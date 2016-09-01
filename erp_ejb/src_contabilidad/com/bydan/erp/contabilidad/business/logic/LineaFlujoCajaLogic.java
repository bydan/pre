/*
*AVISO LEGAL
© Copyright
*Este programa esta protegido por la ley de derechos de autor.
*La reproduccion o distribucion ilicita de este programa o de cualquiera de
*sus partes esta penado por la ley con severas sanciones civiles y penales,
*y seran objeto de todas las sanciones legales que correspondan.

*Su contenido no puede copiarse para fines comerciales o de otras,
*ni puede mostrarse, incluso en una version modificada, en otros sitios Web.
Solo esta permitido colocar hipervinculos al sitio web.
*/
package com.bydan.erp.contabilidad.business.logic;

import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;
import java.sql.Timestamp;
import java.sql.SQLException;
import java.util.Date;
import java.util.Calendar;

import org.json.JSONArray;
import org.json.JSONObject;
import org.apache.log4j.Logger;


//VALIDACION
import org.hibernate.validator.ClassValidator;
import org.hibernate.validator.InvalidValue;

import com.bydan.framework.ConstantesCommon;
import com.bydan.framework.erp.business.entity.GeneralEntityLogic;
import com.bydan.framework.erp.business.entity.Classe;
import com.bydan.framework.erp.business.entity.DatoGeneral;
import com.bydan.framework.erp.business.entity.DatoGeneralMinimo;
import com.bydan.framework.erp.business.entity.DatoGeneralMaximo;
import com.bydan.framework.erp.business.logic.*;
import com.bydan.framework.erp.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.contabilidad.util.LineaFlujoCajaConstantesFunciones;
import com.bydan.erp.contabilidad.util.LineaFlujoCajaParameterReturnGeneral;
//import com.bydan.erp.contabilidad.util.LineaFlujoCajaParameterGeneral;
import com.bydan.erp.contabilidad.business.entity.LineaFlujoCaja;
import com.bydan.erp.contabilidad.business.logic.LineaFlujoCajaLogicAdditional;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;


import com.bydan.erp.seguridad.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;








