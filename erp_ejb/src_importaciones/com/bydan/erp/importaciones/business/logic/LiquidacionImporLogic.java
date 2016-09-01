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
package com.bydan.erp.importaciones.business.logic;

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
import com.bydan.erp.importaciones.util.*;
import com.bydan.erp.importaciones.util.LiquidacionImporConstantesFunciones;
import com.bydan.erp.importaciones.util.LiquidacionImporParameterReturnGeneral;
//import com.bydan.erp.importaciones.util.LiquidacionImporParameterGeneral;
import com.bydan.erp.importaciones.business.entity.LiquidacionImpor;
import com.bydan.erp.importaciones.business.logic.LiquidacionImporLogicAdditional;
import com.bydan.erp.importaciones.business.dataaccess.*;
import com.bydan.erp.importaciones.business.entity.*;

import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.seguridad.business.logic.*;
import com.bydan.erp.contabilidad.business.logic.*;
import com.bydan.erp.inventario.business.logic.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.inventario.util.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;








@SuppressWarnings("unused")
public class LiquidacionImporLogic  extends GeneralEntityLogic  {
	static Logger logger = Logger.getLogger(LiquidacionImporLogic.class);
	
	protected LiquidacionImporDataAccess liquidacionimporDataAccess; 	
	protected LiquidacionImpor liquidacionimpor;
	protected List<LiquidacionImpor> liquidacionimpors;
	protected Object liquidacionimporObject;	
	protected List<Object> liquidacionimporsObject;
	
	public static ClassValidator<LiquidacionImpor> liquidacionimporValidator = new ClassValidator<LiquidacionImpor>(LiquidacionImpor.class);	
	public InvalidValue[] invalidValues=null;
	public StringBuilder stringBuilder=new StringBuilder();
	public Boolean conMostrarMensajesStringBuilder=true;
	
	
	protected LiquidacionImporLogicAdditional liquidacionimporLogicAdditional=null;
	
	public LiquidacionImporLogicAdditional getLiquidacionImporLogicAdditional() {
		return this.liquidacionimporLogicAdditional;
	}
	
