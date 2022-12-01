import request from '@/utils/httpRequest'

export default class MyCalendarService {
  save (inputForm) {
    return request({
      url: `/myCalendar/save`,
      method: 'post',
      data: inputForm
    })
  }

  delete (id) {
    return request({
      url: '/myCalendar/del',
      method: 'delete',
      params: {id: id}
    })
  }

  queryById (id) {
    return request({
      url: `/myCalendar/queryById`,
      method: 'get',
      params: {id: id}
    })
  }

  drag (params) {
    return request({
      url: `/myCalendar/drag`,
      method: 'put',
      params: params
    })
  }

  resize (params) {
    return request({
      url: '/myCalendar/resize',
      method: 'put',
      params: params
    })
  }

  list () {
    return request({
      url: '/myCalendar/findList',
      method: 'get'
    })
  }
}
