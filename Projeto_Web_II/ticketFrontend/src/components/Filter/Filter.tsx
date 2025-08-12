import "../../styles/Filter.css"

const Filter = () => {
    return(
        <div className="filter-container">
            <ul className="filter-index">
                <li>
                    <label className="filter-item">
                        <input type="checkbox" />
                        <span></span>
                    </label>
                </li>
            </ul>
            <button className="filter-apply-btn" type="button">

            </button>
        </div>
    )
}

export default Filter