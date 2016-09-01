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
package com.bydan.erp.activosfijos.business.dataaccess;

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

import com.bydan.erp.activosfijos.business.entity.*;
import com.bydan.erp.activosfijos.util.*;//MantenimientoActivoFijoConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;




@SuppressWarnings("unused")
final public class MantenimientoActivoFijoDataAccess extends  MantenimientoActivoFijoDataAccessAdditional{ //MantenimientoActivoFijoDataAccessAdditional,DataAccessHelper<MantenimientoActivoFijo>
	//static Logger logger = Logger.getLogger(MantenimientoActivoFijoDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="mantenimiento_activo_fijo";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+MantenimientoActivoFijoConstantesFunciones.SCHEMA+"."+MantenimientoActivoFijoConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,id_detalle_activo_fijo,id_tipo_movimiento,numero_documento,causa,referencia,taller,telefono,fecha_inicio,fecha_entrega,costo,responsable,observacion)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+MantenimientoActivoFijoConstantesFunciones.SCHEMA+"."+MantenimientoActivoFijoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_detalle_activo_fijo=?,id_tipo_movimiento=?,numero_documento=?,causa=?,referencia=?,taller=?,telefono=?,fecha_inicio=?,fecha_entrega=?,costo=?,responsable=?,observacion=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+MantenimientoActivoFijoConstantesFunciones.SCHEMA+"."+MantenimientoActivoFijoConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select mantenimientoactivofijo from "+MantenimientoActivoFijoConstantesFunciones.SPERSISTENCENAME+" mantenimientoactivofijo";
	public static String QUERYSELECTNATIVE="select "+MantenimientoActivoFijoConstantesFunciones.SCHEMA+"."+MantenimientoActivoFijoConstantesFunciones.TABLENAME+".id,"+MantenimientoActivoFijoConstantesFunciones.SCHEMA+"."+MantenimientoActivoFijoConstantesFunciones.TABLENAME+".version_row,"+MantenimientoActivoFijoConstantesFunciones.SCHEMA+"."+MantenimientoActivoFijoConstantesFunciones.TABLENAME+".id_empresa,"+MantenimientoActivoFijoConstantesFunciones.SCHEMA+"."+MantenimientoActivoFijoConstantesFunciones.TABLENAME+".id_sucursal,"+MantenimientoActivoFijoConstantesFunciones.SCHEMA+"."+MantenimientoActivoFijoConstantesFunciones.TABLENAME+".id_detalle_activo_fijo,"+MantenimientoActivoFijoConstantesFunciones.SCHEMA+"."+MantenimientoActivoFijoConstantesFunciones.TABLENAME+".id_tipo_movimiento,"+MantenimientoActivoFijoConstantesFunciones.SCHEMA+"."+MantenimientoActivoFijoConstantesFunciones.TABLENAME+".numero_documento,"+MantenimientoActivoFijoConstantesFunciones.SCHEMA+"."+MantenimientoActivoFijoConstantesFunciones.TABLENAME+".causa,"+MantenimientoActivoFijoConstantesFunciones.SCHEMA+"."+MantenimientoActivoFijoConstantesFunciones.TABLENAME+".referencia,"+MantenimientoActivoFijoConstantesFunciones.SCHEMA+"."+MantenimientoActivoFijoConstantesFunciones.TABLENAME+".taller,"+MantenimientoActivoFijoConstantesFunciones.SCHEMA+"."+MantenimientoActivoFijoConstantesFunciones.TABLENAME+".telefono,"+MantenimientoActivoFijoConstantesFunciones.SCHEMA+"."+MantenimientoActivoFijoConstantesFunciones.TABLENAME+".fecha_inicio,"+MantenimientoActivoFijoConstantesFunciones.SCHEMA+"."+MantenimientoActivoFijoConstantesFunciones.TABLENAME+".fecha_entrega,"+MantenimientoActivoFijoConstantesFunciones.SCHEMA+"."+MantenimientoActivoFijoConstantesFunciones.TABLENAME+".costo,"+MantenimientoActivoFijoConstantesFunciones.SCHEMA+"."+MantenimientoActivoFijoConstantesFunciones.TABLENAME+".responsable,"+MantenimientoActivoFijoConstantesFunciones.SCHEMA+"."+MantenimientoActivoFijoConstantesFunciones.TABLENAME+".observacion from "+MantenimientoActivoFijoConstantesFunciones.SCHEMA+"."+MantenimientoActivoFijoConstantesFunciones.TABLENAME;//+" as "+MantenimientoActivoFijoConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+MantenimientoActivoFijoConstantesFunciones.SCHEMA+"."+MantenimientoActivoFijoConstantesFunciones.TABLENAME+".id,"+MantenimientoActivoFijoConstantesFunciones.SCHEMA+"."+MantenimientoActivoFijoConstantesFunciones.TABLENAME+".version_row from "+MantenimientoActivoFijoConstantesFunciones.SCHEMA+"."+MantenimientoActivoFijoConstantesFunciones.TABLENAME;//+" as "+MantenimientoActivoFijoConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+MantenimientoActivoFijoConstantesFunciones.SCHEMA+"."+MantenimientoActivoFijoConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_detalle_activo_fijo=?,id_tipo_movimiento=?,numero_documento=?,causa=?,referencia=?,taller=?,telefono=?,fecha_inicio=?,fecha_entrega=?,costo=?,responsable=?,observacion=?";
	
