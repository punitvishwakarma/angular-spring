<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html ng-app="crudApp">
    <head>
        <title>AngularJS CRUD Operations Demo</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- Include Bootstrap CSS -->
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
        <!-- Include main CSS -->
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">
        <!-- Include jQuery library -->
        <script src="${pageContext.request.contextPath}/resources/js/jQuery/jquery.min.js"></script>
        <!-- Include AngularJS library -->
        <script src="${pageContext.request.contextPath}/resources/js/lib/angular/angular.min.js"></script>
        <!-- Include Bootstrap Javascript -->
        <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
    </head>
    <body>
        <div class="container wrapper" ng-controller="DbController">
            <h1 class="text-center">AngularJS CRUD Operations Demo</h1>
            <nav class="navbar navbar-default">
                <div class="navbar-header">
                    <div class="alert alert-default navbar-brand search-box">
                        <button class="btn btn-primary" ng-show="show_form" ng-click="formToggle()">Add Employee <span class="glyphicon glyphicon-plus" aria-hidden="true"></span></button>
                    </div>
                    <div class="alert alert-default input-group search-box">
                        <span class="input-group-btn">
                            <input type="text" class="form-control" placeholder="Search Employee Details Into Database..." ng-model="search_query">
                        </span>
                    </div>
                </div>
            </nav>
            <div class="col-md-6 col-md-offset-3">

                <!-- Include form template which is used to insert data into database -->
                <div ng-include src="'${pageContext.request.contextPath}/templates/form.html'"></div>

                <!-- Include form template which is used to edit and update data into database -->
                <div ng-include src="'${pageContext.request.contextPath}/templates/editForm.html'"></div>
            </div>
            <div class="clearfix"></div>

            <!-- Table to show employee detalis -->
            <div class="table-responsive">
                <table class="table table-hover">
                    <tr>
                        <th>Emp ID</th>
                        <th>Employee Name</th>
                        <th>Email Address</th>
                        <th>Gender</th>
                        <th>Address</th>
                        <th></th>
                        <th></th>
                    </tr>
                    <tr ng-repeat="detail in details | filter:search_query">
                        <td>
                            <span>{{detail.empId}}</span></td>
                        <td>{{detail.empName}}</td>
                        <td>{{detail.empEmail}}</td>
                        <td>{{detail.empGender}}</td>
                        <td>{{detail.empAddress}}</td>
                        <td>
                            <button class="btn btn-warning" ng-click="editInfo(detail)" title="Edit"><span>Edit</span></button>
                        </td>
                        <td>
                            <button class="btn btn-danger" ng-click="deleteInfo(detail)" title="Delete"><span>Delete</span></button>
                        </td>
                    </tr>
                </table>
            </div>
        </div>
            
            
    </div>
    <!-- Include controller -->
    <script src="${pageContext.request.contextPath}/resources/js/angular-script.js"></script>
</body>
</html>