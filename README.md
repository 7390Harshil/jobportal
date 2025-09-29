Job Portal 

A full-stack Job Portal Application that connects job seekers with employers. It allows job seekers to search and apply for jobs, while employers can post and manage job listings.

🚀 Features
👨‍💼 For Job Seekers
Register and create a profile.
Upload resume/CV.
Search and filter jobs (by title, location, category, etc.).
Apply for jobs.
Track applications.

🏢 For Employers
Register as an employer.
Post new job listings.
Manage job postings (edit, delete).
View applicants for a job.

⚙️ General
User authentication and authorization.
Secure password storage.

Admin dashboard (manage users, jobs, and applications).
🛠️ Tech Stack
Backend: Spring Boot
Database: MySQL
Authentication: JWT / Session-based authentication
Other Tools: Git, GitHub

📂 Project Structure
job-portal/
│── backend/              # Server-side code (APIs, DB connection)
│── config/               # Config files (DB, authentication, etc.)
│── public/               # Static assets
│── package.json          # Node.js dependencies
│── README.md             # Project documentation

⚡ Installation & Setup
1️⃣ Clone the Repository
git clone https://github.com/yourusername/job-portal.git
cd job-portal

2️⃣ Backend Setup
cd backend
npm install
# Setup environment variables in .env file
npm start

NOTE : It's a backend code only , Frontend layout can be of your choice and i am eager in taking contributions for frontend from u all to make my project interactive. 

🔑 Environment Variables

Create a .env file inside the backend/ directory:

PORT=5000
MONGO_URI=your_mongo_database_url
JWT_SECRET=your_secret_key

🎯 Future Enhancements
Make a responsive page for more interactiveness.
Resume parser for automatic skill extraction.
Recommendation engine for job seekers.
Email notifications for job alerts.
Role-based access control (Admin, Employer, Seeker).

🤝 Contributing
Contributions are welcome! Please fork the repository and submit a pull request.
