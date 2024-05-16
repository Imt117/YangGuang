import request from '@/utils/request'

// 查询补贴公示列表
export function listPublicity(query) {
  return request({
    url: '/subsidy/publicity/list',
    method: 'get',
    params: query
  })
}

// 查询补贴公示详细
export function getPublicity(publicityId) {
  return request({
    url: '/subsidy/publicity/' + publicityId,
    method: 'get'
  })
}

// 新增补贴公示
export function addPublicity(data) {
  return request({
    url: '/subsidy/publicity',
    method: 'post',
    data: data
  })
}

// 修改补贴公示
export function updatePublicity(data) {
  return request({
    url: '/subsidy/publicity',
    method: 'put',
    data: data
  })
}

// 删除补贴公示
export function delPublicity(publicityId) {
  return request({
    url: '/subsidy/publicity/' + publicityId,
    method: 'delete'
  })
}
