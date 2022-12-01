<template>
	<view>
		<cu-custom bgColor="bg-blue" backUrl="/pages/apps/mail/inbox" :isBack="true">
			<block slot="backText">返回</block>
			<block slot="content"> {{mailBox.mailDTO.title}}</block>
		</cu-custom>
		<view class="cu-bar bg-white solid-bottom">
			<view class="mail grid col-1  margin-top-sm action " >
				<view class=" text-gray text-sm">
					<text class="title padding-right-xs" >发件人：</text>{{mailBox.sender.name}}
				</view>
				<view class=" text-gray text-sm">
					<text class="title  padding-right-xs" >收件人：</text>{{mailBox.receiverNames}}
				</view>
				<view class=" text-gray text-sm">
					<text class="title  padding-right-xs" >时间：</text>{{mailBox.sendTime}}
				</view>			
			</view>
		</view>

		<view class="padding bg-white">
			<view class="text-left padding">
				<view v-html="mailBox.mailDTO.content"></view>
			</view>
		</view>
	</view>
</template>

<script>
	import MailBoxService from "@/api/mail/MailBoxService";	
	export default {
		data() {
			return {
				mailBox: {
					mailDTO: {
						title: ''
					},
					sender: {
						name: ''
					}
				}
			}
		},
		onLoad: function (option) {
			new MailBoxService().queryById(option.id).then(({data})=>{
				this.mailBox = data
			});
		},
		methods: {
			
		}
	}
</script>

<style>
  .mail .title {
  	min-width: calc(4em + 0px);
	text-align: right; 
	display: inline-block
  }
</style>
