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
import com.bydan.erp.comisiones.util.*;//VendedorConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.sris.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.*;
import com.bydan.erp.importaciones.business.entity.*;
import com.bydan.erp.produccion.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.nomina.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.comisiones.business.dataaccess.*;
import com.bydan.erp.sris.business.dataaccess.*;
import com.bydan.erp.tesoreria.business.dataaccess.*;
import com.bydan.erp.puntoventa.business.dataaccess.*;
import com.bydan.erp.activosfijos.business.dataaccess.*;
import com.bydan.erp.importaciones.business.dataaccess.*;
import com.bydan.erp.produccion.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.nomina.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.sris.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.puntoventa.util.*;
import com.bydan.erp.activosfijos.util.*;
import com.bydan.erp.importaciones.util.*;
import com.bydan.erp.produccion.util.*;




@SuppressWarnings("unused")
final public class VendedorDataAccess extends  VendedorDataAccessAdditional{ //VendedorDataAccessAdditional,DataAccessHelper<Vendedor>
	//static Logger logger = Logger.getLogger(VendedorDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="vendedor";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+VendedorConstantesFunciones.SCHEMA+"."+VendedorConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,codigo,nombre,ruc,email,id_empleado,telefono,id_empleado_soporte,id_vendedor,id_pais,id_ciudad,id_zona,representante,es_supervisor,fecha_creacion,direccion_domicilio,direccion_referencia,descripcion,porcentaje_comision,comision,monto_vendido,numero_facturas,fecha_ultima_venta,monto_ultima_venta,con_presupuesto,con_cobertura)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+VendedorConstantesFunciones.SCHEMA+"."+VendedorConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,codigo=?,nombre=?,ruc=?,email=?,id_empleado=?,telefono=?,id_empleado_soporte=?,id_vendedor=?,id_pais=?,id_ciudad=?,id_zona=?,representante=?,es_supervisor=?,fecha_creacion=?,direccion_domicilio=?,direccion_referencia=?,descripcion=?,porcentaje_comision=?,comision=?,monto_vendido=?,numero_facturas=?,fecha_ultima_venta=?,monto_ultima_venta=?,con_presupuesto=?,con_cobertura=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+VendedorConstantesFunciones.SCHEMA+"."+VendedorConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select vendedor from "+VendedorConstantesFunciones.SPERSISTENCENAME+" vendedor";
	public static String QUERYSELECTNATIVE="select "+VendedorConstantesFunciones.SCHEMA+"."+VendedorConstantesFunciones.TABLENAME+".id,"+VendedorConstantesFunciones.SCHEMA+"."+VendedorConstantesFunciones.TABLENAME+".version_row,"+VendedorConstantesFunciones.SCHEMA+"."+VendedorConstantesFunciones.TABLENAME+".id_empresa,"+VendedorConstantesFunciones.SCHEMA+"."+VendedorConstantesFunciones.TABLENAME+".id_sucursal,"+VendedorConstantesFunciones.SCHEMA+"."+VendedorConstantesFunciones.TABLENAME+".codigo,"+VendedorConstantesFunciones.SCHEMA+"."+VendedorConstantesFunciones.TABLENAME+".nombre,"+VendedorConstantesFunciones.SCHEMA+"."+VendedorConstantesFunciones.TABLENAME+".ruc,"+VendedorConstantesFunciones.SCHEMA+"."+VendedorConstantesFunciones.TABLENAME+".email,"+VendedorConstantesFunciones.SCHEMA+"."+VendedorConstantesFunciones.TABLENAME+".id_empleado,"+VendedorConstantesFunciones.SCHEMA+"."+VendedorConstantesFunciones.TABLENAME+".telefono,"+VendedorConstantesFunciones.SCHEMA+"."+VendedorConstantesFunciones.TABLENAME+".id_empleado_soporte,"+VendedorConstantesFunciones.SCHEMA+"."+VendedorConstantesFunciones.TABLENAME+".id_vendedor,"+VendedorConstantesFunciones.SCHEMA+"."+VendedorConstantesFunciones.TABLENAME+".id_pais,"+VendedorConstantesFunciones.SCHEMA+"."+VendedorConstantesFunciones.TABLENAME+".id_ciudad,"+VendedorConstantesFunciones.SCHEMA+"."+VendedorConstantesFunciones.TABLENAME+".id_zona,"+VendedorConstantesFunciones.SCHEMA+"."+VendedorConstantesFunciones.TABLENAME+".representante,"+VendedorConstantesFunciones.SCHEMA+"."+VendedorConstantesFunciones.TABLENAME+".es_supervisor,"+VendedorConstantesFunciones.SCHEMA+"."+VendedorConstantesFunciones.TABLENAME+".fecha_creacion,"+VendedorConstantesFunciones.SCHEMA+"."+VendedorConstantesFunciones.TABLENAME+".direccion_domicilio,"+VendedorConstantesFunciones.SCHEMA+"."+VendedorConstantesFunciones.TABLENAME+".direccion_referencia,"+VendedorConstantesFunciones.SCHEMA+"."+VendedorConstantesFunciones.TABLENAME+".descripcion,"+VendedorConstantesFunciones.SCHEMA+"."+VendedorConstantesFunciones.TABLENAME+".porcentaje_comision,"+VendedorConstantesFunciones.SCHEMA+"."+VendedorConstantesFunciones.TABLENAME+".comision,"+VendedorConstantesFunciones.SCHEMA+"."+VendedorConstantesFunciones.TABLENAME+".monto_vendido,"+VendedorConstantesFunciones.SCHEMA+"."+VendedorConstantesFunciones.TABLENAME+".numero_facturas,"+VendedorConstantesFunciones.SCHEMA+"."+VendedorConstantesFunciones.TABLENAME+".fecha_ultima_venta,"+VendedorConstantesFunciones.SCHEMA+"."+VendedorConstantesFunciones.TABLENAME+".monto_ultima_venta,"+VendedorConstantesFunciones.SCHEMA+"."+VendedorConstantesFunciones.TABLENAME+".con_presupuesto,"+VendedorConstantesFunciones.SCHEMA+"."+VendedorConstantesFunciones.TABLENAME+".con_cobertura from "+VendedorConstantesFunciones.SCHEMA+"."+VendedorConstantesFunciones.TABLENAME;//+" as "+VendedorConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+VendedorConstantesFunciones.SCHEMA+"."+VendedorConstantesFunciones.TABLENAME+".id,"+VendedorConstantesFunciones.SCHEMA+"."+VendedorConstantesFunciones.TABLENAME+".version_row,"+VendedorConstantesFunciones.SCHEMA+"."+VendedorConstantesFunciones.TABLENAME+".codigo,"+VendedorConstantesFunciones.SCHEMA+"."+VendedorConstantesFunciones.TABLENAME+".nombre from "+VendedorConstantesFunciones.SCHEMA+"."+VendedorConstantesFunciones.TABLENAME;//+" as "+VendedorConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+VendedorConstantesFunciones.SCHEMA+"."+VendedorConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,codigo=?,nombre=?,ruc=?,email=?,id_empleado=?,telefono=?,id_empleado_soporte=?,id_vendedor=?,id_pais=?,id_ciudad=?,id_zona=?,representante=?,es_supervisor=?,fecha_creacion=?,direccion_domicilio=?,direccion_referencia=?,descripcion=?,porcentaje_comision=?,comision=?,monto_vendido=?,numero_facturas=?,fecha_ultima_venta=?,monto_ultima_venta=?,con_presupuesto=?,con_cobertura=?";
	
