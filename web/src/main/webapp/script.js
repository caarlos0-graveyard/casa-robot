var robotApp = angular.module('app', [])
var DEFAULT_POSITION = "0,0,N"
var SERVICE_URL = '/rest/mars/'

robotApp.filter('reverse', function() {
  return function(items) {
    return items.slice().reverse()
  }
})

robotApp.controller('mainController', function($scope, $http) {
  $scope.position = DEFAULT_POSITION
  $scope.msg = ''
  $scope.array = Array.apply(null, {length: 5}).map(Number.call, Number)

  $scope.isPosition = function (col, row) {
    var coords = $scope.position.split(',')
    return coords[0] == col && coords[1] == row
  }

  $scope.isPointingTo = function (direction) {
    return $scope.position.split(',')[2] === direction
  }

  $scope.move = function() {
    var command = $scope.command
    if (command) {
      command = command.toUpperCase()
      $http({
        method: 'POST',
        url: SERVICE_URL + command
      }).success(function (data, status, headers, config) {
        $scope.position = data.split('').join(',')
        $scope.msg = ''
      }).error(function (data, status, headers, config) {
        $scope.position = DEFAULT_POSITION
        $scope.msg = data
      })
    } else {
      $scope.position = DEFAULT_POSITION
    }
  }
})
