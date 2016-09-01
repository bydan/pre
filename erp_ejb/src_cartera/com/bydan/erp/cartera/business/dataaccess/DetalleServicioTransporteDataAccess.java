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
package com.bydan.erp.cartera.business.dataaccess;

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

import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.cartera.util.*;//DetalleServicioTransporteConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.inventario.util.*;




@SuppressWarnings("unused")
final public class DetalleServicioTransporteDataAccess extends  DetalleServicioTransporteDataAccessAdditional{ //DetalleServicioTransporteDataAccessAdditional,DataAccessHelper<DetalleServicioTransporte>
	//static Logger logger = Logger.getLogger(DetalleServicioTransporteDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="detalle_servicio_transporte";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+DetalleServicioTransporteConstantesFunciones.SCHEMA+"."+DetalleServicioTransporteConstantesFunciones.TABLENAME+"(version_row,id_servicio_transporte,id_empresa,id_sucursal,id_ejercicio,id_periodo,id_bodega,id_producto,id_unidad,id_centro_costo,cantidad,precio,total,descripcion)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+DetalleServicioTransporteConstantesFunciones.SCHEMA+"."+DetalleServicioTransporteConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_servicio_transporte=?,id_empresa=?,id_sucursal=?,id_ejercicio=?,id_periodo=?,id_bodega=?,id_producto=?,id_unidad=?,id_centro_costo=?,cantidad=?,precio=?,total=?,descripcion=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+DetalleServicioTransporteConstantesFunciones.SCHEMA+"."+DetalleServicioTransporteConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select detalleserviciotransporte from "+DetalleServicioTransporteConstantesFunciones.SPERSISTENCENAME+" detalleserviciotransporte";
	public static String QUERYSELECTNATIVE="select "+DetalleServicioTransporteConstantesFunciones.SCHEMA+"."+DetalleServicioTransporteConstantesFunciones.TABLENAME+".id,"+DetalleServicioTransporteConstantesFunciones.SCHEMA+"."+DetalleServicioTransporteConstantesFunciones.TABLENAME+".version_row,"+DetalleServicioTransporteConstantesFunciones.SCHEMA+"."+DetalleServicioTransporteConstantesFunciones.TABLENAME+".id_servicio_transporte,"+DetalleServicioTransporteConstantesFunciones.SCHEMA+"."+DetalleServicioTransporteConstantesFunciones.TABLENAME+".id_empresa,"+DetalleServicioTransporteConstantesFunciones.SCHEMA+"."+DetalleServicioTransporteConstantesFunciones.TABLENAME+".id_sucursal,"+DetalleServicioTransporteConstantesFunciones.SCHEMA+"."+DetalleServicioTransporteConstantesFunciones.TABLENAME+".id_ejercicio,"+DetalleServicioTransporteConstantesFunciones.SCHEMA+"."+DetalleServicioTransporteConstantesFunciones.TABLENAME+".id_periodo,"+DetalleServicioTransporteConstantesFunciones.SCHEMA+"."+DetalleServicioTransporteConstantesFunciones.TABLENAME+".id_bodega,"+DetalleServicioTransporteConstantesFunciones.SCHEMA+"."+DetalleServicioTransporteConstantesFunciones.TABLENAME+".id_producto,"+DetalleServicioTransporteConstantesFunciones.SCHEMA+"."+DetalleServicioTransporteConstantesFunciones.TABLENAME+".id_unidad,"+DetalleServicioTransporteConstantesFunciones.SCHEMA+"."+DetalleServicioTransporteConstantesFunciones.TABLENAME+".id_centro_costo,"+DetalleServicioTransporteConstantesFunciones.SCHEMA+"."+DetalleServicioTransporteConstantesFunciones.TABLENAME+".cantidad,"+DetalleServicioTransporteConstantesFunciones.SCHEMA+"."+DetalleServicioTransporteConstantesFunciones.TABLENAME+".precio,"+DetalleServicioTransporteConstantesFunciones.SCHEMA+"."+DetalleServicioTransporteConstantesFunciones.TABLENAME+".total,"+DetalleServicioTransporteConstantesFunciones.SCHEMA+"."+DetalleServicioTransporteConstantesFunciones.TABLENAME+".descripcion from "+DetalleServicioTransporteConstantesFunciones.SCHEMA+"."+DetalleServicioTransporteConstantesFunciones.TABLENAME;//+" as "+DetalleServicioTransporteConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+DetalleServicioTransporteConstantesFunciones.SCHEMA+"."+DetalleServicioTransporteConstantesFunciones.TABLENAME+".id,"+DetalleServicioTransporteConstantesFunciones.SCHEMA+"."+DetalleServicioTransporteConstantesFunciones.TABLENAME+".version_row from "+DetalleServicioTransporteConstantesFunciones.SCHEMA+"."+DetalleServicioTransporteConstantesFunciones.TABLENAME;//+" as "+DetalleServicioTransporteConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+DetalleServicioTransporteConstantesFunciones.SCHEMA+"."+DetalleServicioTransporteConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_servicio_transporte=?,id_empresa=?,id_sucursal=?,id_ejercicio=?,id_periodo=?,id_bodega=?,id_producto=?,id_unidad=?,id_centro_costo=?,cantidad=?,precio=?,total=?,descripcion=?";
	
