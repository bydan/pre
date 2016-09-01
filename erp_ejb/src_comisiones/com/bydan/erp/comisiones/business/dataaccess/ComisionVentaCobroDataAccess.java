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
package com.bydan.erp.comisiones.business.dataaccess;

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

import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.comisiones.util.*;//ComisionVentaCobroConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.facturacion.util.*;




@SuppressWarnings("unused")
final public class ComisionVentaCobroDataAccess extends  ComisionVentaCobroDataAccessAdditional{ //ComisionVentaCobroDataAccessAdditional,DataAccessHelper<ComisionVentaCobro>
	//static Logger logger = Logger.getLogger(ComisionVentaCobroDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="comision_venta_cobro";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+ComisionVentaCobroConstantesFunciones.SCHEMA+"."+ComisionVentaCobroConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_ejercicio,id_periodo,id_vendedor,id_factura,numero_factura,fecha_pago,nombre_cliente,numero_comprobante,estado,total_factura,total_abono,porcentaje_comision,total_comision_cobro,numero_dias)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+ComisionVentaCobroConstantesFunciones.SCHEMA+"."+ComisionVentaCobroConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_ejercicio=?,id_periodo=?,id_vendedor=?,id_factura=?,numero_factura=?,fecha_pago=?,nombre_cliente=?,numero_comprobante=?,estado=?,total_factura=?,total_abono=?,porcentaje_comision=?,total_comision_cobro=?,numero_dias=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+ComisionVentaCobroConstantesFunciones.SCHEMA+"."+ComisionVentaCobroConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select comisionventacobro from "+ComisionVentaCobroConstantesFunciones.SPERSISTENCENAME+" comisionventacobro";
	public static String QUERYSELECTNATIVE="select "+ComisionVentaCobroConstantesFunciones.SCHEMA+"."+ComisionVentaCobroConstantesFunciones.TABLENAME+".id,"+ComisionVentaCobroConstantesFunciones.SCHEMA+"."+ComisionVentaCobroConstantesFunciones.TABLENAME+".version_row,"+ComisionVentaCobroConstantesFunciones.SCHEMA+"."+ComisionVentaCobroConstantesFunciones.TABLENAME+".id_empresa,"+ComisionVentaCobroConstantesFunciones.SCHEMA+"."+ComisionVentaCobroConstantesFunciones.TABLENAME+".id_ejercicio,"+ComisionVentaCobroConstantesFunciones.SCHEMA+"."+ComisionVentaCobroConstantesFunciones.TABLENAME+".id_periodo,"+ComisionVentaCobroConstantesFunciones.SCHEMA+"."+ComisionVentaCobroConstantesFunciones.TABLENAME+".id_vendedor,"+ComisionVentaCobroConstantesFunciones.SCHEMA+"."+ComisionVentaCobroConstantesFunciones.TABLENAME+".id_factura,"+ComisionVentaCobroConstantesFunciones.SCHEMA+"."+ComisionVentaCobroConstantesFunciones.TABLENAME+".numero_factura,"+ComisionVentaCobroConstantesFunciones.SCHEMA+"."+ComisionVentaCobroConstantesFunciones.TABLENAME+".fecha_pago,"+ComisionVentaCobroConstantesFunciones.SCHEMA+"."+ComisionVentaCobroConstantesFunciones.TABLENAME+".nombre_cliente,"+ComisionVentaCobroConstantesFunciones.SCHEMA+"."+ComisionVentaCobroConstantesFunciones.TABLENAME+".numero_comprobante,"+ComisionVentaCobroConstantesFunciones.SCHEMA+"."+ComisionVentaCobroConstantesFunciones.TABLENAME+".estado,"+ComisionVentaCobroConstantesFunciones.SCHEMA+"."+ComisionVentaCobroConstantesFunciones.TABLENAME+".total_factura,"+ComisionVentaCobroConstantesFunciones.SCHEMA+"."+ComisionVentaCobroConstantesFunciones.TABLENAME+".total_abono,"+ComisionVentaCobroConstantesFunciones.SCHEMA+"."+ComisionVentaCobroConstantesFunciones.TABLENAME+".porcentaje_comision,"+ComisionVentaCobroConstantesFunciones.SCHEMA+"."+ComisionVentaCobroConstantesFunciones.TABLENAME+".total_comision_cobro,"+ComisionVentaCobroConstantesFunciones.SCHEMA+"."+ComisionVentaCobroConstantesFunciones.TABLENAME+".numero_dias from "+ComisionVentaCobroConstantesFunciones.SCHEMA+"."+ComisionVentaCobroConstantesFunciones.TABLENAME;//+" as "+ComisionVentaCobroConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+ComisionVentaCobroConstantesFunciones.SCHEMA+"."+ComisionVentaCobroConstantesFunciones.TABLENAME+".id,"+ComisionVentaCobroConstantesFunciones.SCHEMA+"."+ComisionVentaCobroConstantesFunciones.TABLENAME+".version_row from "+ComisionVentaCobroConstantesFunciones.SCHEMA+"."+ComisionVentaCobroConstantesFunciones.TABLENAME;//+" as "+ComisionVentaCobroConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+ComisionVentaCobroConstantesFunciones.SCHEMA+"."+ComisionVentaCobroConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_ejercicio=?,id_periodo=?,id_vendedor=?,id_factura=?,numero_factura=?,fecha_pago=?,nombre_cliente=?,numero_comprobante=?,estado=?,total_factura=?,total_abono=?,porcentaje_comision=?,total_comision_cobro=?,numero_dias=?";
	
