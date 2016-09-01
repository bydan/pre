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
import com.bydan.erp.puntoventa.util.*;//NotaCreditoPuntoVentaConstantesFunciones;


import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;


import com.bydan.erp.seguridad.business.dataaccess.*;
import com.bydan.erp.comisiones.business.dataaccess.*;
import com.bydan.erp.cartera.business.dataaccess.*;
import com.bydan.erp.contabilidad.business.dataaccess.*;
import com.bydan.erp.inventario.business.dataaccess.*;
import com.bydan.erp.facturacion.business.dataaccess.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.comisiones.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.inventario.util.*;
import com.bydan.erp.facturacion.util.*;




@SuppressWarnings("unused")
final public class NotaCreditoPuntoVentaDataAccess extends  NotaCreditoPuntoVentaDataAccessAdditional{ //NotaCreditoPuntoVentaDataAccessAdditional,DataAccessHelper<NotaCreditoPuntoVenta>
	//static Logger logger = Logger.getLogger(NotaCreditoPuntoVentaDataAccess.class);
	
	public static String SCHEMA="bydan_erp";	
	public static String TABLENAME="nota_credito_punto_venta";
	
	//POSTGRES
	public static String QUERYINSERT="insert into "+NotaCreditoPuntoVentaConstantesFunciones.SCHEMA+"."+NotaCreditoPuntoVentaConstantesFunciones.TABLENAME+"(version_row,id_empresa,id_sucursal,id_usuario,id_vendedor,id_cliente,id_caja,id_asiento_contable,id_tipo_precio,id_mesa,id_formato,id_tipo_factura_punto_venta,id_estado_nota_credito_punto_venta,numero_secuencial,codigo_cliente,nombre_cliente,tarjeta_cliente,direccion_cliente,telefono_cliente,fecha,hora,total_iva,total_sin_iva,iva,descuento,financiamiento,flete,ice,otros,sub_total,total)values(current_timestamp,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String QUERYUPDATE="update "+NotaCreditoPuntoVentaConstantesFunciones.SCHEMA+"."+NotaCreditoPuntoVentaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_usuario=?,id_vendedor=?,id_cliente=?,id_caja=?,id_asiento_contable=?,id_tipo_precio=?,id_mesa=?,id_formato=?,id_tipo_factura_punto_venta=?,id_estado_nota_credito_punto_venta=?,numero_secuencial=?,codigo_cliente=?,nombre_cliente=?,tarjeta_cliente=?,direccion_cliente=?,telefono_cliente=?,fecha=?,hora=?,total_iva=?,total_sin_iva=?,iva=?,descuento=?,financiamiento=?,flete=?,ice=?,otros=?,sub_total=?,total=? where id=? AND version_row=?";
	public static String QUERYDELETE="delete from "+NotaCreditoPuntoVentaConstantesFunciones.SCHEMA+"."+NotaCreditoPuntoVentaConstantesFunciones.TABLENAME+" where id=?";
	public static String QUERYSELECT="select notacreditopuntoventa from "+NotaCreditoPuntoVentaConstantesFunciones.SPERSISTENCENAME+" notacreditopuntoventa";
	public static String QUERYSELECTNATIVE="select "+NotaCreditoPuntoVentaConstantesFunciones.SCHEMA+"."+NotaCreditoPuntoVentaConstantesFunciones.TABLENAME+".id,"+NotaCreditoPuntoVentaConstantesFunciones.SCHEMA+"."+NotaCreditoPuntoVentaConstantesFunciones.TABLENAME+".version_row,"+NotaCreditoPuntoVentaConstantesFunciones.SCHEMA+"."+NotaCreditoPuntoVentaConstantesFunciones.TABLENAME+".id_empresa,"+NotaCreditoPuntoVentaConstantesFunciones.SCHEMA+"."+NotaCreditoPuntoVentaConstantesFunciones.TABLENAME+".id_sucursal,"+NotaCreditoPuntoVentaConstantesFunciones.SCHEMA+"."+NotaCreditoPuntoVentaConstantesFunciones.TABLENAME+".id_usuario,"+NotaCreditoPuntoVentaConstantesFunciones.SCHEMA+"."+NotaCreditoPuntoVentaConstantesFunciones.TABLENAME+".id_vendedor,"+NotaCreditoPuntoVentaConstantesFunciones.SCHEMA+"."+NotaCreditoPuntoVentaConstantesFunciones.TABLENAME+".id_cliente,"+NotaCreditoPuntoVentaConstantesFunciones.SCHEMA+"."+NotaCreditoPuntoVentaConstantesFunciones.TABLENAME+".id_caja,"+NotaCreditoPuntoVentaConstantesFunciones.SCHEMA+"."+NotaCreditoPuntoVentaConstantesFunciones.TABLENAME+".id_asiento_contable,"+NotaCreditoPuntoVentaConstantesFunciones.SCHEMA+"."+NotaCreditoPuntoVentaConstantesFunciones.TABLENAME+".id_tipo_precio,"+NotaCreditoPuntoVentaConstantesFunciones.SCHEMA+"."+NotaCreditoPuntoVentaConstantesFunciones.TABLENAME+".id_mesa,"+NotaCreditoPuntoVentaConstantesFunciones.SCHEMA+"."+NotaCreditoPuntoVentaConstantesFunciones.TABLENAME+".id_formato,"+NotaCreditoPuntoVentaConstantesFunciones.SCHEMA+"."+NotaCreditoPuntoVentaConstantesFunciones.TABLENAME+".id_tipo_factura_punto_venta,"+NotaCreditoPuntoVentaConstantesFunciones.SCHEMA+"."+NotaCreditoPuntoVentaConstantesFunciones.TABLENAME+".id_estado_nota_credito_punto_venta,"+NotaCreditoPuntoVentaConstantesFunciones.SCHEMA+"."+NotaCreditoPuntoVentaConstantesFunciones.TABLENAME+".numero_secuencial,"+NotaCreditoPuntoVentaConstantesFunciones.SCHEMA+"."+NotaCreditoPuntoVentaConstantesFunciones.TABLENAME+".codigo_cliente,"+NotaCreditoPuntoVentaConstantesFunciones.SCHEMA+"."+NotaCreditoPuntoVentaConstantesFunciones.TABLENAME+".nombre_cliente,"+NotaCreditoPuntoVentaConstantesFunciones.SCHEMA+"."+NotaCreditoPuntoVentaConstantesFunciones.TABLENAME+".tarjeta_cliente,"+NotaCreditoPuntoVentaConstantesFunciones.SCHEMA+"."+NotaCreditoPuntoVentaConstantesFunciones.TABLENAME+".direccion_cliente,"+NotaCreditoPuntoVentaConstantesFunciones.SCHEMA+"."+NotaCreditoPuntoVentaConstantesFunciones.TABLENAME+".telefono_cliente,"+NotaCreditoPuntoVentaConstantesFunciones.SCHEMA+"."+NotaCreditoPuntoVentaConstantesFunciones.TABLENAME+".fecha,"+NotaCreditoPuntoVentaConstantesFunciones.SCHEMA+"."+NotaCreditoPuntoVentaConstantesFunciones.TABLENAME+".hora,"+NotaCreditoPuntoVentaConstantesFunciones.SCHEMA+"."+NotaCreditoPuntoVentaConstantesFunciones.TABLENAME+".total_iva,"+NotaCreditoPuntoVentaConstantesFunciones.SCHEMA+"."+NotaCreditoPuntoVentaConstantesFunciones.TABLENAME+".total_sin_iva,"+NotaCreditoPuntoVentaConstantesFunciones.SCHEMA+"."+NotaCreditoPuntoVentaConstantesFunciones.TABLENAME+".iva,"+NotaCreditoPuntoVentaConstantesFunciones.SCHEMA+"."+NotaCreditoPuntoVentaConstantesFunciones.TABLENAME+".descuento,"+NotaCreditoPuntoVentaConstantesFunciones.SCHEMA+"."+NotaCreditoPuntoVentaConstantesFunciones.TABLENAME+".financiamiento,"+NotaCreditoPuntoVentaConstantesFunciones.SCHEMA+"."+NotaCreditoPuntoVentaConstantesFunciones.TABLENAME+".flete,"+NotaCreditoPuntoVentaConstantesFunciones.SCHEMA+"."+NotaCreditoPuntoVentaConstantesFunciones.TABLENAME+".ice,"+NotaCreditoPuntoVentaConstantesFunciones.SCHEMA+"."+NotaCreditoPuntoVentaConstantesFunciones.TABLENAME+".otros,"+NotaCreditoPuntoVentaConstantesFunciones.SCHEMA+"."+NotaCreditoPuntoVentaConstantesFunciones.TABLENAME+".sub_total,"+NotaCreditoPuntoVentaConstantesFunciones.SCHEMA+"."+NotaCreditoPuntoVentaConstantesFunciones.TABLENAME+".total from "+NotaCreditoPuntoVentaConstantesFunciones.SCHEMA+"."+NotaCreditoPuntoVentaConstantesFunciones.TABLENAME;//+" as "+NotaCreditoPuntoVentaConstantesFunciones.TABLENAME;
	public static String QUERYSELECTNATIVEFORFOREINGKEY="select "+NotaCreditoPuntoVentaConstantesFunciones.SCHEMA+"."+NotaCreditoPuntoVentaConstantesFunciones.TABLENAME+".id,"+NotaCreditoPuntoVentaConstantesFunciones.SCHEMA+"."+NotaCreditoPuntoVentaConstantesFunciones.TABLENAME+".version_row,"+NotaCreditoPuntoVentaConstantesFunciones.SCHEMA+"."+NotaCreditoPuntoVentaConstantesFunciones.TABLENAME+".numero_secuencial from "+NotaCreditoPuntoVentaConstantesFunciones.SCHEMA+"."+NotaCreditoPuntoVentaConstantesFunciones.TABLENAME;//+" as "+NotaCreditoPuntoVentaConstantesFunciones.TABLENAME;
	
