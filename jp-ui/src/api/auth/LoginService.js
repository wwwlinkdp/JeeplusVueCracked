import request from '@/utils/httpRequest'

export default class LoginService {
  getCode () {
    return request({
      url: '/sys/getCode',
      method: 'get'
    })
  }
  login (data) {
    return request({
      url: '/sys/login',
      method: 'post',
      data: data
    })
  }
  logout () {
    return request({
      url: '/sys/logout',
      method: 'get'
    })
  }
}
