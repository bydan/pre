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
package com.bydan.erp.cartera.util.report;

import org.apache.log4j.Logger;
import java.sql.Time;
import java.sql.Timestamp;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.util.CellRangeAddress;

import javax.swing.border.Border;
import java.io.InputStream;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.Date;
//import java.util.ArrayList;

import com.bydan.framework.erp.business.entity.GeneralEntity;
import com.bydan.framework.erp.business.entity.GeneralEntityReturnGeneral;
import com.bydan.framework.erp.business.entity.GeneralEntityParameterGeneral;
import com.bydan.framework.erp.business.entity.DatoGeneral;
import com.bydan.framework.erp.business.entity.OrderBy;
import com.bydan.framework.erp.business.entity.Classe;
import com.bydan.framework.erp.business.entity.Reporte;
import com.bydan.framework.erp.util.ConstantesJsp;
import com.bydan.framework.erp.business.dataaccess.ConstantesSql;


import com.bydan.erp.cartera.util.report.CobrarListadoVendedoresConstantesFunciones;
import com.bydan.erp.cartera.util.report.CobrarListadoVendedoresParameterReturnGeneral;
//import com.bydan.erp.cartera.util.report.CobrarListadoVendedoresParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.cartera.business.entity.report.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.comisiones.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.comisiones.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.cartera.business.dataaccess.*;
//import com.bydan.erp.cartera.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class CobrarListadoVendedoresConstantesFunciones{		
	
	
	
	public static String S_TIPOREPORTE_EXTRA="";
	
	//USADO MAS EN RELACIONADO PARA MANTENIMIENTO MAESTRO-DETALLE
	public static Integer TAMANIO_ALTO_MAXIMO_TABLADATOS=Constantes.ISWING_TAMANIOMAXIMO_TABLADATOS;
	public static Integer TAMANIO_ALTO_MINIMO_TABLADATOS=Constantes.ISWING_TAMANIOMINIMO_TABLADATOS;
	
	//PARA TABLA RELACIONES(DESCRIPCION HEIGHTPE_REL_TAB)
	public static Integer ALTO_TABPANE_RELACIONES=Constantes.ISWING_ALTO_TABPANE + Funciones2.getValorProporcion(Constantes.ISWING_ALTO_TABPANE,0);
	
	//PARA TABLA RELACIONADO(DESCRIPTION HEIGHTPE_REL)
	public static Integer TAMANIO_ALTO_MAXIMO_TABLADATOSREL=Constantes.ISWING_TAMANIOMAXIMO_TABLADATOSREL + Funciones2.getValorProporcion(Constantes.ISWING_TAMANIOMAXIMO_TABLADATOSREL,0);		
	public static Integer TAMANIO_ALTO_MINIMO_TABLADATOSREL=Constantes.ISWING_TAMANIOMINIMO_TABLADATOSREL + Funciones2.getValorProporcion(Constantes.ISWING_TAMANIOMINIMO_TABLADATOSREL,0);	
	
	//PARA CAMBIAR TODO--> SE CAMBIA EN TABLA RELACIONES Y TABLAS RELACIONADOS
	/*
	PARA MANEJAR EL TAB RELACIONES CON TABLA DE DATOS SE DEBE MODIFICAR Y VERIFICAR LOS VALORES CONTANTES:	
		final public static Integer ISWING_TAMANIOMAXIMO_TABLADATOSREL=240;//230;350;		
		final public static Integer ISWING_TAMANIOMINIMO_TABLADATOSREL=240;//230;260
		
		final public static Integer ISWING_ALTO_TABPANE=375;//375;400;260;
	CASO CONTRARIO, ESTOS VALORES SERIAN PARA CADA CASO (NO CONSTANTES)
	
	NOTA:
	* LA ALINEACION HORIZONTAL,FALTA
	*/
	
	
	public static final String SFINALQUERY="";	
	public static final String SNOMBREOPCION="CobrarListadoVendedores";
	public static final String SPATHOPCION="Cartera";	
	public static final String SPATHMODULO="cartera/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="CobrarListadoVendedores"+CobrarListadoVendedoresConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="CobrarListadoVendedoresHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="CobrarListadoVendedoresHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=CobrarListadoVendedoresConstantesFunciones.SCHEMA+"_"+CobrarListadoVendedoresConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/CobrarListadoVendedoresHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=CobrarListadoVendedoresConstantesFunciones.SCHEMA+"_"+CobrarListadoVendedoresConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=CobrarListadoVendedoresConstantesFunciones.SCHEMA+"_"+CobrarListadoVendedoresConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/CobrarListadoVendedoresHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=CobrarListadoVendedoresConstantesFunciones.SCHEMA+"_"+CobrarListadoVendedoresConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CobrarListadoVendedoresConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/CobrarListadoVendedoresHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CobrarListadoVendedoresConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CobrarListadoVendedoresConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/CobrarListadoVendedoresHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+CobrarListadoVendedoresConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=CobrarListadoVendedoresConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+CobrarListadoVendedoresConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=CobrarListadoVendedoresConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+CobrarListadoVendedoresConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Cobrar Listado Vendedoreses";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Cobrar Listado Vendedores";
	public static final String SCLASSWEBTITULO_LOWER="Cobrar Listado Vendedores";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="CobrarListadoVendedores";
	public static final String OBJECTNAME="cobrarlistadovendedores";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_CARTERA;	
	public static final String TABLENAME="cobrar_listado_vendedores";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select cobrarlistadovendedores from "+CobrarListadoVendedoresConstantesFunciones.SPERSISTENCENAME+" cobrarlistadovendedores";
	public static String QUERYSELECTNATIVE="select "+CobrarListadoVendedoresConstantesFunciones.SCHEMA+"."+CobrarListadoVendedoresConstantesFunciones.TABLENAME+".id,"+CobrarListadoVendedoresConstantesFunciones.SCHEMA+"."+CobrarListadoVendedoresConstantesFunciones.TABLENAME+".version_row,"+CobrarListadoVendedoresConstantesFunciones.SCHEMA+"."+CobrarListadoVendedoresConstantesFunciones.TABLENAME+".id_empresa,"+CobrarListadoVendedoresConstantesFunciones.SCHEMA+"."+CobrarListadoVendedoresConstantesFunciones.TABLENAME+".id_sucursal,"+CobrarListadoVendedoresConstantesFunciones.SCHEMA+"."+CobrarListadoVendedoresConstantesFunciones.TABLENAME+".id_vendedor,"+CobrarListadoVendedoresConstantesFunciones.SCHEMA+"."+CobrarListadoVendedoresConstantesFunciones.TABLENAME+".nombre_vendedor,"+CobrarListadoVendedoresConstantesFunciones.SCHEMA+"."+CobrarListadoVendedoresConstantesFunciones.TABLENAME+".codigo,"+CobrarListadoVendedoresConstantesFunciones.SCHEMA+"."+CobrarListadoVendedoresConstantesFunciones.TABLENAME+".nombre,"+CobrarListadoVendedoresConstantesFunciones.SCHEMA+"."+CobrarListadoVendedoresConstantesFunciones.TABLENAME+".ruc,"+CobrarListadoVendedoresConstantesFunciones.SCHEMA+"."+CobrarListadoVendedoresConstantesFunciones.TABLENAME+".direccion_domicilio,"+CobrarListadoVendedoresConstantesFunciones.SCHEMA+"."+CobrarListadoVendedoresConstantesFunciones.TABLENAME+".telefono from "+CobrarListadoVendedoresConstantesFunciones.SCHEMA+"."+CobrarListadoVendedoresConstantesFunciones.TABLENAME;//+" as "+CobrarListadoVendedoresConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDVENDEDOR= "id_vendedor";
    public static final String NOMBREVENDEDOR= "nombre_vendedor";
    public static final String CODIGO= "codigo";
    public static final String NOMBRE= "nombre";
    public static final String RUC= "ruc";
    public static final String DIRECCIONDOMICILIO= "direccion_domicilio";
    public static final String TELEFONO= "telefono";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDVENDEDOR= "Vendedor";
		public static final String LABEL_IDVENDEDOR_LOWER= "Vendedor";
    	public static final String LABEL_NOMBREVENDEDOR= "Nombre Vendedor";
		public static final String LABEL_NOMBREVENDEDOR_LOWER= "Nombre Vendedor";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_RUC= "Ruc";
		public static final String LABEL_RUC_LOWER= "Ruc";
    	public static final String LABEL_DIRECCIONDOMICILIO= "Direccion Domicilio";
		public static final String LABEL_DIRECCIONDOMICILIO_LOWER= "Direccion Domicilio";
    	public static final String LABEL_TELEFONO= "Telefono";
		public static final String LABEL_TELEFONO_LOWER= "Telefono";
	
		
		
		
		
		
	public static final String SREGEXNOMBRE_VENDEDOR=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_VENDEDOR=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXRUC=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXRUC=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXDIRECCION_DOMICILIO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDIRECCION_DOMICILIO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXTELEFONO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXTELEFONO=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getCobrarListadoVendedoresLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(CobrarListadoVendedoresConstantesFunciones.IDEMPRESA)) {sLabelColumna=CobrarListadoVendedoresConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(CobrarListadoVendedoresConstantesFunciones.IDSUCURSAL)) {sLabelColumna=CobrarListadoVendedoresConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(CobrarListadoVendedoresConstantesFunciones.IDVENDEDOR)) {sLabelColumna=CobrarListadoVendedoresConstantesFunciones.LABEL_IDVENDEDOR;}
		if(sNombreColumna.equals(CobrarListadoVendedoresConstantesFunciones.NOMBREVENDEDOR)) {sLabelColumna=CobrarListadoVendedoresConstantesFunciones.LABEL_NOMBREVENDEDOR;}
		if(sNombreColumna.equals(CobrarListadoVendedoresConstantesFunciones.CODIGO)) {sLabelColumna=CobrarListadoVendedoresConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(CobrarListadoVendedoresConstantesFunciones.NOMBRE)) {sLabelColumna=CobrarListadoVendedoresConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(CobrarListadoVendedoresConstantesFunciones.RUC)) {sLabelColumna=CobrarListadoVendedoresConstantesFunciones.LABEL_RUC;}
		if(sNombreColumna.equals(CobrarListadoVendedoresConstantesFunciones.DIRECCIONDOMICILIO)) {sLabelColumna=CobrarListadoVendedoresConstantesFunciones.LABEL_DIRECCIONDOMICILIO;}
		if(sNombreColumna.equals(CobrarListadoVendedoresConstantesFunciones.TELEFONO)) {sLabelColumna=CobrarListadoVendedoresConstantesFunciones.LABEL_TELEFONO;}
		
		if(sLabelColumna.equals("")) {
			sLabelColumna=sNombreColumna;	
		}
		return sLabelColumna;
	}
	
	
	
	public static String getNombreEjb_JBoss81(String sAplicacion,String sModule,String sClaseEjb,String sInterfaceEjb) throws Exception {
		String sDescripcion="";

		sDescripcion="ejb:"+sAplicacion+"/"+sModule+"/"+sClaseEjb+"!" + sInterfaceEjb;
		
		return sDescripcion;
	}
	
	
	
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getCobrarListadoVendedoresDescripcion(CobrarListadoVendedores cobrarlistadovendedores) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(cobrarlistadovendedores !=null/* && cobrarlistadovendedores.getId()!=0*/) {
			sDescripcion=cobrarlistadovendedores.getcodigo();//cobrarlistadovendedorescobrarlistadovendedores.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getCobrarListadoVendedoresDescripcionDetallado(CobrarListadoVendedores cobrarlistadovendedores) {
		String sDescripcion="";
			
		sDescripcion+=CobrarListadoVendedoresConstantesFunciones.ID+"=";
		sDescripcion+=cobrarlistadovendedores.getId().toString()+",";
		sDescripcion+=CobrarListadoVendedoresConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=cobrarlistadovendedores.getVersionRow().toString()+",";
		sDescripcion+=CobrarListadoVendedoresConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=cobrarlistadovendedores.getid_empresa().toString()+",";
		sDescripcion+=CobrarListadoVendedoresConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=cobrarlistadovendedores.getid_sucursal().toString()+",";
		sDescripcion+=CobrarListadoVendedoresConstantesFunciones.IDVENDEDOR+"=";
		sDescripcion+=cobrarlistadovendedores.getid_vendedor().toString()+",";
		sDescripcion+=CobrarListadoVendedoresConstantesFunciones.NOMBREVENDEDOR+"=";
		sDescripcion+=cobrarlistadovendedores.getnombre_vendedor()+",";
		sDescripcion+=CobrarListadoVendedoresConstantesFunciones.CODIGO+"=";
		sDescripcion+=cobrarlistadovendedores.getcodigo()+",";
		sDescripcion+=CobrarListadoVendedoresConstantesFunciones.NOMBRE+"=";
		sDescripcion+=cobrarlistadovendedores.getnombre()+",";
		sDescripcion+=CobrarListadoVendedoresConstantesFunciones.RUC+"=";
		sDescripcion+=cobrarlistadovendedores.getruc()+",";
		sDescripcion+=CobrarListadoVendedoresConstantesFunciones.DIRECCIONDOMICILIO+"=";
		sDescripcion+=cobrarlistadovendedores.getdireccion_domicilio()+",";
		sDescripcion+=CobrarListadoVendedoresConstantesFunciones.TELEFONO+"=";
		sDescripcion+=cobrarlistadovendedores.gettelefono()+",";
			
		return sDescripcion;
	}
	
	public static void setCobrarListadoVendedoresDescripcion(CobrarListadoVendedores cobrarlistadovendedores,String sValor) throws Exception {			
		if(cobrarlistadovendedores !=null) {
			cobrarlistadovendedores.setcodigo(sValor);;//cobrarlistadovendedorescobrarlistadovendedores.getcodigo().trim();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getSucursalDescripcion(Sucursal sucursal) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(sucursal!=null/*&&sucursal.getId()>0*/) {
			sDescripcion=SucursalConstantesFunciones.getSucursalDescripcion(sucursal);
		}

		return sDescripcion;
	}

	public static String getVendedorDescripcion(Vendedor vendedor) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(vendedor!=null/*&&vendedor.getId()>0*/) {
			sDescripcion=VendedorConstantesFunciones.getVendedorDescripcion(vendedor);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaCobrarListadoVendedores")) {
			sNombreIndice="Tipo=  Por Vendedor";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		} else if(sNombreIndice.equals("FK_IdVendedor")) {
			sNombreIndice="Tipo=  Por Vendedor";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaCobrarListadoVendedores(Long id_vendedor) {
		String sDetalleIndice=" Parametros->";
		if(id_vendedor!=null) {sDetalleIndice+=" Codigo Unico De Vendedor="+id_vendedor.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdVendedor(Long id_vendedor) {
		String sDetalleIndice=" Parametros->";
		if(id_vendedor!=null) {sDetalleIndice+=" Codigo Unico De Vendedor="+id_vendedor.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosCobrarListadoVendedores(CobrarListadoVendedores cobrarlistadovendedores,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		cobrarlistadovendedores.setnombre_vendedor(cobrarlistadovendedores.getnombre_vendedor().trim());
		cobrarlistadovendedores.setcodigo(cobrarlistadovendedores.getcodigo().trim());
		cobrarlistadovendedores.setnombre(cobrarlistadovendedores.getnombre().trim());
		cobrarlistadovendedores.setruc(cobrarlistadovendedores.getruc().trim());
		cobrarlistadovendedores.setdireccion_domicilio(cobrarlistadovendedores.getdireccion_domicilio().trim());
		cobrarlistadovendedores.settelefono(cobrarlistadovendedores.gettelefono().trim());
	}
	
	public static void quitarEspaciosCobrarListadoVendedoress(List<CobrarListadoVendedores> cobrarlistadovendedoress,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(CobrarListadoVendedores cobrarlistadovendedores: cobrarlistadovendedoress) {
			cobrarlistadovendedores.setnombre_vendedor(cobrarlistadovendedores.getnombre_vendedor().trim());
			cobrarlistadovendedores.setcodigo(cobrarlistadovendedores.getcodigo().trim());
			cobrarlistadovendedores.setnombre(cobrarlistadovendedores.getnombre().trim());
			cobrarlistadovendedores.setruc(cobrarlistadovendedores.getruc().trim());
			cobrarlistadovendedores.setdireccion_domicilio(cobrarlistadovendedores.getdireccion_domicilio().trim());
			cobrarlistadovendedores.settelefono(cobrarlistadovendedores.gettelefono().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresCobrarListadoVendedores(CobrarListadoVendedores cobrarlistadovendedores,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && cobrarlistadovendedores.getConCambioAuxiliar()) {
			cobrarlistadovendedores.setIsDeleted(cobrarlistadovendedores.getIsDeletedAuxiliar());	
			cobrarlistadovendedores.setIsNew(cobrarlistadovendedores.getIsNewAuxiliar());	
			cobrarlistadovendedores.setIsChanged(cobrarlistadovendedores.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			cobrarlistadovendedores.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			cobrarlistadovendedores.setIsDeletedAuxiliar(false);	
			cobrarlistadovendedores.setIsNewAuxiliar(false);	
			cobrarlistadovendedores.setIsChangedAuxiliar(false);
			
			cobrarlistadovendedores.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresCobrarListadoVendedoress(List<CobrarListadoVendedores> cobrarlistadovendedoress,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(CobrarListadoVendedores cobrarlistadovendedores : cobrarlistadovendedoress) {
			if(conAsignarBase && cobrarlistadovendedores.getConCambioAuxiliar()) {
				cobrarlistadovendedores.setIsDeleted(cobrarlistadovendedores.getIsDeletedAuxiliar());	
				cobrarlistadovendedores.setIsNew(cobrarlistadovendedores.getIsNewAuxiliar());	
				cobrarlistadovendedores.setIsChanged(cobrarlistadovendedores.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				cobrarlistadovendedores.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				cobrarlistadovendedores.setIsDeletedAuxiliar(false);	
				cobrarlistadovendedores.setIsNewAuxiliar(false);	
				cobrarlistadovendedores.setIsChangedAuxiliar(false);
				
				cobrarlistadovendedores.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresCobrarListadoVendedores(CobrarListadoVendedores cobrarlistadovendedores,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresCobrarListadoVendedoress(List<CobrarListadoVendedores> cobrarlistadovendedoress,Boolean conEnteros) throws Exception  {
		
		for(CobrarListadoVendedores cobrarlistadovendedores: cobrarlistadovendedoress) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaCobrarListadoVendedores(List<CobrarListadoVendedores> cobrarlistadovendedoress,CobrarListadoVendedores cobrarlistadovendedoresAux) throws Exception  {
		CobrarListadoVendedoresConstantesFunciones.InicializarValoresCobrarListadoVendedores(cobrarlistadovendedoresAux,true);
		
		for(CobrarListadoVendedores cobrarlistadovendedores: cobrarlistadovendedoress) {
			if(cobrarlistadovendedores.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesCobrarListadoVendedores(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=CobrarListadoVendedoresConstantesFunciones.getArrayColumnasGlobalesCobrarListadoVendedores(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesCobrarListadoVendedores(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(CobrarListadoVendedoresConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(CobrarListadoVendedoresConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(CobrarListadoVendedoresConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(CobrarListadoVendedoresConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoCobrarListadoVendedores(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<CobrarListadoVendedores> cobrarlistadovendedoress,CobrarListadoVendedores cobrarlistadovendedores,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(CobrarListadoVendedores cobrarlistadovendedoresAux: cobrarlistadovendedoress) {
			if(cobrarlistadovendedoresAux!=null && cobrarlistadovendedores!=null) {
				if((cobrarlistadovendedoresAux.getId()==null && cobrarlistadovendedores.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(cobrarlistadovendedoresAux.getId()!=null && cobrarlistadovendedores.getId()!=null){
					if(cobrarlistadovendedoresAux.getId().equals(cobrarlistadovendedores.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaCobrarListadoVendedores(List<CobrarListadoVendedores> cobrarlistadovendedoress) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(CobrarListadoVendedores cobrarlistadovendedores: cobrarlistadovendedoress) {			
			if(cobrarlistadovendedores.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaCobrarListadoVendedores() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,CobrarListadoVendedoresConstantesFunciones.LABEL_ID, CobrarListadoVendedoresConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarListadoVendedoresConstantesFunciones.LABEL_VERSIONROW, CobrarListadoVendedoresConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarListadoVendedoresConstantesFunciones.LABEL_NOMBREVENDEDOR, CobrarListadoVendedoresConstantesFunciones.NOMBREVENDEDOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarListadoVendedoresConstantesFunciones.LABEL_CODIGO, CobrarListadoVendedoresConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarListadoVendedoresConstantesFunciones.LABEL_NOMBRE, CobrarListadoVendedoresConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarListadoVendedoresConstantesFunciones.LABEL_RUC, CobrarListadoVendedoresConstantesFunciones.RUC,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarListadoVendedoresConstantesFunciones.LABEL_DIRECCIONDOMICILIO, CobrarListadoVendedoresConstantesFunciones.DIRECCIONDOMICILIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,CobrarListadoVendedoresConstantesFunciones.LABEL_TELEFONO, CobrarListadoVendedoresConstantesFunciones.TELEFONO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasCobrarListadoVendedores() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=CobrarListadoVendedoresConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarListadoVendedoresConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarListadoVendedoresConstantesFunciones.NOMBREVENDEDOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarListadoVendedoresConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarListadoVendedoresConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarListadoVendedoresConstantesFunciones.RUC;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarListadoVendedoresConstantesFunciones.DIRECCIONDOMICILIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=CobrarListadoVendedoresConstantesFunciones.TELEFONO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCobrarListadoVendedores() throws Exception  {
		return CobrarListadoVendedoresConstantesFunciones.getTiposSeleccionarCobrarListadoVendedores(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCobrarListadoVendedores(Boolean conFk) throws Exception  {
		return CobrarListadoVendedoresConstantesFunciones.getTiposSeleccionarCobrarListadoVendedores(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarCobrarListadoVendedores(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarListadoVendedoresConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(CobrarListadoVendedoresConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarListadoVendedoresConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(CobrarListadoVendedoresConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarListadoVendedoresConstantesFunciones.LABEL_IDVENDEDOR);
			reporte.setsDescripcion(CobrarListadoVendedoresConstantesFunciones.LABEL_IDVENDEDOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarListadoVendedoresConstantesFunciones.LABEL_NOMBREVENDEDOR);
			reporte.setsDescripcion(CobrarListadoVendedoresConstantesFunciones.LABEL_NOMBREVENDEDOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarListadoVendedoresConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(CobrarListadoVendedoresConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarListadoVendedoresConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(CobrarListadoVendedoresConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarListadoVendedoresConstantesFunciones.LABEL_RUC);
			reporte.setsDescripcion(CobrarListadoVendedoresConstantesFunciones.LABEL_RUC);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarListadoVendedoresConstantesFunciones.LABEL_DIRECCIONDOMICILIO);
			reporte.setsDescripcion(CobrarListadoVendedoresConstantesFunciones.LABEL_DIRECCIONDOMICILIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(CobrarListadoVendedoresConstantesFunciones.LABEL_TELEFONO);
			reporte.setsDescripcion(CobrarListadoVendedoresConstantesFunciones.LABEL_TELEFONO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesCobrarListadoVendedores(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesCobrarListadoVendedores(CobrarListadoVendedores cobrarlistadovendedoresAux) throws Exception {
		
			cobrarlistadovendedoresAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(cobrarlistadovendedoresAux.getEmpresa()));
			cobrarlistadovendedoresAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(cobrarlistadovendedoresAux.getSucursal()));
			cobrarlistadovendedoresAux.setvendedor_descripcion(VendedorConstantesFunciones.getVendedorDescripcion(cobrarlistadovendedoresAux.getVendedor()));		
	}
	
	public static void refrescarForeignKeysDescripcionesCobrarListadoVendedores(List<CobrarListadoVendedores> cobrarlistadovendedoressTemp) throws Exception {
		for(CobrarListadoVendedores cobrarlistadovendedoresAux:cobrarlistadovendedoressTemp) {
			
			cobrarlistadovendedoresAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(cobrarlistadovendedoresAux.getEmpresa()));
			cobrarlistadovendedoresAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(cobrarlistadovendedoresAux.getSucursal()));
			cobrarlistadovendedoresAux.setvendedor_descripcion(VendedorConstantesFunciones.getVendedorDescripcion(cobrarlistadovendedoresAux.getVendedor()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfCobrarListadoVendedores(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Vendedor.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Sucursal.class)) {
						classes.add(new Classe(Sucursal.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Vendedor.class)) {
						classes.add(new Classe(Vendedor.class));
					}
				}

				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {					
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfCobrarListadoVendedores(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(Vendedor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Vendedor.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(Vendedor.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Vendedor.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {					
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfCobrarListadoVendedores(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return CobrarListadoVendedoresConstantesFunciones.getClassesRelationshipsOfCobrarListadoVendedores(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfCobrarListadoVendedores(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {		
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfCobrarListadoVendedores(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return CobrarListadoVendedoresConstantesFunciones.getClassesRelationshipsFromStringsOfCobrarListadoVendedores(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfCobrarListadoVendedores(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {
				}
				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {		
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}		
	
	//FUNCIONES CONTROLLER
	public static void actualizarLista(CobrarListadoVendedores cobrarlistadovendedores,List<CobrarListadoVendedores> cobrarlistadovendedoress,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(CobrarListadoVendedores cobrarlistadovendedores,List<CobrarListadoVendedores> cobrarlistadovendedoress) throws Exception {
		try	{			
			for(CobrarListadoVendedores cobrarlistadovendedoresLocal:cobrarlistadovendedoress) {
				if(cobrarlistadovendedoresLocal.getId().equals(cobrarlistadovendedores.getId())) {
					cobrarlistadovendedoresLocal.setIsSelected(cobrarlistadovendedores.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesCobrarListadoVendedores(List<CobrarListadoVendedores> cobrarlistadovendedoressAux) throws Exception {
		//this.cobrarlistadovendedoressAux=cobrarlistadovendedoressAux;
		
		for(CobrarListadoVendedores cobrarlistadovendedoresAux:cobrarlistadovendedoressAux) {
			if(cobrarlistadovendedoresAux.getIsChanged()) {
				cobrarlistadovendedoresAux.setIsChanged(false);
			}		
			
			if(cobrarlistadovendedoresAux.getIsNew()) {
				cobrarlistadovendedoresAux.setIsNew(false);
			}	
			
			if(cobrarlistadovendedoresAux.getIsDeleted()) {
				cobrarlistadovendedoresAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesCobrarListadoVendedores(CobrarListadoVendedores cobrarlistadovendedoresAux) throws Exception {
		//this.cobrarlistadovendedoresAux=cobrarlistadovendedoresAux;
		
			if(cobrarlistadovendedoresAux.getIsChanged()) {
				cobrarlistadovendedoresAux.setIsChanged(false);
			}		
			
			if(cobrarlistadovendedoresAux.getIsNew()) {
				cobrarlistadovendedoresAux.setIsNew(false);
			}	
			
			if(cobrarlistadovendedoresAux.getIsDeleted()) {
				cobrarlistadovendedoresAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(CobrarListadoVendedores cobrarlistadovendedoresAsignar,CobrarListadoVendedores cobrarlistadovendedores) throws Exception {
		cobrarlistadovendedoresAsignar.setId(cobrarlistadovendedores.getId());	
		cobrarlistadovendedoresAsignar.setVersionRow(cobrarlistadovendedores.getVersionRow());	
		cobrarlistadovendedoresAsignar.setnombre_vendedor(cobrarlistadovendedores.getnombre_vendedor());	
		cobrarlistadovendedoresAsignar.setcodigo(cobrarlistadovendedores.getcodigo());	
		cobrarlistadovendedoresAsignar.setnombre(cobrarlistadovendedores.getnombre());	
		cobrarlistadovendedoresAsignar.setruc(cobrarlistadovendedores.getruc());	
		cobrarlistadovendedoresAsignar.setdireccion_domicilio(cobrarlistadovendedores.getdireccion_domicilio());	
		cobrarlistadovendedoresAsignar.settelefono(cobrarlistadovendedores.gettelefono());	
	}
	
	public static void inicializarCobrarListadoVendedores(CobrarListadoVendedores cobrarlistadovendedores) throws Exception {
		try {
				cobrarlistadovendedores.setId(0L);	
					
				cobrarlistadovendedores.setnombre_vendedor("");	
				cobrarlistadovendedores.setcodigo("");	
				cobrarlistadovendedores.setnombre("");	
				cobrarlistadovendedores.setruc("");	
				cobrarlistadovendedores.setdireccion_domicilio("");	
				cobrarlistadovendedores.settelefono("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderCobrarListadoVendedores(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarListadoVendedoresConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarListadoVendedoresConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarListadoVendedoresConstantesFunciones.LABEL_IDVENDEDOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarListadoVendedoresConstantesFunciones.LABEL_NOMBREVENDEDOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarListadoVendedoresConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarListadoVendedoresConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarListadoVendedoresConstantesFunciones.LABEL_RUC);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarListadoVendedoresConstantesFunciones.LABEL_DIRECCIONDOMICILIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(CobrarListadoVendedoresConstantesFunciones.LABEL_TELEFONO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataCobrarListadoVendedores(String sTipo,Row row,Workbook workbook,CobrarListadoVendedores cobrarlistadovendedores,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarlistadovendedores.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarlistadovendedores.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarlistadovendedores.getvendedor_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarlistadovendedores.getnombre_vendedor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarlistadovendedores.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarlistadovendedores.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarlistadovendedores.getruc());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarlistadovendedores.getdireccion_domicilio());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(cobrarlistadovendedores.gettelefono());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryCobrarListadoVendedores="";
	
	public String getsFinalQueryCobrarListadoVendedores() {
		return this.sFinalQueryCobrarListadoVendedores;
	}
	
	public void setsFinalQueryCobrarListadoVendedores(String sFinalQueryCobrarListadoVendedores) {
		this.sFinalQueryCobrarListadoVendedores= sFinalQueryCobrarListadoVendedores;
	}
	
	public Border resaltarSeleccionarCobrarListadoVendedores=null;
	
	public Border setResaltarSeleccionarCobrarListadoVendedores(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarListadoVendedoresBeanSwingJInternalFrame cobrarlistadovendedoresBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//cobrarlistadovendedoresBeanSwingJInternalFrame.jTtoolBarCobrarListadoVendedores.setBorder(borderResaltar);
		
		this.resaltarSeleccionarCobrarListadoVendedores= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarCobrarListadoVendedores() {
		return this.resaltarSeleccionarCobrarListadoVendedores;
	}
	
	public void setResaltarSeleccionarCobrarListadoVendedores(Border borderResaltarSeleccionarCobrarListadoVendedores) {
		this.resaltarSeleccionarCobrarListadoVendedores= borderResaltarSeleccionarCobrarListadoVendedores;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridCobrarListadoVendedores=null;
	public Boolean mostraridCobrarListadoVendedores=true;
	public Boolean activaridCobrarListadoVendedores=true;

	public Border resaltarid_empresaCobrarListadoVendedores=null;
	public Boolean mostrarid_empresaCobrarListadoVendedores=true;
	public Boolean activarid_empresaCobrarListadoVendedores=true;
	public Boolean cargarid_empresaCobrarListadoVendedores=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaCobrarListadoVendedores=false;//ConEventDepend=true

	public Border resaltarid_sucursalCobrarListadoVendedores=null;
	public Boolean mostrarid_sucursalCobrarListadoVendedores=true;
	public Boolean activarid_sucursalCobrarListadoVendedores=true;
	public Boolean cargarid_sucursalCobrarListadoVendedores=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalCobrarListadoVendedores=false;//ConEventDepend=true

	public Border resaltarid_vendedorCobrarListadoVendedores=null;
	public Boolean mostrarid_vendedorCobrarListadoVendedores=true;
	public Boolean activarid_vendedorCobrarListadoVendedores=true;
	public Boolean cargarid_vendedorCobrarListadoVendedores=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_vendedorCobrarListadoVendedores=false;//ConEventDepend=true

	public Border resaltarnombre_vendedorCobrarListadoVendedores=null;
	public Boolean mostrarnombre_vendedorCobrarListadoVendedores=true;
	public Boolean activarnombre_vendedorCobrarListadoVendedores=true;

	public Border resaltarcodigoCobrarListadoVendedores=null;
	public Boolean mostrarcodigoCobrarListadoVendedores=true;
	public Boolean activarcodigoCobrarListadoVendedores=true;

	public Border resaltarnombreCobrarListadoVendedores=null;
	public Boolean mostrarnombreCobrarListadoVendedores=true;
	public Boolean activarnombreCobrarListadoVendedores=true;

	public Border resaltarrucCobrarListadoVendedores=null;
	public Boolean mostrarrucCobrarListadoVendedores=true;
	public Boolean activarrucCobrarListadoVendedores=true;

	public Border resaltardireccion_domicilioCobrarListadoVendedores=null;
	public Boolean mostrardireccion_domicilioCobrarListadoVendedores=true;
	public Boolean activardireccion_domicilioCobrarListadoVendedores=true;

	public Border resaltartelefonoCobrarListadoVendedores=null;
	public Boolean mostrartelefonoCobrarListadoVendedores=true;
	public Boolean activartelefonoCobrarListadoVendedores=true;

	
	

	public Border setResaltaridCobrarListadoVendedores(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarListadoVendedoresBeanSwingJInternalFrame cobrarlistadovendedoresBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarlistadovendedoresBeanSwingJInternalFrame.jTtoolBarCobrarListadoVendedores.setBorder(borderResaltar);
		
		this.resaltaridCobrarListadoVendedores= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridCobrarListadoVendedores() {
		return this.resaltaridCobrarListadoVendedores;
	}

	public void setResaltaridCobrarListadoVendedores(Border borderResaltar) {
		this.resaltaridCobrarListadoVendedores= borderResaltar;
	}

	public Boolean getMostraridCobrarListadoVendedores() {
		return this.mostraridCobrarListadoVendedores;
	}

	public void setMostraridCobrarListadoVendedores(Boolean mostraridCobrarListadoVendedores) {
		this.mostraridCobrarListadoVendedores= mostraridCobrarListadoVendedores;
	}

	public Boolean getActivaridCobrarListadoVendedores() {
		return this.activaridCobrarListadoVendedores;
	}

	public void setActivaridCobrarListadoVendedores(Boolean activaridCobrarListadoVendedores) {
		this.activaridCobrarListadoVendedores= activaridCobrarListadoVendedores;
	}

	public Border setResaltarid_empresaCobrarListadoVendedores(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarListadoVendedoresBeanSwingJInternalFrame cobrarlistadovendedoresBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarlistadovendedoresBeanSwingJInternalFrame.jTtoolBarCobrarListadoVendedores.setBorder(borderResaltar);
		
		this.resaltarid_empresaCobrarListadoVendedores= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaCobrarListadoVendedores() {
		return this.resaltarid_empresaCobrarListadoVendedores;
	}

	public void setResaltarid_empresaCobrarListadoVendedores(Border borderResaltar) {
		this.resaltarid_empresaCobrarListadoVendedores= borderResaltar;
	}

	public Boolean getMostrarid_empresaCobrarListadoVendedores() {
		return this.mostrarid_empresaCobrarListadoVendedores;
	}

	public void setMostrarid_empresaCobrarListadoVendedores(Boolean mostrarid_empresaCobrarListadoVendedores) {
		this.mostrarid_empresaCobrarListadoVendedores= mostrarid_empresaCobrarListadoVendedores;
	}

	public Boolean getActivarid_empresaCobrarListadoVendedores() {
		return this.activarid_empresaCobrarListadoVendedores;
	}

	public void setActivarid_empresaCobrarListadoVendedores(Boolean activarid_empresaCobrarListadoVendedores) {
		this.activarid_empresaCobrarListadoVendedores= activarid_empresaCobrarListadoVendedores;
	}

	public Boolean getCargarid_empresaCobrarListadoVendedores() {
		return this.cargarid_empresaCobrarListadoVendedores;
	}

	public void setCargarid_empresaCobrarListadoVendedores(Boolean cargarid_empresaCobrarListadoVendedores) {
		this.cargarid_empresaCobrarListadoVendedores= cargarid_empresaCobrarListadoVendedores;
	}

	public Border setResaltarid_sucursalCobrarListadoVendedores(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarListadoVendedoresBeanSwingJInternalFrame cobrarlistadovendedoresBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarlistadovendedoresBeanSwingJInternalFrame.jTtoolBarCobrarListadoVendedores.setBorder(borderResaltar);
		
		this.resaltarid_sucursalCobrarListadoVendedores= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalCobrarListadoVendedores() {
		return this.resaltarid_sucursalCobrarListadoVendedores;
	}

	public void setResaltarid_sucursalCobrarListadoVendedores(Border borderResaltar) {
		this.resaltarid_sucursalCobrarListadoVendedores= borderResaltar;
	}

	public Boolean getMostrarid_sucursalCobrarListadoVendedores() {
		return this.mostrarid_sucursalCobrarListadoVendedores;
	}

	public void setMostrarid_sucursalCobrarListadoVendedores(Boolean mostrarid_sucursalCobrarListadoVendedores) {
		this.mostrarid_sucursalCobrarListadoVendedores= mostrarid_sucursalCobrarListadoVendedores;
	}

	public Boolean getActivarid_sucursalCobrarListadoVendedores() {
		return this.activarid_sucursalCobrarListadoVendedores;
	}

	public void setActivarid_sucursalCobrarListadoVendedores(Boolean activarid_sucursalCobrarListadoVendedores) {
		this.activarid_sucursalCobrarListadoVendedores= activarid_sucursalCobrarListadoVendedores;
	}

	public Boolean getCargarid_sucursalCobrarListadoVendedores() {
		return this.cargarid_sucursalCobrarListadoVendedores;
	}

	public void setCargarid_sucursalCobrarListadoVendedores(Boolean cargarid_sucursalCobrarListadoVendedores) {
		this.cargarid_sucursalCobrarListadoVendedores= cargarid_sucursalCobrarListadoVendedores;
	}

	public Border setResaltarid_vendedorCobrarListadoVendedores(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarListadoVendedoresBeanSwingJInternalFrame cobrarlistadovendedoresBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarlistadovendedoresBeanSwingJInternalFrame.jTtoolBarCobrarListadoVendedores.setBorder(borderResaltar);
		
		this.resaltarid_vendedorCobrarListadoVendedores= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_vendedorCobrarListadoVendedores() {
		return this.resaltarid_vendedorCobrarListadoVendedores;
	}

	public void setResaltarid_vendedorCobrarListadoVendedores(Border borderResaltar) {
		this.resaltarid_vendedorCobrarListadoVendedores= borderResaltar;
	}

	public Boolean getMostrarid_vendedorCobrarListadoVendedores() {
		return this.mostrarid_vendedorCobrarListadoVendedores;
	}

	public void setMostrarid_vendedorCobrarListadoVendedores(Boolean mostrarid_vendedorCobrarListadoVendedores) {
		this.mostrarid_vendedorCobrarListadoVendedores= mostrarid_vendedorCobrarListadoVendedores;
	}

	public Boolean getActivarid_vendedorCobrarListadoVendedores() {
		return this.activarid_vendedorCobrarListadoVendedores;
	}

	public void setActivarid_vendedorCobrarListadoVendedores(Boolean activarid_vendedorCobrarListadoVendedores) {
		this.activarid_vendedorCobrarListadoVendedores= activarid_vendedorCobrarListadoVendedores;
	}

	public Boolean getCargarid_vendedorCobrarListadoVendedores() {
		return this.cargarid_vendedorCobrarListadoVendedores;
	}

	public void setCargarid_vendedorCobrarListadoVendedores(Boolean cargarid_vendedorCobrarListadoVendedores) {
		this.cargarid_vendedorCobrarListadoVendedores= cargarid_vendedorCobrarListadoVendedores;
	}

	public Border setResaltarnombre_vendedorCobrarListadoVendedores(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarListadoVendedoresBeanSwingJInternalFrame cobrarlistadovendedoresBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarlistadovendedoresBeanSwingJInternalFrame.jTtoolBarCobrarListadoVendedores.setBorder(borderResaltar);
		
		this.resaltarnombre_vendedorCobrarListadoVendedores= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_vendedorCobrarListadoVendedores() {
		return this.resaltarnombre_vendedorCobrarListadoVendedores;
	}

	public void setResaltarnombre_vendedorCobrarListadoVendedores(Border borderResaltar) {
		this.resaltarnombre_vendedorCobrarListadoVendedores= borderResaltar;
	}

	public Boolean getMostrarnombre_vendedorCobrarListadoVendedores() {
		return this.mostrarnombre_vendedorCobrarListadoVendedores;
	}

	public void setMostrarnombre_vendedorCobrarListadoVendedores(Boolean mostrarnombre_vendedorCobrarListadoVendedores) {
		this.mostrarnombre_vendedorCobrarListadoVendedores= mostrarnombre_vendedorCobrarListadoVendedores;
	}

	public Boolean getActivarnombre_vendedorCobrarListadoVendedores() {
		return this.activarnombre_vendedorCobrarListadoVendedores;
	}

	public void setActivarnombre_vendedorCobrarListadoVendedores(Boolean activarnombre_vendedorCobrarListadoVendedores) {
		this.activarnombre_vendedorCobrarListadoVendedores= activarnombre_vendedorCobrarListadoVendedores;
	}

	public Border setResaltarcodigoCobrarListadoVendedores(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarListadoVendedoresBeanSwingJInternalFrame cobrarlistadovendedoresBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarlistadovendedoresBeanSwingJInternalFrame.jTtoolBarCobrarListadoVendedores.setBorder(borderResaltar);
		
		this.resaltarcodigoCobrarListadoVendedores= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoCobrarListadoVendedores() {
		return this.resaltarcodigoCobrarListadoVendedores;
	}

	public void setResaltarcodigoCobrarListadoVendedores(Border borderResaltar) {
		this.resaltarcodigoCobrarListadoVendedores= borderResaltar;
	}

	public Boolean getMostrarcodigoCobrarListadoVendedores() {
		return this.mostrarcodigoCobrarListadoVendedores;
	}

	public void setMostrarcodigoCobrarListadoVendedores(Boolean mostrarcodigoCobrarListadoVendedores) {
		this.mostrarcodigoCobrarListadoVendedores= mostrarcodigoCobrarListadoVendedores;
	}

	public Boolean getActivarcodigoCobrarListadoVendedores() {
		return this.activarcodigoCobrarListadoVendedores;
	}

	public void setActivarcodigoCobrarListadoVendedores(Boolean activarcodigoCobrarListadoVendedores) {
		this.activarcodigoCobrarListadoVendedores= activarcodigoCobrarListadoVendedores;
	}

	public Border setResaltarnombreCobrarListadoVendedores(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarListadoVendedoresBeanSwingJInternalFrame cobrarlistadovendedoresBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarlistadovendedoresBeanSwingJInternalFrame.jTtoolBarCobrarListadoVendedores.setBorder(borderResaltar);
		
		this.resaltarnombreCobrarListadoVendedores= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreCobrarListadoVendedores() {
		return this.resaltarnombreCobrarListadoVendedores;
	}

	public void setResaltarnombreCobrarListadoVendedores(Border borderResaltar) {
		this.resaltarnombreCobrarListadoVendedores= borderResaltar;
	}

	public Boolean getMostrarnombreCobrarListadoVendedores() {
		return this.mostrarnombreCobrarListadoVendedores;
	}

	public void setMostrarnombreCobrarListadoVendedores(Boolean mostrarnombreCobrarListadoVendedores) {
		this.mostrarnombreCobrarListadoVendedores= mostrarnombreCobrarListadoVendedores;
	}

	public Boolean getActivarnombreCobrarListadoVendedores() {
		return this.activarnombreCobrarListadoVendedores;
	}

	public void setActivarnombreCobrarListadoVendedores(Boolean activarnombreCobrarListadoVendedores) {
		this.activarnombreCobrarListadoVendedores= activarnombreCobrarListadoVendedores;
	}

	public Border setResaltarrucCobrarListadoVendedores(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarListadoVendedoresBeanSwingJInternalFrame cobrarlistadovendedoresBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarlistadovendedoresBeanSwingJInternalFrame.jTtoolBarCobrarListadoVendedores.setBorder(borderResaltar);
		
		this.resaltarrucCobrarListadoVendedores= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarrucCobrarListadoVendedores() {
		return this.resaltarrucCobrarListadoVendedores;
	}

	public void setResaltarrucCobrarListadoVendedores(Border borderResaltar) {
		this.resaltarrucCobrarListadoVendedores= borderResaltar;
	}

	public Boolean getMostrarrucCobrarListadoVendedores() {
		return this.mostrarrucCobrarListadoVendedores;
	}

	public void setMostrarrucCobrarListadoVendedores(Boolean mostrarrucCobrarListadoVendedores) {
		this.mostrarrucCobrarListadoVendedores= mostrarrucCobrarListadoVendedores;
	}

	public Boolean getActivarrucCobrarListadoVendedores() {
		return this.activarrucCobrarListadoVendedores;
	}

	public void setActivarrucCobrarListadoVendedores(Boolean activarrucCobrarListadoVendedores) {
		this.activarrucCobrarListadoVendedores= activarrucCobrarListadoVendedores;
	}

	public Border setResaltardireccion_domicilioCobrarListadoVendedores(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarListadoVendedoresBeanSwingJInternalFrame cobrarlistadovendedoresBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarlistadovendedoresBeanSwingJInternalFrame.jTtoolBarCobrarListadoVendedores.setBorder(borderResaltar);
		
		this.resaltardireccion_domicilioCobrarListadoVendedores= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardireccion_domicilioCobrarListadoVendedores() {
		return this.resaltardireccion_domicilioCobrarListadoVendedores;
	}

	public void setResaltardireccion_domicilioCobrarListadoVendedores(Border borderResaltar) {
		this.resaltardireccion_domicilioCobrarListadoVendedores= borderResaltar;
	}

	public Boolean getMostrardireccion_domicilioCobrarListadoVendedores() {
		return this.mostrardireccion_domicilioCobrarListadoVendedores;
	}

	public void setMostrardireccion_domicilioCobrarListadoVendedores(Boolean mostrardireccion_domicilioCobrarListadoVendedores) {
		this.mostrardireccion_domicilioCobrarListadoVendedores= mostrardireccion_domicilioCobrarListadoVendedores;
	}

	public Boolean getActivardireccion_domicilioCobrarListadoVendedores() {
		return this.activardireccion_domicilioCobrarListadoVendedores;
	}

	public void setActivardireccion_domicilioCobrarListadoVendedores(Boolean activardireccion_domicilioCobrarListadoVendedores) {
		this.activardireccion_domicilioCobrarListadoVendedores= activardireccion_domicilioCobrarListadoVendedores;
	}

	public Border setResaltartelefonoCobrarListadoVendedores(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarListadoVendedoresBeanSwingJInternalFrame cobrarlistadovendedoresBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//cobrarlistadovendedoresBeanSwingJInternalFrame.jTtoolBarCobrarListadoVendedores.setBorder(borderResaltar);
		
		this.resaltartelefonoCobrarListadoVendedores= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltartelefonoCobrarListadoVendedores() {
		return this.resaltartelefonoCobrarListadoVendedores;
	}

	public void setResaltartelefonoCobrarListadoVendedores(Border borderResaltar) {
		this.resaltartelefonoCobrarListadoVendedores= borderResaltar;
	}

	public Boolean getMostrartelefonoCobrarListadoVendedores() {
		return this.mostrartelefonoCobrarListadoVendedores;
	}

	public void setMostrartelefonoCobrarListadoVendedores(Boolean mostrartelefonoCobrarListadoVendedores) {
		this.mostrartelefonoCobrarListadoVendedores= mostrartelefonoCobrarListadoVendedores;
	}

	public Boolean getActivartelefonoCobrarListadoVendedores() {
		return this.activartelefonoCobrarListadoVendedores;
	}

	public void setActivartelefonoCobrarListadoVendedores(Boolean activartelefonoCobrarListadoVendedores) {
		this.activartelefonoCobrarListadoVendedores= activartelefonoCobrarListadoVendedores;
	}
	
	public void setMostrarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos)throws Exception {	
		Boolean esInicial=false;
		Boolean esAsigna=false;
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=false;
			esAsigna=true;
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=true;
			esAsigna=false;
		}
		
		
		this.setMostraridCobrarListadoVendedores(esInicial);
		this.setMostrarid_empresaCobrarListadoVendedores(esInicial);
		this.setMostrarid_sucursalCobrarListadoVendedores(esInicial);
		this.setMostrarid_vendedorCobrarListadoVendedores(esInicial);
		this.setMostrarnombre_vendedorCobrarListadoVendedores(esInicial);
		this.setMostrarcodigoCobrarListadoVendedores(esInicial);
		this.setMostrarnombreCobrarListadoVendedores(esInicial);
		this.setMostrarrucCobrarListadoVendedores(esInicial);
		this.setMostrardireccion_domicilioCobrarListadoVendedores(esInicial);
		this.setMostrartelefonoCobrarListadoVendedores(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CobrarListadoVendedoresConstantesFunciones.ID)) {
				this.setMostraridCobrarListadoVendedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarListadoVendedoresConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaCobrarListadoVendedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarListadoVendedoresConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalCobrarListadoVendedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarListadoVendedoresConstantesFunciones.IDVENDEDOR)) {
				this.setMostrarid_vendedorCobrarListadoVendedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarListadoVendedoresConstantesFunciones.NOMBREVENDEDOR)) {
				this.setMostrarnombre_vendedorCobrarListadoVendedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarListadoVendedoresConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoCobrarListadoVendedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarListadoVendedoresConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreCobrarListadoVendedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarListadoVendedoresConstantesFunciones.RUC)) {
				this.setMostrarrucCobrarListadoVendedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarListadoVendedoresConstantesFunciones.DIRECCIONDOMICILIO)) {
				this.setMostrardireccion_domicilioCobrarListadoVendedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarListadoVendedoresConstantesFunciones.TELEFONO)) {
				this.setMostrartelefonoCobrarListadoVendedores(esAsigna);
				continue;
			}
		}
	}
	
	public void setActivarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos)throws Exception {	
		Boolean esInicial=false;
		Boolean esAsigna=false;
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=false;
			esAsigna=true;
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=true;
			esAsigna=false;
		}
		
		
		this.setActivaridCobrarListadoVendedores(esInicial);
		this.setActivarid_empresaCobrarListadoVendedores(esInicial);
		this.setActivarid_sucursalCobrarListadoVendedores(esInicial);
		this.setActivarid_vendedorCobrarListadoVendedores(esInicial);
		this.setActivarnombre_vendedorCobrarListadoVendedores(esInicial);
		this.setActivarcodigoCobrarListadoVendedores(esInicial);
		this.setActivarnombreCobrarListadoVendedores(esInicial);
		this.setActivarrucCobrarListadoVendedores(esInicial);
		this.setActivardireccion_domicilioCobrarListadoVendedores(esInicial);
		this.setActivartelefonoCobrarListadoVendedores(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CobrarListadoVendedoresConstantesFunciones.ID)) {
				this.setActivaridCobrarListadoVendedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarListadoVendedoresConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaCobrarListadoVendedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarListadoVendedoresConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalCobrarListadoVendedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarListadoVendedoresConstantesFunciones.IDVENDEDOR)) {
				this.setActivarid_vendedorCobrarListadoVendedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarListadoVendedoresConstantesFunciones.NOMBREVENDEDOR)) {
				this.setActivarnombre_vendedorCobrarListadoVendedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarListadoVendedoresConstantesFunciones.CODIGO)) {
				this.setActivarcodigoCobrarListadoVendedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarListadoVendedoresConstantesFunciones.NOMBRE)) {
				this.setActivarnombreCobrarListadoVendedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarListadoVendedoresConstantesFunciones.RUC)) {
				this.setActivarrucCobrarListadoVendedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarListadoVendedoresConstantesFunciones.DIRECCIONDOMICILIO)) {
				this.setActivardireccion_domicilioCobrarListadoVendedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarListadoVendedoresConstantesFunciones.TELEFONO)) {
				this.setActivartelefonoCobrarListadoVendedores(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,CobrarListadoVendedoresBeanSwingJInternalFrame cobrarlistadovendedoresBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridCobrarListadoVendedores(esInicial);
		this.setResaltarid_empresaCobrarListadoVendedores(esInicial);
		this.setResaltarid_sucursalCobrarListadoVendedores(esInicial);
		this.setResaltarid_vendedorCobrarListadoVendedores(esInicial);
		this.setResaltarnombre_vendedorCobrarListadoVendedores(esInicial);
		this.setResaltarcodigoCobrarListadoVendedores(esInicial);
		this.setResaltarnombreCobrarListadoVendedores(esInicial);
		this.setResaltarrucCobrarListadoVendedores(esInicial);
		this.setResaltardireccion_domicilioCobrarListadoVendedores(esInicial);
		this.setResaltartelefonoCobrarListadoVendedores(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(CobrarListadoVendedoresConstantesFunciones.ID)) {
				this.setResaltaridCobrarListadoVendedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarListadoVendedoresConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaCobrarListadoVendedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarListadoVendedoresConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalCobrarListadoVendedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarListadoVendedoresConstantesFunciones.IDVENDEDOR)) {
				this.setResaltarid_vendedorCobrarListadoVendedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarListadoVendedoresConstantesFunciones.NOMBREVENDEDOR)) {
				this.setResaltarnombre_vendedorCobrarListadoVendedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarListadoVendedoresConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoCobrarListadoVendedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarListadoVendedoresConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreCobrarListadoVendedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarListadoVendedoresConstantesFunciones.RUC)) {
				this.setResaltarrucCobrarListadoVendedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarListadoVendedoresConstantesFunciones.DIRECCIONDOMICILIO)) {
				this.setResaltardireccion_domicilioCobrarListadoVendedores(esAsigna);
				continue;
			}

			if(campo.clase.equals(CobrarListadoVendedoresConstantesFunciones.TELEFONO)) {
				this.setResaltartelefonoCobrarListadoVendedores(esAsigna);
				continue;
			}
		}
	}
	
			
		
	public void setMostrarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {	
		Boolean esInicial=false;
		Boolean esAsigna=false;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=false;
			esAsigna=true;
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=true;
			esAsigna=false;
		}


		for(Classe clase:clases) {
		}		
	}
	
	public void setActivarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases)throws Exception {	
		Boolean esInicial=false;
		Boolean esAsigna=false;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=false;
			esAsigna=true;
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=true;
			esAsigna=false;
		}


		for(Classe clase:clases) {
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,CobrarListadoVendedoresBeanSwingJInternalFrame cobrarlistadovendedoresBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}


		for(Classe clase:clases) {
		}		
	}
	
	


	public Boolean mostrarBusquedaCobrarListadoVendedoresCobrarListadoVendedores=true;

	public Boolean getMostrarBusquedaCobrarListadoVendedoresCobrarListadoVendedores() {
		return this.mostrarBusquedaCobrarListadoVendedoresCobrarListadoVendedores;
	}

	public void setMostrarBusquedaCobrarListadoVendedoresCobrarListadoVendedores(Boolean visibilidadResaltar) {
		this.mostrarBusquedaCobrarListadoVendedoresCobrarListadoVendedores= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaCobrarListadoVendedoresCobrarListadoVendedores=true;

	public Boolean getActivarBusquedaCobrarListadoVendedoresCobrarListadoVendedores() {
		return this.activarBusquedaCobrarListadoVendedoresCobrarListadoVendedores;
	}

	public void setActivarBusquedaCobrarListadoVendedoresCobrarListadoVendedores(Boolean habilitarResaltar) {
		this.activarBusquedaCobrarListadoVendedoresCobrarListadoVendedores= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaCobrarListadoVendedoresCobrarListadoVendedores=null;

	public Border getResaltarBusquedaCobrarListadoVendedoresCobrarListadoVendedores() {
		return this.resaltarBusquedaCobrarListadoVendedoresCobrarListadoVendedores;
	}

	public void setResaltarBusquedaCobrarListadoVendedoresCobrarListadoVendedores(Border borderResaltar) {
		this.resaltarBusquedaCobrarListadoVendedoresCobrarListadoVendedores= borderResaltar;
	}

	public void setResaltarBusquedaCobrarListadoVendedoresCobrarListadoVendedores(ParametroGeneralUsuario parametroGeneralUsuario/*CobrarListadoVendedoresBeanSwingJInternalFrame cobrarlistadovendedoresBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaCobrarListadoVendedoresCobrarListadoVendedores= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}