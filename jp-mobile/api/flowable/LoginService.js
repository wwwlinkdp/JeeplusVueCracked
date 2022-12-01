import request from "../../common/request"

export default class LoginService {
  getCode () {
    return request({
      url: '/app/sys/getCode',
      method: 'get',
      responseType: "arraybuffer"
    })
  }
  login (username, password, code) {
    return request({
      url: '/app/sys/login',
      method: 'post',
      data: {
        'username': username,
        'password': password,
        'code': code
      }
    })
  }
  logout () {
    return request({
      url: '/app/sys/logout',
      method: 'get'
    })
  }
}
