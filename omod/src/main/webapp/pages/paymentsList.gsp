<%
    ui.decorateWith("appui", "standardEmrPage")
%>

${ui.includeFragment("coreapps", "patientHeader", [patient: patient])}

<div>
    <h3>Charges Info:</h3>
    <ul>
        <li>Date: ${ui.formatDatePretty(charges.date)}</li>
        <li>Total: KES ${charges.total}</li>
        <li>Balance: KES ${charges.balance}</li>
        <!-- 
        <li>Stay: KES ${charges.stay}</li>
        <li>Procedure: KES ${charges.procedure}</li>
        <li>Anaesthesia: KES ${charges.anaesthesia}</li>
        <li>Doctor: KES ${charges.doctor}</li>
        <li>Medications: KES ${charges.medications}</li>
        <li>Lab: KES ${charges.lab}</li>
        <li>X-ray: KES ${charges.xray}</li>
        <li>Supplies: KES ${charges.supplies}</li>
        <li>File: KES ${charges.file}</li>
        <li>Follow-up: KES ${charges.followUp}</li>
         -->
    </ul>
</div>

<div>
    <p>
        <a href="${ ui.pageLink("bkkh", "payment", [ chargesId: charges.id, patientId: patient.uuid ]) }">Add Charges</a>
    </p>
</div>

<table>
    <thead>
        <th>Payment Date</th>
        <th>Amount</th>
        <th>Method</th>
        <th>Account Charged</th>
    </thead>
    <tbody>
    <% charges.payments.each { payment -> %>
        <tr>
            <td>${payment.paymentDate}</td>
            <td>KES ${payment.paid}</td>
            <td>${payment.modeOfPayment}</td>
            <td>${payment.accountCharged}</td>
        </tr>
    <% } %>
    </tbody>
</table>