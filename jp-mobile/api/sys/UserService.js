import {request, upload} from "../../common/request"

export default class UserService {

  saveInfo (inputForm) {
    return request({
      url: `/sys/user/saveInfo`,
      method: 'post',
      header: {arrayFormat: 'repeat'},
      data: inputForm
    })
  }

 upload(filePath) {
	return upload('/sys/user/imageUpload',filePath)
 }
	 
  savePwd (inputForm) {
    return request({
      url: `/sys/user/savePwd`,
      method: 'put',
      params: inputForm
    })
  }

  queryById (id) {
    return request({
      url: `/sys/user/queryById`,
      method: 'get',
      params: {id: id}
    })
  }
  
  imageUpload (filePath) {
	return upload('/sys/user/imageUpload',filePath)  
  }
 
  info () {
    return request({
      url: `/sys/user/info`,
      method: 'get'
    })
  }
  
  getMenus () {
    return request({
	  url: `/sys/user/getMenus`,
	  method: 'get'
    })
  }

  list (params) {
    return request({
      url: '/sys/user/list',
      method: 'get',
      params: params
    })
  }
  
  treeData () {
    return request({
      url: '/sys/user/treeData',
      method: 'get'
    })
  }
}
