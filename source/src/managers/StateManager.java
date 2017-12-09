package managers;

import java.util.HashMap;
import com.jogamp.opengl.GLAutoDrawable;
import utils.State;

public class StateManager {
	private static StateManager instance;
	public static StateManager getInstance() {
		if (instance == null) {
			instance = new StateManager();
		}
		return instance;
	}
	
	/**
	 * Erstellt einen State Manager
	 */
	private StateManager() {};
	
	private HashMap<Integer, State> stateList = new HashMap<Integer, State>();
	private State activeState;
	
	/**
	 * F�gt einen State der State Liste hinzu
	 * @param state Der hinzuzuf�gende State
	 */
	public void addState(State state) {
		stateList.put(state.getId(), state);
	}
	
	/**
	 * L�scht einen State aus der State Liste
	 * @param id Die ID des zu l�schenden States
	 */
	public void removeState(int id) {
		stateList.remove(id);
	}
	
	/**
	 * Gibt den aktuell als aktiv gesetzten State zur�ck
	 * @return Der aktive State
	 */
	public State getActiveState() {
		return activeState;
	}
	
	/**
	 * Setzt den aktiven State
	 * @param id ID des als Aktiv zu setzenden States
	 */
	public void setActiveState(int id) {
		activeState = stateList.get(id);
	}
	
	/**
	 * Ruft die Init-Methoden aller States auf
	 * @param drawable Drawable Referenz
	 */
	public void initStates(GLAutoDrawable drawable) {
		for(State state : stateList.values()) {
			state.init(drawable);
		}
	}
}