	//MYSQL
	public static String QUERYINSERT_MYSQL="insert into "+NotaCreditoPuntoVentaConstantesFunciones.SCHEMA+"."+NotaCreditoPuntoVentaConstantesFunciones.TABLENAME+" set version_row=current_timestamp,id_empresa=?,id_sucursal=?,id_usuario=?,id_vendedor=?,id_cliente=?,id_caja=?,id_asiento_contable=?,id_tipo_precio=?,id_mesa=?,id_formato=?,id_tipo_factura_punto_venta=?,id_estado_nota_credito_punto_venta=?,numero_secuencial=?,codigo_cliente=?,nombre_cliente=?,tarjeta_cliente=?,direccion_cliente=?,telefono_cliente=?,fecha=?,hora=?,total_iva=?,total_sin_iva=?,iva=?,descuento=?,financiamiento=?,flete=?,ice=?,otros=?,sub_total=?,total=?";
	
	public static String STOREPROCEDUREINSERT="call SP_NOTACREDITOPUNTOVENTA_INSERT(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static String STOREPROCEDUREUPDATE="call SP_NOTACREDITOPUNTOVENTA_UPDATE(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,? ,? ,?,?)";
	public static String STOREPROCEDUREDELETE="call SP_NOTACREDITOPUNTOVENTA_DELETE(?,?)";
	public static String STOREPROCEDURESELECT="call SP_NOTACREDITOPUNTOVENTA_SELECT(?,?)";
	
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
	
	
	protected NotaCreditoPuntoVentaDataAccessAdditional notacreditopuntoventaDataAccessAdditional=null;
	
	public NotaCreditoPuntoVentaDataAccessAdditional getNotaCreditoPuntoVentaDataAccessAdditional() {
		return this.notacreditopuntoventaDataAccessAdditional;
	}
	
