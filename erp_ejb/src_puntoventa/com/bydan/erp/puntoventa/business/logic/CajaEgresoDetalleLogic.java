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
import com.bydan.erp.puntoventa.util.CajaEgresoDetalleConstantesFunciones;
import com.bydan.erp.puntoventa.util.CajaEgresoDetalleParameterReturnGeneral;
//import com.bydan.erp.puntoventa.util.CajaEgresoDetalleParameterGeneral;
import com.bydan.erp.puntoventa.business.entity.CajaEgresoDetalle;
import com.bydan.erp.puntoventa.business.logic.CajaEgresoDetalleLogicAdditional;
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
public class CajaEgresoDetalleLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(CajaEgresoDetalleLogic.class);
	
	protected CajaEgresoDetalleDataAccess cajaegresodetalleDataAccess; 	
	protected CajaEgresoDetalle cajaegresodetalle;
	protected List<CajaEgresoDetalle> cajaegresodetalles;
	protected Object cajaegresodetalleObject;	
	protected List<Object> cajaegresodetallesObject;
	
	public static ClassValidator<CajaEgresoDetalle> cajaegresodetalleValidator = new ClassValidator<CajaEgresoDetalle>(CajaEgresoDetalle.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected CajaEgresoDetalleLogicAdditional cajaegresodetalleLogicAdditional=null;
	
	public CajaEgresoDetalleLogicAdditional getCajaEgresoDetalleLogicAdditional() {
		return this.cajaegresodetalleLogicAdditional;
	}
	
	public void setCajaEgresoDetalleLogicAdditional(CajaEgresoDetalleLogicAdditional cajaegresodetalleLogicAdditional) {
		try {
			this.cajaegresodetalleLogicAdditional=cajaegresodetalleLogicAdditional;
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
	
	
	
	
	public  CajaEgresoDetalleLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.cajaegresodetalleDataAccess = new CajaEgresoDetalleDataAccess();
			
			this.cajaegresodetalles= new ArrayList<CajaEgresoDetalle>();
			this.cajaegresodetalle= new CajaEgresoDetalle();
			
			this.cajaegresodetalleObject=new Object();
			this.cajaegresodetallesObject=new ArrayList<Object>();
				
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
			
			this.cajaegresodetalleDataAccess.setConnexionType(this.connexionType);
			this.cajaegresodetalleDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  CajaEgresoDetalleLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.cajaegresodetalleDataAccess = new CajaEgresoDetalleDataAccess();
			this.cajaegresodetalles= new ArrayList<CajaEgresoDetalle>();
			this.cajaegresodetalle= new CajaEgresoDetalle();
			this.cajaegresodetalleObject=new Object();
			this.cajaegresodetallesObject=new ArrayList<Object>();
			
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
			
			this.cajaegresodetalleDataAccess.setConnexionType(this.connexionType);
			this.cajaegresodetalleDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public CajaEgresoDetalle getCajaEgresoDetalle() throws Exception {	
		CajaEgresoDetalleLogicAdditional.checkCajaEgresoDetalleToGet(cajaegresodetalle,this.datosCliente,this.arrDatoGeneral);
		CajaEgresoDetalleLogicAdditional.updateCajaEgresoDetalleToGet(cajaegresodetalle,this.arrDatoGeneral);
		
		return cajaegresodetalle;
	}
		
	public void setCajaEgresoDetalle(CajaEgresoDetalle newCajaEgresoDetalle) {
		this.cajaegresodetalle = newCajaEgresoDetalle;
	}
	
	public CajaEgresoDetalleDataAccess getCajaEgresoDetalleDataAccess() {
		return cajaegresodetalleDataAccess;
	}
	
	public void setCajaEgresoDetalleDataAccess(CajaEgresoDetalleDataAccess newcajaegresodetalleDataAccess) {
		this.cajaegresodetalleDataAccess = newcajaegresodetalleDataAccess;
	}
	
	public List<CajaEgresoDetalle> getCajaEgresoDetalles() throws Exception {		
		this.quitarCajaEgresoDetallesNulos();
		
		CajaEgresoDetalleLogicAdditional.checkCajaEgresoDetalleToGets(cajaegresodetalles,this.datosCliente,this.arrDatoGeneral);
		
		for (CajaEgresoDetalle cajaegresodetalleLocal: cajaegresodetalles ) {
			CajaEgresoDetalleLogicAdditional.updateCajaEgresoDetalleToGet(cajaegresodetalleLocal,this.arrDatoGeneral);
		}
		
		return cajaegresodetalles;
	}
	
	public void setCajaEgresoDetalles(List<CajaEgresoDetalle> newCajaEgresoDetalles) {
		this.cajaegresodetalles = newCajaEgresoDetalles;
	}
	
	public Object getCajaEgresoDetalleObject() {	
		this.cajaegresodetalleObject=this.cajaegresodetalleDataAccess.getEntityObject();
		return this.cajaegresodetalleObject;
	}
		
	public void setCajaEgresoDetalleObject(Object newCajaEgresoDetalleObject) {
		this.cajaegresodetalleObject = newCajaEgresoDetalleObject;
	}
	
	public List<Object> getCajaEgresoDetallesObject() {		
		this.cajaegresodetallesObject=this.cajaegresodetalleDataAccess.getEntitiesObject();
		return this.cajaegresodetallesObject;
	}
		
	public void setCajaEgresoDetallesObject(List<Object> newCajaEgresoDetallesObject) {
		this.cajaegresodetallesObject = newCajaEgresoDetallesObject;
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
		
		if(this.cajaegresodetalleDataAccess!=null) {
			this.cajaegresodetalleDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CajaEgresoDetalle.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			cajaegresodetalleDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			cajaegresodetalleDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		cajaegresodetalle = new  CajaEgresoDetalle();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CajaEgresoDetalle.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			cajaegresodetalle=cajaegresodetalleDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.cajaegresodetalle,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CajaEgresoDetalleConstantesFunciones.refrescarForeignKeysDescripcionesCajaEgresoDetalle(this.cajaegresodetalle);
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
		cajaegresodetalle = new  CajaEgresoDetalle();
		  		  
        try {
			
			cajaegresodetalle=cajaegresodetalleDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.cajaegresodetalle,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CajaEgresoDetalleConstantesFunciones.refrescarForeignKeysDescripcionesCajaEgresoDetalle(this.cajaegresodetalle);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		cajaegresodetalle = new  CajaEgresoDetalle();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CajaEgresoDetalle.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			cajaegresodetalle=cajaegresodetalleDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.cajaegresodetalle,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CajaEgresoDetalleConstantesFunciones.refrescarForeignKeysDescripcionesCajaEgresoDetalle(this.cajaegresodetalle);
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
		cajaegresodetalle = new  CajaEgresoDetalle();
		  		  
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
		cajaegresodetalle = new  CajaEgresoDetalle();
		  		  
        try {
			
			cajaegresodetalle=cajaegresodetalleDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.cajaegresodetalle,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				CajaEgresoDetalleConstantesFunciones.refrescarForeignKeysDescripcionesCajaEgresoDetalle(this.cajaegresodetalle);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		cajaegresodetalle = new  CajaEgresoDetalle();
		  		  
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
		cajaegresodetalle = new  CajaEgresoDetalle();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CajaEgresoDetalle.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =cajaegresodetalleDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		cajaegresodetalle = new  CajaEgresoDetalle();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=cajaegresodetalleDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		cajaegresodetalle = new  CajaEgresoDetalle();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CajaEgresoDetalle.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =cajaegresodetalleDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		cajaegresodetalle = new  CajaEgresoDetalle();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=cajaegresodetalleDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		cajaegresodetalle = new  CajaEgresoDetalle();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CajaEgresoDetalle.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =cajaegresodetalleDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		cajaegresodetalle = new  CajaEgresoDetalle();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=cajaegresodetalleDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		cajaegresodetalles = new  ArrayList<CajaEgresoDetalle>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CajaEgresoDetalle.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			CajaEgresoDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cajaegresodetalles=cajaegresodetalleDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCajaEgresoDetalle(cajaegresodetalles);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CajaEgresoDetalleConstantesFunciones.refrescarForeignKeysDescripcionesCajaEgresoDetalle(this.cajaegresodetalles);
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
		cajaegresodetalles = new  ArrayList<CajaEgresoDetalle>();
		  		  
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
		cajaegresodetalles = new  ArrayList<CajaEgresoDetalle>();
		  		  
        try {			
			CajaEgresoDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cajaegresodetalles=cajaegresodetalleDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarCajaEgresoDetalle(cajaegresodetalles);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CajaEgresoDetalleConstantesFunciones.refrescarForeignKeysDescripcionesCajaEgresoDetalle(this.cajaegresodetalles);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		cajaegresodetalles = new  ArrayList<CajaEgresoDetalle>();
		  		  
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
		cajaegresodetalles = new  ArrayList<CajaEgresoDetalle>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CajaEgresoDetalle.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			CajaEgresoDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cajaegresodetalles=cajaegresodetalleDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCajaEgresoDetalle(cajaegresodetalles);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CajaEgresoDetalleConstantesFunciones.refrescarForeignKeysDescripcionesCajaEgresoDetalle(this.cajaegresodetalles);
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
		cajaegresodetalles = new  ArrayList<CajaEgresoDetalle>();
		  		  
        try {
			CajaEgresoDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cajaegresodetalles=cajaegresodetalleDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCajaEgresoDetalle(cajaegresodetalles);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CajaEgresoDetalleConstantesFunciones.refrescarForeignKeysDescripcionesCajaEgresoDetalle(this.cajaegresodetalles);
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
		cajaegresodetalles = new  ArrayList<CajaEgresoDetalle>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CajaEgresoDetalle.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CajaEgresoDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cajaegresodetalles=cajaegresodetalleDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCajaEgresoDetalle(cajaegresodetalles);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CajaEgresoDetalleConstantesFunciones.refrescarForeignKeysDescripcionesCajaEgresoDetalle(this.cajaegresodetalles);
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
		cajaegresodetalles = new  ArrayList<CajaEgresoDetalle>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CajaEgresoDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cajaegresodetalles=cajaegresodetalleDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCajaEgresoDetalle(cajaegresodetalles);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CajaEgresoDetalleConstantesFunciones.refrescarForeignKeysDescripcionesCajaEgresoDetalle(this.cajaegresodetalles);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		cajaegresodetalle = new  CajaEgresoDetalle();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CajaEgresoDetalle.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CajaEgresoDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cajaegresodetalle=cajaegresodetalleDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCajaEgresoDetalle(cajaegresodetalle);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CajaEgresoDetalleConstantesFunciones.refrescarForeignKeysDescripcionesCajaEgresoDetalle(this.cajaegresodetalle);
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
		cajaegresodetalle = new  CajaEgresoDetalle();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CajaEgresoDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cajaegresodetalle=cajaegresodetalleDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarCajaEgresoDetalle(cajaegresodetalle);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CajaEgresoDetalleConstantesFunciones.refrescarForeignKeysDescripcionesCajaEgresoDetalle(this.cajaegresodetalle);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		cajaegresodetalles = new  ArrayList<CajaEgresoDetalle>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CajaEgresoDetalle.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			CajaEgresoDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cajaegresodetalles=cajaegresodetalleDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCajaEgresoDetalle(cajaegresodetalles);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CajaEgresoDetalleConstantesFunciones.refrescarForeignKeysDescripcionesCajaEgresoDetalle(this.cajaegresodetalles);
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
		cajaegresodetalles = new  ArrayList<CajaEgresoDetalle>();
		  		  
        try {
			CajaEgresoDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cajaegresodetalles=cajaegresodetalleDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarCajaEgresoDetalle(cajaegresodetalles);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CajaEgresoDetalleConstantesFunciones.refrescarForeignKeysDescripcionesCajaEgresoDetalle(this.cajaegresodetalles);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosCajaEgresoDetallesWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		cajaegresodetalles = new  ArrayList<CajaEgresoDetalle>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CajaEgresoDetalle.class.getSimpleName()+"-getTodosCajaEgresoDetallesWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CajaEgresoDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cajaegresodetalles=cajaegresodetalleDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarCajaEgresoDetalle(cajaegresodetalles);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CajaEgresoDetalleConstantesFunciones.refrescarForeignKeysDescripcionesCajaEgresoDetalle(this.cajaegresodetalles);
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
	
	public  void  getTodosCajaEgresoDetalles(String sFinalQuery,Pagination pagination)throws Exception {
		cajaegresodetalles = new  ArrayList<CajaEgresoDetalle>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			CajaEgresoDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			cajaegresodetalles=cajaegresodetalleDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarCajaEgresoDetalle(cajaegresodetalles);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				CajaEgresoDetalleConstantesFunciones.refrescarForeignKeysDescripcionesCajaEgresoDetalle(this.cajaegresodetalles);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarCajaEgresoDetalle(CajaEgresoDetalle cajaegresodetalle) throws Exception {
		Boolean estaValidado=false;
		
		if(cajaegresodetalle.getIsNew() || cajaegresodetalle.getIsChanged()) { 
			this.invalidValues = cajaegresodetalleValidator.getInvalidValues(cajaegresodetalle);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(cajaegresodetalle);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarCajaEgresoDetalle(List<CajaEgresoDetalle> CajaEgresoDetalles) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(CajaEgresoDetalle cajaegresodetalleLocal:cajaegresodetalles) {				
			estaValidadoObjeto=this.validarGuardarCajaEgresoDetalle(cajaegresodetalleLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarCajaEgresoDetalle(List<CajaEgresoDetalle> CajaEgresoDetalles) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarCajaEgresoDetalle(cajaegresodetalles)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarCajaEgresoDetalle(CajaEgresoDetalle CajaEgresoDetalle) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarCajaEgresoDetalle(cajaegresodetalle)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(CajaEgresoDetalle cajaegresodetalle) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+cajaegresodetalle.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=CajaEgresoDetalleConstantesFunciones.getCajaEgresoDetalleLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"cajaegresodetalle","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(CajaEgresoDetalleConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(CajaEgresoDetalleConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveCajaEgresoDetalleWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CajaEgresoDetalle.class.getSimpleName()+"-saveCajaEgresoDetalleWithConnection");connexion.begin();			
			
			CajaEgresoDetalleLogicAdditional.checkCajaEgresoDetalleToSave(this.cajaegresodetalle,this.datosCliente,connexion,this.arrDatoGeneral);
			
			CajaEgresoDetalleLogicAdditional.updateCajaEgresoDetalleToSave(this.cajaegresodetalle,this.arrDatoGeneral);
			
			CajaEgresoDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.cajaegresodetalle,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowCajaEgresoDetalle();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarCajaEgresoDetalle(this.cajaegresodetalle)) {
				CajaEgresoDetalleDataAccess.save(this.cajaegresodetalle, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.cajaegresodetalle,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			CajaEgresoDetalleLogicAdditional.checkCajaEgresoDetalleToSaveAfter(this.cajaegresodetalle,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowCajaEgresoDetalle();
			
			connexion.commit();			
			
			if(this.cajaegresodetalle.getIsDeleted()) {
				this.cajaegresodetalle=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveCajaEgresoDetalle()throws Exception {	
		try {	
			
			CajaEgresoDetalleLogicAdditional.checkCajaEgresoDetalleToSave(this.cajaegresodetalle,this.datosCliente,connexion,this.arrDatoGeneral);
			
			CajaEgresoDetalleLogicAdditional.updateCajaEgresoDetalleToSave(this.cajaegresodetalle,this.arrDatoGeneral);
			
			CajaEgresoDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.cajaegresodetalle,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarCajaEgresoDetalle(this.cajaegresodetalle)) {			
				CajaEgresoDetalleDataAccess.save(this.cajaegresodetalle, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.cajaegresodetalle,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			CajaEgresoDetalleLogicAdditional.checkCajaEgresoDetalleToSaveAfter(this.cajaegresodetalle,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.cajaegresodetalle.getIsDeleted()) {
				this.cajaegresodetalle=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveCajaEgresoDetallesWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CajaEgresoDetalle.class.getSimpleName()+"-saveCajaEgresoDetallesWithConnection");connexion.begin();			
			
			CajaEgresoDetalleLogicAdditional.checkCajaEgresoDetalleToSaves(cajaegresodetalles,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowCajaEgresoDetalles();
			
			Boolean validadoTodosCajaEgresoDetalle=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(CajaEgresoDetalle cajaegresodetalleLocal:cajaegresodetalles) {		
				if(cajaegresodetalleLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				CajaEgresoDetalleLogicAdditional.updateCajaEgresoDetalleToSave(cajaegresodetalleLocal,this.arrDatoGeneral);
	        	
				CajaEgresoDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),cajaegresodetalleLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarCajaEgresoDetalle(cajaegresodetalleLocal)) {
					CajaEgresoDetalleDataAccess.save(cajaegresodetalleLocal, connexion);				
				} else {
					validadoTodosCajaEgresoDetalle=false;
				}
			}
			
			if(!validadoTodosCajaEgresoDetalle) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			CajaEgresoDetalleLogicAdditional.checkCajaEgresoDetalleToSavesAfter(cajaegresodetalles,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowCajaEgresoDetalles();
			
			connexion.commit();		
			
			this.quitarCajaEgresoDetallesEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveCajaEgresoDetalles()throws Exception {				
		 try {	
			CajaEgresoDetalleLogicAdditional.checkCajaEgresoDetalleToSaves(cajaegresodetalles,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosCajaEgresoDetalle=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(CajaEgresoDetalle cajaegresodetalleLocal:cajaegresodetalles) {				
				if(cajaegresodetalleLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				CajaEgresoDetalleLogicAdditional.updateCajaEgresoDetalleToSave(cajaegresodetalleLocal,this.arrDatoGeneral);
	        	
				CajaEgresoDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),cajaegresodetalleLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarCajaEgresoDetalle(cajaegresodetalleLocal)) {				
					CajaEgresoDetalleDataAccess.save(cajaegresodetalleLocal, connexion);				
				} else {
					validadoTodosCajaEgresoDetalle=false;
				}
			}
			
			if(!validadoTodosCajaEgresoDetalle) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			CajaEgresoDetalleLogicAdditional.checkCajaEgresoDetalleToSavesAfter(cajaegresodetalles,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarCajaEgresoDetallesEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public CajaEgresoDetalleParameterReturnGeneral procesarAccionCajaEgresoDetalles(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<CajaEgresoDetalle> cajaegresodetalles,CajaEgresoDetalleParameterReturnGeneral cajaegresodetalleParameterGeneral)throws Exception {
		 try {	
			CajaEgresoDetalleParameterReturnGeneral cajaegresodetalleReturnGeneral=new CajaEgresoDetalleParameterReturnGeneral();
	
			CajaEgresoDetalleLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,cajaegresodetalles,cajaegresodetalleParameterGeneral,cajaegresodetalleReturnGeneral);
			
			return cajaegresodetalleReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public CajaEgresoDetalleParameterReturnGeneral procesarAccionCajaEgresoDetallesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<CajaEgresoDetalle> cajaegresodetalles,CajaEgresoDetalleParameterReturnGeneral cajaegresodetalleParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CajaEgresoDetalle.class.getSimpleName()+"-procesarAccionCajaEgresoDetallesWithConnection");connexion.begin();			
			
			CajaEgresoDetalleParameterReturnGeneral cajaegresodetalleReturnGeneral=new CajaEgresoDetalleParameterReturnGeneral();
	
			CajaEgresoDetalleLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,cajaegresodetalles,cajaegresodetalleParameterGeneral,cajaegresodetalleReturnGeneral);
			
			this.connexion.commit();
			
			return cajaegresodetalleReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public CajaEgresoDetalleParameterReturnGeneral procesarEventosCajaEgresoDetalles(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<CajaEgresoDetalle> cajaegresodetalles,CajaEgresoDetalle cajaegresodetalle,CajaEgresoDetalleParameterReturnGeneral cajaegresodetalleParameterGeneral,Boolean isEsNuevoCajaEgresoDetalle,ArrayList<Classe> clases)throws Exception {
		 try {	
			CajaEgresoDetalleParameterReturnGeneral cajaegresodetalleReturnGeneral=new CajaEgresoDetalleParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				cajaegresodetalleReturnGeneral.setConRecargarPropiedades(true);
			}
			
			CajaEgresoDetalleLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,cajaegresodetalles,cajaegresodetalle,cajaegresodetalleParameterGeneral,cajaegresodetalleReturnGeneral,isEsNuevoCajaEgresoDetalle,clases);
			
			return cajaegresodetalleReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public CajaEgresoDetalleParameterReturnGeneral procesarEventosCajaEgresoDetallesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<CajaEgresoDetalle> cajaegresodetalles,CajaEgresoDetalle cajaegresodetalle,CajaEgresoDetalleParameterReturnGeneral cajaegresodetalleParameterGeneral,Boolean isEsNuevoCajaEgresoDetalle,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CajaEgresoDetalle.class.getSimpleName()+"-procesarEventosCajaEgresoDetallesWithConnection");connexion.begin();			
			
			CajaEgresoDetalleParameterReturnGeneral cajaegresodetalleReturnGeneral=new CajaEgresoDetalleParameterReturnGeneral();
	
			cajaegresodetalleReturnGeneral.setCajaEgresoDetalle(cajaegresodetalle);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				cajaegresodetalleReturnGeneral.setConRecargarPropiedades(true);
			}
			
			CajaEgresoDetalleLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,cajaegresodetalles,cajaegresodetalle,cajaegresodetalleParameterGeneral,cajaegresodetalleReturnGeneral,isEsNuevoCajaEgresoDetalle,clases);
			
			this.connexion.commit();
			
			return cajaegresodetalleReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public CajaEgresoDetalleParameterReturnGeneral procesarImportacionCajaEgresoDetallesWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,CajaEgresoDetalleParameterReturnGeneral cajaegresodetalleParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CajaEgresoDetalle.class.getSimpleName()+"-procesarImportacionCajaEgresoDetallesWithConnection");connexion.begin();			
			
			CajaEgresoDetalleParameterReturnGeneral cajaegresodetalleReturnGeneral=new CajaEgresoDetalleParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.cajaegresodetalles=new ArrayList<CajaEgresoDetalle>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.cajaegresodetalle=new CajaEgresoDetalle();
				
				
				if(conColumnasBase) {this.cajaegresodetalle.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.cajaegresodetalle.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.cajaegresodetalle.setconcepto(arrColumnas[iColumn++]);
				this.cajaegresodetalle.setvalor(Double.parseDouble(arrColumnas[iColumn++]));
				
				this.cajaegresodetalles.add(this.cajaegresodetalle);
			}
			
			this.saveCajaEgresoDetalles();
			
			this.connexion.commit();
			
			cajaegresodetalleReturnGeneral.setConRetornoEstaProcesado(true);
			cajaegresodetalleReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return cajaegresodetalleReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarCajaEgresoDetallesEliminados() throws Exception {				
		
		List<CajaEgresoDetalle> cajaegresodetallesAux= new ArrayList<CajaEgresoDetalle>();
		
		for(CajaEgresoDetalle cajaegresodetalle:cajaegresodetalles) {
			if(!cajaegresodetalle.getIsDeleted()) {
				cajaegresodetallesAux.add(cajaegresodetalle);
			}
		}
		
		cajaegresodetalles=cajaegresodetallesAux;
	}
	
	public void quitarCajaEgresoDetallesNulos() throws Exception {				
		
		List<CajaEgresoDetalle> cajaegresodetallesAux= new ArrayList<CajaEgresoDetalle>();
		
		for(CajaEgresoDetalle cajaegresodetalle : this.cajaegresodetalles) {
			if(cajaegresodetalle==null) {
				cajaegresodetallesAux.add(cajaegresodetalle);
			}
		}
		
		//this.cajaegresodetalles=cajaegresodetallesAux;
		
		this.cajaegresodetalles.removeAll(cajaegresodetallesAux);
	}
	
	public void getSetVersionRowCajaEgresoDetalleWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(cajaegresodetalle.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((cajaegresodetalle.getIsDeleted() || (cajaegresodetalle.getIsChanged()&&!cajaegresodetalle.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=cajaegresodetalleDataAccess.getSetVersionRowCajaEgresoDetalle(connexion,cajaegresodetalle.getId());
				
				if(!cajaegresodetalle.getVersionRow().equals(timestamp)) {	
					cajaegresodetalle.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				cajaegresodetalle.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowCajaEgresoDetalle()throws Exception {	
		
		if(cajaegresodetalle.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((cajaegresodetalle.getIsDeleted() || (cajaegresodetalle.getIsChanged()&&!cajaegresodetalle.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=cajaegresodetalleDataAccess.getSetVersionRowCajaEgresoDetalle(connexion,cajaegresodetalle.getId());
			
			try {							
				if(!cajaegresodetalle.getVersionRow().equals(timestamp)) {	
					cajaegresodetalle.setVersionRow(timestamp);
				}
				
				cajaegresodetalle.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowCajaEgresoDetallesWithConnection()throws Exception {	
		if(cajaegresodetalles!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(CajaEgresoDetalle cajaegresodetalleAux:cajaegresodetalles) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(cajaegresodetalleAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(cajaegresodetalleAux.getIsDeleted() || (cajaegresodetalleAux.getIsChanged()&&!cajaegresodetalleAux.getIsNew())) {
						
						timestamp=cajaegresodetalleDataAccess.getSetVersionRowCajaEgresoDetalle(connexion,cajaegresodetalleAux.getId());
						
						if(!cajaegresodetalle.getVersionRow().equals(timestamp)) {	
							cajaegresodetalleAux.setVersionRow(timestamp);
						}
								
						cajaegresodetalleAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowCajaEgresoDetalles()throws Exception {	
		if(cajaegresodetalles!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(CajaEgresoDetalle cajaegresodetalleAux:cajaegresodetalles) {
					if(cajaegresodetalleAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(cajaegresodetalleAux.getIsDeleted() || (cajaegresodetalleAux.getIsChanged()&&!cajaegresodetalleAux.getIsNew())) {
						
						timestamp=cajaegresodetalleDataAccess.getSetVersionRowCajaEgresoDetalle(connexion,cajaegresodetalleAux.getId());
						
						if(!cajaegresodetalleAux.getVersionRow().equals(timestamp)) {	
							cajaegresodetalleAux.setVersionRow(timestamp);
						}
						
													
						cajaegresodetalleAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public CajaEgresoDetalleParameterReturnGeneral cargarCombosLoteForeignKeyCajaEgresoDetalleWithConnection(String finalQueryGlobalCajaEgreso,String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalCliente,String finalQueryGlobalFactura) throws Exception {
		CajaEgresoDetalleParameterReturnGeneral  cajaegresodetalleReturnGeneral =new CajaEgresoDetalleParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CajaEgresoDetalle.class.getSimpleName()+"-cargarCombosLoteForeignKeyCajaEgresoDetalleWithConnection");connexion.begin();
			
			cajaegresodetalleReturnGeneral =new CajaEgresoDetalleParameterReturnGeneral();
			
			

			List<CajaEgreso> cajaegresosForeignKey=new ArrayList<CajaEgreso>();
			CajaEgresoLogic cajaegresoLogic=new CajaEgresoLogic();
			cajaegresoLogic.setConnexion(this.connexion);
			cajaegresoLogic.getCajaEgresoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCajaEgreso.equals("NONE")) {
				cajaegresoLogic.getTodosCajaEgresos(finalQueryGlobalCajaEgreso,new Pagination());
				cajaegresosForeignKey=cajaegresoLogic.getCajaEgresos();
			}

			cajaegresodetalleReturnGeneral.setcajaegresosForeignKey(cajaegresosForeignKey);


			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			cajaegresodetalleReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			cajaegresodetalleReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			cajaegresodetalleReturnGeneral.setclientesForeignKey(clientesForeignKey);


			List<Factura> facturasForeignKey=new ArrayList<Factura>();
			FacturaLogic facturaLogic=new FacturaLogic();
			facturaLogic.setConnexion(this.connexion);
			facturaLogic.getFacturaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFactura.equals("NONE")) {
				facturaLogic.getTodosFacturas(finalQueryGlobalFactura,new Pagination());
				facturasForeignKey=facturaLogic.getFacturas();
			}

			cajaegresodetalleReturnGeneral.setfacturasForeignKey(facturasForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return cajaegresodetalleReturnGeneral;
	}
	
	public CajaEgresoDetalleParameterReturnGeneral cargarCombosLoteForeignKeyCajaEgresoDetalle(String finalQueryGlobalCajaEgreso,String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalCliente,String finalQueryGlobalFactura) throws Exception {
		CajaEgresoDetalleParameterReturnGeneral  cajaegresodetalleReturnGeneral =new CajaEgresoDetalleParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			cajaegresodetalleReturnGeneral =new CajaEgresoDetalleParameterReturnGeneral();
			
			

			List<CajaEgreso> cajaegresosForeignKey=new ArrayList<CajaEgreso>();
			CajaEgresoLogic cajaegresoLogic=new CajaEgresoLogic();
			cajaegresoLogic.setConnexion(this.connexion);
			cajaegresoLogic.getCajaEgresoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCajaEgreso.equals("NONE")) {
				cajaegresoLogic.getTodosCajaEgresos(finalQueryGlobalCajaEgreso,new Pagination());
				cajaegresosForeignKey=cajaegresoLogic.getCajaEgresos();
			}

			cajaegresodetalleReturnGeneral.setcajaegresosForeignKey(cajaegresosForeignKey);


			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			cajaegresodetalleReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			cajaegresodetalleReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<Cliente> clientesForeignKey=new ArrayList<Cliente>();
			ClienteLogic clienteLogic=new ClienteLogic();
			clienteLogic.setConnexion(this.connexion);
			clienteLogic.getClienteDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCliente.equals("NONE")) {
				clienteLogic.getTodosClientes(finalQueryGlobalCliente,new Pagination());
				clientesForeignKey=clienteLogic.getClientes();
			}

			cajaegresodetalleReturnGeneral.setclientesForeignKey(clientesForeignKey);


			List<Factura> facturasForeignKey=new ArrayList<Factura>();
			FacturaLogic facturaLogic=new FacturaLogic();
			facturaLogic.setConnexion(this.connexion);
			facturaLogic.getFacturaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalFactura.equals("NONE")) {
				facturaLogic.getTodosFacturas(finalQueryGlobalFactura,new Pagination());
				facturasForeignKey=facturaLogic.getFacturas();
			}

			cajaegresodetalleReturnGeneral.setfacturasForeignKey(facturasForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return cajaegresodetalleReturnGeneral;
	}
	
	
	public void deepLoad(CajaEgresoDetalle cajaegresodetalle,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			CajaEgresoDetalleLogicAdditional.updateCajaEgresoDetalleToGet(cajaegresodetalle,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		cajaegresodetalle.setCajaEgreso(cajaegresodetalleDataAccess.getCajaEgreso(connexion,cajaegresodetalle));
		cajaegresodetalle.setEmpresa(cajaegresodetalleDataAccess.getEmpresa(connexion,cajaegresodetalle));
		cajaegresodetalle.setSucursal(cajaegresodetalleDataAccess.getSucursal(connexion,cajaegresodetalle));
		cajaegresodetalle.setCliente(cajaegresodetalleDataAccess.getCliente(connexion,cajaegresodetalle));
		cajaegresodetalle.setFactura(cajaegresodetalleDataAccess.getFactura(connexion,cajaegresodetalle));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(CajaEgreso.class)) {
				cajaegresodetalle.setCajaEgreso(cajaegresodetalleDataAccess.getCajaEgreso(connexion,cajaegresodetalle));
				continue;
			}

			if(clas.clas.equals(Empresa.class)) {
				cajaegresodetalle.setEmpresa(cajaegresodetalleDataAccess.getEmpresa(connexion,cajaegresodetalle));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				cajaegresodetalle.setSucursal(cajaegresodetalleDataAccess.getSucursal(connexion,cajaegresodetalle));
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				cajaegresodetalle.setCliente(cajaegresodetalleDataAccess.getCliente(connexion,cajaegresodetalle));
				continue;
			}

			if(clas.clas.equals(Factura.class)) {
				cajaegresodetalle.setFactura(cajaegresodetalleDataAccess.getFactura(connexion,cajaegresodetalle));
				continue;
			}
		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CajaEgreso.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cajaegresodetalle.setCajaEgreso(cajaegresodetalleDataAccess.getCajaEgreso(connexion,cajaegresodetalle));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cajaegresodetalle.setEmpresa(cajaegresodetalleDataAccess.getEmpresa(connexion,cajaegresodetalle));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cajaegresodetalle.setSucursal(cajaegresodetalleDataAccess.getSucursal(connexion,cajaegresodetalle));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cajaegresodetalle.setCliente(cajaegresodetalleDataAccess.getCliente(connexion,cajaegresodetalle));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Factura.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cajaegresodetalle.setFactura(cajaegresodetalleDataAccess.getFactura(connexion,cajaegresodetalle));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		cajaegresodetalle.setCajaEgreso(cajaegresodetalleDataAccess.getCajaEgreso(connexion,cajaegresodetalle));
		CajaEgresoLogic cajaegresoLogic= new CajaEgresoLogic(connexion);
		cajaegresoLogic.deepLoad(cajaegresodetalle.getCajaEgreso(),isDeep,deepLoadType,clases);
				
		cajaegresodetalle.setEmpresa(cajaegresodetalleDataAccess.getEmpresa(connexion,cajaegresodetalle));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(cajaegresodetalle.getEmpresa(),isDeep,deepLoadType,clases);
				
		cajaegresodetalle.setSucursal(cajaegresodetalleDataAccess.getSucursal(connexion,cajaegresodetalle));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(cajaegresodetalle.getSucursal(),isDeep,deepLoadType,clases);
				
		cajaegresodetalle.setCliente(cajaegresodetalleDataAccess.getCliente(connexion,cajaegresodetalle));
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(cajaegresodetalle.getCliente(),isDeep,deepLoadType,clases);
				
		cajaegresodetalle.setFactura(cajaegresodetalleDataAccess.getFactura(connexion,cajaegresodetalle));
		FacturaLogic facturaLogic= new FacturaLogic(connexion);
		facturaLogic.deepLoad(cajaegresodetalle.getFactura(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(CajaEgreso.class)) {
				cajaegresodetalle.setCajaEgreso(cajaegresodetalleDataAccess.getCajaEgreso(connexion,cajaegresodetalle));
				CajaEgresoLogic cajaegresoLogic= new CajaEgresoLogic(connexion);
				cajaegresoLogic.deepLoad(cajaegresodetalle.getCajaEgreso(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empresa.class)) {
				cajaegresodetalle.setEmpresa(cajaegresodetalleDataAccess.getEmpresa(connexion,cajaegresodetalle));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(cajaegresodetalle.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				cajaegresodetalle.setSucursal(cajaegresodetalleDataAccess.getSucursal(connexion,cajaegresodetalle));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(cajaegresodetalle.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				cajaegresodetalle.setCliente(cajaegresodetalleDataAccess.getCliente(connexion,cajaegresodetalle));
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepLoad(cajaegresodetalle.getCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Factura.class)) {
				cajaegresodetalle.setFactura(cajaegresodetalleDataAccess.getFactura(connexion,cajaegresodetalle));
				FacturaLogic facturaLogic= new FacturaLogic(connexion);
				facturaLogic.deepLoad(cajaegresodetalle.getFactura(),isDeep,deepLoadType,clases);				
				continue;
			}

		}
	}
	else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {


		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CajaEgreso.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cajaegresodetalle.setCajaEgreso(cajaegresodetalleDataAccess.getCajaEgreso(connexion,cajaegresodetalle));
			CajaEgresoLogic cajaegresoLogic= new CajaEgresoLogic(connexion);
			cajaegresoLogic.deepLoad(cajaegresodetalle.getCajaEgreso(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cajaegresodetalle.setEmpresa(cajaegresodetalleDataAccess.getEmpresa(connexion,cajaegresodetalle));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(cajaegresodetalle.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cajaegresodetalle.setSucursal(cajaegresodetalleDataAccess.getSucursal(connexion,cajaegresodetalle));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(cajaegresodetalle.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Cliente.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cajaegresodetalle.setCliente(cajaegresodetalleDataAccess.getCliente(connexion,cajaegresodetalle));
			ClienteLogic clienteLogic= new ClienteLogic(connexion);
			clienteLogic.deepLoad(cajaegresodetalle.getCliente(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Factura.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			cajaegresodetalle.setFactura(cajaegresodetalleDataAccess.getFactura(connexion,cajaegresodetalle));
			FacturaLogic facturaLogic= new FacturaLogic(connexion);
			facturaLogic.deepLoad(cajaegresodetalle.getFactura(),isDeep,deepLoadType,clases);
				
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(CajaEgresoDetalle cajaegresodetalle,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			CajaEgresoDetalleLogicAdditional.updateCajaEgresoDetalleToSave(cajaegresodetalle,this.arrDatoGeneral);
			
CajaEgresoDetalleDataAccess.save(cajaegresodetalle, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		CajaEgresoDataAccess.save(cajaegresodetalle.getCajaEgreso(),connexion);

		EmpresaDataAccess.save(cajaegresodetalle.getEmpresa(),connexion);

		SucursalDataAccess.save(cajaegresodetalle.getSucursal(),connexion);

		ClienteDataAccess.save(cajaegresodetalle.getCliente(),connexion);

		FacturaDataAccess.save(cajaegresodetalle.getFactura(),connexion);
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(CajaEgreso.class)) {
				CajaEgresoDataAccess.save(cajaegresodetalle.getCajaEgreso(),connexion);
				continue;
			}

			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(cajaegresodetalle.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(cajaegresodetalle.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(cajaegresodetalle.getCliente(),connexion);
				continue;
			}

			if(clas.clas.equals(Factura.class)) {
				FacturaDataAccess.save(cajaegresodetalle.getFactura(),connexion);
				continue;
			}

		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		CajaEgresoDataAccess.save(cajaegresodetalle.getCajaEgreso(),connexion);
		CajaEgresoLogic cajaegresoLogic= new CajaEgresoLogic(connexion);
		cajaegresoLogic.deepLoad(cajaegresodetalle.getCajaEgreso(),isDeep,deepLoadType,clases);
				

		EmpresaDataAccess.save(cajaegresodetalle.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(cajaegresodetalle.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(cajaegresodetalle.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(cajaegresodetalle.getSucursal(),isDeep,deepLoadType,clases);
				

		ClienteDataAccess.save(cajaegresodetalle.getCliente(),connexion);
		ClienteLogic clienteLogic= new ClienteLogic(connexion);
		clienteLogic.deepLoad(cajaegresodetalle.getCliente(),isDeep,deepLoadType,clases);
				

		FacturaDataAccess.save(cajaegresodetalle.getFactura(),connexion);
		FacturaLogic facturaLogic= new FacturaLogic(connexion);
		facturaLogic.deepLoad(cajaegresodetalle.getFactura(),isDeep,deepLoadType,clases);
				
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(CajaEgreso.class)) {
				CajaEgresoDataAccess.save(cajaegresodetalle.getCajaEgreso(),connexion);
				CajaEgresoLogic cajaegresoLogic= new CajaEgresoLogic(connexion);
				cajaegresoLogic.deepSave(cajaegresodetalle.getCajaEgreso(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(cajaegresodetalle.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(cajaegresodetalle.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(cajaegresodetalle.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(cajaegresodetalle.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Cliente.class)) {
				ClienteDataAccess.save(cajaegresodetalle.getCliente(),connexion);
				ClienteLogic clienteLogic= new ClienteLogic(connexion);
				clienteLogic.deepSave(cajaegresodetalle.getCliente(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Factura.class)) {
				FacturaDataAccess.save(cajaegresodetalle.getFactura(),connexion);
				FacturaLogic facturaLogic= new FacturaLogic(connexion);
				facturaLogic.deepSave(cajaegresodetalle.getFactura(),isDeep,deepLoadType,clases);				
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
			this.getNewConnexionToDeep(CajaEgresoDetalle.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(cajaegresodetalle,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				CajaEgresoDetalleConstantesFunciones.refrescarForeignKeysDescripcionesCajaEgresoDetalle(cajaegresodetalle);
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
			this.deepLoad(this.cajaegresodetalle,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				CajaEgresoDetalleConstantesFunciones.refrescarForeignKeysDescripcionesCajaEgresoDetalle(this.cajaegresodetalle);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(CajaEgresoDetalle.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(cajaegresodetalles!=null) {
				for(CajaEgresoDetalle cajaegresodetalle:cajaegresodetalles) {
					this.deepLoad(cajaegresodetalle,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					CajaEgresoDetalleConstantesFunciones.refrescarForeignKeysDescripcionesCajaEgresoDetalle(cajaegresodetalles);
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
			if(cajaegresodetalles!=null) {
				for(CajaEgresoDetalle cajaegresodetalle:cajaegresodetalles) {
					this.deepLoad(cajaegresodetalle,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					CajaEgresoDetalleConstantesFunciones.refrescarForeignKeysDescripcionesCajaEgresoDetalle(cajaegresodetalles);
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
			this.getNewConnexionToDeep(CajaEgresoDetalle.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(cajaegresodetalle,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(CajaEgresoDetalle.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(cajaegresodetalles!=null) {
				for(CajaEgresoDetalle cajaegresodetalle:cajaegresodetalles) {
					this.deepSave(cajaegresodetalle,isDeep,deepLoadType,clases);
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
			if(cajaegresodetalles!=null) {
				for(CajaEgresoDetalle cajaegresodetalle:cajaegresodetalles) {
					this.deepSave(cajaegresodetalle,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getCajaEgresoDetallesFK_IdCajaEgresoWithConnection(String sFinalQuery,Pagination pagination,Long id_caja_egreso)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CajaEgresoDetalle.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCajaEgreso= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCajaEgreso.setParameterSelectionGeneralEqual(ParameterType.LONG,id_caja_egreso,CajaEgresoDetalleConstantesFunciones.IDCAJAEGRESO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCajaEgreso);

			CajaEgresoDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCajaEgreso","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cajaegresodetalles=cajaegresodetalleDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CajaEgresoDetalleConstantesFunciones.refrescarForeignKeysDescripcionesCajaEgresoDetalle(this.cajaegresodetalles);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCajaEgresoDetallesFK_IdCajaEgreso(String sFinalQuery,Pagination pagination,Long id_caja_egreso)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCajaEgreso= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCajaEgreso.setParameterSelectionGeneralEqual(ParameterType.LONG,id_caja_egreso,CajaEgresoDetalleConstantesFunciones.IDCAJAEGRESO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCajaEgreso);

			CajaEgresoDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCajaEgreso","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cajaegresodetalles=cajaegresodetalleDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CajaEgresoDetalleConstantesFunciones.refrescarForeignKeysDescripcionesCajaEgresoDetalle(this.cajaegresodetalles);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCajaEgresoDetallesFK_IdClienteWithConnection(String sFinalQuery,Pagination pagination,Long id_cliente)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CajaEgresoDetalle.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente,CajaEgresoDetalleConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			CajaEgresoDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cajaegresodetalles=cajaegresodetalleDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CajaEgresoDetalleConstantesFunciones.refrescarForeignKeysDescripcionesCajaEgresoDetalle(this.cajaegresodetalles);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCajaEgresoDetallesFK_IdCliente(String sFinalQuery,Pagination pagination,Long id_cliente)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCliente= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCliente.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cliente,CajaEgresoDetalleConstantesFunciones.IDCLIENTE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCliente);

			CajaEgresoDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCliente","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cajaegresodetalles=cajaegresodetalleDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CajaEgresoDetalleConstantesFunciones.refrescarForeignKeysDescripcionesCajaEgresoDetalle(this.cajaegresodetalles);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCajaEgresoDetallesFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CajaEgresoDetalle.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,CajaEgresoDetalleConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			CajaEgresoDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cajaegresodetalles=cajaegresodetalleDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CajaEgresoDetalleConstantesFunciones.refrescarForeignKeysDescripcionesCajaEgresoDetalle(this.cajaegresodetalles);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCajaEgresoDetallesFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,CajaEgresoDetalleConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			CajaEgresoDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cajaegresodetalles=cajaegresodetalleDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CajaEgresoDetalleConstantesFunciones.refrescarForeignKeysDescripcionesCajaEgresoDetalle(this.cajaegresodetalles);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCajaEgresoDetallesFK_IdFacturaWithConnection(String sFinalQuery,Pagination pagination,Long id_factura)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CajaEgresoDetalle.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFactura= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFactura.setParameterSelectionGeneralEqual(ParameterType.LONG,id_factura,CajaEgresoDetalleConstantesFunciones.IDFACTURA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFactura);

			CajaEgresoDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFactura","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cajaegresodetalles=cajaegresodetalleDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CajaEgresoDetalleConstantesFunciones.refrescarForeignKeysDescripcionesCajaEgresoDetalle(this.cajaegresodetalles);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCajaEgresoDetallesFK_IdFactura(String sFinalQuery,Pagination pagination,Long id_factura)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidFactura= new ParameterSelectionGeneral();
			parameterSelectionGeneralidFactura.setParameterSelectionGeneralEqual(ParameterType.LONG,id_factura,CajaEgresoDetalleConstantesFunciones.IDFACTURA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidFactura);

			CajaEgresoDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdFactura","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cajaegresodetalles=cajaegresodetalleDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CajaEgresoDetalleConstantesFunciones.refrescarForeignKeysDescripcionesCajaEgresoDetalle(this.cajaegresodetalles);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getCajaEgresoDetallesFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,CajaEgresoDetalle.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,CajaEgresoDetalleConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			CajaEgresoDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cajaegresodetalles=cajaegresodetalleDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CajaEgresoDetalleConstantesFunciones.refrescarForeignKeysDescripcionesCajaEgresoDetalle(this.cajaegresodetalles);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getCajaEgresoDetallesFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,CajaEgresoDetalleConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			CajaEgresoDetalleLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			cajaegresodetalles=cajaegresodetalleDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				CajaEgresoDetalleConstantesFunciones.refrescarForeignKeysDescripcionesCajaEgresoDetalle(this.cajaegresodetalles);
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
			if(CajaEgresoDetalleConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,CajaEgresoDetalleDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,CajaEgresoDetalle cajaegresodetalle,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(CajaEgresoDetalleConstantesFunciones.ISCONAUDITORIA) {
				if(cajaegresodetalle.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,CajaEgresoDetalleDataAccess.TABLENAME, cajaegresodetalle.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(CajaEgresoDetalleConstantesFunciones.ISCONAUDITORIADETALLE) {
						////CajaEgresoDetalleLogic.registrarAuditoriaDetallesCajaEgresoDetalle(connexion,cajaegresodetalle,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(cajaegresodetalle.getIsDeleted()) {
					/*if(!cajaegresodetalle.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,CajaEgresoDetalleDataAccess.TABLENAME, cajaegresodetalle.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////CajaEgresoDetalleLogic.registrarAuditoriaDetallesCajaEgresoDetalle(connexion,cajaegresodetalle,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,CajaEgresoDetalleDataAccess.TABLENAME, cajaegresodetalle.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(cajaegresodetalle.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,CajaEgresoDetalleDataAccess.TABLENAME, cajaegresodetalle.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(CajaEgresoDetalleConstantesFunciones.ISCONAUDITORIADETALLE) {
						////CajaEgresoDetalleLogic.registrarAuditoriaDetallesCajaEgresoDetalle(connexion,cajaegresodetalle,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesCajaEgresoDetalle(Connexion connexion,CajaEgresoDetalle cajaegresodetalle)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(cajaegresodetalle.getIsNew()||!cajaegresodetalle.getid_caja_egreso().equals(cajaegresodetalle.getCajaEgresoDetalleOriginal().getid_caja_egreso()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cajaegresodetalle.getCajaEgresoDetalleOriginal().getid_caja_egreso()!=null)
				{
					strValorActual=cajaegresodetalle.getCajaEgresoDetalleOriginal().getid_caja_egreso().toString();
				}
				if(cajaegresodetalle.getid_caja_egreso()!=null)
				{
					strValorNuevo=cajaegresodetalle.getid_caja_egreso().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CajaEgresoDetalleConstantesFunciones.IDCAJAEGRESO,strValorActual,strValorNuevo);
			}	
			
			if(cajaegresodetalle.getIsNew()||!cajaegresodetalle.getid_empresa().equals(cajaegresodetalle.getCajaEgresoDetalleOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cajaegresodetalle.getCajaEgresoDetalleOriginal().getid_empresa()!=null)
				{
					strValorActual=cajaegresodetalle.getCajaEgresoDetalleOriginal().getid_empresa().toString();
				}
				if(cajaegresodetalle.getid_empresa()!=null)
				{
					strValorNuevo=cajaegresodetalle.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CajaEgresoDetalleConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(cajaegresodetalle.getIsNew()||!cajaegresodetalle.getid_sucursal().equals(cajaegresodetalle.getCajaEgresoDetalleOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cajaegresodetalle.getCajaEgresoDetalleOriginal().getid_sucursal()!=null)
				{
					strValorActual=cajaegresodetalle.getCajaEgresoDetalleOriginal().getid_sucursal().toString();
				}
				if(cajaegresodetalle.getid_sucursal()!=null)
				{
					strValorNuevo=cajaegresodetalle.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CajaEgresoDetalleConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(cajaegresodetalle.getIsNew()||!cajaegresodetalle.getid_cliente().equals(cajaegresodetalle.getCajaEgresoDetalleOriginal().getid_cliente()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cajaegresodetalle.getCajaEgresoDetalleOriginal().getid_cliente()!=null)
				{
					strValorActual=cajaegresodetalle.getCajaEgresoDetalleOriginal().getid_cliente().toString();
				}
				if(cajaegresodetalle.getid_cliente()!=null)
				{
					strValorNuevo=cajaegresodetalle.getid_cliente().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CajaEgresoDetalleConstantesFunciones.IDCLIENTE,strValorActual,strValorNuevo);
			}	
			
			if(cajaegresodetalle.getIsNew()||!cajaegresodetalle.getid_factura().equals(cajaegresodetalle.getCajaEgresoDetalleOriginal().getid_factura()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cajaegresodetalle.getCajaEgresoDetalleOriginal().getid_factura()!=null)
				{
					strValorActual=cajaegresodetalle.getCajaEgresoDetalleOriginal().getid_factura().toString();
				}
				if(cajaegresodetalle.getid_factura()!=null)
				{
					strValorNuevo=cajaegresodetalle.getid_factura().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CajaEgresoDetalleConstantesFunciones.IDFACTURA,strValorActual,strValorNuevo);
			}	
			
			if(cajaegresodetalle.getIsNew()||!cajaegresodetalle.getconcepto().equals(cajaegresodetalle.getCajaEgresoDetalleOriginal().getconcepto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cajaegresodetalle.getCajaEgresoDetalleOriginal().getconcepto()!=null)
				{
					strValorActual=cajaegresodetalle.getCajaEgresoDetalleOriginal().getconcepto();
				}
				if(cajaegresodetalle.getconcepto()!=null)
				{
					strValorNuevo=cajaegresodetalle.getconcepto() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CajaEgresoDetalleConstantesFunciones.CONCEPTO,strValorActual,strValorNuevo);
			}	
			
			if(cajaegresodetalle.getIsNew()||!cajaegresodetalle.getvalor().equals(cajaegresodetalle.getCajaEgresoDetalleOriginal().getvalor()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(cajaegresodetalle.getCajaEgresoDetalleOriginal().getvalor()!=null)
				{
					strValorActual=cajaegresodetalle.getCajaEgresoDetalleOriginal().getvalor().toString();
				}
				if(cajaegresodetalle.getvalor()!=null)
				{
					strValorNuevo=cajaegresodetalle.getvalor().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),CajaEgresoDetalleConstantesFunciones.VALOR,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveCajaEgresoDetalleRelacionesWithConnection(CajaEgresoDetalle cajaegresodetalle) throws Exception {

		if(!cajaegresodetalle.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveCajaEgresoDetalleRelacionesBase(cajaegresodetalle,true);
		}
	}

	public void saveCajaEgresoDetalleRelaciones(CajaEgresoDetalle cajaegresodetalle)throws Exception {

		if(!cajaegresodetalle.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveCajaEgresoDetalleRelacionesBase(cajaegresodetalle,false);
		}
	}

	public void saveCajaEgresoDetalleRelacionesBase(CajaEgresoDetalle cajaegresodetalle,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("CajaEgresoDetalle-saveRelacionesWithConnection");}
	

			this.setCajaEgresoDetalle(cajaegresodetalle);

			if(CajaEgresoDetalleLogicAdditional.validarSaveRelaciones(cajaegresodetalle,this)) {

				CajaEgresoDetalleLogicAdditional.updateRelacionesToSave(cajaegresodetalle,this);

				if((cajaegresodetalle.getIsNew()||cajaegresodetalle.getIsChanged())&&!cajaegresodetalle.getIsDeleted()) {
					this.saveCajaEgresoDetalle();
					this.saveCajaEgresoDetalleRelacionesDetalles();

				} else if(cajaegresodetalle.getIsDeleted()) {
					this.saveCajaEgresoDetalleRelacionesDetalles();
					this.saveCajaEgresoDetalle();
				}

				CajaEgresoDetalleLogicAdditional.updateRelacionesToSaveAfter(cajaegresodetalle,this);

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
	
	
	private void saveCajaEgresoDetalleRelacionesDetalles()throws Exception {
		try {
	

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfCajaEgresoDetalle(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=CajaEgresoDetalleConstantesFunciones.getClassesForeignKeysOfCajaEgresoDetalle(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfCajaEgresoDetalle(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=CajaEgresoDetalleConstantesFunciones.getClassesRelationshipsOfCajaEgresoDetalle(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