	public void setLiquidacionImporLogicAdditional(LiquidacionImporLogicAdditional liquidacionimporLogicAdditional) {
		try {
			this.liquidacionimporLogicAdditional=liquidacionimporLogicAdditional;
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
	
	
	
	
	public  LiquidacionImporLogic()throws SQLException,Exception {
		super();
		
		try	{						
			this.liquidacionimporDataAccess = new LiquidacionImporDataAccess();
			
			this.liquidacionimpors= new ArrayList<LiquidacionImpor>();
			this.liquidacionimpor= new LiquidacionImpor();
			
			this.liquidacionimporObject=new Object();
			this.liquidacionimporsObject=new ArrayList<Object>();
				
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
			
			this.liquidacionimporDataAccess.setConnexionType(this.connexionType);
			this.liquidacionimporDataAccess.setParameterDbType(this.parameterDbType);
			
			
	
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}	 
    }
	
	public  LiquidacionImporLogic(Connexion newConnexion)throws Exception {
		super(newConnexion);
		
		try	{						
			//this.connexion=newConnexion;
			
			this.liquidacionimporDataAccess = new LiquidacionImporDataAccess();
			this.liquidacionimpors= new ArrayList<LiquidacionImpor>();
			this.liquidacionimpor= new LiquidacionImpor();
			this.liquidacionimporObject=new Object();
			this.liquidacionimporsObject=new ArrayList<Object>();
			
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
			
			this.liquidacionimporDataAccess.setConnexionType(this.connexionType);
			this.liquidacionimporDataAccess.setParameterDbType(this.parameterDbType);
			
			
			
			
			
			
			this.invalidValues=new InvalidValue[0];
			this.stringBuilder=new StringBuilder();
			this.conMostrarMensajesStringBuilder=true;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
	  	}	 
    }
	
	public LiquidacionImpor getLiquidacionImpor() throws Exception {	
		LiquidacionImporLogicAdditional.checkLiquidacionImporToGet(liquidacionimpor,this.datosCliente,this.arrDatoGeneral);
		LiquidacionImporLogicAdditional.updateLiquidacionImporToGet(liquidacionimpor,this.arrDatoGeneral);
		
		return liquidacionimpor;
	}
		
	public void setLiquidacionImpor(LiquidacionImpor newLiquidacionImpor) {
		this.liquidacionimpor = newLiquidacionImpor;
	}
	
	public LiquidacionImporDataAccess getLiquidacionImporDataAccess() {
		return liquidacionimporDataAccess;
	}
	
	public void setLiquidacionImporDataAccess(LiquidacionImporDataAccess newliquidacionimporDataAccess) {
		this.liquidacionimporDataAccess = newliquidacionimporDataAccess;
	}
	
	public List<LiquidacionImpor> getLiquidacionImpors() throws Exception {		
		this.quitarLiquidacionImporsNulos();
		
		LiquidacionImporLogicAdditional.checkLiquidacionImporToGets(liquidacionimpors,this.datosCliente,this.arrDatoGeneral);
		
		for (LiquidacionImpor liquidacionimporLocal: liquidacionimpors ) {
			LiquidacionImporLogicAdditional.updateLiquidacionImporToGet(liquidacionimporLocal,this.arrDatoGeneral);
		}
		
		return liquidacionimpors;
	}
	
	public void setLiquidacionImpors(List<LiquidacionImpor> newLiquidacionImpors) {
		this.liquidacionimpors = newLiquidacionImpors;
	}
	
	public Object getLiquidacionImporObject() {	
		this.liquidacionimporObject=this.liquidacionimporDataAccess.getEntityObject();
		return this.liquidacionimporObject;
	}
		
	public void setLiquidacionImporObject(Object newLiquidacionImporObject) {
		this.liquidacionimporObject = newLiquidacionImporObject;
	}
	
	public List<Object> getLiquidacionImporsObject() {		
		this.liquidacionimporsObject=this.liquidacionimporDataAccess.getEntitiesObject();
		return this.liquidacionimporsObject;
	}
		
	public void setLiquidacionImporsObject(List<Object> newLiquidacionImporsObject) {
		this.liquidacionimporsObject = newLiquidacionImporsObject;
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
		
		if(this.liquidacionimporDataAccess!=null) {
			this.liquidacionimporDataAccess.setDatosCliente(datosCliente);
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
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LiquidacionImpor.class.getSimpleName()+"-executeQueryWithConnection");connexion.begin();	
					
			liquidacionimporDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
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
			liquidacionimporDataAccess.executeQuery(connexion, sQueryExecute);   	       	 
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(Long id) throws Exception {
		liquidacionimpor = new  LiquidacionImpor();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LiquidacionImpor.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			liquidacionimpor=liquidacionimporDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.liquidacionimpor,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				LiquidacionImporConstantesFunciones.refrescarForeignKeysDescripcionesLiquidacionImpor(this.liquidacionimpor);
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
		liquidacionimpor = new  LiquidacionImpor();
		  		  
        try {
			
			liquidacionimpor=liquidacionimporDataAccess.getEntity(connexion, id);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.liquidacionimpor,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				LiquidacionImporConstantesFunciones.refrescarForeignKeysDescripcionesLiquidacionImpor(this.liquidacionimpor);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public  void getEntityWithConnection(QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		liquidacionimpor = new  LiquidacionImpor();
		  		  
        try {
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LiquidacionImpor.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();	
					
			liquidacionimpor=liquidacionimporDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.liquidacionimpor,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				LiquidacionImporConstantesFunciones.refrescarForeignKeysDescripcionesLiquidacionImpor(this.liquidacionimpor);
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
		liquidacionimpor = new  LiquidacionImpor();
		  		  
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
		liquidacionimpor = new  LiquidacionImpor();
		  		  
        try {
			
			liquidacionimpor=liquidacionimporDataAccess.getEntity(connexion, queryWhereSelectParameters);   	       	 
			
			if(this.isConDeep) {
				this.deepLoad(this.liquidacionimpor,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
				
				LiquidacionImporConstantesFunciones.refrescarForeignKeysDescripcionesLiquidacionImpor(this.liquidacionimpor);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntity(String sFinalQuery) throws Exception {
		liquidacionimpor = new  LiquidacionImpor();
		  		  
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
		liquidacionimpor = new  LiquidacionImpor();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LiquidacionImpor.class.getSimpleName()+"-getEntityDatoGeneralMinimoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMinimo =liquidacionimporDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		liquidacionimpor = new  LiquidacionImpor();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		DatoGeneralMinimo datoGeneralMinimo = new DatoGeneralMinimo();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMinimo=liquidacionimporDataAccess.getEntityDatoGeneralMinimoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMinimo;
	}
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		liquidacionimpor = new  LiquidacionImpor();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LiquidacionImpor.class.getSimpleName()+"-getEntitiesDatoGeneralGenericoWithConnection");connexion.begin();	
			
			datoGenerals =liquidacionimporDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		liquidacionimpor = new  LiquidacionImpor();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGenerals=liquidacionimporDataAccess.getEntitiesDatoGeneralGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGenerals;
	}
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenericoWithConnection(String sSelectQuery,String sFinalQuery,ArrayList<Classe> classes) throws Exception {
		liquidacionimpor = new  LiquidacionImpor();
		  
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
						
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LiquidacionImpor.class.getSimpleName()+"-getEntitiesDatoGeneralMaximoGenericoWithConnection");connexion.begin();	
			
			datoGeneralMaximos =liquidacionimporDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 
			
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
		liquidacionimpor = new  LiquidacionImpor();
		
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		
        try {
			
			queryWhereSelectParameters.setSelectQuery(sSelectQuery);			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			datoGeneralMaximos=liquidacionimporDataAccess.getEntitiesDatoGeneralMaximoGenerico(connexion, queryWhereSelectParameters,classes);   	       	 			
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
		
		return datoGeneralMaximos;
	}
	
	

	public  void getEntitiesWithConnection(QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		liquidacionimpors = new  ArrayList<LiquidacionImpor>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LiquidacionImpor.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();
			
			LiquidacionImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			liquidacionimpors=liquidacionimporDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarLiquidacionImpor(liquidacionimpors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				LiquidacionImporConstantesFunciones.refrescarForeignKeysDescripcionesLiquidacionImpor(this.liquidacionimpors);
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
		liquidacionimpors = new  ArrayList<LiquidacionImpor>();
		  		  
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
		liquidacionimpors = new  ArrayList<LiquidacionImpor>();
		  		  
        try {			
			LiquidacionImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIES","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			liquidacionimpors=liquidacionimporDataAccess.getEntities(connexion, queryWhereSelectParameters);    	       	 			
		
			this.validarGuardarManejarLiquidacionImpor(liquidacionimpors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				LiquidacionImporConstantesFunciones.refrescarForeignKeysDescripcionesLiquidacionImpor(this.liquidacionimpors);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntities(String sFinalQuery)throws Exception {	
		liquidacionimpors = new  ArrayList<LiquidacionImpor>();
		  		  
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
		liquidacionimpors = new  ArrayList<LiquidacionImpor>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LiquidacionImpor.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			LiquidacionImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			liquidacionimpors=liquidacionimporDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarLiquidacionImpor(liquidacionimpors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				LiquidacionImporConstantesFunciones.refrescarForeignKeysDescripcionesLiquidacionImpor(this.liquidacionimpors);
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
		liquidacionimpors = new  ArrayList<LiquidacionImpor>();
		  		  
        try {
			LiquidacionImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			liquidacionimpors=liquidacionimporDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarLiquidacionImpor(liquidacionimpors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				LiquidacionImporConstantesFunciones.refrescarForeignKeysDescripcionesLiquidacionImpor(this.liquidacionimpors);
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
		liquidacionimpors = new  ArrayList<LiquidacionImpor>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LiquidacionImpor.class.getSimpleName()+"-getEntitiesWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			LiquidacionImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			liquidacionimpors=liquidacionimporDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarLiquidacionImpor(liquidacionimpors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				LiquidacionImporConstantesFunciones.refrescarForeignKeysDescripcionesLiquidacionImpor(this.liquidacionimpors);
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
		liquidacionimpors = new  ArrayList<LiquidacionImpor>();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			LiquidacionImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			liquidacionimpors=liquidacionimporDataAccess.getEntities(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarLiquidacionImpor(liquidacionimpors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				LiquidacionImporConstantesFunciones.refrescarForeignKeysDescripcionesLiquidacionImpor(this.liquidacionimpors);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public  void getEntityWithConnection(String sQuerySelect,String sFinalQuery,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico)throws Exception {	
		liquidacionimpor = new  LiquidacionImpor();
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LiquidacionImpor.class.getSimpleName()+"-getEntityWithConnection");connexion.begin();			
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			LiquidacionImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			liquidacionimpor=liquidacionimporDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarLiquidacionImpor(liquidacionimpor);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				LiquidacionImporConstantesFunciones.refrescarForeignKeysDescripcionesLiquidacionImpor(this.liquidacionimpor);
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
		liquidacionimpor = new  LiquidacionImpor();
		 
		QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
		
        try {
			
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			LiquidacionImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESWITHSELECT","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			liquidacionimpor=liquidacionimporDataAccess.getEntity(connexion,sQuerySelect, queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);    	       	 
			
			this.validarGuardarManejarLiquidacionImpor(liquidacionimpor);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				LiquidacionImporConstantesFunciones.refrescarForeignKeysDescripcionesLiquidacionImpor(this.liquidacionimpor);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public  void getEntitiesSimpleQueryBuildWithConnection(String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception {	
		liquidacionimpors = new  ArrayList<LiquidacionImpor>();
		  		  
        try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LiquidacionImpor.class.getSimpleName()+"-getEntitiesSimpleQueryBuildWithConnection");connexion.begin();			
			
			LiquidacionImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			liquidacionimpors=liquidacionimporDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarLiquidacionImpor(liquidacionimpors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				LiquidacionImporConstantesFunciones.refrescarForeignKeysDescripcionesLiquidacionImpor(this.liquidacionimpors);
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
		liquidacionimpors = new  ArrayList<LiquidacionImpor>();
		  		  
        try {
			LiquidacionImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"GETENTITIESSIMPLEQUERY","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			liquidacionimpors=liquidacionimporDataAccess.getEntitiesSimpleQueryBuild(connexion,sQuerySelect, queryWhereSelectParameters);    	       	 
			
			this.validarGuardarManejarLiquidacionImpor(liquidacionimpors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				LiquidacionImporConstantesFunciones.refrescarForeignKeysDescripcionesLiquidacionImpor(this.liquidacionimpors);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	
	public void getTodosLiquidacionImporsWithConnection(String sFinalQuery,Pagination pagination)throws Exception {
		liquidacionimpors = new  ArrayList<LiquidacionImpor>();
		
		try {
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LiquidacionImpor.class.getSimpleName()+"-getTodosLiquidacionImporsWithConnection");connexion.begin();			
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			LiquidacionImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			liquidacionimpors=liquidacionimporDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarLiquidacionImpor(liquidacionimpors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				LiquidacionImporConstantesFunciones.refrescarForeignKeysDescripcionesLiquidacionImpor(this.liquidacionimpors);
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
	
	public  void  getTodosLiquidacionImpors(String sFinalQuery,Pagination pagination)throws Exception {
		liquidacionimpors = new  ArrayList<LiquidacionImpor>();
		
		try {
			
			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters("");	
			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);
			
			LiquidacionImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"TODOS","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			liquidacionimpors=liquidacionimporDataAccess.getEntities(connexion,queryWhereSelectParameters);				
			
			this.validarGuardarManejarLiquidacionImpor(liquidacionimpors);
			
			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());
				
				LiquidacionImporConstantesFunciones.refrescarForeignKeysDescripcionesLiquidacionImpor(this.liquidacionimpors);
			}
			
		} catch(Exception e) {	
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}		
	}
	
	
	public Boolean validarGuardarLiquidacionImpor(LiquidacionImpor liquidacionimpor) throws Exception {
		Boolean estaValidado=false;
		
		if(liquidacionimpor.getIsNew() || liquidacionimpor.getIsChanged()) { 
			this.invalidValues = liquidacionimporValidator.getInvalidValues(liquidacionimpor);
						
			if(this.invalidValues==null || this.invalidValues.length<=0) {
				estaValidado=true;
			} else {
				this.guardarInvalidValues(liquidacionimpor);	
			}
		} else {
			estaValidado=true;
		}
		
		return estaValidado;
	}
	
	public Boolean validarGuardarLiquidacionImpor(List<LiquidacionImpor> LiquidacionImpors) throws Exception {
		Boolean estaValidado=true;
		Boolean estaValidadoObjeto=false;
		
		for(LiquidacionImpor liquidacionimporLocal:liquidacionimpors) {				
			estaValidadoObjeto=this.validarGuardarLiquidacionImpor(liquidacionimporLocal);
			
			if(!estaValidadoObjeto) {
				if(estaValidado) {
					estaValidado=false;
				}
			}
		}
		
		return estaValidado;
	}
	
	public void validarGuardarManejarLiquidacionImpor(List<LiquidacionImpor> LiquidacionImpors) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarLiquidacionImpor(liquidacionimpors)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void validarGuardarManejarLiquidacionImpor(LiquidacionImpor LiquidacionImpor) throws Exception {	
		if(Constantes2.ISDEVELOPING_VALIDACIONDATOS_TRAER) {
			if(!this.validarGuardarLiquidacionImpor(liquidacionimpor)) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
		}
	}
	
	public void guardarInvalidValues(LiquidacionImpor liquidacionimpor) throws Exception {
		String sCampo="";
		String sMensajeCampo="";
		String sMensaje="";
		String sIdMensaje="";
		
		sIdMensaje="\r\nID="+liquidacionimpor.getId();
		sMensaje+=sIdMensaje;		
		
		for (InvalidValue invalidValue : this.invalidValues) {
			sCampo=LiquidacionImporConstantesFunciones.getLiquidacionImporLabelDesdeNombre(invalidValue.getPropertyName());
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
			
			Funciones.manageException(logger,this.stringBuilder,this.datosCliente.getDatosExportar().getsPath(),"liquidacionimpor","validar_datos");
			
			if(ConstantesMensajes.CON_MOSTRAR_MENSAJES_DETALLE) {
				throw new Exception(LiquidacionImporConstantesFunciones.SCLASSWEBTITULO + sMensajeDetalleExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			} else {
				throw new Exception(LiquidacionImporConstantesFunciones.SCLASSWEBTITULO + sMensajeExcepcion);//ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS
			}
		}
	}
	
	public void saveLiquidacionImporWithConnection()throws Exception {	
		try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LiquidacionImpor.class.getSimpleName()+"-saveLiquidacionImporWithConnection");connexion.begin();			
			
			LiquidacionImporLogicAdditional.checkLiquidacionImporToSave(this.liquidacionimpor,this.datosCliente,connexion,this.arrDatoGeneral);
			
			LiquidacionImporLogicAdditional.updateLiquidacionImporToSave(this.liquidacionimpor,this.arrDatoGeneral);
			
			LiquidacionImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.liquidacionimpor,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			//TEMPORAL
			//this.getSetVersionRowLiquidacionImpor();
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarLiquidacionImpor(this.liquidacionimpor)) {
				LiquidacionImporDataAccess.save(this.liquidacionimpor, connexion);	    	       	 
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}
			
			if(this.isConDeep) {
				this.deepSave(this.liquidacionimpor,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			LiquidacionImporLogicAdditional.checkLiquidacionImporToSaveAfter(this.liquidacionimpor,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowLiquidacionImpor();
			
			connexion.commit();			
			
			if(this.liquidacionimpor.getIsDeleted()) {
				this.liquidacionimpor=null;
			}
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();			
		}
	}
	
	public void saveLiquidacionImpor()throws Exception {	
		try {	
			
			LiquidacionImporLogicAdditional.checkLiquidacionImporToSave(this.liquidacionimpor,this.datosCliente,connexion,this.arrDatoGeneral);
			
			LiquidacionImporLogicAdditional.updateLiquidacionImporToSave(this.liquidacionimpor,this.arrDatoGeneral);
			
			LiquidacionImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),this.liquidacionimpor,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
			
			
			this.stringBuilder=new StringBuilder();
			
			if(this.validarGuardarLiquidacionImpor(this.liquidacionimpor)) {			
				LiquidacionImporDataAccess.save(this.liquidacionimpor, connexion);	    	       	 			
			} else {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);	
				}
			}

			if(this.isConDeep) {
				this.deepSave(this.liquidacionimpor,this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases());
			}
			
			LiquidacionImporLogicAdditional.checkLiquidacionImporToSaveAfter(this.liquidacionimpor,this.datosCliente,connexion,this.arrDatoGeneral);
			
			if(this.liquidacionimpor.getIsDeleted()) {
				this.liquidacionimpor=null;
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public void saveLiquidacionImporsWithConnection()throws Exception {				
		 try {	
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LiquidacionImpor.class.getSimpleName()+"-saveLiquidacionImporsWithConnection");connexion.begin();			
			
			LiquidacionImporLogicAdditional.checkLiquidacionImporToSaves(liquidacionimpors,this.datosCliente,connexion,this.arrDatoGeneral);
			
			//TEMPORAL
			//this.getSetVersionRowLiquidacionImpors();
			
			Boolean validadoTodosLiquidacionImpor=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(LiquidacionImpor liquidacionimporLocal:liquidacionimpors) {		
				if(liquidacionimporLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				LiquidacionImporLogicAdditional.updateLiquidacionImporToSave(liquidacionimporLocal,this.arrDatoGeneral);
	        	
				LiquidacionImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),liquidacionimporLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarLiquidacionImpor(liquidacionimporLocal)) {
					LiquidacionImporDataAccess.save(liquidacionimporLocal, connexion);				
				} else {
					validadoTodosLiquidacionImpor=false;
				}
			}
			
			if(!validadoTodosLiquidacionImpor) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			LiquidacionImporLogicAdditional.checkLiquidacionImporToSavesAfter(liquidacionimpors,this.datosCliente,connexion,this.arrDatoGeneral);
					
			//SOLO FUNCIONA PARA ACTUALIZAR Y CON CONNEXION
			this.getSetVersionRowLiquidacionImpors();
			
			connexion.commit();		
			
			this.quitarLiquidacionImporsEliminados();
			
		} catch(Exception e) {
			connexion.rollback();			
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			connexion.close();				
		}
	}
	
	public void saveLiquidacionImpors()throws Exception {				
		 try {	
			LiquidacionImporLogicAdditional.checkLiquidacionImporToSaves(liquidacionimpors,this.datosCliente,connexion,this.arrDatoGeneral);
			
			Boolean validadoTodosLiquidacionImpor=true;
			this.stringBuilder=new StringBuilder();
			
	   		for(LiquidacionImpor liquidacionimporLocal:liquidacionimpors) {				
				if(liquidacionimporLocal.getsType().contains(Constantes2.S_TOTALES)) {
					continue;
				}
				
				LiquidacionImporLogicAdditional.updateLiquidacionImporToSave(liquidacionimporLocal,this.arrDatoGeneral);
	        	
				LiquidacionImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),liquidacionimporLocal,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());
	   
				
				if(this.validarGuardarLiquidacionImpor(liquidacionimporLocal)) {				
					LiquidacionImporDataAccess.save(liquidacionimporLocal, connexion);				
				} else {
					validadoTodosLiquidacionImpor=false;
				}
			}
			
			if(!validadoTodosLiquidacionImpor) {
				//SE GENERA EXCEPTION
				if(this.conMostrarMensajesStringBuilder) {
					this.manejarMensajesStringBuilder(ConstantesMensajes.SMENSAJEEXCEPCION_VALIDACIONDATOS);
				}
			}
			
			if(this.isConDeep) {
				this.deepSaves(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(), this.datosDeep.getSTituloMensaje());
			}
			
			LiquidacionImporLogicAdditional.checkLiquidacionImporToSavesAfter(liquidacionimpors,this.datosCliente,connexion,this.arrDatoGeneral);
			
			this.quitarLiquidacionImporsEliminados();
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public LiquidacionImporParameterReturnGeneral procesarAccionLiquidacionImpors(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<LiquidacionImpor> liquidacionimpors,LiquidacionImporParameterReturnGeneral liquidacionimporParameterGeneral)throws Exception {
		 try {	
			LiquidacionImporParameterReturnGeneral liquidacionimporReturnGeneral=new LiquidacionImporParameterReturnGeneral();
	
			LiquidacionImporLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,liquidacionimpors,liquidacionimporParameterGeneral,liquidacionimporReturnGeneral);
			
			return liquidacionimporReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
	
	public LiquidacionImporParameterReturnGeneral procesarAccionLiquidacionImporsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,String sProceso,List<LiquidacionImpor> liquidacionimpors,LiquidacionImporParameterReturnGeneral liquidacionimporParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LiquidacionImpor.class.getSimpleName()+"-procesarAccionLiquidacionImporsWithConnection");connexion.begin();			
			
			LiquidacionImporParameterReturnGeneral liquidacionimporReturnGeneral=new LiquidacionImporParameterReturnGeneral();
	
			LiquidacionImporLogicAdditional.procesarAccions(parametroGeneralUsuario,modulo,opcion,usuario,this,sProceso,liquidacionimpors,liquidacionimporParameterGeneral,liquidacionimporReturnGeneral);
			
			this.connexion.commit();
			
			return liquidacionimporReturnGeneral;
			
		} catch(Exception e) {
			
			this.connexion.rollback();
			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public LiquidacionImporParameterReturnGeneral procesarEventosLiquidacionImpors(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<LiquidacionImpor> liquidacionimpors,LiquidacionImpor liquidacionimpor,LiquidacionImporParameterReturnGeneral liquidacionimporParameterGeneral,Boolean isEsNuevoLiquidacionImpor,ArrayList<Classe> clases)throws Exception {
		 try {	
			LiquidacionImporParameterReturnGeneral liquidacionimporReturnGeneral=new LiquidacionImporParameterReturnGeneral();
	
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				liquidacionimporReturnGeneral.setConRecargarPropiedades(true);
			}
			
			LiquidacionImporLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,liquidacionimpors,liquidacionimpor,liquidacionimporParameterGeneral,liquidacionimporReturnGeneral,isEsNuevoLiquidacionImpor,clases);
			
			return liquidacionimporReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			;
		}
	}
		
	public LiquidacionImporParameterReturnGeneral procesarEventosLiquidacionImporsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo moduloActual,Opcion opcionActual,Usuario usuarioActual,EventoGlobalTipo eventoGlobalTipo,ControlTipo controlTipo,EventoTipo eventoTipo,EventoSubTipo eventoSubTipo,String sTipo,List<LiquidacionImpor> liquidacionimpors,LiquidacionImpor liquidacionimpor,LiquidacionImporParameterReturnGeneral liquidacionimporParameterGeneral,Boolean isEsNuevoLiquidacionImpor,ArrayList<Classe> clases)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LiquidacionImpor.class.getSimpleName()+"-procesarEventosLiquidacionImporsWithConnection");connexion.begin();			
			
			LiquidacionImporParameterReturnGeneral liquidacionimporReturnGeneral=new LiquidacionImporParameterReturnGeneral();
	
			liquidacionimporReturnGeneral.setLiquidacionImpor(liquidacionimpor);
			
			//SI ES PARA FORMULARIO-> NUEVO PREPARAR, RECARGAR POR DEFECTO FORMULARIO (PARA MANEJAR VALORES POR DEFECTO)
			if(eventoGlobalTipo.equals(EventoGlobalTipo.FORM_RECARGAR) && controlTipo.equals(ControlTipo.FORM) 
				&& eventoTipo.equals(EventoTipo.LOAD) && eventoSubTipo.equals(EventoSubTipo.NEW) 
				&& sTipo.equals("FORM")) {
				
				liquidacionimporReturnGeneral.setConRecargarPropiedades(true);
			}
			
			LiquidacionImporLogicAdditional.procesarEventos(parametroGeneralUsuario,moduloActual,opcionActual,usuarioActual,this,eventoGlobalTipo,controlTipo,eventoTipo,eventoSubTipo,sTipo,liquidacionimpors,liquidacionimpor,liquidacionimporParameterGeneral,liquidacionimporReturnGeneral,isEsNuevoLiquidacionImpor,clases);
			
			this.connexion.commit();
			
			return liquidacionimporReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public LiquidacionImporParameterReturnGeneral procesarImportacionLiquidacionImporsWithConnection(ParametroGeneralUsuario parametroGeneralUsuario,Modulo modulo,Opcion opcion,Usuario usuario,List<DatoGeneralMinimo> datoGeneralMinimos,LiquidacionImporParameterReturnGeneral liquidacionimporParameterGeneral)throws Exception {				
		 try {	
			this.connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LiquidacionImpor.class.getSimpleName()+"-procesarImportacionLiquidacionImporsWithConnection");connexion.begin();			
			
			LiquidacionImporParameterReturnGeneral liquidacionimporReturnGeneral=new LiquidacionImporParameterReturnGeneral();
			
			Boolean esPrimero=true;			
			Boolean conColumnasBase=true;//SIEMPRE
			String sDelimiter=Funciones2.getTipoDelimiter(parametroGeneralUsuario);
			String sLinea="";
			String[] arrColumnas=null;//new String[5];
			Integer iColumn=0;			
			
			this.liquidacionimpors=new ArrayList<LiquidacionImpor>();
			
			for(DatoGeneralMinimo datoGeneralMinimo:datoGeneralMinimos) {
				iColumn=0;
				
				if(esPrimero && parametroGeneralUsuario.getcon_exportar_cabecera()) {
					esPrimero=false;
					continue;
				}
				
				sLinea=datoGeneralMinimo.getsDescripcion();
				arrColumnas=sLinea.split(sDelimiter);
				
				this.liquidacionimpor=new LiquidacionImpor();
				
				
				if(conColumnasBase) {this.liquidacionimpor.setId(Long.parseLong(arrColumnas[iColumn++]));}

				if(parametroGeneralUsuario.getcon_exportar_campo_version()){
				this.liquidacionimpor.setVersionRow(Timestamp.valueOf(arrColumnas[iColumn++]));
				}

				this.liquidacionimpor.setnombre(arrColumnas[iColumn++]);
			this.liquidacionimpor.setdescripcion(arrColumnas[iColumn++]);
				this.liquidacionimpor.setfecha(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.liquidacionimpor.setfecha_liquidacion(Funciones.ConvertToDate(arrColumnas[iColumn++]));
				this.liquidacionimpor.setflete(Double.parseDouble(arrColumnas[iColumn++]));
				this.liquidacionimpor.settipo(arrColumnas[iColumn++]);
				
				this.liquidacionimpors.add(this.liquidacionimpor);
			}
			
			this.saveLiquidacionImpors();
			
			this.connexion.commit();
			
			liquidacionimporReturnGeneral.setConRetornoEstaProcesado(true);
			liquidacionimporReturnGeneral.setsMensajeProceso("IMPORTADO CORRECTAMENTE");
			
			return liquidacionimporReturnGeneral;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();
		}
	}
	
	public void quitarLiquidacionImporsEliminados() throws Exception {				
		
		List<LiquidacionImpor> liquidacionimporsAux= new ArrayList<LiquidacionImpor>();
		
		for(LiquidacionImpor liquidacionimpor:liquidacionimpors) {
			if(!liquidacionimpor.getIsDeleted()) {
				liquidacionimporsAux.add(liquidacionimpor);
			}
		}
		
		liquidacionimpors=liquidacionimporsAux;
	}
	
	public void quitarLiquidacionImporsNulos() throws Exception {				
		
		List<LiquidacionImpor> liquidacionimporsAux= new ArrayList<LiquidacionImpor>();
		
		for(LiquidacionImpor liquidacionimpor : this.liquidacionimpors) {
			if(liquidacionimpor==null) {
				liquidacionimporsAux.add(liquidacionimpor);
			}
		}
		
		//this.liquidacionimpors=liquidacionimporsAux;
		
		this.liquidacionimpors.removeAll(liquidacionimporsAux);
	}
	
	public void getSetVersionRowLiquidacionImporWithConnection()throws Exception {	
		//VERIFICA EL OBJETO NO IMPORTA ESTADO			
		if(liquidacionimpor.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {
		  	//TEMPORAL
			//if((liquidacionimpor.getIsDeleted() || (liquidacionimpor.getIsChanged()&&!liquidacionimpor.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=null;
			
			try {	
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();					
				
				timestamp=liquidacionimporDataAccess.getSetVersionRowLiquidacionImpor(connexion,liquidacionimpor.getId());
				
				if(!liquidacionimpor.getVersionRow().equals(timestamp)) {	
					liquidacionimpor.setVersionRow(timestamp);
				}
				
				connexion.commit();									
				
				liquidacionimpor.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				connexion.rollback();			
				
				throw e;
				
	      	} finally {
				connexion.close();			
			}
		}
	}
	
	private void getSetVersionRowLiquidacionImpor()throws Exception {	
		
		if(liquidacionimpor.getIsChangedAuxiliar() && Constantes.ISSETVERSIONROWUPDATE) {		
		//TEMPORAL
		//if((liquidacionimpor.getIsDeleted() || (liquidacionimpor.getIsChanged()&&!liquidacionimpor.getIsNew()))&& Constantes.ISSETVERSIONROWUPDATE) {
			Timestamp timestamp=liquidacionimporDataAccess.getSetVersionRowLiquidacionImpor(connexion,liquidacionimpor.getId());
			
			try {							
				if(!liquidacionimpor.getVersionRow().equals(timestamp)) {	
					liquidacionimpor.setVersionRow(timestamp);
				}
				
				liquidacionimpor.setIsChangedAuxiliar(false);
				
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public void getSetVersionRowLiquidacionImporsWithConnection()throws Exception {	
		if(liquidacionimpors!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {
				Timestamp timestamp=null;
				
				connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory);connexion.begin();
				
				for(LiquidacionImpor liquidacionimporAux:liquidacionimpors) {
					//VERIFICA EL OBJETO NO IMPORTA ESTADO										
					//if(liquidacionimporAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(liquidacionimporAux.getIsDeleted() || (liquidacionimporAux.getIsChanged()&&!liquidacionimporAux.getIsNew())) {
						
						timestamp=liquidacionimporDataAccess.getSetVersionRowLiquidacionImpor(connexion,liquidacionimporAux.getId());
						
						if(!liquidacionimpor.getVersionRow().equals(timestamp)) {	
							liquidacionimporAux.setVersionRow(timestamp);
						}
								
						liquidacionimporAux.setIsChangedAuxiliar(false);														
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
	
	private void getSetVersionRowLiquidacionImpors()throws Exception {	
		if(liquidacionimpors!=null && Constantes.ISSETVERSIONROWUPDATE)	{
			
			try {	
				Timestamp timestamp=null;
				
				for(LiquidacionImpor liquidacionimporAux:liquidacionimpors) {
					if(liquidacionimporAux.getIsChangedAuxiliar()) {
					//TEMPORAL
					//if(liquidacionimporAux.getIsDeleted() || (liquidacionimporAux.getIsChanged()&&!liquidacionimporAux.getIsNew())) {
						
						timestamp=liquidacionimporDataAccess.getSetVersionRowLiquidacionImpor(connexion,liquidacionimporAux.getId());
						
						if(!liquidacionimporAux.getVersionRow().equals(timestamp)) {	
							liquidacionimporAux.setVersionRow(timestamp);
						}
						
													
						liquidacionimporAux.setIsChangedAuxiliar(false);														
					}
				}
					
			} catch(Exception e) {
				throw e;
				
	      	} finally {
				;			
			}
		}
	}
	
	public LiquidacionImporParameterReturnGeneral cargarCombosLoteForeignKeyLiquidacionImporWithConnection(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalCentroCosto,String finalQueryGlobalCuentaContable,String finalQueryGlobalPais,String finalQueryGlobalPuerto) throws Exception {
		LiquidacionImporParameterReturnGeneral  liquidacionimporReturnGeneral =new LiquidacionImporParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LiquidacionImpor.class.getSimpleName()+"-cargarCombosLoteForeignKeyLiquidacionImporWithConnection");connexion.begin();
			
			liquidacionimporReturnGeneral =new LiquidacionImporParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			liquidacionimporReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			liquidacionimporReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<CentroCosto> centrocostosForeignKey=new ArrayList<CentroCosto>();
			CentroCostoLogic centrocostoLogic=new CentroCostoLogic();
			centrocostoLogic.setConnexion(this.connexion);
			centrocostoLogic.getCentroCostoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCentroCosto.equals("NONE")) {
				centrocostoLogic.getTodosCentroCostos(finalQueryGlobalCentroCosto,new Pagination());
				centrocostosForeignKey=centrocostoLogic.getCentroCostos();
			}

			liquidacionimporReturnGeneral.setcentrocostosForeignKey(centrocostosForeignKey);


			List<CuentaContable> cuentacontablesForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableLogic=new CuentaContableLogic();
			cuentacontableLogic.setConnexion(this.connexion);
			cuentacontableLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContable.equals("NONE")) {
				cuentacontableLogic.getTodosCuentaContables(finalQueryGlobalCuentaContable,new Pagination());
				cuentacontablesForeignKey=cuentacontableLogic.getCuentaContables();
			}

			liquidacionimporReturnGeneral.setcuentacontablesForeignKey(cuentacontablesForeignKey);


			List<Pais> paissForeignKey=new ArrayList<Pais>();
			PaisLogic paisLogic=new PaisLogic();
			paisLogic.setConnexion(this.connexion);
			paisLogic.getPaisDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPais.equals("NONE")) {
				paisLogic.getTodosPaiss(finalQueryGlobalPais,new Pagination());
				paissForeignKey=paisLogic.getPaiss();
			}

			liquidacionimporReturnGeneral.setpaissForeignKey(paissForeignKey);


			List<Puerto> puertosForeignKey=new ArrayList<Puerto>();
			PuertoLogic puertoLogic=new PuertoLogic();
			puertoLogic.setConnexion(this.connexion);
			puertoLogic.getPuertoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPuerto.equals("NONE")) {
				puertoLogic.getTodosPuertos(finalQueryGlobalPuerto,new Pagination());
				puertosForeignKey=puertoLogic.getPuertos();
			}

			liquidacionimporReturnGeneral.setpuertosForeignKey(puertosForeignKey);

			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
		
		return liquidacionimporReturnGeneral;
	}
	
	public LiquidacionImporParameterReturnGeneral cargarCombosLoteForeignKeyLiquidacionImpor(String finalQueryGlobalEmpresa,String finalQueryGlobalSucursal,String finalQueryGlobalCentroCosto,String finalQueryGlobalCuentaContable,String finalQueryGlobalPais,String finalQueryGlobalPuerto) throws Exception {
		LiquidacionImporParameterReturnGeneral  liquidacionimporReturnGeneral =new LiquidacionImporParameterReturnGeneral();
		
		ArrayList<Classe> clases=new ArrayList<Classe>();
		ArrayList<String> arrClasses=new ArrayList<String>();
		Classe classe=new Classe();
		DatosDeep datosDeep=new DatosDeep(false,DeepLoadType.INCLUDE,clases,"");
		
		try {						
			liquidacionimporReturnGeneral =new LiquidacionImporParameterReturnGeneral();
			
			

			List<Empresa> empresasForeignKey=new ArrayList<Empresa>();
			EmpresaLogic empresaLogic=new EmpresaLogic();
			empresaLogic.setConnexion(this.connexion);
			//empresaLogic.getEmpresaDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalEmpresa.equals("NONE")) {
				empresaLogic.getTodosEmpresas(finalQueryGlobalEmpresa,new Pagination());
				empresasForeignKey=empresaLogic.getEmpresas();
			}

			liquidacionimporReturnGeneral.setempresasForeignKey(empresasForeignKey);


			List<Sucursal> sucursalsForeignKey=new ArrayList<Sucursal>();
			SucursalLogic sucursalLogic=new SucursalLogic();
			sucursalLogic.setConnexion(this.connexion);
			//sucursalLogic.getSucursalDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalSucursal.equals("NONE")) {
				sucursalLogic.getTodosSucursals(finalQueryGlobalSucursal,new Pagination());
				sucursalsForeignKey=sucursalLogic.getSucursals();
			}

			liquidacionimporReturnGeneral.setsucursalsForeignKey(sucursalsForeignKey);


			List<CentroCosto> centrocostosForeignKey=new ArrayList<CentroCosto>();
			CentroCostoLogic centrocostoLogic=new CentroCostoLogic();
			centrocostoLogic.setConnexion(this.connexion);
			centrocostoLogic.getCentroCostoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCentroCosto.equals("NONE")) {
				centrocostoLogic.getTodosCentroCostos(finalQueryGlobalCentroCosto,new Pagination());
				centrocostosForeignKey=centrocostoLogic.getCentroCostos();
			}

			liquidacionimporReturnGeneral.setcentrocostosForeignKey(centrocostosForeignKey);


			List<CuentaContable> cuentacontablesForeignKey=new ArrayList<CuentaContable>();
			CuentaContableLogic cuentacontableLogic=new CuentaContableLogic();
			cuentacontableLogic.setConnexion(this.connexion);
			cuentacontableLogic.getCuentaContableDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalCuentaContable.equals("NONE")) {
				cuentacontableLogic.getTodosCuentaContables(finalQueryGlobalCuentaContable,new Pagination());
				cuentacontablesForeignKey=cuentacontableLogic.getCuentaContables();
			}

			liquidacionimporReturnGeneral.setcuentacontablesForeignKey(cuentacontablesForeignKey);


			List<Pais> paissForeignKey=new ArrayList<Pais>();
			PaisLogic paisLogic=new PaisLogic();
			paisLogic.setConnexion(this.connexion);
			paisLogic.getPaisDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPais.equals("NONE")) {
				paisLogic.getTodosPaiss(finalQueryGlobalPais,new Pagination());
				paissForeignKey=paisLogic.getPaiss();
			}

			liquidacionimporReturnGeneral.setpaissForeignKey(paissForeignKey);


			List<Puerto> puertosForeignKey=new ArrayList<Puerto>();
			PuertoLogic puertoLogic=new PuertoLogic();
			puertoLogic.setConnexion(this.connexion);
			puertoLogic.getPuertoDataAccess().setIsForForeingKeyData(true);

			if(!finalQueryGlobalPuerto.equals("NONE")) {
				puertoLogic.getTodosPuertos(finalQueryGlobalPuerto,new Pagination());
				puertosForeignKey=puertoLogic.getPuertos();
			}

			liquidacionimporReturnGeneral.setpuertosForeignKey(puertosForeignKey);
						
			
		} catch(Exception e) {			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			
		}
		
		return liquidacionimporReturnGeneral;
	}
	
	public void cargarRelacionesLoteForeignKeyLiquidacionImporWithConnection() throws Exception {
		ArrayList<Classe> classes=new ArrayList<Classe>();		
		
		
			DetalleLiquidacionImporLogic detalleliquidacionimporLogic=new DetalleLiquidacionImporLogic();
		
		try {
			
			this.connexion=this.connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LiquidacionImpor.class.getSimpleName()+"-cargarRelacionesLoteForeignKeyLiquidacionImporWithConnection");connexion.begin();
			
			
			classes.add(new Classe(DetalleLiquidacionImpor.class));
											
			

			detalleliquidacionimporLogic.setConnexion(this.getConnexion());
			detalleliquidacionimporLogic.setDatosCliente(this.datosCliente);
			detalleliquidacionimporLogic.setIsConRefrescarForeignKeys(true);
			
			this.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			
			for(LiquidacionImpor liquidacionimpor:this.liquidacionimpors) {
				

				classes=new ArrayList<Classe>();
				classes=DetalleLiquidacionImporConstantesFunciones.getClassesForeignKeysOfDetalleLiquidacionImpor(new ArrayList<Classe>(),DeepLoadType.NONE);

				detalleliquidacionimporLogic.setDetalleLiquidacionImpors(liquidacionimpor.detalleliquidacionimpors);
				detalleliquidacionimporLogic.deepLoads(false, DeepLoadType.INCLUDE, classes, "");
			}
			
			this.connexion.commit();			
			
		} catch(Exception e) {
			this.connexion.rollback();			
			Funciones.manageException(logger,e);
			throw e;
			
      	} finally {
			this.connexion.close();	
		}
	}
	
	public void deepLoad(LiquidacionImpor liquidacionimpor,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {
		Boolean existe=false;
		
		try {
			LiquidacionImporLogicAdditional.updateLiquidacionImporToGet(liquidacionimpor,this.arrDatoGeneral);
			
if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		liquidacionimpor.setEmpresa(liquidacionimporDataAccess.getEmpresa(connexion,liquidacionimpor));
		liquidacionimpor.setSucursal(liquidacionimporDataAccess.getSucursal(connexion,liquidacionimpor));
		liquidacionimpor.setCentroCosto(liquidacionimporDataAccess.getCentroCosto(connexion,liquidacionimpor));
		liquidacionimpor.setCuentaContable(liquidacionimporDataAccess.getCuentaContable(connexion,liquidacionimpor));
		liquidacionimpor.setPais(liquidacionimporDataAccess.getPais(connexion,liquidacionimpor));
		liquidacionimpor.setPuerto(liquidacionimporDataAccess.getPuerto(connexion,liquidacionimpor));
		liquidacionimpor.setDetalleLiquidacionImpors(liquidacionimporDataAccess.getDetalleLiquidacionImpors(connexion,liquidacionimpor));
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				liquidacionimpor.setEmpresa(liquidacionimporDataAccess.getEmpresa(connexion,liquidacionimpor));
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				liquidacionimpor.setSucursal(liquidacionimporDataAccess.getSucursal(connexion,liquidacionimpor));
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				liquidacionimpor.setCentroCosto(liquidacionimporDataAccess.getCentroCosto(connexion,liquidacionimpor));
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				liquidacionimpor.setCuentaContable(liquidacionimporDataAccess.getCuentaContable(connexion,liquidacionimpor));
				continue;
			}

			if(clas.clas.equals(Pais.class)) {
				liquidacionimpor.setPais(liquidacionimporDataAccess.getPais(connexion,liquidacionimpor));
				continue;
			}

			if(clas.clas.equals(Puerto.class)) {
				liquidacionimpor.setPuerto(liquidacionimporDataAccess.getPuerto(connexion,liquidacionimpor));
				continue;
			}

			if(clas.clas.equals(DetalleLiquidacionImpor.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				liquidacionimpor.setDetalleLiquidacionImpors(liquidacionimporDataAccess.getDetalleLiquidacionImpors(connexion,liquidacionimpor));

				if(this.isConDeep) {
					DetalleLiquidacionImporLogic detalleliquidacionimporLogic= new DetalleLiquidacionImporLogic(this.connexion);
					detalleliquidacionimporLogic.setDetalleLiquidacionImpors(liquidacionimpor.getDetalleLiquidacionImpors());
					ArrayList<Classe> classesLocal=DetalleLiquidacionImporConstantesFunciones.getClassesForeignKeysOfDetalleLiquidacionImpor(new ArrayList<Classe>(),DeepLoadType.NONE);
					detalleliquidacionimporLogic.deepLoads(false,DeepLoadType.INCLUDE, classesLocal,"");
					DetalleLiquidacionImporConstantesFunciones.refrescarForeignKeysDescripcionesDetalleLiquidacionImpor(detalleliquidacionimporLogic.getDetalleLiquidacionImpors());
					liquidacionimpor.setDetalleLiquidacionImpors(detalleliquidacionimporLogic.getDetalleLiquidacionImpors());
				}

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
			liquidacionimpor.setEmpresa(liquidacionimporDataAccess.getEmpresa(connexion,liquidacionimpor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			liquidacionimpor.setSucursal(liquidacionimporDataAccess.getSucursal(connexion,liquidacionimpor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CentroCosto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			liquidacionimpor.setCentroCosto(liquidacionimporDataAccess.getCentroCosto(connexion,liquidacionimpor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			liquidacionimpor.setCuentaContable(liquidacionimporDataAccess.getCuentaContable(connexion,liquidacionimpor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Pais.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			liquidacionimpor.setPais(liquidacionimporDataAccess.getPais(connexion,liquidacionimpor));
		}
		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(Puerto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			liquidacionimpor.setPuerto(liquidacionimporDataAccess.getPuerto(connexion,liquidacionimpor));
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleLiquidacionImpor.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetalleLiquidacionImpor.class));
			liquidacionimpor.setDetalleLiquidacionImpors(liquidacionimporDataAccess.getDetalleLiquidacionImpors(connexion,liquidacionimpor));
		}
	}
}
else {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		liquidacionimpor.setEmpresa(liquidacionimporDataAccess.getEmpresa(connexion,liquidacionimpor));
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(liquidacionimpor.getEmpresa(),isDeep,deepLoadType,clases);
				
		liquidacionimpor.setSucursal(liquidacionimporDataAccess.getSucursal(connexion,liquidacionimpor));
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(liquidacionimpor.getSucursal(),isDeep,deepLoadType,clases);
				
		liquidacionimpor.setCentroCosto(liquidacionimporDataAccess.getCentroCosto(connexion,liquidacionimpor));
		CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
		centrocostoLogic.deepLoad(liquidacionimpor.getCentroCosto(),isDeep,deepLoadType,clases);
				
		liquidacionimpor.setCuentaContable(liquidacionimporDataAccess.getCuentaContable(connexion,liquidacionimpor));
		CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
		cuentacontableLogic.deepLoad(liquidacionimpor.getCuentaContable(),isDeep,deepLoadType,clases);
				
		liquidacionimpor.setPais(liquidacionimporDataAccess.getPais(connexion,liquidacionimpor));
		PaisLogic paisLogic= new PaisLogic(connexion);
		paisLogic.deepLoad(liquidacionimpor.getPais(),isDeep,deepLoadType,clases);
				
		liquidacionimpor.setPuerto(liquidacionimporDataAccess.getPuerto(connexion,liquidacionimpor));
		PuertoLogic puertoLogic= new PuertoLogic(connexion);
		puertoLogic.deepLoad(liquidacionimpor.getPuerto(),isDeep,deepLoadType,clases);
				

		liquidacionimpor.setDetalleLiquidacionImpors(liquidacionimporDataAccess.getDetalleLiquidacionImpors(connexion,liquidacionimpor));

		for(DetalleLiquidacionImpor detalleliquidacionimpor:liquidacionimpor.getDetalleLiquidacionImpors()) {
			DetalleLiquidacionImporLogic detalleliquidacionimporLogic= new DetalleLiquidacionImporLogic(connexion);
			detalleliquidacionimporLogic.deepLoad(detalleliquidacionimpor,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				liquidacionimpor.setEmpresa(liquidacionimporDataAccess.getEmpresa(connexion,liquidacionimpor));
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepLoad(liquidacionimpor.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				liquidacionimpor.setSucursal(liquidacionimporDataAccess.getSucursal(connexion,liquidacionimpor));
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepLoad(liquidacionimpor.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				liquidacionimpor.setCentroCosto(liquidacionimporDataAccess.getCentroCosto(connexion,liquidacionimpor));
				CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
				centrocostoLogic.deepLoad(liquidacionimpor.getCentroCosto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				liquidacionimpor.setCuentaContable(liquidacionimporDataAccess.getCuentaContable(connexion,liquidacionimpor));
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepLoad(liquidacionimpor.getCuentaContable(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Pais.class)) {
				liquidacionimpor.setPais(liquidacionimporDataAccess.getPais(connexion,liquidacionimpor));
				PaisLogic paisLogic= new PaisLogic(connexion);
				paisLogic.deepLoad(liquidacionimpor.getPais(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Puerto.class)) {
				liquidacionimpor.setPuerto(liquidacionimporDataAccess.getPuerto(connexion,liquidacionimpor));
				PuertoLogic puertoLogic= new PuertoLogic(connexion);
				puertoLogic.deepLoad(liquidacionimpor.getPuerto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(DetalleLiquidacionImpor.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				liquidacionimpor.setDetalleLiquidacionImpors(liquidacionimporDataAccess.getDetalleLiquidacionImpors(connexion,liquidacionimpor));

				for(DetalleLiquidacionImpor detalleliquidacionimpor:liquidacionimpor.getDetalleLiquidacionImpors()) {
					DetalleLiquidacionImporLogic detalleliquidacionimporLogic= new DetalleLiquidacionImporLogic(connexion);
					detalleliquidacionimporLogic.deepLoad(detalleliquidacionimpor,isDeep,deepLoadType,clases);
				}
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
			liquidacionimpor.setEmpresa(liquidacionimporDataAccess.getEmpresa(connexion,liquidacionimpor));
			EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
			empresaLogic.deepLoad(liquidacionimpor.getEmpresa(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Sucursal.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			liquidacionimpor.setSucursal(liquidacionimporDataAccess.getSucursal(connexion,liquidacionimpor));
			SucursalLogic sucursalLogic= new SucursalLogic(connexion);
			sucursalLogic.deepLoad(liquidacionimpor.getSucursal(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CentroCosto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			liquidacionimpor.setCentroCosto(liquidacionimporDataAccess.getCentroCosto(connexion,liquidacionimpor));
			CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
			centrocostoLogic.deepLoad(liquidacionimpor.getCentroCosto(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(CuentaContable.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			liquidacionimpor.setCuentaContable(liquidacionimporDataAccess.getCuentaContable(connexion,liquidacionimpor));
			CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
			cuentacontableLogic.deepLoad(liquidacionimpor.getCuentaContable(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Pais.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			liquidacionimpor.setPais(liquidacionimporDataAccess.getPais(connexion,liquidacionimpor));
			PaisLogic paisLogic= new PaisLogic(connexion);
			paisLogic.deepLoad(liquidacionimpor.getPais(),isDeep,deepLoadType,clases);
				
		}

		existe=false;


		for(Classe clas:clases) {
			if(clas.clas.equals(Puerto.class)) {
				existe=true;
				break;
			}
				
		}

		if(!existe) {
			liquidacionimpor.setPuerto(liquidacionimporDataAccess.getPuerto(connexion,liquidacionimpor));
			PuertoLogic puertoLogic= new PuertoLogic(connexion);
			puertoLogic.deepLoad(liquidacionimpor.getPuerto(),isDeep,deepLoadType,clases);
				
		}

		existe=false;

		for(Classe clas:clases) {
			if(clas.clas.equals(DetalleLiquidacionImpor.class)&&clas.blnActivo) {
				clas.blnActivo=false;
				existe=true;
				break;
			}
		}

		if(!existe) {
			clases.add(new Classe(DetalleLiquidacionImpor.class));
			liquidacionimpor.setDetalleLiquidacionImpors(liquidacionimporDataAccess.getDetalleLiquidacionImpors(connexion,liquidacionimpor));

			for(DetalleLiquidacionImpor detalleliquidacionimpor:liquidacionimpor.getDetalleLiquidacionImpors()) {
				DetalleLiquidacionImporLogic detalleliquidacionimporLogic= new DetalleLiquidacionImporLogic(connexion);
				detalleliquidacionimporLogic.deepLoad(detalleliquidacionimpor,isDeep,deepLoadType,clases);
			}
		}
	}
}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
  		}		
	}
	
	public void deepSave(LiquidacionImpor liquidacionimpor,Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {		
		Boolean existe=false;		
		try {
			LiquidacionImporLogicAdditional.updateLiquidacionImporToSave(liquidacionimpor,this.arrDatoGeneral);
			
LiquidacionImporDataAccess.save(liquidacionimpor, connexion);

if(!isDeep) {

	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(liquidacionimpor.getEmpresa(),connexion);

		SucursalDataAccess.save(liquidacionimpor.getSucursal(),connexion);

		CentroCostoDataAccess.save(liquidacionimpor.getCentroCosto(),connexion);

		CuentaContableDataAccess.save(liquidacionimpor.getCuentaContable(),connexion);

		PaisDataAccess.save(liquidacionimpor.getPais(),connexion);

		PuertoDataAccess.save(liquidacionimpor.getPuerto(),connexion);

		for(DetalleLiquidacionImpor detalleliquidacionimpor:liquidacionimpor.getDetalleLiquidacionImpors()) {
			detalleliquidacionimpor.setid_liquidacion_impor(liquidacionimpor.getId());
			DetalleLiquidacionImporDataAccess.save(detalleliquidacionimpor,connexion);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(liquidacionimpor.getEmpresa(),connexion);
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(liquidacionimpor.getSucursal(),connexion);
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				CentroCostoDataAccess.save(liquidacionimpor.getCentroCosto(),connexion);
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(liquidacionimpor.getCuentaContable(),connexion);
				continue;
			}

			if(clas.clas.equals(Pais.class)) {
				PaisDataAccess.save(liquidacionimpor.getPais(),connexion);
				continue;
			}

			if(clas.clas.equals(Puerto.class)) {
				PuertoDataAccess.save(liquidacionimpor.getPuerto(),connexion);
				continue;
			}


			if(clas.clas.equals(DetalleLiquidacionImpor.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetalleLiquidacionImpor detalleliquidacionimpor:liquidacionimpor.getDetalleLiquidacionImpors()) {
					detalleliquidacionimpor.setid_liquidacion_impor(liquidacionimpor.getId());
					DetalleLiquidacionImporDataAccess.save(detalleliquidacionimpor,connexion);
				}
				continue;
			}
		}
	}

	}
else {
	if(deepLoadType.equals(DeepLoadType.NONE)) {

		EmpresaDataAccess.save(liquidacionimpor.getEmpresa(),connexion);
		EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
		empresaLogic.deepLoad(liquidacionimpor.getEmpresa(),isDeep,deepLoadType,clases);
				

		SucursalDataAccess.save(liquidacionimpor.getSucursal(),connexion);
		SucursalLogic sucursalLogic= new SucursalLogic(connexion);
		sucursalLogic.deepLoad(liquidacionimpor.getSucursal(),isDeep,deepLoadType,clases);
				

		CentroCostoDataAccess.save(liquidacionimpor.getCentroCosto(),connexion);
		CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
		centrocostoLogic.deepLoad(liquidacionimpor.getCentroCosto(),isDeep,deepLoadType,clases);
				

		CuentaContableDataAccess.save(liquidacionimpor.getCuentaContable(),connexion);
		CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
		cuentacontableLogic.deepLoad(liquidacionimpor.getCuentaContable(),isDeep,deepLoadType,clases);
				

		PaisDataAccess.save(liquidacionimpor.getPais(),connexion);
		PaisLogic paisLogic= new PaisLogic(connexion);
		paisLogic.deepLoad(liquidacionimpor.getPais(),isDeep,deepLoadType,clases);
				

		PuertoDataAccess.save(liquidacionimpor.getPuerto(),connexion);
		PuertoLogic puertoLogic= new PuertoLogic(connexion);
		puertoLogic.deepLoad(liquidacionimpor.getPuerto(),isDeep,deepLoadType,clases);
				

		for(DetalleLiquidacionImpor detalleliquidacionimpor:liquidacionimpor.getDetalleLiquidacionImpors()) {
			DetalleLiquidacionImporLogic detalleliquidacionimporLogic= new DetalleLiquidacionImporLogic(connexion);
			detalleliquidacionimpor.setid_liquidacion_impor(liquidacionimpor.getId());
			DetalleLiquidacionImporDataAccess.save(detalleliquidacionimpor,connexion);
			detalleliquidacionimporLogic.deepSave(detalleliquidacionimpor,isDeep,deepLoadType,clases);
		}
	}
	 else 	if(deepLoadType.equals(DeepLoadType.INCLUDE)) {

		for(Classe clas:clases) {
			if(clas.clas.equals(Empresa.class)) {
				EmpresaDataAccess.save(liquidacionimpor.getEmpresa(),connexion);
				EmpresaLogic empresaLogic= new EmpresaLogic(connexion);
				empresaLogic.deepSave(liquidacionimpor.getEmpresa(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Sucursal.class)) {
				SucursalDataAccess.save(liquidacionimpor.getSucursal(),connexion);
				SucursalLogic sucursalLogic= new SucursalLogic(connexion);
				sucursalLogic.deepSave(liquidacionimpor.getSucursal(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CentroCosto.class)) {
				CentroCostoDataAccess.save(liquidacionimpor.getCentroCosto(),connexion);
				CentroCostoLogic centrocostoLogic= new CentroCostoLogic(connexion);
				centrocostoLogic.deepSave(liquidacionimpor.getCentroCosto(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(CuentaContable.class)) {
				CuentaContableDataAccess.save(liquidacionimpor.getCuentaContable(),connexion);
				CuentaContableLogic cuentacontableLogic= new CuentaContableLogic(connexion);
				cuentacontableLogic.deepSave(liquidacionimpor.getCuentaContable(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Pais.class)) {
				PaisDataAccess.save(liquidacionimpor.getPais(),connexion);
				PaisLogic paisLogic= new PaisLogic(connexion);
				paisLogic.deepSave(liquidacionimpor.getPais(),isDeep,deepLoadType,clases);				
				continue;
			}

			if(clas.clas.equals(Puerto.class)) {
				PuertoDataAccess.save(liquidacionimpor.getPuerto(),connexion);
				PuertoLogic puertoLogic= new PuertoLogic(connexion);
				puertoLogic.deepSave(liquidacionimpor.getPuerto(),isDeep,deepLoadType,clases);				
				continue;
			}


			if(clas.clas.equals(DetalleLiquidacionImpor.class)&&clas.blnActivo) {
				clas.blnActivo=false;

				for(DetalleLiquidacionImpor detalleliquidacionimpor:liquidacionimpor.getDetalleLiquidacionImpors()) {
					DetalleLiquidacionImporLogic detalleliquidacionimporLogic= new DetalleLiquidacionImporLogic(connexion);
					detalleliquidacionimpor.setid_liquidacion_impor(liquidacionimpor.getId());
					DetalleLiquidacionImporDataAccess.save(detalleliquidacionimpor,connexion);
					detalleliquidacionimporLogic.deepSave(detalleliquidacionimpor,isDeep,deepLoadType,clases);
				}
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
			this.getNewConnexionToDeep(LiquidacionImpor.class.getSimpleName()+"-deepLoadWithConnection");
			
			this.deepLoad(liquidacionimpor,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				LiquidacionImporConstantesFunciones.refrescarForeignKeysDescripcionesLiquidacionImpor(liquidacionimpor);
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
			this.deepLoad(this.liquidacionimpor,isDeep,deepLoadType,clases);	
			
			if(this.isConRefrescarForeignKeys) {
				LiquidacionImporConstantesFunciones.refrescarForeignKeysDescripcionesLiquidacionImpor(this.liquidacionimpor);
			}
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		}
	}
	
	public void deepLoadsWithConnection(Boolean isDeep,DeepLoadType deepLoadType,ArrayList<Classe> clases,String sTituloMensaje)throws Exception {		
		try {
			this.getNewConnexionToDeep(LiquidacionImpor.class.getSimpleName()+"-deepLoadsWithConnection");
			
			if(liquidacionimpors!=null) {
				for(LiquidacionImpor liquidacionimpor:liquidacionimpors) {
					this.deepLoad(liquidacionimpor,isDeep,deepLoadType,clases);
				}	
				
				if(this.isConRefrescarForeignKeys) {
					LiquidacionImporConstantesFunciones.refrescarForeignKeysDescripcionesLiquidacionImpor(liquidacionimpors);
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
			if(liquidacionimpors!=null) {
				for(LiquidacionImpor liquidacionimpor:liquidacionimpors) {
					this.deepLoad(liquidacionimpor,isDeep,deepLoadType,clases);
				}	
						
				if(this.isConRefrescarForeignKeys) {
					LiquidacionImporConstantesFunciones.refrescarForeignKeysDescripcionesLiquidacionImpor(liquidacionimpors);
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
			this.getNewConnexionToDeep(LiquidacionImpor.class.getSimpleName()+"-deepSaveWithConnection");
			
			this.deepSave(liquidacionimpor,isDeep,deepLoadType,clases);	
			
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
			this.getNewConnexionToDeep(LiquidacionImpor.class.getSimpleName()+"-deepSavesWithConnection");
			
			if(liquidacionimpors!=null) {
				for(LiquidacionImpor liquidacionimpor:liquidacionimpors) {
					this.deepSave(liquidacionimpor,isDeep,deepLoadType,clases);
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
			if(liquidacionimpors!=null) {
				for(LiquidacionImpor liquidacionimpor:liquidacionimpors) {
					this.deepSave(liquidacionimpor,isDeep,deepLoadType,clases);
				}		
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
			
  		} finally {
			;
		}
	}
	
	
	public void getLiquidacionImporsFK_IdCentroCostoWithConnection(String sFinalQuery,Pagination pagination,Long id_centro_costo)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LiquidacionImpor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCentroCosto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCentroCosto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_centro_costo,LiquidacionImporConstantesFunciones.IDCENTROCOSTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCentroCosto);

			LiquidacionImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCentroCosto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			liquidacionimpors=liquidacionimporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				LiquidacionImporConstantesFunciones.refrescarForeignKeysDescripcionesLiquidacionImpor(this.liquidacionimpors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getLiquidacionImporsFK_IdCentroCosto(String sFinalQuery,Pagination pagination,Long id_centro_costo)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCentroCosto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCentroCosto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_centro_costo,LiquidacionImporConstantesFunciones.IDCENTROCOSTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCentroCosto);

			LiquidacionImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCentroCosto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			liquidacionimpors=liquidacionimporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				LiquidacionImporConstantesFunciones.refrescarForeignKeysDescripcionesLiquidacionImpor(this.liquidacionimpors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getLiquidacionImporsFK_IdCuentaContableWithConnection(String sFinalQuery,Pagination pagination,Long id_cuenta_contable)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LiquidacionImpor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable,LiquidacionImporConstantesFunciones.IDCUENTACONTABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContable);

			LiquidacionImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			liquidacionimpors=liquidacionimporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				LiquidacionImporConstantesFunciones.refrescarForeignKeysDescripcionesLiquidacionImpor(this.liquidacionimpors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getLiquidacionImporsFK_IdCuentaContable(String sFinalQuery,Pagination pagination,Long id_cuenta_contable)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidCuentaContable= new ParameterSelectionGeneral();
			parameterSelectionGeneralidCuentaContable.setParameterSelectionGeneralEqual(ParameterType.LONG,id_cuenta_contable,LiquidacionImporConstantesFunciones.IDCUENTACONTABLE,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidCuentaContable);

			LiquidacionImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdCuentaContable","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			liquidacionimpors=liquidacionimporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				LiquidacionImporConstantesFunciones.refrescarForeignKeysDescripcionesLiquidacionImpor(this.liquidacionimpors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getLiquidacionImporsFK_IdEmpresaWithConnection(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LiquidacionImpor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,LiquidacionImporConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			LiquidacionImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			liquidacionimpors=liquidacionimporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				LiquidacionImporConstantesFunciones.refrescarForeignKeysDescripcionesLiquidacionImpor(this.liquidacionimpors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getLiquidacionImporsFK_IdEmpresa(String sFinalQuery,Pagination pagination,Long id_empresa)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidEmpresa= new ParameterSelectionGeneral();
			parameterSelectionGeneralidEmpresa.setParameterSelectionGeneralEqual(ParameterType.LONG,id_empresa,LiquidacionImporConstantesFunciones.IDEMPRESA,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidEmpresa);

			LiquidacionImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdEmpresa","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			liquidacionimpors=liquidacionimporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				LiquidacionImporConstantesFunciones.refrescarForeignKeysDescripcionesLiquidacionImpor(this.liquidacionimpors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getLiquidacionImporsFK_IdPaisWithConnection(String sFinalQuery,Pagination pagination,Long id_pais)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LiquidacionImpor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPais= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPais.setParameterSelectionGeneralEqual(ParameterType.LONG,id_pais,LiquidacionImporConstantesFunciones.IDPAIS,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPais);

			LiquidacionImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPais","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			liquidacionimpors=liquidacionimporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				LiquidacionImporConstantesFunciones.refrescarForeignKeysDescripcionesLiquidacionImpor(this.liquidacionimpors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getLiquidacionImporsFK_IdPais(String sFinalQuery,Pagination pagination,Long id_pais)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPais= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPais.setParameterSelectionGeneralEqual(ParameterType.LONG,id_pais,LiquidacionImporConstantesFunciones.IDPAIS,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPais);

			LiquidacionImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPais","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			liquidacionimpors=liquidacionimporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				LiquidacionImporConstantesFunciones.refrescarForeignKeysDescripcionesLiquidacionImpor(this.liquidacionimpors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getLiquidacionImporsFK_IdPuertoWithConnection(String sFinalQuery,Pagination pagination,Long id_puerto)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LiquidacionImpor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPuerto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPuerto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_puerto,LiquidacionImporConstantesFunciones.IDPUERTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPuerto);

			LiquidacionImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPuerto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			liquidacionimpors=liquidacionimporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				LiquidacionImporConstantesFunciones.refrescarForeignKeysDescripcionesLiquidacionImpor(this.liquidacionimpors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getLiquidacionImporsFK_IdPuerto(String sFinalQuery,Pagination pagination,Long id_puerto)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidPuerto= new ParameterSelectionGeneral();
			parameterSelectionGeneralidPuerto.setParameterSelectionGeneralEqual(ParameterType.LONG,id_puerto,LiquidacionImporConstantesFunciones.IDPUERTO,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidPuerto);

			LiquidacionImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdPuerto","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			liquidacionimpors=liquidacionimporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				LiquidacionImporConstantesFunciones.refrescarForeignKeysDescripcionesLiquidacionImpor(this.liquidacionimpors);
			}

		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
		}
	}

	public void getLiquidacionImporsFK_IdSucursalWithConnection(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{
			connexion=connexion.getNewConnexion(this.connexionType,this.parameterDbType,this.entityManagerFactory,LiquidacionImpor.class.getSimpleName()+"-getBusquedaIndice");connexion.begin();

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,LiquidacionImporConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			LiquidacionImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			liquidacionimpors=liquidacionimporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				LiquidacionImporConstantesFunciones.refrescarForeignKeysDescripcionesLiquidacionImpor(this.liquidacionimpors);
			}


			connexion.commit();
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		} finally {
			connexion.close();
		}
	}

	public void getLiquidacionImporsFK_IdSucursal(String sFinalQuery,Pagination pagination,Long id_sucursal)throws Exception {
		try
		{

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters(ParameterDbType.MYSQL,"");

			queryWhereSelectParameters.setPagination(pagination);
			queryWhereSelectParameters.setFinalQuery(sFinalQuery);

			ParameterSelectionGeneral parameterSelectionGeneralidSucursal= new ParameterSelectionGeneral();
			parameterSelectionGeneralidSucursal.setParameterSelectionGeneralEqual(ParameterType.LONG,id_sucursal,LiquidacionImporConstantesFunciones.IDSUCURSAL,ParameterTypeOperator.NONE);
			queryWhereSelectParameters.addParameter(parameterSelectionGeneralidSucursal);

			LiquidacionImporLogic.registrarAuditoria(this.connexion,datosCliente.getIdUsuario(),"FK_IdSucursal","",queryWhereSelectParameters,datosCliente.getsUsuarioPC(),datosCliente.getsNamePC(),datosCliente.getsIPPC());

			liquidacionimpors=liquidacionimporDataAccess.getEntities(connexion,queryWhereSelectParameters);


			if(this.isConDeep) {
				this.deepLoads(this.datosDeep.getIsDeep(),this.datosDeep.getDeepLoadType(), this.datosDeep.getClases(),this.datosDeep.getSTituloMensaje());

				LiquidacionImporConstantesFunciones.refrescarForeignKeysDescripcionesLiquidacionImpor(this.liquidacionimpors);
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
			if(LiquidacionImporConstantesFunciones.ISCONAUDITORIA) {
				String sDetalleBusqueda=sDetalleProcesoBusqueda+Funciones.getDetalleBusqueda(queryWhereSelectParameters);
				
				////auditoriaLogicAdditional.registrarNuevaAuditoriaBusqueda(Constantes.LIDSISTEMAACTUAL,idUsuario,LiquidacionImporDataAccess.TABLENAME, 0L, Constantes.SAUDITORIABUSCAR,sProcesoBusqueda,sUsuarioPC,sNamePC,sIPPC,new Date(),sDetalleBusqueda);														
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
	
	public static void registrarAuditoria(Connexion connexion,Long idUsuario,LiquidacionImpor liquidacionimpor,String sUsuarioPC,String sNamePC,String sIPPC)throws Exception {
		////AuditoriaLogicAdditional auditoriaLogicAdditional=new AuditoriaLogicAdditional();
		////auditoriaLogicAdditional.setConnexion(connexion);
		////AuditoriaDataAccess.SCHEMA="bydan_erp";
		
		try {
			if(LiquidacionImporConstantesFunciones.ISCONAUDITORIA) {
				if(liquidacionimpor.getIsNew()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,LiquidacionImporDataAccess.TABLENAME, liquidacionimpor.getId(), Constantes.SAUDITORIAINSERTAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(LiquidacionImporConstantesFunciones.ISCONAUDITORIADETALLE) {
						////LiquidacionImporLogic.registrarAuditoriaDetallesLiquidacionImpor(connexion,liquidacionimpor,auditoriaLogicAdditional.getAuditoria());
					}
				} else if(liquidacionimpor.getIsDeleted()) {
					/*if(!liquidacionimpor.getIsExpired()) {
						////auditoriaLogicAdditional.RegistrarNuevaAuditoria(Constantes.getLOidSistemaActual(),idUsuario,LiquidacionImporDataAccess.TABLENAME, liquidacionimpor.getId(), Constantes.getSAuditoriaEliminarLogicamente(),"",sUsuarioPC,sNamePC,sIPPC,Timestamp.valueOf(Funciones.getStringMySqlCurrentDateTime()),"");
						////LiquidacionImporLogic.registrarAuditoriaDetallesLiquidacionImpor(connexion,liquidacionimpor,auditoriaLogicAdditional.getAuditoria());
					} else {*/
						////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,LiquidacionImporDataAccess.TABLENAME, liquidacionimpor.getId(), Constantes.SAUDITORIAELIMINARFISICAMENTE,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					//}
				} else if(liquidacionimpor.getIsChanged()) {
					////auditoriaLogicAdditional.registrarNuevaAuditoria(Constantes.LIDSISTEMAACTUAL,idUsuario,LiquidacionImporDataAccess.TABLENAME, liquidacionimpor.getId(), Constantes.SAUDITORIAACTUALIZAR,"",sUsuarioPC,sNamePC,sIPPC,new Date(),"");
					
					if(LiquidacionImporConstantesFunciones.ISCONAUDITORIADETALLE) {
						////LiquidacionImporLogic.registrarAuditoriaDetallesLiquidacionImpor(connexion,liquidacionimpor,auditoriaLogicAdditional.getAuditoria());
					}
				}
			}
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}		
	}
		private static void registrarAuditoriaDetallesLiquidacionImpor(Connexion connexion,LiquidacionImpor liquidacionimpor)throws Exception {		
		////AuditoriaDetalleLogicAdditional auditoriaDetalleLogicAdditional= new AuditoriaDetalleLogicAdditional(); 
		////auditoriaDetalleLogicAdditional.setConnexion(connexion);
		////AuditoriaDetalleDataAccess.SCHEMA="bydan_erp";
		
		String strValorActual=null;
		String strValorNuevo=null;
		
			
			if(liquidacionimpor.getIsNew()||!liquidacionimpor.getid_empresa().equals(liquidacionimpor.getLiquidacionImporOriginal().getid_empresa()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(liquidacionimpor.getLiquidacionImporOriginal().getid_empresa()!=null)
				{
					strValorActual=liquidacionimpor.getLiquidacionImporOriginal().getid_empresa().toString();
				}
				if(liquidacionimpor.getid_empresa()!=null)
				{
					strValorNuevo=liquidacionimpor.getid_empresa().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),LiquidacionImporConstantesFunciones.IDEMPRESA,strValorActual,strValorNuevo);
			}	
			
			if(liquidacionimpor.getIsNew()||!liquidacionimpor.getid_sucursal().equals(liquidacionimpor.getLiquidacionImporOriginal().getid_sucursal()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(liquidacionimpor.getLiquidacionImporOriginal().getid_sucursal()!=null)
				{
					strValorActual=liquidacionimpor.getLiquidacionImporOriginal().getid_sucursal().toString();
				}
				if(liquidacionimpor.getid_sucursal()!=null)
				{
					strValorNuevo=liquidacionimpor.getid_sucursal().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),LiquidacionImporConstantesFunciones.IDSUCURSAL,strValorActual,strValorNuevo);
			}	
			
			if(liquidacionimpor.getIsNew()||!liquidacionimpor.getid_centro_costo().equals(liquidacionimpor.getLiquidacionImporOriginal().getid_centro_costo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(liquidacionimpor.getLiquidacionImporOriginal().getid_centro_costo()!=null)
				{
					strValorActual=liquidacionimpor.getLiquidacionImporOriginal().getid_centro_costo().toString();
				}
				if(liquidacionimpor.getid_centro_costo()!=null)
				{
					strValorNuevo=liquidacionimpor.getid_centro_costo().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),LiquidacionImporConstantesFunciones.IDCENTROCOSTO,strValorActual,strValorNuevo);
			}	
			
			if(liquidacionimpor.getIsNew()||!liquidacionimpor.getid_cuenta_contable().equals(liquidacionimpor.getLiquidacionImporOriginal().getid_cuenta_contable()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(liquidacionimpor.getLiquidacionImporOriginal().getid_cuenta_contable()!=null)
				{
					strValorActual=liquidacionimpor.getLiquidacionImporOriginal().getid_cuenta_contable().toString();
				}
				if(liquidacionimpor.getid_cuenta_contable()!=null)
				{
					strValorNuevo=liquidacionimpor.getid_cuenta_contable().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),LiquidacionImporConstantesFunciones.IDCUENTACONTABLE,strValorActual,strValorNuevo);
			}	
			
			if(liquidacionimpor.getIsNew()||!liquidacionimpor.getid_pais().equals(liquidacionimpor.getLiquidacionImporOriginal().getid_pais()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(liquidacionimpor.getLiquidacionImporOriginal().getid_pais()!=null)
				{
					strValorActual=liquidacionimpor.getLiquidacionImporOriginal().getid_pais().toString();
				}
				if(liquidacionimpor.getid_pais()!=null)
				{
					strValorNuevo=liquidacionimpor.getid_pais().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),LiquidacionImporConstantesFunciones.IDPAIS,strValorActual,strValorNuevo);
			}	
			
			if(liquidacionimpor.getIsNew()||!liquidacionimpor.getid_puerto().equals(liquidacionimpor.getLiquidacionImporOriginal().getid_puerto()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(liquidacionimpor.getLiquidacionImporOriginal().getid_puerto()!=null)
				{
					strValorActual=liquidacionimpor.getLiquidacionImporOriginal().getid_puerto().toString();
				}
				if(liquidacionimpor.getid_puerto()!=null)
				{
					strValorNuevo=liquidacionimpor.getid_puerto().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),LiquidacionImporConstantesFunciones.IDPUERTO,strValorActual,strValorNuevo);
			}	
			
			if(liquidacionimpor.getIsNew()||!liquidacionimpor.getnombre().equals(liquidacionimpor.getLiquidacionImporOriginal().getnombre()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(liquidacionimpor.getLiquidacionImporOriginal().getnombre()!=null)
				{
					strValorActual=liquidacionimpor.getLiquidacionImporOriginal().getnombre();
				}
				if(liquidacionimpor.getnombre()!=null)
				{
					strValorNuevo=liquidacionimpor.getnombre() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),LiquidacionImporConstantesFunciones.NOMBRE,strValorActual,strValorNuevo);
			}	
			
			if(liquidacionimpor.getIsNew()||!liquidacionimpor.getdescripcion().equals(liquidacionimpor.getLiquidacionImporOriginal().getdescripcion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(liquidacionimpor.getLiquidacionImporOriginal().getdescripcion()!=null)
				{
					strValorActual=liquidacionimpor.getLiquidacionImporOriginal().getdescripcion();
				}
				if(liquidacionimpor.getdescripcion()!=null)
				{
					strValorNuevo=liquidacionimpor.getdescripcion() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),LiquidacionImporConstantesFunciones.DESCRIPCION,strValorActual,strValorNuevo);
			}	
			
			if(liquidacionimpor.getIsNew()||!liquidacionimpor.getfecha().equals(liquidacionimpor.getLiquidacionImporOriginal().getfecha()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(liquidacionimpor.getLiquidacionImporOriginal().getfecha()!=null)
				{
					strValorActual=liquidacionimpor.getLiquidacionImporOriginal().getfecha().toString();
				}
				if(liquidacionimpor.getfecha()!=null)
				{
					strValorNuevo=liquidacionimpor.getfecha().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),LiquidacionImporConstantesFunciones.FECHA,strValorActual,strValorNuevo);
			}	
			
			if(liquidacionimpor.getIsNew()||!liquidacionimpor.getfecha_liquidacion().equals(liquidacionimpor.getLiquidacionImporOriginal().getfecha_liquidacion()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(liquidacionimpor.getLiquidacionImporOriginal().getfecha_liquidacion()!=null)
				{
					strValorActual=liquidacionimpor.getLiquidacionImporOriginal().getfecha_liquidacion().toString();
				}
				if(liquidacionimpor.getfecha_liquidacion()!=null)
				{
					strValorNuevo=liquidacionimpor.getfecha_liquidacion().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),LiquidacionImporConstantesFunciones.FECHALIQUIDACION,strValorActual,strValorNuevo);
			}	
			
			if(liquidacionimpor.getIsNew()||!liquidacionimpor.getflete().equals(liquidacionimpor.getLiquidacionImporOriginal().getflete()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(liquidacionimpor.getLiquidacionImporOriginal().getflete()!=null)
				{
					strValorActual=liquidacionimpor.getLiquidacionImporOriginal().getflete().toString();
				}
				if(liquidacionimpor.getflete()!=null)
				{
					strValorNuevo=liquidacionimpor.getflete().toString() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),LiquidacionImporConstantesFunciones.FLETE,strValorActual,strValorNuevo);
			}	
			
			if(liquidacionimpor.getIsNew()||!liquidacionimpor.gettipo().equals(liquidacionimpor.getLiquidacionImporOriginal().gettipo()))
			{
				strValorActual=null;
				strValorNuevo=null;

				if(liquidacionimpor.getLiquidacionImporOriginal().gettipo()!=null)
				{
					strValorActual=liquidacionimpor.getLiquidacionImporOriginal().gettipo();
				}
				if(liquidacionimpor.gettipo()!=null)
				{
					strValorNuevo=liquidacionimpor.gettipo() ;
				}

				////auditoriaDetalleLogicAdditional.registrarNuevaAuditoriaDetalle(auditoriaObj.getId(),LiquidacionImporConstantesFunciones.TIPO,strValorActual,strValorNuevo);
			}	
	}
	
	
	
	
	
		
	
	
	

	public void saveLiquidacionImporRelacionesWithConnection(LiquidacionImpor liquidacionimpor,List<DetalleLiquidacionImpor> detalleliquidacionimpors) throws Exception {

		if(!liquidacionimpor.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveLiquidacionImporRelacionesBase(liquidacionimpor,detalleliquidacionimpors,true);
		}
	}

	public void saveLiquidacionImporRelaciones(LiquidacionImpor liquidacionimpor,List<DetalleLiquidacionImpor> detalleliquidacionimpors)throws Exception {

		if(!liquidacionimpor.getsType().contains(Constantes2.S_TOTALES)) {
			this.saveLiquidacionImporRelacionesBase(liquidacionimpor,detalleliquidacionimpors,false);
		}
	}

	public void saveLiquidacionImporRelacionesBase(LiquidacionImpor liquidacionimpor,List<DetalleLiquidacionImpor> detalleliquidacionimpors,Boolean conConexion)throws Exception {
		try {
			if(conConexion) {this.getNewConnexionToDeep("LiquidacionImpor-saveRelacionesWithConnection");}
	
			liquidacionimpor.setDetalleLiquidacionImpors(detalleliquidacionimpors);

			this.setLiquidacionImpor(liquidacionimpor);

			if(LiquidacionImporLogicAdditional.validarSaveRelaciones(liquidacionimpor,this)) {

				LiquidacionImporLogicAdditional.updateRelacionesToSave(liquidacionimpor,this);

				if((liquidacionimpor.getIsNew()||liquidacionimpor.getIsChanged())&&!liquidacionimpor.getIsDeleted()) {
					this.saveLiquidacionImpor();
					this.saveLiquidacionImporRelacionesDetalles(detalleliquidacionimpors);

				} else if(liquidacionimpor.getIsDeleted()) {
					this.saveLiquidacionImporRelacionesDetalles(detalleliquidacionimpors);
					this.saveLiquidacionImpor();
				}

				LiquidacionImporLogicAdditional.updateRelacionesToSaveAfter(liquidacionimpor,this);

			} else {
				throw new Exception("LOS DATOS SON INVALIDOS");
			}

			if(conConexion) {connexion.commit();}

		} catch(Exception e) {
			
			DetalleLiquidacionImporConstantesFunciones.InicializarGeneralEntityAuxiliaresDetalleLiquidacionImpors(detalleliquidacionimpors,true,true);

			if(conConexion){connexion.rollback();}
			Funciones.manageException(logger,e);
			throw e;

		} finally {
			if(conConexion){this.closeNewConnexionToDeep();}
		}
	}
	
	
	private void saveLiquidacionImporRelacionesDetalles(List<DetalleLiquidacionImpor> detalleliquidacionimpors)throws Exception {
		try {
	

			Long idLiquidacionImporActual=this.getLiquidacionImpor().getId();

			DetalleLiquidacionImporLogic detalleliquidacionimporLogic_Desde_LiquidacionImpor=new DetalleLiquidacionImporLogic();
			detalleliquidacionimporLogic_Desde_LiquidacionImpor.setDetalleLiquidacionImpors(detalleliquidacionimpors);

			detalleliquidacionimporLogic_Desde_LiquidacionImpor.setConnexion(this.getConnexion());
			detalleliquidacionimporLogic_Desde_LiquidacionImpor.setDatosCliente(this.datosCliente);

			for(DetalleLiquidacionImpor detalleliquidacionimpor_Desde_LiquidacionImpor:detalleliquidacionimporLogic_Desde_LiquidacionImpor.getDetalleLiquidacionImpors()) {
				detalleliquidacionimpor_Desde_LiquidacionImpor.setid_liquidacion_impor(idLiquidacionImporActual);
			}

			detalleliquidacionimporLogic_Desde_LiquidacionImpor.saveDetalleLiquidacionImpors();

		} catch(Exception e) {


			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	//IF MAX CODE
			
	public static ArrayList<Classe> getClassesForeignKeysOfLiquidacionImpor(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=LiquidacionImporConstantesFunciones.getClassesForeignKeysOfLiquidacionImpor(classesP,deepLoadType);	
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfLiquidacionImpor(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=LiquidacionImporConstantesFunciones.getClassesRelationshipsOfLiquidacionImpor(classesP,deepLoadType);				
			
			
			return classes;
			
		} catch(Exception e) {
			Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	
	
	
	
	
	
	
	
}
