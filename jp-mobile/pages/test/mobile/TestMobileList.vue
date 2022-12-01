<template>
	<view>
		<cu-custom bgColor="bg-blue" :isBack="true">
			<block slot="backText">返回</block>
			<block slot="content"> 测试移动表单</block>
		</cu-custom>
		<view>
			<view class="uni-container">
				<uni-table ref="table" :loading="loading" border stripe type="selection" emptyText="暂无更多数据" @selection-change="selectionChange">
					<uni-tr>
						<uni-th  filter-type="search" @filter-change="searchChangeHandle"   field="name" @sort-change="sortChangeHandle" sortable align="center">姓名</uni-th>
						<uni-th  filter-type="search" @filter-change="searchChangeHandle"   field="age" @sort-change="sortChangeHandle" sortable align="center">年龄</uni-th>
						<uni-th  filter-type="search" @filter-change="searchChangeHandle"   field="area.name"  @sort-change="sortChangeHandle" sortable align="center">地区</uni-th>
						<uni-th  filter-type="search" @filter-change="searchChangeHandle"   field="company.name"  @sort-change="sortChangeHandle" sortable align="center">公司</uni-th>
						<uni-th  filter-type="search" @filter-change="searchChangeHandle"   field="office.name"  @sort-change="sortChangeHandle" sortable align="center">部门</uni-th>
						<uni-th  filter-type="search" @filter-change="searchChangeHandle"   field="sex" @sort-change="sortChangeHandle" sortable align="center">性别</uni-th>
						<uni-th  filter-type="search" @filter-change="searchChangeHandle"   field="teImage" @sort-change="sortChangeHandle" sortable align="center">头像</uni-th>
						<uni-th  filter-type="search" @filter-change="searchChangeHandle"   field="isSingle" @sort-change="sortChangeHandle" sortable align="center">单选框</uni-th>
						<uni-th  filter-type="search" @filter-change="searchChangeHandle"   field="cks" @sort-change="sortChangeHandle" sortable align="center">多选框</uni-th>
						<uni-th  filter-type="search" @filter-change="searchChangeHandle"   field="textArea" @sort-change="sortChangeHandle" sortable align="center">多行文本框</uni-th>
						<uni-th  filter-type="search" @filter-change="searchChangeHandle"   field="textNumber" @sort-change="sortChangeHandle" sortable align="center">数字输入框</uni-th>
						<uni-th  filter-type="search" @filter-change="searchChangeHandle"   field="teDate" @sort-change="sortChangeHandle" sortable align="center">日期选择框</uni-th>
						<uni-th  filter-type="search" @filter-change="searchChangeHandle"   field="email" @sort-change="sortChangeHandle" sortable align="center">邮箱</uni-th>
						<uni-th  filter-type="search" @filter-change="searchChangeHandle"   field="phone" @sort-change="sortChangeHandle" sortable align="center">手机号</uni-th>
						<uni-th  filter-type="search" @filter-change="searchChangeHandle"   field="tel" @sort-change="sortChangeHandle" sortable align="center">电话</uni-th>
						<uni-th>操作</uni-th>
					</uni-tr>
					<uni-tr v-for="(row, index) in dataList" :key="index">
						<uni-td>{{row.name}}</uni-td>
						<uni-td>{{row.age}}</uni-td>
						<uni-td>{{ row.area && row.area.name }}</uni-td>
						<uni-td>{{ row.company && row.company.name }}</uni-td>
						<uni-td>{{ row.office && row.office.name }}</uni-td>
						<uni-td>{{ $dictUtils.getDictLabel("sex", row.sex, '-') }}</uni-td>	
                        <uni-td><image  :src="row.teImage"></image></uni-td>
						<uni-td>{{ $dictUtils.getDictLabel("yes_no", row.isSingle, '-') }}</uni-td>
						<uni-td>{{row.cks.split(",").map( (item)=> { return $dictUtils.getDictLabel("form_style", item, '-')}).join(",")  }}</uni-td>	
						<uni-td>{{row.textArea}}</uni-td>
						<uni-td>{{row.textNumber}}</uni-td>
						<uni-td>{{row.teDate}}</uni-td>
						<uni-td>{{row.email}}</uni-td>
						<uni-td>{{row.phone}}</uni-td>
						<uni-td>{{row.tel}}</uni-td>
						<uni-td>
							<view class="uni-group">
								<button class="uni-button" size="mini"  @click="edit(row.id)" type="primary">修改</button>
								<button class="uni-button" size="mini"  @click="del(row.id)" type="warn">删除</button>
							</view>
						</uni-td>
					</uni-tr>
				</uni-table>
				<view class="uni-pagination-box">
					<uni-pagination show-icon :page-size="tablePage.pageSize" :current="tablePage.currentPage" :total="tablePage.total" @change="currentChangeHandle" />
				</view>
			</view>
		
			<uni-fab
				:pattern=" {
							color: '#7A7E83',
							backgroundColor: '#fff',
							selectedColor: '#007AFF',
							buttonColor: '#007AFF'
						}"
				horizontal="right"
				vertical="bottom"
				@fabClick="add"
			></uni-fab>
		</view>
		</view>
</template>

<script>
  import uniFab from '@/components/uni-fab/uni-fab.vue';
  import TestMobileService from '@/api/test/mobile/TestMobileService'
  export default {
	onShow(option) {
		this.$auth.checkLogin()
	},
	components:{
		uniFab
	},
    data () {
      return {
        searchForm: {},
        dataList: [], // 数据列表
        tablePage: {
          total: 0,
          currentPage: 1,
          pageSize: 10,
          orders: []
        },
        loading: false
      }
    },
    testMobileService: null,
	onLoad() {
	  this.testMobileService = new TestMobileService()
	  this.refreshList()
	},
    methods: {
	  // 新增
	  add (){
	  	uni.navigateTo({
	  	  url: '/pages/test/mobile/TestMobileForm'
	  	})
	  },
	  // 修改
	  edit (id) {
	  	uni.navigateTo({
	  	  url: '/pages/test/mobile/TestMobileForm?id='+id
	  	})
	  },
      // 删除
	  del (id) {
	  	uni.showModal({
	  		title: '提示',
	  		content: '您确认要删除数据吗',
	  		showCancel: true,
	  		success: (res) => {
	  			if (res.confirm) {
	  				this.testMobileService.delete(id).then(({data})=>{
	  					uni.showToast({
	  						title: data,
	  						icon:"success"
	  					})
	  					this.refreshList()
	  				})
	  			}
	  		}
	  	});
	  },
	  /*获取数据列表 */
	  refreshList() {
	    this.loading = true
	    this.testMobileService.list({
	  	  'current': this.tablePage.currentPage,
	  	  'size': this.tablePage.pageSize,
	  	  'orders': this.tablePage.orders,
	  	  ...this.searchForm
	  	}).then(({data}) => {
	  	  this.dataList = data.records
	  	  this.tablePage.total = data.total
	  	  this.loading = false
	  	})
	  	
	  },
	  // 排序
	  sortChangeHandle (column) {
	  	this.tablePage.orders = []
	  	if (column.order != null) {
	  	  this.tablePage.orders.push({column: this.$utils.toLine(column.property), asc: column.order === 'ascending'})
	  	}
	  	this.refreshList()
	  },
	// 检索
	  searchChangeHandle (column) {
		this.searchForm[column.property] = column.filter
		this.refreshList()
	  },
	// 分页触发
	  currentChangeHandle (e) {
		this.tablePage.currentPage = e.current
		this.refreshList()
	  }
    }
  }
</script>