	public static String STOREPROCEDUREINSERT="call SP_DETALLESERVICIOTRANSPORTE_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_DETALLESERVICIOTRANSPORTE_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_DETALLESERVICIOTRANSPORTE_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_DETALLESERVICIOTRANSPORTE_SELECT(?,?)";
	
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
	
	
	protected DetalleServicioTransporteDataAccessAdditional detalleserviciotransporteDataAccessAdditional=null;
	
	public DetalleServicioTransporteDataAccessAdditional getDetalleServicioTransporteDataAccessAdditional() {
		return this.detalleserviciotransporteDataAccessAdditional;
	}
	
	public void setDetalleServicioTransporteDataAccessAdditional(DetalleServicioTransporteDataAccessAdditional detalleserviciotransporteDataAccessAdditional) {
		try {
			this.detalleserviciotransporteDataAccessAdditional=detalleserviciotransporteDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public DetalleServicioTransporteDataAccess() {
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
		DetalleServicioTransporteDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		DetalleServicioTransporteDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		DetalleServicioTransporteDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setDetalleServicioTransporteOriginal(DetalleServicioTransporte detalleserviciotransporte)throws Exception  {
		detalleserviciotransporte.setDetalleServicioTransporteOriginal((DetalleServicioTransporte)detalleserviciotransporte.clone());		
	}
	
	public void setDetalleServicioTransportesOriginal(List<DetalleServicioTransporte> detalleserviciotransportes)throws Exception  {
		
		for(DetalleServicioTransporte detalleserviciotransporte:detalleserviciotransportes){
			detalleserviciotransporte.setDetalleServicioTransporteOriginal((DetalleServicioTransporte)detalleserviciotransporte.clone());
		}
	}
	
	public static void setDetalleServicioTransporteOriginalStatic(DetalleServicioTransporte detalleserviciotransporte)throws Exception  {
		detalleserviciotransporte.setDetalleServicioTransporteOriginal((DetalleServicioTransporte)detalleserviciotransporte.clone());		
	}
	
	public static void setDetalleServicioTransportesOriginalStatic(List<DetalleServicioTransporte> detalleserviciotransportes)throws Exception  {
		
		for(DetalleServicioTransporte detalleserviciotransporte:detalleserviciotransportes){
			detalleserviciotransporte.setDetalleServicioTransporteOriginal((DetalleServicioTransporte)detalleserviciotransporte.clone());
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
	
	public  DetalleServicioTransporte getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		DetalleServicioTransporte entity = new DetalleServicioTransporte();		
		
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
	
	public  DetalleServicioTransporte getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		DetalleServicioTransporte entity = new DetalleServicioTransporte();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=DetalleServicioTransporteDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DetalleServicioTransporteDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Cartera.DetalleServicioTransporte.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setDetalleServicioTransporteOriginal(new DetalleServicioTransporte());
      	    	entity=super.getEntity("",entity,resultSet,DetalleServicioTransporteDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityDetalleServicioTransporte("",entity,resultSet); 
				
				//entity.setDetalleServicioTransporteOriginal(super.getEntity("",entity.getDetalleServicioTransporteOriginal(),resultSet,DetalleServicioTransporteDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleServicioTransporteOriginal(this.getEntityDetalleServicioTransporte("",entity.getDetalleServicioTransporteOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseDetalleServicioTransporte(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  DetalleServicioTransporte getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		DetalleServicioTransporte entity = new DetalleServicioTransporte();
				
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
	
	public  DetalleServicioTransporte getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		DetalleServicioTransporte entity = new DetalleServicioTransporte();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=DetalleServicioTransporteDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DetalleServicioTransporteDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleServicioTransporteDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Cartera.DetalleServicioTransporte.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setDetalleServicioTransporteOriginal(new DetalleServicioTransporte());
      	    	entity=super.getEntity("",entity,resultSet,DetalleServicioTransporteDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityDetalleServicioTransporte("",entity,resultSet);    
				
				//entity.setDetalleServicioTransporteOriginal(super.getEntity("",entity.getDetalleServicioTransporteOriginal(),resultSet,DetalleServicioTransporteDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleServicioTransporteOriginal(this.getEntityDetalleServicioTransporte("",entity.getDetalleServicioTransporteOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseDetalleServicioTransporte(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //DetalleServicioTransporte
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		DetalleServicioTransporte entity = new DetalleServicioTransporte();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DetalleServicioTransporteDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DetalleServicioTransporteDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleServicioTransporteDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Cartera.DetalleServicioTransporte.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseDetalleServicioTransporte(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<DetalleServicioTransporte> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<DetalleServicioTransporte> entities = new  ArrayList<DetalleServicioTransporte>();
		DetalleServicioTransporte entity = new DetalleServicioTransporte();		  
		
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
	
	public  List<DetalleServicioTransporte> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<DetalleServicioTransporte> entities = new  ArrayList<DetalleServicioTransporte>();
		DetalleServicioTransporte entity = new DetalleServicioTransporte();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=DetalleServicioTransporteDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=DetalleServicioTransporteDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleServicioTransporteDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleServicioTransporte();
      	    	entity=super.getEntity("",entity,resultSet,DetalleServicioTransporteDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDetalleServicioTransporte("",entity,resultSet);
      	    	
				//entity.setDetalleServicioTransporteOriginal( new DetalleServicioTransporte());
      	    	//entity.setDetalleServicioTransporteOriginal(super.getEntity("",entity.getDetalleServicioTransporteOriginal(),resultSet,DetalleServicioTransporteDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleServicioTransporteOriginal(this.getEntityDetalleServicioTransporte("",entity.getDetalleServicioTransporteOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDetalleServicioTransportes(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleServicioTransporte(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<DetalleServicioTransporte> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<DetalleServicioTransporte> entities = new  ArrayList<DetalleServicioTransporte>();
		DetalleServicioTransporte entity = new DetalleServicioTransporte();		  
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
	
	public  List<DetalleServicioTransporte> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<DetalleServicioTransporte> entities = new  ArrayList<DetalleServicioTransporte>();
		DetalleServicioTransporte entity = new DetalleServicioTransporte();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleServicioTransporte();
				
				if(conMapGenerico) {
					entity.inicializarMapDetalleServicioTransporte();
					//entity.setMapDetalleServicioTransporte(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapDetalleServicioTransporteValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapDetalleServicioTransporte().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,DetalleServicioTransporteDataAccess.ISWITHSCHEMA);         		
					entity=DetalleServicioTransporteDataAccess.getEntityDetalleServicioTransporte("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setDetalleServicioTransporteOriginal( new DetalleServicioTransporte());
					////entity.setDetalleServicioTransporteOriginal(super.getEntity("",entity.getDetalleServicioTransporteOriginal(),resultSet,DetalleServicioTransporteDataAccess.ISWITHSCHEMA));         		
					////entity.setDetalleServicioTransporteOriginal(this.getEntityDetalleServicioTransporte("",entity.getDetalleServicioTransporteOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDetalleServicioTransportes(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleServicioTransporte(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public DetalleServicioTransporte getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		DetalleServicioTransporte entity = new DetalleServicioTransporte();		  
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
	
	public  DetalleServicioTransporte getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		DetalleServicioTransporte entity = new DetalleServicioTransporte();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleServicioTransporte();
				
				if(conMapGenerico) {
					entity.inicializarMapDetalleServicioTransporte();
					//entity.setMapDetalleServicioTransporte(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapDetalleServicioTransporteValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapDetalleServicioTransporte().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,DetalleServicioTransporteDataAccess.ISWITHSCHEMA);         		
					entity=DetalleServicioTransporteDataAccess.getEntityDetalleServicioTransporte("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setDetalleServicioTransporteOriginal( new DetalleServicioTransporte());
					////entity.setDetalleServicioTransporteOriginal(super.getEntity("",entity.getDetalleServicioTransporteOriginal(),resultSet,DetalleServicioTransporteDataAccess.ISWITHSCHEMA));         		
					////entity.setDetalleServicioTransporteOriginal(this.getEntityDetalleServicioTransporte("",entity.getDetalleServicioTransporteOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseDetalleServicioTransporte(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleServicioTransporte(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static DetalleServicioTransporte getEntityDetalleServicioTransporte(String strPrefijo,DetalleServicioTransporte entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = DetalleServicioTransporte.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = DetalleServicioTransporte.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					DetalleServicioTransporteDataAccess.setFieldReflectionDetalleServicioTransporte(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasDetalleServicioTransporte=DetalleServicioTransporteConstantesFunciones.getTodosTiposColumnasDetalleServicioTransporte();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasDetalleServicioTransporte) {
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
							field = DetalleServicioTransporte.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = DetalleServicioTransporte.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						DetalleServicioTransporteDataAccess.setFieldReflectionDetalleServicioTransporte(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionDetalleServicioTransporte(Field field,String strPrefijo,String sColumn,DetalleServicioTransporte entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case DetalleServicioTransporteConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleServicioTransporteConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case DetalleServicioTransporteConstantesFunciones.IDSERVICIOTRANSPORTE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleServicioTransporteConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleServicioTransporteConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleServicioTransporteConstantesFunciones.IDEJERCICIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleServicioTransporteConstantesFunciones.IDPERIODO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleServicioTransporteConstantesFunciones.IDBODEGA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleServicioTransporteConstantesFunciones.IDPRODUCTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleServicioTransporteConstantesFunciones.IDUNIDAD:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleServicioTransporteConstantesFunciones.IDCENTROCOSTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case DetalleServicioTransporteConstantesFunciones.CANTIDAD:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case DetalleServicioTransporteConstantesFunciones.PRECIO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleServicioTransporteConstantesFunciones.TOTAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case DetalleServicioTransporteConstantesFunciones.DESCRIPCION:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<DetalleServicioTransporte>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<DetalleServicioTransporte> entities = new  ArrayList<DetalleServicioTransporte>();
		DetalleServicioTransporte entity = new DetalleServicioTransporte();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DetalleServicioTransporteDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DetalleServicioTransporteDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleServicioTransporteDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new DetalleServicioTransporte();
					entity=super.getEntity("",entity,resultSet,DetalleServicioTransporteDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityDetalleServicioTransporte("",entity,resultSet);
					
					//entity.setDetalleServicioTransporteOriginal( new DetalleServicioTransporte());
					//entity.setDetalleServicioTransporteOriginal(super.getEntity("",entity.getDetalleServicioTransporteOriginal(),resultSet,DetalleServicioTransporteDataAccess.ISWITHSCHEMA));         		
					//entity.setDetalleServicioTransporteOriginal(this.getEntityDetalleServicioTransporte("",entity.getDetalleServicioTransporteOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseDetalleServicioTransportes(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleServicioTransporte(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<DetalleServicioTransporte>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<DetalleServicioTransporte> entities = new  ArrayList<DetalleServicioTransporte>();
		DetalleServicioTransporte entity = new DetalleServicioTransporte();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=DetalleServicioTransporteDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=DetalleServicioTransporteDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,DetalleServicioTransporteDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<DetalleServicioTransporte> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetalleServicioTransporte> entities = new  ArrayList<DetalleServicioTransporte>();
		DetalleServicioTransporte entity = new DetalleServicioTransporte();		  
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
	
	public  List<DetalleServicioTransporte> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetalleServicioTransporte> entities = new  ArrayList<DetalleServicioTransporte>();
		DetalleServicioTransporte entity = new DetalleServicioTransporte();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleServicioTransporte();
      	    	entity=super.getEntity("",entity,resultSet,DetalleServicioTransporteDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDetalleServicioTransporte("",entity,resultSet);
      	    	
				//entity.setDetalleServicioTransporteOriginal( new DetalleServicioTransporte());
      	    	//entity.setDetalleServicioTransporteOriginal(super.getEntity("",entity.getDetalleServicioTransporteOriginal(),resultSet,DetalleServicioTransporteDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleServicioTransporteOriginal(this.getEntityDetalleServicioTransporte("",entity.getDetalleServicioTransporteOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseDetalleServicioTransportes(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarDetalleServicioTransporte(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<DetalleServicioTransporte> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetalleServicioTransporte> entities = new  ArrayList<DetalleServicioTransporte>();
		DetalleServicioTransporte entity = new DetalleServicioTransporte();		  
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
	
	public  List<DetalleServicioTransporte> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<DetalleServicioTransporte> entities = new  ArrayList<DetalleServicioTransporte>();
		DetalleServicioTransporte entity = new DetalleServicioTransporte();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new DetalleServicioTransporte();
      	    	entity=super.getEntity("",entity,resultSet,DetalleServicioTransporteDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityDetalleServicioTransporte("",entity,resultSet);
      	    	
				//entity.setDetalleServicioTransporteOriginal( new DetalleServicioTransporte());
      	    	//entity.setDetalleServicioTransporteOriginal(super.getEntity("",entity.getDetalleServicioTransporteOriginal(),resultSet,DetalleServicioTransporteDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setDetalleServicioTransporteOriginal(this.getEntityDetalleServicioTransporte("",entity.getDetalleServicioTransporteOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseDetalleServicioTransportes(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public DetalleServicioTransporte getEntityDetalleServicioTransporte(String strPrefijo,DetalleServicioTransporte entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_servicio_transporte(resultSet.getLong(strPrefijo+DetalleServicioTransporteConstantesFunciones.IDSERVICIOTRANSPORTE));
				entity.setid_empresa(resultSet.getLong(strPrefijo+DetalleServicioTransporteConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+DetalleServicioTransporteConstantesFunciones.IDSUCURSAL));
				entity.setid_ejercicio(resultSet.getLong(strPrefijo+DetalleServicioTransporteConstantesFunciones.IDEJERCICIO));
				entity.setid_periodo(resultSet.getLong(strPrefijo+DetalleServicioTransporteConstantesFunciones.IDPERIODO));
				entity.setid_bodega(resultSet.getLong(strPrefijo+DetalleServicioTransporteConstantesFunciones.IDBODEGA));
				entity.setid_producto(resultSet.getLong(strPrefijo+DetalleServicioTransporteConstantesFunciones.IDPRODUCTO));
				entity.setid_unidad(resultSet.getLong(strPrefijo+DetalleServicioTransporteConstantesFunciones.IDUNIDAD));
				entity.setid_centro_costo(resultSet.getLong(strPrefijo+DetalleServicioTransporteConstantesFunciones.IDCENTROCOSTO));if(resultSet.wasNull()) {entity.setid_centro_costo(null); }
				entity.setcantidad(resultSet.getInt(strPrefijo+DetalleServicioTransporteConstantesFunciones.CANTIDAD));
				entity.setprecio(resultSet.getDouble(strPrefijo+DetalleServicioTransporteConstantesFunciones.PRECIO));
				entity.settotal(resultSet.getDouble(strPrefijo+DetalleServicioTransporteConstantesFunciones.TOTAL));
				entity.setdescripcion(resultSet.getString(strPrefijo+DetalleServicioTransporteConstantesFunciones.DESCRIPCION));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowDetalleServicioTransporte(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(DetalleServicioTransporte entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=DetalleServicioTransporteDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=DetalleServicioTransporteDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=DetalleServicioTransporteDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=DetalleServicioTransporteDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(DetalleServicioTransporteConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,DetalleServicioTransporteDataAccess.TABLENAME,DetalleServicioTransporteDataAccess.ISWITHSTOREPROCEDURES);
			
			DetalleServicioTransporteDataAccess.setDetalleServicioTransporteOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public ServicioTransporte getServicioTransporte(Connexion connexion,DetalleServicioTransporte reldetalleserviciotransporte)throws SQLException,Exception {

		ServicioTransporte serviciotransporte= new ServicioTransporte();

		try {
			ServicioTransporteDataAccess serviciotransporteDataAccess=new ServicioTransporteDataAccess();

			serviciotransporteDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			serviciotransporteDataAccess.setConnexionType(this.connexionType);
			serviciotransporteDataAccess.setParameterDbType(this.parameterDbType);

			serviciotransporte=serviciotransporteDataAccess.getEntity(connexion,reldetalleserviciotransporte.getid_servicio_transporte());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return serviciotransporte;

	}

	public Empresa getEmpresa(Connexion connexion,DetalleServicioTransporte reldetalleserviciotransporte)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,reldetalleserviciotransporte.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,DetalleServicioTransporte reldetalleserviciotransporte)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,reldetalleserviciotransporte.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Ejercicio getEjercicio(Connexion connexion,DetalleServicioTransporte reldetalleserviciotransporte)throws SQLException,Exception {

		Ejercicio ejercicio= new Ejercicio();

		try {
			EjercicioDataAccess ejercicioDataAccess=new EjercicioDataAccess();

			ejercicioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ejercicioDataAccess.setConnexionType(this.connexionType);
			ejercicioDataAccess.setParameterDbType(this.parameterDbType);

			ejercicio=ejercicioDataAccess.getEntity(connexion,reldetalleserviciotransporte.getid_ejercicio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ejercicio;

	}

	public Periodo getPeriodo(Connexion connexion,DetalleServicioTransporte reldetalleserviciotransporte)throws SQLException,Exception {

		Periodo periodo= new Periodo();

		try {
			PeriodoDataAccess periodoDataAccess=new PeriodoDataAccess();

			periodoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			periodoDataAccess.setConnexionType(this.connexionType);
			periodoDataAccess.setParameterDbType(this.parameterDbType);

			periodo=periodoDataAccess.getEntity(connexion,reldetalleserviciotransporte.getid_periodo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return periodo;

	}

	public Bodega getBodega(Connexion connexion,DetalleServicioTransporte reldetalleserviciotransporte)throws SQLException,Exception {

		Bodega bodega= new Bodega();

		try {
			BodegaDataAccess bodegaDataAccess=new BodegaDataAccess();

			bodegaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			bodegaDataAccess.setConnexionType(this.connexionType);
			bodegaDataAccess.setParameterDbType(this.parameterDbType);

			bodega=bodegaDataAccess.getEntity(connexion,reldetalleserviciotransporte.getid_bodega());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return bodega;

	}

	public Producto getProducto(Connexion connexion,DetalleServicioTransporte reldetalleserviciotransporte)throws SQLException,Exception {

		Producto producto= new Producto();

		try {
			ProductoDataAccess productoDataAccess=new ProductoDataAccess();

			productoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			productoDataAccess.setConnexionType(this.connexionType);
			productoDataAccess.setParameterDbType(this.parameterDbType);

			producto=productoDataAccess.getEntity(connexion,reldetalleserviciotransporte.getid_producto());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return producto;

	}

	public Unidad getUnidad(Connexion connexion,DetalleServicioTransporte reldetalleserviciotransporte)throws SQLException,Exception {

		Unidad unidad= new Unidad();

		try {
			UnidadDataAccess unidadDataAccess=new UnidadDataAccess();

			unidadDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			unidadDataAccess.setConnexionType(this.connexionType);
			unidadDataAccess.setParameterDbType(this.parameterDbType);

			unidad=unidadDataAccess.getEntity(connexion,reldetalleserviciotransporte.getid_unidad());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return unidad;

	}

	public CentroCosto getCentroCosto(Connexion connexion,DetalleServicioTransporte reldetalleserviciotransporte)throws SQLException,Exception {

		CentroCosto centrocosto= new CentroCosto();

		try {
			CentroCostoDataAccess centrocostoDataAccess=new CentroCostoDataAccess();

			centrocostoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			centrocostoDataAccess.setConnexionType(this.connexionType);
			centrocostoDataAccess.setParameterDbType(this.parameterDbType);

			centrocosto=centrocostoDataAccess.getEntity(connexion,reldetalleserviciotransporte.getid_centro_costo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return centrocosto;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,DetalleServicioTransporte detalleserviciotransporte) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!detalleserviciotransporte.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_servicio_transporte=new ParameterValue<Long>();
					parameterMaintenanceValueid_servicio_transporte.setValue(detalleserviciotransporte.getid_servicio_transporte());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_servicio_transporte);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(detalleserviciotransporte.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(detalleserviciotransporte.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_ejercicio=new ParameterValue<Long>();
					parameterMaintenanceValueid_ejercicio.setValue(detalleserviciotransporte.getid_ejercicio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_ejercicio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_periodo=new ParameterValue<Long>();
					parameterMaintenanceValueid_periodo.setValue(detalleserviciotransporte.getid_periodo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_periodo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_bodega=new ParameterValue<Long>();
					parameterMaintenanceValueid_bodega.setValue(detalleserviciotransporte.getid_bodega());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_bodega);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_producto=new ParameterValue<Long>();
					parameterMaintenanceValueid_producto.setValue(detalleserviciotransporte.getid_producto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_producto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_unidad=new ParameterValue<Long>();
					parameterMaintenanceValueid_unidad.setValue(detalleserviciotransporte.getid_unidad());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_unidad);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_centro_costo=new ParameterValue<Long>();
					parameterMaintenanceValueid_centro_costo.setValue(detalleserviciotransporte.getid_centro_costo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_centro_costo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuecantidad=new ParameterValue<Integer>();
					parameterMaintenanceValuecantidad.setValue(detalleserviciotransporte.getcantidad());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecantidad);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueprecio=new ParameterValue<Double>();
					parameterMaintenanceValueprecio.setValue(detalleserviciotransporte.getprecio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueprecio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuetotal=new ParameterValue<Double>();
					parameterMaintenanceValuetotal.setValue(detalleserviciotransporte.gettotal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetotal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(detalleserviciotransporte.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
						if(!detalleserviciotransporte.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(detalleserviciotransporte.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(detalleserviciotransporte.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(detalleserviciotransporte.getId());
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
	
	public void setIsNewIsChangedFalseDetalleServicioTransporte(DetalleServicioTransporte detalleserviciotransporte)throws Exception  {		
		detalleserviciotransporte.setIsNew(false);
		detalleserviciotransporte.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseDetalleServicioTransportes(List<DetalleServicioTransporte> detalleserviciotransportes)throws Exception  {				
		for(DetalleServicioTransporte detalleserviciotransporte:detalleserviciotransportes) {
			detalleserviciotransporte.setIsNew(false);
			detalleserviciotransporte.setIsChanged(false);
		}
	}
	
	public void generarExportarDetalleServicioTransporte(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
