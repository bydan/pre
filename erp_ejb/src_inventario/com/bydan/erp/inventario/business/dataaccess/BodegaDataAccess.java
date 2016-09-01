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
package com.bydan.erp.inventario.business.dataaccess;

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

import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.inventario.util.*;//BodegaConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.nomina.util.*;




@SuppressWarnings("unused")
final public class BodegaDataAccess extends  BodegaDataAccessAdditional{ //BodegaDataAccessAdditional,DataAccessHelper<Bodega>
	//static Logger logger = Logger.getLogger(BodegaDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="bodega";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+BodegaConstantesFunciones.SCHEMA+"."+BodegaConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_grupo_bodega,id_calidad_producto,codigo,nombre,siglas,direccion,telefono,ruc,responsable_nombre,descripcion,id_pais,id_ciudad,id_centro_costo,id_empleado,es_multi_empresa,con_mostrar_stock,es_bodega_transito,con_stock_negativo,id_cuenta_contable_inventario,id_cuenta_contable_costo,id_cuenta_contable_venta,id_cuenta_contable_descuento,id_cuenta_contable_devolucion,id_cuenta_contable_debito,id_cuenta_contable_credito,id_cuenta_contable_bonifica,id_cuenta_contable_produccion,id_cuenta_contable_costo_bonifica)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+BodegaConstantesFunciones.SCHEMA+"."+BodegaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_grupo_bodega=?,id_calidad_producto=?,codigo=?,nombre=?,siglas=?,direccion=?,telefono=?,ruc=?,responsable_nombre=?,descripcion=?,id_pais=?,id_ciudad=?,id_centro_costo=?,id_empleado=?,es_multi_empresa=?,con_mostrar_stock=?,es_bodega_transito=?,con_stock_negativo=?,id_cuenta_contable_inventario=?,id_cuenta_contable_costo=?,id_cuenta_contable_venta=?,id_cuenta_contable_descuento=?,id_cuenta_contable_devolucion=?,id_cuenta_contable_debito=?,id_cuenta_contable_credito=?,id_cuenta_contable_bonifica=?,id_cuenta_contable_produccion=?,id_cuenta_contable_costo_bonifica=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+BodegaConstantesFunciones.SCHEMA+"."+BodegaConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select bodega from "+BodegaConstantesFunciones.SPERSISTENCENAME+" bodega";
	public static String QUERYSELECTNATIVE="select "+BodegaConstantesFunciones.SCHEMA+"."+BodegaConstantesFunciones.TABLENAME+".id,"+BodegaConstantesFunciones.SCHEMA+"."+BodegaConstantesFunciones.TABLENAME+".version_row,"+BodegaConstantesFunciones.SCHEMA+"."+BodegaConstantesFunciones.TABLENAME+".id_empresa,"+BodegaConstantesFunciones.SCHEMA+"."+BodegaConstantesFunciones.TABLENAME+".id_grupo_bodega,"+BodegaConstantesFunciones.SCHEMA+"."+BodegaConstantesFunciones.TABLENAME+".id_calidad_producto,"+BodegaConstantesFunciones.SCHEMA+"."+BodegaConstantesFunciones.TABLENAME+".codigo,"+BodegaConstantesFunciones.SCHEMA+"."+BodegaConstantesFunciones.TABLENAME+".nombre,"+BodegaConstantesFunciones.SCHEMA+"."+BodegaConstantesFunciones.TABLENAME+".siglas,"+BodegaConstantesFunciones.SCHEMA+"."+BodegaConstantesFunciones.TABLENAME+".direccion,"+BodegaConstantesFunciones.SCHEMA+"."+BodegaConstantesFunciones.TABLENAME+".telefono,"+BodegaConstantesFunciones.SCHEMA+"."+BodegaConstantesFunciones.TABLENAME+".ruc,"+BodegaConstantesFunciones.SCHEMA+"."+BodegaConstantesFunciones.TABLENAME+".responsable_nombre,"+BodegaConstantesFunciones.SCHEMA+"."+BodegaConstantesFunciones.TABLENAME+".descripcion,"+BodegaConstantesFunciones.SCHEMA+"."+BodegaConstantesFunciones.TABLENAME+".id_pais,"+BodegaConstantesFunciones.SCHEMA+"."+BodegaConstantesFunciones.TABLENAME+".id_ciudad,"+BodegaConstantesFunciones.SCHEMA+"."+BodegaConstantesFunciones.TABLENAME+".id_centro_costo,"+BodegaConstantesFunciones.SCHEMA+"."+BodegaConstantesFunciones.TABLENAME+".id_empleado,"+BodegaConstantesFunciones.SCHEMA+"."+BodegaConstantesFunciones.TABLENAME+".es_multi_empresa,"+BodegaConstantesFunciones.SCHEMA+"."+BodegaConstantesFunciones.TABLENAME+".con_mostrar_stock,"+BodegaConstantesFunciones.SCHEMA+"."+BodegaConstantesFunciones.TABLENAME+".es_bodega_transito,"+BodegaConstantesFunciones.SCHEMA+"."+BodegaConstantesFunciones.TABLENAME+".con_stock_negativo,"+BodegaConstantesFunciones.SCHEMA+"."+BodegaConstantesFunciones.TABLENAME+".id_cuenta_contable_inventario,"+BodegaConstantesFunciones.SCHEMA+"."+BodegaConstantesFunciones.TABLENAME+".id_cuenta_contable_costo,"+BodegaConstantesFunciones.SCHEMA+"."+BodegaConstantesFunciones.TABLENAME+".id_cuenta_contable_venta,"+BodegaConstantesFunciones.SCHEMA+"."+BodegaConstantesFunciones.TABLENAME+".id_cuenta_contable_descuento,"+BodegaConstantesFunciones.SCHEMA+"."+BodegaConstantesFunciones.TABLENAME+".id_cuenta_contable_devolucion,"+BodegaConstantesFunciones.SCHEMA+"."+BodegaConstantesFunciones.TABLENAME+".id_cuenta_contable_debito,"+BodegaConstantesFunciones.SCHEMA+"."+BodegaConstantesFunciones.TABLENAME+".id_cuenta_contable_credito,"+BodegaConstantesFunciones.SCHEMA+"."+BodegaConstantesFunciones.TABLENAME+".id_cuenta_contable_bonifica,"+BodegaConstantesFunciones.SCHEMA+"."+BodegaConstantesFunciones.TABLENAME+".id_cuenta_contable_produccion,"+BodegaConstantesFunciones.SCHEMA+"."+BodegaConstantesFunciones.TABLENAME+".id_cuenta_contable_costo_bonifica from "+BodegaConstantesFunciones.SCHEMA+"."+BodegaConstantesFunciones.TABLENAME;//+" as "+BodegaConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+BodegaConstantesFunciones.SCHEMA+"."+BodegaConstantesFunciones.TABLENAME+".id,"+BodegaConstantesFunciones.SCHEMA+"."+BodegaConstantesFunciones.TABLENAME+".version_row,"+BodegaConstantesFunciones.SCHEMA+"."+BodegaConstantesFunciones.TABLENAME+".nombre from "+BodegaConstantesFunciones.SCHEMA+"."+BodegaConstantesFunciones.TABLENAME;//+" as "+BodegaConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+BodegaConstantesFunciones.SCHEMA+"."+BodegaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_grupo_bodega=?,id_calidad_producto=?,codigo=?,nombre=?,siglas=?,direccion=?,telefono=?,ruc=?,responsable_nombre=?,descripcion=?,id_pais=?,id_ciudad=?,id_centro_costo=?,id_empleado=?,es_multi_empresa=?,con_mostrar_stock=?,es_bodega_transito=?,con_stock_negativo=?,id_cuenta_contable_inventario=?,id_cuenta_contable_costo=?,id_cuenta_contable_venta=?,id_cuenta_contable_descuento=?,id_cuenta_contable_devolucion=?,id_cuenta_contable_debito=?,id_cuenta_contable_credito=?,id_cuenta_contable_bonifica=?,id_cuenta_contable_produccion=?,id_cuenta_contable_costo_bonifica=?";
	
