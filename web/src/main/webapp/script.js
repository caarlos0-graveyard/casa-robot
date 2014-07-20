var robotApp = angular.module('app', [])
var DEFAULT_POSITION = "0,0,N"
var SERVICE_URL = '/rest/mars/'

robotApp.filter('reverse', function() {
  return function(items) {
    return items.slice().reverse()
  }
})

robotApp.service('Robot', function ($http) {
  this.move = function (command) {
    command = command.toUpperCase()
    return $http({
      method: 'POST',
      url: SERVICE_URL + command
    })
  }
})

robotApp.controller('mainController', function($scope, $http, Robot) {
  var processCommand, defaultState, init;

  defaultState = function () {
    $scope.position = DEFAULT_POSITION
    $scope.msg = ''
  }
  processCommand = function (command) {
    defaultState()
    Robot.move(command).success(function (data, status, headers, config) {
      $scope.position = data.split('').join(',')
    }).error(function (data, status, headers, config) {
      $scope.msg = data
    })
  }
  init = function () {
    $scope.array = Array.apply(null, {length: 5}).map(Number.call, Number)
    defaultState()
  }

  $scope.isPosition = function (col, row) {
    var coords = $scope.position.split(',')
    return coords[0] == col && coords[1] == row
  }

  $scope.isPointingTo = function (direction) {
    return $scope.position.split(',')[2] === direction
  }

  $scope.move = function() {
    var command = $scope.command
    if (!command)
      return;
    processCommand(command)
  }

  init()
})
