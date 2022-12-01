<template>
	<view>
		<cu-custom bgColor="bg-blue" backUrl="/pages/test/mobile/TestMobileList" :isBack="true">
			<block slot="backText">返回</block>
			<block slot="content">{{title}}</block>
		</cu-custom>
		<form @submit="formSubmit" class="cu-list menu">
       <view class="cu-form-group margin-top">
		   <view class="title">
			 <text class="red-color ">* </text> 姓名  
		   </view>
		   <input placeholder='请填写姓名'  v-model="inputForm.name"></input>
		</view>
       <view class="cu-form-group ">
		   <view class="title">
			 <text class="red-color ">* </text> 年龄  
		   </view>
		   <input placeholder='请填写年龄'  v-model="inputForm.age"></input>
		</view>
       <view class="cu-form-group ">
		   <view class="title">
			 <text class="red-color ">* </text> 地区  
		   </view>
		<jp-area-select v-model="inputForm.area.id"></jp-area-select>
		</view>
       <view class="cu-form-group ">
		   <view class="title">
			 <text class="red-color ">* </text> 公司  
		   </view>
		<jp-office-select v-model="inputForm.company.id"></jp-office-select>
		</view>
       <view class="cu-form-group ">
		   <view class="title">
			 <text class="red-color ">* </text> 部门  
		   </view>
		<jp-office-select v-model="inputForm.office.id"></jp-office-select>
		</view>
       <view class="cu-form-group ">
		   <view class="title">
			 <text class="red-color ">* </text> 性别  
		   </view>
		  <jp-picker v-model="inputForm.sex" rangeKey="label" rangeValue="value" :range="$dictUtils.getDictList('sex')">
		  	<view class="picker">
		  		{{$dictUtils.getDictLabel('sex', inputForm.sex ,'请选择')}}
		  	</view>
		  </jp-picker>
		</view>
       <view class="cu-form-group ">
		   <view class="title">
			 <text class="red-color ">* </text> 头像  
		   </view>
		<jp-image-upload2 v-model="inputForm.teImage"></jp-image-upload2>
		</view>
       <view class="cu-form-group ">
		   <view class="title">
			 <text class="red-color ">* </text> 单选框  
		   </view>
		 <jp-radio-group  v-model="inputForm.isSingle">
			<label v-for="(option, index) in $dictUtils.getDictList('yes_no')">
				<view>
					{{option.label}}
					<radio class='blue radio'  :value="option.value"  :class="inputForm.isSingle==option.value?'checked':''" :checked="inputForm.isSingle==option.value?true:false" ></radio>
				</view>
			</label>
		 </jp-radio-group>
		</view>
       <view class="cu-form-group ">
		   <view class="title">
			 <text class="red-color ">* </text> 多选框  
		   </view>
		  <jp-checkbox-group2 v-model="inputForm.cks">
		  	<label v-for="(option, index) in $dictUtils.getDictList('form_style')">
		  		<view>
		  			{{option.label || option.value}}
		  			<checkbox  class="blue" :value="option.value"  :class="(','+inputForm.cks+',').indexOf(','+option.value+',')>=0?'checked':''" :checked="(','+inputForm.cks+',').indexOf(','+option.value+',')>=0" ></checkbox>
		  		</view>
		  	</label>
		  </jp-checkbox-group2>	
		</view>
       <view class="cu-form-group ">
		   <view class="title">
			 <text class="red-color ">* </text> 多行文本框  
		   </view>
           <textarea placeholder='请填写多行文本框'  v-model="inputForm.textArea"></textarea>
		</view>
       <view class="cu-form-group ">
		   <view class="title">
			 <text class="red-color ">* </text> 数字输入框  
		   </view>
		   <input placeholder='请填写数字输入框'  type="number"  v-model="inputForm.textNumber"></input>
		</view>
       <view class="cu-form-group ">
		   <view class="title">
			 <text class="red-color ">* </text> 日期选择框  
		   </view>
		<jp-datetime-picker v-model="inputForm.teDate" placeholder="选择日期时间"  mode="date"></jp-datetime-picker>
		</view>
       <view class="cu-form-group ">
		   <view class="title">
			 邮箱  
		   </view>
		   <input placeholder='请填写邮箱'  v-model="inputForm.email"></input>
		</view>
       <view class="cu-form-group ">
		   <view class="title">
			 手机号  
		   </view>
		   <input placeholder='请填写手机号'  v-model="inputForm.phone"></input>
		</view>
       <view class="cu-form-group ">
		   <view class="title">
			 电话  
		   </view>
		   <input placeholder='请填写电话'  v-model="inputForm.tel"></input>
		</view>
	  
			<view class="padding-xl">
				<button form-type="submit" class="cu-btn block bg-blue margin-tb-sm lg" >提交</button>
			</view>
		</form>
	</view>