	public static String STOREPROCEDUREINSERT="call SP_BODEGA_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_BODEGA_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_BODEGA_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_BODEGA_SELECT(?,?)";
	
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
	
	
	protected BodegaDataAccessAdditional bodegaDataAccessAdditional=null;
	
	public BodegaDataAccessAdditional getBodegaDataAccessAdditional() {
		return this.bodegaDataAccessAdditional;
	}
	
	public void setBodegaDataAccessAdditional(BodegaDataAccessAdditional bodegaDataAccessAdditional) {
		try {
			this.bodegaDataAccessAdditional=bodegaDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public BodegaDataAccess() {
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
		BodegaDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		BodegaDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		BodegaDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setBodegaOriginal(Bodega bodega)throws Exception  {
		bodega.setBodegaOriginal((Bodega)bodega.clone());		
	}
	
	public void setBodegasOriginal(List<Bodega> bodegas)throws Exception  {
		
		for(Bodega bodega:bodegas){
			bodega.setBodegaOriginal((Bodega)bodega.clone());
		}
	}
	
	public static void setBodegaOriginalStatic(Bodega bodega)throws Exception  {
		bodega.setBodegaOriginal((Bodega)bodega.clone());		
	}
	
	public static void setBodegasOriginalStatic(List<Bodega> bodegas)throws Exception  {
		
		for(Bodega bodega:bodegas){
			bodega.setBodegaOriginal((Bodega)bodega.clone());
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
	
	public  Bodega getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		Bodega entity = new Bodega();		
		
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
	
	public  Bodega getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		Bodega entity = new Bodega();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=BodegaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=BodegaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Inventario.Bodega.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setBodegaOriginal(new Bodega());
      	    	entity=super.getEntity("",entity,resultSet,BodegaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityBodega("",entity,resultSet); 
				
				//entity.setBodegaOriginal(super.getEntity("",entity.getBodegaOriginal(),resultSet,BodegaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setBodegaOriginal(this.getEntityBodega("",entity.getBodegaOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseBodega(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  Bodega getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		Bodega entity = new Bodega();
				
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
	
	public  Bodega getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		Bodega entity = new Bodega();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=BodegaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=BodegaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,BodegaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.Bodega.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setBodegaOriginal(new Bodega());
      	    	entity=super.getEntity("",entity,resultSet,BodegaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityBodega("",entity,resultSet);    
				
				//entity.setBodegaOriginal(super.getEntity("",entity.getBodegaOriginal(),resultSet,BodegaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setBodegaOriginal(this.getEntityBodega("",entity.getBodegaOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseBodega(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //Bodega
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		Bodega entity = new Bodega();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=BodegaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=BodegaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,BodegaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Inventario.Bodega.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseBodega(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<Bodega> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<Bodega> entities = new  ArrayList<Bodega>();
		Bodega entity = new Bodega();		  
		
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
	
	public  List<Bodega> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<Bodega> entities = new  ArrayList<Bodega>();
		Bodega entity = new Bodega();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=BodegaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=BodegaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,BodegaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Bodega();
      	    	entity=super.getEntity("",entity,resultSet,BodegaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityBodega("",entity,resultSet);
      	    	
				//entity.setBodegaOriginal( new Bodega());
      	    	//entity.setBodegaOriginal(super.getEntity("",entity.getBodegaOriginal(),resultSet,BodegaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setBodegaOriginal(this.getEntityBodega("",entity.getBodegaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseBodegas(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarBodega(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<Bodega> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<Bodega> entities = new  ArrayList<Bodega>();
		Bodega entity = new Bodega();		  
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
	
	public  List<Bodega> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<Bodega> entities = new  ArrayList<Bodega>();
		Bodega entity = new Bodega();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Bodega();
				
				if(conMapGenerico) {
					entity.inicializarMapBodega();
					//entity.setMapBodega(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapBodegaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapBodega().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,BodegaDataAccess.ISWITHSCHEMA);         		
					entity=BodegaDataAccess.getEntityBodega("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setBodegaOriginal( new Bodega());
					////entity.setBodegaOriginal(super.getEntity("",entity.getBodegaOriginal(),resultSet,BodegaDataAccess.ISWITHSCHEMA));         		
					////entity.setBodegaOriginal(this.getEntityBodega("",entity.getBodegaOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseBodegas(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarBodega(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public Bodega getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		Bodega entity = new Bodega();		  
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
	
	public  Bodega getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		Bodega entity = new Bodega();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Bodega();
				
				if(conMapGenerico) {
					entity.inicializarMapBodega();
					//entity.setMapBodega(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapBodegaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapBodega().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,BodegaDataAccess.ISWITHSCHEMA);         		
					entity=BodegaDataAccess.getEntityBodega("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setBodegaOriginal( new Bodega());
					////entity.setBodegaOriginal(super.getEntity("",entity.getBodegaOriginal(),resultSet,BodegaDataAccess.ISWITHSCHEMA));         		
					////entity.setBodegaOriginal(this.getEntityBodega("",entity.getBodegaOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseBodega(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarBodega(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static Bodega getEntityBodega(String strPrefijo,Bodega entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = Bodega.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = Bodega.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					BodegaDataAccess.setFieldReflectionBodega(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasBodega=BodegaConstantesFunciones.getTodosTiposColumnasBodega();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasBodega) {
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
							field = Bodega.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = Bodega.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						BodegaDataAccess.setFieldReflectionBodega(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionBodega(Field field,String strPrefijo,String sColumn,Bodega entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case BodegaConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case BodegaConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case BodegaConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case BodegaConstantesFunciones.IDGRUPOBODEGA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case BodegaConstantesFunciones.IDCALIDADPRODUCTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case BodegaConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case BodegaConstantesFunciones.NOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case BodegaConstantesFunciones.SIGLAS:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case BodegaConstantesFunciones.DIRECCION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case BodegaConstantesFunciones.TELEFONO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case BodegaConstantesFunciones.RUC:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case BodegaConstantesFunciones.RESPONSABLENOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case BodegaConstantesFunciones.DESCRIPCION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case BodegaConstantesFunciones.IDPAIS:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case BodegaConstantesFunciones.IDCIUDAD:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case BodegaConstantesFunciones.IDCENTROCOSTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case BodegaConstantesFunciones.IDEMPLEADO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case BodegaConstantesFunciones.ESMULTIEMPRESA:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case BodegaConstantesFunciones.CONMOSTRARSTOCK:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case BodegaConstantesFunciones.ESBODEGATRANSITO:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case BodegaConstantesFunciones.CONSTOCKNEGATIVO:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case BodegaConstantesFunciones.IDCUENTACONTABLEINVENTARIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case BodegaConstantesFunciones.IDCUENTACONTABLECOSTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case BodegaConstantesFunciones.IDCUENTACONTABLEVENTA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case BodegaConstantesFunciones.IDCUENTACONTABLEDESCUENTO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case BodegaConstantesFunciones.IDCUENTACONTABLEDEVOLUCION:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case BodegaConstantesFunciones.IDCUENTACONTABLEDEBITO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case BodegaConstantesFunciones.IDCUENTACONTABLECREDITO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case BodegaConstantesFunciones.IDCUENTACONTABLEBONIFICA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case BodegaConstantesFunciones.IDCUENTACONTABLEPRODUCCION:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case BodegaConstantesFunciones.IDCUENTACONTABLECOSTOBONIFICA:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<Bodega>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<Bodega> entities = new  ArrayList<Bodega>();
		Bodega entity = new Bodega();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=BodegaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=BodegaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,BodegaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new Bodega();
					entity=super.getEntity("",entity,resultSet,BodegaDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityBodega("",entity,resultSet);
					
					//entity.setBodegaOriginal( new Bodega());
					//entity.setBodegaOriginal(super.getEntity("",entity.getBodegaOriginal(),resultSet,BodegaDataAccess.ISWITHSCHEMA));         		
					//entity.setBodegaOriginal(this.getEntityBodega("",entity.getBodegaOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseBodegas(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarBodega(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<Bodega>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<Bodega> entities = new  ArrayList<Bodega>();
		Bodega entity = new Bodega();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=BodegaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=BodegaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,BodegaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<Bodega> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Bodega> entities = new  ArrayList<Bodega>();
		Bodega entity = new Bodega();		  
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
	
	public  List<Bodega> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Bodega> entities = new  ArrayList<Bodega>();
		Bodega entity = new Bodega();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Bodega();
      	    	entity=super.getEntity("",entity,resultSet,BodegaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityBodega("",entity,resultSet);
      	    	
				//entity.setBodegaOriginal( new Bodega());
      	    	//entity.setBodegaOriginal(super.getEntity("",entity.getBodegaOriginal(),resultSet,BodegaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setBodegaOriginal(this.getEntityBodega("",entity.getBodegaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseBodegas(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarBodega(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<Bodega> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Bodega> entities = new  ArrayList<Bodega>();
		Bodega entity = new Bodega();		  
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
	
	public  List<Bodega> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Bodega> entities = new  ArrayList<Bodega>();
		Bodega entity = new Bodega();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Bodega();
      	    	entity=super.getEntity("",entity,resultSet,BodegaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityBodega("",entity,resultSet);
      	    	
				//entity.setBodegaOriginal( new Bodega());
      	    	//entity.setBodegaOriginal(super.getEntity("",entity.getBodegaOriginal(),resultSet,BodegaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setBodegaOriginal(this.getEntityBodega("",entity.getBodegaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseBodegas(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public Bodega getEntityBodega(String strPrefijo,Bodega entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+BodegaConstantesFunciones.IDEMPRESA));
				entity.setid_grupo_bodega(resultSet.getLong(strPrefijo+BodegaConstantesFunciones.IDGRUPOBODEGA));
				entity.setid_calidad_producto(resultSet.getLong(strPrefijo+BodegaConstantesFunciones.IDCALIDADPRODUCTO));
				entity.setcodigo(resultSet.getString(strPrefijo+BodegaConstantesFunciones.CODIGO));
				entity.setnombre(resultSet.getString(strPrefijo+BodegaConstantesFunciones.NOMBRE));
				entity.setsiglas(resultSet.getString(strPrefijo+BodegaConstantesFunciones.SIGLAS));
				entity.setdireccion(resultSet.getString(strPrefijo+BodegaConstantesFunciones.DIRECCION));
				entity.settelefono(resultSet.getString(strPrefijo+BodegaConstantesFunciones.TELEFONO));
				entity.setruc(resultSet.getString(strPrefijo+BodegaConstantesFunciones.RUC));
				entity.setresponsable_nombre(resultSet.getString(strPrefijo+BodegaConstantesFunciones.RESPONSABLENOMBRE));
				entity.setdescripcion(resultSet.getString(strPrefijo+BodegaConstantesFunciones.DESCRIPCION));
				entity.setid_pais(resultSet.getLong(strPrefijo+BodegaConstantesFunciones.IDPAIS));
				entity.setid_ciudad(resultSet.getLong(strPrefijo+BodegaConstantesFunciones.IDCIUDAD));
				entity.setid_centro_costo(resultSet.getLong(strPrefijo+BodegaConstantesFunciones.IDCENTROCOSTO));if(resultSet.wasNull()) {entity.setid_centro_costo(null); }
				entity.setid_empleado(resultSet.getLong(strPrefijo+BodegaConstantesFunciones.IDEMPLEADO));
				entity.setes_multi_empresa(resultSet.getBoolean(strPrefijo+BodegaConstantesFunciones.ESMULTIEMPRESA));
				entity.setcon_mostrar_stock(resultSet.getBoolean(strPrefijo+BodegaConstantesFunciones.CONMOSTRARSTOCK));
				entity.setes_bodega_transito(resultSet.getBoolean(strPrefijo+BodegaConstantesFunciones.ESBODEGATRANSITO));
				entity.setcon_stock_negativo(resultSet.getBoolean(strPrefijo+BodegaConstantesFunciones.CONSTOCKNEGATIVO));
				entity.setid_cuenta_contable_inventario(resultSet.getLong(strPrefijo+BodegaConstantesFunciones.IDCUENTACONTABLEINVENTARIO));
				entity.setid_cuenta_contable_costo(resultSet.getLong(strPrefijo+BodegaConstantesFunciones.IDCUENTACONTABLECOSTO));
				entity.setid_cuenta_contable_venta(resultSet.getLong(strPrefijo+BodegaConstantesFunciones.IDCUENTACONTABLEVENTA));
				entity.setid_cuenta_contable_descuento(resultSet.getLong(strPrefijo+BodegaConstantesFunciones.IDCUENTACONTABLEDESCUENTO));
				entity.setid_cuenta_contable_devolucion(resultSet.getLong(strPrefijo+BodegaConstantesFunciones.IDCUENTACONTABLEDEVOLUCION));
				entity.setid_cuenta_contable_debito(resultSet.getLong(strPrefijo+BodegaConstantesFunciones.IDCUENTACONTABLEDEBITO));if(resultSet.wasNull()) {entity.setid_cuenta_contable_debito(null); }
				entity.setid_cuenta_contable_credito(resultSet.getLong(strPrefijo+BodegaConstantesFunciones.IDCUENTACONTABLECREDITO));if(resultSet.wasNull()) {entity.setid_cuenta_contable_credito(null); }
				entity.setid_cuenta_contable_bonifica(resultSet.getLong(strPrefijo+BodegaConstantesFunciones.IDCUENTACONTABLEBONIFICA));
				entity.setid_cuenta_contable_produccion(resultSet.getLong(strPrefijo+BodegaConstantesFunciones.IDCUENTACONTABLEPRODUCCION));
				entity.setid_cuenta_contable_costo_bonifica(resultSet.getLong(strPrefijo+BodegaConstantesFunciones.IDCUENTACONTABLECOSTOBONIFICA));
			} else {
				entity.setnombre(resultSet.getString(strPrefijo+BodegaConstantesFunciones.NOMBRE));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowBodega(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(Bodega entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=BodegaDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=BodegaDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=BodegaDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=BodegaDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(BodegaConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,BodegaDataAccess.TABLENAME,BodegaDataAccess.ISWITHSTOREPROCEDURES);
			
			BodegaDataAccess.setBodegaOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,Bodega relbodega)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relbodega.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public GrupoBodega getGrupoBodega(Connexion connexion,Bodega relbodega)throws SQLException,Exception {

		GrupoBodega grupobodega= new GrupoBodega();

		try {
			GrupoBodegaDataAccess grupobodegaDataAccess=new GrupoBodegaDataAccess();

			grupobodegaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			grupobodegaDataAccess.setConnexionType(this.connexionType);
			grupobodegaDataAccess.setParameterDbType(this.parameterDbType);

			grupobodega=grupobodegaDataAccess.getEntity(connexion,relbodega.getid_grupo_bodega());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return grupobodega;

	}

	public CalidadProducto getCalidadProducto(Connexion connexion,Bodega relbodega)throws SQLException,Exception {

		CalidadProducto calidadproducto= new CalidadProducto();

		try {
			CalidadProductoDataAccess calidadproductoDataAccess=new CalidadProductoDataAccess();

			calidadproductoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			calidadproductoDataAccess.setConnexionType(this.connexionType);
			calidadproductoDataAccess.setParameterDbType(this.parameterDbType);

			calidadproducto=calidadproductoDataAccess.getEntity(connexion,relbodega.getid_calidad_producto());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return calidadproducto;

	}

	public Pais getPais(Connexion connexion,Bodega relbodega)throws SQLException,Exception {

		Pais pais= new Pais();

		try {
			PaisDataAccess paisDataAccess=new PaisDataAccess();

			paisDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			paisDataAccess.setConnexionType(this.connexionType);
			paisDataAccess.setParameterDbType(this.parameterDbType);

			pais=paisDataAccess.getEntity(connexion,relbodega.getid_pais());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return pais;

	}

	public Ciudad getCiudad(Connexion connexion,Bodega relbodega)throws SQLException,Exception {

		Ciudad ciudad= new Ciudad();

		try {
			CiudadDataAccess ciudadDataAccess=new CiudadDataAccess();

			ciudadDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ciudadDataAccess.setConnexionType(this.connexionType);
			ciudadDataAccess.setParameterDbType(this.parameterDbType);

			ciudad=ciudadDataAccess.getEntity(connexion,relbodega.getid_ciudad());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ciudad;

	}

	public CentroCosto getCentroCosto(Connexion connexion,Bodega relbodega)throws SQLException,Exception {

		CentroCosto centrocosto= new CentroCosto();

		try {
			CentroCostoDataAccess centrocostoDataAccess=new CentroCostoDataAccess();

			centrocostoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			centrocostoDataAccess.setConnexionType(this.connexionType);
			centrocostoDataAccess.setParameterDbType(this.parameterDbType);

			centrocosto=centrocostoDataAccess.getEntity(connexion,relbodega.getid_centro_costo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return centrocosto;

	}

	public Empleado getEmpleado(Connexion connexion,Bodega relbodega)throws SQLException,Exception {

		Empleado empleado= new Empleado();

		try {
			EmpleadoDataAccess empleadoDataAccess=new EmpleadoDataAccess();

			empleadoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empleadoDataAccess.setConnexionType(this.connexionType);
			empleadoDataAccess.setParameterDbType(this.parameterDbType);

			empleado=empleadoDataAccess.getEntity(connexion,relbodega.getid_empleado());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empleado;

	}

	public CuentaContable getCuentaContableInventario(Connexion connexion,Bodega relbodega)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relbodega.getid_cuenta_contable_inventario());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public CuentaContable getCuentaContableCosto(Connexion connexion,Bodega relbodega)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relbodega.getid_cuenta_contable_costo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public CuentaContable getCuentaContableVenta(Connexion connexion,Bodega relbodega)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relbodega.getid_cuenta_contable_venta());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public CuentaContable getCuentaContableDescuento(Connexion connexion,Bodega relbodega)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relbodega.getid_cuenta_contable_descuento());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public CuentaContable getCuentaContableDevolucion(Connexion connexion,Bodega relbodega)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relbodega.getid_cuenta_contable_devolucion());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public CuentaContable getCuentaContableDebito(Connexion connexion,Bodega relbodega)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relbodega.getid_cuenta_contable_debito());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public CuentaContable getCuentaContableCredito(Connexion connexion,Bodega relbodega)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relbodega.getid_cuenta_contable_credito());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public CuentaContable getCuentaContableBonifica(Connexion connexion,Bodega relbodega)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relbodega.getid_cuenta_contable_bonifica());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public CuentaContable getCuentaContableProduccion(Connexion connexion,Bodega relbodega)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relbodega.getid_cuenta_contable_produccion());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}

	public CuentaContable getCuentaContableCostoBonifica(Connexion connexion,Bodega relbodega)throws SQLException,Exception {

		CuentaContable cuentacontable= new CuentaContable();

		try {
			CuentaContableDataAccess cuentacontableDataAccess=new CuentaContableDataAccess();

			cuentacontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cuentacontableDataAccess.setConnexionType(this.connexionType);
			cuentacontableDataAccess.setParameterDbType(this.parameterDbType);

			cuentacontable=cuentacontableDataAccess.getEntity(connexion,relbodega.getid_cuenta_contable_costo_bonifica());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cuentacontable;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,Bodega bodega) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!bodega.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(bodega.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_grupo_bodega=new ParameterValue<Long>();
					parameterMaintenanceValueid_grupo_bodega.setValue(bodega.getid_grupo_bodega());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_grupo_bodega);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_calidad_producto=new ParameterValue<Long>();
					parameterMaintenanceValueid_calidad_producto.setValue(bodega.getid_calidad_producto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_calidad_producto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo=new ParameterValue<String>();
					parameterMaintenanceValuecodigo.setValue(bodega.getcodigo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(bodega.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuesiglas=new ParameterValue<String>();
					parameterMaintenanceValuesiglas.setValue(bodega.getsiglas());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuesiglas);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedireccion=new ParameterValue<String>();
					parameterMaintenanceValuedireccion.setValue(bodega.getdireccion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedireccion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuetelefono=new ParameterValue<String>();
					parameterMaintenanceValuetelefono.setValue(bodega.gettelefono());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetelefono);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueruc=new ParameterValue<String>();
					parameterMaintenanceValueruc.setValue(bodega.getruc());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueruc);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueresponsable_nombre=new ParameterValue<String>();
					parameterMaintenanceValueresponsable_nombre.setValue(bodega.getresponsable_nombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueresponsable_nombre);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(bodega.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_pais=new ParameterValue<Long>();
					parameterMaintenanceValueid_pais.setValue(bodega.getid_pais());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_pais);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_ciudad=new ParameterValue<Long>();
					parameterMaintenanceValueid_ciudad.setValue(bodega.getid_ciudad());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_ciudad);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_centro_costo=new ParameterValue<Long>();
					parameterMaintenanceValueid_centro_costo.setValue(bodega.getid_centro_costo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_centro_costo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empleado=new ParameterValue<Long>();
					parameterMaintenanceValueid_empleado.setValue(bodega.getid_empleado());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empleado);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuees_multi_empresa=new ParameterValue<Boolean>();
					parameterMaintenanceValuees_multi_empresa.setValue(bodega.getes_multi_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuees_multi_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_mostrar_stock=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_mostrar_stock.setValue(bodega.getcon_mostrar_stock());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_mostrar_stock);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuees_bodega_transito=new ParameterValue<Boolean>();
					parameterMaintenanceValuees_bodega_transito.setValue(bodega.getes_bodega_transito());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuees_bodega_transito);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_stock_negativo=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_stock_negativo.setValue(bodega.getcon_stock_negativo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_stock_negativo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_inventario=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_inventario.setValue(bodega.getid_cuenta_contable_inventario());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_inventario);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_costo=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_costo.setValue(bodega.getid_cuenta_contable_costo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_costo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_venta=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_venta.setValue(bodega.getid_cuenta_contable_venta());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_venta);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_descuento=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_descuento.setValue(bodega.getid_cuenta_contable_descuento());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_descuento);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_devolucion=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_devolucion.setValue(bodega.getid_cuenta_contable_devolucion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_devolucion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_debito=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_debito.setValue(bodega.getid_cuenta_contable_debito());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_debito);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_credito=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_credito.setValue(bodega.getid_cuenta_contable_credito());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_credito);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_bonifica=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_bonifica.setValue(bodega.getid_cuenta_contable_bonifica());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_bonifica);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_produccion=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_produccion.setValue(bodega.getid_cuenta_contable_produccion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_produccion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cuenta_contable_costo_bonifica=new ParameterValue<Long>();
					parameterMaintenanceValueid_cuenta_contable_costo_bonifica.setValue(bodega.getid_cuenta_contable_costo_bonifica());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cuenta_contable_costo_bonifica);
					parametersTemp.add(parameterMaintenance);
					
						if(!bodega.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(bodega.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(bodega.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(bodega.getId());
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
	
	public void setIsNewIsChangedFalseBodega(Bodega bodega)throws Exception  {		
		bodega.setIsNew(false);
		bodega.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseBodegas(List<Bodega> bodegas)throws Exception  {				
		for(Bodega bodega:bodegas) {
			bodega.setIsNew(false);
			bodega.setIsChanged(false);
		}
	}
	
	public void generarExportarBodega(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
