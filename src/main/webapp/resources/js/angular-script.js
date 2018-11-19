var crudApp = angular.module('crudApp', []);

crudApp.controller("DbController", ['$scope', '$http', function ($scope, $http) {
        getInfo();

        function getInfo() {
            $http.post('/ANGULAR/employee_details').success(function (data) {
                $scope.details = data;
            });
        }

        $scope.Employee = {'empGender': 'male'};
        $scope.show_form = true;

        $scope.formToggle = function () {
            $('#empForm').slideToggle();
            $('#editForm').css('display', 'none');
        }
        
        $scope.insertInfo = function (info) {
            $http.post('/ANGULAR/employee_save', info).success(function (data) {
                if (data == true) {
                    getInfo();
                    $('#empForm').css('display', 'none');
                }
            });
        }
        
        $scope.deleteInfo = function (info) {
            $http.post('/ANGULAR/employee_delete',info).success(function (data) {
                if (data == true) {
                    getInfo();
                }
            });
        }
         
        $scope.editInfo = function (info) {
            $scope.Employee = info;
            $('#empForm').slideUp();
            $('#editForm').slideToggle();
        }
        
        $scope.UpdateInfo = function (info) {
            $http.post('/ANGULAR/employee_update',info).success(function (data) {
                $scope.show_form = true;
                if (data == true) {
                    getInfo();
                }
            });
        }
        $scope.updateMsg = function (emp_id) {
            $('#editForm').css('display', 'none');
        }
    }]);