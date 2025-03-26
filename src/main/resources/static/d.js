// Function to handle form submission
async function get() {
    // Collect the data from the inputs
    const name = document.getElementById('po').value;
    const email = document.getElementById('po1').value;
    const phone = document.getElementById('po2').value;

    // Validate the input data
    if (!name || !email || !phone) {
        alert('All fields are required!');
        return;
    }

    // Create a student object with the entered data
    const studentData = {
        name: name,
        email: email,
        phone: phone
    };

    // Send data to backend (assuming you have a REST API endpoint)
    try {
        const response = await fetch('https://myspringboot-10.onrender.com/api/users', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(studentData)
        });

        if (response.ok) {
            // Show success message
            document.getElementById('b1').innerHTML = `<p>Student Info submitted successfully!</p>`;
        } else {
            // Handle error
            document.getElementById('b1').innerHTML = `<p>Error submitting data. Please try again.</p>`;
        }
    } catch (error) {
        console.error('Error:', error);
        document.getElementById('b1').innerHTML = `<p>Network error. Please try again later.</p>`;
    }
}
