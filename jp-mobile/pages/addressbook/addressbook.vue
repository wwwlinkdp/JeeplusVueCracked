<template>
	<view>
		<cu-custom bgColor="bg-blue">
			<block slot="content">通讯录</block>
		</cu-custom>
		<view class="cu-bar bg-white search fixed" :style="[{top:CustomBar + 'px'}]">
			<view class="search-form round">
				<text class="cuIcon-search"></text>
				<input type="text" v-model="searchUserName" placeholder="输入搜索的关键词" confirm-type="search"></input>
			</view>
			<view class="action">
				<button class="cu-btn bg-blue shadow-blur round">搜索</button>
			</view>
		</view>
		<scroll-view scroll-y class="indexes x-page" :scroll-into-view="'indexes-'+ listCurID" :style="[{height:'calc(100vh - '+ CustomBar + 'px - 50px)'}]"
		 :scroll-with-animation="true" :enable-back-to-top="true">
			<block v-for="(item,index) in list" :key="index">
				<view :class="'indexItem-' + item.letter" :id="'indexes-' + item.letter" :data-index="item.letter">
					<view class="padding">{{item.letter}}</view>
					<view class="cu-list menu-avatar no-padding">
						<view class="cu-item" v-for="(user,sub) in item.data" :key="sub">
							<!-- <view class="cu-avatar round lg">{{user.name}}</view> -->
							<view class="cu-avatar lg round " :style="'background-image:url('+(user.photo?user.photo:'/static/user/flat-avatar.png')+');'"></view>
							<view class="content">
								<view class="text-grey"><text class="text-abc">{{user.name}}</text></view>
								<view class="text-gray text-sm">
								{{user.companyDTO && user.companyDTO.name}} {{user.officeDTO && user.officeDTO.name}}
								</view>
							</view>
						</view>
					</view>
				</view>
			</block>
		</scroll-view>
		<view class="indexBar" :style="[{height:'calc(100vh - ' + CustomBar + 'px - 50px)'}]">
			<view class="indexBar-box" @touchstart="tStart" @touchend="tEnd" @touchmove.stop="tMove">
				<view class="indexBar-item" v-for="(item,index) in list" :key="index" :id="index" @touchstart="getCur" @touchend="setCur"> {{item.letter}}</view>
			</view>
		</view>
		<!--选择显示-->
		<view v-show="!hidden" class="indexToast">
			{{listCur}}
		</view>
		<view class="cu-tabbar-height"></view>
	</view>
</template>

<script>
	import UserService from '@/api/sys/UserService'
	export default {
		data() {
			return {
				StatusBar: this.StatusBar,
				CustomBar: this.CustomBar,
				searchUserName: '',
				hidden: true,
				listCurID: '',
				userList: [],
				listCur: '',
			};
		},
		created() {
			new UserService().list({current: 1, size: -1}).then(({data})=>{
				this.userList = data.records
			}).catch((e)=>{
				throw e
			})
		},
		mounted() {
			let that = this;
			uni.createSelectorQuery().select('.indexBar-box').boundingClientRect(function(res) {
				that.boxTop = res.top
			}).exec();
		},
		computed: {
			list () {
				let resultList = this.userList.filter((item)=>{
					if(item.name.indexOf(this.searchUserName) >= 0){
						return true
					}
				})
				return this.pySegSort(resultList)
			}
		},
		methods: {
			//获取文字信息
			getCur(e) {
				this.hidden = false;
				this.listCur = this.list[e.target.id].letter;
			},
			// 排序
			pySegSort(arr) {
			    if(!String.prototype.localeCompare)
			        return null;
			     
			    var letters = "0abcdefghjklmnopqrstwxyz".split('');
			    var zh = "阿八嚓哒妸发旮哈讥咔垃痳拏噢妑七呥扨它穵夕丫帀".split('');
			     
			    var segs = [];
			    var curr;
			    letters.forEach(function(item,i){
			        curr = {letter: item, data:[]};
			        arr.forEach(function(item2){
			            if((!zh[i-1] || zh[i-1].localeCompare(item2.name) <= 0) && item2.name.localeCompare(zh[i]) == -1) {
			                curr.data.push(item2);
			            }
			        });
			        if(curr.data.length) {
			            segs.push(curr);
			            curr.data.sort(function(a,b){
			                return a.name.localeCompare(b.name);
			            });
			        }
			    });
			    return segs;
			},
			setCur(e) {
				this.hidden = true;
				this.listCur = this.listCur
			},
			//滑动选择Item
			tMove(e) {
				let y = e.touches[0].clientY,
					offsettop = this.boxTop,
					that = this;
				//判断选择区域,只有在选择区才会生效
				if (y > offsettop) {
					let num = parseInt((y - offsettop) / 20);
					this.listCur = that.list[num].letter
				};
			},

			//触发全部开始选择
			tStart() {
				this.hidden = false
			},

			//触发结束选择
			tEnd() {
				this.hidden = true;
				this.listCurID = this.listCur
			},
			indexSelect(e) {
				let that = this;
				let barHeight = this.barHeight;
				let list = this.list;
				let scrollY = Math.ceil(list.length * e.detail.y / barHeight);
				for (let i = 0; i < list.length; i++) {
					if (scrollY < i + 1) {
						that.listCur = list[i].letter;
						that.movableY = i * 20
						return false
					}
				}
			}
		}
	}
</script>

<style>
	.x-page {
		padding-top: 100upx;
	}

	.indexes {
		position: relative;
	}

	.indexBar {
		position: fixed;
		right: 0px;
		bottom: 0px;
		padding: 20upx 20upx 20upx 60upx;
		display: flex;
		align-items: center;
	}

	.indexBar .indexBar-box {
		width: 40upx;
		height: auto;
		background: #fff;
		display: flex;
		flex-direction: column;
		box-shadow: 0 0 20upx rgba(0, 0, 0, 0.1);
		border-radius: 10upx;
	}

	.indexBar-item {
		flex: 1;
		width: 40upx;
		height: 40upx;
		display: flex;
		align-items: center;
		justify-content: center;
		font-size: 24upx;
		color: #888;
	}

	movable-view.indexBar-item {
		width: 40upx;
		height: 40upx;
		z-index: 9;
		position: relative;
	}

	movable-view.indexBar-item::before {
		content: "";
		display: block;
		position: absolute;
		left: 0;
		top: 10upx;
		height: 20upx;
		width: 4upx;
		background-color: #f37b1d;
	}

	.indexToast {
		position: fixed;
		top: 0;
		right: 80upx;
		bottom: 0;
		background: rgba(0, 0, 0, 0.5);
		width: 100upx;
		height: 100upx;
		border-radius: 10upx;
		margin: auto;
		color: #fff;
		line-height: 100upx;
		text-align: center;
		font-size: 48upx;
	}
</style>
