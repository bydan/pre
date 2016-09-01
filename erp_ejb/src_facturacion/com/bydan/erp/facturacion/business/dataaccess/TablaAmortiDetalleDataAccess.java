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
package com.bydan.erp.facturacion.business.dataaccess;

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

import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.facturacion.util.*;//TablaAmortiDetalleConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;




@SuppressWarnings("unused")
final public class TablaAmortiDetalleDataAccess extends  TablaAmortiDetalleDataAccessAdditional{ //TablaAmortiDetalleDataAccessAdditional,DataAccessHelper<TablaAmortiDetalle>
	//static Logger logger = Logger.getLogger(TablaAmortiDetalleDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="tabla_amorti_detalle";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+TablaAmortiDetalleConstantesFunciones.SCHEMA+"."+TablaAmortiDetalleConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,id_ejercicio,id_periodo,id_tasa,id_factura,id_tipo_intervalo,fecha_emision,fecha_vencimiento,fecha_inicial,fecha_final,valor,interes,capital,numero_cuotas,id_anio,id_mes)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+TablaAmortiDetalleConstantesFunciones.SCHEMA+"."+TablaAmortiDetalleConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_ejercicio=?,id_periodo=?,id_tasa=?,id_factura=?,id_tipo_intervalo=?,fecha_emision=?,fecha_vencimiento=?,fecha_inicial=?,fecha_final=?,valor=?,interes=?,capital=?,numero_cuotas=?,id_anio=?,id_mes=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+TablaAmortiDetalleConstantesFunciones.SCHEMA+"."+TablaAmortiDetalleConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select tablaamortidetalle from "+TablaAmortiDetalleConstantesFunciones.SPERSISTENCENAME+" tablaamortidetalle";
	public static String QUERYSELECTNATIVE="select "+TablaAmortiDetalleConstantesFunciones.SCHEMA+"."+TablaAmortiDetalleConstantesFunciones.TABLENAME+".id,"+TablaAmortiDetalleConstantesFunciones.SCHEMA+"."+TablaAmortiDetalleConstantesFunciones.TABLENAME+".version_row,"+TablaAmortiDetalleConstantesFunciones.SCHEMA+"."+TablaAmortiDetalleConstantesFunciones.TABLENAME+".id_empresa,"+TablaAmortiDetalleConstantesFunciones.SCHEMA+"."+TablaAmortiDetalleConstantesFunciones.TABLENAME+".id_sucursal,"+TablaAmortiDetalleConstantesFunciones.SCHEMA+"."+TablaAmortiDetalleConstantesFunciones.TABLENAME+".id_ejercicio,"+TablaAmortiDetalleConstantesFunciones.SCHEMA+"."+TablaAmortiDetalleConstantesFunciones.TABLENAME+".id_periodo,"+TablaAmortiDetalleConstantesFunciones.SCHEMA+"."+TablaAmortiDetalleConstantesFunciones.TABLENAME+".id_tasa,"+TablaAmortiDetalleConstantesFunciones.SCHEMA+"."+TablaAmortiDetalleConstantesFunciones.TABLENAME+".id_factura,"+TablaAmortiDetalleConstantesFunciones.SCHEMA+"."+TablaAmortiDetalleConstantesFunciones.TABLENAME+".id_tipo_intervalo,"+TablaAmortiDetalleConstantesFunciones.SCHEMA+"."+TablaAmortiDetalleConstantesFunciones.TABLENAME+".fecha_emision,"+TablaAmortiDetalleConstantesFunciones.SCHEMA+"."+TablaAmortiDetalleConstantesFunciones.TABLENAME+".fecha_vencimiento,"+TablaAmortiDetalleConstantesFunciones.SCHEMA+"."+TablaAmortiDetalleConstantesFunciones.TABLENAME+".fecha_inicial,"+TablaAmortiDetalleConstantesFunciones.SCHEMA+"."+TablaAmortiDetalleConstantesFunciones.TABLENAME+".fecha_final,"+TablaAmortiDetalleConstantesFunciones.SCHEMA+"."+TablaAmortiDetalleConstantesFunciones.TABLENAME+".valor,"+TablaAmortiDetalleConstantesFunciones.SCHEMA+"."+TablaAmortiDetalleConstantesFunciones.TABLENAME+".interes,"+TablaAmortiDetalleConstantesFunciones.SCHEMA+"."+TablaAmortiDetalleConstantesFunciones.TABLENAME+".capital,"+TablaAmortiDetalleConstantesFunciones.SCHEMA+"."+TablaAmortiDetalleConstantesFunciones.TABLENAME+".numero_cuotas,"+TablaAmortiDetalleConstantesFunciones.SCHEMA+"."+TablaAmortiDetalleConstantesFunciones.TABLENAME+".id_anio,"+TablaAmortiDetalleConstantesFunciones.SCHEMA+"."+TablaAmortiDetalleConstantesFunciones.TABLENAME+".id_mes from "+TablaAmortiDetalleConstantesFunciones.SCHEMA+"."+TablaAmortiDetalleConstantesFunciones.TABLENAME;//+" as "+TablaAmortiDetalleConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+TablaAmortiDetalleConstantesFunciones.SCHEMA+"."+TablaAmortiDetalleConstantesFunciones.TABLENAME+".id,"+TablaAmortiDetalleConstantesFunciones.SCHEMA+"."+TablaAmortiDetalleConstantesFunciones.TABLENAME+".version_row from "+TablaAmortiDetalleConstantesFunciones.SCHEMA+"."+TablaAmortiDetalleConstantesFunciones.TABLENAME;//+" as "+TablaAmortiDetalleConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+TablaAmortiDetalleConstantesFunciones.SCHEMA+"."+TablaAmortiDetalleConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_ejercicio=?,id_periodo=?,id_tasa=?,id_factura=?,id_tipo_intervalo=?,fecha_emision=?,fecha_vencimiento=?,fecha_inicial=?,fecha_final=?,valor=?,interes=?,capital=?,numero_cuotas=?,id_anio=?,id_mes=?";
	
