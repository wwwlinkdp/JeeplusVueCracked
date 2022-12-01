<template>
	<view>
		<cu-custom bgColor="bg-blue" :isBack="true">
			<block slot="backText">返回</block>
			<block slot="content"> {{mailCompose.mailDTO.title}}</block>
		</cu-custom>
		<view class="cu-bar bg-white solid-bottom">
			<view class="mail grid col-1  margin-top-sm action " >
				<view class=" text-gray text-sm">
					<text class="title padding-right-xs" >发件人：</text> 自己
				</view>
				<view class=" text-gray text-sm">
					<text class="title  padding-right-xs" >收件人：</text>{{mailCompose.receiverNames}}
				</view>
				<view class=" text-gray text-sm">
					<text class="title  padding-right-xs" >时间：</text>{{mailCompose.sendTime}}
				</view>			
			</view>
		</view>

		<view class="padding bg-white">
			<view class="text-left padding">
				<view v-html="mailCompose.mailDTO.content"></view>
			</view>
		</view>
	</view>
</template>

<script>
	import MailComposeService from "@/api/mail/MailComposeService";
	export default {
		data() {
			return {
				mailCompose: {
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
			new MailComposeService().queryById(option.id).then(({data})=>{
				this.mailCompose = data
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
