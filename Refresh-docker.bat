echo =======================================
echo   Ricostruzione immagine Docker...
echo =======================================
"C:\Program Files\Docker\Docker\resources\bin\docker.exe" compose down
"C:\Program Files\Docker\Docker\resources\bin\docker.exe" compose up --build -d

echo =======================================
echo          Operazione completata!
echo =======================================
pause