	public static String STOREPROCEDUREINSERT="call SP_VENDEDOR_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_VENDEDOR_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_VENDEDOR_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_VENDEDOR_SELECT(?,?)";
	
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
	
	
	protected VendedorDataAccessAdditional vendedorDataAccessAdditional=null;
	
	public VendedorDataAccessAdditional getVendedorDataAccessAdditional() {
		return this.vendedorDataAccessAdditional;
	}
	
	public void setVendedorDataAccessAdditional(VendedorDataAccessAdditional vendedorDataAccessAdditional) {
		try {
			this.vendedorDataAccessAdditional=vendedorDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public VendedorDataAccess() {
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
		VendedorDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		VendedorDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		VendedorDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setVendedorOriginal(Vendedor vendedor)throws Exception  {
		vendedor.setVendedorOriginal((Vendedor)vendedor.clone());		
	}
	
	public void setVendedorsOriginal(List<Vendedor> vendedors)throws Exception  {
		
		for(Vendedor vendedor:vendedors){
			vendedor.setVendedorOriginal((Vendedor)vendedor.clone());
		}
	}
	
	public static void setVendedorOriginalStatic(Vendedor vendedor)throws Exception  {
		vendedor.setVendedorOriginal((Vendedor)vendedor.clone());		
	}
	
	public static void setVendedorsOriginalStatic(List<Vendedor> vendedors)throws Exception  {
		
		for(Vendedor vendedor:vendedors){
			vendedor.setVendedorOriginal((Vendedor)vendedor.clone());
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
	
	public  Vendedor getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		Vendedor entity = new Vendedor();		
		
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
	
	public  Vendedor getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		Vendedor entity = new Vendedor();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=VendedorDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=VendedorDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//Comisiones.Vendedor.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setVendedorOriginal(new Vendedor());
      	    	entity=super.getEntity("",entity,resultSet,VendedorDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityVendedor("",entity,resultSet); 
				
				//entity.setVendedorOriginal(super.getEntity("",entity.getVendedorOriginal(),resultSet,VendedorDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setVendedorOriginal(this.getEntityVendedor("",entity.getVendedorOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseVendedor(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  Vendedor getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		Vendedor entity = new Vendedor();
				
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
	
	public  Vendedor getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		Vendedor entity = new Vendedor();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=VendedorDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=VendedorDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,VendedorDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Comisiones.Vendedor.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setVendedorOriginal(new Vendedor());
      	    	entity=super.getEntity("",entity,resultSet,VendedorDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityVendedor("",entity,resultSet);    
				
				//entity.setVendedorOriginal(super.getEntity("",entity.getVendedorOriginal(),resultSet,VendedorDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setVendedorOriginal(this.getEntityVendedor("",entity.getVendedorOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseVendedor(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //Vendedor
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		Vendedor entity = new Vendedor();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=VendedorDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=VendedorDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,VendedorDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//Comisiones.Vendedor.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseVendedor(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<Vendedor> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<Vendedor> entities = new  ArrayList<Vendedor>();
		Vendedor entity = new Vendedor();		  
		
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
	
	public  List<Vendedor> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<Vendedor> entities = new  ArrayList<Vendedor>();
		Vendedor entity = new Vendedor();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=VendedorDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=VendedorDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,VendedorDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Vendedor();
      	    	entity=super.getEntity("",entity,resultSet,VendedorDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityVendedor("",entity,resultSet);
      	    	
				//entity.setVendedorOriginal( new Vendedor());
      	    	//entity.setVendedorOriginal(super.getEntity("",entity.getVendedorOriginal(),resultSet,VendedorDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setVendedorOriginal(this.getEntityVendedor("",entity.getVendedorOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseVendedors(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarVendedor(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<Vendedor> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<Vendedor> entities = new  ArrayList<Vendedor>();
		Vendedor entity = new Vendedor();		  
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
	
	public  List<Vendedor> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<Vendedor> entities = new  ArrayList<Vendedor>();
		Vendedor entity = new Vendedor();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Vendedor();
				
				if(conMapGenerico) {
					entity.inicializarMapVendedor();
					//entity.setMapVendedor(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapVendedorValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapVendedor().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,VendedorDataAccess.ISWITHSCHEMA);         		
					entity=VendedorDataAccess.getEntityVendedor("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setVendedorOriginal( new Vendedor());
					////entity.setVendedorOriginal(super.getEntity("",entity.getVendedorOriginal(),resultSet,VendedorDataAccess.ISWITHSCHEMA));         		
					////entity.setVendedorOriginal(this.getEntityVendedor("",entity.getVendedorOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseVendedors(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarVendedor(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public Vendedor getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		Vendedor entity = new Vendedor();		  
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
	
	public  Vendedor getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		Vendedor entity = new Vendedor();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Vendedor();
				
				if(conMapGenerico) {
					entity.inicializarMapVendedor();
					//entity.setMapVendedor(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapVendedorValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapVendedor().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,VendedorDataAccess.ISWITHSCHEMA);         		
					entity=VendedorDataAccess.getEntityVendedor("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setVendedorOriginal( new Vendedor());
					////entity.setVendedorOriginal(super.getEntity("",entity.getVendedorOriginal(),resultSet,VendedorDataAccess.ISWITHSCHEMA));         		
					////entity.setVendedorOriginal(this.getEntityVendedor("",entity.getVendedorOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseVendedor(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarVendedor(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static Vendedor getEntityVendedor(String strPrefijo,Vendedor entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = Vendedor.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = Vendedor.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					VendedorDataAccess.setFieldReflectionVendedor(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasVendedor=VendedorConstantesFunciones.getTodosTiposColumnasVendedor();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasVendedor) {
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
							field = Vendedor.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = Vendedor.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						VendedorDataAccess.setFieldReflectionVendedor(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionVendedor(Field field,String strPrefijo,String sColumn,Vendedor entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case VendedorConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case VendedorConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case VendedorConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case VendedorConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case VendedorConstantesFunciones.CODIGO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case VendedorConstantesFunciones.NOMBRE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case VendedorConstantesFunciones.RUC:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case VendedorConstantesFunciones.EMAIL:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case VendedorConstantesFunciones.IDEMPLEADO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case VendedorConstantesFunciones.TELEFONO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case VendedorConstantesFunciones.IDEMPLEADOSOPORTE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case VendedorConstantesFunciones.IDVENDEDOR:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case VendedorConstantesFunciones.IDPAIS:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case VendedorConstantesFunciones.IDCIUDAD:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case VendedorConstantesFunciones.IDZONA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case VendedorConstantesFunciones.REPRESENTANTE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case VendedorConstantesFunciones.ESSUPERVISOR:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case VendedorConstantesFunciones.FECHACREACION:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case VendedorConstantesFunciones.DIRECCIONDOMICILIO:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case VendedorConstantesFunciones.DIRECCIONREFERENCIA:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case VendedorConstantesFunciones.DESCRIPCION:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case VendedorConstantesFunciones.PORCENTAJECOMISION:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case VendedorConstantesFunciones.COMISION:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case VendedorConstantesFunciones.MONTOVENDIDO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case VendedorConstantesFunciones.NUMEROFACTURAS:
					field.set(entity,resultSet.getInt(sCampo));
					break;
				
				case VendedorConstantesFunciones.FECHAULTIMAVENTA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case VendedorConstantesFunciones.MONTOULTIMAVENTA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case VendedorConstantesFunciones.CONPRESUPUESTO:
					field.set(entity,resultSet.getBoolean(sCampo));
					break;
				
				case VendedorConstantesFunciones.CONCOBERTURA:
					field.set(entity,resultSet.getBoolean(sCampo));
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<Vendedor>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<Vendedor> entities = new  ArrayList<Vendedor>();
		Vendedor entity = new Vendedor();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=VendedorDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=VendedorDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,VendedorDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new Vendedor();
					entity=super.getEntity("",entity,resultSet,VendedorDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityVendedor("",entity,resultSet);
					
					//entity.setVendedorOriginal( new Vendedor());
					//entity.setVendedorOriginal(super.getEntity("",entity.getVendedorOriginal(),resultSet,VendedorDataAccess.ISWITHSCHEMA));         		
					//entity.setVendedorOriginal(this.getEntityVendedor("",entity.getVendedorOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseVendedors(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarVendedor(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<Vendedor>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<Vendedor> entities = new  ArrayList<Vendedor>();
		Vendedor entity = new Vendedor();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=VendedorDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=VendedorDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,VendedorDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<Vendedor> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Vendedor> entities = new  ArrayList<Vendedor>();
		Vendedor entity = new Vendedor();		  
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
	
	public  List<Vendedor> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Vendedor> entities = new  ArrayList<Vendedor>();
		Vendedor entity = new Vendedor();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Vendedor();
      	    	entity=super.getEntity("",entity,resultSet,VendedorDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityVendedor("",entity,resultSet);
      	    	
				//entity.setVendedorOriginal( new Vendedor());
      	    	//entity.setVendedorOriginal(super.getEntity("",entity.getVendedorOriginal(),resultSet,VendedorDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setVendedorOriginal(this.getEntityVendedor("",entity.getVendedorOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseVendedors(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarVendedor(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<Vendedor> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Vendedor> entities = new  ArrayList<Vendedor>();
		Vendedor entity = new Vendedor();		  
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
	
	public  List<Vendedor> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<Vendedor> entities = new  ArrayList<Vendedor>();
		Vendedor entity = new Vendedor();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new Vendedor();
      	    	entity=super.getEntity("",entity,resultSet,VendedorDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityVendedor("",entity,resultSet);
      	    	
				//entity.setVendedorOriginal( new Vendedor());
      	    	//entity.setVendedorOriginal(super.getEntity("",entity.getVendedorOriginal(),resultSet,VendedorDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setVendedorOriginal(this.getEntityVendedor("",entity.getVendedorOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseVendedors(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public Vendedor getEntityVendedor(String strPrefijo,Vendedor entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+VendedorConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+VendedorConstantesFunciones.IDSUCURSAL));
				entity.setcodigo(resultSet.getString(strPrefijo+VendedorConstantesFunciones.CODIGO));
				entity.setnombre(resultSet.getString(strPrefijo+VendedorConstantesFunciones.NOMBRE));
				entity.setruc(resultSet.getString(strPrefijo+VendedorConstantesFunciones.RUC));
				entity.setemail(resultSet.getString(strPrefijo+VendedorConstantesFunciones.EMAIL));
				entity.setid_empleado(resultSet.getLong(strPrefijo+VendedorConstantesFunciones.IDEMPLEADO));
				entity.settelefono(resultSet.getString(strPrefijo+VendedorConstantesFunciones.TELEFONO));
				entity.setid_empleado_soporte(resultSet.getLong(strPrefijo+VendedorConstantesFunciones.IDEMPLEADOSOPORTE));if(resultSet.wasNull()) {entity.setid_empleado_soporte(null); }
				entity.setid_vendedor(resultSet.getLong(strPrefijo+VendedorConstantesFunciones.IDVENDEDOR));if(resultSet.wasNull()) {entity.setid_vendedor(null); }
				entity.setid_pais(resultSet.getLong(strPrefijo+VendedorConstantesFunciones.IDPAIS));
				entity.setid_ciudad(resultSet.getLong(strPrefijo+VendedorConstantesFunciones.IDCIUDAD));
				entity.setid_zona(resultSet.getLong(strPrefijo+VendedorConstantesFunciones.IDZONA));
				entity.setrepresentante(resultSet.getString(strPrefijo+VendedorConstantesFunciones.REPRESENTANTE));
				entity.setes_supervisor(resultSet.getBoolean(strPrefijo+VendedorConstantesFunciones.ESSUPERVISOR));
				entity.setfecha_creacion(new Date(resultSet.getDate(strPrefijo+VendedorConstantesFunciones.FECHACREACION).getTime()));
				entity.setdireccion_domicilio(resultSet.getString(strPrefijo+VendedorConstantesFunciones.DIRECCIONDOMICILIO));
				entity.setdireccion_referencia(resultSet.getString(strPrefijo+VendedorConstantesFunciones.DIRECCIONREFERENCIA));
				entity.setdescripcion(resultSet.getString(strPrefijo+VendedorConstantesFunciones.DESCRIPCION));
				entity.setporcentaje_comision(resultSet.getDouble(strPrefijo+VendedorConstantesFunciones.PORCENTAJECOMISION));
				entity.setcomision(resultSet.getDouble(strPrefijo+VendedorConstantesFunciones.COMISION));
				entity.setmonto_vendido(resultSet.getDouble(strPrefijo+VendedorConstantesFunciones.MONTOVENDIDO));
				entity.setnumero_facturas(resultSet.getInt(strPrefijo+VendedorConstantesFunciones.NUMEROFACTURAS));
				entity.setfecha_ultima_venta(new Date(resultSet.getDate(strPrefijo+VendedorConstantesFunciones.FECHAULTIMAVENTA).getTime()));
				entity.setmonto_ultima_venta(resultSet.getDouble(strPrefijo+VendedorConstantesFunciones.MONTOULTIMAVENTA));
				entity.setcon_presupuesto(resultSet.getBoolean(strPrefijo+VendedorConstantesFunciones.CONPRESUPUESTO));
				entity.setcon_cobertura(resultSet.getBoolean(strPrefijo+VendedorConstantesFunciones.CONCOBERTURA));
			} else {
				entity.setcodigo(resultSet.getString(strPrefijo+VendedorConstantesFunciones.CODIGO));entity.setnombre(resultSet.getString(strPrefijo+VendedorConstantesFunciones.NOMBRE));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowVendedor(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(Vendedor entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=VendedorDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=VendedorDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=VendedorDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=VendedorDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(VendedorConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,VendedorDataAccess.TABLENAME,VendedorDataAccess.ISWITHSTOREPROCEDURES);
			
			VendedorDataAccess.setVendedorOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,Vendedor relvendedor)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relvendedor.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,Vendedor relvendedor)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,relvendedor.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Empleado getEmpleado(Connexion connexion,Vendedor relvendedor)throws SQLException,Exception {

		Empleado empleado= new Empleado();

		try {
			EmpleadoDataAccess empleadoDataAccess=new EmpleadoDataAccess();

			empleadoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empleadoDataAccess.setConnexionType(this.connexionType);
			empleadoDataAccess.setParameterDbType(this.parameterDbType);

			empleado=empleadoDataAccess.getEntity(connexion,relvendedor.getid_empleado());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empleado;

	}

	public Empleado getEmpleadoSoporte(Connexion connexion,Vendedor relvendedor)throws SQLException,Exception {

		Empleado empleado= new Empleado();

		try {
			EmpleadoDataAccess empleadoDataAccess=new EmpleadoDataAccess();

			empleadoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empleadoDataAccess.setConnexionType(this.connexionType);
			empleadoDataAccess.setParameterDbType(this.parameterDbType);

			empleado=empleadoDataAccess.getEntity(connexion,relvendedor.getid_empleado_soporte());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empleado;

	}

	public Vendedor getVendedor(Connexion connexion,Vendedor relvendedor)throws SQLException,Exception {

		Vendedor vendedor= new Vendedor();

		try {
			VendedorDataAccess vendedorDataAccess=new VendedorDataAccess();

			vendedorDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			vendedorDataAccess.setConnexionType(this.connexionType);
			vendedorDataAccess.setParameterDbType(this.parameterDbType);

			vendedor=vendedorDataAccess.getEntity(connexion,relvendedor.getid_vendedor());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return vendedor;

	}

	public Pais getPais(Connexion connexion,Vendedor relvendedor)throws SQLException,Exception {

		Pais pais= new Pais();

		try {
			PaisDataAccess paisDataAccess=new PaisDataAccess();

			paisDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			paisDataAccess.setConnexionType(this.connexionType);
			paisDataAccess.setParameterDbType(this.parameterDbType);

			pais=paisDataAccess.getEntity(connexion,relvendedor.getid_pais());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return pais;

	}

	public Ciudad getCiudad(Connexion connexion,Vendedor relvendedor)throws SQLException,Exception {

		Ciudad ciudad= new Ciudad();

		try {
			CiudadDataAccess ciudadDataAccess=new CiudadDataAccess();

			ciudadDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			ciudadDataAccess.setConnexionType(this.connexionType);
			ciudadDataAccess.setParameterDbType(this.parameterDbType);

			ciudad=ciudadDataAccess.getEntity(connexion,relvendedor.getid_ciudad());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return ciudad;

	}

	public Zona getZona(Connexion connexion,Vendedor relvendedor)throws SQLException,Exception {

		Zona zona= new Zona();

		try {
			ZonaDataAccess zonaDataAccess=new ZonaDataAccess();

			zonaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			zonaDataAccess.setConnexionType(this.connexionType);
			zonaDataAccess.setParameterDbType(this.parameterDbType);

			zona=zonaDataAccess.getEntity(connexion,relvendedor.getid_zona());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return zona;

	}


		
		public List<NotaCreditoSoli> getNotaCreditoSolis(Connexion connexion,Vendedor vendedor)throws SQLException,Exception {

		List<NotaCreditoSoli> notacreditosolis= new ArrayList<NotaCreditoSoli>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+VendedorConstantesFunciones.SCHEMA+".vendedor ON "+NotaCreditoSoliConstantesFunciones.SCHEMA+".nota_credito_soli.id_vendedor="+VendedorConstantesFunciones.SCHEMA+".vendedor.id WHERE "+VendedorConstantesFunciones.SCHEMA+".vendedor.id="+String.valueOf(vendedor.getId());
			} else {
				sQuery=" INNER JOIN notacreditosoli.Vendedor WHERE notacreditosoli.Vendedor.id="+String.valueOf(vendedor.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			NotaCreditoSoliDataAccess notacreditosoliDataAccess=new NotaCreditoSoliDataAccess();

			notacreditosoliDataAccess.setConnexionType(this.connexionType);
			notacreditosoliDataAccess.setParameterDbType(this.parameterDbType);
			notacreditosolis=notacreditosoliDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return notacreditosolis;

	}

	public List<ComisionVentaCobro> getComisionVentaCobros(Connexion connexion,Vendedor vendedor)throws SQLException,Exception {

		List<ComisionVentaCobro> comisionventacobros= new ArrayList<ComisionVentaCobro>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+VendedorConstantesFunciones.SCHEMA+".vendedor ON "+ComisionVentaCobroConstantesFunciones.SCHEMA+".comision_venta_cobro.id_vendedor="+VendedorConstantesFunciones.SCHEMA+".vendedor.id WHERE "+VendedorConstantesFunciones.SCHEMA+".vendedor.id="+String.valueOf(vendedor.getId());
			} else {
				sQuery=" INNER JOIN comisionventacobro.Vendedor WHERE comisionventacobro.Vendedor.id="+String.valueOf(vendedor.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ComisionVentaCobroDataAccess comisionventacobroDataAccess=new ComisionVentaCobroDataAccess();

			comisionventacobroDataAccess.setConnexionType(this.connexionType);
			comisionventacobroDataAccess.setParameterDbType(this.parameterDbType);
			comisionventacobros=comisionventacobroDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return comisionventacobros;

	}

	public List<Vendedor> getVendedors(Connexion connexion,Vendedor vendedor)throws SQLException,Exception {

		List<Vendedor> vendedors= new ArrayList<Vendedor>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+VendedorConstantesFunciones.SCHEMA+".vendedor ON "+VendedorConstantesFunciones.SCHEMA+".vendedor.id_vendedor="+VendedorConstantesFunciones.SCHEMA+".vendedor.id WHERE "+VendedorConstantesFunciones.SCHEMA+".vendedor.id="+String.valueOf(vendedor.getId());
			} else {
				sQuery=" INNER JOIN vendedor.Vendedor WHERE vendedor.Vendedor.id="+String.valueOf(vendedor.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			VendedorDataAccess vendedorDataAccess=new VendedorDataAccess();

			vendedorDataAccess.setConnexionType(this.connexionType);
			vendedorDataAccess.setParameterDbType(this.parameterDbType);
			vendedors=vendedorDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return vendedors;

	}

	public List<Cliente> getClientes(Connexion connexion,Vendedor vendedor)throws SQLException,Exception {

		List<Cliente> clientes= new ArrayList<Cliente>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+VendedorConstantesFunciones.SCHEMA+".vendedor ON "+ClienteConstantesFunciones.SCHEMA+".cliente.id_vendedor="+VendedorConstantesFunciones.SCHEMA+".vendedor.id WHERE "+VendedorConstantesFunciones.SCHEMA+".vendedor.id="+String.valueOf(vendedor.getId());
			} else {
				sQuery=" INNER JOIN cliente.Vendedor WHERE cliente.Vendedor.id="+String.valueOf(vendedor.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ClienteDataAccess clienteDataAccess=new ClienteDataAccess();

			clienteDataAccess.setConnexionType(this.connexionType);
			clienteDataAccess.setParameterDbType(this.parameterDbType);
			clientes=clienteDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return clientes;

	}

	public List<ComisionGrupo> getComisionGrupos(Connexion connexion,Vendedor vendedor)throws SQLException,Exception {

		List<ComisionGrupo> comisiongrupos= new ArrayList<ComisionGrupo>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+VendedorConstantesFunciones.SCHEMA+".vendedor ON "+ComisionGrupoConstantesFunciones.SCHEMA+".comision_grupo.id_vendedor="+VendedorConstantesFunciones.SCHEMA+".vendedor.id WHERE "+VendedorConstantesFunciones.SCHEMA+".vendedor.id="+String.valueOf(vendedor.getId());
			} else {
				sQuery=" INNER JOIN comisiongrupo.Vendedor WHERE comisiongrupo.Vendedor.id="+String.valueOf(vendedor.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ComisionGrupoDataAccess comisiongrupoDataAccess=new ComisionGrupoDataAccess();

			comisiongrupoDataAccess.setConnexionType(this.connexionType);
			comisiongrupoDataAccess.setParameterDbType(this.parameterDbType);
			comisiongrupos=comisiongrupoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return comisiongrupos;

	}

	public List<ComisionLinea> getComisionLineas(Connexion connexion,Vendedor vendedor)throws SQLException,Exception {

		List<ComisionLinea> comisionlineas= new ArrayList<ComisionLinea>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+VendedorConstantesFunciones.SCHEMA+".vendedor ON "+ComisionLineaConstantesFunciones.SCHEMA+".comision_linea.id_vendedor="+VendedorConstantesFunciones.SCHEMA+".vendedor.id WHERE "+VendedorConstantesFunciones.SCHEMA+".vendedor.id="+String.valueOf(vendedor.getId());
			} else {
				sQuery=" INNER JOIN comisionlinea.Vendedor WHERE comisionlinea.Vendedor.id="+String.valueOf(vendedor.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ComisionLineaDataAccess comisionlineaDataAccess=new ComisionLineaDataAccess();

			comisionlineaDataAccess.setConnexionType(this.connexionType);
			comisionlineaDataAccess.setParameterDbType(this.parameterDbType);
			comisionlineas=comisionlineaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return comisionlineas;

	}

	public List<VendedorZona> getVendedorZonas(Connexion connexion,Vendedor vendedor)throws SQLException,Exception {

		List<VendedorZona> vendedorzonas= new ArrayList<VendedorZona>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+VendedorConstantesFunciones.SCHEMA+".vendedor ON "+VendedorZonaConstantesFunciones.SCHEMA+".vendedor_zona.id_vendedor="+VendedorConstantesFunciones.SCHEMA+".vendedor.id WHERE "+VendedorConstantesFunciones.SCHEMA+".vendedor.id="+String.valueOf(vendedor.getId());
			} else {
				sQuery=" INNER JOIN vendedorzona.Vendedor WHERE vendedorzona.Vendedor.id="+String.valueOf(vendedor.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			VendedorZonaDataAccess vendedorzonaDataAccess=new VendedorZonaDataAccess();

			vendedorzonaDataAccess.setConnexionType(this.connexionType);
			vendedorzonaDataAccess.setParameterDbType(this.parameterDbType);
			vendedorzonas=vendedorzonaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return vendedorzonas;

	}

	public List<ComisionCate> getComisionCates(Connexion connexion,Vendedor vendedor)throws SQLException,Exception {

		List<ComisionCate> comisioncates= new ArrayList<ComisionCate>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+VendedorConstantesFunciones.SCHEMA+".vendedor ON "+ComisionCateConstantesFunciones.SCHEMA+".comision_cate.id_vendedor="+VendedorConstantesFunciones.SCHEMA+".vendedor.id WHERE "+VendedorConstantesFunciones.SCHEMA+".vendedor.id="+String.valueOf(vendedor.getId());
			} else {
				sQuery=" INNER JOIN comisioncate.Vendedor WHERE comisioncate.Vendedor.id="+String.valueOf(vendedor.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ComisionCateDataAccess comisioncateDataAccess=new ComisionCateDataAccess();

			comisioncateDataAccess.setConnexionType(this.connexionType);
			comisioncateDataAccess.setParameterDbType(this.parameterDbType);
			comisioncates=comisioncateDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return comisioncates;

	}

	public List<CajeroTurno> getCajeroTurnos(Connexion connexion,Vendedor vendedor)throws SQLException,Exception {

		List<CajeroTurno> cajeroturnos= new ArrayList<CajeroTurno>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+VendedorConstantesFunciones.SCHEMA+".vendedor ON "+CajeroTurnoConstantesFunciones.SCHEMA+".cajero_turno.id_vendedor="+VendedorConstantesFunciones.SCHEMA+".vendedor.id WHERE "+VendedorConstantesFunciones.SCHEMA+".vendedor.id="+String.valueOf(vendedor.getId());
			} else {
				sQuery=" INNER JOIN cajeroturno.Vendedor WHERE cajeroturno.Vendedor.id="+String.valueOf(vendedor.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			CajeroTurnoDataAccess cajeroturnoDataAccess=new CajeroTurnoDataAccess();

			cajeroturnoDataAccess.setConnexionType(this.connexionType);
			cajeroturnoDataAccess.setParameterDbType(this.parameterDbType);
			cajeroturnos=cajeroturnoDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cajeroturnos;

	}

	public List<ComisionMarca> getComisionMarcas(Connexion connexion,Vendedor vendedor)throws SQLException,Exception {

		List<ComisionMarca> comisionmarcas= new ArrayList<ComisionMarca>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+VendedorConstantesFunciones.SCHEMA+".vendedor ON "+ComisionMarcaConstantesFunciones.SCHEMA+".comision_marca.id_vendedor="+VendedorConstantesFunciones.SCHEMA+".vendedor.id WHERE "+VendedorConstantesFunciones.SCHEMA+".vendedor.id="+String.valueOf(vendedor.getId());
			} else {
				sQuery=" INNER JOIN comisionmarca.Vendedor WHERE comisionmarca.Vendedor.id="+String.valueOf(vendedor.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			ComisionMarcaDataAccess comisionmarcaDataAccess=new ComisionMarcaDataAccess();

			comisionmarcaDataAccess.setConnexionType(this.connexionType);
			comisionmarcaDataAccess.setParameterDbType(this.parameterDbType);
			comisionmarcas=comisionmarcaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return comisionmarcas;

	}

	public List<PresupuestoVentas> getPresupuestoVentass(Connexion connexion,Vendedor vendedor)throws SQLException,Exception {

		List<PresupuestoVentas> presupuestoventass= new ArrayList<PresupuestoVentas>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+VendedorConstantesFunciones.SCHEMA+".vendedor ON "+PresupuestoVentasConstantesFunciones.SCHEMA+".presupuesto_ventas.id_vendedor="+VendedorConstantesFunciones.SCHEMA+".vendedor.id WHERE "+VendedorConstantesFunciones.SCHEMA+".vendedor.id="+String.valueOf(vendedor.getId());
			} else {
				sQuery=" INNER JOIN presupuestoventas.Vendedor WHERE presupuestoventas.Vendedor.id="+String.valueOf(vendedor.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			PresupuestoVentasDataAccess presupuestoventasDataAccess=new PresupuestoVentasDataAccess();

			presupuestoventasDataAccess.setConnexionType(this.connexionType);
			presupuestoventasDataAccess.setParameterDbType(this.parameterDbType);
			presupuestoventass=presupuestoventasDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return presupuestoventass;

	}

	public List<PresupuestoVentasLineas> getPresupuestoVentasLineass(Connexion connexion,Vendedor vendedor)throws SQLException,Exception {

		List<PresupuestoVentasLineas> presupuestoventaslineass= new ArrayList<PresupuestoVentasLineas>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+VendedorConstantesFunciones.SCHEMA+".vendedor ON "+PresupuestoVentasLineasConstantesFunciones.SCHEMA+".presupuesto_ventas_lineas.id_vendedor="+VendedorConstantesFunciones.SCHEMA+".vendedor.id WHERE "+VendedorConstantesFunciones.SCHEMA+".vendedor.id="+String.valueOf(vendedor.getId());
			} else {
				sQuery=" INNER JOIN presupuestoventaslineas.Vendedor WHERE presupuestoventaslineas.Vendedor.id="+String.valueOf(vendedor.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			PresupuestoVentasLineasDataAccess presupuestoventaslineasDataAccess=new PresupuestoVentasLineasDataAccess();

			presupuestoventaslineasDataAccess.setConnexionType(this.connexionType);
			presupuestoventaslineasDataAccess.setParameterDbType(this.parameterDbType);
			presupuestoventaslineass=presupuestoventaslineasDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return presupuestoventaslineass;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,Vendedor vendedor) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!vendedor.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(vendedor.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(vendedor.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo=new ParameterValue<String>();
					parameterMaintenanceValuecodigo.setValue(vendedor.getcodigo());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre=new ParameterValue<String>();
					parameterMaintenanceValuenombre.setValue(vendedor.getnombre());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueruc=new ParameterValue<String>();
					parameterMaintenanceValueruc.setValue(vendedor.getruc());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueruc);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValueemail=new ParameterValue<String>();
					parameterMaintenanceValueemail.setValue(vendedor.getemail());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueemail);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empleado=new ParameterValue<Long>();
					parameterMaintenanceValueid_empleado.setValue(vendedor.getid_empleado());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empleado);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuetelefono=new ParameterValue<String>();
					parameterMaintenanceValuetelefono.setValue(vendedor.gettelefono());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetelefono);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empleado_soporte=new ParameterValue<Long>();
					parameterMaintenanceValueid_empleado_soporte.setValue(vendedor.getid_empleado_soporte());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empleado_soporte);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_vendedor=new ParameterValue<Long>();
					parameterMaintenanceValueid_vendedor.setValue(vendedor.getid_vendedor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_vendedor);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_pais=new ParameterValue<Long>();
					parameterMaintenanceValueid_pais.setValue(vendedor.getid_pais());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_pais);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_ciudad=new ParameterValue<Long>();
					parameterMaintenanceValueid_ciudad.setValue(vendedor.getid_ciudad());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_ciudad);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_zona=new ParameterValue<Long>();
					parameterMaintenanceValueid_zona.setValue(vendedor.getid_zona());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_zona);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuerepresentante=new ParameterValue<String>();
					parameterMaintenanceValuerepresentante.setValue(vendedor.getrepresentante());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuerepresentante);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuees_supervisor=new ParameterValue<Boolean>();
					parameterMaintenanceValuees_supervisor.setValue(vendedor.getes_supervisor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuees_supervisor);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_creacion=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_creacion.setValue(vendedor.getfecha_creacion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_creacion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedireccion_domicilio=new ParameterValue<String>();
					parameterMaintenanceValuedireccion_domicilio.setValue(vendedor.getdireccion_domicilio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedireccion_domicilio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedireccion_referencia=new ParameterValue<String>();
					parameterMaintenanceValuedireccion_referencia.setValue(vendedor.getdireccion_referencia());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedireccion_referencia);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedescripcion=new ParameterValue<String>();
					parameterMaintenanceValuedescripcion.setValue(vendedor.getdescripcion());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescripcion);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueporcentaje_comision=new ParameterValue<Double>();
					parameterMaintenanceValueporcentaje_comision.setValue(vendedor.getporcentaje_comision());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueporcentaje_comision);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuecomision=new ParameterValue<Double>();
					parameterMaintenanceValuecomision.setValue(vendedor.getcomision());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecomision);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuemonto_vendido=new ParameterValue<Double>();
					parameterMaintenanceValuemonto_vendido.setValue(vendedor.getmonto_vendido());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuemonto_vendido);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.INT);
					ParameterValue<Integer> parameterMaintenanceValuenumero_facturas=new ParameterValue<Integer>();
					parameterMaintenanceValuenumero_facturas.setValue(vendedor.getnumero_facturas());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_facturas);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha_ultima_venta=new ParameterValue<Date>();
					parameterMaintenanceValuefecha_ultima_venta.setValue(vendedor.getfecha_ultima_venta());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha_ultima_venta);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuemonto_ultima_venta=new ParameterValue<Double>();
					parameterMaintenanceValuemonto_ultima_venta.setValue(vendedor.getmonto_ultima_venta());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuemonto_ultima_venta);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_presupuesto=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_presupuesto.setValue(vendedor.getcon_presupuesto());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_presupuesto);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.BOOLEAN);
					ParameterValue<Boolean> parameterMaintenanceValuecon_cobertura=new ParameterValue<Boolean>();
					parameterMaintenanceValuecon_cobertura.setValue(vendedor.getcon_cobertura());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecon_cobertura);
					parametersTemp.add(parameterMaintenance);
					
						if(!vendedor.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(vendedor.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(vendedor.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(vendedor.getId());
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
	
	public void setIsNewIsChangedFalseVendedor(Vendedor vendedor)throws Exception  {		
		vendedor.setIsNew(false);
		vendedor.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseVendedors(List<Vendedor> vendedors)throws Exception  {				
		for(Vendedor vendedor:vendedors) {
			vendedor.setIsNew(false);
			vendedor.setIsChanged(false);
		}
	}
	
	public void generarExportarVendedor(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
