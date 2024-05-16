import request from '@/utils/request'

// 查询补贴申请状态列表
export function listStatus(query) {
  return request({
    url: '/subsidy/status/list',
    method: 'get',
    params: query
  })
}

// 查询补贴申请状态详细
export function getStatus(statusId) {
  return request({
    url: '/subsidy/status/' + statusId,
    method: 'get'
  })
}

// 新增补贴申请状态
export function addStatus(data) {
  return request({
    url: '/subsidy/status',
    method: 'post',
    data: data
  })
}

// 修改补贴申请状态
export function updateStatus(data) {
  return request({
    url: '/subsidy/status',
    method: 'put',
    data: data
  })
}

// 删除补贴申请状态
export function delStatus(statusId) {
  return request({
    url: '/subsidy/status/' + statusId,
    method: 'delete'
  })
}
