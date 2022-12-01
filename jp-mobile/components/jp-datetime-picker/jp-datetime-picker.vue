<template>
		<picker :mode="mode" :value="value" :disabled="disabled" :start="start" :end="end" @change="TimeChange">
			<view class=" picker action">
				<view class="text-grey ">{{label || '请选择'}}</view>
			</view>
		</picker>
</template>

<script>
	import moment from 'moment'
	export default {
		data () {
			return {
				label: ''
			}
		},
		props: {
		    value: {
				type: String,
				default: '2020-09-12'
			},
			start: String,
			end: String,
			mode: String,
			disabled: {
				type: Boolean,
				default: false
			}
		},
		watch:{
			value:{
				handler (val) {
					this.label = val
				},
				immediate: true,
				deep: false
			}
		},
		methods:{
			TimeChange(e) {
				if(this.mode === 'date'){
					this.label = moment(e.detail.value).format('YYYY-MM-DD HH:mm:ss')
				}
				this.$emit('input', this.label)
			}
		}
	}
</script>

