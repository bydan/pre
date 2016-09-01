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
package com.bydan.erp.puntoventa.business.logic;

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
import com.bydan.erp.puntoventa.util.*;
import com.bydan.erp.puntoventa.util.CajaIngresoDetalleConstantesFunciones;
import com.bydan.erp.puntoventa.util.CajaIngresoDetalleParameterReturnGeneral;
//import com.bydan.erp.puntoventa.util.CajaIngresoDetalleParameterGeneral;
import com.bydan.erp.puntoventa.business.entity.CajaIngresoDetalle;
import com.bydan.erp.puntoventa.business.logic.CajaIngresoDetalleLogicAdditional;
import com.bydan.erp.puntoventa.business.dataaccess.*;
import com.bydan.erp.puntoventa.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.cartera.business.logic.*;
import com.bydan.erp.facturacion.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.facturacion.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;








@SuppressWarnings("unused")
public class CajaIngresoDetalleLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(CajaIngresoDetalleLogic.class);
	
	protected CajaIngresoDetalleDataAccess cajaingresodetalleDataAccess; 	
	protected CajaIngresoDetalle cajaingresodetalle;
	protected List<CajaIngresoDetalle> cajaingresodetalles;
	protected Object cajaingresodetalleObject;	
	protected List<Object> cajaingresodetallesObject;
	
	public static ClassValidator<CajaIngresoDetalle> cajaingresodetalleValidator = new ClassValidator<CajaIngresoDetalle>(CajaIngresoDetalle.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected CajaIngresoDetalleLogicAdditional cajaingresodetalleLogicAdditional=null;
	
	public CajaIngresoDetalleLogicAdditional getCajaIngresoDetalleLogicAdditional() {
		return this.cajaingresodetalleLogicAdditional;
	}
	
	public void setCajaIngresoDetalleLogicAdditional(CajaIngresoDetalleLogicAdditional cajaingresodetalleLogicAdditional) {
		try {
			this.cajaingresodetalleLogicAdditional=cajaingresodetalleLogicAdditional;
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
	
	
	
	
	public  CajaIngresoDetalleLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.cajaingresodetalleDataAccess = new CajaIngresoDetalleDataAccess();
			
			this.cajaingresodetalles= new ArrayList<CajaIngresoDetalle>();
			this.cajaingresodetalle= new CajaIngresoDetalle();
			
			this.cajaingresodetalleObject=new Object();
			this.cajaingresodetallesObject=new ArrayList<Object>();
				
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
			
			this.cajaingresodetalleDataAccess.setConnexionType(this.connexionType);
			this.cajaingresodetalleDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  CajaIngresoDetalleLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.cajaingresodetalleDataAccess = new CajaIngresoDetalleDataAccess();
			this.cajaingresodetalles= new ArrayList<CajaIngresoDetalle>();
			this.cajaingresodetalle= new CajaIngresoDetalle();
			this.cajaingresodetalleObject=new Object();
			this.cajaingresodetallesObject=new ArrayList<Object>();
			
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
			
			this.cajaingresodetalleDataAccess.setConnexionType(this.connexionType);
			this.cajaingresodetalleDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public CajaIngresoDetalle getCajaIngresoDetalle() throws Exception {	
		CajaIngresoDetalleLogicAdditional.checkCajaIngresoDetalleToGet(cajaingresodetalle,this.datosCliente,this.arrDatoGeneral);
		CajaIngresoDetalleLogicAdditional.updateCajaIngresoDetalleToGet(cajaingresodetalle,this.arrDatoGeneral);
		
		return cajaingresodetalle;
	}
		
	public void setCajaIngresoDetalle(CajaIngresoDetalle newCajaIngresoDetalle) {
		this.cajaingresodetalle = newCajaIngresoDetalle;
	}
	
	public CajaIngresoDetalleDataAccess getCajaIngresoDetalleDataAccess() {
		return cajaingresodetalleDataAccess;
	}
	
	public void setCajaIngresoDetalleDataAccess(CajaIngresoDetalleDataAccess newcajaingresodetalleDataAccess) {
		this.cajaingresodetalleDataAccess = newcajaingresodetalleDataAccess;
	}
	
	public List<CajaIngresoDetalle> getCajaIngresoDetalles() throws Exception {		
		this.quitarCajaIngresoDetallesNulos();
		
		CajaIngresoDetalleLogicAdditional.checkCajaIngresoDetalleToGets(cajaingresodetalles,this.datosCliente,this.arrDatoGeneral);
		
		for (CajaIngresoDetalle cajaingresodetalleLocal: cajaingresodetalles ) {
			CajaIngresoDetalleLogicAdditional.updateCajaIngresoDetalleToGet(cajaingresodetalleLocal,this.arrDatoGeneral);
		}
		
		return cajaingresodetalles;
	}
	
	public void setCajaIngresoDetalles(List<CajaIngresoDetalle> newCajaIngresoDetalles) {
		this.cajaingresodetalles = newCajaIngresoDetalles;
	}
	
	public Object getCajaIngresoDetalleObject() {	
		this.cajaingresodetalleObject=this.cajaingresodetalleDataAccess.getEntityObject();
		return this.cajaingresodetalleObject;
	}
		
	public void setCajaIngresoDetalleObject(Object newCajaIngresoDetalleObject) {
		this.cajaingresodetalleObject = newCajaIngresoDetalleObject;
	}
	
	public List<Object> getCajaIngresoDetallesObject() {		
		this.cajaingresodetallesObject=this.cajaingresodetalleDataAccess.getEntitiesObject();
		return this.cajaingresodetallesObject;
	}
		
	public void setCajaIngresoDetallesObject(List<Object> newCajaIngresoDetallesObject) {
		this.cajaingresodetallesObject = newCajaIngresoDetallesObject;
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
		
		if(this.cajaingresodetalleDataAccess!=null) {
			this.cajaingresodetalleDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CajaIngresoDetalle.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			cajaingresodetalleDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			cajaingresodetalleDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		cajaingresodetalle = new  CajaIngresoDetalle();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CajaIngresoDetalle.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			cajaingresodetalle=cajaingresodetalleDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.cajaingresodetalle,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CajaIngresoDetalleConstantesFunciones.refrescarForeignKeysDescripcionesCajaIngresoDetalle(this.cajaingresodetalle);
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
		cajaingresodetalle = new  CajaIngresoDetalle();
		  		  
        try {
			
			cajaingresodetalle=cajaingresodetalleDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.cajaingresodetalle,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CajaIngresoDetalleConstantesFunciones.refrescarForeignKeysDescripcionesCajaIngresoDetalle(this.cajaingresodetalle);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		cajaingresodetalle = new  CajaIngresoDetalle();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CajaIngresoDetalle.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			cajaingresodetalle=cajaingresodetalleDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.cajaingresodetalle,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CajaIngresoDetalleConstantesFunciones.refrescarForeignKeysDescripcionesCajaIngresoDetalle(this.cajaingresodetalle);
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
		cajaingresodetalle = new  CajaIngresoDetalle();
		  		  
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
		cajaingresodetalle = new  CajaIngresoDetalle();
		  		  
        try {
			
			cajaingresodetalle=cajaingresodetalleDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.cajaingresodetalle,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CajaIngresoDetalleConstantesFunciones.refrescarForeignKeysDescripcionesCajaIngresoDetalle(this.cajaingresodetalle);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		cajaingresodetalle = new  CajaIngresoDetalle();
		  		  
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
		cajaingresodetalle = new  CajaIngresoDetalle();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CajaIngresoDetalle.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =cajaingresodetalleDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		cajaingresodetalle = new  CajaIngresoDetalle();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=cajaingresodetalleDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		cajaingresodetalle = new  CajaIngresoDetalle();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CajaIngresoDetalle.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =cajaingresodetalleDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		cajaingresodetalle = new  CajaIngresoDetalle();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=cajaingresodetalleDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		cajaingresodetalle = new  CajaIngresoDetalle();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CajaIngresoDetalle.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =cajaingresodetalleDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		cajaingresodetalle = new  CajaIngresoDetalle();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=cajaingresodetalleDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		cajaingresodetalles = new  ArrayList<CajaIngresoDetalle>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CajaIngresoDetalle.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			CajaIngresoDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cajaingresodetalles=cajaingresodetalleDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCajaIngresoDetalle(cajaingresodetalles);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CajaIngresoDetalleConstantesFunciones.refrescarForeignKeysDescripcionesCajaIngresoDetalle(this.cajaingresodetalles);
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
		cajaingresodetalles = new  ArrayList<CajaIngresoDetalle>();
		  		  
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
		cajaingresodetalles = new  ArrayList<CajaIngresoDetalle>();
		  		  
        try {			
			CajaIngresoDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cajaingresodetalles=cajaingresodetalleDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarCajaIngresoDetalle(cajaingresodetalles);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CajaIngresoDetalleConstantesFunciones.refrescarForeignKeysDescripcionesCajaIngresoDetalle(this.cajaingresodetalles);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		cajaingresodetalles = new  ArrayList<CajaIngresoDetalle>();
		  		  
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
		cajaingresodetalles = new  ArrayList<CajaIngresoDetalle>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CajaIngresoDetalle.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			CajaIngresoDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cajaingresodetalles=cajaingresodetalleDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCajaIngresoDetalle(cajaingresodetalles);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CajaIngresoDetalleConstantesFunciones.refrescarForeignKeysDescripcionesCajaIngresoDetalle(this.cajaingresodetalles);
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
		cajaingresodetalles = new  ArrayList<CajaIngresoDetalle>();
		  		  
        try {
			CajaIngresoDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cajaingresodetalles=cajaingresodetalleDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCajaIngresoDetalle(cajaingresodetalles);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CajaIngresoDetalleConstantesFunciones.refrescarForeignKeysDescripcionesCajaIngresoDetalle(this.cajaingresodetalles);
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
		cajaingresodetalles = new  ArrayList<CajaIngresoDetalle>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CajaIngresoDetalle.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CajaIngresoDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cajaingresodetalles=cajaingresodetalleDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCajaIngresoDetalle(cajaingresodetalles);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CajaIngresoDetalleConstantesFunciones.refrescarForeignKeysDescripcionesCajaIngresoDetalle(this.cajaingresodetalles);
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
		cajaingresodetalles = new  ArrayList<CajaIngresoDetalle>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CajaIngresoDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cajaingresodetalles=cajaingresodetalleDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCajaIngresoDetalle(cajaingresodetalles);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CajaIngresoDetalleConstantesFunciones.refrescarForeignKeysDescripcionesCajaIngresoDetalle(this.cajaingresodetalles);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		cajaingresodetalle = new  CajaIngresoDetalle();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CajaIngresoDetalle.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CajaIngresoDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cajaingresodetalle=cajaingresodetalleDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCajaIngresoDetalle(cajaingresodetalle);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CajaIngresoDetalleConstantesFunciones.refrescarForeignKeysDescripcionesCajaIngresoDetalle(this.cajaingresodetalle);
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
		cajaingresodetalle = new  CajaIngresoDetalle();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CajaIngresoDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cajaingresodetalle=cajaingresodetalleDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCajaIngresoDetalle(cajaingresodetalle);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CajaIngresoDetalleConstantesFunciones.refrescarForeignKeysDescripcionesCajaIngresoDetalle(this.cajaingresodetalle);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		cajaingresodetalles = new  ArrayList<CajaIngresoDetalle>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CajaIngresoDetalle.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			CajaIngresoDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cajaingresodetalles=cajaingresodetalleDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCajaIngresoDetalle(cajaingresodetalles);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CajaIngresoDetalleConstantesFunciones.refrescarForeignKeysDescripcionesCajaIngresoDetalle(this.cajaingresodetalles);
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
		cajaingresodetalles = new  ArrayList<CajaIngresoDetalle>();
		  		  
        try {
			CajaIngresoDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cajaingresodetalles=cajaingresodetalleDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCajaIngresoDetalle(cajaingresodetalles);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CajaIngresoDetalleConstantesFunciones.refrescarForeignKeysDescripcionesCajaIngresoDetalle(this.cajaingresodetalles);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosCajaIngresoDetallesWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		cajaingresodetalles = new  ArrayList<CajaIngresoDetalle>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CajaIngresoDetalle.class.getSimpleName()+"-getTodosCajaIngresoDetallesWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CajaIngresoDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cajaingresodetalles=cajaingresodetalleDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarCajaIngresoDetalle(cajaingresodetalles);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CajaIngresoDetalleConstantesFunciones.refrescarForeignKeysDescripcionesCajaIngresoDetalle(this.cajaingresodetalles);
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
	
	public  void  getTodosCajaIngresoDetalles(String sFinalQuery,Pagination pagination)throws Exception {
		cajaingresodetalles = new  ArrayList<CajaIngresoDetalle>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CajaIngresoDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cajaingresodetalles=cajaingresodetalleDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarCajaIngresoDetalle(cajaingresodetalles);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CajaIngresoDetalleConstantesFunciones.refrescarForeignKeysDescripcionesCajaIngresoDetalle(this.cajaingresodetalles);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarCajaIngresoDetalle(CajaIngresoDetalle cajaingresodetalle) throws Exception {
		Boolean estaValidado=false;
		
		if(cajaingresodetalle.getIsNew() || cajaingresodetalle.getIsChanged()) { 
			this.invalidValues = cajaingresodetalleValidator.getInvalidValues(cajaingresodetalle);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(cajaingresodetalle);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarCajaIngresoDetalle(List<CajaIngresoDetalle> CajaIngresoDetalles) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(CajaIngresoDetalle cajaingresodetalleLocal:cajaingresodetalles) {				
			estaValidadoObjeto=this.validarGuardarCajaIngresoDetalle(cajaingresodetalleLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarCajaIngresoDetalle(List<CajaIngresoDetalle> CajaIngresoDetalles) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarCajaIngresoDetalle(cajaingresodetalles)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarCajaIngresoDetalle(CajaIngresoDetalle CajaIngresoDetalle) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarCajaIngresoDetalle(cajaingresodetalle)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(CajaIngresoDetalle cajaingresodetalle) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+cajaingresodetalle.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=CajaIngresoDetalleConstantesFunciones.getCajaIngresoDetalleLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"cajaingresodetalle","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(CajaIngresoDetalleConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(CajaIngresoDetalleConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveCajaIngresoDetalleWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CajaIngresoDetalle.class.getSimpleName()+"-saveCajaIngresoDetalleWithConnection");connexion.begin();			
			
			CajaIngresoDetalleLogicAdditional.checkCajaIngresoDetalleToSave(this.cajaingresodetalle,this.datosCliente,connexion,this.arrDatoGeneral);
			
			CajaIngresoDetalleLogicAdditional.updateCajaIngresoDetalleToSave(this.cajaingresodetalle,this.arrDatoGeneral);
			
			CajaIngresoDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.cajaingresodetalle,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowCajaIngresoDetalle();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarCajaIngresoDetalle(this.cajaingresodetalle)) {
				CajaIngresoDetalleDataAccess.save(this.cajaingresodetalle, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.cajaingresodetalle,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			CajaIngresoDetalleLogicAdditional.checkCajaIngresoDetalleToSaveAfter(this.cajaingresodetalle,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowCajaIngresoDetalle();
			
			connexion.commit();			
			
			if(this.cajaingresodetalle.getIsDeleted()) {
				this.cajaingresodetalle=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveCajaIngresoDetalle()throws Exception {	
		try {	
			
			CajaIngresoDetalleLogicAdditional.checkCajaIngresoDetalleToSave(this.cajaingresodetalle,this.datosCliente,connexion,this.arrDatoGeneral);
			
			CajaIngresoDetalleLogicAdditional.updateCajaIngresoDetalleToSave(this.cajaingresodetalle,this.arrDatoGeneral);
			
			CajaIngresoDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.cajaingresodetalle,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarCajaIngresoDetalle(this.cajaingresodetalle)) {			
				CajaIngresoDetalleDataAccess.save(this.cajaingresodetalle, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.cajaingresodetalle,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			CajaIngresoDetalleLogicAdditional.checkCajaIngresoDetalleToSaveAfter(this.cajaingresodetalle,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.cajaingresodetalle.getIsDeleted()) {
				this.cajaingresodetalle=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveCajaIngresoDetallesWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CajaIngresoDetalle.class.getSimpleName()+"-saveCajaIngresoDetallesWithConnection");connexion.begin();			
			
			CajaIngresoDetalleLogicAdditional.checkCajaIngresoDetalleToSaves(cajaingresodetalles,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowCajaIngresoDetalles();
			
			Boolean validadoTodosCajaIngresoDetalle=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(CajaIngresoDetalle cajaingresodetalleLocal:cajaingresodetalles) {		
				if(cajaingresodetalleLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				CajaIngresoDetalleLogicAdditional.updateCajaIngresoDetalleToSave(cajaingresodetalleLocal,this.arrDatoGeneral);
	        	
				CajaIngresoDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),cajaingresodetalleLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarCajaIngresoDetalle(cajaingresodetalleLocal)) {
					CajaIngresoDetalleDataAccess.save(cajaingresodetalleLocal, connexion);				
				} else {
					validadoTodosCajaIngresoDetalle=false;
				}
			}
			
			if(!validadoTodosCajaIngresoDetalle) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			CajaIngresoDetalleLogicAdditional.checkCajaIngresoDetalleToSavesAfter(cajaingresodetalles,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowCajaIngresoDetalles();
			
			connexion.commit();		
			
			this.quitarCajaIngresoDetallesEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveCajaIngresoDetalles()throws Exception {				
		 try {	
			CajaIngresoDetalleLogicAdditional.checkCajaIngresoDetalleToSaves(cajaingresodetalles,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosCajaIngresoDetalle=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(CajaIngresoDetalle cajaingresodetalleLocal:cajaingresodetalles) {				
				if(cajaingresodetalleLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				CajaIngresoDetalleLogicAdditional.updateCajaIngresoDetalleToSave(cajaingresodetalleLocal,this.arrDatoGeneral);
	        	
				CajaIngresoDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),cajaingresodetalleLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarCajaIngresoDetalle(cajaingresodetalleLocal)) {				
					CajaIngresoDetalleDataAccess.save(cajaingresodetalleLocal, connexion);				
				} else {
					validadoTodosCajaIngresoDetalle=false;
				}
			}
			
			if(!validadoTodosCajaIngresoDetalle) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			CajaIngresoDetalleLogicAdditional.checkCajaIngresoDetalleToSavesAfter(cajaingresodetalles,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarCajaIngresoDetallesEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public CajaIngresoDetalleParameterReturnGeneral procesarAccionCajaIngresoDetalles(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<CajaIngresoDetalle> cajaingresodetalles,CajaIngresoDetalleParameterReturnGeneral cajaingresodetalleParameterGeneral)throws Exception {
		 try {	
			CajaIngresoDetalleParameterReturnGeneral cajaingresodetalleReturnGeneral=new CajaIngresoDetalleParameterReturnGeneral();
	
			CajaIngresoDetalleLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,cajaingresodetalles,cajaingresodetalleParameterGeneral,cajaingresodetalleReturnGeneral);
			
			return cajaingresodetalleReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public CajaIngresoDetalleParameterReturnGeneral procesarAccionCajaIngresoDetallesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<CajaIngresoDetalle> cajaingresodetalles,CajaIngresoDetalleParameterReturnGeneral cajaingresodetalleParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CajaIngresoDetalle.class.getSimpleName()+"-procesarAccionCajaIngresoDetallesWithConnection");connexion.begin();			
			
			CajaIngresoDetalleParameterReturnGeneral cajaingresodetalleReturnGeneral=new CajaIngresoDetalleParameterReturnGeneral();
	
			CajaIngresoDetalleLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,cajaingresodetalles,cajaingresodetalleParameterGeneral,cajaingresodetalleReturnGeneral);
			
			this.connexion.commit();
			
			return cajaingresodetalleReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public CajaIngresoDetalleParameterReturnGeneral procesarEventosCajaIngresoDetalles(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<CajaIngresoDetalle> cajaingresodetalles,CajaIngresoDetalle cajaingresodetalle,CajaIngresoDetalleParameterReturnGeneral cajaingresodetalleParameterGeneral,Boolean isEsNuevoCajaIngresoDetalle,ArrayList<Classe> clases)throws Exception {
		 try {	
			CajaIngresoDetalleParameterReturnGeneral cajaingresodetalleReturnGeneral=new CajaIngresoDetalleParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				cajaingresodetalleReturnGeneral.setConRecargarPropiedades(true);
			}
			
			CajaIngresoDetalleLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,cajaingresodetalles,cajaingresodetalle,cajaingresodetalleParameterGeneral,cajaingresodetalleReturnGeneral,isEsNuevoCajaIngresoDetalle,clases);
			
			return cajaingresodetalleReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public CajaIngresoDetalleParameterReturnGeneral procesarEventosCajaIngresoDetallesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<CajaIngresoDetalle> cajaingresodetalles,CajaIngresoDetalle cajaingresodetalle,CajaIngresoDetalleParameterReturnGeneral cajaingresodetalleParameterGeneral,Boolean isEsNuevoCajaIngresoDetalle,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CajaIngresoDetalle.class.getSimpleName()+"-procesarEventosCajaIngresoDetallesWithConnection");connexion.begin();			
			
			CajaIngresoDetalleParameterReturnGeneral cajaingresodetalleReturnGeneral=new CajaIngresoDetalleParameterReturnGeneral();
	
			cajaingresodetalleReturnGeneral.setCajaIngresoDetalle(cajaingresodetalle);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				cajaingresodetalleReturnGeneral.setConRecargarPropiedades(true);
			}
			
			CajaIngresoDetalleLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,cajaingresodetalles,cajaingresodetalle,cajaingresodetalleParameterGeneral,cajaingresodetalleReturnGeneral,isEsNuevoCajaIngresoDetalle,clases);
			
			this.connexion.commit();
			
			return cajaingresodetalleReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public CajaIngresoDetalleParameterReturnGeneral procesarImportacionCajaIngresoDetallesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,CajaIngresoDetalleParameterReturnGeneral cajaingresodetalleParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CajaIngresoDetalle.class.getSimpleName()+"-procesarImportacionCajaIngresoDetallesWithConnection");connexion.begin();			
			
			CajaIngresoDetalleParameterReturnGeneral cajaingresodetalleReturnGeneral=new CajaIngresoDetalleParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.cajaingresodetalles=new ArrayList<CajaIngresoDetalle>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.cajaingresodetalle=new CajaIngresoDetalle();
				
				
				if(conColumnasBase) {this.cajaingresodetalle.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.cajaingresodetalle.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.cajaingresodetalle.setconcepto(arrColumnas[iColumn++]);
				this.cajaingresodetalle.setvalor(Double.parseDouble(arrColumnas[iColumn++]));
				
				this.cajaingresodetalles.add(this.cajaingresodetalle);
			}
			
			this.saveCajaIngresoDetalles();
			
			this.connexion.commit();
			
			cajaingresodetalleReturnGeneral.setConRetornoEstaProcesado(true);
			cajaingresodetalleReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return cajaingresodetalleReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarCajaIngresoDetallesEliminados() throws Exception {				
		
		List<CajaIngresoDetalle> cajaingresodetallesAux= new ArrayList<CajaIngresoDetalle>();
		
		for(CajaIngresoDetalle cajaingresodetalle:cajaingresodetalles) {
			if(!cajaingresodetalle.getIsDeleted()) {
				cajaingresodetallesAux.add(cajaingresodetalle);
			}
		}
		
		cajaingresodetalles=cajaingresodetallesAux;
	}
	
	public void quitarCajaIngresoDetallesNulos() throws Exception {				
		
		List<CajaIngresoDetalle> cajaingresodetallesAux= new ArrayList<CajaIngresoDetalle>();
		
		for(CajaIngresoDetalle cajaingresodetalle : this.cajaingresodetalles) {
			if(cajaingresodetalle==null) {
				cajaingresodetallesAux.add(cajaingresodetalle);
			}
		}
		
		//this.cajaingresodetalles=cajaingresodetallesAux;
		
		this.cajaingresodetalles.removeAll(cajaingresodetallesAux);
	}
	
	public void getSetVersionRowCajaIngresoDetalleWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(cajaingresodetalle.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((cajaingresodetalle.getIsDeleted() || (cajaingresodetalle.getIsChanged()&&!cajaingresodetalle.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=cajaingresodetalleDataAccess.getSetVersionRowCajaIngresoDetalle(connexion,cajaingresodetalle.getId());
				
				if(!cajaingresodetalle.getVersionRow().equals(timestamp)) {	
					cajaingresodetalle.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				cajaingresodetalle.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowCajaIngresoDetalle()throws Exception {	
		
		if(cajaingresodetalle.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((cajaingresodetalle.getIsDeleted() || (cajaingresodetalle.getIsChanged()&&!cajaingresodetalle.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=cajaingresodetalleDataAccess.getSetVersionRowCajaIngresoDetalle(connexion,cajaingresodetalle.getId());
			
			try {							
				if(!cajaingresodetalle.getVersionRow().equals(timestamp)) {	
					cajaingresodetalle.setVersionRow(timestamp);
				}
				
				cajaingresodetalle.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowCajaIngresoDetallesWithConnection()throws Exception {	
		if(cajaingresodetalles!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(CajaIngresoDetalle cajaingresodetalleAux:cajaingresodetalles) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(cajaingresodetalleAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(cajaingresodetalleAux.getIsDeleted() || (cajaingresodetalleAux.getIsChanged()&&!cajaingresodetalleAux.getIsNew())) {
						
						timestamp=cajaingresodetalleDataAccess.getSetVersionRowCajaIngresoDetalle(connexion,cajaingresodetalleAux.getId());
						
						if(!cajaingresodetalle.getVersionRow().equals(timestamp)) {	
							cajaingresodetalleAux.setVersionRow(timestamp);
						}
								
						cajaingresodetalleAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowCajaIngresoDetalles()throws Exception {	
		if(cajaingresodetalles!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(CajaIngresoDetalle cajaingresodetalleAux:cajaingresodetalles) {
					if(cajaingresodetalleAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(cajaingresodetalleAux.getIsDeleted() || (cajaingresodetalleAux.getIsChanged()&&!cajaingresodetalleAux.getIsNew())) {
						
						timestamp=cajaingresodetalleDataAccess.getSetVersionRowCajaIngresoDetalle(connexion,cajaingresodetalleAux.getId());
						
						if(!cajaingresodetalleAux.getVersionRow().equals(timestamp)) {	
							cajaingresodetalleAux.setVersionRow(timestamp);
						}
						
													
						cajaingresodetalleAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public CajaIngresoDetalleParameterReturnGeneral cargarCombosLoteForeignKeyCajaIngresoDetalleWithConnection(String finalQueryGlobalCajaIngreso,String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalCliente,String finalQueryGlobalFactura) throws Exception {
		CajaIngresoDetalleParameterReturnGeneral  cajaingresodetalleReturnGeneral =new CajaIngresoDetalleParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CajaIngresoDetalle.class.getSimpleName()+"-cargarCombosLoteForeignKeyCajaIngresoDetalleWithConnection");connexion.begin();
			
			cajaingresodetalleReturnGeneral =new CajaIngresoDetalleParameterReturnGeneral();
			
			

			List<CajaIngreso> cajaingresosForeignKey=new ArrayList<CajaIngreso>();
			CajaIngresoLogic cajaingresoLogic=new CajaIngresoLogic();
			cajaingresoLogic.setConnexion(this.connexion);
			cajaingresoLogic.getCajaIngresoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCajaIngreso.equals("NONE")) {
				cajaingresoLogic.getTodosCajaIngresos(finalQueryGlobalCajaIngreso,new Pagination());
				cajaingresosForeignKey=cajaingresoLogic.getCajaIngresos();
			}

			cajaingresodetalleReturnGeneral.setcajaingresosForeignKey(cajaingresosForeignKey);


			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			cajaingresodetalleReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			cajaingresodetalleReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			cajaingresodetalleReturnGeneral.setclientesForeignKey(clientesForeignKey);


			List<Factura> facturasForeignKey=new ArrayList<Factura>();
			FacturaLogic facturaLogic=new FacturaLogic();
			facturaLogic.setConnexion(this.connexion);
			facturaLogic.getFacturaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFactura.equals("NONE")) {
				facturaLogic.getTodosFacturas(finalQueryGlobalFactura,new Pagination());
				facturasForeignKey=facturaLogic.getFacturas();
			}

			cajaingresodetalleReturnGeneral.setfacturasForeignKey(facturasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return cajaingresodetalleReturnGeneral;
	}
	
	public CajaIngresoDetalleParameterReturnGeneral cargarCombosLoteForeignKeyCajaIngresoDetalle(String finalQueryGlobalCajaIngreso,String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalCliente,String finalQueryGlobalFactura) throws Exception {
		CajaIngresoDetalleParameterReturnGeneral  cajaingresodetalleReturnGeneral =new CajaIngresoDetalleParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			cajaingresodetalleReturnGeneral =new CajaIngresoDetalleParameterReturnGeneral();
			
			

			List<CajaIngreso> cajaingresosForeignKey=new ArrayList<CajaIngreso>();
			CajaIngresoLogic cajaingresoLogic=new CajaIngresoLogic();
			cajaingresoLogic.setConnexion(this.connexion);
			cajaingresoLogic.getCajaIngresoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCajaIngreso.equals("NONE")) {
				cajaingresoLogic.getTodosCajaIngresos(finalQueryGlobalCajaIngreso,new Pagination());
				cajaingresosForeignKey=cajaingresoLogic.getCajaIngresos();
			}

			cajaingresodetalleReturnGeneral.setcajaingresosForeignKey(cajaingresosForeignKey);


			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			cajaingresodetalleReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			cajaingresodetalleReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			cajaingresodetalleReturnGeneral.setclientesForeignKey(clientesForeignKey);


			List<Factura> facturasForeignKey=new ArrayList<Factura>();
			FacturaLogic facturaLogic=new FacturaLogic();
			facturaLogic.setConnexion(this.connexion);
			facturaLogic.getFacturaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFactura.equals("NONE")) {
				facturaLogic.getTodosFacturas(finalQueryGlobalFactura,new Pagination());
				facturasForeignKey=facturaLogic.getFacturas();
			}

			cajaingresodetalleReturnGeneral.setfacturasForeignKey(facturasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return cajaingresodetalleReturnGeneral;
	}
	
	
	public void deepLoad(CajaIngresoDetalle cajaingresodetalle,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			CajaIngresoDetalleLogicAdditional.updateCajaIngresoDetalleToGet(cajaingresodetalle,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		cajaingresodetalle.setCajaIngreso(cajaingresodetalleDataAccess.getCajaIngreso(connexion,cajaingresodetalle));
		cajaingresodetalle.setEmpresa(cajaingresodetalleDataAccess.getEmpresa(connexion,cajaingresodetalle));
		cajaingresodetalle.setSucursal(cajaingresodetalleDataAccess.getSucursal(connexion,cajaingresodetalle));
		cajaingresodetalle.setCliente(cajaingresodetalleDataAccess.getCliente(connexion,cajaingresodetalle));
		cajaingresodetalle.setFactura(cajaingresodetalleDataAccess.getFactura(connexion,cajaingresodetalle));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(CajaIngreso.class)) {
				cajaingresodetalle.setCajaIngreso(cajaingresodetalleDataAccess.getCajaIngreso(connexion,cajaingresodetalle));
				continue;
			}

			if(clas.clas.equals(Empresa.class)) {
				cajaingresodetalle.setEmpresa(cajaingresodetalleDataAccess.getEmpresa(connexion,cajaingresodetalle));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				cajaingresodetalle.setSucursal(cajaingresodetalleDataAccess.getSucursal(connexion,cajaingresodetalle));
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				cajaingresodetalle.setCliente(cajaingresodetalleDataAccess.getCliente(connexion,cajaingresodetalle));
				continue;
			}

			if(clas.clas.equals(Factura.class)) {
				cajaingresodetalle.setFactura(cajaingresodetalleDataAccess.getFactura(connexion,cajaingresodetalle));
				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CajaIngreso.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cajaingresodetalle.setCajaIngreso(cajaingresodetalleDataAccess.getCajaIngreso(connexion,cajaingresodetalle));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cajaingresodetalle.setEmpresa(cajaingresodetalleDataAccess.getEmpresa(connexion,cajaingresodetalle));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cajaingresodetalle.setSucursal(cajaingresodetalleDataAccess.getSucursal(connexion,cajaingresodetalle));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cajaingresodetalle.setCliente(cajaingresodetalleDataAccess.getCliente(connexion,cajaingresodetalle));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Factura.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cajaingresodetalle.setFactura(cajaingresodetalleDataAccess.getFactura(connexion,cajaingresodetalle));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		cajaingresodetalle.setCajaIngreso(cajaingresodetalleDataAccess.getCajaIngreso(connexion,cajaingresodetalle));
		CajaIngresoLogic cajaingresoLogic= new CajaIngresoLogic(connexion);
		cajaingresoLogic.deepLoad(cajaingresodetalle.getCajaIngreso(),isDeep,deepLoadType,clases);
				
		cajaingresodetalle.setEmpresa(cajaingresodetalleDataAccess.getEmpresa(connexion,cajaingresodetalle));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(cajaingresodetalle.getEmpresa(),isDeep,deepLoadType,clases);
				
		cajaingresodetalle.setSucursal(cajaingresodetalleDataAccess.getSucursal(connexion,cajaingresodetalle));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(cajaingresodetalle.getSucursal(),isDeep,deepLoadType,clases);
				
		cajaingresodetalle.setCliente(cajaingresodetalleDataAccess.getCliente(connexion,cajaingresodetalle));
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(cajaingresodetalle.getCliente(),isDeep,deepLoadType,clases);
				
		cajaingresodetalle.setFactura(cajaingresodetalleDataAccess.getFactura(connexion,cajaingresodetalle));
		FacturaLogic facturaLogic= new FacturaLogic(connexion);
		facturaLogic.deepLoad(cajaingresodetalle.getFactura(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(CajaIngreso.class)) {
				cajaingresodetalle.setCajaIngreso(cajaingresodetalleDataAccess.getCajaIngreso(connexion,cajaingresodetalle));
				CajaIngresoLogic cajaingresoLogic= new CajaIngresoLogic(connexion);
				cajaingresoLogic.deepLoad(cajaingresodetalle.getCajaIngreso(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empresa.class)) {
				cajaingresodetalle.setEmpresa(cajaingresodetalleDataAccess.getEmpresa(connexion,cajaingresodetalle));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(cajaingresodetalle.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				cajaingresodetalle.setSucursal(cajaingresodetalleDataAccess.getSucursal(connexion,cajaingresodetalle));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(cajaingresodetalle.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				cajaingresodetalle.setCliente(cajaingresodetalleDataAccess.getCliente(connexion,cajaingresodetalle));
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepLoad(cajaingresodetalle.getCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Factura.class)) {
				cajaingresodetalle.setFactura(cajaingresodetalleDataAccess.getFactura(connexion,cajaingresodetalle));
				FacturaLogic facturaLogic= new FacturaLogic(connexion);
				facturaLogic.deepLoad(cajaingresodetalle.getFactura(),isDeep,deepLoadType,clases);				
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CajaIngreso.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cajaingresodetalle.setCajaIngreso(cajaingresodetalleDataAccess.getCajaIngreso(connexion,cajaingresodetalle));
			CajaIngresoLogic cajaingresoLogic= new CajaIngresoLogic(connexion);
			cajaingresoLogic.deepLoad(cajaingresodetalle.getCajaIngreso(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cajaingresodetalle.setEmpresa(cajaingresodetalleDataAccess.getEmpresa(connexion,cajaingresodetalle));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(cajaingresodetalle.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cajaingresodetalle.setSucursal(cajaingresodetalleDataAccess.getSucursal(connexion,cajaingresodetalle));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(cajaingresodetalle.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cajaingresodetalle.setCliente(cajaingresodetalleDataAccess.getCliente(connexion,cajaingresodetalle));
			ClienteLogic clienteLogic= new ClienteLogic(connexion);
			clienteLogic.deepLoad(cajaingresodetalle.getCliente(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Factura.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cajaingresodetalle.setFactura(cajaingresodetalleDataAccess.getFactura(connexion,cajaingresodetalle));
			FacturaLogic facturaLogic= new FacturaLogic(connexion);
			facturaLogic.deepLoad(cajaingresodetalle.getFactura(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(CajaIngresoDetalle cajaingresodetalle,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			CajaIngresoDetalleLogicAdditional.updateCajaIngresoDetalleToSave(cajaingresodetalle,this.arrDatoGeneral);
			
CajaIngresoDetalleDataAccess.save(cajaingresodetalle, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		CajaIngresoDataAccess.save(cajaingresodetalle.getCajaIngreso(),connexion);

		EmpresaDataAccess.save(cajaingresodetalle.getEmpresa(),connexion);

		SucursalDataAccess.save(cajaingresodetalle.getSucursal(),connexion);

		ClienteDataAccess.save(cajaingresodetalle.getCliente(),connexion);

		FacturaDataAccess.save(cajaingresodetalle.getFactura(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(CajaIngreso.class)) {
				CajaIngresoDataAccess.save(cajaingresodetalle.getCajaIngreso(),connexion);
				continue;
			}

			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(cajaingresodetalle.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(cajaingresodetalle.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(cajaingresodetalle.getCliente(),connexion);
				continue;
			}

			if(clas.clas.equals(Factura.class)) {
				FacturaDataAccess.save(cajaingresodetalle.getFactura(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		CajaIngresoDataAccess.save(cajaingresodetalle.getCajaIngreso(),connexion);
		CajaIngresoLogic cajaingresoLogic= new CajaIngresoLogic(connexion);
		cajaingresoLogic.deepLoad(cajaingresodetalle.getCajaIngreso(),isDeep,deepLoadType,clases);
				

		EmpresaDataAccess.save(cajaingresodetalle.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(cajaingresodetalle.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(cajaingresodetalle.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(cajaingresodetalle.getSucursal(),isDeep,deepLoadType,clases);
				

		ClienteDataAccess.save(cajaingresodetalle.getCliente(),connexion);
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(cajaingresodetalle.getCliente(),isDeep,deepLoadType,clases);
				

		FacturaDataAccess.save(cajaingresodetalle.getFactura(),connexion);
		FacturaLogic facturaLogic= new FacturaLogic(connexion);
		facturaLogic.deepLoad(cajaingresodetalle.getFactura(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(CajaIngreso.class)) {
				CajaIngresoDataAccess.save(cajaingresodetalle.getCajaIngreso(),connexion);
				CajaIngresoLogic cajaingresoLogic= new CajaIngresoLogic(connexion);
				cajaingresoLogic.deepSave(cajaingresodetalle.getCajaIngreso(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(cajaingresodetalle.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(cajaingresodetalle.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(cajaingresodetalle.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(cajaingresodetalle.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(cajaingresodetalle.getCliente(),connexion);
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepSave(cajaingresodetalle.getCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Factura.class)) {
				FacturaDataAccess.save(cajaingresodetalle.getFactura(),connexion);
				FacturaLogic facturaLogic= new FacturaLogic(connexion);
				facturaLogic.deepSave(cajaingresodetalle.getFactura(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(CajaIngresoDetalle.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(cajaingresodetalle,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				CajaIngresoDetalleConstantesFunciones.refrescarForeignKeysDescripcionesCajaIngresoDetalle(cajaingresodetalle);
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
			this.deepLoad(this.cajaingresodetalle,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				CajaIngresoDetalleConstantesFunciones.refrescarForeignKeysDescripcionesCajaIngresoDetalle(this.cajaingresodetalle);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(CajaIngresoDetalle.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(cajaingresodetalles!=null) {
				for(CajaIngresoDetalle cajaingresodetalle:cajaingresodetalles) {
					this.deepLoad(cajaingresodetalle,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					CajaIngresoDetalleConstantesFunciones.refrescarForeignKeysDescripcionesCajaIngresoDetalle(cajaingresodetalles);
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
			if(cajaingresodetalles!=null) {
				for(CajaIngresoDetalle cajaingresodetalle:cajaingresodetalles) {
					this.deepLoad(cajaingresodetalle,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					CajaIngresoDetalleConstantesFunciones.refrescarForeignKeysDescripcionesCajaIngresoDetalle(cajaingresodetalles);
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
			this.getNewConnexionToDeep(CajaIngresoDetalle.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(cajaingresodetalle,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(CajaIngresoDetalle.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(cajaingresodetalles!=null) {
				for(CajaIngresoDetalle cajaingresodetalle:cajaingresodetalles) {
					this.deepSave(cajaingresodetalle,isDeep,deepLoadType,clases);
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
			if(cajaingresodetalles!=null) {
				for(CajaIngresoDetalle cajaingresodetalle:cajaingresodetalles) {
					this.deepSave(cajaingresodetalle,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getCajaIngresoDetallesFK_IdCajaIngresoWithConnection(String sFinalQuery,Pagination pagination,Long id_caja_ingreso)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CajaIngresoDetalle.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCajaIngreso= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCajaIngreso.setParameterSelectionGeneralEqual(ParameterType.LONG,id_caja_ingreso,CajaIngresoDetalleConstantesFunciones.IDCAJAINGRESO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCajaIngreso);

			CajaIngresoDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCajaIngreso","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cajaingresodetalles=cajaingresodetalleDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CajaIngresoDetalleConstantesFunciones.refrescarForeignKeysDescripcionesCajaIngresoDetalle(this.cajaingresodetalles);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCajaIngresoDetallesFK_IdCajaIngreso(String sFinalQuery,Pagination pagination,Long id_caja_ingreso)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCajaIngreso= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCajaIngreso.setParameterSelectionGeneralEqual(ParameterType.LONG,id_caja_ingreso,CajaIngresoDetalleConstantesFunciones.IDCAJAINGRESO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCajaIngreso);

			CajaIngresoDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCajaIngreso","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cajaingresodetalles=cajaingresodetalleDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CajaIngresoDetalleConstantesFunciones.refrescarForeignKeysDescripcionesCajaIngresoDetalle(this.cajaingresodetalles);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCajaIngresoDetallesFK_IdClienteWithConnection(String sFinalQuery,Pagination pagination,Long id_cliente)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CajaIngresoDetalle.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente,CajaIngresoDetalleConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			CajaIngresoDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cajaingresodetalles=cajaingresodetalleDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CajaIngresoDetalleConstantesFunciones.refrescarForeignKeysDescripcionesCajaIngresoDetalle(this.cajaingresodetalles);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCajaIngresoDetallesFK_IdCliente(String sFinalQuery,Pagination pagination,Long id_cliente)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente,CajaIngresoDetalleConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			CajaIngresoDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cajaingresodetalles=cajaingresodetalleDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CajaIngresoDetalleConstantesFunciones.refrescarForeignKeysDescripcionesCajaIngresoDetalle(this.cajaingresodetalles);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCajaIngresoDetallesFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CajaIngresoDetalle.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,CajaIngresoDetalleConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			CajaIngresoDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cajaingresodetalles=cajaingresodetalleDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CajaIngresoDetalleConstantesFunciones.refrescarForeignKeysDescripcionesCajaIngresoDetalle(this.cajaingresodetalles);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCajaIngresoDetallesFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,CajaIngresoDetalleConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			CajaIngresoDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cajaingresodetalles=cajaingresodetalleDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CajaIngresoDetalleConstantesFunciones.refrescarForeignKeysDescripcionesCajaIngresoDetalle(this.cajaingresodetalles);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCajaIngresoDetallesFK_IdFacturaWithConnection(String sFinalQuery,Pagination pagination,Long id_factura)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CajaIngresoDetalle.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFactura= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFactura.setParameterSelectionGeneralEqual(ParameterType.LONG,id_factura,CajaIngresoDetalleConstantesFunciones.IDFACTURA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFactura);

			CajaIngresoDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFactura","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cajaingresodetalles=cajaingresodetalleDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CajaIngresoDetalleConstantesFunciones.refrescarForeignKeysDescripcionesCajaIngresoDetalle(this.cajaingresodetalles);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCajaIngresoDetallesFK_IdFactura(String sFinalQuery,Pagination pagination,Long id_factura)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFactura= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFactura.setParameterSelectionGeneralEqual(ParameterType.LONG,id_factura,CajaIngresoDetalleConstantesFunciones.IDFACTURA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFactura);

			CajaIngresoDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFactura","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cajaingresodetalles=cajaingresodetalleDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CajaIngresoDetalleConstantesFunciones.refrescarForeignKeysDescripcionesCajaIngresoDetalle(this.cajaingresodetalles);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCajaIngresoDetallesFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CajaIngresoDetalle.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,CajaIngresoDetalleConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			CajaIngresoDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cajaingresodetalles=cajaingresodetalleDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CajaIngresoDetalleConstantesFunciones.refrescarForeignKeysDescripcionesCajaIngresoDetalle(this.cajaingresodetalles);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCajaIngresoDetallesFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,CajaIngresoDetalleConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			CajaIngresoDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cajaingresodetalles=cajaingresodetalleDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CajaIngresoDetalleConstantesFunciones.refrescarForeignKeysDescripcionesCajaIngresoDetalle(this.cajaingresodetalles);
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
			if(CajaIngresoDetalleConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,CajaIngresoDetalleDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,CajaIngresoDetalle cajaingresodetalle,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(CajaIngresoDetalleConstantesFunciones.ISCONAUDITORIA) {
				if(cajaingresodetalle.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,CajaIngresoDetalleDataAccess.TABLENAME, cajaingresodetalle.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(CajaIngresoDetalleConstantesFunciones.ISCONAUDITORIADETALLE) {
						////CajaIngresoDetalleLogic.registrarAuditoriaDetallesCajaIngresoDetalle(connexion,cajaingresodetalle,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(cajaingresodetalle.getIsDeleted()) {
					/*if(!cajaingresodetalle.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,CajaIngresoDetalleDataAccess.TABLENAME, cajaingresodetalle.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////CajaIngresoDetalleLogic.registrarAuditoriaDetallesCajaIngresoDetalle(connexion,cajaingresodetalle,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,CajaIngresoDetalleDataAccess.TABLENAME, cajaingresodetalle.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(cajaingresodetalle.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,CajaIngresoDetalleDataAccess.TABLENAME, cajaingresodetalle.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(CajaIngresoDetalleConstantesFunciones.ISCONAUDITORIADETALLE) {
						////CajaIngresoDetalleLogic.registrarAuditoriaDetallesCajaIngresoDetalle(connexion,cajaingresodetalle,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesCajaIngresoDetalle(Connexion connexion,CajaIngresoDetalle cajaingresodetalle)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(cajaingresodetalle.getIsNew()||!cajaingresodetalle.getid_caja_ingreso().equals(cajaingresodetalle.getCajaIngresoDetalleOriginal().getid_caja_ingreso()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cajaingresodetalle.getCajaIngresoDetalleOriginal().getid_caja_ingreso()!=null)
				{
					strValorActual=cajaingresodetalle.getCajaIngresoDetalleOriginal().getid_caja_ingreso().toString();
				}
				if(cajaingresodetalle.getid_caja_ingreso()!=null)
				{
					strValorNuevo=cajaingresodetalle.getid_caja_ingreso().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CajaIngresoDetalleConstantesFunciones.IDCAJAINGRESO,strValorActual,strValorNuevo);
			}	
			
			if(cajaingresodetalle.getIsNew()||!cajaingresodetalle.getid_empresa().equals(cajaingresodetalle.getCajaIngresoDetalleOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cajaingresodetalle.getCajaIngresoDetalleOriginal().getid_empresa()!=null)
				{
					strValorActual=cajaingresodetalle.getCajaIngresoDetalleOriginal().getid_empresa().toString();
				}
				if(cajaingresodetalle.getid_empresa()!=null)
				{
					strValorNuevo=cajaingresodetalle.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CajaIngresoDetalleConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(cajaingresodetalle.getIsNew()||!cajaingresodetalle.getid_sucursal().equals(cajaingresodetalle.getCajaIngresoDetalleOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cajaingresodetalle.getCajaIngresoDetalleOriginal().getid_sucursal()!=null)
				{
					strValorActual=cajaingresodetalle.getCajaIngresoDetalleOriginal().getid_sucursal().toString();
				}
				if(cajaingresodetalle.getid_sucursal()!=null)
				{
					strValorNuevo=cajaingresodetalle.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CajaIngresoDetalleConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(cajaingresodetalle.getIsNew()||!cajaingresodetalle.getid_cliente().equals(cajaingresodetalle.getCajaIngresoDetalleOriginal().getid_cliente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cajaingresodetalle.getCajaIngresoDetalleOriginal().getid_cliente()!=null)
				{
					strValorActual=cajaingresodetalle.getCajaIngresoDetalleOriginal().getid_cliente().toString();
				}
				if(cajaingresodetalle.getid_cliente()!=null)
				{
					strValorNuevo=cajaingresodetalle.getid_cliente().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CajaIngresoDetalleConstantesFunciones.IDCLIENTE,strValorActual,strValorNuevo);
			}	
			
			if(cajaingresodetalle.getIsNew()||!cajaingresodetalle.getid_factura().equals(cajaingresodetalle.getCajaIngresoDetalleOriginal().getid_factura()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cajaingresodetalle.getCajaIngresoDetalleOriginal().getid_factura()!=null)
				{
					strValorActual=cajaingresodetalle.getCajaIngresoDetalleOriginal().getid_factura().toString();
				}
				if(cajaingresodetalle.getid_factura()!=null)
				{
					strValorNuevo=cajaingresodetalle.getid_factura().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CajaIngresoDetalleConstantesFunciones.IDFACTURA,strValorActual,strValorNuevo);
			}	
			
			if(cajaingresodetalle.getIsNew()||!cajaingresodetalle.getconcepto().equals(cajaingresodetalle.getCajaIngresoDetalleOriginal().getconcepto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cajaingresodetalle.getCajaIngresoDetalleOriginal().getconcepto()!=null)
				{
					strValorActual=cajaingresodetalle.getCajaIngresoDetalleOriginal().getconcepto();
				}
				if(cajaingresodetalle.getconcepto()!=null)
				{
					strValorNuevo=cajaingresodetalle.getconcepto() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CajaIngresoDetalleConstantesFunciones.CONCEPTO,strValorActual,strValorNuevo);
			}	
			
			if(cajaingresodetalle.getIsNew()||!cajaingresodetalle.getvalor().equals(cajaingresodetalle.getCajaIngresoDetalleOriginal().getvalor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cajaingresodetalle.getCajaIngresoDetalleOriginal().getvalor()!=null)
				{
					strValorActual=cajaingresodetalle.getCajaIngresoDetalleOriginal().getvalor().toString();
				}
				if(cajaingresodetalle.getvalor()!=null)
				{
					strValorNuevo=cajaingresodetalle.getvalor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CajaIngresoDetalleConstantesFunciones.VALOR,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveCajaIngresoDetalleRelacionesWithConnection(CajaIngresoDetalle cajaingresodetalle) throws Exception {

		if(!cajaingresodetalle.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveCajaIngresoDetalleRelacionesBase(cajaingresodetalle,true);
		}
	}

	public void saveCajaIngresoDetalleRelaciones(CajaIngresoDetalle cajaingresodetalle)throws Exception {

		if(!cajaingresodetalle.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveCajaIngresoDetalleRelacionesBase(cajaingresodetalle,false);
		}
	}

	public void saveCajaIngresoDetalleRelacionesBase(CajaIngresoDetalle cajaingresodetalle,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("CajaIngresoDetalle-saveRelacionesWithConnection");}
	

			this.setCajaIngresoDetalle(cajaingresodetalle);

			if(CajaIngresoDetalleLogicAdditional.validarSaveRelaciones(cajaingresodetalle,this)) {

				CajaIngresoDetalleLogicAdditional.updateRelacionesToSave(cajaingresodetalle,this);

				if((cajaingresodetalle.getIsNew()||cajaingresodetalle.getIsChanged())&&!cajaingresodetalle.getIsDeleted()) {
					this.saveCajaIngresoDetalle();
					this.saveCajaIngresoDetalleRelacionesDetalles();

				} else if(cajaingresodetalle.getIsDeleted()) {
					this.saveCajaIngresoDetalleRelacionesDetalles();
					this.saveCajaIngresoDetalle();
				}

				CajaIngresoDetalleLogicAdditional.updateRelacionesToSaveAfter(cajaingresodetalle,this);

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
	
	
	private void saveCajaIngresoDetalleRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfCajaIngresoDetalle(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=CajaIngresoDetalleConstantesFunciones.getClassesForeignKeysOfCajaIngresoDetalle(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfCajaIngresoDetalle(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=CajaIngresoDetalleConstantesFunciones.getClassesRelationshipsOfCajaIngresoDetalle(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
