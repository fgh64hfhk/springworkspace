# Java Spring Hibernate Project

## 簡介
本專案是一個基於 Java Spring 與 Hibernate 的後端應用，提供 JWT 驗證機制、基本資料初始化功能，並支援 MySQL 數據存取。

## 功能
- **JWT 驗證**: 提供管理員權限的安全框架。
- **資料初始化**: 預設建立產品 (Product)、分類 (Category) 和用戶 (User) 資料。
- **用戶註冊**: 支援用戶註冊的 API (`POST /register`)。
- **MySQL 數據存取範例**: 展示如何透過 Hibernate 存取 MySQL 資料庫。

## 環境需求
- JDK 11 或以上
- Spring Boot 依賴
- MySQL 資料庫

## 安裝與執行
### 1. 克隆專案
```bash
git clone <repository_url>
cd <project_directory>
```

### 2. 設定資料庫
請先確保 MySQL 已啟動，並建立對應的資料庫。
修改 `application.properties`:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/your_database
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```

### 3. 生成與運行專案
```bash
mvn clean install
mvn spring-boot:run
```

## API 端點
| 方法 | 端點 | 描述 |
|------|------|------|
| POST | `/register` | 註冊新用戶 |
| POST | `/login` | 用戶登入，取得 JWT Token |
| GET  | `/products` | 獲取所有產品 (需 JWT 驗證) |
| GET  | `/categories` | 獲取所有分類 (需 JWT 驗證) |

## 授權
本專案使用 JWT (JSON Web Token) 進行身份驗證。
- 註冊成功後，可使用 `/login` 取得 JWT。
- 所有受保護的 API 端點都需要在 `Authorization` Header 中攜帶 `Bearer <JWT>`。

## 貢獻方式
歡迎貢獻！請提交 Pull Request 或創建 Issue 來提供建議。

## 聯絡方式
如有問題，請聯繫專案維護者或提交 Issue。

---
本 README 根據 Commit 記錄撰寫，如有功能更新，請適時補充！
