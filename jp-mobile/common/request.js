import * as $auth from "./auth"
import BASE_URL from './config.js'
import qs from 'qs'

function error(res){
	if (res.statusCode === 408 || res.statusCode === 401) {// 需要重新登录
		$auth.removeUserToken();
		uni.showToast({
			title: res.data,
			icon:"none"
		})
	}else if(res.statusCode === 404){
		uni.showToast({
			title:"404，路径找不到："+res.data.path,
			icon:"none"
		})
	}else if(res.statusCode === 503){
		uni.showToast({
			title:"服务不可用",
			icon:"none"
		})
	}else if(res.statusCode === 504){
		uni.showToast({
			title:"网络连接错误",
			icon:"none"
		})
	}else{
		uni.showToast({
			title:res.data,
			icon:"none"
		})
	}
}
export function request(body){
	let {url,method,data,header, params, responseType} = body
	data = data || params || {};
	header = header || {'Content-Type': 'application/json; charset=utf-8'}
	method = method.toUpperCase() || "GET";
	responseType = responseType || "text"
	let token = $auth.getUserToken();
	if(token){
		header.token = token;			// 获取token值
	}
	if(method === 'POST' && header['Content-Type'] === 'application/x-www-form-urlencoded; charset=utf-8'){
		data = qs.stringify(data,  { allowDots: true, arrayFormat: 'indices' })
	}else if(method === 'GET' || method === 'DELETE' || method === 'PUT'){
		url = url + '?' +  qs.stringify(data, { allowDots: true, arrayFormat: 'indices' }) 
		data = null

	}
	
	let promise = new Promise((resolve,reject)=>{
		uni.request({
			url: BASE_URL + url,
			header:header,
			data: data,
			method: method,
			responseType: responseType,
			success: res => {
				if(res && res.statusCode !== 200){
					error(res);
					reject(res)
				}
				resolve(res);
			},
			fail: (res) => {
				uni.hideLoading();
				error(res);
				reject(res);
			},
			complete: () => {	
			}
		});
	})
	return promise;
}

// 单文件上传
export function upload(url, filePath,filename, formData,header,success,fail){
	let name = filename || 'file';
	header = header || {};
	let token = $auth.getUserToken();
	if(token){
		header.token = token;			// 获取token值
	}
	
	let promise = new Promise((resolve,reject)=>{
		uni.uploadFile({
			url: BASE_URL + url,
			filePath:filePath,
			name: 'file', 
			formData: formData || {},
			header:header,
			success: res => {
				resolve(res.data);
			},
			fail: (res) => {
				uni.hideLoading();
				let err = JSON.parse(res);
				error(err);
				reject(err);
			},
			complete: () => {	
			}
		});
	})
	return promise;
}

export function download(url,header,success,fail){
	header = header || {};
	let token = $auth.getUserToken();
	if(token){
		header.token = token;			// 获取token值
	}
	if(!url){
		return;
	}
	let downloadTask = uni.downloadFile({
		url: url,
		success: (res) => {
			if(res.statusCode===200){
				if(success){
					success.call(null,res);
				}
			}else{
				if(fail){
					fail.call(null,res);
				}
			}
		},
		fail:(res) => {
			let err = JSON.parse(res);
			error(err);
			if(fail){
				fail.call(null,err)
			}
		},
		complete: () => {
			
		}
	});
	return downloadTask;
}

export default request