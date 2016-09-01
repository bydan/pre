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
package com.bydan.erp.puntoventa.business.dataaccess;

import java.util.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.sql.ResultSetMetaData;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.HashMap;

import java.io.File;
import java.lang.reflect.Field;

//COMODIN
import javax.persistence.EntityManagerFactory;

import com.bydan.framework.erp.business.entity.GeneralEntity;
import com.bydan.framework.erp.business.entity.DatoGeneral;
import com.bydan.framework.erp.business.entity.DatoGeneralMinimo;
import com.bydan.framework.erp.business.entity.DatoGeneralMaximo;
import com.bydan.framework.erp.business.entity.Classe;
import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.business.logic.QueryWhereSelectParameters;
import com.bydan.framework.erp.business.logic.ParameterSelectionGeneral;
import com.bydan.framework.erp.business.dataaccess.ConstantesSql;
import com.bydan.framework.erp.business.dataaccess.DataAccessHelper;
import com.bydan.framework.erp.business.dataaccess.DataAccessHelperBase;
import com.bydan.framework.erp.business.dataaccess.DataAccessHelper;

import com.bydan.framework.erp.util.*;

import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.puntoventa.util.*;//PresupuestoVentasPunVenConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;




@SuppressWarnings("unused")
final public class PresupuestoVentasPunVenDataAccess extends  PresupuestoVentasPunVenDataAccessAdditional{ //PresupuestoVentasPunVenDataAccessAdditional,DataAccessHelper<PresupuestoVentasPunVen>
	//static Logger logger = Logger.getLogger(PresupuestoVentasPunVenDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="presupuesto_ventas_pun_ven";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+PresupuestoVentasPunVenConstantesFunciones.SCHEMA+"."+PresupuestoVentasPunVenConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,id_ejercicio,id_periodo,id_caja,valor,cantidad,porcentaje,cantidad_total,valor_total)values(current_timestamp,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+PresupuestoVentasPunVenConstantesFunciones.SCHEMA+"."+PresupuestoVentasPunVenConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_ejercicio=?,id_periodo=?,id_caja=?,valor=?,cantidad=?,porcentaje=?,cantidad_total=?,valor_total=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+PresupuestoVentasPunVenConstantesFunciones.SCHEMA+"."+PresupuestoVentasPunVenConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select presupuestoventaspunven from "+PresupuestoVentasPunVenConstantesFunciones.SPERSISTENCENAME+" presupuestoventaspunven";
	public static String QUERYSELECTNATIVE="select "+PresupuestoVentasPunVenConstantesFunciones.SCHEMA+"."+PresupuestoVentasPunVenConstantesFunciones.TABLENAME+".id,"+PresupuestoVentasPunVenConstantesFunciones.SCHEMA+"."+PresupuestoVentasPunVenConstantesFunciones.TABLENAME+".version_row,"+PresupuestoVentasPunVenConstantesFunciones.SCHEMA+"."+PresupuestoVentasPunVenConstantesFunciones.TABLENAME+".id_empresa,"+PresupuestoVentasPunVenConstantesFunciones.SCHEMA+"."+PresupuestoVentasPunVenConstantesFunciones.TABLENAME+".id_sucursal,"+PresupuestoVentasPunVenConstantesFunciones.SCHEMA+"."+PresupuestoVentasPunVenConstantesFunciones.TABLENAME+".id_ejercicio,"+PresupuestoVentasPunVenConstantesFunciones.SCHEMA+"."+PresupuestoVentasPunVenConstantesFunciones.TABLENAME+".id_periodo,"+PresupuestoVentasPunVenConstantesFunciones.SCHEMA+"."+PresupuestoVentasPunVenConstantesFunciones.TABLENAME+".id_caja,"+PresupuestoVentasPunVenConstantesFunciones.SCHEMA+"."+PresupuestoVentasPunVenConstantesFunciones.TABLENAME+".valor,"+PresupuestoVentasPunVenConstantesFunciones.SCHEMA+"."+PresupuestoVentasPunVenConstantesFunciones.TABLENAME+".cantidad,"+PresupuestoVentasPunVenConstantesFunciones.SCHEMA+"."+PresupuestoVentasPunVenConstantesFunciones.TABLENAME+".porcentaje,"+PresupuestoVentasPunVenConstantesFunciones.SCHEMA+"."+PresupuestoVentasPunVenConstantesFunciones.TABLENAME+".cantidad_total,"+PresupuestoVentasPunVenConstantesFunciones.SCHEMA+"."+PresupuestoVentasPunVenConstantesFunciones.TABLENAME+".valor_total from "+PresupuestoVentasPunVenConstantesFunciones.SCHEMA+"."+PresupuestoVentasPunVenConstantesFunciones.TABLENAME;//+" as "+PresupuestoVentasPunVenConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+PresupuestoVentasPunVenConstantesFunciones.SCHEMA+"."+PresupuestoVentasPunVenConstantesFunciones.TABLENAME+".id,"+PresupuestoVentasPunVenConstantesFunciones.SCHEMA+"."+PresupuestoVentasPunVenConstantesFunciones.TABLENAME+".version_row from "+PresupuestoVentasPunVenConstantesFunciones.SCHEMA+"."+PresupuestoVentasPunVenConstantesFunciones.TABLENAME;//+" as "+PresupuestoVentasPunVenConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+PresupuestoVentasPunVenConstantesFunciones.SCHEMA+"."+PresupuestoVentasPunVenConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_ejercicio=?,id_periodo=?,id_caja=?,valor=?,cantidad=?,porcentaje=?,cantidad_total=?,valor_total=?";
	