@SuppressWarnings("unused")
public class LineaFlujoCajaLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(LineaFlujoCajaLogic.class);
	
	protected LineaFlujoCajaDataAccess lineaflujocajaDataAccess; 	
	protected LineaFlujoCaja lineaflujocaja;
	protected List<LineaFlujoCaja> lineaflujocajas;
	protected Object lineaflujocajaObject;	
	protected List<Object> lineaflujocajasObject;
	
	public static ClassValidator<LineaFlujoCaja> lineaflujocajaValidator = new ClassValidator<LineaFlujoCaja>(LineaFlujoCaja.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected LineaFlujoCajaLogicAdditional lineaflujocajaLogicAdditional=null;
	
	public LineaFlujoCajaLogicAdditional getLineaFlujoCajaLogicAdditional() {
		return this.lineaflujocajaLogicAdditional;
	}
	
	public void setLineaFlujoCajaLogicAdditional(LineaFlujoCajaLogicAdditional lineaflujocajaLogicAdditional) {
		try {
			this.lineaflujocajaLogicAdditional=lineaflujocajaLogicAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	/*
	protected ArrayList<DatoGeneral> arrDatoGeneral;
	protected Connexion connexion;
	protected DatosCliente datosCliente;
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	protected EntityManagerFactory entityManagerFactory;
	
	protected DatosDeep datosDeep;
	protected Boolean isConDeep=false;
	*/
	
	
	
	
	public  LineaFlujoCajaLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.lineaflujocajaDataAccess = new LineaFlujoCajaDataAccess();
			
			this.lineaflujocajas= new ArrayList<LineaFlujoCaja>();
			this.lineaflujocaja= new LineaFlujoCaja();
			
			this.lineaflujocajaObject=new Object();
			this.lineaflujocajasObject=new ArrayList<Object>();
				
			/*
			this.connexion=new Connexion();
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			this.datosDeep=new DatosDeep();
			this.isConDeep=false;
			*/
			
			this.lineaflujocajaDataAccess.setConnexionType(this.connexionType);
			this.lineaflujocajaDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  LineaFlujoCajaLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.lineaflujocajaDataAccess = new LineaFlujoCajaDataAccess();
			this.lineaflujocajas= new ArrayList<LineaFlujoCaja>();
			this.lineaflujocaja= new LineaFlujoCaja();
			this.lineaflujocajaObject=new Object();
			this.lineaflujocajasObject=new ArrayList<Object>();
			
			/*
			this.datosCliente=new DatosCliente();
			this.arrDatoGeneral= new  ArrayList<DatoGeneral>();
			
			//INICIALIZA PARAMETROS CONEXION
			this.connexionType=Constantes.CONNEXIONTYPE;
			this.parameterDbType=Constantes.PARAMETERDBTYPE;
			
			if(Constantes.CONNEXIONTYPE.equals(ConnexionType.HIBERNATE)) {
				this.entityManagerFactory=ConstantesCommon.JPAENTITYMANAGERFACTORY;
			}
			
			this.datosDeep=new DatosDeep();
			this.isConDeep=false;
			*/
			
			this.lineaflujocajaDataAccess.setConnexionType(this.connexionType);
			this.lineaflujocajaDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public LineaFlujoCaja getLineaFlujoCaja() throws Exception {	
		LineaFlujoCajaLogicAdditional.checkLineaFlujoCajaToGet(lineaflujocaja,this.datosCliente,this.arrDatoGeneral);
		LineaFlujoCajaLogicAdditional.updateLineaFlujoCajaToGet(lineaflujocaja,this.arrDatoGeneral);
		
		return lineaflujocaja;
	}
		
	public void setLineaFlujoCaja(LineaFlujoCaja newLineaFlujoCaja) {
		this.lineaflujocaja = newLineaFlujoCaja;
	}
	
	public LineaFlujoCajaDataAccess getLineaFlujoCajaDataAccess() {
		return lineaflujocajaDataAccess;
	}
	
	public void setLineaFlujoCajaDataAccess(LineaFlujoCajaDataAccess newlineaflujocajaDataAccess) {
		this.lineaflujocajaDataAccess = newlineaflujocajaDataAccess;
	}
	
	public List<LineaFlujoCaja> getLineaFlujoCajas() throws Exception {		
		this.quitarLineaFlujoCajasNulos();
		
		LineaFlujoCajaLogicAdditional.checkLineaFlujoCajaToGets(lineaflujocajas,this.datosCliente,this.arrDatoGeneral);
		
		for (LineaFlujoCaja lineaflujocajaLocal: lineaflujocajas ) {
			LineaFlujoCajaLogicAdditional.updateLineaFlujoCajaToGet(lineaflujocajaLocal,this.arrDatoGeneral);
		}
		
		return lineaflujocajas;
	}
	
	public void setLineaFlujoCajas(List<LineaFlujoCaja> newLineaFlujoCajas) {
		this.lineaflujocajas = newLineaFlujoCajas;
	}
	
	public Object getLineaFlujoCajaObject() {	
		this.lineaflujocajaObject=this.lineaflujocajaDataAccess.getEntityObject();
		return this.lineaflujocajaObject;
	}
		
	public void setLineaFlujoCajaObject(Object newLineaFlujoCajaObject) {
		this.lineaflujocajaObject = newLineaFlujoCajaObject;
	}
	
	public List<Object> getLineaFlujoCajasObject() {		
		this.lineaflujocajasObject=this.lineaflujocajaDataAccess.getEntitiesObject();
		return this.lineaflujocajasObject;
	}
		
	public void setLineaFlujoCajasObject(List<Object> newLineaFlujoCajasObject) {
		this.lineaflujocajasObject = newLineaFlujoCajasObject;
	}
	
	/*
	public Connexion getConnexion() {
		return this.connexion;		
	}
	
	public void setConnexion(Connexion newConnexion) {
		this.connexion=newConnexion;		
	}
	
	public DatosCliente getDatosCliente() {
		return datosCliente;
	}
	*/
	
	public void setDatosCliente(DatosCliente datosCliente) {		
		this.datosCliente = datosCliente;
		
		if(this.lineaflujocajaDataAccess!=null) {
			this.lineaflujocajaDataAccess.setDatosCliente(datosCliente);
		}
	}
	
	/*
	public DatosDeep getDatosDeep() {
		return this.datosDeep;
	}

	public void setDatosDeep(DatosDeep datosDeep) {
		this.datosDeep = datosDeep;
	}
	
	public void setDatosDeepFromDatosCliente() {
		this.datosDeep = this.datosCliente.getDatosDeep();
		this.isConDeep=this.datosCliente.getIsConDeep();
	}
	
	public Boolean getIsConDeep() {
		return this.isConDeep;
	}

	public void setIsConDeep(Boolean isConDeep) {
		this.isConDeep = isConDeep;
	}
	
	public ArrayList<DatoGeneral> getArrDatoGeneral() {
		return arrDatoGeneral;
	}

	public void setArrDatoGeneral(ArrayList<DatoGeneral> arrDatoGeneral) {
		this.arrDatoGeneral = arrDatoGeneral;
	}
	
	public ConnexionType getConnexionType() {
		return connexionType;
	}

	public void setConnexionType(ConnexionType connexionType) {
		this.connexionType = connexionType;
	}


	public ParameterDbType getParameterDbType() {
		return parameterDbType;
	}

	public void setParameterDbType(ParameterDbType parameterDbType) {
		this.parameterDbType = parameterDbType;
	}

	public EntityManagerFactory getEntityManagerFactory() {
		return entityManagerFactory;
	}

	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}
	*/
	
			
	public void setDatosDeepParametros(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String strTituloMensaje) {
		this.datosDeep.setIsDeep(isDeep);
		this.datosDeep.setDeepLoadType(deepLoadType);
		this.datosDeep.setClases(clases);
		this.datosDeep.setSTituloMensaje(strTituloMensaje);
	}
	
	public InvalidValue[] getInvalidValues() {
		return invalidValues;
	}

	public void setInvalidValues(InvalidValue[] invalidValues) {
		this.invalidValues = invalidValues;
	}
	
	public StringBuilder getStringBuilder() {
		return this.stringBuilder;
	}

	public void setStringBuilder(StringBuilder stringBuilder) {
		this.stringBuilder = stringBuilder;
	}
	
	public Boolean getConMostrarMensajesStringBuilder() {
		return this.conMostrarMensajesStringBuilder;
	}

	public void setConMostrarMensajesStringBuilder(Boolean conMostrarMensajesStringBuilder) {
		this.conMostrarMensajesStringBuilder = conMostrarMensajesStringBuilder;
	}	
	
			
	
	public void getNewConnexionToDeep()throws Exception {
		//this.getNewConnexionToDeep();
		try	{
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,"");connexion.begin();
			
		} catch(SQLException e) {
			Funciones.manageException(logger,e);
			throw e;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public void getNewConnexionToDeep(String sDetalle)throws Exception {
		try	{
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,sDetalle);connexion.begin();
			
		} catch(SQLException e) {
			Funciones.manageException(logger,e);
			throw e;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public void commitNewConnexionToDeep()throws Exception {
		try	{
			this.connexion.commit();
			
		} catch(SQLException e) {
			Funciones.manageException(logger,e);
			throw e;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public void rollbackNewConnexionToDeep()throws Exception {
		try	{
			this.connexion.rollback();
			
		} catch(SQLException e) {
			Funciones.manageException(logger,e);
			throw e;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public void closeNewConnexionToDeep()throws Exception {
		try	{
			this.connexion.close();
			
		} catch(SQLException e) {
			Funciones.manageException(logger,e);
			throw e;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public  void executeQueryWithConnection(String sQueryExecute) throws Exception {
		try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LineaFlujoCaja.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			lineaflujocajaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
			connexion.commit();
						
		} catch(Exception e) {
			connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public  void executeQuery(String sQueryExecute) throws Exception {
		try {			
			lineaflujocajaDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		lineaflujocaja = new  LineaFlujoCaja();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LineaFlujoCaja.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			lineaflujocaja=lineaflujocajaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.lineaflujocaja,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				LineaFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesLineaFlujoCaja(this.lineaflujocaja);
			}
			
			connexion.commit();
						
		} catch(Exception e) {
			connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public  void getEntity(Long id) throws Exception {
		lineaflujocaja = new  LineaFlujoCaja();
		  		  
        try {
			
			lineaflujocaja=lineaflujocajaDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.lineaflujocaja,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				LineaFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesLineaFlujoCaja(this.lineaflujocaja);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		lineaflujocaja = new  LineaFlujoCaja();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LineaFlujoCaja.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			lineaflujocaja=lineaflujocajaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.lineaflujocaja,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				LineaFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesLineaFlujoCaja(this.lineaflujocaja);
			}
			
			connexion.commit();
						
		} catch(Exception e) {
			connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public  void getEntityWithConnection(String sFinalQuery) throws Exception {
		lineaflujocaja = new  LineaFlujoCaja();
		  		  
        try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			this.getEntityWithConnection(queryWhereSelectParameters);
			
		} catch(Exception e) {
			throw e;
			
      	} finally {
					
		}
	}
	
	public  void getEntity(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		lineaflujocaja = new  LineaFlujoCaja();
		  		  
        try {
			
			lineaflujocaja=lineaflujocajaDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.lineaflujocaja,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				LineaFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesLineaFlujoCaja(this.lineaflujocaja);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		lineaflujocaja = new  LineaFlujoCaja();
		  		  
        try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			this.getEntity(queryWhereSelectParameters);
			
		} catch(Exception e) {
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		lineaflujocaja = new  LineaFlujoCaja();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LineaFlujoCaja.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =lineaflujocajaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
			connexion.commit();
			
		} catch(Exception e) {
			connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
		
		return datoGeneralMinimo;
	}
	
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		lineaflujocaja = new  LineaFlujoCaja();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=lineaflujocajaDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		lineaflujocaja = new  LineaFlujoCaja();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LineaFlujoCaja.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =lineaflujocajaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
			connexion.commit();
			
		} catch(Exception e) {
			connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		lineaflujocaja = new  LineaFlujoCaja();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=lineaflujocajaDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		lineaflujocaja = new  LineaFlujoCaja();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LineaFlujoCaja.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =lineaflujocajaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
			connexion.commit();
			
		} catch(Exception e) {
			connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
		
		return datoGeneralMaximos;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		lineaflujocaja = new  LineaFlujoCaja();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=lineaflujocajaDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		lineaflujocajas = new  ArrayList<LineaFlujoCaja>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LineaFlujoCaja.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			LineaFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			lineaflujocajas=lineaflujocajaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarLineaFlujoCaja(lineaflujocajas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				LineaFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesLineaFlujoCaja(this.lineaflujocajas);
			}
			
			connexion.commit();			
			
		} catch(Exception e) {
			connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();	
		}
	}
	
	public  void getEntitiesWithConnection(String sFinalQuery)throws Exception {	
		lineaflujocajas = new  ArrayList<LineaFlujoCaja>();
		  		  
        try {
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			this.getEntitiesWithConnection(queryWhereSelectParameters);    	       	 
			
		} catch(Exception e) {
			throw e;
			
      	} finally {
		}
	}
	
	public  void getEntities(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		lineaflujocajas = new  ArrayList<LineaFlujoCaja>();
		  		  
        try {			
			LineaFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			lineaflujocajas=lineaflujocajaDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarLineaFlujoCaja(lineaflujocajas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				LineaFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesLineaFlujoCaja(this.lineaflujocajas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		lineaflujocajas = new  ArrayList<LineaFlujoCaja>();
		  		  
        try {			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			this.getEntities(queryWhereSelectParameters);    	       	 			
		
		} catch(Exception e) {	
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		lineaflujocajas = new  ArrayList<LineaFlujoCaja>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LineaFlujoCaja.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			LineaFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			lineaflujocajas=lineaflujocajaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarLineaFlujoCaja(lineaflujocajas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				LineaFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesLineaFlujoCaja(this.lineaflujocajas);
			}
			
			connexion.commit();
			
		} catch(Exception e) {
			connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public  void getEntities(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		lineaflujocajas = new  ArrayList<LineaFlujoCaja>();
		  		  
        try {
			LineaFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			lineaflujocajas=lineaflujocajaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarLineaFlujoCaja(lineaflujocajas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				LineaFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesLineaFlujoCaja(this.lineaflujocajas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	/**
	* Trae cualquier tipo de query select
	* @conMapGenerico  Si es true, trae todo como objeto generico, Si es false trae query en campos de la clase, usando unicamente los determinados en listColumns y deepLoadType
	* @deepLoadType  Si conMapGenerico es false trae query select con las columnas de listColumns, incluyento o excludendo deacuerdo a deepLoadType
	*/
	public void getEntitiesWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		lineaflujocajas = new  ArrayList<LineaFlujoCaja>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LineaFlujoCaja.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			LineaFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			lineaflujocajas=lineaflujocajaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarLineaFlujoCaja(lineaflujocajas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				LineaFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesLineaFlujoCaja(this.lineaflujocajas);
			}
			
			connexion.commit();
			
		} catch(Exception e) {
			connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public  void getEntities(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		lineaflujocajas = new  ArrayList<LineaFlujoCaja>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			LineaFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			lineaflujocajas=lineaflujocajaDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarLineaFlujoCaja(lineaflujocajas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				LineaFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesLineaFlujoCaja(this.lineaflujocajas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		lineaflujocaja = new  LineaFlujoCaja();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LineaFlujoCaja.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			LineaFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			lineaflujocaja=lineaflujocajaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarLineaFlujoCaja(lineaflujocaja);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				LineaFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesLineaFlujoCaja(this.lineaflujocaja);
			}
			
			connexion.commit();
			
		} catch(Exception e) {
			connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public  void getEntity(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		lineaflujocaja = new  LineaFlujoCaja();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			LineaFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			lineaflujocaja=lineaflujocajaDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarLineaFlujoCaja(lineaflujocaja);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				LineaFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesLineaFlujoCaja(this.lineaflujocaja);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		lineaflujocajas = new  ArrayList<LineaFlujoCaja>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LineaFlujoCaja.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			LineaFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			lineaflujocajas=lineaflujocajaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarLineaFlujoCaja(lineaflujocajas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				LineaFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesLineaFlujoCaja(this.lineaflujocajas);
			}
			
			connexion.commit();			
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public  void getEntitiesSimpleQueryBuild(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		lineaflujocajas = new  ArrayList<LineaFlujoCaja>();
		  		  
        try {
			LineaFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			lineaflujocajas=lineaflujocajaDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarLineaFlujoCaja(lineaflujocajas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				LineaFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesLineaFlujoCaja(this.lineaflujocajas);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosLineaFlujoCajasWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		lineaflujocajas = new  ArrayList<LineaFlujoCaja>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LineaFlujoCaja.class.getSimpleName()+"-getTodosLineaFlujoCajasWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			LineaFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			lineaflujocajas=lineaflujocajaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarLineaFlujoCaja(lineaflujocajas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				LineaFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesLineaFlujoCaja(this.lineaflujocajas);
			}
			
			connexion.commit();			
			
		} catch(Exception e) {	
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}		
	}
	
	public  void  getTodosLineaFlujoCajas(String sFinalQuery,Pagination pagination)throws Exception {
		lineaflujocajas = new  ArrayList<LineaFlujoCaja>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			LineaFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			lineaflujocajas=lineaflujocajaDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarLineaFlujoCaja(lineaflujocajas);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				LineaFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesLineaFlujoCaja(this.lineaflujocajas);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarLineaFlujoCaja(LineaFlujoCaja lineaflujocaja) throws Exception {
		Boolean estaValidado=false;
		
		if(lineaflujocaja.getIsNew() || lineaflujocaja.getIsChanged()) { 
			this.invalidValues = lineaflujocajaValidator.getInvalidValues(lineaflujocaja);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(lineaflujocaja);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarLineaFlujoCaja(List<LineaFlujoCaja> LineaFlujoCajas) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(LineaFlujoCaja lineaflujocajaLocal:lineaflujocajas) {				
			estaValidadoObjeto=this.validarGuardarLineaFlujoCaja(lineaflujocajaLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarLineaFlujoCaja(List<LineaFlujoCaja> LineaFlujoCajas) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarLineaFlujoCaja(lineaflujocajas)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarLineaFlujoCaja(LineaFlujoCaja LineaFlujoCaja) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarLineaFlujoCaja(lineaflujocaja)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(LineaFlujoCaja lineaflujocaja) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+lineaflujocaja.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=LineaFlujoCajaConstantesFunciones.getLineaFlujoCajaLabelDesdeNombre(invalidValue.getPropertyName());
			sMensajeCampo=invalidValue.getMessage();
			
			sMensaje+="\r\n"+sCampo+"->"+sMensajeCampo;
			
			//MOSTRAR CAMPOS INVALIDOS
        }
				
		if(!sMensaje.equals("")) {
			this.stringBuilder.append(sMensaje);	
		}		
	}	
	
	public void manejarMensajesStringBuilder(String sMensajeExcepcion) throws Exception {
		String sMensajeDetalleExcepcion="";
		
		sMensajeDetalleExcepcion=this.stringBuilder.toString();
		
		if(!sMensajeDetalleExcepcion.equals("")) {
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"lineaflujocaja","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(LineaFlujoCajaConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(LineaFlujoCajaConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveLineaFlujoCajaWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LineaFlujoCaja.class.getSimpleName()+"-saveLineaFlujoCajaWithConnection");connexion.begin();			
			
			LineaFlujoCajaLogicAdditional.checkLineaFlujoCajaToSave(this.lineaflujocaja,this.datosCliente,connexion,this.arrDatoGeneral);
			
			LineaFlujoCajaLogicAdditional.updateLineaFlujoCajaToSave(this.lineaflujocaja,this.arrDatoGeneral);
			
			LineaFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.lineaflujocaja,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowLineaFlujoCaja();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarLineaFlujoCaja(this.lineaflujocaja)) {
				LineaFlujoCajaDataAccess.save(this.lineaflujocaja, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.lineaflujocaja,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			LineaFlujoCajaLogicAdditional.checkLineaFlujoCajaToSaveAfter(this.lineaflujocaja,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowLineaFlujoCaja();
			
			connexion.commit();			
			
			if(this.lineaflujocaja.getIsDeleted()) {
				this.lineaflujocaja=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveLineaFlujoCaja()throws Exception {	
		try {	
			
			LineaFlujoCajaLogicAdditional.checkLineaFlujoCajaToSave(this.lineaflujocaja,this.datosCliente,connexion,this.arrDatoGeneral);
			
			LineaFlujoCajaLogicAdditional.updateLineaFlujoCajaToSave(this.lineaflujocaja,this.arrDatoGeneral);
			
			LineaFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.lineaflujocaja,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarLineaFlujoCaja(this.lineaflujocaja)) {			
				LineaFlujoCajaDataAccess.save(this.lineaflujocaja, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.lineaflujocaja,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			LineaFlujoCajaLogicAdditional.checkLineaFlujoCajaToSaveAfter(this.lineaflujocaja,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.lineaflujocaja.getIsDeleted()) {
				this.lineaflujocaja=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveLineaFlujoCajasWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LineaFlujoCaja.class.getSimpleName()+"-saveLineaFlujoCajasWithConnection");connexion.begin();			
			
			LineaFlujoCajaLogicAdditional.checkLineaFlujoCajaToSaves(lineaflujocajas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowLineaFlujoCajas();
			
			Boolean validadoTodosLineaFlujoCaja=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(LineaFlujoCaja lineaflujocajaLocal:lineaflujocajas) {		
				if(lineaflujocajaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				LineaFlujoCajaLogicAdditional.updateLineaFlujoCajaToSave(lineaflujocajaLocal,this.arrDatoGeneral);
	        	
				LineaFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),lineaflujocajaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarLineaFlujoCaja(lineaflujocajaLocal)) {
					LineaFlujoCajaDataAccess.save(lineaflujocajaLocal, connexion);				
				} else {
					validadoTodosLineaFlujoCaja=false;
				}
			}
			
			if(!validadoTodosLineaFlujoCaja) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			LineaFlujoCajaLogicAdditional.checkLineaFlujoCajaToSavesAfter(lineaflujocajas,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowLineaFlujoCajas();
			
			connexion.commit();		
			
			this.quitarLineaFlujoCajasEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveLineaFlujoCajas()throws Exception {				
		 try {	
			LineaFlujoCajaLogicAdditional.checkLineaFlujoCajaToSaves(lineaflujocajas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosLineaFlujoCaja=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(LineaFlujoCaja lineaflujocajaLocal:lineaflujocajas) {				
				if(lineaflujocajaLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				LineaFlujoCajaLogicAdditional.updateLineaFlujoCajaToSave(lineaflujocajaLocal,this.arrDatoGeneral);
	        	
				LineaFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),lineaflujocajaLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarLineaFlujoCaja(lineaflujocajaLocal)) {				
					LineaFlujoCajaDataAccess.save(lineaflujocajaLocal, connexion);				
				} else {
					validadoTodosLineaFlujoCaja=false;
				}
			}
			
			if(!validadoTodosLineaFlujoCaja) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			LineaFlujoCajaLogicAdditional.checkLineaFlujoCajaToSavesAfter(lineaflujocajas,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarLineaFlujoCajasEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public LineaFlujoCajaParameterReturnGeneral procesarAccionLineaFlujoCajas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<LineaFlujoCaja> lineaflujocajas,LineaFlujoCajaParameterReturnGeneral lineaflujocajaParameterGeneral)throws Exception {
		 try {	
			LineaFlujoCajaParameterReturnGeneral lineaflujocajaReturnGeneral=new LineaFlujoCajaParameterReturnGeneral();
	
			LineaFlujoCajaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,lineaflujocajas,lineaflujocajaParameterGeneral,lineaflujocajaReturnGeneral);
			
			return lineaflujocajaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public LineaFlujoCajaParameterReturnGeneral procesarAccionLineaFlujoCajasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<LineaFlujoCaja> lineaflujocajas,LineaFlujoCajaParameterReturnGeneral lineaflujocajaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LineaFlujoCaja.class.getSimpleName()+"-procesarAccionLineaFlujoCajasWithConnection");connexion.begin();			
			
			LineaFlujoCajaParameterReturnGeneral lineaflujocajaReturnGeneral=new LineaFlujoCajaParameterReturnGeneral();
	
			LineaFlujoCajaLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,lineaflujocajas,lineaflujocajaParameterGeneral,lineaflujocajaReturnGeneral);
			
			this.connexion.commit();
			
			return lineaflujocajaReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public LineaFlujoCajaParameterReturnGeneral procesarEventosLineaFlujoCajas(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<LineaFlujoCaja> lineaflujocajas,LineaFlujoCaja lineaflujocaja,LineaFlujoCajaParameterReturnGeneral lineaflujocajaParameterGeneral,Boolean isEsNuevoLineaFlujoCaja,ArrayList<Classe> clases)throws Exception {
		 try {	
			LineaFlujoCajaParameterReturnGeneral lineaflujocajaReturnGeneral=new LineaFlujoCajaParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				lineaflujocajaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			LineaFlujoCajaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,lineaflujocajas,lineaflujocaja,lineaflujocajaParameterGeneral,lineaflujocajaReturnGeneral,isEsNuevoLineaFlujoCaja,clases);
			
			return lineaflujocajaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public LineaFlujoCajaParameterReturnGeneral procesarEventosLineaFlujoCajasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<LineaFlujoCaja> lineaflujocajas,LineaFlujoCaja lineaflujocaja,LineaFlujoCajaParameterReturnGeneral lineaflujocajaParameterGeneral,Boolean isEsNuevoLineaFlujoCaja,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LineaFlujoCaja.class.getSimpleName()+"-procesarEventosLineaFlujoCajasWithConnection");connexion.begin();			
			
			LineaFlujoCajaParameterReturnGeneral lineaflujocajaReturnGeneral=new LineaFlujoCajaParameterReturnGeneral();
	
			lineaflujocajaReturnGeneral.setLineaFlujoCaja(lineaflujocaja);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				lineaflujocajaReturnGeneral.setConRecargarPropiedades(true);
			}
			
			LineaFlujoCajaLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,lineaflujocajas,lineaflujocaja,lineaflujocajaParameterGeneral,lineaflujocajaReturnGeneral,isEsNuevoLineaFlujoCaja,clases);
			
			this.connexion.commit();
			
			return lineaflujocajaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public LineaFlujoCajaParameterReturnGeneral procesarImportacionLineaFlujoCajasWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,LineaFlujoCajaParameterReturnGeneral lineaflujocajaParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LineaFlujoCaja.class.getSimpleName()+"-procesarImportacionLineaFlujoCajasWithConnection");connexion.begin();			
			
			LineaFlujoCajaParameterReturnGeneral lineaflujocajaReturnGeneral=new LineaFlujoCajaParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.lineaflujocajas=new ArrayList<LineaFlujoCaja>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.lineaflujocaja=new LineaFlujoCaja();
				
				
				if(conColumnasBase) {this.lineaflujocaja.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.lineaflujocaja.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.lineaflujocaja.setcodigo(arrColumnas[iColumn++]);
				this.lineaflujocaja.setnombre(arrColumnas[iColumn++]);
				this.lineaflujocaja.setes_consolidado(Boolean.parseBoolean(arrColumnas[iColumn++]));
				this.lineaflujocaja.setesta_proyeccion(Boolean.parseBoolean(arrColumnas[iColumn++]));
				
				this.lineaflujocajas.add(this.lineaflujocaja);
			}
			
			this.saveLineaFlujoCajas();
			
			this.connexion.commit();
			
			lineaflujocajaReturnGeneral.setConRetornoEstaProcesado(true);
			lineaflujocajaReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return lineaflujocajaReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarLineaFlujoCajasEliminados() throws Exception {				
		
		List<LineaFlujoCaja> lineaflujocajasAux= new ArrayList<LineaFlujoCaja>();
		
		for(LineaFlujoCaja lineaflujocaja:lineaflujocajas) {
			if(!lineaflujocaja.getIsDeleted()) {
				lineaflujocajasAux.add(lineaflujocaja);
			}
		}
		
		lineaflujocajas=lineaflujocajasAux;
	}
	
	public void quitarLineaFlujoCajasNulos() throws Exception {				
		
		List<LineaFlujoCaja> lineaflujocajasAux= new ArrayList<LineaFlujoCaja>();
		
		for(LineaFlujoCaja lineaflujocaja : this.lineaflujocajas) {
			if(lineaflujocaja==null) {
				lineaflujocajasAux.add(lineaflujocaja);
			}
		}
		
		//this.lineaflujocajas=lineaflujocajasAux;
		
		this.lineaflujocajas.removeAll(lineaflujocajasAux);
	}
	
	public void getSetVersionRowLineaFlujoCajaWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(lineaflujocaja.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((lineaflujocaja.getIsDeleted() || (lineaflujocaja.getIsChanged()&&!lineaflujocaja.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=lineaflujocajaDataAccess.getSetVersionRowLineaFlujoCaja(connexion,lineaflujocaja.getId());
				
				if(!lineaflujocaja.getVersionRow().equals(timestamp)) {	
					lineaflujocaja.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				lineaflujocaja.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowLineaFlujoCaja()throws Exception {	
		
		if(lineaflujocaja.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((lineaflujocaja.getIsDeleted() || (lineaflujocaja.getIsChanged()&&!lineaflujocaja.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=lineaflujocajaDataAccess.getSetVersionRowLineaFlujoCaja(connexion,lineaflujocaja.getId());
			
			try {							
				if(!lineaflujocaja.getVersionRow().equals(timestamp)) {	
					lineaflujocaja.setVersionRow(timestamp);
				}
				
				lineaflujocaja.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowLineaFlujoCajasWithConnection()throws Exception {	
		if(lineaflujocajas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(LineaFlujoCaja lineaflujocajaAux:lineaflujocajas) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(lineaflujocajaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(lineaflujocajaAux.getIsDeleted() || (lineaflujocajaAux.getIsChanged()&&!lineaflujocajaAux.getIsNew())) {
						
						timestamp=lineaflujocajaDataAccess.getSetVersionRowLineaFlujoCaja(connexion,lineaflujocajaAux.getId());
						
						if(!lineaflujocaja.getVersionRow().equals(timestamp)) {	
							lineaflujocajaAux.setVersionRow(timestamp);
						}
								
						lineaflujocajaAux.setIsChangedAuxiliar(false);														
					//}
				}
				
				connexion.commit();									
				
			} catch(Exception e) {
				connexion.rollback();							
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowLineaFlujoCajas()throws Exception {	
		if(lineaflujocajas!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(LineaFlujoCaja lineaflujocajaAux:lineaflujocajas) {
					if(lineaflujocajaAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(lineaflujocajaAux.getIsDeleted() || (lineaflujocajaAux.getIsChanged()&&!lineaflujocajaAux.getIsNew())) {
						
						timestamp=lineaflujocajaDataAccess.getSetVersionRowLineaFlujoCaja(connexion,lineaflujocajaAux.getId());
						
						if(!lineaflujocajaAux.getVersionRow().equals(timestamp)) {	
							lineaflujocajaAux.setVersionRow(timestamp);
						}
						
													
						lineaflujocajaAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public LineaFlujoCajaParameterReturnGeneral cargarCombosLoteForeignKeyLineaFlujoCajaWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalTipoGrupoFlujoCaja,String finalQueryGlobalTipoLineaFlujoCaja) throws Exception {
		LineaFlujoCajaParameterReturnGeneral  lineaflujocajaReturnGeneral =new LineaFlujoCajaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LineaFlujoCaja.class.getSimpleName()+"-cargarCombosLoteForeignKeyLineaFlujoCajaWithConnection");connexion.begin();
			
			lineaflujocajaReturnGeneral =new LineaFlujoCajaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			lineaflujocajaReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<TipoGrupoFlujoCaja> tipogrupoflujocajasForeignKey=new ArrayList<TipoGrupoFlujoCaja>();
			TipoGrupoFlujoCajaLogic tipogrupoflujocajaLogic=new TipoGrupoFlujoCajaLogic();
			tipogrupoflujocajaLogic.setConnexion(this.connexion);
			tipogrupoflujocajaLogic.getTipoGrupoFlujoCajaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoGrupoFlujoCaja.equals("NONE")) {
				tipogrupoflujocajaLogic.getTodosTipoGrupoFlujoCajas(finalQueryGlobalTipoGrupoFlujoCaja,new Pagination());
				tipogrupoflujocajasForeignKey=tipogrupoflujocajaLogic.getTipoGrupoFlujoCajas();
			}

			lineaflujocajaReturnGeneral.settipogrupoflujocajasForeignKey(tipogrupoflujocajasForeignKey);


			List<TipoLineaFlujoCaja> tipolineaflujocajasForeignKey=new ArrayList<TipoLineaFlujoCaja>();
			TipoLineaFlujoCajaLogic tipolineaflujocajaLogic=new TipoLineaFlujoCajaLogic();
			tipolineaflujocajaLogic.setConnexion(this.connexion);
			tipolineaflujocajaLogic.getTipoLineaFlujoCajaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoLineaFlujoCaja.equals("NONE")) {
				tipolineaflujocajaLogic.getTodosTipoLineaFlujoCajas(finalQueryGlobalTipoLineaFlujoCaja,new Pagination());
				tipolineaflujocajasForeignKey=tipolineaflujocajaLogic.getTipoLineaFlujoCajas();
			}

			lineaflujocajaReturnGeneral.settipolineaflujocajasForeignKey(tipolineaflujocajasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return lineaflujocajaReturnGeneral;
	}
	
	public LineaFlujoCajaParameterReturnGeneral cargarCombosLoteForeignKeyLineaFlujoCaja(String finalQueryGlobalEmpresa,String finalQueryGlobalTipoGrupoFlujoCaja,String finalQueryGlobalTipoLineaFlujoCaja) throws Exception {
		LineaFlujoCajaParameterReturnGeneral  lineaflujocajaReturnGeneral =new LineaFlujoCajaParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			lineaflujocajaReturnGeneral =new LineaFlujoCajaParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			lineaflujocajaReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<TipoGrupoFlujoCaja> tipogrupoflujocajasForeignKey=new ArrayList<TipoGrupoFlujoCaja>();
			TipoGrupoFlujoCajaLogic tipogrupoflujocajaLogic=new TipoGrupoFlujoCajaLogic();
			tipogrupoflujocajaLogic.setConnexion(this.connexion);
			tipogrupoflujocajaLogic.getTipoGrupoFlujoCajaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoGrupoFlujoCaja.equals("NONE")) {
				tipogrupoflujocajaLogic.getTodosTipoGrupoFlujoCajas(finalQueryGlobalTipoGrupoFlujoCaja,new Pagination());
				tipogrupoflujocajasForeignKey=tipogrupoflujocajaLogic.getTipoGrupoFlujoCajas();
			}

			lineaflujocajaReturnGeneral.settipogrupoflujocajasForeignKey(tipogrupoflujocajasForeignKey);


			List<TipoLineaFlujoCaja> tipolineaflujocajasForeignKey=new ArrayList<TipoLineaFlujoCaja>();
			TipoLineaFlujoCajaLogic tipolineaflujocajaLogic=new TipoLineaFlujoCajaLogic();
			tipolineaflujocajaLogic.setConnexion(this.connexion);
			tipolineaflujocajaLogic.getTipoLineaFlujoCajaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalTipoLineaFlujoCaja.equals("NONE")) {
				tipolineaflujocajaLogic.getTodosTipoLineaFlujoCajas(finalQueryGlobalTipoLineaFlujoCaja,new Pagination());
				tipolineaflujocajasForeignKey=tipolineaflujocajaLogic.getTipoLineaFlujoCajas();
			}

			lineaflujocajaReturnGeneral.settipolineaflujocajasForeignKey(tipolineaflujocajasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return lineaflujocajaReturnGeneral;
	}
	
	
	public void deepLoad(LineaFlujoCaja lineaflujocaja,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			LineaFlujoCajaLogicAdditional.updateLineaFlujoCajaToGet(lineaflujocaja,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		lineaflujocaja.setEmpresa(lineaflujocajaDataAccess.getEmpresa(connexion,lineaflujocaja));
		lineaflujocaja.setTipoGrupoFlujoCaja(lineaflujocajaDataAccess.getTipoGrupoFlujoCaja(connexion,lineaflujocaja));
		lineaflujocaja.setTipoLineaFlujoCaja(lineaflujocajaDataAccess.getTipoLineaFlujoCaja(connexion,lineaflujocaja));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				lineaflujocaja.setEmpresa(lineaflujocajaDataAccess.getEmpresa(connexion,lineaflujocaja));
				continue;
			}

			if(clas.clas.equals(TipoGrupoFlujoCaja.class)) {
				lineaflujocaja.setTipoGrupoFlujoCaja(lineaflujocajaDataAccess.getTipoGrupoFlujoCaja(connexion,lineaflujocaja));
				continue;
			}

			if(clas.clas.equals(TipoLineaFlujoCaja.class)) {
				lineaflujocaja.setTipoLineaFlujoCaja(lineaflujocajaDataAccess.getTipoLineaFlujoCaja(connexion,lineaflujocaja));
				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			lineaflujocaja.setEmpresa(lineaflujocajaDataAccess.getEmpresa(connexion,lineaflujocaja));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoGrupoFlujoCaja.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			lineaflujocaja.setTipoGrupoFlujoCaja(lineaflujocajaDataAccess.getTipoGrupoFlujoCaja(connexion,lineaflujocaja));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(TipoLineaFlujoCaja.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			lineaflujocaja.setTipoLineaFlujoCaja(lineaflujocajaDataAccess.getTipoLineaFlujoCaja(connexion,lineaflujocaja));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		lineaflujocaja.setEmpresa(lineaflujocajaDataAccess.getEmpresa(connexion,lineaflujocaja));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(lineaflujocaja.getEmpresa(),isDeep,deepLoadType,clases);
				
		lineaflujocaja.setTipoGrupoFlujoCaja(lineaflujocajaDataAccess.getTipoGrupoFlujoCaja(connexion,lineaflujocaja));
		TipoGrupoFlujoCajaLogic tipogrupoflujocajaLogic= new TipoGrupoFlujoCajaLogic(connexion);
		tipogrupoflujocajaLogic.deepLoad(lineaflujocaja.getTipoGrupoFlujoCaja(),isDeep,deepLoadType,clases);
				
		lineaflujocaja.setTipoLineaFlujoCaja(lineaflujocajaDataAccess.getTipoLineaFlujoCaja(connexion,lineaflujocaja));
		TipoLineaFlujoCajaLogic tipolineaflujocajaLogic= new TipoLineaFlujoCajaLogic(connexion);
		tipolineaflujocajaLogic.deepLoad(lineaflujocaja.getTipoLineaFlujoCaja(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				lineaflujocaja.setEmpresa(lineaflujocajaDataAccess.getEmpresa(connexion,lineaflujocaja));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(lineaflujocaja.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoGrupoFlujoCaja.class)) {
				lineaflujocaja.setTipoGrupoFlujoCaja(lineaflujocajaDataAccess.getTipoGrupoFlujoCaja(connexion,lineaflujocaja));
				TipoGrupoFlujoCajaLogic tipogrupoflujocajaLogic= new TipoGrupoFlujoCajaLogic(connexion);
				tipogrupoflujocajaLogic.deepLoad(lineaflujocaja.getTipoGrupoFlujoCaja(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoLineaFlujoCaja.class)) {
				lineaflujocaja.setTipoLineaFlujoCaja(lineaflujocajaDataAccess.getTipoLineaFlujoCaja(connexion,lineaflujocaja));
				TipoLineaFlujoCajaLogic tipolineaflujocajaLogic= new TipoLineaFlujoCajaLogic(connexion);
				tipolineaflujocajaLogic.deepLoad(lineaflujocaja.getTipoLineaFlujoCaja(),isDeep,deepLoadType,clases);				
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			lineaflujocaja.setEmpresa(lineaflujocajaDataAccess.getEmpresa(connexion,lineaflujocaja));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(lineaflujocaja.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoGrupoFlujoCaja.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			lineaflujocaja.setTipoGrupoFlujoCaja(lineaflujocajaDataAccess.getTipoGrupoFlujoCaja(connexion,lineaflujocaja));
			TipoGrupoFlujoCajaLogic tipogrupoflujocajaLogic= new TipoGrupoFlujoCajaLogic(connexion);
			tipogrupoflujocajaLogic.deepLoad(lineaflujocaja.getTipoGrupoFlujoCaja(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(TipoLineaFlujoCaja.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			lineaflujocaja.setTipoLineaFlujoCaja(lineaflujocajaDataAccess.getTipoLineaFlujoCaja(connexion,lineaflujocaja));
			TipoLineaFlujoCajaLogic tipolineaflujocajaLogic= new TipoLineaFlujoCajaLogic(connexion);
			tipolineaflujocajaLogic.deepLoad(lineaflujocaja.getTipoLineaFlujoCaja(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(LineaFlujoCaja lineaflujocaja,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			LineaFlujoCajaLogicAdditional.updateLineaFlujoCajaToSave(lineaflujocaja,this.arrDatoGeneral);
			
LineaFlujoCajaDataAccess.save(lineaflujocaja, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(lineaflujocaja.getEmpresa(),connexion);

		TipoGrupoFlujoCajaDataAccess.save(lineaflujocaja.getTipoGrupoFlujoCaja(),connexion);

		TipoLineaFlujoCajaDataAccess.save(lineaflujocaja.getTipoLineaFlujoCaja(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(lineaflujocaja.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoGrupoFlujoCaja.class)) {
				TipoGrupoFlujoCajaDataAccess.save(lineaflujocaja.getTipoGrupoFlujoCaja(),connexion);
				continue;
			}

			if(clas.clas.equals(TipoLineaFlujoCaja.class)) {
				TipoLineaFlujoCajaDataAccess.save(lineaflujocaja.getTipoLineaFlujoCaja(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(lineaflujocaja.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(lineaflujocaja.getEmpresa(),isDeep,deepLoadType,clases);
				

		TipoGrupoFlujoCajaDataAccess.save(lineaflujocaja.getTipoGrupoFlujoCaja(),connexion);
		TipoGrupoFlujoCajaLogic tipogrupoflujocajaLogic= new TipoGrupoFlujoCajaLogic(connexion);
		tipogrupoflujocajaLogic.deepLoad(lineaflujocaja.getTipoGrupoFlujoCaja(),isDeep,deepLoadType,clases);
				

		TipoLineaFlujoCajaDataAccess.save(lineaflujocaja.getTipoLineaFlujoCaja(),connexion);
		TipoLineaFlujoCajaLogic tipolineaflujocajaLogic= new TipoLineaFlujoCajaLogic(connexion);
		tipolineaflujocajaLogic.deepLoad(lineaflujocaja.getTipoLineaFlujoCaja(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(lineaflujocaja.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(lineaflujocaja.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoGrupoFlujoCaja.class)) {
				TipoGrupoFlujoCajaDataAccess.save(lineaflujocaja.getTipoGrupoFlujoCaja(),connexion);
				TipoGrupoFlujoCajaLogic tipogrupoflujocajaLogic= new TipoGrupoFlujoCajaLogic(connexion);
				tipogrupoflujocajaLogic.deepSave(lineaflujocaja.getTipoGrupoFlujoCaja(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(TipoLineaFlujoCaja.class)) {
				TipoLineaFlujoCajaDataAccess.save(lineaflujocaja.getTipoLineaFlujoCaja(),connexion);
				TipoLineaFlujoCajaLogic tipolineaflujocajaLogic= new TipoLineaFlujoCajaLogic(connexion);
				tipolineaflujocajaLogic.deepSave(lineaflujocaja.getTipoLineaFlujoCaja(),isDeep,deepLoadType,clases);				
				continue;
			}

		}
	}

	}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}	
	}
	
	public void deepLoadWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(LineaFlujoCaja.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(lineaflujocaja,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				LineaFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesLineaFlujoCaja(lineaflujocaja);
			}
			
			this.connexion.commit();
			
		} catch(Exception e) {
			connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			this.closeNewConnexionToDeep();
  		}
	}
	
	public void deepLoad(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.deepLoad(this.lineaflujocaja,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				LineaFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesLineaFlujoCaja(this.lineaflujocaja);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(LineaFlujoCaja.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(lineaflujocajas!=null) {
				for(LineaFlujoCaja lineaflujocaja:lineaflujocajas) {
					this.deepLoad(lineaflujocaja,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					LineaFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesLineaFlujoCaja(lineaflujocajas);
				}
			}
			
			this.connexion.commit();
			
		} catch(Exception e) {
			connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			this.closeNewConnexionToDeep();
  		}
	}
	
	public void deepLoads(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {			
			if(lineaflujocajas!=null) {
				for(LineaFlujoCaja lineaflujocaja:lineaflujocajas) {
					this.deepLoad(lineaflujocaja,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					LineaFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesLineaFlujoCaja(lineaflujocajas);
				}	
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
		
	public void deepSaveWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {	
			this.getNewConnexionToDeep(LineaFlujoCaja.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(lineaflujocaja,isDeep,deepLoadType,clases);	
			
			this.connexion.commit();
		} catch(Exception e) {			
			connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			this.closeNewConnexionToDeep();
  		}
	}
	
	public void deepSavesWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {			
			this.getNewConnexionToDeep(LineaFlujoCaja.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(lineaflujocajas!=null) {
				for(LineaFlujoCaja lineaflujocaja:lineaflujocajas) {
					this.deepSave(lineaflujocaja,isDeep,deepLoadType,clases);
				}
			}
			this.connexion.commit();
			
		} catch(Exception e) {
			connexion.rollback();
			Funciones.manageException(logger,e);
			throw e;
			
  		}finally {
			this.closeNewConnexionToDeep();
  		}
	}
	
	public void deepSaves(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {	
			if(lineaflujocajas!=null) {
				for(LineaFlujoCaja lineaflujocaja:lineaflujocajas) {
					this.deepSave(lineaflujocaja,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getLineaFlujoCajasBusquedaPorCodigoWithConnection(String sFinalQuery,Pagination pagination,String codigo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LineaFlujoCaja.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+codigo+"%",LineaFlujoCajaConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			LineaFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorCodigo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			lineaflujocajas=lineaflujocajaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				LineaFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesLineaFlujoCaja(this.lineaflujocajas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getLineaFlujoCajasBusquedaPorCodigo(String sFinalQuery,Pagination pagination,String codigo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralCodigo= new ParameterSelectionGeneral();
			parameterSelectionGeneralCodigo.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+codigo+"%",LineaFlujoCajaConstantesFunciones.CODIGO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralCodigo);

			LineaFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorCodigo","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			lineaflujocajas=lineaflujocajaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				LineaFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesLineaFlujoCaja(this.lineaflujocajas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getLineaFlujoCajasBusquedaPorNombreWithConnection(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LineaFlujoCaja.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",LineaFlujoCajaConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			LineaFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			lineaflujocajas=lineaflujocajaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				LineaFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesLineaFlujoCaja(this.lineaflujocajas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getLineaFlujoCajasBusquedaPorNombre(String sFinalQuery,Pagination pagination,String nombre)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralNombre= new ParameterSelectionGeneral();
			parameterSelectionGeneralNombre.setParameterSelectionGeneralLike(ParameterType.STRING,"%"+nombre+"%",LineaFlujoCajaConstantesFunciones.NOMBRE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralNombre);

			LineaFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"BusquedaPorNombre","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			lineaflujocajas=lineaflujocajaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				LineaFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesLineaFlujoCaja(this.lineaflujocajas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getLineaFlujoCajasFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LineaFlujoCaja.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,LineaFlujoCajaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			LineaFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			lineaflujocajas=lineaflujocajaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				LineaFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesLineaFlujoCaja(this.lineaflujocajas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getLineaFlujoCajasFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,LineaFlujoCajaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			LineaFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			lineaflujocajas=lineaflujocajaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				LineaFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesLineaFlujoCaja(this.lineaflujocajas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getLineaFlujoCajasFK_IdTipoGrupoFlujoCajaWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_grupo_flujo_caja)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LineaFlujoCaja.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoGrupoFlujoCaja= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoGrupoFlujoCaja.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_grupo_flujo_caja,LineaFlujoCajaConstantesFunciones.IDTIPOGRUPOFLUJOCAJA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoGrupoFlujoCaja);

			LineaFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoGrupoFlujoCaja","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			lineaflujocajas=lineaflujocajaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				LineaFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesLineaFlujoCaja(this.lineaflujocajas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getLineaFlujoCajasFK_IdTipoGrupoFlujoCaja(String sFinalQuery,Pagination pagination,Long id_tipo_grupo_flujo_caja)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoGrupoFlujoCaja= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoGrupoFlujoCaja.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_grupo_flujo_caja,LineaFlujoCajaConstantesFunciones.IDTIPOGRUPOFLUJOCAJA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoGrupoFlujoCaja);

			LineaFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoGrupoFlujoCaja","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			lineaflujocajas=lineaflujocajaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				LineaFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesLineaFlujoCaja(this.lineaflujocajas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getLineaFlujoCajasFK_IdTipoLineaFlujoCajaWithConnection(String sFinalQuery,Pagination pagination,Long id_tipo_linea_flujo_caja)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LineaFlujoCaja.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoLineaFlujoCaja= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoLineaFlujoCaja.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_linea_flujo_caja,LineaFlujoCajaConstantesFunciones.IDTIPOLINEAFLUJOCAJA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoLineaFlujoCaja);

			LineaFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoLineaFlujoCaja","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			lineaflujocajas=lineaflujocajaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				LineaFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesLineaFlujoCaja(this.lineaflujocajas);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getLineaFlujoCajasFK_IdTipoLineaFlujoCaja(String sFinalQuery,Pagination pagination,Long id_tipo_linea_flujo_caja)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoLineaFlujoCaja= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoLineaFlujoCaja.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_linea_flujo_caja,LineaFlujoCajaConstantesFunciones.IDTIPOLINEAFLUJOCAJA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoLineaFlujoCaja);

			LineaFlujoCajaLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdTipoLineaFlujoCaja","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			lineaflujocajas=lineaflujocajaDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				LineaFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesLineaFlujoCaja(this.lineaflujocajas);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getLineaFlujoCajaPorEmpresaPorTipoLineaFlujoWithConnection(Long id_empresa,Long id_tipo_linea_flujo_caja)throws Exception {
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LineaFlujoCaja.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,LineaFlujoCajaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoLineaFlujoCaja= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoLineaFlujoCaja.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_linea_flujo_caja,LineaFlujoCajaConstantesFunciones.IDTIPOLINEAFLUJOCAJA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoLineaFlujoCaja);

			lineaflujocaja=lineaflujocajaDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.lineaflujocaja,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				LineaFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesLineaFlujoCaja(this.lineaflujocaja);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getLineaFlujoCajaPorEmpresaPorTipoLineaFlujo(Long id_empresa,Long id_tipo_linea_flujo_caja)throws Exception {
		try {

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,LineaFlujoCajaConstantesFunciones.IDEMPRESA,ParameterTypeOperator.AND);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			ParameterSelectionGeneral parameterSelectionGeneralidTipoLineaFlujoCaja= new ParameterSelectionGeneral();
			parameterSelectionGeneralidTipoLineaFlujoCaja.setParameterSelectionGeneralEqual(ParameterType.LONG,id_tipo_linea_flujo_caja,LineaFlujoCajaConstantesFunciones.IDTIPOLINEAFLUJOCAJA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidTipoLineaFlujoCaja);

			lineaflujocaja=lineaflujocajaDataAccess.getEntity(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoad(this.lineaflujocaja,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());

				LineaFlujoCajaConstantesFunciones.refrescarForeignKeysDescripcionesLineaFlujoCaja(this.lineaflujocaja);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,String sProcesoBusqueda,String sDetalleProcesoBusqueda,QueryWhereSelectParameters queryWhereSelectParameters,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(LineaFlujoCajaConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,LineaFlujoCajaDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,LineaFlujoCaja lineaflujocaja,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(LineaFlujoCajaConstantesFunciones.ISCONAUDITORIA) {
				if(lineaflujocaja.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,LineaFlujoCajaDataAccess.TABLENAME, lineaflujocaja.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(LineaFlujoCajaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////LineaFlujoCajaLogic.registrarAuditoriaDetallesLineaFlujoCaja(connexion,lineaflujocaja,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(lineaflujocaja.getIsDeleted()) {
					/*if(!lineaflujocaja.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,LineaFlujoCajaDataAccess.TABLENAME, lineaflujocaja.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////LineaFlujoCajaLogic.registrarAuditoriaDetallesLineaFlujoCaja(connexion,lineaflujocaja,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,LineaFlujoCajaDataAccess.TABLENAME, lineaflujocaja.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(lineaflujocaja.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,LineaFlujoCajaDataAccess.TABLENAME, lineaflujocaja.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(LineaFlujoCajaConstantesFunciones.ISCONAUDITORIADETALLE) {
						////LineaFlujoCajaLogic.registrarAuditoriaDetallesLineaFlujoCaja(connexion,lineaflujocaja,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesLineaFlujoCaja(Connexion connexion,LineaFlujoCaja lineaflujocaja)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(lineaflujocaja.getIsNew()||!lineaflujocaja.getid_empresa().equals(lineaflujocaja.getLineaFlujoCajaOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(lineaflujocaja.getLineaFlujoCajaOriginal().getid_empresa()!=null)
				{
					strValorActual=lineaflujocaja.getLineaFlujoCajaOriginal().getid_empresa().toString();
				}
				if(lineaflujocaja.getid_empresa()!=null)
				{
					strValorNuevo=lineaflujocaja.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),LineaFlujoCajaConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(lineaflujocaja.getIsNew()||!lineaflujocaja.getid_tipo_grupo_flujo_caja().equals(lineaflujocaja.getLineaFlujoCajaOriginal().getid_tipo_grupo_flujo_caja()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(lineaflujocaja.getLineaFlujoCajaOriginal().getid_tipo_grupo_flujo_caja()!=null)
				{
					strValorActual=lineaflujocaja.getLineaFlujoCajaOriginal().getid_tipo_grupo_flujo_caja().toString();
				}
				if(lineaflujocaja.getid_tipo_grupo_flujo_caja()!=null)
				{
					strValorNuevo=lineaflujocaja.getid_tipo_grupo_flujo_caja().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),LineaFlujoCajaConstantesFunciones.IDTIPOGRUPOFLUJOCAJA,strValorActual,strValorNuevo);
			}	
			
			if(lineaflujocaja.getIsNew()||!lineaflujocaja.getcodigo().equals(lineaflujocaja.getLineaFlujoCajaOriginal().getcodigo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(lineaflujocaja.getLineaFlujoCajaOriginal().getcodigo()!=null)
				{
					strValorActual=lineaflujocaja.getLineaFlujoCajaOriginal().getcodigo();
				}
				if(lineaflujocaja.getcodigo()!=null)
				{
					strValorNuevo=lineaflujocaja.getcodigo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),LineaFlujoCajaConstantesFunciones.CODIGO,strValorActual,strValorNuevo);
			}	
			
			if(lineaflujocaja.getIsNew()||!lineaflujocaja.getnombre().equals(lineaflujocaja.getLineaFlujoCajaOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(lineaflujocaja.getLineaFlujoCajaOriginal().getnombre()!=null)
				{
					strValorActual=lineaflujocaja.getLineaFlujoCajaOriginal().getnombre();
				}
				if(lineaflujocaja.getnombre()!=null)
				{
					strValorNuevo=lineaflujocaja.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),LineaFlujoCajaConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(lineaflujocaja.getIsNew()||!lineaflujocaja.getid_tipo_linea_flujo_caja().equals(lineaflujocaja.getLineaFlujoCajaOriginal().getid_tipo_linea_flujo_caja()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(lineaflujocaja.getLineaFlujoCajaOriginal().getid_tipo_linea_flujo_caja()!=null)
				{
					strValorActual=lineaflujocaja.getLineaFlujoCajaOriginal().getid_tipo_linea_flujo_caja().toString();
				}
				if(lineaflujocaja.getid_tipo_linea_flujo_caja()!=null)
				{
					strValorNuevo=lineaflujocaja.getid_tipo_linea_flujo_caja().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),LineaFlujoCajaConstantesFunciones.IDTIPOLINEAFLUJOCAJA,strValorActual,strValorNuevo);
			}	
			
			if(lineaflujocaja.getIsNew()||!lineaflujocaja.getes_consolidado().equals(lineaflujocaja.getLineaFlujoCajaOriginal().getes_consolidado()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(lineaflujocaja.getLineaFlujoCajaOriginal().getes_consolidado()!=null)
				{
					strValorActual=lineaflujocaja.getLineaFlujoCajaOriginal().getes_consolidado().toString();
				}
				if(lineaflujocaja.getes_consolidado()!=null)
				{
					strValorNuevo=lineaflujocaja.getes_consolidado().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),LineaFlujoCajaConstantesFunciones.ESCONSOLIDADO,strValorActual,strValorNuevo);
			}	
			
			if(lineaflujocaja.getIsNew()||!lineaflujocaja.getesta_proyeccion().equals(lineaflujocaja.getLineaFlujoCajaOriginal().getesta_proyeccion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(lineaflujocaja.getLineaFlujoCajaOriginal().getesta_proyeccion()!=null)
				{
					strValorActual=lineaflujocaja.getLineaFlujoCajaOriginal().getesta_proyeccion().toString();
				}
				if(lineaflujocaja.getesta_proyeccion()!=null)
				{
					strValorNuevo=lineaflujocaja.getesta_proyeccion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),LineaFlujoCajaConstantesFunciones.ESTAPROYECCION,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveLineaFlujoCajaRelacionesWithConnection(LineaFlujoCaja lineaflujocaja) throws Exception {

		if(!lineaflujocaja.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveLineaFlujoCajaRelacionesBase(lineaflujocaja,true);
		}
	}

	public void saveLineaFlujoCajaRelaciones(LineaFlujoCaja lineaflujocaja)throws Exception {

		if(!lineaflujocaja.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveLineaFlujoCajaRelacionesBase(lineaflujocaja,false);
		}
	}

	public void saveLineaFlujoCajaRelacionesBase(LineaFlujoCaja lineaflujocaja,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("LineaFlujoCaja-saveRelacionesWithConnection");}
	

			this.setLineaFlujoCaja(lineaflujocaja);

			if(LineaFlujoCajaLogicAdditional.validarSaveRelaciones(lineaflujocaja,this)) {

				LineaFlujoCajaLogicAdditional.updateRelacionesToSave(lineaflujocaja,this);

				if((lineaflujocaja.getIsNew()||lineaflujocaja.getIsChanged())&&!lineaflujocaja.getIsDeleted()) {
					this.saveLineaFlujoCaja();
					this.saveLineaFlujoCajaRelacionesDetalles();

				} else if(lineaflujocaja.getIsDeleted()) {
					this.saveLineaFlujoCajaRelacionesDetalles();
					this.saveLineaFlujoCaja();
				}

				LineaFlujoCajaLogicAdditional.updateRelacionesToSaveAfter(lineaflujocaja,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveLineaFlujoCajaRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfLineaFlujoCaja(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=LineaFlujoCajaConstantesFunciones.getClassesForeignKeysOfLineaFlujoCaja(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfLineaFlujoCaja(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=LineaFlujoCajaConstantesFunciones.getClassesRelationshipsOfLineaFlujoCaja(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