	public static String STOREPROCEDUREINSERT="call SP_MANTENIMIENTOACTIVOFIJO_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_MANTENIMIENTOACTIVOFIJO_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_MANTENIMIENTOACTIVOFIJO_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_MANTENIMIENTOACTIVOFIJO_SELECT(?,?)";
	
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
	
	
	protected MantenimientoActivoFijoDataAccessAdditional mantenimientoactivofijoDataAccessAdditional=null;
	
	public MantenimientoActivoFijoDataAccessAdditional getMantenimientoActivoFijoDataAccessAdditional() {
		return this.mantenimientoactivofijoDataAccessAdditional;
	}
	
	public void setMantenimientoActivoFijoDataAccessAdditional(MantenimientoActivoFijoDataAccessAdditional mantenimientoactivofijoDataAccessAdditional) {
		try {
			this.mantenimientoactivofijoDataAccessAdditional=mantenimientoactivofijoDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public MantenimientoActivoFijoDataAccess() {
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
		MantenimientoActivoFijoDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		MantenimientoActivoFijoDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		MantenimientoActivoFijoDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setMantenimientoActivoFijoOriginal(MantenimientoActivoFijo mantenimientoactivofijo)throws Exception  {
		mantenimientoactivofijo.setMantenimientoActivoFijoOriginal((MantenimientoActivoFijo)mantenimientoactivofijo.clone());		
	}
	
	public void setMantenimientoActivoFijosOriginal(List<MantenimientoActivoFijo> mantenimientoactivofijos)throws Exception  {
		
		for(MantenimientoActivoFijo mantenimientoactivofijo:mantenimientoactivofijos){
			mantenimientoactivofijo.setMantenimientoActivoFijoOriginal((MantenimientoActivoFijo)mantenimientoactivofijo.clone());
		}
	}
	
	public static void setMantenimientoActivoFijoOriginalStatic(MantenimientoActivoFijo mantenimientoactivofijo)throws Exception  {
		mantenimientoactivofijo.setMantenimientoActivoFijoOriginal((MantenimientoActivoFijo)mantenimientoactivofijo.clone());		
	}
	
	public static void setMantenimientoActivoFijosOriginalStatic(List<MantenimientoActivoFijo> mantenimientoactivofijos)throws Exception  {
		
		for(MantenimientoActivoFijo mantenimientoactivofijo:mantenimientoactivofijos){
			mantenimientoactivofijo.setMantenimientoActivoFijoOriginal((MantenimientoActivoFijo)mantenimientoactivofijo.clone());
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
	
	public  MantenimientoActivoFijo getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		MantenimientoActivoFijo entity = new MantenimientoActivoFijo();		
		
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
	
	public  MantenimientoActivoFijo getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		MantenimientoActivoFijo entity = new MantenimientoActivoFijo();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=MantenimientoActivoFijoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=MantenimientoActivoFijoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//ActivosFijos.MantenimientoActivoFijo.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setMantenimientoActivoFijoOriginal(new MantenimientoActivoFijo());
      	    	entity=super.getEntity("",entity,resultSet,MantenimientoActivoFijoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityMantenimientoActivoFijo("",entity,resultSet); 
				
				//entity.setMantenimientoActivoFijoOriginal(super.getEntity("",entity.getMantenimientoActivoFijoOriginal(),resultSet,MantenimientoActivoFijoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setMantenimientoActivoFijoOriginal(this.getEntityMantenimientoActivoFijo("",entity.getMantenimientoActivoFijoOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseMantenimientoActivoFijo(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  MantenimientoActivoFijo getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		MantenimientoActivoFijo entity = new MantenimientoActivoFijo();
				
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
	
	public  MantenimientoActivoFijo getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		MantenimientoActivoFijo entity = new MantenimientoActivoFijo();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=MantenimientoActivoFijoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=MantenimientoActivoFijoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,MantenimientoActivoFijoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//ActivosFijos.MantenimientoActivoFijo.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setMantenimientoActivoFijoOriginal(new MantenimientoActivoFijo());
      	    	entity=super.getEntity("",entity,resultSet,MantenimientoActivoFijoDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityMantenimientoActivoFijo("",entity,resultSet);    
				
				//entity.setMantenimientoActivoFijoOriginal(super.getEntity("",entity.getMantenimientoActivoFijoOriginal(),resultSet,MantenimientoActivoFijoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setMantenimientoActivoFijoOriginal(this.getEntityMantenimientoActivoFijo("",entity.getMantenimientoActivoFijoOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseMantenimientoActivoFijo(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //MantenimientoActivoFijo
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		MantenimientoActivoFijo entity = new MantenimientoActivoFijo();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=MantenimientoActivoFijoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=MantenimientoActivoFijoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,MantenimientoActivoFijoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//ActivosFijos.MantenimientoActivoFijo.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseMantenimientoActivoFijo(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<MantenimientoActivoFijo> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<MantenimientoActivoFijo> entities = new  ArrayList<MantenimientoActivoFijo>();
		MantenimientoActivoFijo entity = new MantenimientoActivoFijo();		  
		
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
	
	public  List<MantenimientoActivoFijo> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<MantenimientoActivoFijo> entities = new  ArrayList<MantenimientoActivoFijo>();
		MantenimientoActivoFijo entity = new MantenimientoActivoFijo();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=MantenimientoActivoFijoDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=MantenimientoActivoFijoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,MantenimientoActivoFijoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new MantenimientoActivoFijo();
      	    	entity=super.getEntity("",entity,resultSet,MantenimientoActivoFijoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityMantenimientoActivoFijo("",entity,resultSet);
      	    	
				//entity.setMantenimientoActivoFijoOriginal( new MantenimientoActivoFijo());
      	    	//entity.setMantenimientoActivoFijoOriginal(super.getEntity("",entity.getMantenimientoActivoFijoOriginal(),resultSet,MantenimientoActivoFijoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setMantenimientoActivoFijoOriginal(this.getEntityMantenimientoActivoFijo("",entity.getMantenimientoActivoFijoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseMantenimientoActivoFijos(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarMantenimientoActivoFijo(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<MantenimientoActivoFijo> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<MantenimientoActivoFijo> entities = new  ArrayList<MantenimientoActivoFijo>();
		MantenimientoActivoFijo entity = new MantenimientoActivoFijo();		  
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
	
	public  List<MantenimientoActivoFijo> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<MantenimientoActivoFijo> entities = new  ArrayList<MantenimientoActivoFijo>();
		MantenimientoActivoFijo entity = new MantenimientoActivoFijo();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new MantenimientoActivoFijo();
				
				if(conMapGenerico) {
					entity.inicializarMapMantenimientoActivoFijo();
					//entity.setMapMantenimientoActivoFijo(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapMantenimientoActivoFijoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapMantenimientoActivoFijo().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,MantenimientoActivoFijoDataAccess.ISWITHSCHEMA);         		
					entity=MantenimientoActivoFijoDataAccess.getEntityMantenimientoActivoFijo("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setMantenimientoActivoFijoOriginal( new MantenimientoActivoFijo());
					////entity.setMantenimientoActivoFijoOriginal(super.getEntity("",entity.getMantenimientoActivoFijoOriginal(),resultSet,MantenimientoActivoFijoDataAccess.ISWITHSCHEMA));         		
					////entity.setMantenimientoActivoFijoOriginal(this.getEntityMantenimientoActivoFijo("",entity.getMantenimientoActivoFijoOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseMantenimientoActivoFijos(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarMantenimientoActivoFijo(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public MantenimientoActivoFijo getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		MantenimientoActivoFijo entity = new MantenimientoActivoFijo();		  
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
	
	public  MantenimientoActivoFijo getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		MantenimientoActivoFijo entity = new MantenimientoActivoFijo();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new MantenimientoActivoFijo();
				
				if(conMapGenerico) {
					entity.inicializarMapMantenimientoActivoFijo();
					//entity.setMapMantenimientoActivoFijo(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapMantenimientoActivoFijoValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapMantenimientoActivoFijo().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,MantenimientoActivoFijoDataAccess.ISWITHSCHEMA);         		
					entity=MantenimientoActivoFijoDataAccess.getEntityMantenimientoActivoFijo("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setMantenimientoActivoFijoOriginal( new MantenimientoActivoFijo());
					////entity.setMantenimientoActivoFijoOriginal(super.getEntity("",entity.getMantenimientoActivoFijoOriginal(),resultSet,MantenimientoActivoFijoDataAccess.ISWITHSCHEMA));         		
					////entity.setMantenimientoActivoFijoOriginal(this.getEntityMantenimientoActivoFijo("",entity.getMantenimientoActivoFijoOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseMantenimientoActivoFijo(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarMantenimientoActivoFijo(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static MantenimientoActivoFijo getEntityMantenimientoActivoFijo(String strPrefijo,MantenimientoActivoFijo entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = MantenimientoActivoFijo.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = MantenimientoActivoFijo.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					MantenimientoActivoFijoDataAccess.setFieldReflectionMantenimientoActivoFijo(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasMantenimientoActivoFijo=MantenimientoActivoFijoConstantesFunciones.getTodosTiposColumnasMantenimientoActivoFijo();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasMantenimientoActivoFijo) {
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
							field = MantenimientoActivoFijo.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = MantenimientoActivoFijo.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						MantenimientoActivoFijoDataAccess.setFieldReflectionMantenimientoActivoFijo(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionMantenimientoActivoFijo(Field field,String strPrefijo,String sColumn,MantenimientoActivoFijo entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case MantenimientoActivoFijoConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case MantenimientoActivoFijoConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case MantenimientoActivoFijoConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case MantenimientoActivoFijoConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case MantenimientoActivoFijoConstantesFunciones.IDDETALLEACTIVOFIJO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case MantenimientoActivoFijoConstantesFunciones.IDTIPOMOVIMIENTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case MantenimientoActivoFijoConstantesFunciones.NUMERODOCUMENTO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case MantenimientoActivoFijoConstantesFunciones.CAUSA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case MantenimientoActivoFijoConstantesFunciones.REFERENCIA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case MantenimientoActivoFijoConstantesFunciones.TALLER:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case MantenimientoActivoFijoConstantesFunciones.TELEFONO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case MantenimientoActivoFijoConstantesFunciones.FECHAINICIO:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case MantenimientoActivoFijoConstantesFunciones.FECHAENTREGA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case MantenimientoActivoFijoConstantesFunciones.COSTO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case MantenimientoActivoFijoConstantesFunciones.RESPONSABLE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case MantenimientoActivoFijoConstantesFunciones.OBSERVACION:
					field.set(entity,resultSet.getString(sCampo));
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<MantenimientoActivoFijo>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<MantenimientoActivoFijo> entities = new  ArrayList<MantenimientoActivoFijo>();
		MantenimientoActivoFijo entity = new MantenimientoActivoFijo();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=MantenimientoActivoFijoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=MantenimientoActivoFijoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,MantenimientoActivoFijoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new MantenimientoActivoFijo();
					entity=super.getEntity("",entity,resultSet,MantenimientoActivoFijoDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityMantenimientoActivoFijo("",entity,resultSet);
					
					//entity.setMantenimientoActivoFijoOriginal( new MantenimientoActivoFijo());
					//entity.setMantenimientoActivoFijoOriginal(super.getEntity("",entity.getMantenimientoActivoFijoOriginal(),resultSet,MantenimientoActivoFijoDataAccess.ISWITHSCHEMA));         		
					//entity.setMantenimientoActivoFijoOriginal(this.getEntityMantenimientoActivoFijo("",entity.getMantenimientoActivoFijoOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseMantenimientoActivoFijos(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarMantenimientoActivoFijo(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<MantenimientoActivoFijo>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<MantenimientoActivoFijo> entities = new  ArrayList<MantenimientoActivoFijo>();
		MantenimientoActivoFijo entity = new MantenimientoActivoFijo();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=MantenimientoActivoFijoDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=MantenimientoActivoFijoDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,MantenimientoActivoFijoDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<MantenimientoActivoFijo> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<MantenimientoActivoFijo> entities = new  ArrayList<MantenimientoActivoFijo>();
		MantenimientoActivoFijo entity = new MantenimientoActivoFijo();		  
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
	
	public  List<MantenimientoActivoFijo> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<MantenimientoActivoFijo> entities = new  ArrayList<MantenimientoActivoFijo>();
		MantenimientoActivoFijo entity = new MantenimientoActivoFijo();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new MantenimientoActivoFijo();
      	    	entity=super.getEntity("",entity,resultSet,MantenimientoActivoFijoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityMantenimientoActivoFijo("",entity,resultSet);
      	    	
				//entity.setMantenimientoActivoFijoOriginal( new MantenimientoActivoFijo());
      	    	//entity.setMantenimientoActivoFijoOriginal(super.getEntity("",entity.getMantenimientoActivoFijoOriginal(),resultSet,MantenimientoActivoFijoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setMantenimientoActivoFijoOriginal(this.getEntityMantenimientoActivoFijo("",entity.getMantenimientoActivoFijoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseMantenimientoActivoFijos(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarMantenimientoActivoFijo(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<MantenimientoActivoFijo> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<MantenimientoActivoFijo> entities = new  ArrayList<MantenimientoActivoFijo>();
		MantenimientoActivoFijo entity = new MantenimientoActivoFijo();		  
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
	
	public  List<MantenimientoActivoFijo> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<MantenimientoActivoFijo> entities = new  ArrayList<MantenimientoActivoFijo>();
		MantenimientoActivoFijo entity = new MantenimientoActivoFijo();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new MantenimientoActivoFijo();
      	    	entity=super.getEntity("",entity,resultSet,MantenimientoActivoFijoDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityMantenimientoActivoFijo("",entity,resultSet);
      	    	
				//entity.setMantenimientoActivoFijoOriginal( new MantenimientoActivoFijo());
      	    	//entity.setMantenimientoActivoFijoOriginal(super.getEntity("",entity.getMantenimientoActivoFijoOriginal(),resultSet,MantenimientoActivoFijoDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setMantenimientoActivoFijoOriginal(this.getEntityMantenimientoActivoFijo("",entity.getMantenimientoActivoFijoOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseMantenimientoActivoFijos(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public MantenimientoActivoFijo getEntityMantenimientoActivoFijo(String strPrefijo,MantenimientoActivoFijo entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+MantenimientoActivoFijoConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+MantenimientoActivoFijoConstantesFunciones.IDSUCURSAL));
				entity.setid_detalle_activo_fijo(resultSet.getLong(strPrefijo+MantenimientoActivoFijoConstantesFunciones.IDDETALLEACTIVOFIJO));
				entity.setid_tipo_movimiento(resultSet.getLong(strPrefijo+MantenimientoActivoFijoConstantesFunciones.IDTIPOMOVIMIENTO));
				entity.setnumero_documento(resultSet.getString(strPrefijo+MantenimientoActivoFijoConstantesFunciones.NUMERODOCUMENTO));
				entity.setcausa(resultSet.getString(strPrefijo+MantenimientoActivoFijoConstantesFunciones.CAUSA));
				entity.setreferencia(resultSet.getString(strPrefijo+MantenimientoActivoFijoConstantesFunciones.REFERENCIA));
				entity.settaller(resultSet.getString(strPrefijo+MantenimientoActivoFijoConstantesFunciones.TALLER));
				entity.settelefono(resultSet.getString(strPrefijo+MantenimientoActivoFijoConstantesFunciones.TELEFONO));
				entity.setfecha_inicio(new Date(resultSet.getDate(strPrefijo+MantenimientoActivoFijoConstantesFunciones.FECHAINICIO).getTime()));
				entity.setfecha_entrega(new Date(resultSet.getDate(strPrefijo+MantenimientoActivoFijoConstantesFunciones.FECHAENTREGA).getTime()));
				entity.setcosto(resultSet.getDouble(strPrefijo+MantenimientoActivoFijoConstantesFunciones.COSTO));
				entity.setresponsable(resultSet.getString(strPrefijo+MantenimientoActivoFijoConstantesFunciones.RESPONSABLE));
				entity.setobservacion(resultSet.getString(strPrefijo+MantenimientoActivoFijoConstantesFunciones.OBSERVACION));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowMantenimientoActivoFijo(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(MantenimientoActivoFijo entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=MantenimientoActivoFijoDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=MantenimientoActivoFijoDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=MantenimientoActivoFijoDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=MantenimientoActivoFijoDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(MantenimientoActivoFijoConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,MantenimientoActivoFijoDataAccess.TABLENAME,MantenimientoActivoFijoDataAccess.ISWITHSTOREPROCEDURES);
			
			MantenimientoActivoFijoDataAccess.setMantenimientoActivoFijoOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,MantenimientoActivoFijo relmantenimientoactivofijo)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relmantenimientoactivofijo.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,MantenimientoActivoFijo relmantenimientoactivofijo)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,relmantenimientoactivofijo.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public DetalleActivoFijo getDetalleActivoFijo(Connexion connexion,MantenimientoActivoFijo relmantenimientoactivofijo)throws SQLException,Exception {

		DetalleActivoFijo detalleactivofijo= new DetalleActivoFijo();

		try {
			DetalleActivoFijoDataAccess detalleactivofijoDataAccess=new DetalleActivoFijoDataAccess();

			detalleactivofijoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			detalleactivofijoDataAccess.setConnexionType(this.connexionType);
			detalleactivofijoDataAccess.setParameterDbType(this.parameterDbType);

			detalleactivofijo=detalleactivofijoDataAccess.getEntity(connexion,relmantenimientoactivofijo.getid_detalle_activo_fijo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return detalleactivofijo;

	}

	public TipoMovimiento getTipoMovimiento(Connexion connexion,MantenimientoActivoFijo relmantenimientoactivofijo)throws SQLException,Exception {

		TipoMovimiento tipomovimiento= new TipoMovimiento();

		try {
			TipoMovimientoDataAccess tipomovimientoDataAccess=new TipoMovimientoDataAccess();

			tipomovimientoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipomovimientoDataAccess.setConnexionType(this.connexionType);
			tipomovimientoDataAccess.setParameterDbType(this.parameterDbType);

			tipomovimiento=tipomovimientoDataAccess.getEntity(connexion,relmantenimientoactivofijo.getid_tipo_movimiento());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipomovimiento;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,MantenimientoActivoFijo mantenimientoactivofijo) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!mantenimientoactivofijo.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(mantenimientoactivofijo.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(mantenimientoactivofijo.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_detalle_activo_fijo=new ParameterValue<Long>();
					parameterMaintenanceValueid_detalle_activo_fijo.setValue(mantenimientoactivofijo.getid_detalle_activo_fijo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_detalle_activo_fijo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_movimiento=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_movimiento.setValue(mantenimientoactivofijo.getid_tipo_movimiento());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_movimiento);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero_documento=new ParameterValue<String>();
					parameterMaintenanceValuenumero_documento.setValue(mantenimientoactivofijo.getnumero_documento());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_documento);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecausa=new ParameterValue<String>();
					parameterMaintenanceValuecausa.setValue(mantenimientoactivofijo.getcausa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecausa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuereferencia=new ParameterValue<String>();
					parameterMaintenanceValuereferencia.setValue(mantenimientoactivofijo.getreferencia());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuereferencia);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuetaller=new ParameterValue<String>();
					parameterMaintenanceValuetaller.setValue(mantenimientoactivofijo.gettaller());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetaller);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuetelefono=new ParameterValue<String>();
					parameterMaintenanceValuetelefono.setValue(mantenimientoactivofijo.gettelefono());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetelefono);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_inicio=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_inicio.setValue(mantenimientoactivofijo.getfecha_inicio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_inicio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_entrega=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_entrega.setValue(mantenimientoactivofijo.getfecha_entrega());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_entrega);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuecosto=new ParameterValue<Double>();
					parameterMaintenanceValuecosto.setValue(mantenimientoactivofijo.getcosto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecosto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueresponsable=new ParameterValue<String>();
					parameterMaintenanceValueresponsable.setValue(mantenimientoactivofijo.getresponsable());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueresponsable);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueobservacion=new ParameterValue<String>();
					parameterMaintenanceValueobservacion.setValue(mantenimientoactivofijo.getobservacion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueobservacion);
					parametersTemp.add(parameterMaintenance);
					
						if(!mantenimientoactivofijo.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(mantenimientoactivofijo.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(mantenimientoactivofijo.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(mantenimientoactivofijo.getId());
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
	
	public void setIsNewIsChangedFalseMantenimientoActivoFijo(MantenimientoActivoFijo mantenimientoactivofijo)throws Exception  {		
		mantenimientoactivofijo.setIsNew(false);
		mantenimientoactivofijo.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseMantenimientoActivoFijos(List<MantenimientoActivoFijo> mantenimientoactivofijos)throws Exception  {				
		for(MantenimientoActivoFijo mantenimientoactivofijo:mantenimientoactivofijos) {
			mantenimientoactivofijo.setIsNew(false);
			mantenimientoactivofijo.setIsChanged(false);
		}
	}
	
	public void generarExportarMantenimientoActivoFijo(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
