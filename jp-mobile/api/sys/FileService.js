import {request, upload} from "../../common/request"

export default class FileService {
  uploadFile (uploadPath) {
	  return upload('/sys/file/webupload/upload?uploadPath=/app/formbuilder',uploadPath)
  }

  getUrl (params) {
    return request({
      url: `/sys/file/getUrl`,
      method: 'get',
      params: params
    })
  }
}