	public static String STOREPROCEDUREINSERT="call SP_TABLAAMORTIDETALLE_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_TABLAAMORTIDETALLE_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_TABLAAMORTIDETALLE_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_TABLAAMORTIDETALLE_SELECT(?,?)";
	
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
	
	
	protected TablaAmortiDetalleDataAccessAdditional tablaamortidetalleDataAccessAdditional=null;
	
	public TablaAmortiDetalleDataAccessAdditional getTablaAmortiDetalleDataAccessAdditional() {
		return this.tablaamortidetalleDataAccessAdditional;
	}
	
	public void setTablaAmortiDetalleDataAccessAdditional(TablaAmortiDetalleDataAccessAdditional tablaamortidetalleDataAccessAdditional) {
		try {
			this.tablaamortidetalleDataAccessAdditional=tablaamortidetalleDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public TablaAmortiDetalleDataAccess() {
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
		TablaAmortiDetalleDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		TablaAmortiDetalleDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		TablaAmortiDetalleDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setTablaAmortiDetalleOriginal(TablaAmortiDetalle tablaamortidetalle)throws Exception  {
		tablaamortidetalle.setTablaAmortiDetalleOriginal((TablaAmortiDetalle)tablaamortidetalle.clone());		
	}
	
	public void setTablaAmortiDetallesOriginal(List<TablaAmortiDetalle> tablaamortidetalles)throws Exception  {
		
		for(TablaAmortiDetalle tablaamortidetalle:tablaamortidetalles){
			tablaamortidetalle.setTablaAmortiDetalleOriginal((TablaAmortiDetalle)tablaamortidetalle.clone());
		}
	}
	
	public static void setTablaAmortiDetalleOriginalStatic(TablaAmortiDetalle tablaamortidetalle)throws Exception  {
		tablaamortidetalle.setTablaAmortiDetalleOriginal((TablaAmortiDetalle)tablaamortidetalle.clone());		
	}
	
	public static void setTablaAmortiDetallesOriginalStatic(List<TablaAmortiDetalle> tablaamortidetalles)throws Exception  {
		
		for(TablaAmortiDetalle tablaamortidetalle:tablaamortidetalles){
			tablaamortidetalle.setTablaAmortiDetalleOriginal((TablaAmortiDetalle)tablaamortidetalle.clone());
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
	
	public  TablaAmortiDetalle getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		TablaAmortiDetalle entity = new TablaAmortiDetalle();		
		
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
	
	public  TablaAmortiDetalle getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		TablaAmortiDetalle entity = new TablaAmortiDetalle();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TablaAmortiDetalleDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TablaAmortiDetalleDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Facturacion.TablaAmortiDetalle.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setTablaAmortiDetalleOriginal(new TablaAmortiDetalle());
      	    	entity=super.getEntity("",entity,resultSet,TablaAmortiDetalleDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTablaAmortiDetalle("",entity,resultSet); 
				
				//entity.setTablaAmortiDetalleOriginal(super.getEntity("",entity.getTablaAmortiDetalleOriginal(),resultSet,TablaAmortiDetalleDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTablaAmortiDetalleOriginal(this.getEntityTablaAmortiDetalle("",entity.getTablaAmortiDetalleOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseTablaAmortiDetalle(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  TablaAmortiDetalle getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TablaAmortiDetalle entity = new TablaAmortiDetalle();
				
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
	
	public  TablaAmortiDetalle getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		TablaAmortiDetalle entity = new TablaAmortiDetalle();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=TablaAmortiDetalleDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TablaAmortiDetalleDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TablaAmortiDetalleDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Facturacion.TablaAmortiDetalle.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setTablaAmortiDetalleOriginal(new TablaAmortiDetalle());
      	    	entity=super.getEntity("",entity,resultSet,TablaAmortiDetalleDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityTablaAmortiDetalle("",entity,resultSet);    
				
				//entity.setTablaAmortiDetalleOriginal(super.getEntity("",entity.getTablaAmortiDetalleOriginal(),resultSet,TablaAmortiDetalleDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTablaAmortiDetalleOriginal(this.getEntityTablaAmortiDetalle("",entity.getTablaAmortiDetalleOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseTablaAmortiDetalle(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //TablaAmortiDetalle
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		TablaAmortiDetalle entity = new TablaAmortiDetalle();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TablaAmortiDetalleDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TablaAmortiDetalleDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TablaAmortiDetalleDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Facturacion.TablaAmortiDetalle.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseTablaAmortiDetalle(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<TablaAmortiDetalle> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TablaAmortiDetalle> entities = new  ArrayList<TablaAmortiDetalle>();
		TablaAmortiDetalle entity = new TablaAmortiDetalle();		  
		
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
	
	public  List<TablaAmortiDetalle> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<TablaAmortiDetalle> entities = new  ArrayList<TablaAmortiDetalle>();
		TablaAmortiDetalle entity = new TablaAmortiDetalle();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=TablaAmortiDetalleDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=TablaAmortiDetalleDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TablaAmortiDetalleDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TablaAmortiDetalle();
      	    	entity=super.getEntity("",entity,resultSet,TablaAmortiDetalleDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTablaAmortiDetalle("",entity,resultSet);
      	    	
				//entity.setTablaAmortiDetalleOriginal( new TablaAmortiDetalle());
      	    	//entity.setTablaAmortiDetalleOriginal(super.getEntity("",entity.getTablaAmortiDetalleOriginal(),resultSet,TablaAmortiDetalleDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTablaAmortiDetalleOriginal(this.getEntityTablaAmortiDetalle("",entity.getTablaAmortiDetalleOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTablaAmortiDetalles(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTablaAmortiDetalle(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TablaAmortiDetalle> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TablaAmortiDetalle> entities = new  ArrayList<TablaAmortiDetalle>();
		TablaAmortiDetalle entity = new TablaAmortiDetalle();		  
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
	
	public  List<TablaAmortiDetalle> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<TablaAmortiDetalle> entities = new  ArrayList<TablaAmortiDetalle>();
		TablaAmortiDetalle entity = new TablaAmortiDetalle();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TablaAmortiDetalle();
				
				if(conMapGenerico) {
					entity.inicializarMapTablaAmortiDetalle();
					//entity.setMapTablaAmortiDetalle(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapTablaAmortiDetalleValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTablaAmortiDetalle().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TablaAmortiDetalleDataAccess.ISWITHSCHEMA);         		
					entity=TablaAmortiDetalleDataAccess.getEntityTablaAmortiDetalle("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTablaAmortiDetalleOriginal( new TablaAmortiDetalle());
					////entity.setTablaAmortiDetalleOriginal(super.getEntity("",entity.getTablaAmortiDetalleOriginal(),resultSet,TablaAmortiDetalleDataAccess.ISWITHSCHEMA));         		
					////entity.setTablaAmortiDetalleOriginal(this.getEntityTablaAmortiDetalle("",entity.getTablaAmortiDetalleOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTablaAmortiDetalles(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTablaAmortiDetalle(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public TablaAmortiDetalle getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TablaAmortiDetalle entity = new TablaAmortiDetalle();		  
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
	
	public  TablaAmortiDetalle getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		TablaAmortiDetalle entity = new TablaAmortiDetalle();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TablaAmortiDetalle();
				
				if(conMapGenerico) {
					entity.inicializarMapTablaAmortiDetalle();
					//entity.setMapTablaAmortiDetalle(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapTablaAmortiDetalleValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapTablaAmortiDetalle().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,TablaAmortiDetalleDataAccess.ISWITHSCHEMA);         		
					entity=TablaAmortiDetalleDataAccess.getEntityTablaAmortiDetalle("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setTablaAmortiDetalleOriginal( new TablaAmortiDetalle());
					////entity.setTablaAmortiDetalleOriginal(super.getEntity("",entity.getTablaAmortiDetalleOriginal(),resultSet,TablaAmortiDetalleDataAccess.ISWITHSCHEMA));         		
					////entity.setTablaAmortiDetalleOriginal(this.getEntityTablaAmortiDetalle("",entity.getTablaAmortiDetalleOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseTablaAmortiDetalle(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTablaAmortiDetalle(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static TablaAmortiDetalle getEntityTablaAmortiDetalle(String strPrefijo,TablaAmortiDetalle entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = TablaAmortiDetalle.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = TablaAmortiDetalle.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					TablaAmortiDetalleDataAccess.setFieldReflectionTablaAmortiDetalle(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasTablaAmortiDetalle=TablaAmortiDetalleConstantesFunciones.getTodosTiposColumnasTablaAmortiDetalle();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasTablaAmortiDetalle) {
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
							field = TablaAmortiDetalle.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = TablaAmortiDetalle.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						TablaAmortiDetalleDataAccess.setFieldReflectionTablaAmortiDetalle(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionTablaAmortiDetalle(Field field,String strPrefijo,String sColumn,TablaAmortiDetalle entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case TablaAmortiDetalleConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TablaAmortiDetalleConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case TablaAmortiDetalleConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TablaAmortiDetalleConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TablaAmortiDetalleConstantesFunciones.IDEJERCICIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TablaAmortiDetalleConstantesFunciones.IDPERIODO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TablaAmortiDetalleConstantesFunciones.IDTASA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TablaAmortiDetalleConstantesFunciones.IDFACTURA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TablaAmortiDetalleConstantesFunciones.IDTIPOINTERVALO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TablaAmortiDetalleConstantesFunciones.FECHAEMISION:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case TablaAmortiDetalleConstantesFunciones.FECHAVENCIMIENTO:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case TablaAmortiDetalleConstantesFunciones.FECHAINICIAL:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case TablaAmortiDetalleConstantesFunciones.FECHAFINAL:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case TablaAmortiDetalleConstantesFunciones.VALOR:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case TablaAmortiDetalleConstantesFunciones.INTERES:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case TablaAmortiDetalleConstantesFunciones.CAPITAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case TablaAmortiDetalleConstantesFunciones.NUMEROCUOTA:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case TablaAmortiDetalleConstantesFunciones.IDANIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case TablaAmortiDetalleConstantesFunciones.IDMES:
					field.set(entity,resultSet.getLong(sCampo));
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TablaAmortiDetalle>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<TablaAmortiDetalle> entities = new  ArrayList<TablaAmortiDetalle>();
		TablaAmortiDetalle entity = new TablaAmortiDetalle();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TablaAmortiDetalleDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TablaAmortiDetalleDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TablaAmortiDetalleDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new TablaAmortiDetalle();
					entity=super.getEntity("",entity,resultSet,TablaAmortiDetalleDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityTablaAmortiDetalle("",entity,resultSet);
					
					//entity.setTablaAmortiDetalleOriginal( new TablaAmortiDetalle());
					//entity.setTablaAmortiDetalleOriginal(super.getEntity("",entity.getTablaAmortiDetalleOriginal(),resultSet,TablaAmortiDetalleDataAccess.ISWITHSCHEMA));         		
					//entity.setTablaAmortiDetalleOriginal(this.getEntityTablaAmortiDetalle("",entity.getTablaAmortiDetalleOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseTablaAmortiDetalles(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTablaAmortiDetalle(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<TablaAmortiDetalle>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<TablaAmortiDetalle> entities = new  ArrayList<TablaAmortiDetalle>();
		TablaAmortiDetalle entity = new TablaAmortiDetalle();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=TablaAmortiDetalleDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=TablaAmortiDetalleDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,TablaAmortiDetalleDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<TablaAmortiDetalle> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TablaAmortiDetalle> entities = new  ArrayList<TablaAmortiDetalle>();
		TablaAmortiDetalle entity = new TablaAmortiDetalle();		  
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
	
	public  List<TablaAmortiDetalle> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TablaAmortiDetalle> entities = new  ArrayList<TablaAmortiDetalle>();
		TablaAmortiDetalle entity = new TablaAmortiDetalle();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TablaAmortiDetalle();
      	    	entity=super.getEntity("",entity,resultSet,TablaAmortiDetalleDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTablaAmortiDetalle("",entity,resultSet);
      	    	
				//entity.setTablaAmortiDetalleOriginal( new TablaAmortiDetalle());
      	    	//entity.setTablaAmortiDetalleOriginal(super.getEntity("",entity.getTablaAmortiDetalleOriginal(),resultSet,TablaAmortiDetalleDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTablaAmortiDetalleOriginal(this.getEntityTablaAmortiDetalle("",entity.getTablaAmortiDetalleOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseTablaAmortiDetalles(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarTablaAmortiDetalle(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<TablaAmortiDetalle> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TablaAmortiDetalle> entities = new  ArrayList<TablaAmortiDetalle>();
		TablaAmortiDetalle entity = new TablaAmortiDetalle();		  
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
	
	public  List<TablaAmortiDetalle> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<TablaAmortiDetalle> entities = new  ArrayList<TablaAmortiDetalle>();
		TablaAmortiDetalle entity = new TablaAmortiDetalle();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new TablaAmortiDetalle();
      	    	entity=super.getEntity("",entity,resultSet,TablaAmortiDetalleDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityTablaAmortiDetalle("",entity,resultSet);
      	    	
				//entity.setTablaAmortiDetalleOriginal( new TablaAmortiDetalle());
      	    	//entity.setTablaAmortiDetalleOriginal(super.getEntity("",entity.getTablaAmortiDetalleOriginal(),resultSet,TablaAmortiDetalleDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setTablaAmortiDetalleOriginal(this.getEntityTablaAmortiDetalle("",entity.getTablaAmortiDetalleOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseTablaAmortiDetalles(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public TablaAmortiDetalle getEntityTablaAmortiDetalle(String strPrefijo,TablaAmortiDetalle entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+TablaAmortiDetalleConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+TablaAmortiDetalleConstantesFunciones.IDSUCURSAL));
				entity.setid_ejercicio(resultSet.getLong(strPrefijo+TablaAmortiDetalleConstantesFunciones.IDEJERCICIO));
				entity.setid_periodo(resultSet.getLong(strPrefijo+TablaAmortiDetalleConstantesFunciones.IDPERIODO));
				entity.setid_tasa(resultSet.getLong(strPrefijo+TablaAmortiDetalleConstantesFunciones.IDTASA));
				entity.setid_factura(resultSet.getLong(strPrefijo+TablaAmortiDetalleConstantesFunciones.IDFACTURA));
				entity.setid_tipo_intervalo(resultSet.getLong(strPrefijo+TablaAmortiDetalleConstantesFunciones.IDTIPOINTERVALO));
				entity.setfecha_emision(new Date(resultSet.getDate(strPrefijo+TablaAmortiDetalleConstantesFunciones.FECHAEMISION).getTime()));
				entity.setfecha_vencimiento(new Date(resultSet.getDate(strPrefijo+TablaAmortiDetalleConstantesFunciones.FECHAVENCIMIENTO).getTime()));
				entity.setfecha_inicial(new Date(resultSet.getDate(strPrefijo+TablaAmortiDetalleConstantesFunciones.FECHAINICIAL).getTime()));
				entity.setfecha_final(new Date(resultSet.getDate(strPrefijo+TablaAmortiDetalleConstantesFunciones.FECHAFINAL).getTime()));
				entity.setvalor(resultSet.getDouble(strPrefijo+TablaAmortiDetalleConstantesFunciones.VALOR));
				entity.setinteres(resultSet.getDouble(strPrefijo+TablaAmortiDetalleConstantesFunciones.INTERES));
				entity.setcapital(resultSet.getDouble(strPrefijo+TablaAmortiDetalleConstantesFunciones.CAPITAL));
				entity.setnumero_cuotas(resultSet.getInt(strPrefijo+TablaAmortiDetalleConstantesFunciones.NUMEROCUOTA));
				entity.setid_anio(resultSet.getLong(strPrefijo+TablaAmortiDetalleConstantesFunciones.IDANIO));if(resultSet.wasNull()) {entity.setid_anio(null); }
				entity.setid_mes(resultSet.getLong(strPrefijo+TablaAmortiDetalleConstantesFunciones.IDMES));if(resultSet.wasNull()) {entity.setid_mes(null); }
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowTablaAmortiDetalle(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(TablaAmortiDetalle entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=TablaAmortiDetalleDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=TablaAmortiDetalleDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=TablaAmortiDetalleDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=TablaAmortiDetalleDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(TablaAmortiDetalleConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,TablaAmortiDetalleDataAccess.TABLENAME,TablaAmortiDetalleDataAccess.ISWITHSTOREPROCEDURES);
			
			TablaAmortiDetalleDataAccess.setTablaAmortiDetalleOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,TablaAmortiDetalle reltablaamortidetalle)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,reltablaamortidetalle.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,TablaAmortiDetalle reltablaamortidetalle)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,reltablaamortidetalle.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Ejercicio getEjercicio(Connexion connexion,TablaAmortiDetalle reltablaamortidetalle)throws SQLException,Exception {

		Ejercicio ejercicio= new Ejercicio();

		try {
			EjercicioDataAccess ejercicioDataAccess=new EjercicioDataAccess();

			ejercicioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ejercicioDataAccess.setConnexionType(this.connexionType);
			ejercicioDataAccess.setParameterDbType(this.parameterDbType);

			ejercicio=ejercicioDataAccess.getEntity(connexion,reltablaamortidetalle.getid_ejercicio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ejercicio;

	}

	public Periodo getPeriodo(Connexion connexion,TablaAmortiDetalle reltablaamortidetalle)throws SQLException,Exception {

		Periodo periodo= new Periodo();

		try {
			PeriodoDataAccess periodoDataAccess=new PeriodoDataAccess();

			periodoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			periodoDataAccess.setConnexionType(this.connexionType);
			periodoDataAccess.setParameterDbType(this.parameterDbType);

			periodo=periodoDataAccess.getEntity(connexion,reltablaamortidetalle.getid_periodo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return periodo;

	}

	public Tasa getTasa(Connexion connexion,TablaAmortiDetalle reltablaamortidetalle)throws SQLException,Exception {

		Tasa tasa= new Tasa();

		try {
			TasaDataAccess tasaDataAccess=new TasaDataAccess();

			tasaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tasaDataAccess.setConnexionType(this.connexionType);
			tasaDataAccess.setParameterDbType(this.parameterDbType);

			tasa=tasaDataAccess.getEntity(connexion,reltablaamortidetalle.getid_tasa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tasa;

	}

	public Factura getFactura(Connexion connexion,TablaAmortiDetalle reltablaamortidetalle)throws SQLException,Exception {

		Factura factura= new Factura();

		try {
			FacturaDataAccess facturaDataAccess=new FacturaDataAccess();

			facturaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			facturaDataAccess.setConnexionType(this.connexionType);
			facturaDataAccess.setParameterDbType(this.parameterDbType);

			factura=facturaDataAccess.getEntity(connexion,reltablaamortidetalle.getid_factura());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return factura;

	}

	public TipoIntervalo getTipoIntervalo(Connexion connexion,TablaAmortiDetalle reltablaamortidetalle)throws SQLException,Exception {

		TipoIntervalo tipointervalo= new TipoIntervalo();

		try {
			TipoIntervaloDataAccess tipointervaloDataAccess=new TipoIntervaloDataAccess();

			tipointervaloDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipointervaloDataAccess.setConnexionType(this.connexionType);
			tipointervaloDataAccess.setParameterDbType(this.parameterDbType);

			tipointervalo=tipointervaloDataAccess.getEntity(connexion,reltablaamortidetalle.getid_tipo_intervalo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipointervalo;

	}

	public Anio getAnio(Connexion connexion,TablaAmortiDetalle reltablaamortidetalle)throws SQLException,Exception {

		Anio anio= new Anio();

		try {
			AnioDataAccess anioDataAccess=new AnioDataAccess();

			anioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			anioDataAccess.setConnexionType(this.connexionType);
			anioDataAccess.setParameterDbType(this.parameterDbType);

			anio=anioDataAccess.getEntity(connexion,reltablaamortidetalle.getid_anio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return anio;

	}

	public Mes getMes(Connexion connexion,TablaAmortiDetalle reltablaamortidetalle)throws SQLException,Exception {

		Mes mes= new Mes();

		try {
			MesDataAccess mesDataAccess=new MesDataAccess();

			mesDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			mesDataAccess.setConnexionType(this.connexionType);
			mesDataAccess.setParameterDbType(this.parameterDbType);

			mes=mesDataAccess.getEntity(connexion,reltablaamortidetalle.getid_mes());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return mes;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,TablaAmortiDetalle tablaamortidetalle) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!tablaamortidetalle.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(tablaamortidetalle.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(tablaamortidetalle.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_ejercicio=new ParameterValue<Long>();
					parameterMaintenanceValueid_ejercicio.setValue(tablaamortidetalle.getid_ejercicio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_ejercicio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_periodo=new ParameterValue<Long>();
					parameterMaintenanceValueid_periodo.setValue(tablaamortidetalle.getid_periodo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_periodo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tasa=new ParameterValue<Long>();
					parameterMaintenanceValueid_tasa.setValue(tablaamortidetalle.getid_tasa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tasa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_factura=new ParameterValue<Long>();
					parameterMaintenanceValueid_factura.setValue(tablaamortidetalle.getid_factura());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_factura);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_intervalo=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_intervalo.setValue(tablaamortidetalle.getid_tipo_intervalo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_intervalo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_emision=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_emision.setValue(tablaamortidetalle.getfecha_emision());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_emision);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_vencimiento=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_vencimiento.setValue(tablaamortidetalle.getfecha_vencimiento());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_vencimiento);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_inicial=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_inicial.setValue(tablaamortidetalle.getfecha_inicial());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_inicial);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_final=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_final.setValue(tablaamortidetalle.getfecha_final());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_final);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuevalor=new ParameterValue<Double>();
					parameterMaintenanceValuevalor.setValue(tablaamortidetalle.getvalor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuevalor);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueinteres=new ParameterValue<Double>();
					parameterMaintenanceValueinteres.setValue(tablaamortidetalle.getinteres());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueinteres);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuecapital=new ParameterValue<Double>();
					parameterMaintenanceValuecapital.setValue(tablaamortidetalle.getcapital());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecapital);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuenumero_cuotas=new ParameterValue<Integer>();
					parameterMaintenanceValuenumero_cuotas.setValue(tablaamortidetalle.getnumero_cuotas());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_cuotas);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_anio=new ParameterValue<Long>();
					parameterMaintenanceValueid_anio.setValue(tablaamortidetalle.getid_anio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_anio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_mes=new ParameterValue<Long>();
					parameterMaintenanceValueid_mes.setValue(tablaamortidetalle.getid_mes());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_mes);
					parametersTemp.add(parameterMaintenance);
					
						if(!tablaamortidetalle.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(tablaamortidetalle.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(tablaamortidetalle.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(tablaamortidetalle.getId());
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
	
	public void setIsNewIsChangedFalseTablaAmortiDetalle(TablaAmortiDetalle tablaamortidetalle)throws Exception  {		
		tablaamortidetalle.setIsNew(false);
		tablaamortidetalle.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseTablaAmortiDetalles(List<TablaAmortiDetalle> tablaamortidetalles)throws Exception  {				
		for(TablaAmortiDetalle tablaamortidetalle:tablaamortidetalles) {
			tablaamortidetalle.setIsNew(false);
			tablaamortidetalle.setIsChanged(false);
		}
	}
	
	public void generarExportarTablaAmortiDetalle(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
