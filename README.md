# 🏥 CareMate 安心伴長照照護系統

> Java MVC × Swing GUI × MySQL Database

---

## 📖 專案介紹

CareMate（安心伴）是一套專為長照照護情境所設計的健康管理系統。

本系統提供：

* 家屬照顧者
* 被照顧者
* 外籍照顧者

三種角色登入使用。

透過圖形化介面協助記錄長輩日常健康狀況，包含血壓與體溫量測，並建立完整會員管理機制。

---

## 🎯 專案目標

解決長照環境中：

* 健康紀錄紙本化
* 外籍看護溝通困難
* 家屬無法即時掌握狀況
* 健康數據難以保存

等問題。

---

## 🖥️ 系統功能

### 1️⃣ 身分選擇

使用者可選擇：

* 家屬照顧者
* 被照顧者
* 外籍照顧者

外籍照顧者支援：

* 🇹🇼 中文
* 🇻🇳 越南文
* 🇵🇭 菲律賓文
* 🇮🇩 印尼文

---

### 2️⃣ 會員註冊

註冊資訊：

* 姓名
* 手機號碼
* 帳號
* 密碼
* 地址
* 身分類型

功能：

* 帳號重複檢查
* 註冊成功提示

---

### 3️⃣ 會員登入

登入驗證：

* Account
* Password

功能：

* 登入成功頁面
* 登入失敗提示
* 引導重新註冊

---

### 4️⃣ 首頁管理

首頁提供：

#### 用藥管理

* 08:00
* 12:00
* 20:00

#### 飲食營養

* 早餐
* 午餐
* 晚餐

#### 心情紀錄

* 開心
* 普通
* 不佳

#### 提醒通知

顯示未完成任務提醒。

---

### 5️⃣ 血壓與體溫紀錄

支援：

#### 時段選擇

* 早上
* 中午
* 晚上

#### 時間選擇

06:00 ~ 22:00

#### 血壓輸入

* 收縮壓
* 舒張壓

#### 體溫輸入

* 體溫 (°C)

---

### 6️⃣ 健康紀錄管理

功能：

* 新增紀錄
* 查看紀錄
* 清除輸入
* 刪除全部紀錄

資料存放於 MySQL：

```sql
health_record
```

---

## 🏗️ 系統架構

```text
CareMate
│
├─ app
│   └─ Main.java
│
├─ controller
│   ├─ RoleFrame
│   ├─ AddMemberFrame
│   ├─ LoginSuccess
│   ├─ LoginError
│   ├─ HomeFrame
│   └─ HealthFrame
│
├─ service
│   ├─ MemberService
│   └─ HealthService
│
├─ service.impl
│   ├─ MemberServiceImpl
│   └─ HealthServiceImpl
│
├─ dao
│   ├─ MemberDao
│   └─ HealthDao
│
├─ dao.impl
│   ├─ MemberDaoImpl
│   └─ HealthDaoImpl
│
├─ entity
│   └─ Member
│
└─ resources
    └─ db.properties
```

---

## 🗄️ 資料庫設計

### member

```sql
CREATE TABLE member (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50),
    phone VARCHAR(20),
    account VARCHAR(50),
    password VARCHAR(50),
    address VARCHAR(255),
    role VARCHAR(50)
);
```

---

### health_record

```sql
CREATE TABLE health_record (
    id INT PRIMARY KEY AUTO_INCREMENT,
    period VARCHAR(20),
    measure_time VARCHAR(20),
    systolic INT,
    diastolic INT,
    temperature DOUBLE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```

---

## ⚙️ 開發環境

| 項目       | 版本         |
| -------- | ---------- |
| Java     | JDK 8      |
| IDE      | Eclipse    |
| GUI      | Java Swing |
| Database | MySQL 8    |
| Pattern  | MVC        |

---

## 🚀 執行方式

### 1. Clone 專案

```bash
git clone https://github.com/你的帳號/CareMate.git
```

---

### 2. 建立資料庫

```sql
CREATE DATABASE caremate;
```

---

### 3. 修改資料庫設定

```properties
db.url=jdbc:mysql://localhost:3306/caremate
db.user=root
db.password=你的密碼
```

---

### 4. 執行主程式

```java
Main.java
```

---

---

## 📷 系統畫面

### 身分選擇

![Role](images/role.png)

### 我的帳戶

![Account](images/account.png)

### 首頁

![Home](images/home.png)

### 血壓體溫紀錄

![Health](images/health.png)

---

## 🔮 未來開發規劃

* [ ] 用藥提醒系統
* [ ] 飲食營養紀錄
* [ ] 心情管理
* [ ] 即時翻譯
* [ ] SOS緊急求助
* [ ] PDF報表匯出
* [ ] 雲端同步
* [ ] Android App版本

---

## 👨‍💻 作者

### 甘少棠 (KST Studio)

UI/UX Designer × Java Developer

專案名稱：

**CareMate 安心伴長照照護系統**

---

## 📄 License

MIT License

Copyright (c) 2026 KST Studio