	public static String STOREPROCEDUREINSERT="call SP_COMISIONVENTACOBRO_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_COMISIONVENTACOBRO_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_COMISIONVENTACOBRO_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_COMISIONVENTACOBRO_SELECT(?,?)";
	
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
	
	
	protected ComisionVentaCobroDataAccessAdditional comisionventacobroDataAccessAdditional=null;
	
	public ComisionVentaCobroDataAccessAdditional getComisionVentaCobroDataAccessAdditional() {
		return this.comisionventacobroDataAccessAdditional;
	}
	
	public void setComisionVentaCobroDataAccessAdditional(ComisionVentaCobroDataAccessAdditional comisionventacobroDataAccessAdditional) {
		try {
			this.comisionventacobroDataAccessAdditional=comisionventacobroDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public ComisionVentaCobroDataAccess() {
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
		ComisionVentaCobroDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		ComisionVentaCobroDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		ComisionVentaCobroDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setComisionVentaCobroOriginal(ComisionVentaCobro comisionventacobro)throws Exception  {
		comisionventacobro.setComisionVentaCobroOriginal((ComisionVentaCobro)comisionventacobro.clone());		
	}
	
	public void setComisionVentaCobrosOriginal(List<ComisionVentaCobro> comisionventacobros)throws Exception  {
		
		for(ComisionVentaCobro comisionventacobro:comisionventacobros){
			comisionventacobro.setComisionVentaCobroOriginal((ComisionVentaCobro)comisionventacobro.clone());
		}
	}
	
	public static void setComisionVentaCobroOriginalStatic(ComisionVentaCobro comisionventacobro)throws Exception  {
		comisionventacobro.setComisionVentaCobroOriginal((ComisionVentaCobro)comisionventacobro.clone());		
	}
	
	public static void setComisionVentaCobrosOriginalStatic(List<ComisionVentaCobro> comisionventacobros)throws Exception  {
		
		for(ComisionVentaCobro comisionventacobro:comisionventacobros){
			comisionventacobro.setComisionVentaCobroOriginal((ComisionVentaCobro)comisionventacobro.clone());
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
	
	public  ComisionVentaCobro getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		ComisionVentaCobro entity = new ComisionVentaCobro();		
		
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
	
	public  ComisionVentaCobro getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		ComisionVentaCobro entity = new ComisionVentaCobro();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ComisionVentaCobroDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ComisionVentaCobroDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Comisiones.ComisionVentaCobro.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setComisionVentaCobroOriginal(new ComisionVentaCobro());
      	    	entity=super.getEntity("",entity,resultSet,ComisionVentaCobroDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityComisionVentaCobro("",entity,resultSet); 
				
				//entity.setComisionVentaCobroOriginal(super.getEntity("",entity.getComisionVentaCobroOriginal(),resultSet,ComisionVentaCobroDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setComisionVentaCobroOriginal(this.getEntityComisionVentaCobro("",entity.getComisionVentaCobroOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseComisionVentaCobro(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  ComisionVentaCobro getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		ComisionVentaCobro entity = new ComisionVentaCobro();
				
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
	
	public  ComisionVentaCobro getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		ComisionVentaCobro entity = new ComisionVentaCobro();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=ComisionVentaCobroDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ComisionVentaCobroDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ComisionVentaCobroDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Comisiones.ComisionVentaCobro.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setComisionVentaCobroOriginal(new ComisionVentaCobro());
      	    	entity=super.getEntity("",entity,resultSet,ComisionVentaCobroDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityComisionVentaCobro("",entity,resultSet);    
				
				//entity.setComisionVentaCobroOriginal(super.getEntity("",entity.getComisionVentaCobroOriginal(),resultSet,ComisionVentaCobroDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setComisionVentaCobroOriginal(this.getEntityComisionVentaCobro("",entity.getComisionVentaCobroOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseComisionVentaCobro(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //ComisionVentaCobro
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		ComisionVentaCobro entity = new ComisionVentaCobro();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ComisionVentaCobroDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ComisionVentaCobroDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ComisionVentaCobroDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Comisiones.ComisionVentaCobro.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseComisionVentaCobro(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<ComisionVentaCobro> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<ComisionVentaCobro> entities = new  ArrayList<ComisionVentaCobro>();
		ComisionVentaCobro entity = new ComisionVentaCobro();		  
		
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
	
	public  List<ComisionVentaCobro> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<ComisionVentaCobro> entities = new  ArrayList<ComisionVentaCobro>();
		ComisionVentaCobro entity = new ComisionVentaCobro();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=ComisionVentaCobroDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=ComisionVentaCobroDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ComisionVentaCobroDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ComisionVentaCobro();
      	    	entity=super.getEntity("",entity,resultSet,ComisionVentaCobroDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityComisionVentaCobro("",entity,resultSet);
      	    	
				//entity.setComisionVentaCobroOriginal( new ComisionVentaCobro());
      	    	//entity.setComisionVentaCobroOriginal(super.getEntity("",entity.getComisionVentaCobroOriginal(),resultSet,ComisionVentaCobroDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setComisionVentaCobroOriginal(this.getEntityComisionVentaCobro("",entity.getComisionVentaCobroOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseComisionVentaCobros(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarComisionVentaCobro(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<ComisionVentaCobro> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<ComisionVentaCobro> entities = new  ArrayList<ComisionVentaCobro>();
		ComisionVentaCobro entity = new ComisionVentaCobro();		  
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
	
	public  List<ComisionVentaCobro> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<ComisionVentaCobro> entities = new  ArrayList<ComisionVentaCobro>();
		ComisionVentaCobro entity = new ComisionVentaCobro();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ComisionVentaCobro();
				
				if(conMapGenerico) {
					entity.inicializarMapComisionVentaCobro();
					//entity.setMapComisionVentaCobro(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapComisionVentaCobroValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapComisionVentaCobro().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ComisionVentaCobroDataAccess.ISWITHSCHEMA);         		
					entity=ComisionVentaCobroDataAccess.getEntityComisionVentaCobro("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setComisionVentaCobroOriginal( new ComisionVentaCobro());
					////entity.setComisionVentaCobroOriginal(super.getEntity("",entity.getComisionVentaCobroOriginal(),resultSet,ComisionVentaCobroDataAccess.ISWITHSCHEMA));         		
					////entity.setComisionVentaCobroOriginal(this.getEntityComisionVentaCobro("",entity.getComisionVentaCobroOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseComisionVentaCobros(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarComisionVentaCobro(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public ComisionVentaCobro getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		ComisionVentaCobro entity = new ComisionVentaCobro();		  
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
	
	public  ComisionVentaCobro getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		ComisionVentaCobro entity = new ComisionVentaCobro();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ComisionVentaCobro();
				
				if(conMapGenerico) {
					entity.inicializarMapComisionVentaCobro();
					//entity.setMapComisionVentaCobro(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapComisionVentaCobroValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapComisionVentaCobro().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,ComisionVentaCobroDataAccess.ISWITHSCHEMA);         		
					entity=ComisionVentaCobroDataAccess.getEntityComisionVentaCobro("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setComisionVentaCobroOriginal( new ComisionVentaCobro());
					////entity.setComisionVentaCobroOriginal(super.getEntity("",entity.getComisionVentaCobroOriginal(),resultSet,ComisionVentaCobroDataAccess.ISWITHSCHEMA));         		
					////entity.setComisionVentaCobroOriginal(this.getEntityComisionVentaCobro("",entity.getComisionVentaCobroOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseComisionVentaCobro(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarComisionVentaCobro(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static ComisionVentaCobro getEntityComisionVentaCobro(String strPrefijo,ComisionVentaCobro entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = ComisionVentaCobro.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = ComisionVentaCobro.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					ComisionVentaCobroDataAccess.setFieldReflectionComisionVentaCobro(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasComisionVentaCobro=ComisionVentaCobroConstantesFunciones.getTodosTiposColumnasComisionVentaCobro();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasComisionVentaCobro) {
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
							field = ComisionVentaCobro.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = ComisionVentaCobro.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						ComisionVentaCobroDataAccess.setFieldReflectionComisionVentaCobro(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionComisionVentaCobro(Field field,String strPrefijo,String sColumn,ComisionVentaCobro entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case ComisionVentaCobroConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ComisionVentaCobroConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ComisionVentaCobroConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ComisionVentaCobroConstantesFunciones.IDEJERCICIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ComisionVentaCobroConstantesFunciones.IDPERIODO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ComisionVentaCobroConstantesFunciones.IDVENDEDOR:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ComisionVentaCobroConstantesFunciones.IDFACTURA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case ComisionVentaCobroConstantesFunciones.NUMEROFACTURA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ComisionVentaCobroConstantesFunciones.FECHAPAGO:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case ComisionVentaCobroConstantesFunciones.NOMBRECLIENTE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ComisionVentaCobroConstantesFunciones.NUMEROCOMPROBANTE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ComisionVentaCobroConstantesFunciones.ESTADO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case ComisionVentaCobroConstantesFunciones.TOTALFACTURA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ComisionVentaCobroConstantesFunciones.TOTALABONO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ComisionVentaCobroConstantesFunciones.PORCENTAJECOMISION:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ComisionVentaCobroConstantesFunciones.TOTALCOMISIONCOBRO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case ComisionVentaCobroConstantesFunciones.NUMERODIAS:
					field.set(entity,resultSet.getInt(sCampo));
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<ComisionVentaCobro>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<ComisionVentaCobro> entities = new  ArrayList<ComisionVentaCobro>();
		ComisionVentaCobro entity = new ComisionVentaCobro();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ComisionVentaCobroDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ComisionVentaCobroDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ComisionVentaCobroDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new ComisionVentaCobro();
					entity=super.getEntity("",entity,resultSet,ComisionVentaCobroDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityComisionVentaCobro("",entity,resultSet);
					
					//entity.setComisionVentaCobroOriginal( new ComisionVentaCobro());
					//entity.setComisionVentaCobroOriginal(super.getEntity("",entity.getComisionVentaCobroOriginal(),resultSet,ComisionVentaCobroDataAccess.ISWITHSCHEMA));         		
					//entity.setComisionVentaCobroOriginal(this.getEntityComisionVentaCobro("",entity.getComisionVentaCobroOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseComisionVentaCobros(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarComisionVentaCobro(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<ComisionVentaCobro>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<ComisionVentaCobro> entities = new  ArrayList<ComisionVentaCobro>();
		ComisionVentaCobro entity = new ComisionVentaCobro();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=ComisionVentaCobroDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=ComisionVentaCobroDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,ComisionVentaCobroDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<ComisionVentaCobro> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ComisionVentaCobro> entities = new  ArrayList<ComisionVentaCobro>();
		ComisionVentaCobro entity = new ComisionVentaCobro();		  
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
	
	public  List<ComisionVentaCobro> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ComisionVentaCobro> entities = new  ArrayList<ComisionVentaCobro>();
		ComisionVentaCobro entity = new ComisionVentaCobro();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ComisionVentaCobro();
      	    	entity=super.getEntity("",entity,resultSet,ComisionVentaCobroDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityComisionVentaCobro("",entity,resultSet);
      	    	
				//entity.setComisionVentaCobroOriginal( new ComisionVentaCobro());
      	    	//entity.setComisionVentaCobroOriginal(super.getEntity("",entity.getComisionVentaCobroOriginal(),resultSet,ComisionVentaCobroDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setComisionVentaCobroOriginal(this.getEntityComisionVentaCobro("",entity.getComisionVentaCobroOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseComisionVentaCobros(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarComisionVentaCobro(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<ComisionVentaCobro> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ComisionVentaCobro> entities = new  ArrayList<ComisionVentaCobro>();
		ComisionVentaCobro entity = new ComisionVentaCobro();		  
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
	
	public  List<ComisionVentaCobro> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<ComisionVentaCobro> entities = new  ArrayList<ComisionVentaCobro>();
		ComisionVentaCobro entity = new ComisionVentaCobro();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new ComisionVentaCobro();
      	    	entity=super.getEntity("",entity,resultSet,ComisionVentaCobroDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityComisionVentaCobro("",entity,resultSet);
      	    	
				//entity.setComisionVentaCobroOriginal( new ComisionVentaCobro());
      	    	//entity.setComisionVentaCobroOriginal(super.getEntity("",entity.getComisionVentaCobroOriginal(),resultSet,ComisionVentaCobroDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setComisionVentaCobroOriginal(this.getEntityComisionVentaCobro("",entity.getComisionVentaCobroOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseComisionVentaCobros(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public ComisionVentaCobro getEntityComisionVentaCobro(String strPrefijo,ComisionVentaCobro entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+ComisionVentaCobroConstantesFunciones.IDEMPRESA));
				entity.setid_ejercicio(resultSet.getLong(strPrefijo+ComisionVentaCobroConstantesFunciones.IDEJERCICIO));
				entity.setid_periodo(resultSet.getLong(strPrefijo+ComisionVentaCobroConstantesFunciones.IDPERIODO));
				entity.setid_vendedor(resultSet.getLong(strPrefijo+ComisionVentaCobroConstantesFunciones.IDVENDEDOR));
				entity.setid_factura(resultSet.getLong(strPrefijo+ComisionVentaCobroConstantesFunciones.IDFACTURA));
				entity.setnumero_factura(resultSet.getString(strPrefijo+ComisionVentaCobroConstantesFunciones.NUMEROFACTURA));
				entity.setfecha_pago(new Date(resultSet.getDate(strPrefijo+ComisionVentaCobroConstantesFunciones.FECHAPAGO).getTime()));
				entity.setnombre_cliente(resultSet.getString(strPrefijo+ComisionVentaCobroConstantesFunciones.NOMBRECLIENTE));
				entity.setnumero_comprobante(resultSet.getString(strPrefijo+ComisionVentaCobroConstantesFunciones.NUMEROCOMPROBANTE));
				entity.setestado(resultSet.getString(strPrefijo+ComisionVentaCobroConstantesFunciones.ESTADO));
				entity.settotal_factura(resultSet.getDouble(strPrefijo+ComisionVentaCobroConstantesFunciones.TOTALFACTURA));
				entity.settotal_abono(resultSet.getDouble(strPrefijo+ComisionVentaCobroConstantesFunciones.TOTALABONO));
				entity.setporcentaje_comision(resultSet.getDouble(strPrefijo+ComisionVentaCobroConstantesFunciones.PORCENTAJECOMISION));
				entity.settotal_comision_cobro(resultSet.getDouble(strPrefijo+ComisionVentaCobroConstantesFunciones.TOTALCOMISIONCOBRO));
				entity.setnumero_dias(resultSet.getInt(strPrefijo+ComisionVentaCobroConstantesFunciones.NUMERODIAS));
			} else {
				  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowComisionVentaCobro(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(ComisionVentaCobro entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=ComisionVentaCobroDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=ComisionVentaCobroDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=ComisionVentaCobroDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=ComisionVentaCobroDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(ComisionVentaCobroConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,ComisionVentaCobroDataAccess.TABLENAME,ComisionVentaCobroDataAccess.ISWITHSTOREPROCEDURES);
			
			ComisionVentaCobroDataAccess.setComisionVentaCobroOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,ComisionVentaCobro relcomisionventacobro)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relcomisionventacobro.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Ejercicio getEjercicio(Connexion connexion,ComisionVentaCobro relcomisionventacobro)throws SQLException,Exception {

		Ejercicio ejercicio= new Ejercicio();

		try {
			EjercicioDataAccess ejercicioDataAccess=new EjercicioDataAccess();

			ejercicioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ejercicioDataAccess.setConnexionType(this.connexionType);
			ejercicioDataAccess.setParameterDbType(this.parameterDbType);

			ejercicio=ejercicioDataAccess.getEntity(connexion,relcomisionventacobro.getid_ejercicio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ejercicio;

	}

	public Periodo getPeriodo(Connexion connexion,ComisionVentaCobro relcomisionventacobro)throws SQLException,Exception {

		Periodo periodo= new Periodo();

		try {
			PeriodoDataAccess periodoDataAccess=new PeriodoDataAccess();

			periodoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			periodoDataAccess.setConnexionType(this.connexionType);
			periodoDataAccess.setParameterDbType(this.parameterDbType);

			periodo=periodoDataAccess.getEntity(connexion,relcomisionventacobro.getid_periodo());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return periodo;

	}

	public Vendedor getVendedor(Connexion connexion,ComisionVentaCobro relcomisionventacobro)throws SQLException,Exception {

		Vendedor vendedor= new Vendedor();

		try {
			VendedorDataAccess vendedorDataAccess=new VendedorDataAccess();

			vendedorDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			vendedorDataAccess.setConnexionType(this.connexionType);
			vendedorDataAccess.setParameterDbType(this.parameterDbType);

			vendedor=vendedorDataAccess.getEntity(connexion,relcomisionventacobro.getid_vendedor());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return vendedor;

	}

	public Factura getFactura(Connexion connexion,ComisionVentaCobro relcomisionventacobro)throws SQLException,Exception {

		Factura factura= new Factura();

		try {
			FacturaDataAccess facturaDataAccess=new FacturaDataAccess();

			facturaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			facturaDataAccess.setConnexionType(this.connexionType);
			facturaDataAccess.setParameterDbType(this.parameterDbType);

			factura=facturaDataAccess.getEntity(connexion,relcomisionventacobro.getid_factura());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return factura;

	}


		
	
	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,ComisionVentaCobro comisionventacobro) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!comisionventacobro.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(comisionventacobro.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_ejercicio=new ParameterValue<Long>();
					parameterMaintenanceValueid_ejercicio.setValue(comisionventacobro.getid_ejercicio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_ejercicio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_periodo=new ParameterValue<Long>();
					parameterMaintenanceValueid_periodo.setValue(comisionventacobro.getid_periodo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_periodo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_vendedor=new ParameterValue<Long>();
					parameterMaintenanceValueid_vendedor.setValue(comisionventacobro.getid_vendedor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_vendedor);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_factura=new ParameterValue<Long>();
					parameterMaintenanceValueid_factura.setValue(comisionventacobro.getid_factura());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_factura);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero_factura=new ParameterValue<String>();
					parameterMaintenanceValuenumero_factura.setValue(comisionventacobro.getnumero_factura());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_factura);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_pago=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_pago.setValue(comisionventacobro.getfecha_pago());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_pago);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre_cliente=new ParameterValue<String>();
					parameterMaintenanceValuenombre_cliente.setValue(comisionventacobro.getnombre_cliente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre_cliente);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero_comprobante=new ParameterValue<String>();
					parameterMaintenanceValuenumero_comprobante.setValue(comisionventacobro.getnumero_comprobante());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_comprobante);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueestado=new ParameterValue<String>();
					parameterMaintenanceValueestado.setValue(comisionventacobro.getestado());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueestado);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuetotal_factura=new ParameterValue<Double>();
					parameterMaintenanceValuetotal_factura.setValue(comisionventacobro.gettotal_factura());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetotal_factura);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuetotal_abono=new ParameterValue<Double>();
					parameterMaintenanceValuetotal_abono.setValue(comisionventacobro.gettotal_abono());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetotal_abono);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueporcentaje_comision=new ParameterValue<Double>();
					parameterMaintenanceValueporcentaje_comision.setValue(comisionventacobro.getporcentaje_comision());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueporcentaje_comision);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuetotal_comision_cobro=new ParameterValue<Double>();
					parameterMaintenanceValuetotal_comision_cobro.setValue(comisionventacobro.gettotal_comision_cobro());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetotal_comision_cobro);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuenumero_dias=new ParameterValue<Integer>();
					parameterMaintenanceValuenumero_dias.setValue(comisionventacobro.getnumero_dias());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_dias);
					parametersTemp.add(parameterMaintenance);
					
						if(!comisionventacobro.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(comisionventacobro.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(comisionventacobro.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(comisionventacobro.getId());
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
	
	public void setIsNewIsChangedFalseComisionVentaCobro(ComisionVentaCobro comisionventacobro)throws Exception  {		
		comisionventacobro.setIsNew(false);
		comisionventacobro.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseComisionVentaCobros(List<ComisionVentaCobro> comisionventacobros)throws Exception  {				
		for(ComisionVentaCobro comisionventacobro:comisionventacobros) {
			comisionventacobro.setIsNew(false);
			comisionventacobro.setIsChanged(false);
		}
	}
	
	public void generarExportarComisionVentaCobro(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
