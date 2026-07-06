<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Order Placed Successfully!</title>
    <style>
        * { 
            margin: 0; 
            padding: 0; 
            box-sizing: border-box; 
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; 
        }
        
        body { 
            background: linear-gradient(135deg, #f5f7fa 0%, #e4e8f0 100%); 
            min-height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
            padding: 20px;
        }
        
        .success-box {
            background: white;
            padding: 50px;
            border-radius: 16px;
            box-shadow: 0 10px 30px rgba(0,0,0,0.08);
            text-align: center;
            max-width: 450px;
            width: 100%;
        }
        
        .icon { 
            font-size: 70px; 
            margin-bottom: 20px; 
            display: block;
        }
        
        h2 { 
            color: #1e293b; 
            margin-bottom: 12px;
            font-size: 28px;
        }
        
        p { 
            color: #64748b; 
            margin-bottom: 35px; 
            line-height: 1.6;
            font-size: 16px;
        }
        
        .btn-home {
            background: linear-gradient(135deg, #ff6b35 0%, #ff4f13 100%);
            color: white; 
            padding: 14px 30px;
            text-decoration: none; 
            border-radius: 8px; 
            font-weight: 600;
            display: inline-block;
            box-shadow: 0 4px 12px rgba(255, 107, 53, 0.2);
            transition: transform 0.2s, box-shadow 0.2s;
        }

        .btn-home:hover {
            transform: translateY(-1px);
            box-shadow: 0 6px 18px rgba(255, 107, 53, 0.3);
        }
    </style>
</head>
<body>

    <div class="success-box">
        <span class="icon">🎉</span>
        <h2>Order Confirmed!</h2>
        <p>Thank you for ordering. Your food is being prepared and will be delivered shortly!</p>
        <a href="restaurants" class="btn-home">Back to Home</a>
    </div>

</body>
</html>