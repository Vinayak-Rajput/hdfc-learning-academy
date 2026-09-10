# HDFC-Learning-Academy
## Version: v0 (Documentation Generated with Swagger MarkDown)

### Servers

| URL | Description |
| --- | ----------- |
| http://localhost:8080 | Generated server url |

---
## Enrollment APIs
Operations for Enrollment System

### [PUT] /enrollments/{id}/complete
**Complete Course**

Set status for course as 'COMPLETED'.

#### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ------ |
| id | path |  | Yes | integer |

#### Responses

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | Completed Successfully. | **application/json**: [EnrollmentResponseDto](#enrollmentresponsedto-schema)<br> |
| 404 | Enrollment For Update Not Found |  |

### [PUT] /enrollments/{id}/cancel
**Cancel Enrollment**

Set status for enrollment as 'CANCELLED'.

#### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ------ |
| id | path |  | Yes | integer |

#### Responses

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | Cancelled Successfully. | **application/json**: [EnrollmentResponseDto](#enrollmentresponsedto-schema)<br> |
| 404 | Enrollment Not Found |  |

### [GET] /enrollments
**Get All Enrollments**

Get all enrollment resources.

#### Responses

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | Fetched all Enrollments details. | **application/json**: [EnrollmentResponseDto](#enrollmentresponsedto-schema)<br> |

### [POST] /enrollments
**Create Enrollment**

Create a new enrollment resource.

#### Request Body

Payload to create Enrollment resource

| Required | Schema |
| -------- | ------ |
|  Yes | **application/json**: [EnrollmentRequestDto](#enrollmentrequestdto-schema)<br> |

#### Responses

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 201 | Successfully created a new employee resource | **application/json**: [EnrollmentResponseDto](#enrollmentresponsedto-schema)<br> |
| 400 | Course Capacity Full |  |
| 404 | Course Not Found |  |
| 409 | Already Enrolled |  |

### [GET] /enrollments/{id}
**Get Enrollment By ID**

Get an enrollment resource by ID reference.

#### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ------ |
| id | path |  | Yes | integer |

#### Responses

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | Fetched the required Enrollment details. | **application/json**: [EnrollmentResponseDto](#enrollmentresponsedto-schema)<br> |
| 404 | Enrollment Not Found |  |

### [GET] /enrollments/status/{status}
**Get Enrollments By Status**

Get all enrollment resources for status.

#### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ------ |
| status | path |  | Yes | string |

#### Responses

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | Fetched the required Enrollments. | **application/json**: [EnrollmentResponseDto](#enrollmentresponsedto-schema)<br> |

### [GET] /enrollments/employee/{employeeId}
**Get Enrollments By Employee ID**

Get all enrollment resources for employee ID.

#### Responses

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | Fetched the required Enrollments. | **application/json**: [EnrollmentResponseDto](#enrollmentresponsedto-schema)<br> |

---
## Courses APIs
Operations for Course Management System

### [GET] /courses/{id}
**Get Course By ID**

Get an course resource by ID reference.

#### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ------ |
| id | path |  | Yes | integer |

#### Responses

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | Fetched the required Course details. | **application/json**: [CourseResponseDto](#courseresponsedto-schema)<br> |
| 404 | Course Not Found |  |

### [PUT] /courses/{id}
**Update Course**

Update Course Details.

#### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ------ |
| id | path |  | Yes | integer |

#### Request Body

| Required | Schema |
| -------- | ------ |
|  Yes | **application/json**: [CourseRequestDto](#courserequestdto-schema)<br> |

#### Responses

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | Updated Successfully. | **application/json**: [CourseResponseDto](#courseresponsedto-schema)<br> |
| 404 | Course Not Found |  |

### [DELETE] /courses/{id}
**Delete Course**

Delete Course Details.

#### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ------ |
| id | path |  | Yes | integer |

#### Responses

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | Deleted Successfully. | **application/json**: [CourseResponseDto](#courseresponsedto-schema)<br> |
| 404 | Course Not Found |  |

### [GET] /courses
**Get All Courses**

Get all course resources.

#### Responses

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | Fetched all Course details. | **application/json**: [CourseResponseDto](#courseresponsedto-schema)<br> |

### [POST] /courses
**Create Course**

Create a new course resource.

#### Request Body

Payload to create Course resource

| Required | Schema |
| -------- | ------ |
|  Yes | **application/json**: [CourseRequestDto](#courserequestdto-schema)<br> |

#### Responses

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 201 | Successfully created a new copurse resource | **application/json**: [CourseResponseDto](#courseresponsedto-schema)<br> |

### [GET] /courses/trainer/{trainerName}
**Get Courses By Trainer Name**

Get all course resources for given trainer.

#### Parameters

| Name | Located in | Description | Required | Schema |
| ---- | ---------- | ----------- | -------- | ------ |
| trainerName | path |  | Yes | string |

#### Responses

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | Fetched the required Courses. | **application/json**: [CourseResponseDto](#courseresponsedto-schema)<br> |

### [GET] /courses/fees/{amount}
**Get Courses By Fees Less Than**

Get all course resources for fees less than given fee amount.

#### Responses

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | Fetched the required Courses. | **application/json**: [CourseResponseDto](#courseresponsedto-schema)<br> |

---
## Analytics APIs
Operations for Analytics System

### [GET] /analytics/most-popular-course
**Get Most Popular Course**

Get course with most enrollments.

#### Responses

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | Fetched the most popular course. | **application/json**: [CourseResponseDto](#courseresponsedto-schema)<br> |

### [GET] /analytics/enrollment-count
**Get Enrollments Count**

Get total count of enrollments.

#### Responses

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | Fetched the enrollments count. | **application/json**: integer<br> |

### [GET] /analytics/course-count
**Get Courses Count**

Get total count of courses.

#### Responses

| Code | Description | Schema |
| ---- | ----------- | ------ |
| 200 | Fetched the courses count. | **application/json**: integer<br> |

---
### Schemas

#### EnrollmentResponseDto Schema

| Name | Type | Description | Required |
| ---- | ---- | ----------- | -------- |
| enrollmentId | integer |  | No |
| employeeId | integer |  | No |
| employeeName | string |  | No |
| courseId | integer |  | No |
| enrollmentDate | date |  | No |
| status | string |  | No |

#### CourseRequestDto Schema

| Name | Type | Description | Required |
| ---- | ---- | ----------- | -------- |
| courseName | string |  | No |
| trainerName | string |  | No |
| durationInDays | integer |  | No |
| maxCapacity | integer |  | No |
| fees | double |  | No |

#### CourseResponseDto Schema

| Name | Type | Description | Required |
| ---- | ---- | ----------- | -------- |
| courseId | integer |  | No |
| courseName | string |  | No |
| trainerName | string |  | No |
| durationInDays | integer |  | No |
| maxCapacity | integer |  | No |
| fees | double |  | No |

#### EnrollmentRequestDto Schema

| Name | Type | Description | Required |
| ---- | ---- | ----------- | -------- |
| employeeId | integer |  | No |
| employeeName | string |  | No |
| courseId | integer |  | No |