	public static String STOREPROCEDUREINSERT="call SP_PRESUPUESTOVENTASPUNVEN_INSERT(?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_PRESUPUESTOVENTASPUNVEN_UPDATE(?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_PRESUPUESTOVENTASPUNVEN_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_PRESUPUESTOVENTASPUNVEN_SELECT(?,?)";
	
	public static Boolean ISDELETECASCADE=false;
	public static boolean ISWITHSCHEMA=true;
	public static boolean ISWITHSTOREPROCEDURES=false;
	
	protected Boolean isForForeingKeyData=false;
	protected Boolean isForForeingsKeysDataRelationships=false;
	
	protected ConnexionType connexionType;
	protected ParameterDbType parameterDbType;
	
	
	private Object entityObject;
	
	private List<Object> entitiesObject;
	
	protected DatosCliente datosCliente;
	
	
	protected PresupuestoVentasPunVenDataAccessAdditional presupuestoventaspunvenDataAccessAdditional=null;
	
	public PresupuestoVentasPunVenDataAccessAdditional getPresupuestoVentasPunVenDataAccessAdditional() {
		return this.presupuestoventaspunvenDataAccessAdditional;
	}
	
	public void setPresupuestoVentasPunVenDataAccessAdditional(PresupuestoVentasPunVenDataAccessAdditional presupuestoventaspunvenDataAccessAdditional) {
		try {
			this.presupuestoventaspunvenDataAccessAdditional=presupuestoventaspunvenDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public PresupuestoVentasPunVenDataAccess() {
		this.entityObject=new Object();
		this.entitiesObject=new ArrayList<Object>();
		this.isForForeingKeyData=false;
		this.isForForeingsKeysDataRelationships=false;
		this.datosCliente=new DatosCliente();
	}
	
	
	public Boolean getIsForForeingKeyData() {
		return this.isForForeingKeyData;
	}

	public void setIsForForeingKeyData(Boolean isForForeingKeyData) {
		this.isForForeingKeyData = isForForeingKeyData;
	}
	
	public Boolean getIsForForeingsKeysDataRelationships() {
		return this.isForForeingsKeysDataRelationships;
	}

	public void setIsForForeingsKeysDataRelationships(Boolean isForForeingsKeysDataRelationships) {
		this.isForForeingsKeysDataRelationships = isForForeingsKeysDataRelationships;
	}
	
	public static boolean getISWITHSCHEMA() {
		return ISWITHSCHEMA;
	}

	public static void setISWITHSCHEMA(boolean ANISWITHSCHEMA) {
		ISWITHSCHEMA = ANISWITHSCHEMA;
	}		
	
	public static boolean getISWITHSTOREPROCEDURES() {
		return ISWITHSTOREPROCEDURES;
	}

	public static void setISWITHSTOREPROCEDURES(boolean ANISWITHSTOREPROCEDURES) {
		ISWITHSTOREPROCEDURES =ANISWITHSTOREPROCEDURES;
	}
	
	public static String getTABLENAME() {
		return TABLENAME;
	}
	
	public static void setTABLENAME(String sTABLENAME) {
		PresupuestoVentasPunVenDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		PresupuestoVentasPunVenDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		PresupuestoVentasPunVenDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
	}
	
	public List<Object> getEntitiesObject() {
		return this.entitiesObject;
	}

	public void setEntitiesObject(List<Object> entitiesObject) {
		this.entitiesObject= entitiesObject;
	}
	
	public Object getEntityObject() {
		return this.entityObject;
	}

	public void setEntityObject(Object entityObject) {
		this.entityObject= entityObject;
	}
	
	public static ParametersMaintenance getParametersMaintenance(GeneralEntity generalEntity) {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
		int orderParameter;

		return parametersMaintenance;
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

	//COMODIN
	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		
	}
	
	public DatosCliente getDatosCliente() {
		return datosCliente;
	}

	public void setDatosCliente(DatosCliente datosCliente) {
		this.datosCliente = datosCliente;
	}
	
	public void setPresupuestoVentasPunVenOriginal(PresupuestoVentasPunVen presupuestoventaspunven)throws Exception  {
		presupuestoventaspunven.setPresupuestoVentasPunVenOriginal((PresupuestoVentasPunVen)presupuestoventaspunven.clone());		
	}
	
	public void setPresupuestoVentasPunVensOriginal(List<PresupuestoVentasPunVen> presupuestoventaspunvens)throws Exception  {
		
		for(PresupuestoVentasPunVen presupuestoventaspunven:presupuestoventaspunvens){
			presupuestoventaspunven.setPresupuestoVentasPunVenOriginal((PresupuestoVentasPunVen)presupuestoventaspunven.clone());
		}
	}
	
	public static void setPresupuestoVentasPunVenOriginalStatic(PresupuestoVentasPunVen presupuestoventaspunven)throws Exception  {
		presupuestoventaspunven.setPresupuestoVentasPunVenOriginal((PresupuestoVentasPunVen)presupuestoventaspunven.clone());		
	}
	
	public static void setPresupuestoVentasPunVensOriginalStatic(List<PresupuestoVentasPunVen> presupuestoventaspunvens)throws Exception  {
		
		for(PresupuestoVentasPunVen presupuestoventaspunven:presupuestoventaspunvens){
			presupuestoventaspunven.setPresupuestoVentasPunVenOriginal((PresupuestoVentasPunVen)presupuestoventaspunven.clone());
		}
	}
	
	public  void executeQuery(Connexion connexion, String sQueryExecute) throws Exception {	
        try {
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				this.executeQueryJdbc(connexion, sQueryExecute);
			} else {
				//this.executeQueryHibernate(connexion, sQueryExecute);
			}
      	} catch(Exception e) {
			throw e;
      	}		    	
    }
	
	public void executeQueryJdbc(Connexion connexion, String sQueryExecute) throws Exception {		
        try {     				
        	PreparedStatement preparedStatement = connexion.getConnection().prepareStatement(sQueryExecute);
      					
        	preparedStatement.executeUpdate();
        	preparedStatement.close();
      		   	
      	} catch(Exception e) {
			throw e;
      	}		
    }
	
	public  PresupuestoVentasPunVen getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		PresupuestoVentasPunVen entity = new PresupuestoVentasPunVen();		
		
        try {
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				entity =this.getEntityJdbc(connexion, id);
			} else {
			}
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	public  PresupuestoVentasPunVen getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		PresupuestoVentasPunVen entity = new PresupuestoVentasPunVen();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=PresupuestoVentasPunVenDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=PresupuestoVentasPunVenDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//PuntoVenta.PresupuestoVentasPunVen.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setPresupuestoVentasPunVenOriginal(new PresupuestoVentasPunVen());
      	    	entity=super.getEntity("",entity,resultSet,PresupuestoVentasPunVenDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityPresupuestoVentasPunVen("",entity,resultSet); 
				
				//entity.setPresupuestoVentasPunVenOriginal(super.getEntity("",entity.getPresupuestoVentasPunVenOriginal(),resultSet,PresupuestoVentasPunVenDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPresupuestoVentasPunVenOriginal(this.getEntityPresupuestoVentasPunVen("",entity.getPresupuestoVentasPunVenOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalsePresupuestoVentasPunVen(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  PresupuestoVentasPunVen getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		PresupuestoVentasPunVen entity = new PresupuestoVentasPunVen();
				
        try  {
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				entity =this.getEntityJdbc(connexion,queryWhereSelectParameters);
			} else {
			}
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  PresupuestoVentasPunVen getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		PresupuestoVentasPunVen entity = new PresupuestoVentasPunVen();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=PresupuestoVentasPunVenDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=PresupuestoVentasPunVenDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PresupuestoVentasPunVenDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//PuntoVenta.PresupuestoVentasPunVen.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setPresupuestoVentasPunVenOriginal(new PresupuestoVentasPunVen());
      	    	entity=super.getEntity("",entity,resultSet,PresupuestoVentasPunVenDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityPresupuestoVentasPunVen("",entity,resultSet);    
				
				//entity.setPresupuestoVentasPunVenOriginal(super.getEntity("",entity.getPresupuestoVentasPunVenOriginal(),resultSet,PresupuestoVentasPunVenDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPresupuestoVentasPunVenOriginal(this.getEntityPresupuestoVentasPunVen("",entity.getPresupuestoVentasPunVenOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalsePresupuestoVentasPunVen(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //PresupuestoVentasPunVen
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		PresupuestoVentasPunVen entity = new PresupuestoVentasPunVen();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=PresupuestoVentasPunVenDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=PresupuestoVentasPunVenDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PresupuestoVentasPunVenDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//PuntoVenta.PresupuestoVentasPunVen.isActive=1
        	 
			//ResultSetMetaData metadata = resultSet.getMetaData();
      	  	
      	  	//int iTotalCountColumn = metadata.getColumnCount();
				
			//if(queryWhereSelectParameters.getIsGetGeneralObjects()) {
				if(resultSet.next()) {				
					for(Classe classe:classes) {
						DataAccessHelperBase.setFieldDynamic(datoGeneralMinimo,classe,resultSet);
					}
					
					/*
					int iIndexColumn = 1;
				    
					while(iIndexColumn <= iTotalCountColumn) {
						//arrayListObject.add(resultSet.getObject(iIndexColumn++));
				    }										
					*/
				} else {
					entity =null;
				}
			//}
			
			if(entity!=null) {
				//this.setIsNewIsChangedFalsePresupuestoVentasPunVen(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<PresupuestoVentasPunVen> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<PresupuestoVentasPunVen> entities = new  ArrayList<PresupuestoVentasPunVen>();
		PresupuestoVentasPunVen entity = new PresupuestoVentasPunVen();		  
		
        try { 
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				entities =this.getEntitiesJdbc(connexion,queryWhereSelectParameters);	
			} else {
			}	
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  List<PresupuestoVentasPunVen> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<PresupuestoVentasPunVen> entities = new  ArrayList<PresupuestoVentasPunVen>();
		PresupuestoVentasPunVen entity = new PresupuestoVentasPunVen();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=PresupuestoVentasPunVenDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=PresupuestoVentasPunVenDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PresupuestoVentasPunVenDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PresupuestoVentasPunVen();
      	    	entity=super.getEntity("",entity,resultSet,PresupuestoVentasPunVenDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityPresupuestoVentasPunVen("",entity,resultSet);
      	    	
				//entity.setPresupuestoVentasPunVenOriginal( new PresupuestoVentasPunVen());
      	    	//entity.setPresupuestoVentasPunVenOriginal(super.getEntity("",entity.getPresupuestoVentasPunVenOriginal(),resultSet,PresupuestoVentasPunVenDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPresupuestoVentasPunVenOriginal(this.getEntityPresupuestoVentasPunVen("",entity.getPresupuestoVentasPunVenOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalsePresupuestoVentasPunVens(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPresupuestoVentasPunVen(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<PresupuestoVentasPunVen> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<PresupuestoVentasPunVen> entities = new  ArrayList<PresupuestoVentasPunVen>();
		PresupuestoVentasPunVen entity = new PresupuestoVentasPunVen();		  
		String sQuery="";
	
        try {
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				entities =this.getEntitiesJdbc(connexion,sQuerySelect,queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);
			} else {
				//entities =this.getEntitiesHibernate(connexion,sQuerySelect,queryWhereSelectParameters,listColumns,conMapGenerico);
			}	
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  List<PresupuestoVentasPunVen> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<PresupuestoVentasPunVen> entities = new  ArrayList<PresupuestoVentasPunVen>();
		PresupuestoVentasPunVen entity = new PresupuestoVentasPunVen();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PresupuestoVentasPunVen();
				
				if(conMapGenerico) {
					entity.inicializarMapPresupuestoVentasPunVen();
					//entity.setMapPresupuestoVentasPunVen(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapPresupuestoVentasPunVenValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapPresupuestoVentasPunVen().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,PresupuestoVentasPunVenDataAccess.ISWITHSCHEMA);         		
					entity=PresupuestoVentasPunVenDataAccess.getEntityPresupuestoVentasPunVen("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setPresupuestoVentasPunVenOriginal( new PresupuestoVentasPunVen());
					////entity.setPresupuestoVentasPunVenOriginal(super.getEntity("",entity.getPresupuestoVentasPunVenOriginal(),resultSet,PresupuestoVentasPunVenDataAccess.ISWITHSCHEMA));         		
					////entity.setPresupuestoVentasPunVenOriginal(this.getEntityPresupuestoVentasPunVen("",entity.getPresupuestoVentasPunVenOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalsePresupuestoVentasPunVens(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPresupuestoVentasPunVen(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public PresupuestoVentasPunVen getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		PresupuestoVentasPunVen entity = new PresupuestoVentasPunVen();		  
		String sQuery="";
	
        try {
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				entity =this.getEntityJdbc(connexion,sQuerySelect,queryWhereSelectParameters,listColumns,deepLoadType,conMapGenerico);
			} else {
				//entity =this.getEntityHibernate(connexion,sQuerySelect,queryWhereSelectParameters,listColumns,conMapGenerico);
			}	
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  PresupuestoVentasPunVen getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		PresupuestoVentasPunVen entity = new PresupuestoVentasPunVen();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PresupuestoVentasPunVen();
				
				if(conMapGenerico) {
					entity.inicializarMapPresupuestoVentasPunVen();
					//entity.setMapPresupuestoVentasPunVen(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapPresupuestoVentasPunVenValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapPresupuestoVentasPunVen().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,PresupuestoVentasPunVenDataAccess.ISWITHSCHEMA);         		
					entity=PresupuestoVentasPunVenDataAccess.getEntityPresupuestoVentasPunVen("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setPresupuestoVentasPunVenOriginal( new PresupuestoVentasPunVen());
					////entity.setPresupuestoVentasPunVenOriginal(super.getEntity("",entity.getPresupuestoVentasPunVenOriginal(),resultSet,PresupuestoVentasPunVenDataAccess.ISWITHSCHEMA));         		
					////entity.setPresupuestoVentasPunVenOriginal(this.getEntityPresupuestoVentasPunVen("",entity.getPresupuestoVentasPunVenOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalsePresupuestoVentasPunVen(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPresupuestoVentasPunVen(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static PresupuestoVentasPunVen getEntityPresupuestoVentasPunVen(String strPrefijo,PresupuestoVentasPunVen entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = PresupuestoVentasPunVen.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = PresupuestoVentasPunVen.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					PresupuestoVentasPunVenDataAccess.setFieldReflectionPresupuestoVentasPunVen(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasPresupuestoVentasPunVen=PresupuestoVentasPunVenConstantesFunciones.getTodosTiposColumnasPresupuestoVentasPunVen();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasPresupuestoVentasPunVen) {
					existe=false;
					
					for(String sColumnExlude:listColumns) {	        	
						if(sColumn.equals(sColumnExlude)) {
							existe=true;
							break;
						}
					} 
					
					if(!existe) {
						//ESTE PROCESO ES REPETIDO DE INCLUDE
						Field field =null;
						try {
							field = PresupuestoVentasPunVen.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = PresupuestoVentasPunVen.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						PresupuestoVentasPunVenDataAccess.setFieldReflectionPresupuestoVentasPunVen(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionPresupuestoVentasPunVen(Field field,String strPrefijo,String sColumn,PresupuestoVentasPunVen entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case PresupuestoVentasPunVenConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PresupuestoVentasPunVenConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case PresupuestoVentasPunVenConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PresupuestoVentasPunVenConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PresupuestoVentasPunVenConstantesFunciones.IDEJERCICIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PresupuestoVentasPunVenConstantesFunciones.IDPERIODO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PresupuestoVentasPunVenConstantesFunciones.IDCAJA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case PresupuestoVentasPunVenConstantesFunciones.VALOR:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case PresupuestoVentasPunVenConstantesFunciones.CANTIDAD:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case PresupuestoVentasPunVenConstantesFunciones.PORCENTAJE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case PresupuestoVentasPunVenConstantesFunciones.CANTIDADTOTAL:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case PresupuestoVentasPunVenConstantesFunciones.VALORTOTAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				default: 
					//CUANDO SE UTILIZA CAMPOS DIFERENCTES A LOS ORIGINALMENTE DEFINIDOS(ADDITIONAL)
					DataAccessHelperBase.setFieldDynamic(entity,sCampo,field,resultSet);
					break;
				/*
        		case "id":
        			field.set(entity, resultSet.getLong(sCampo));
        			break;        		        			
				*/
        	}    
      	} catch(Exception e) {
			throw e;
      	}		
    }
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<PresupuestoVentasPunVen>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<PresupuestoVentasPunVen> entities = new  ArrayList<PresupuestoVentasPunVen>();
		PresupuestoVentasPunVen entity = new PresupuestoVentasPunVen();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=PresupuestoVentasPunVenDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=PresupuestoVentasPunVenDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PresupuestoVentasPunVenDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	
			//ResultSetMetaData metadata = resultSet.getMetaData();
      	  	
      	  	//int iTotalCountColumn = metadata.getColumnCount();
				
			//if(queryWhereSelectParameters.getIsGetGeneralObjects()) {				
				//this.entitiesObject=query.getResultList();	
				
				while (resultSet.next()) {
					datoGeneralMaximo=new DatoGeneralMaximo();
					
					for(Classe classe:classes) {
						DataAccessHelperBase.setFieldDynamic(datoGeneralMaximo,classe,resultSet);
					}
					
					//int iIndexColumn = 1;
				    
					/*
					while(iIndexColumn <= iTotalCountColumn) {
				    	arrayListObject.add(resultSet.getObject(iIndexColumn++));
				    }
					*/
					
					datoGeneralMaximos.add(datoGeneralMaximo);
					
					
					
					//arrayListObjects.add(arrayListObject);
					
					/*
					entity = new PresupuestoVentasPunVen();
					entity=super.getEntity("",entity,resultSet,PresupuestoVentasPunVenDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityPresupuestoVentasPunVen("",entity,resultSet);
					
					//entity.setPresupuestoVentasPunVenOriginal( new PresupuestoVentasPunVen());
					//entity.setPresupuestoVentasPunVenOriginal(super.getEntity("",entity.getPresupuestoVentasPunVenOriginal(),resultSet,PresupuestoVentasPunVenDataAccess.ISWITHSCHEMA));         		
					//entity.setPresupuestoVentasPunVenOriginal(this.getEntityPresupuestoVentasPunVen("",entity.getPresupuestoVentasPunVenOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalsePresupuestoVentasPunVens(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPresupuestoVentasPunVen(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<PresupuestoVentasPunVen>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<PresupuestoVentasPunVen> entities = new  ArrayList<PresupuestoVentasPunVen>();
		PresupuestoVentasPunVen entity = new PresupuestoVentasPunVen();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=PresupuestoVentasPunVenDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=PresupuestoVentasPunVenDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,PresupuestoVentasPunVenDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	
			//ResultSetMetaData metadata = resultSet.getMetaData();
      	  	
      	  	//int iTotalCountColumn = metadata.getColumnCount();
				
			//if(queryWhereSelectParameters.getIsGetGeneralObjects()) {				
				//this.entitiesObject=query.getResultList();	
				
				while (resultSet.next()) {
					datoGeneral=new DatoGeneral();
					
					for(Classe classe:classes) {
						DataAccessHelperBase.setFieldDynamic(datoGeneral,classe,resultSet);
					}
					
					datoGenerals.add(datoGeneral);
				}
			//}
			
			statement.close(); 
			
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGenerals;
    }
	
	
	public  List<PresupuestoVentasPunVen> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PresupuestoVentasPunVen> entities = new  ArrayList<PresupuestoVentasPunVen>();
		PresupuestoVentasPunVen entity = new PresupuestoVentasPunVen();		  
		String sQuery="";
	
        try {
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				entities =this.getEntitiesJdbc(connexion,sQuerySelect,queryWhereSelectParameters);
			} else {
			}	
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  List<PresupuestoVentasPunVen> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PresupuestoVentasPunVen> entities = new  ArrayList<PresupuestoVentasPunVen>();
		PresupuestoVentasPunVen entity = new PresupuestoVentasPunVen();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PresupuestoVentasPunVen();
      	    	entity=super.getEntity("",entity,resultSet,PresupuestoVentasPunVenDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityPresupuestoVentasPunVen("",entity,resultSet);
      	    	
				//entity.setPresupuestoVentasPunVenOriginal( new PresupuestoVentasPunVen());
      	    	//entity.setPresupuestoVentasPunVenOriginal(super.getEntity("",entity.getPresupuestoVentasPunVenOriginal(),resultSet,PresupuestoVentasPunVenDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPresupuestoVentasPunVenOriginal(this.getEntityPresupuestoVentasPunVen("",entity.getPresupuestoVentasPunVenOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalsePresupuestoVentasPunVens(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarPresupuestoVentasPunVen(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<PresupuestoVentasPunVen> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PresupuestoVentasPunVen> entities = new  ArrayList<PresupuestoVentasPunVen>();
		PresupuestoVentasPunVen entity = new PresupuestoVentasPunVen();		  
		String sQuery="";
	
        try {
			queryWhereSelectParameters.setConnexionType(this.connexionType);
        	queryWhereSelectParameters.setDbType(this.parameterDbType);
			
			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				entities =this.getEntitiesSimpleQueryBuildJdbc(connexion,sQuerySelect,queryWhereSelectParameters);
			} else {
			}

		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public  List<PresupuestoVentasPunVen> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<PresupuestoVentasPunVen> entities = new  ArrayList<PresupuestoVentasPunVen>();
		PresupuestoVentasPunVen entity = new PresupuestoVentasPunVen();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new PresupuestoVentasPunVen();
      	    	entity=super.getEntity("",entity,resultSet,PresupuestoVentasPunVenDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityPresupuestoVentasPunVen("",entity,resultSet);
      	    	
				//entity.setPresupuestoVentasPunVenOriginal( new PresupuestoVentasPunVen());
      	    	//entity.setPresupuestoVentasPunVenOriginal(super.getEntity("",entity.getPresupuestoVentasPunVenOriginal(),resultSet,PresupuestoVentasPunVenDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setPresupuestoVentasPunVenOriginal(this.getEntityPresupuestoVentasPunVen("",entity.getPresupuestoVentasPunVenOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalsePresupuestoVentasPunVens(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public PresupuestoVentasPunVen getEntityPresupuestoVentasPunVen(String strPrefijo,PresupuestoVentasPunVen entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+PresupuestoVentasPunVenConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+PresupuestoVentasPunVenConstantesFunciones.IDSUCURSAL));
				entity.setid_ejercicio(resultSet.getLong(strPrefijo+PresupuestoVentasPunVenConstantesFunciones.IDEJERCICIO));
				entity.setid_periodo(resultSet.getLong(strPrefijo+PresupuestoVentasPunVenConstantesFunciones.IDPERIODO));
				entity.setid_caja(resultSet.getLong(strPrefijo+PresupuestoVentasPunVenConstantesFunciones.IDCAJA));
				entity.setvalor(resultSet.getDouble(strPrefijo+PresupuestoVentasPunVenConstantesFunciones.VALOR));
				entity.setcantidad(resultSet.getInt(strPrefijo+PresupuestoVentasPunVenConstantesFunciones.CANTIDAD));
				entity.setporcentaje(resultSet.getDouble(strPrefijo+PresupuestoVentasPunVenConstantesFunciones.PORCENTAJE));
				entity.setcantidad_total(resultSet.getInt(strPrefijo+PresupuestoVentasPunVenConstantesFunciones.CANTIDADTOTAL));
				entity.setvalor_total(resultSet.getDouble(strPrefijo+PresupuestoVentasPunVenConstantesFunciones.VALORTOTAL));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowPresupuestoVentasPunVen(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(PresupuestoVentasPunVen entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=PresupuestoVentasPunVenDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=PresupuestoVentasPunVenDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=PresupuestoVentasPunVenDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=PresupuestoVentasPunVenDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(PresupuestoVentasPunVenConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,PresupuestoVentasPunVenDataAccess.TABLENAME,PresupuestoVentasPunVenDataAccess.ISWITHSTOREPROCEDURES);
			
			PresupuestoVentasPunVenDataAccess.setPresupuestoVentasPunVenOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,PresupuestoVentasPunVen relpresupuestoventaspunven)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relpresupuestoventaspunven.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,PresupuestoVentasPunVen relpresupuestoventaspunven)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,relpresupuestoventaspunven.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Ejercicio getEjercicio(Connexion connexion,PresupuestoVentasPunVen relpresupuestoventaspunven)throws SQLException,Exception {

		Ejercicio ejercicio= new Ejercicio();

		try {
			EjercicioDataAccess ejercicioDataAccess=new EjercicioDataAccess();

			ejercicioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ejercicioDataAccess.setConnexionType(this.connexionType);
			ejercicioDataAccess.setParameterDbType(this.parameterDbType);

			ejercicio=ejercicioDataAccess.getEntity(connexion,relpresupuestoventaspunven.getid_ejercicio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ejercicio;

	}

	public Periodo getPeriodo(Connexion connexion,PresupuestoVentasPunVen relpresupuestoventaspunven)throws SQLException,Exception {

		Periodo periodo= new Periodo();

		try {
			PeriodoDataAccess periodoDataAccess=new PeriodoDataAccess();

			periodoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			periodoDataAccess.setConnexionType(this.connexionType);
			periodoDataAccess.setParameterDbType(this.parameterDbType);

			periodo=periodoDataAccess.getEntity(connexion,relpresupuestoventaspunven.getid_periodo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return periodo;

	}

	public Caja getCaja(Connexion connexion,PresupuestoVentasPunVen relpresupuestoventaspunven)throws SQLException,Exception {

		Caja caja= new Caja();

		try {
			CajaDataAccess cajaDataAccess=new CajaDataAccess();

			cajaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cajaDataAccess.setConnexionType(this.connexionType);
			cajaDataAccess.setParameterDbType(this.parameterDbType);

			caja=cajaDataAccess.getEntity(connexion,relpresupuestoventaspunven.getid_caja());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return caja;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,PresupuestoVentasPunVen presupuestoventaspunven) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!presupuestoventaspunven.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(presupuestoventaspunven.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(presupuestoventaspunven.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_ejercicio=new ParameterValue<Long>();
					parameterMaintenanceValueid_ejercicio.setValue(presupuestoventaspunven.getid_ejercicio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_ejercicio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_periodo=new ParameterValue<Long>();
					parameterMaintenanceValueid_periodo.setValue(presupuestoventaspunven.getid_periodo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_periodo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_caja=new ParameterValue<Long>();
					parameterMaintenanceValueid_caja.setValue(presupuestoventaspunven.getid_caja());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_caja);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor=new ParameterValue<Double>();
					parameterMaintenanceValuevalor.setValue(presupuestoventaspunven.getvalor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuecantidad=new ParameterValue<Integer>();
					parameterMaintenanceValuecantidad.setValue(presupuestoventaspunven.getcantidad());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecantidad);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueporcentaje=new ParameterValue<Double>();
					parameterMaintenanceValueporcentaje.setValue(presupuestoventaspunven.getporcentaje());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueporcentaje);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuecantidad_total=new ParameterValue<Integer>();
					parameterMaintenanceValuecantidad_total.setValue(presupuestoventaspunven.getcantidad_total());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecantidad_total);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor_total=new ParameterValue<Double>();
					parameterMaintenanceValuevalor_total.setValue(presupuestoventaspunven.getvalor_total());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor_total);
					parametersTemp.add(parameterMaintenance);
					
						if(!presupuestoventaspunven.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(presupuestoventaspunven.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(presupuestoventaspunven.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(presupuestoventaspunven.getId());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
					parametersTemp.add(parameterMaintenance);
				}
			
			parametersMaintenance= new ParametersMaintenance();
			parametersMaintenance.setDbType(newDbType);
			parametersMaintenance.setParametersMaintenance(parametersTemp);
			//super.setParametersMaintenance(parametersMaintenance);		
		} catch(Exception e) {
			throw e;
		}
		
		return parametersMaintenance;
	}
	
	public void setIsNewIsChangedFalsePresupuestoVentasPunVen(PresupuestoVentasPunVen presupuestoventaspunven)throws Exception  {		
		presupuestoventaspunven.setIsNew(false);
		presupuestoventaspunven.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalsePresupuestoVentasPunVens(List<PresupuestoVentasPunVen> presupuestoventaspunvens)throws Exception  {				
		for(PresupuestoVentasPunVen presupuestoventaspunven:presupuestoventaspunvens) {
			presupuestoventaspunven.setIsNew(false);
			presupuestoventaspunven.setIsChanged(false);
		}
	}
	
	public void generarExportarPresupuestoVentasPunVen(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
		try {
			if(this.datosCliente.getIsConExportar()) {
				String sQueryExportar=Funciones2.getQueryExportar(this.datosCliente, sQuery, queryWhereSelectParameters);
				
				this.executeQueryJdbc(connexion,sQueryExportar);
			}
		} catch(Exception e) {
			e.printStackTrace();
			//System.out.print(e.getStackTrace());
		}
	}
}
   
