import request from '@/utils/request'

// 查询补贴申请列表
export function listApplication(query) {
  return request({
    url: '/subsidy/application/list',
    method: 'get',
    params: query
  })
}

// 查询补贴申请详细
export function getApplication(applicationId) {
  return request({
    url: '/subsidy/application/' + applicationId,
    method: 'get'
  })
}

// 新增补贴申请
export function addApplication(data) {
  return request({
    url: '/subsidy/application',
    method: 'post',
    data: data
  })
}

// 修改补贴申请
export function updateApplication(data) {
  return request({
    url: '/subsidy/application',
    method: 'put',
    data: data
  })
}

// 删除补贴申请
export function delApplication(applicationId) {
  return request({
    url: '/subsidy/application/' + applicationId,
    method: 'delete'
  })
}