	public void setNotaCreditoPuntoVentaDataAccessAdditional(NotaCreditoPuntoVentaDataAccessAdditional notacreditopuntoventaDataAccessAdditional) {
		try {
			this.notacreditopuntoventaDataAccessAdditional=notacreditopuntoventaDataAccessAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	public NotaCreditoPuntoVentaDataAccess() {
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
		NotaCreditoPuntoVentaDataAccess.TABLENAME = sTABLENAME;
	}
	
	public static String getSCHEMA() {
		return SCHEMA;
	}

	public static void setSCHEMA(String aSCHEMA) {
		NotaCreditoPuntoVentaDataAccess.SCHEMA = aSCHEMA;
	}				
	
	
	public static Boolean getISDELETECASCADE() {
		return ISDELETECASCADE;
	}

	public static void setISDELETECASCADE(Boolean ANISDELETECASCADE) {
		NotaCreditoPuntoVentaDataAccess.ISDELETECASCADE = ANISDELETECASCADE;
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
	
	public void setNotaCreditoPuntoVentaOriginal(NotaCreditoPuntoVenta notacreditopuntoventa)throws Exception  {
		notacreditopuntoventa.setNotaCreditoPuntoVentaOriginal((NotaCreditoPuntoVenta)notacreditopuntoventa.clone());		
	}
	
	public void setNotaCreditoPuntoVentasOriginal(List<NotaCreditoPuntoVenta> notacreditopuntoventas)throws Exception  {
		
		for(NotaCreditoPuntoVenta notacreditopuntoventa:notacreditopuntoventas){
			notacreditopuntoventa.setNotaCreditoPuntoVentaOriginal((NotaCreditoPuntoVenta)notacreditopuntoventa.clone());
		}
	}
	
	public static void setNotaCreditoPuntoVentaOriginalStatic(NotaCreditoPuntoVenta notacreditopuntoventa)throws Exception  {
		notacreditopuntoventa.setNotaCreditoPuntoVentaOriginal((NotaCreditoPuntoVenta)notacreditopuntoventa.clone());		
	}
	
	public static void setNotaCreditoPuntoVentasOriginalStatic(List<NotaCreditoPuntoVenta> notacreditopuntoventas)throws Exception  {
		
		for(NotaCreditoPuntoVenta notacreditopuntoventa:notacreditopuntoventas){
			notacreditopuntoventa.setNotaCreditoPuntoVentaOriginal((NotaCreditoPuntoVenta)notacreditopuntoventa.clone());
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
	
	public  NotaCreditoPuntoVenta getEntity(Connexion connexion, Long id) throws SQLException,Exception {
		NotaCreditoPuntoVenta entity = new NotaCreditoPuntoVenta();		
		
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
	
	public  NotaCreditoPuntoVenta getEntityJdbc(Connexion connexion, Long id) throws SQLException,Exception {
		NotaCreditoPuntoVenta entity = new NotaCreditoPuntoVenta();		
		
        try {     		
			String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=NotaCreditoPuntoVentaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=NotaCreditoPuntoVentaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuerySelect + " WHERE id="+id);
            }
			
      		ResultSet resultSet = statement.executeQuery(sQuerySelect + " WHERE id="+id);//PuntoVenta.NotaCreditoPuntoVenta.isActive=1 AND
      	    			
      	    if(resultSet.next()) {				
				entity.setNotaCreditoPuntoVentaOriginal(new NotaCreditoPuntoVenta());
      	    	entity=super.getEntity("",entity,resultSet,NotaCreditoPuntoVentaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityNotaCreditoPuntoVenta("",entity,resultSet); 
				
				//entity.setNotaCreditoPuntoVentaOriginal(super.getEntity("",entity.getNotaCreditoPuntoVentaOriginal(),resultSet,NotaCreditoPuntoVentaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setNotaCreditoPuntoVentaOriginal(this.getEntityNotaCreditoPuntoVenta("",entity.getNotaCreditoPuntoVentaOriginal(),resultSet));
      	    } else {
				entity =null;
			}
			
			if(entity!=null) {
				this.setIsNewIsChangedFalseNotaCreditoPuntoVenta(entity);
			}
			
      		statement.close();     
	
      	} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;
    }
	
	
	public  NotaCreditoPuntoVenta getEntity(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		NotaCreditoPuntoVenta entity = new NotaCreditoPuntoVenta();
				
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
	
	public  NotaCreditoPuntoVenta getEntityJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		NotaCreditoPuntoVenta entity = new NotaCreditoPuntoVenta();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!this.isForForeingKeyData) {
				sQuerySelect=NotaCreditoPuntoVentaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=NotaCreditoPuntoVentaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,NotaCreditoPuntoVentaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//PuntoVenta.NotaCreditoPuntoVenta.isActive=1
        	 
			if(resultSet.next()) {				
				entity.setNotaCreditoPuntoVentaOriginal(new NotaCreditoPuntoVenta());
      	    	entity=super.getEntity("",entity,resultSet,NotaCreditoPuntoVentaDataAccess.ISWITHSCHEMA);         	    
      	    	entity=this.getEntityNotaCreditoPuntoVenta("",entity,resultSet);    
				
				//entity.setNotaCreditoPuntoVentaOriginal(super.getEntity("",entity.getNotaCreditoPuntoVentaOriginal(),resultSet,NotaCreditoPuntoVentaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setNotaCreditoPuntoVentaOriginal(this.getEntityNotaCreditoPuntoVenta("",entity.getNotaCreditoPuntoVentaOriginal(),resultSet));
      	    } else {
				entity =null;
			}

			if(entity!=null) {
				this.setIsNewIsChangedFalseNotaCreditoPuntoVenta(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }

	
	
	
	//PARA SQL ESCALAR O QUE TRAIGA 1 FILA Y POCOS CAMPOS
	public DatoGeneralMinimo getEntityDatoGeneralMinimoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws SQLException,Exception { //NotaCreditoPuntoVenta
		DatoGeneralMinimo datoGeneralMinimo= new DatoGeneralMinimo();
		
		NotaCreditoPuntoVenta entity = new NotaCreditoPuntoVenta();
				
        try  {			
			String sQuery="";
      	    String sQuerySelect="";
			
			Statement statement = connexion.getConnection().createStatement();			
			
			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();
				
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=NotaCreditoPuntoVentaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=NotaCreditoPuntoVentaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
      	    sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,NotaCreditoPuntoVentaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
      	  	ResultSet resultSet = statement.executeQuery(sQuery);//PuntoVenta.NotaCreditoPuntoVenta.isActive=1
        	 
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
				//this.setIsNewIsChangedFalseNotaCreditoPuntoVenta(entity);
			}
			
      	    statement.close(); 
		
		} 
		catch(Exception e) {
			throw e;
      	}
		
    	//return entity;	
		
		return datoGeneralMinimo;
    }
	
	
	
	public  List<NotaCreditoPuntoVenta> getEntities(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<NotaCreditoPuntoVenta> entities = new  ArrayList<NotaCreditoPuntoVenta>();
		NotaCreditoPuntoVenta entity = new NotaCreditoPuntoVenta();		  
		
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
	
	public  List<NotaCreditoPuntoVenta> getEntitiesJdbc(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters) throws Exception {
		List<NotaCreditoPuntoVenta> entities = new  ArrayList<NotaCreditoPuntoVenta>();
		NotaCreditoPuntoVenta entity = new NotaCreditoPuntoVenta();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!this.isForForeingKeyData) {
				sQuerySelect=NotaCreditoPuntoVentaDataAccess.QUERYSELECTNATIVE;
			} else {
				sQuerySelect=NotaCreditoPuntoVentaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,NotaCreditoPuntoVentaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet= statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new NotaCreditoPuntoVenta();
      	    	entity=super.getEntity("",entity,resultSet,NotaCreditoPuntoVentaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityNotaCreditoPuntoVenta("",entity,resultSet);
      	    	
				//entity.setNotaCreditoPuntoVentaOriginal( new NotaCreditoPuntoVenta());
      	    	//entity.setNotaCreditoPuntoVentaOriginal(super.getEntity("",entity.getNotaCreditoPuntoVentaOriginal(),resultSet,NotaCreditoPuntoVentaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setNotaCreditoPuntoVentaOriginal(this.getEntityNotaCreditoPuntoVenta("",entity.getNotaCreditoPuntoVentaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseNotaCreditoPuntoVentas(entities);			
			
			statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarNotaCreditoPuntoVenta(connexion,sQuery,queryWhereSelectParameters);
			}			
      	        
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<NotaCreditoPuntoVenta> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<NotaCreditoPuntoVenta> entities = new  ArrayList<NotaCreditoPuntoVenta>();
		NotaCreditoPuntoVenta entity = new NotaCreditoPuntoVenta();		  
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
	
	public  List<NotaCreditoPuntoVenta> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		List<NotaCreditoPuntoVenta> entities = new  ArrayList<NotaCreditoPuntoVenta>();
		NotaCreditoPuntoVenta entity = new NotaCreditoPuntoVenta();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new NotaCreditoPuntoVenta();
				
				if(conMapGenerico) {
					entity.inicializarMapNotaCreditoPuntoVenta();
					//entity.setMapNotaCreditoPuntoVenta(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {						
						entity.setMapNotaCreditoPuntoVentaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapNotaCreditoPuntoVenta().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,NotaCreditoPuntoVentaDataAccess.ISWITHSCHEMA);         		
					entity=NotaCreditoPuntoVentaDataAccess.getEntityNotaCreditoPuntoVenta("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setNotaCreditoPuntoVentaOriginal( new NotaCreditoPuntoVenta());
					////entity.setNotaCreditoPuntoVentaOriginal(super.getEntity("",entity.getNotaCreditoPuntoVentaOriginal(),resultSet,NotaCreditoPuntoVentaDataAccess.ISWITHSCHEMA));         		
					////entity.setNotaCreditoPuntoVentaOriginal(this.getEntityNotaCreditoPuntoVenta("",entity.getNotaCreditoPuntoVentaOriginal(),resultSet));
				}
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseNotaCreditoPuntoVentas(entities);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarNotaCreditoPuntoVenta(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	public NotaCreditoPuntoVenta getEntity(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		NotaCreditoPuntoVenta entity = new NotaCreditoPuntoVenta();		  
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
	
	public  NotaCreditoPuntoVenta getEntityJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters,List<String> listColumns,DeepLoadType deepLoadType,Boolean conMapGenerico) throws SQLException,Exception {
		NotaCreditoPuntoVenta entity = new NotaCreditoPuntoVenta();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new NotaCreditoPuntoVenta();
				
				if(conMapGenerico) {
					entity.inicializarMapNotaCreditoPuntoVenta();
					//entity.setMapNotaCreditoPuntoVenta(new HashMap<String,Object>());
					
					for(String sColumn:listColumns) {
						entity.setMapNotaCreditoPuntoVentaValue(sColumn, resultSet.getObject(sColumn));
						//entity.getMapNotaCreditoPuntoVenta().put(sColumn, resultSet.getObject(sColumn));
					}
				} else {				
					//entity=super.getEntity("",entity,resultSet,NotaCreditoPuntoVentaDataAccess.ISWITHSCHEMA);         		
					entity=NotaCreditoPuntoVentaDataAccess.getEntityNotaCreditoPuntoVenta("",entity,resultSet,listColumns,deepLoadType);
					
					////entity.setNotaCreditoPuntoVentaOriginal( new NotaCreditoPuntoVenta());
					////entity.setNotaCreditoPuntoVentaOriginal(super.getEntity("",entity.getNotaCreditoPuntoVentaOriginal(),resultSet,NotaCreditoPuntoVentaDataAccess.ISWITHSCHEMA));         		
					////entity.setNotaCreditoPuntoVentaOriginal(this.getEntityNotaCreditoPuntoVenta("",entity.getNotaCreditoPuntoVentaOriginal(),resultSet));
				}
				
      	    	//entities.add(entity);								
      	    }

			this.setIsNewIsChangedFalseNotaCreditoPuntoVenta(entity);
			
      	    statement.close();  
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarNotaCreditoPuntoVenta(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static NotaCreditoPuntoVenta getEntityNotaCreditoPuntoVenta(String strPrefijo,NotaCreditoPuntoVenta entity,ResultSet resultSet,List<String> listColumns,DeepLoadType deepLoadType) throws Exception {		
        try {     	  
			if(deepLoadType.equals(DeepLoadType.NONE) || deepLoadType.equals(DeepLoadType.INCLUDE)) {
				for(String sColumn:listColumns) {	        	
					Field field =null;
					try {
						field = NotaCreditoPuntoVenta.class.getDeclaredField(sColumn);//getField
						field.setAccessible(true);
						
					} catch(Exception e) {
						field = NotaCreditoPuntoVenta.class.getSuperclass().getDeclaredField(sColumn);//getField
						field.setAccessible(true);
					}
					
					NotaCreditoPuntoVentaDataAccess.setFieldReflectionNotaCreditoPuntoVenta(field,strPrefijo,sColumn,entity,resultSet);
					//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
				}  
			
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
				List<String> listTiposColumnasNotaCreditoPuntoVenta=NotaCreditoPuntoVentaConstantesFunciones.getTodosTiposColumnasNotaCreditoPuntoVenta();
				Boolean existe=false;
				
				for(String sColumn:listTiposColumnasNotaCreditoPuntoVenta) {
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
							field = NotaCreditoPuntoVenta.class.getDeclaredField(sColumn);//getField
							field.setAccessible(true);
							
						} catch(Exception e) {
							field = NotaCreditoPuntoVenta.class.getSuperclass().getDeclaredField(sColumn);//getField
							field.setAccessible(true);
						}
						
						NotaCreditoPuntoVentaDataAccess.setFieldReflectionNotaCreditoPuntoVenta(field,strPrefijo,sColumn,entity,resultSet);
						//field.set(entity, resultSet.getLong(strPrefijo+"id_opcion"));
					}
				}
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public  static void setFieldReflectionNotaCreditoPuntoVenta(Field field,String strPrefijo,String sColumn,NotaCreditoPuntoVenta entity,ResultSet resultSet) throws Exception {		
        try {    
        	String sCampo=strPrefijo+sColumn;
        	
        	switch(sColumn) {
				
				case NotaCreditoPuntoVentaConstantesFunciones.ID:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case NotaCreditoPuntoVentaConstantesFunciones.VERSIONROW:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case NotaCreditoPuntoVentaConstantesFunciones.IDEMPRESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case NotaCreditoPuntoVentaConstantesFunciones.IDSUCURSAL:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case NotaCreditoPuntoVentaConstantesFunciones.IDUSUARIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case NotaCreditoPuntoVentaConstantesFunciones.IDVENDEDOR:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case NotaCreditoPuntoVentaConstantesFunciones.IDCLIENTE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case NotaCreditoPuntoVentaConstantesFunciones.IDCAJA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case NotaCreditoPuntoVentaConstantesFunciones.IDASIENTOCONTABLE:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case NotaCreditoPuntoVentaConstantesFunciones.IDTIPOPRECIO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case NotaCreditoPuntoVentaConstantesFunciones.IDMESA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case NotaCreditoPuntoVentaConstantesFunciones.IDFORMATO:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case NotaCreditoPuntoVentaConstantesFunciones.IDTIPOFACTURAPUNTOVENTA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case NotaCreditoPuntoVentaConstantesFunciones.IDESTADONOTACREDITOPUNTOVENTA:
					field.set(entity,resultSet.getLong(sCampo));
					break;
				
				case NotaCreditoPuntoVentaConstantesFunciones.NUMEROSECUENCIAL:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case NotaCreditoPuntoVentaConstantesFunciones.CODIGOCLIENTE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case NotaCreditoPuntoVentaConstantesFunciones.NOMBRECLIENTE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case NotaCreditoPuntoVentaConstantesFunciones.TARJETACLIENTE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case NotaCreditoPuntoVentaConstantesFunciones.DIRECCIONCLIENTE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case NotaCreditoPuntoVentaConstantesFunciones.TELEFONOCLIENTE:
					field.set(entity,resultSet.getString(sCampo));
					break;
				
				case NotaCreditoPuntoVentaConstantesFunciones.FECHA:
					field.set(entity,new Date(resultSet.getDate(sCampo).getTime()));
					break;
				
				case NotaCreditoPuntoVentaConstantesFunciones.HORA:
					field.set(entity,resultSet.getTime(sCampo));
					break;
				
				case NotaCreditoPuntoVentaConstantesFunciones.TOTALIVA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case NotaCreditoPuntoVentaConstantesFunciones.TOTALSINIVA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case NotaCreditoPuntoVentaConstantesFunciones.IVA:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case NotaCreditoPuntoVentaConstantesFunciones.DESCUENTO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case NotaCreditoPuntoVentaConstantesFunciones.FINANCIAMIENTO:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case NotaCreditoPuntoVentaConstantesFunciones.FLETE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case NotaCreditoPuntoVentaConstantesFunciones.ICE:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case NotaCreditoPuntoVentaConstantesFunciones.OTROS:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case NotaCreditoPuntoVentaConstantesFunciones.SUBTOTAL:
					field.set(entity,resultSet.getDouble(sCampo));
					break;
				
				case NotaCreditoPuntoVentaConstantesFunciones.TOTAL:
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
	
	
	public ArrayList<DatoGeneralMaximo> getEntitiesDatoGeneralMaximoGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<NotaCreditoPuntoVenta>
		ArrayList<DatoGeneralMaximo> datoGeneralMaximos = new ArrayList<DatoGeneralMaximo>();
		DatoGeneralMaximo datoGeneralMaximo=new DatoGeneralMaximo();
		
		List<NotaCreditoPuntoVenta> entities = new  ArrayList<NotaCreditoPuntoVenta>();
		NotaCreditoPuntoVenta entity = new NotaCreditoPuntoVenta();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=NotaCreditoPuntoVentaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=NotaCreditoPuntoVentaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,NotaCreditoPuntoVentaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
					entity = new NotaCreditoPuntoVenta();
					entity=super.getEntity("",entity,resultSet,NotaCreditoPuntoVentaDataAccess.ISWITHSCHEMA);         		
					entity=this.getEntityNotaCreditoPuntoVenta("",entity,resultSet);
					
					//entity.setNotaCreditoPuntoVentaOriginal( new NotaCreditoPuntoVenta());
					//entity.setNotaCreditoPuntoVentaOriginal(super.getEntity("",entity.getNotaCreditoPuntoVentaOriginal(),resultSet,NotaCreditoPuntoVentaDataAccess.ISWITHSCHEMA));         		
					//entity.setNotaCreditoPuntoVentaOriginal(this.getEntityNotaCreditoPuntoVenta("",entity.getNotaCreditoPuntoVentaOriginal(),resultSet));
					
					entities.add(entity);
					*/
				}
			//}
			
			//this.setIsNewIsChangedFalseNotaCreditoPuntoVentas(entities);			
			
			statement.close(); 
			
			/*
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarNotaCreditoPuntoVenta(connexion,sQuery,queryWhereSelectParameters);
			}			
      	     */
				
		} catch(Exception e) {
			throw e;
      	}
		
    	//return entities;	
		
		return datoGeneralMaximos;
    }
	
	public ArrayList<DatoGeneral> getEntitiesDatoGeneralGenerico(Connexion connexion,QueryWhereSelectParameters queryWhereSelectParameters,ArrayList<Classe> classes) throws Exception { //List<NotaCreditoPuntoVenta>
		ArrayList<DatoGeneral> datoGenerals = new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		List<NotaCreditoPuntoVenta> entities = new  ArrayList<NotaCreditoPuntoVenta>();
		NotaCreditoPuntoVenta entity = new NotaCreditoPuntoVenta();		  
		String sQuery="";
		String sQuerySelect="";
		
        try { 
			
			Statement statement = connexion.getConnection().createStatement();	

			if(!queryWhereSelectParameters.getSelectQuery().equals("")) {			
				sQuerySelect=queryWhereSelectParameters.getSelectQuery();				
			
			} else {
				if(!this.isForForeingKeyData) {
					sQuerySelect=NotaCreditoPuntoVentaDataAccess.QUERYSELECTNATIVE;
				} else {
					sQuerySelect=NotaCreditoPuntoVentaDataAccess.QUERYSELECTNATIVEFORFOREINGKEY;
				}
			}
			
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,NotaCreditoPuntoVentaDataAccess.TABLENAME+".",queryWhereSelectParameters,sQuerySelect);
			
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
	
	
	public  List<NotaCreditoPuntoVenta> getEntities(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<NotaCreditoPuntoVenta> entities = new  ArrayList<NotaCreditoPuntoVenta>();
		NotaCreditoPuntoVenta entity = new NotaCreditoPuntoVenta();		  
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
	
	public  List<NotaCreditoPuntoVenta> getEntitiesJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<NotaCreditoPuntoVenta> entities = new  ArrayList<NotaCreditoPuntoVenta>();
		NotaCreditoPuntoVenta entity = new NotaCreditoPuntoVenta();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesJDBC(entity,queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new NotaCreditoPuntoVenta();
      	    	entity=super.getEntity("",entity,resultSet,NotaCreditoPuntoVentaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityNotaCreditoPuntoVenta("",entity,resultSet);
      	    	
				//entity.setNotaCreditoPuntoVentaOriginal( new NotaCreditoPuntoVenta());
      	    	//entity.setNotaCreditoPuntoVentaOriginal(super.getEntity("",entity.getNotaCreditoPuntoVentaOriginal(),resultSet,NotaCreditoPuntoVentaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setNotaCreditoPuntoVentaOriginal(this.getEntityNotaCreditoPuntoVenta("",entity.getNotaCreditoPuntoVentaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }
			
			this.setIsNewIsChangedFalseNotaCreditoPuntoVentas(entities);
			
      	    statement.close(); 
			
			if(this.datosCliente.getIsConExportar()) {
				this.generarExportarNotaCreditoPuntoVenta(connexion,sQuery,queryWhereSelectParameters);
			}
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public  List<NotaCreditoPuntoVenta> getEntitiesSimpleQueryBuild(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<NotaCreditoPuntoVenta> entities = new  ArrayList<NotaCreditoPuntoVenta>();
		NotaCreditoPuntoVenta entity = new NotaCreditoPuntoVenta();		  
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
	
	public  List<NotaCreditoPuntoVenta> getEntitiesSimpleQueryBuildJdbc(Connexion connexion,String sQuerySelect,QueryWhereSelectParameters queryWhereSelectParameters) throws SQLException,Exception {
		List<NotaCreditoPuntoVenta> entities = new  ArrayList<NotaCreditoPuntoVenta>();
		NotaCreditoPuntoVenta entity = new NotaCreditoPuntoVenta();		  
		String sQuery="";
	
        try {
			Statement statement = connexion.getConnection().createStatement();
							
			sQuery=DataAccessHelper.buildSqlGeneralGetEntitiesSimpleQueryBuildJDBC(queryWhereSelectParameters,sQuerySelect);
			
			if(Constantes2.ISDEVELOPING_SQL)  {
            	Funciones2.mostrarMensajeDeveloping(sQuery);
            }
			
			ResultSet resultSet = statement.executeQuery(sQuery);
        	 
      	    while (resultSet.next()) {
      	    	entity = new NotaCreditoPuntoVenta();
      	    	entity=super.getEntity("",entity,resultSet,NotaCreditoPuntoVentaDataAccess.ISWITHSCHEMA);         		
      	    	entity=this.getEntityNotaCreditoPuntoVenta("",entity,resultSet);
      	    	
				//entity.setNotaCreditoPuntoVentaOriginal( new NotaCreditoPuntoVenta());
      	    	//entity.setNotaCreditoPuntoVentaOriginal(super.getEntity("",entity.getNotaCreditoPuntoVentaOriginal(),resultSet,NotaCreditoPuntoVentaDataAccess.ISWITHSCHEMA));         		
      	    	//entity.setNotaCreditoPuntoVentaOriginal(this.getEntityNotaCreditoPuntoVenta("",entity.getNotaCreditoPuntoVentaOriginal(),resultSet));
				
      	    	entities.add(entity);
      	    }

			this.setIsNewIsChangedFalseNotaCreditoPuntoVentas(entities);
			
      	    statement.close();      
		} catch(Exception e) {
			throw e;
      	}
		
    	return entities;	
    }
	
	
	
	public NotaCreditoPuntoVenta getEntityNotaCreditoPuntoVenta(String strPrefijo,NotaCreditoPuntoVenta entity,ResultSet resultSet) throws Exception {		
        try { 
			
			if(!this.isForForeingKeyData) {
				entity.setid_empresa(resultSet.getLong(strPrefijo+NotaCreditoPuntoVentaConstantesFunciones.IDEMPRESA));
				entity.setid_sucursal(resultSet.getLong(strPrefijo+NotaCreditoPuntoVentaConstantesFunciones.IDSUCURSAL));
				entity.setid_usuario(resultSet.getLong(strPrefijo+NotaCreditoPuntoVentaConstantesFunciones.IDUSUARIO));
				entity.setid_vendedor(resultSet.getLong(strPrefijo+NotaCreditoPuntoVentaConstantesFunciones.IDVENDEDOR));
				entity.setid_cliente(resultSet.getLong(strPrefijo+NotaCreditoPuntoVentaConstantesFunciones.IDCLIENTE));
				entity.setid_caja(resultSet.getLong(strPrefijo+NotaCreditoPuntoVentaConstantesFunciones.IDCAJA));
				entity.setid_asiento_contable(resultSet.getLong(strPrefijo+NotaCreditoPuntoVentaConstantesFunciones.IDASIENTOCONTABLE));if(resultSet.wasNull()) {entity.setid_asiento_contable(null); }
				entity.setid_tipo_precio(resultSet.getLong(strPrefijo+NotaCreditoPuntoVentaConstantesFunciones.IDTIPOPRECIO));
				entity.setid_mesa(resultSet.getLong(strPrefijo+NotaCreditoPuntoVentaConstantesFunciones.IDMESA));
				entity.setid_formato(resultSet.getLong(strPrefijo+NotaCreditoPuntoVentaConstantesFunciones.IDFORMATO));
				entity.setid_tipo_factura_punto_venta(resultSet.getLong(strPrefijo+NotaCreditoPuntoVentaConstantesFunciones.IDTIPOFACTURAPUNTOVENTA));
				entity.setid_estado_nota_credito_punto_venta(resultSet.getLong(strPrefijo+NotaCreditoPuntoVentaConstantesFunciones.IDESTADONOTACREDITOPUNTOVENTA));
				entity.setnumero_secuencial(resultSet.getString(strPrefijo+NotaCreditoPuntoVentaConstantesFunciones.NUMEROSECUENCIAL));
				entity.setcodigo_cliente(resultSet.getString(strPrefijo+NotaCreditoPuntoVentaConstantesFunciones.CODIGOCLIENTE));
				entity.setnombre_cliente(resultSet.getString(strPrefijo+NotaCreditoPuntoVentaConstantesFunciones.NOMBRECLIENTE));
				entity.settarjeta_cliente(resultSet.getString(strPrefijo+NotaCreditoPuntoVentaConstantesFunciones.TARJETACLIENTE));
				entity.setdireccion_cliente(resultSet.getString(strPrefijo+NotaCreditoPuntoVentaConstantesFunciones.DIRECCIONCLIENTE));
				entity.settelefono_cliente(resultSet.getString(strPrefijo+NotaCreditoPuntoVentaConstantesFunciones.TELEFONOCLIENTE));
				entity.setfecha(new Date(resultSet.getDate(strPrefijo+NotaCreditoPuntoVentaConstantesFunciones.FECHA).getTime()));
				entity.sethora(resultSet.getTime(strPrefijo+NotaCreditoPuntoVentaConstantesFunciones.HORA));
				entity.settotal_iva(resultSet.getDouble(strPrefijo+NotaCreditoPuntoVentaConstantesFunciones.TOTALIVA));
				entity.settotal_sin_iva(resultSet.getDouble(strPrefijo+NotaCreditoPuntoVentaConstantesFunciones.TOTALSINIVA));
				entity.setiva(resultSet.getDouble(strPrefijo+NotaCreditoPuntoVentaConstantesFunciones.IVA));
				entity.setdescuento(resultSet.getDouble(strPrefijo+NotaCreditoPuntoVentaConstantesFunciones.DESCUENTO));
				entity.setfinanciamiento(resultSet.getDouble(strPrefijo+NotaCreditoPuntoVentaConstantesFunciones.FINANCIAMIENTO));
				entity.setflete(resultSet.getDouble(strPrefijo+NotaCreditoPuntoVentaConstantesFunciones.FLETE));
				entity.setice(resultSet.getDouble(strPrefijo+NotaCreditoPuntoVentaConstantesFunciones.ICE));
				entity.setotros(resultSet.getDouble(strPrefijo+NotaCreditoPuntoVentaConstantesFunciones.OTROS));
				entity.setsub_total(resultSet.getDouble(strPrefijo+NotaCreditoPuntoVentaConstantesFunciones.SUBTOTAL));
				entity.settotal(resultSet.getDouble(strPrefijo+NotaCreditoPuntoVentaConstantesFunciones.TOTAL));
			} else {
				entity.setnumero_secuencial(resultSet.getString(strPrefijo+NotaCreditoPuntoVentaConstantesFunciones.NUMEROSECUENCIAL));  
			}
      	} catch(Exception e) {
			throw e;
      	}
		
    	return entity;	
    }
	
	public Timestamp getSetVersionRowNotaCreditoPuntoVenta(Connexion connexion, Long id) throws SQLException,Exception {
		Timestamp timestampVersionRow=null;
						
        try {     		
			if(connexion.getConnexionType().equals(ConnexionType.HIBERNATE)) {
			}
							
      	} catch(Exception e) {
			throw e;
      	}
		
    	return timestampVersionRow;
    }
	
	public static void save(NotaCreditoPuntoVenta entity,Connexion connexion)throws SQLException,Exception {	
		try {
			ParametersType parametersType=null;
			String sQuerySave="";
			
			if (entity.getIsDeleted()) {
				parametersType=ParametersType.DELETE;
				sQuerySave=NotaCreditoPuntoVentaDataAccess.QUERYDELETE;
				
			} else if (entity.getIsChanged()) {
				if(entity.getIsNew()) {
					parametersType=ParametersType.INSERT;
					sQuerySave=NotaCreditoPuntoVentaDataAccess.QUERYINSERT;
				} else {
					parametersType=ParametersType.UPDATE;
					sQuerySave=NotaCreditoPuntoVentaDataAccess.QUERYUPDATE;
				}
				
			} 
			
			ParametersMaintenance parametersMaintenance=new ParametersMaintenance();
			
			if(connexion.getConnexionType().equals(ConnexionType.JDBC32)) {
				parametersMaintenance=NotaCreditoPuntoVentaDataAccess.buildParametersMaintenance(connexion.getDbType(), parametersType, entity);
			}
			connexion.setFuncionAuxiliar(NotaCreditoPuntoVentaConstantesFunciones.SQL_SECUENCIAL);
			
			DataAccessHelper.save(entity, connexion,parametersMaintenance,sQuerySave,NotaCreditoPuntoVentaDataAccess.TABLENAME,NotaCreditoPuntoVentaDataAccess.ISWITHSTOREPROCEDURES);
			
			NotaCreditoPuntoVentaDataAccess.setNotaCreditoPuntoVentaOriginalStatic(entity);
			
		} catch(Exception e) {
            throw e;
        }
	}
	
	
		public Empresa getEmpresa(Connexion connexion,NotaCreditoPuntoVenta relnotacreditopuntoventa)throws SQLException,Exception {

		Empresa empresa= new Empresa();

		try {
			EmpresaDataAccess empresaDataAccess=new EmpresaDataAccess();

			empresaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			empresaDataAccess.setConnexionType(this.connexionType);
			empresaDataAccess.setParameterDbType(this.parameterDbType);

			empresa=empresaDataAccess.getEntity(connexion,relnotacreditopuntoventa.getid_empresa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return empresa;

	}

	public Sucursal getSucursal(Connexion connexion,NotaCreditoPuntoVenta relnotacreditopuntoventa)throws SQLException,Exception {

		Sucursal sucursal= new Sucursal();

		try {
			SucursalDataAccess sucursalDataAccess=new SucursalDataAccess();

			sucursalDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			sucursalDataAccess.setConnexionType(this.connexionType);
			sucursalDataAccess.setParameterDbType(this.parameterDbType);

			sucursal=sucursalDataAccess.getEntity(connexion,relnotacreditopuntoventa.getid_sucursal());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return sucursal;

	}

	public Usuario getUsuario(Connexion connexion,NotaCreditoPuntoVenta relnotacreditopuntoventa)throws SQLException,Exception {

		Usuario usuario= new Usuario();

		try {
			UsuarioDataAccess usuarioDataAccess=new UsuarioDataAccess();

			usuarioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			usuarioDataAccess.setConnexionType(this.connexionType);
			usuarioDataAccess.setParameterDbType(this.parameterDbType);

			usuario=usuarioDataAccess.getEntity(connexion,relnotacreditopuntoventa.getid_usuario());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return usuario;

	}

	public Vendedor getVendedor(Connexion connexion,NotaCreditoPuntoVenta relnotacreditopuntoventa)throws SQLException,Exception {

		Vendedor vendedor= new Vendedor();

		try {
			VendedorDataAccess vendedorDataAccess=new VendedorDataAccess();

			vendedorDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			vendedorDataAccess.setConnexionType(this.connexionType);
			vendedorDataAccess.setParameterDbType(this.parameterDbType);

			vendedor=vendedorDataAccess.getEntity(connexion,relnotacreditopuntoventa.getid_vendedor());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return vendedor;

	}

	public Cliente getCliente(Connexion connexion,NotaCreditoPuntoVenta relnotacreditopuntoventa)throws SQLException,Exception {

		Cliente cliente= new Cliente();

		try {
			ClienteDataAccess clienteDataAccess=new ClienteDataAccess();

			clienteDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			clienteDataAccess.setConnexionType(this.connexionType);
			clienteDataAccess.setParameterDbType(this.parameterDbType);

			cliente=clienteDataAccess.getEntity(connexion,relnotacreditopuntoventa.getid_cliente());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return cliente;

	}

	public Caja getCaja(Connexion connexion,NotaCreditoPuntoVenta relnotacreditopuntoventa)throws SQLException,Exception {

		Caja caja= new Caja();

		try {
			CajaDataAccess cajaDataAccess=new CajaDataAccess();

			cajaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			cajaDataAccess.setConnexionType(this.connexionType);
			cajaDataAccess.setParameterDbType(this.parameterDbType);

			caja=cajaDataAccess.getEntity(connexion,relnotacreditopuntoventa.getid_caja());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return caja;

	}

	public AsientoContable getAsientoContable(Connexion connexion,NotaCreditoPuntoVenta relnotacreditopuntoventa)throws SQLException,Exception {

		AsientoContable asientocontable= new AsientoContable();

		try {
			AsientoContableDataAccess asientocontableDataAccess=new AsientoContableDataAccess();

			asientocontableDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			asientocontableDataAccess.setConnexionType(this.connexionType);
			asientocontableDataAccess.setParameterDbType(this.parameterDbType);

			asientocontable=asientocontableDataAccess.getEntity(connexion,relnotacreditopuntoventa.getid_asiento_contable());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return asientocontable;

	}

	public TipoPrecio getTipoPrecio(Connexion connexion,NotaCreditoPuntoVenta relnotacreditopuntoventa)throws SQLException,Exception {

		TipoPrecio tipoprecio= new TipoPrecio();

		try {
			TipoPrecioDataAccess tipoprecioDataAccess=new TipoPrecioDataAccess();

			tipoprecioDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipoprecioDataAccess.setConnexionType(this.connexionType);
			tipoprecioDataAccess.setParameterDbType(this.parameterDbType);

			tipoprecio=tipoprecioDataAccess.getEntity(connexion,relnotacreditopuntoventa.getid_tipo_precio());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipoprecio;

	}

	public Mesa getMesa(Connexion connexion,NotaCreditoPuntoVenta relnotacreditopuntoventa)throws SQLException,Exception {

		Mesa mesa= new Mesa();

		try {
			MesaDataAccess mesaDataAccess=new MesaDataAccess();

			mesaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			mesaDataAccess.setConnexionType(this.connexionType);
			mesaDataAccess.setParameterDbType(this.parameterDbType);

			mesa=mesaDataAccess.getEntity(connexion,relnotacreditopuntoventa.getid_mesa());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return mesa;

	}

	public Formato getFormato(Connexion connexion,NotaCreditoPuntoVenta relnotacreditopuntoventa)throws SQLException,Exception {

		Formato formato= new Formato();

		try {
			FormatoDataAccess formatoDataAccess=new FormatoDataAccess();

			formatoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			formatoDataAccess.setConnexionType(this.connexionType);
			formatoDataAccess.setParameterDbType(this.parameterDbType);

			formato=formatoDataAccess.getEntity(connexion,relnotacreditopuntoventa.getid_formato());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return formato;

	}

	public TipoFacturaPuntoVenta getTipoFacturaPuntoVenta(Connexion connexion,NotaCreditoPuntoVenta relnotacreditopuntoventa)throws SQLException,Exception {

		TipoFacturaPuntoVenta tipofacturapuntoventa= new TipoFacturaPuntoVenta();

		try {
			TipoFacturaPuntoVentaDataAccess tipofacturapuntoventaDataAccess=new TipoFacturaPuntoVentaDataAccess();

			tipofacturapuntoventaDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			tipofacturapuntoventaDataAccess.setConnexionType(this.connexionType);
			tipofacturapuntoventaDataAccess.setParameterDbType(this.parameterDbType);

			tipofacturapuntoventa=tipofacturapuntoventaDataAccess.getEntity(connexion,relnotacreditopuntoventa.getid_tipo_factura_punto_venta());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return tipofacturapuntoventa;

	}

	public EstadoNotaCredito getEstadoNotaCreditoPuntoVenta(Connexion connexion,NotaCreditoPuntoVenta relnotacreditopuntoventa)throws SQLException,Exception {

		EstadoNotaCredito estadonotacredito= new EstadoNotaCredito();

		try {
			EstadoNotaCreditoDataAccess estadonotacreditoDataAccess=new EstadoNotaCreditoDataAccess();

			estadonotacreditoDataAccess.setIsForForeingKeyData(this.isForForeingsKeysDataRelationships);
			estadonotacreditoDataAccess.setConnexionType(this.connexionType);
			estadonotacreditoDataAccess.setParameterDbType(this.parameterDbType);

			estadonotacredito=estadonotacreditoDataAccess.getEntity(connexion,relnotacreditopuntoventa.getid_estado_nota_credito_punto_venta());
		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return estadonotacredito;

	}


		
		public List<DetalleNotaCreditoPuntoVenta> getDetalleNotaCreditoPuntoVentas(Connexion connexion,NotaCreditoPuntoVenta notacreditopuntoventa)throws SQLException,Exception {

		List<DetalleNotaCreditoPuntoVenta> detallenotacreditopuntoventas= new ArrayList<DetalleNotaCreditoPuntoVenta>();

		try {

			String sQuery="";

			if(this.connexionType.equals(ConnexionType.JDBC32)) {
				sQuery=" INNER JOIN "+NotaCreditoPuntoVentaConstantesFunciones.SCHEMA+".nota_credito_punto_venta ON "+DetalleNotaCreditoPuntoVentaConstantesFunciones.SCHEMA+".detalle_nota_credito_punto_venta.id_nota_credito_punto_venta="+NotaCreditoPuntoVentaConstantesFunciones.SCHEMA+".nota_credito_punto_venta.id WHERE "+NotaCreditoPuntoVentaConstantesFunciones.SCHEMA+".nota_credito_punto_venta.id="+String.valueOf(notacreditopuntoventa.getId());
			} else {
				sQuery=" INNER JOIN detallenotacreditopuntoventa.NotaCreditoPuntoVenta WHERE detallenotacreditopuntoventa.NotaCreditoPuntoVenta.id="+String.valueOf(notacreditopuntoventa.getId());

			}

			QueryWhereSelectParameters queryWhereSelectParameters=new QueryWhereSelectParameters();
			queryWhereSelectParameters.setFinalQuery(sQuery);
			DetalleNotaCreditoPuntoVentaDataAccess detallenotacreditopuntoventaDataAccess=new DetalleNotaCreditoPuntoVentaDataAccess();

			detallenotacreditopuntoventaDataAccess.setConnexionType(this.connexionType);
			detallenotacreditopuntoventaDataAccess.setParameterDbType(this.parameterDbType);
			detallenotacreditopuntoventas=detallenotacreditopuntoventaDataAccess.getEntities(connexion,queryWhereSelectParameters);

		} catch(SQLException e) {
			throw e;
		} catch(Exception e) {
			throw e;
		}

	return detallenotacreditopuntoventas;

	}


	


	
	public  static ParametersMaintenance buildParametersMaintenance(ParameterDbType newDbType,ParametersType parametersType,NotaCreditoPuntoVenta notacreditopuntoventa) throws Exception {
		ParametersMaintenance parametersMaintenance=new ParametersMaintenance();		
		
		try {
			//ParametersMaintenance parametersMaintenance=super.getParametersMaintenance();		
			ArrayList<ParameterMaintenance> parametersTemp=new ArrayList<ParameterMaintenance>();
			ParameterMaintenance parameterMaintenance;
			ParameterValue<Long> parameterMaintenanceValueId;
			Integer iOrder=1;
			
				if(!notacreditopuntoventa.getIsDeleted()) {		
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_empresa=new ParameterValue<Long>();
					parameterMaintenanceValueid_empresa.setValue(notacreditopuntoventa.getid_empresa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_empresa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_sucursal=new ParameterValue<Long>();
					parameterMaintenanceValueid_sucursal.setValue(notacreditopuntoventa.getid_sucursal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_sucursal);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_usuario=new ParameterValue<Long>();
					parameterMaintenanceValueid_usuario.setValue(notacreditopuntoventa.getid_usuario());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_usuario);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_vendedor=new ParameterValue<Long>();
					parameterMaintenanceValueid_vendedor.setValue(notacreditopuntoventa.getid_vendedor());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_vendedor);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_cliente=new ParameterValue<Long>();
					parameterMaintenanceValueid_cliente.setValue(notacreditopuntoventa.getid_cliente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_cliente);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_caja=new ParameterValue<Long>();
					parameterMaintenanceValueid_caja.setValue(notacreditopuntoventa.getid_caja());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_caja);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_asiento_contable=new ParameterValue<Long>();
					parameterMaintenanceValueid_asiento_contable.setValue(notacreditopuntoventa.getid_asiento_contable());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_asiento_contable);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_precio=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_precio.setValue(notacreditopuntoventa.getid_tipo_precio());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_precio);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_mesa=new ParameterValue<Long>();
					parameterMaintenanceValueid_mesa.setValue(notacreditopuntoventa.getid_mesa());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_mesa);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_formato=new ParameterValue<Long>();
					parameterMaintenanceValueid_formato.setValue(notacreditopuntoventa.getid_formato());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_formato);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_tipo_factura_punto_venta=new ParameterValue<Long>();
					parameterMaintenanceValueid_tipo_factura_punto_venta.setValue(notacreditopuntoventa.getid_tipo_factura_punto_venta());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_tipo_factura_punto_venta);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					ParameterValue<Long> parameterMaintenanceValueid_estado_nota_credito_punto_venta=new ParameterValue<Long>();
					parameterMaintenanceValueid_estado_nota_credito_punto_venta.setValue(notacreditopuntoventa.getid_estado_nota_credito_punto_venta());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueid_estado_nota_credito_punto_venta);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenumero_secuencial=new ParameterValue<String>();
					parameterMaintenanceValuenumero_secuencial.setValue(notacreditopuntoventa.getnumero_secuencial());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenumero_secuencial);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuecodigo_cliente=new ParameterValue<String>();
					parameterMaintenanceValuecodigo_cliente.setValue(notacreditopuntoventa.getcodigo_cliente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuecodigo_cliente);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuenombre_cliente=new ParameterValue<String>();
					parameterMaintenanceValuenombre_cliente.setValue(notacreditopuntoventa.getnombre_cliente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuenombre_cliente);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuetarjeta_cliente=new ParameterValue<String>();
					parameterMaintenanceValuetarjeta_cliente.setValue(notacreditopuntoventa.gettarjeta_cliente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetarjeta_cliente);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuedireccion_cliente=new ParameterValue<String>();
					parameterMaintenanceValuedireccion_cliente.setValue(notacreditopuntoventa.getdireccion_cliente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedireccion_cliente);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.STRING);
					ParameterValue<String> parameterMaintenanceValuetelefono_cliente=new ParameterValue<String>();
					parameterMaintenanceValuetelefono_cliente.setValue(notacreditopuntoventa.gettelefono_cliente());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetelefono_cliente);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DATE);
					ParameterValue<Date> parameterMaintenanceValuefecha=new ParameterValue<Date>();
					parameterMaintenanceValuefecha.setValue(notacreditopuntoventa.getfecha());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefecha);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.TIME);
					ParameterValue<Time> parameterMaintenanceValuehora=new ParameterValue<Time>();
					parameterMaintenanceValuehora.setValue(notacreditopuntoventa.gethora());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuehora);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuetotal_iva=new ParameterValue<Double>();
					parameterMaintenanceValuetotal_iva.setValue(notacreditopuntoventa.gettotal_iva());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetotal_iva);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuetotal_sin_iva=new ParameterValue<Double>();
					parameterMaintenanceValuetotal_sin_iva.setValue(notacreditopuntoventa.gettotal_sin_iva());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetotal_sin_iva);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueiva=new ParameterValue<Double>();
					parameterMaintenanceValueiva.setValue(notacreditopuntoventa.getiva());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueiva);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuedescuento=new ParameterValue<Double>();
					parameterMaintenanceValuedescuento.setValue(notacreditopuntoventa.getdescuento());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuedescuento);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuefinanciamiento=new ParameterValue<Double>();
					parameterMaintenanceValuefinanciamiento.setValue(notacreditopuntoventa.getfinanciamiento());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuefinanciamiento);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueflete=new ParameterValue<Double>();
					parameterMaintenanceValueflete.setValue(notacreditopuntoventa.getflete());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueflete);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueice=new ParameterValue<Double>();
					parameterMaintenanceValueice.setValue(notacreditopuntoventa.getice());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueice);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValueotros=new ParameterValue<Double>();
					parameterMaintenanceValueotros.setValue(notacreditopuntoventa.getotros());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueotros);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuesub_total=new ParameterValue<Double>();
					parameterMaintenanceValuesub_total.setValue(notacreditopuntoventa.getsub_total());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuesub_total);
					parametersTemp.add(parameterMaintenance);
					
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder++);		
					parameterMaintenance.setParameterMaintenanceType(ParameterType.DOUBLE);
					ParameterValue<Double> parameterMaintenanceValuetotal=new ParameterValue<Double>();
					parameterMaintenanceValuetotal.setValue(notacreditopuntoventa.gettotal());
					parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValuetotal);
					parametersTemp.add(parameterMaintenance);
					
						if(!notacreditopuntoventa.getIsNew()) {					
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
							parameterMaintenanceValueId=new ParameterValue<Long>();
							parameterMaintenanceValueId.setValue(notacreditopuntoventa.getId());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueId);		
							parametersTemp.add(parameterMaintenance);
							
							parameterMaintenance=new ParameterMaintenance();
							parameterMaintenance.setOrder(iOrder++);
							parameterMaintenance.setParameterMaintenanceType(ParameterType.TIMESTAMP);
							ParameterValue<Date> parameterMaintenanceValueVersionRow=new ParameterValue<Date>();
							parameterMaintenanceValueVersionRow.setValue(notacreditopuntoventa.getVersionRow());
							parameterMaintenance.setParameterMaintenanceValue(parameterMaintenanceValueVersionRow);		
							parametersTemp.add(parameterMaintenance);					
						}
				} else {
					parameterMaintenance=new ParameterMaintenance();
					parameterMaintenance.setOrder(iOrder);
					parameterMaintenance.setParameterMaintenanceType(ParameterType.LONG);
					parameterMaintenanceValueId=new ParameterValue<Long>();
					parameterMaintenanceValueId.setValue(notacreditopuntoventa.getId());
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
	
	public void setIsNewIsChangedFalseNotaCreditoPuntoVenta(NotaCreditoPuntoVenta notacreditopuntoventa)throws Exception  {		
		notacreditopuntoventa.setIsNew(false);
		notacreditopuntoventa.setIsChanged(false);		
	}
	
	public void setIsNewIsChangedFalseNotaCreditoPuntoVentas(List<NotaCreditoPuntoVenta> notacreditopuntoventas)throws Exception  {				
		for(NotaCreditoPuntoVenta notacreditopuntoventa:notacreditopuntoventas) {
			notacreditopuntoventa.setIsNew(false);
			notacreditopuntoventa.setIsChanged(false);
		}
	}
	
	public void generarExportarNotaCreditoPuntoVenta(Connexion connexion,String sQuery,QueryWhereSelectParameters queryWhereSelectParameters)throws Exception  {		
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
   
