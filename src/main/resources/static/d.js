// Function to handle form submission
async function get() {
    // Collect the data from the inputs
    const uploaderName = document.getElementById('po').value; // Changed 'name' to 'uploaderName'
    const uniqueId = document.getElementById('po1').value;
    const driveLink = document.getElementById('po2').value;

    // Validate the input data
    if (!uploaderName || !uniqueId || !driveLink) { // Validate for uploaderName, uniqueId, and driveLink
        alert('All fields are required!');
        return;
    }

    // Create a drive info object with the entered data
    const driveInfoData = {
        uploaderName: uploaderName, // Changed 'name' to 'uploaderName'
        uniqueId: uniqueId,
        driveLink: driveLink
    };

    // Send data to backend (assuming you have a REST API endpoint)
    try {
        const response = await fetch('https://myspringboot-10.onrender.com/api/driveinfo', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(driveInfoData)
        });

        if (response.ok) {
            // Show success message
            document.getElementById('b1').innerHTML = `<p>Drive Info submitted successfully!</p>`;
        } else {
            // Handle error
            document.getElementById('b1').innerHTML = `<p>Error submitting data. Please try again.</p>`;
        }
    } catch (error) {
        console.error('Error:', error);
        document.getElementById('b1').innerHTML = `<p>Network error. Please try again later.</p>`;
    }
}