</template>

<script>
  var  graceChecker = require("@/common/graceChecker.js");
  import TestMobileService from '@/api/test/mobile/TestMobileService'
  export default {
    onShow() {
      this.$auth.checkLogin()
    },
    data () {
      return {
        title: '新建测试移动表单',
        inputForm: {
          id: '',
          name: '',
          age: '',
          area: {
            id: ''
          },
          company: {
            id: ''
          },
          office: {
            id: ''
          },
          sex: '',
          teImage: '',
          isSingle: '',
          cks: '',
          textArea: '',
          textNumber: '',
          teDate: '',
          email: '',
          phone: '',
          tel: ''
        }
      }
    },
    testMobileService: null,
    beforeCreate () {
      this.testMobileService = new TestMobileService()
    },
	async onLoad(query) {
		if(query&&query.id){
			this.titile = "修改测试移动表单";
			let {data} = await this.testMobileService.queryById(query.id)
			this.inputForm = this.recover(this.inputForm, data)
		}
	},
    methods: {
      formSubmit: function(e) {
      	//定义表单规则
      	var rule = [
			      {name:"name", checkType : "notnull", checkRule:"",  errorMsg:"姓名不能为空"},
			      {name:"age", checkType : "notnull", checkRule:"",  errorMsg:"年龄不能为空"},
			      {name:"area.id", checkType : "notnull", checkRule:"",  errorMsg:"地区不能为空"},
			      {name:"company.id", checkType : "notnull", checkRule:"",  errorMsg:"公司不能为空"},
			      {name:"office.id", checkType : "notnull", checkRule:"",  errorMsg:"部门不能为空"},
			      {name:"sex", checkType : "notnull", checkRule:"",  errorMsg:"性别不能为空"},
			      {name:"teImage", checkType : "notnull", checkRule:"",  errorMsg:"头像不能为空"},
			      {name:"isSingle", checkType : "notnull", checkRule:"",  errorMsg:"单选框不能为空"},
			      {name:"cks", checkType : "notnull", checkRule:"",  errorMsg:"多选框不能为空"},
			      {name:"textArea", checkType : "notnull", checkRule:"",  errorMsg:"多行文本框不能为空"},
			      {name:"textNumber", checkType : "notnull", checkRule:"",  errorMsg:"数字输入框不能为空"},
			      {name:"teDate", checkType : "notnull", checkRule:"",  errorMsg:"日期选择框不能为空"},
			      {name:"email", checkType : "isEmail", checkRule:"",  errorMsg:""},
			      {name:"phone", checkType : "isMobile", checkRule:"",  errorMsg:""},
			      {name:"tel", checkType : "isPhone", checkRule:"",  errorMsg:""}
      	];
      	//进行表单检查
      	var formData = this.inputForm;
      	var checkRes = graceChecker.check(formData, rule);
      	if(checkRes){
      		uni.showLoading()
      		this.testMobileService.save(this.inputForm).then(({data}) => {
      			uni.showToast({title:data, icon:"success"});
      			uni.navigateTo({
      			  url: '/pages/test/mobile/TestMobileList'
      			})
      		}).catch((e)=>{
      			
      		})
      		
      	}else{
      		uni.showToast({ title: graceChecker.error, icon: "none" });
      	}
      }
    }
  }
</script>

  
