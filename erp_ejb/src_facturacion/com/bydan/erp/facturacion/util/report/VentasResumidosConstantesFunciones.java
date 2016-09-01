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
package com.bydan.erp.facturacion.util.report;

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


import com.bydan.erp.facturacion.util.report.VentasResumidosConstantesFunciones;
import com.bydan.erp.facturacion.util.report.VentasResumidosParameterReturnGeneral;
//import com.bydan.erp.facturacion.util.report.VentasResumidosParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.facturacion.business.entity.report.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.facturacion.business.dataaccess.*;
//import com.bydan.erp.facturacion.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class VentasResumidosConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="VentasResumidos";
	public static final String SPATHOPCION="Facturacion";	
	public static final String SPATHMODULO="facturacion/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="VentasResumidos"+VentasResumidosConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="VentasResumidosHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="VentasResumidosHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=VentasResumidosConstantesFunciones.SCHEMA+"_"+VentasResumidosConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/VentasResumidosHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=VentasResumidosConstantesFunciones.SCHEMA+"_"+VentasResumidosConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=VentasResumidosConstantesFunciones.SCHEMA+"_"+VentasResumidosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/VentasResumidosHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=VentasResumidosConstantesFunciones.SCHEMA+"_"+VentasResumidosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+VentasResumidosConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/VentasResumidosHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+VentasResumidosConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+VentasResumidosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/VentasResumidosHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+VentasResumidosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=VentasResumidosConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+VentasResumidosConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=VentasResumidosConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+VentasResumidosConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Ventas Resumidoses";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Ventas Resumidos";
	public static final String SCLASSWEBTITULO_LOWER="Ventas Resumidos";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="VentasResumidos";
	public static final String OBJECTNAME="ventasresumidos";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_FACTURACION;	
	public static final String TABLENAME="ventas_resumidos";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select ventasresumidos from "+VentasResumidosConstantesFunciones.SPERSISTENCENAME+" ventasresumidos";
	public static String QUERYSELECTNATIVE="select "+VentasResumidosConstantesFunciones.SCHEMA+"."+VentasResumidosConstantesFunciones.TABLENAME+".id,"+VentasResumidosConstantesFunciones.SCHEMA+"."+VentasResumidosConstantesFunciones.TABLENAME+".version_row,"+VentasResumidosConstantesFunciones.SCHEMA+"."+VentasResumidosConstantesFunciones.TABLENAME+".id_empresa,"+VentasResumidosConstantesFunciones.SCHEMA+"."+VentasResumidosConstantesFunciones.TABLENAME+".id_sucursal,"+VentasResumidosConstantesFunciones.SCHEMA+"."+VentasResumidosConstantesFunciones.TABLENAME+".fecha_emision_desde,"+VentasResumidosConstantesFunciones.SCHEMA+"."+VentasResumidosConstantesFunciones.TABLENAME+".fecha_emision_hasta,"+VentasResumidosConstantesFunciones.SCHEMA+"."+VentasResumidosConstantesFunciones.TABLENAME+".nombre_completo,"+VentasResumidosConstantesFunciones.SCHEMA+"."+VentasResumidosConstantesFunciones.TABLENAME+".ruc,"+VentasResumidosConstantesFunciones.SCHEMA+"."+VentasResumidosConstantesFunciones.TABLENAME+".nombre_producto,"+VentasResumidosConstantesFunciones.SCHEMA+"."+VentasResumidosConstantesFunciones.TABLENAME+".cantidad,"+VentasResumidosConstantesFunciones.SCHEMA+"."+VentasResumidosConstantesFunciones.TABLENAME+".precio,"+VentasResumidosConstantesFunciones.SCHEMA+"."+VentasResumidosConstantesFunciones.TABLENAME+".monto,"+VentasResumidosConstantesFunciones.SCHEMA+"."+VentasResumidosConstantesFunciones.TABLENAME+".codigo_producto from "+VentasResumidosConstantesFunciones.SCHEMA+"."+VentasResumidosConstantesFunciones.TABLENAME;//+" as "+VentasResumidosConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String FECHAEMISIONDESDE= "fecha_emision_desde";
    public static final String FECHAEMISIONHASTA= "fecha_emision_hasta";
    public static final String NOMBRECOMPLETO= "nombre_completo";
    public static final String RUC= "ruc";
    public static final String NOMBREPRODUCTO= "nombre_producto";
    public static final String CANTIDAD= "cantidad";
    public static final String PRECIO= "precio";
    public static final String MONTO= "monto";
    public static final String CODIGOPRODUCTO= "codigo_producto";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_FECHAEMISIONDESDE= "Fecha Emision Desde";
		public static final String LABEL_FECHAEMISIONDESDE_LOWER= "Fecha Emision Desde";
    	public static final String LABEL_FECHAEMISIONHASTA= "Fecha Emision Hasta";
		public static final String LABEL_FECHAEMISIONHASTA_LOWER= "Fecha Emision Hasta";
    	public static final String LABEL_NOMBRECOMPLETO= "Nombre Completo";
		public static final String LABEL_NOMBRECOMPLETO_LOWER= "Nombre Completo";
    	public static final String LABEL_RUC= "Ruc";
		public static final String LABEL_RUC_LOWER= "Ruc";
    	public static final String LABEL_NOMBREPRODUCTO= "Nombre Producto";
		public static final String LABEL_NOMBREPRODUCTO_LOWER= "Nombre Producto";
    	public static final String LABEL_CANTIDAD= "Cantad";
		public static final String LABEL_CANTIDAD_LOWER= "Cantidad";
    	public static final String LABEL_PRECIO= "Precio";
		public static final String LABEL_PRECIO_LOWER= "Precio";
    	public static final String LABEL_MONTO= "Monto";
		public static final String LABEL_MONTO_LOWER= "Monto";
    	public static final String LABEL_CODIGOPRODUCTO= "Codigo Producto";
		public static final String LABEL_CODIGOPRODUCTO_LOWER= "Codigo Producto";
	
		
		
		
		
		
		
	public static final String SREGEXNOMBRE_COMPLETO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_COMPLETO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXRUC=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXRUC=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_PRODUCTO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_PRODUCTO=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
	public static final String SREGEXCODIGO_PRODUCTO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO_PRODUCTO=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getVentasResumidosLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(VentasResumidosConstantesFunciones.IDEMPRESA)) {sLabelColumna=VentasResumidosConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(VentasResumidosConstantesFunciones.IDSUCURSAL)) {sLabelColumna=VentasResumidosConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(VentasResumidosConstantesFunciones.FECHAEMISIONDESDE)) {sLabelColumna=VentasResumidosConstantesFunciones.LABEL_FECHAEMISIONDESDE;}
		if(sNombreColumna.equals(VentasResumidosConstantesFunciones.FECHAEMISIONHASTA)) {sLabelColumna=VentasResumidosConstantesFunciones.LABEL_FECHAEMISIONHASTA;}
		if(sNombreColumna.equals(VentasResumidosConstantesFunciones.NOMBRECOMPLETO)) {sLabelColumna=VentasResumidosConstantesFunciones.LABEL_NOMBRECOMPLETO;}
		if(sNombreColumna.equals(VentasResumidosConstantesFunciones.RUC)) {sLabelColumna=VentasResumidosConstantesFunciones.LABEL_RUC;}
		if(sNombreColumna.equals(VentasResumidosConstantesFunciones.NOMBREPRODUCTO)) {sLabelColumna=VentasResumidosConstantesFunciones.LABEL_NOMBREPRODUCTO;}
		if(sNombreColumna.equals(VentasResumidosConstantesFunciones.CANTIDAD)) {sLabelColumna=VentasResumidosConstantesFunciones.LABEL_CANTIDAD;}
		if(sNombreColumna.equals(VentasResumidosConstantesFunciones.PRECIO)) {sLabelColumna=VentasResumidosConstantesFunciones.LABEL_PRECIO;}
		if(sNombreColumna.equals(VentasResumidosConstantesFunciones.MONTO)) {sLabelColumna=VentasResumidosConstantesFunciones.LABEL_MONTO;}
		if(sNombreColumna.equals(VentasResumidosConstantesFunciones.CODIGOPRODUCTO)) {sLabelColumna=VentasResumidosConstantesFunciones.LABEL_CODIGOPRODUCTO;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getVentasResumidosDescripcion(VentasResumidos ventasresumidos) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(ventasresumidos !=null/* && ventasresumidos.getId()!=0*/) {
			sDescripcion=ventasresumidos.getfecha_emision_desde().toString();//ventasresumidosventasresumidos.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getVentasResumidosDescripcionDetallado(VentasResumidos ventasresumidos) {
		String sDescripcion="";
			
		sDescripcion+=VentasResumidosConstantesFunciones.ID+"=";
		sDescripcion+=ventasresumidos.getId().toString()+",";
		sDescripcion+=VentasResumidosConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=ventasresumidos.getVersionRow().toString()+",";
		sDescripcion+=VentasResumidosConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=ventasresumidos.getid_empresa().toString()+",";
		sDescripcion+=VentasResumidosConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=ventasresumidos.getid_sucursal().toString()+",";
		sDescripcion+=VentasResumidosConstantesFunciones.FECHAEMISIONDESDE+"=";
		sDescripcion+=ventasresumidos.getfecha_emision_desde().toString()+",";
		sDescripcion+=VentasResumidosConstantesFunciones.FECHAEMISIONHASTA+"=";
		sDescripcion+=ventasresumidos.getfecha_emision_hasta().toString()+",";
		sDescripcion+=VentasResumidosConstantesFunciones.NOMBRECOMPLETO+"=";
		sDescripcion+=ventasresumidos.getnombre_completo()+",";
		sDescripcion+=VentasResumidosConstantesFunciones.RUC+"=";
		sDescripcion+=ventasresumidos.getruc()+",";
		sDescripcion+=VentasResumidosConstantesFunciones.NOMBREPRODUCTO+"=";
		sDescripcion+=ventasresumidos.getnombre_producto()+",";
		sDescripcion+=VentasResumidosConstantesFunciones.CANTIDAD+"=";
		sDescripcion+=ventasresumidos.getcantidad().toString()+",";
		sDescripcion+=VentasResumidosConstantesFunciones.PRECIO+"=";
		sDescripcion+=ventasresumidos.getprecio().toString()+",";
		sDescripcion+=VentasResumidosConstantesFunciones.MONTO+"=";
		sDescripcion+=ventasresumidos.getmonto().toString()+",";
		sDescripcion+=VentasResumidosConstantesFunciones.CODIGOPRODUCTO+"=";
		sDescripcion+=ventasresumidos.getcodigo_producto()+",";
			
		return sDescripcion;
	}
	
	public static void setVentasResumidosDescripcion(VentasResumidos ventasresumidos,String sValor) throws Exception {			
		if(ventasresumidos !=null) {
			//ventasresumidosventasresumidos.getId().toString();
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
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaVentasResumidos")) {
			sNombreIndice="Tipo=  Por Fecha Emision Desde Por Fecha Emision Hasta";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaVentasResumidos(Date fecha_emision_desde,Date fecha_emision_hasta) {
		String sDetalleIndice=" Parametros->";
		if(fecha_emision_desde!=null) {sDetalleIndice+=" Fecha Emision Desde="+fecha_emision_desde.toString();}
		if(fecha_emision_hasta!=null) {sDetalleIndice+=" Fecha Emision Hasta="+fecha_emision_hasta.toString();} 

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
	
	
	
	
	
	
	public static void quitarEspaciosVentasResumidos(VentasResumidos ventasresumidos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ventasresumidos.setnombre_completo(ventasresumidos.getnombre_completo().trim());
		ventasresumidos.setruc(ventasresumidos.getruc().trim());
		ventasresumidos.setnombre_producto(ventasresumidos.getnombre_producto().trim());
		ventasresumidos.setcodigo_producto(ventasresumidos.getcodigo_producto().trim());
	}
	
	public static void quitarEspaciosVentasResumidoss(List<VentasResumidos> ventasresumidoss,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(VentasResumidos ventasresumidos: ventasresumidoss) {
			ventasresumidos.setnombre_completo(ventasresumidos.getnombre_completo().trim());
			ventasresumidos.setruc(ventasresumidos.getruc().trim());
			ventasresumidos.setnombre_producto(ventasresumidos.getnombre_producto().trim());
			ventasresumidos.setcodigo_producto(ventasresumidos.getcodigo_producto().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresVentasResumidos(VentasResumidos ventasresumidos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && ventasresumidos.getConCambioAuxiliar()) {
			ventasresumidos.setIsDeleted(ventasresumidos.getIsDeletedAuxiliar());	
			ventasresumidos.setIsNew(ventasresumidos.getIsNewAuxiliar());	
			ventasresumidos.setIsChanged(ventasresumidos.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			ventasresumidos.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			ventasresumidos.setIsDeletedAuxiliar(false);	
			ventasresumidos.setIsNewAuxiliar(false);	
			ventasresumidos.setIsChangedAuxiliar(false);
			
			ventasresumidos.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresVentasResumidoss(List<VentasResumidos> ventasresumidoss,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(VentasResumidos ventasresumidos : ventasresumidoss) {
			if(conAsignarBase && ventasresumidos.getConCambioAuxiliar()) {
				ventasresumidos.setIsDeleted(ventasresumidos.getIsDeletedAuxiliar());	
				ventasresumidos.setIsNew(ventasresumidos.getIsNewAuxiliar());	
				ventasresumidos.setIsChanged(ventasresumidos.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				ventasresumidos.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				ventasresumidos.setIsDeletedAuxiliar(false);	
				ventasresumidos.setIsNewAuxiliar(false);	
				ventasresumidos.setIsChangedAuxiliar(false);
				
				ventasresumidos.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresVentasResumidos(VentasResumidos ventasresumidos,Boolean conEnteros) throws Exception  {
		ventasresumidos.setprecio(0.0);
		ventasresumidos.setmonto(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
			ventasresumidos.setcantidad(0);
		}
	}		
	
	public static void InicializarValoresVentasResumidoss(List<VentasResumidos> ventasresumidoss,Boolean conEnteros) throws Exception  {
		
		for(VentasResumidos ventasresumidos: ventasresumidoss) {
			ventasresumidos.setprecio(0.0);
			ventasresumidos.setmonto(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
				ventasresumidos.setcantidad(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaVentasResumidos(List<VentasResumidos> ventasresumidoss,VentasResumidos ventasresumidosAux) throws Exception  {
		VentasResumidosConstantesFunciones.InicializarValoresVentasResumidos(ventasresumidosAux,true);
		
		for(VentasResumidos ventasresumidos: ventasresumidoss) {
			if(ventasresumidos.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			ventasresumidosAux.setcantidad(ventasresumidosAux.getcantidad()+ventasresumidos.getcantidad());			
			ventasresumidosAux.setprecio(ventasresumidosAux.getprecio()+ventasresumidos.getprecio());			
			ventasresumidosAux.setmonto(ventasresumidosAux.getmonto()+ventasresumidos.getmonto());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesVentasResumidos(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=VentasResumidosConstantesFunciones.getArrayColumnasGlobalesVentasResumidos(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesVentasResumidos(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(VentasResumidosConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(VentasResumidosConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(VentasResumidosConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(VentasResumidosConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoVentasResumidos(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<VentasResumidos> ventasresumidoss,VentasResumidos ventasresumidos,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(VentasResumidos ventasresumidosAux: ventasresumidoss) {
			if(ventasresumidosAux!=null && ventasresumidos!=null) {
				if((ventasresumidosAux.getId()==null && ventasresumidos.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(ventasresumidosAux.getId()!=null && ventasresumidos.getId()!=null){
					if(ventasresumidosAux.getId().equals(ventasresumidos.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaVentasResumidos(List<VentasResumidos> ventasresumidoss) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double precioTotal=0.0;
		Double montoTotal=0.0;
	
		for(VentasResumidos ventasresumidos: ventasresumidoss) {			
			if(ventasresumidos.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			precioTotal+=ventasresumidos.getprecio();
			montoTotal+=ventasresumidos.getmonto();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(VentasResumidosConstantesFunciones.PRECIO);
		datoGeneral.setsDescripcion(VentasResumidosConstantesFunciones.LABEL_PRECIO);
		datoGeneral.setdValorDouble(precioTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(VentasResumidosConstantesFunciones.MONTO);
		datoGeneral.setsDescripcion(VentasResumidosConstantesFunciones.LABEL_MONTO);
		datoGeneral.setdValorDouble(montoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaVentasResumidos() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,VentasResumidosConstantesFunciones.LABEL_ID, VentasResumidosConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VentasResumidosConstantesFunciones.LABEL_VERSIONROW, VentasResumidosConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VentasResumidosConstantesFunciones.LABEL_NOMBRECOMPLETO, VentasResumidosConstantesFunciones.NOMBRECOMPLETO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VentasResumidosConstantesFunciones.LABEL_RUC, VentasResumidosConstantesFunciones.RUC,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VentasResumidosConstantesFunciones.LABEL_NOMBREPRODUCTO, VentasResumidosConstantesFunciones.NOMBREPRODUCTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VentasResumidosConstantesFunciones.LABEL_CANTIDAD, VentasResumidosConstantesFunciones.CANTIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VentasResumidosConstantesFunciones.LABEL_PRECIO, VentasResumidosConstantesFunciones.PRECIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VentasResumidosConstantesFunciones.LABEL_MONTO, VentasResumidosConstantesFunciones.MONTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VentasResumidosConstantesFunciones.LABEL_CODIGOPRODUCTO, VentasResumidosConstantesFunciones.CODIGOPRODUCTO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasVentasResumidos() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=VentasResumidosConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VentasResumidosConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VentasResumidosConstantesFunciones.NOMBRECOMPLETO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VentasResumidosConstantesFunciones.RUC;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VentasResumidosConstantesFunciones.NOMBREPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VentasResumidosConstantesFunciones.CANTIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VentasResumidosConstantesFunciones.PRECIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VentasResumidosConstantesFunciones.MONTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VentasResumidosConstantesFunciones.CODIGOPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarVentasResumidos() throws Exception  {
		return VentasResumidosConstantesFunciones.getTiposSeleccionarVentasResumidos(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarVentasResumidos(Boolean conFk) throws Exception  {
		return VentasResumidosConstantesFunciones.getTiposSeleccionarVentasResumidos(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarVentasResumidos(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(VentasResumidosConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(VentasResumidosConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(VentasResumidosConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(VentasResumidosConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VentasResumidosConstantesFunciones.LABEL_FECHAEMISIONDESDE);
			reporte.setsDescripcion(VentasResumidosConstantesFunciones.LABEL_FECHAEMISIONDESDE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VentasResumidosConstantesFunciones.LABEL_FECHAEMISIONHASTA);
			reporte.setsDescripcion(VentasResumidosConstantesFunciones.LABEL_FECHAEMISIONHASTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VentasResumidosConstantesFunciones.LABEL_NOMBRECOMPLETO);
			reporte.setsDescripcion(VentasResumidosConstantesFunciones.LABEL_NOMBRECOMPLETO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VentasResumidosConstantesFunciones.LABEL_RUC);
			reporte.setsDescripcion(VentasResumidosConstantesFunciones.LABEL_RUC);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VentasResumidosConstantesFunciones.LABEL_NOMBREPRODUCTO);
			reporte.setsDescripcion(VentasResumidosConstantesFunciones.LABEL_NOMBREPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VentasResumidosConstantesFunciones.LABEL_CANTIDAD);
			reporte.setsDescripcion(VentasResumidosConstantesFunciones.LABEL_CANTIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VentasResumidosConstantesFunciones.LABEL_PRECIO);
			reporte.setsDescripcion(VentasResumidosConstantesFunciones.LABEL_PRECIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VentasResumidosConstantesFunciones.LABEL_MONTO);
			reporte.setsDescripcion(VentasResumidosConstantesFunciones.LABEL_MONTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VentasResumidosConstantesFunciones.LABEL_CODIGOPRODUCTO);
			reporte.setsDescripcion(VentasResumidosConstantesFunciones.LABEL_CODIGOPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesVentasResumidos(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesVentasResumidos(VentasResumidos ventasresumidosAux) throws Exception {
		
			ventasresumidosAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(ventasresumidosAux.getEmpresa()));
			ventasresumidosAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(ventasresumidosAux.getSucursal()));		
	}
	
	public static void refrescarForeignKeysDescripcionesVentasResumidos(List<VentasResumidos> ventasresumidossTemp) throws Exception {
		for(VentasResumidos ventasresumidosAux:ventasresumidossTemp) {
			
			ventasresumidosAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(ventasresumidosAux.getEmpresa()));
			ventasresumidosAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(ventasresumidosAux.getSucursal()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfVentasResumidos(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				
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

				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {					
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfVentasResumidos(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfVentasResumidos(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return VentasResumidosConstantesFunciones.getClassesRelationshipsOfVentasResumidos(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfVentasResumidos(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfVentasResumidos(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return VentasResumidosConstantesFunciones.getClassesRelationshipsFromStringsOfVentasResumidos(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfVentasResumidos(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(VentasResumidos ventasresumidos,List<VentasResumidos> ventasresumidoss,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(VentasResumidos ventasresumidos,List<VentasResumidos> ventasresumidoss) throws Exception {
		try	{			
			for(VentasResumidos ventasresumidosLocal:ventasresumidoss) {
				if(ventasresumidosLocal.getId().equals(ventasresumidos.getId())) {
					ventasresumidosLocal.setIsSelected(ventasresumidos.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesVentasResumidos(List<VentasResumidos> ventasresumidossAux) throws Exception {
		//this.ventasresumidossAux=ventasresumidossAux;
		
		for(VentasResumidos ventasresumidosAux:ventasresumidossAux) {
			if(ventasresumidosAux.getIsChanged()) {
				ventasresumidosAux.setIsChanged(false);
			}		
			
			if(ventasresumidosAux.getIsNew()) {
				ventasresumidosAux.setIsNew(false);
			}	
			
			if(ventasresumidosAux.getIsDeleted()) {
				ventasresumidosAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesVentasResumidos(VentasResumidos ventasresumidosAux) throws Exception {
		//this.ventasresumidosAux=ventasresumidosAux;
		
			if(ventasresumidosAux.getIsChanged()) {
				ventasresumidosAux.setIsChanged(false);
			}		
			
			if(ventasresumidosAux.getIsNew()) {
				ventasresumidosAux.setIsNew(false);
			}	
			
			if(ventasresumidosAux.getIsDeleted()) {
				ventasresumidosAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(VentasResumidos ventasresumidosAsignar,VentasResumidos ventasresumidos) throws Exception {
		ventasresumidosAsignar.setId(ventasresumidos.getId());	
		ventasresumidosAsignar.setVersionRow(ventasresumidos.getVersionRow());	
		ventasresumidosAsignar.setnombre_completo(ventasresumidos.getnombre_completo());	
		ventasresumidosAsignar.setruc(ventasresumidos.getruc());	
		ventasresumidosAsignar.setnombre_producto(ventasresumidos.getnombre_producto());	
		ventasresumidosAsignar.setcantidad(ventasresumidos.getcantidad());	
		ventasresumidosAsignar.setprecio(ventasresumidos.getprecio());	
		ventasresumidosAsignar.setmonto(ventasresumidos.getmonto());	
		ventasresumidosAsignar.setcodigo_producto(ventasresumidos.getcodigo_producto());	
	}
	
	public static void inicializarVentasResumidos(VentasResumidos ventasresumidos) throws Exception {
		try {
				ventasresumidos.setId(0L);	
					
				ventasresumidos.setnombre_completo("");	
				ventasresumidos.setruc("");	
				ventasresumidos.setnombre_producto("");	
				ventasresumidos.setcantidad(0);	
				ventasresumidos.setprecio(0.0);	
				ventasresumidos.setmonto(0.0);	
				ventasresumidos.setcodigo_producto("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderVentasResumidos(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(VentasResumidosConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VentasResumidosConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VentasResumidosConstantesFunciones.LABEL_FECHAEMISIONDESDE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VentasResumidosConstantesFunciones.LABEL_FECHAEMISIONHASTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VentasResumidosConstantesFunciones.LABEL_NOMBRECOMPLETO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VentasResumidosConstantesFunciones.LABEL_RUC);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VentasResumidosConstantesFunciones.LABEL_NOMBREPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VentasResumidosConstantesFunciones.LABEL_CANTIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VentasResumidosConstantesFunciones.LABEL_PRECIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VentasResumidosConstantesFunciones.LABEL_MONTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VentasResumidosConstantesFunciones.LABEL_CODIGOPRODUCTO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataVentasResumidos(String sTipo,Row row,Workbook workbook,VentasResumidos ventasresumidos,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(ventasresumidos.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ventasresumidos.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ventasresumidos.getfecha_emision_desde());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ventasresumidos.getfecha_emision_hasta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ventasresumidos.getnombre_completo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ventasresumidos.getruc());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ventasresumidos.getnombre_producto());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ventasresumidos.getcantidad());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ventasresumidos.getprecio());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ventasresumidos.getmonto());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ventasresumidos.getcodigo_producto());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryVentasResumidos="";
	
	public String getsFinalQueryVentasResumidos() {
		return this.sFinalQueryVentasResumidos;
	}
	
	public void setsFinalQueryVentasResumidos(String sFinalQueryVentasResumidos) {
		this.sFinalQueryVentasResumidos= sFinalQueryVentasResumidos;
	}
	
	public Border resaltarSeleccionarVentasResumidos=null;
	
	public Border setResaltarSeleccionarVentasResumidos(ParametroGeneralUsuario parametroGeneralUsuario/*VentasResumidosBeanSwingJInternalFrame ventasresumidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//ventasresumidosBeanSwingJInternalFrame.jTtoolBarVentasResumidos.setBorder(borderResaltar);
		
		this.resaltarSeleccionarVentasResumidos= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarVentasResumidos() {
		return this.resaltarSeleccionarVentasResumidos;
	}
	
	public void setResaltarSeleccionarVentasResumidos(Border borderResaltarSeleccionarVentasResumidos) {
		this.resaltarSeleccionarVentasResumidos= borderResaltarSeleccionarVentasResumidos;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridVentasResumidos=null;
	public Boolean mostraridVentasResumidos=true;
	public Boolean activaridVentasResumidos=true;

	public Border resaltarid_empresaVentasResumidos=null;
	public Boolean mostrarid_empresaVentasResumidos=true;
	public Boolean activarid_empresaVentasResumidos=true;
	public Boolean cargarid_empresaVentasResumidos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaVentasResumidos=false;//ConEventDepend=true

	public Border resaltarid_sucursalVentasResumidos=null;
	public Boolean mostrarid_sucursalVentasResumidos=true;
	public Boolean activarid_sucursalVentasResumidos=true;
	public Boolean cargarid_sucursalVentasResumidos=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalVentasResumidos=false;//ConEventDepend=true

	public Border resaltarfecha_emision_desdeVentasResumidos=null;
	public Boolean mostrarfecha_emision_desdeVentasResumidos=true;
	public Boolean activarfecha_emision_desdeVentasResumidos=true;

	public Border resaltarfecha_emision_hastaVentasResumidos=null;
	public Boolean mostrarfecha_emision_hastaVentasResumidos=true;
	public Boolean activarfecha_emision_hastaVentasResumidos=true;

	public Border resaltarnombre_completoVentasResumidos=null;
	public Boolean mostrarnombre_completoVentasResumidos=true;
	public Boolean activarnombre_completoVentasResumidos=true;

	public Border resaltarrucVentasResumidos=null;
	public Boolean mostrarrucVentasResumidos=true;
	public Boolean activarrucVentasResumidos=true;

	public Border resaltarnombre_productoVentasResumidos=null;
	public Boolean mostrarnombre_productoVentasResumidos=true;
	public Boolean activarnombre_productoVentasResumidos=true;

	public Border resaltarcantidadVentasResumidos=null;
	public Boolean mostrarcantidadVentasResumidos=true;
	public Boolean activarcantidadVentasResumidos=true;

	public Border resaltarprecioVentasResumidos=null;
	public Boolean mostrarprecioVentasResumidos=true;
	public Boolean activarprecioVentasResumidos=true;

	public Border resaltarmontoVentasResumidos=null;
	public Boolean mostrarmontoVentasResumidos=true;
	public Boolean activarmontoVentasResumidos=true;

	public Border resaltarcodigo_productoVentasResumidos=null;
	public Boolean mostrarcodigo_productoVentasResumidos=true;
	public Boolean activarcodigo_productoVentasResumidos=true;

	
	

	public Border setResaltaridVentasResumidos(ParametroGeneralUsuario parametroGeneralUsuario/*VentasResumidosBeanSwingJInternalFrame ventasresumidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventasresumidosBeanSwingJInternalFrame.jTtoolBarVentasResumidos.setBorder(borderResaltar);
		
		this.resaltaridVentasResumidos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridVentasResumidos() {
		return this.resaltaridVentasResumidos;
	}

	public void setResaltaridVentasResumidos(Border borderResaltar) {
		this.resaltaridVentasResumidos= borderResaltar;
	}

	public Boolean getMostraridVentasResumidos() {
		return this.mostraridVentasResumidos;
	}

	public void setMostraridVentasResumidos(Boolean mostraridVentasResumidos) {
		this.mostraridVentasResumidos= mostraridVentasResumidos;
	}

	public Boolean getActivaridVentasResumidos() {
		return this.activaridVentasResumidos;
	}

	public void setActivaridVentasResumidos(Boolean activaridVentasResumidos) {
		this.activaridVentasResumidos= activaridVentasResumidos;
	}

	public Border setResaltarid_empresaVentasResumidos(ParametroGeneralUsuario parametroGeneralUsuario/*VentasResumidosBeanSwingJInternalFrame ventasresumidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventasresumidosBeanSwingJInternalFrame.jTtoolBarVentasResumidos.setBorder(borderResaltar);
		
		this.resaltarid_empresaVentasResumidos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaVentasResumidos() {
		return this.resaltarid_empresaVentasResumidos;
	}

	public void setResaltarid_empresaVentasResumidos(Border borderResaltar) {
		this.resaltarid_empresaVentasResumidos= borderResaltar;
	}

	public Boolean getMostrarid_empresaVentasResumidos() {
		return this.mostrarid_empresaVentasResumidos;
	}

	public void setMostrarid_empresaVentasResumidos(Boolean mostrarid_empresaVentasResumidos) {
		this.mostrarid_empresaVentasResumidos= mostrarid_empresaVentasResumidos;
	}

	public Boolean getActivarid_empresaVentasResumidos() {
		return this.activarid_empresaVentasResumidos;
	}

	public void setActivarid_empresaVentasResumidos(Boolean activarid_empresaVentasResumidos) {
		this.activarid_empresaVentasResumidos= activarid_empresaVentasResumidos;
	}

	public Boolean getCargarid_empresaVentasResumidos() {
		return this.cargarid_empresaVentasResumidos;
	}

	public void setCargarid_empresaVentasResumidos(Boolean cargarid_empresaVentasResumidos) {
		this.cargarid_empresaVentasResumidos= cargarid_empresaVentasResumidos;
	}

	public Border setResaltarid_sucursalVentasResumidos(ParametroGeneralUsuario parametroGeneralUsuario/*VentasResumidosBeanSwingJInternalFrame ventasresumidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventasresumidosBeanSwingJInternalFrame.jTtoolBarVentasResumidos.setBorder(borderResaltar);
		
		this.resaltarid_sucursalVentasResumidos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalVentasResumidos() {
		return this.resaltarid_sucursalVentasResumidos;
	}

	public void setResaltarid_sucursalVentasResumidos(Border borderResaltar) {
		this.resaltarid_sucursalVentasResumidos= borderResaltar;
	}

	public Boolean getMostrarid_sucursalVentasResumidos() {
		return this.mostrarid_sucursalVentasResumidos;
	}

	public void setMostrarid_sucursalVentasResumidos(Boolean mostrarid_sucursalVentasResumidos) {
		this.mostrarid_sucursalVentasResumidos= mostrarid_sucursalVentasResumidos;
	}

	public Boolean getActivarid_sucursalVentasResumidos() {
		return this.activarid_sucursalVentasResumidos;
	}

	public void setActivarid_sucursalVentasResumidos(Boolean activarid_sucursalVentasResumidos) {
		this.activarid_sucursalVentasResumidos= activarid_sucursalVentasResumidos;
	}

	public Boolean getCargarid_sucursalVentasResumidos() {
		return this.cargarid_sucursalVentasResumidos;
	}

	public void setCargarid_sucursalVentasResumidos(Boolean cargarid_sucursalVentasResumidos) {
		this.cargarid_sucursalVentasResumidos= cargarid_sucursalVentasResumidos;
	}

	public Border setResaltarfecha_emision_desdeVentasResumidos(ParametroGeneralUsuario parametroGeneralUsuario/*VentasResumidosBeanSwingJInternalFrame ventasresumidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventasresumidosBeanSwingJInternalFrame.jTtoolBarVentasResumidos.setBorder(borderResaltar);
		
		this.resaltarfecha_emision_desdeVentasResumidos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emision_desdeVentasResumidos() {
		return this.resaltarfecha_emision_desdeVentasResumidos;
	}

	public void setResaltarfecha_emision_desdeVentasResumidos(Border borderResaltar) {
		this.resaltarfecha_emision_desdeVentasResumidos= borderResaltar;
	}

	public Boolean getMostrarfecha_emision_desdeVentasResumidos() {
		return this.mostrarfecha_emision_desdeVentasResumidos;
	}

	public void setMostrarfecha_emision_desdeVentasResumidos(Boolean mostrarfecha_emision_desdeVentasResumidos) {
		this.mostrarfecha_emision_desdeVentasResumidos= mostrarfecha_emision_desdeVentasResumidos;
	}

	public Boolean getActivarfecha_emision_desdeVentasResumidos() {
		return this.activarfecha_emision_desdeVentasResumidos;
	}

	public void setActivarfecha_emision_desdeVentasResumidos(Boolean activarfecha_emision_desdeVentasResumidos) {
		this.activarfecha_emision_desdeVentasResumidos= activarfecha_emision_desdeVentasResumidos;
	}

	public Border setResaltarfecha_emision_hastaVentasResumidos(ParametroGeneralUsuario parametroGeneralUsuario/*VentasResumidosBeanSwingJInternalFrame ventasresumidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventasresumidosBeanSwingJInternalFrame.jTtoolBarVentasResumidos.setBorder(borderResaltar);
		
		this.resaltarfecha_emision_hastaVentasResumidos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emision_hastaVentasResumidos() {
		return this.resaltarfecha_emision_hastaVentasResumidos;
	}

	public void setResaltarfecha_emision_hastaVentasResumidos(Border borderResaltar) {
		this.resaltarfecha_emision_hastaVentasResumidos= borderResaltar;
	}

	public Boolean getMostrarfecha_emision_hastaVentasResumidos() {
		return this.mostrarfecha_emision_hastaVentasResumidos;
	}

	public void setMostrarfecha_emision_hastaVentasResumidos(Boolean mostrarfecha_emision_hastaVentasResumidos) {
		this.mostrarfecha_emision_hastaVentasResumidos= mostrarfecha_emision_hastaVentasResumidos;
	}

	public Boolean getActivarfecha_emision_hastaVentasResumidos() {
		return this.activarfecha_emision_hastaVentasResumidos;
	}

	public void setActivarfecha_emision_hastaVentasResumidos(Boolean activarfecha_emision_hastaVentasResumidos) {
		this.activarfecha_emision_hastaVentasResumidos= activarfecha_emision_hastaVentasResumidos;
	}

	public Border setResaltarnombre_completoVentasResumidos(ParametroGeneralUsuario parametroGeneralUsuario/*VentasResumidosBeanSwingJInternalFrame ventasresumidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventasresumidosBeanSwingJInternalFrame.jTtoolBarVentasResumidos.setBorder(borderResaltar);
		
		this.resaltarnombre_completoVentasResumidos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_completoVentasResumidos() {
		return this.resaltarnombre_completoVentasResumidos;
	}

	public void setResaltarnombre_completoVentasResumidos(Border borderResaltar) {
		this.resaltarnombre_completoVentasResumidos= borderResaltar;
	}

	public Boolean getMostrarnombre_completoVentasResumidos() {
		return this.mostrarnombre_completoVentasResumidos;
	}

	public void setMostrarnombre_completoVentasResumidos(Boolean mostrarnombre_completoVentasResumidos) {
		this.mostrarnombre_completoVentasResumidos= mostrarnombre_completoVentasResumidos;
	}

	public Boolean getActivarnombre_completoVentasResumidos() {
		return this.activarnombre_completoVentasResumidos;
	}

	public void setActivarnombre_completoVentasResumidos(Boolean activarnombre_completoVentasResumidos) {
		this.activarnombre_completoVentasResumidos= activarnombre_completoVentasResumidos;
	}

	public Border setResaltarrucVentasResumidos(ParametroGeneralUsuario parametroGeneralUsuario/*VentasResumidosBeanSwingJInternalFrame ventasresumidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventasresumidosBeanSwingJInternalFrame.jTtoolBarVentasResumidos.setBorder(borderResaltar);
		
		this.resaltarrucVentasResumidos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarrucVentasResumidos() {
		return this.resaltarrucVentasResumidos;
	}

	public void setResaltarrucVentasResumidos(Border borderResaltar) {
		this.resaltarrucVentasResumidos= borderResaltar;
	}

	public Boolean getMostrarrucVentasResumidos() {
		return this.mostrarrucVentasResumidos;
	}

	public void setMostrarrucVentasResumidos(Boolean mostrarrucVentasResumidos) {
		this.mostrarrucVentasResumidos= mostrarrucVentasResumidos;
	}

	public Boolean getActivarrucVentasResumidos() {
		return this.activarrucVentasResumidos;
	}

	public void setActivarrucVentasResumidos(Boolean activarrucVentasResumidos) {
		this.activarrucVentasResumidos= activarrucVentasResumidos;
	}

	public Border setResaltarnombre_productoVentasResumidos(ParametroGeneralUsuario parametroGeneralUsuario/*VentasResumidosBeanSwingJInternalFrame ventasresumidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventasresumidosBeanSwingJInternalFrame.jTtoolBarVentasResumidos.setBorder(borderResaltar);
		
		this.resaltarnombre_productoVentasResumidos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_productoVentasResumidos() {
		return this.resaltarnombre_productoVentasResumidos;
	}

	public void setResaltarnombre_productoVentasResumidos(Border borderResaltar) {
		this.resaltarnombre_productoVentasResumidos= borderResaltar;
	}

	public Boolean getMostrarnombre_productoVentasResumidos() {
		return this.mostrarnombre_productoVentasResumidos;
	}

	public void setMostrarnombre_productoVentasResumidos(Boolean mostrarnombre_productoVentasResumidos) {
		this.mostrarnombre_productoVentasResumidos= mostrarnombre_productoVentasResumidos;
	}

	public Boolean getActivarnombre_productoVentasResumidos() {
		return this.activarnombre_productoVentasResumidos;
	}

	public void setActivarnombre_productoVentasResumidos(Boolean activarnombre_productoVentasResumidos) {
		this.activarnombre_productoVentasResumidos= activarnombre_productoVentasResumidos;
	}

	public Border setResaltarcantidadVentasResumidos(ParametroGeneralUsuario parametroGeneralUsuario/*VentasResumidosBeanSwingJInternalFrame ventasresumidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventasresumidosBeanSwingJInternalFrame.jTtoolBarVentasResumidos.setBorder(borderResaltar);
		
		this.resaltarcantidadVentasResumidos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcantidadVentasResumidos() {
		return this.resaltarcantidadVentasResumidos;
	}

	public void setResaltarcantidadVentasResumidos(Border borderResaltar) {
		this.resaltarcantidadVentasResumidos= borderResaltar;
	}

	public Boolean getMostrarcantidadVentasResumidos() {
		return this.mostrarcantidadVentasResumidos;
	}

	public void setMostrarcantidadVentasResumidos(Boolean mostrarcantidadVentasResumidos) {
		this.mostrarcantidadVentasResumidos= mostrarcantidadVentasResumidos;
	}

	public Boolean getActivarcantidadVentasResumidos() {
		return this.activarcantidadVentasResumidos;
	}

	public void setActivarcantidadVentasResumidos(Boolean activarcantidadVentasResumidos) {
		this.activarcantidadVentasResumidos= activarcantidadVentasResumidos;
	}

	public Border setResaltarprecioVentasResumidos(ParametroGeneralUsuario parametroGeneralUsuario/*VentasResumidosBeanSwingJInternalFrame ventasresumidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventasresumidosBeanSwingJInternalFrame.jTtoolBarVentasResumidos.setBorder(borderResaltar);
		
		this.resaltarprecioVentasResumidos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarprecioVentasResumidos() {
		return this.resaltarprecioVentasResumidos;
	}

	public void setResaltarprecioVentasResumidos(Border borderResaltar) {
		this.resaltarprecioVentasResumidos= borderResaltar;
	}

	public Boolean getMostrarprecioVentasResumidos() {
		return this.mostrarprecioVentasResumidos;
	}

	public void setMostrarprecioVentasResumidos(Boolean mostrarprecioVentasResumidos) {
		this.mostrarprecioVentasResumidos= mostrarprecioVentasResumidos;
	}

	public Boolean getActivarprecioVentasResumidos() {
		return this.activarprecioVentasResumidos;
	}

	public void setActivarprecioVentasResumidos(Boolean activarprecioVentasResumidos) {
		this.activarprecioVentasResumidos= activarprecioVentasResumidos;
	}

	public Border setResaltarmontoVentasResumidos(ParametroGeneralUsuario parametroGeneralUsuario/*VentasResumidosBeanSwingJInternalFrame ventasresumidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventasresumidosBeanSwingJInternalFrame.jTtoolBarVentasResumidos.setBorder(borderResaltar);
		
		this.resaltarmontoVentasResumidos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarmontoVentasResumidos() {
		return this.resaltarmontoVentasResumidos;
	}

	public void setResaltarmontoVentasResumidos(Border borderResaltar) {
		this.resaltarmontoVentasResumidos= borderResaltar;
	}

	public Boolean getMostrarmontoVentasResumidos() {
		return this.mostrarmontoVentasResumidos;
	}

	public void setMostrarmontoVentasResumidos(Boolean mostrarmontoVentasResumidos) {
		this.mostrarmontoVentasResumidos= mostrarmontoVentasResumidos;
	}

	public Boolean getActivarmontoVentasResumidos() {
		return this.activarmontoVentasResumidos;
	}

	public void setActivarmontoVentasResumidos(Boolean activarmontoVentasResumidos) {
		this.activarmontoVentasResumidos= activarmontoVentasResumidos;
	}

	public Border setResaltarcodigo_productoVentasResumidos(ParametroGeneralUsuario parametroGeneralUsuario/*VentasResumidosBeanSwingJInternalFrame ventasresumidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventasresumidosBeanSwingJInternalFrame.jTtoolBarVentasResumidos.setBorder(borderResaltar);
		
		this.resaltarcodigo_productoVentasResumidos= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigo_productoVentasResumidos() {
		return this.resaltarcodigo_productoVentasResumidos;
	}

	public void setResaltarcodigo_productoVentasResumidos(Border borderResaltar) {
		this.resaltarcodigo_productoVentasResumidos= borderResaltar;
	}

	public Boolean getMostrarcodigo_productoVentasResumidos() {
		return this.mostrarcodigo_productoVentasResumidos;
	}

	public void setMostrarcodigo_productoVentasResumidos(Boolean mostrarcodigo_productoVentasResumidos) {
		this.mostrarcodigo_productoVentasResumidos= mostrarcodigo_productoVentasResumidos;
	}

	public Boolean getActivarcodigo_productoVentasResumidos() {
		return this.activarcodigo_productoVentasResumidos;
	}

	public void setActivarcodigo_productoVentasResumidos(Boolean activarcodigo_productoVentasResumidos) {
		this.activarcodigo_productoVentasResumidos= activarcodigo_productoVentasResumidos;
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
		
		
		this.setMostraridVentasResumidos(esInicial);
		this.setMostrarid_empresaVentasResumidos(esInicial);
		this.setMostrarid_sucursalVentasResumidos(esInicial);
		this.setMostrarfecha_emision_desdeVentasResumidos(esInicial);
		this.setMostrarfecha_emision_hastaVentasResumidos(esInicial);
		this.setMostrarnombre_completoVentasResumidos(esInicial);
		this.setMostrarrucVentasResumidos(esInicial);
		this.setMostrarnombre_productoVentasResumidos(esInicial);
		this.setMostrarcantidadVentasResumidos(esInicial);
		this.setMostrarprecioVentasResumidos(esInicial);
		this.setMostrarmontoVentasResumidos(esInicial);
		this.setMostrarcodigo_productoVentasResumidos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(VentasResumidosConstantesFunciones.ID)) {
				this.setMostraridVentasResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasResumidosConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaVentasResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasResumidosConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalVentasResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasResumidosConstantesFunciones.FECHAEMISIONDESDE)) {
				this.setMostrarfecha_emision_desdeVentasResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasResumidosConstantesFunciones.FECHAEMISIONHASTA)) {
				this.setMostrarfecha_emision_hastaVentasResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasResumidosConstantesFunciones.NOMBRECOMPLETO)) {
				this.setMostrarnombre_completoVentasResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasResumidosConstantesFunciones.RUC)) {
				this.setMostrarrucVentasResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasResumidosConstantesFunciones.NOMBREPRODUCTO)) {
				this.setMostrarnombre_productoVentasResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasResumidosConstantesFunciones.CANTIDAD)) {
				this.setMostrarcantidadVentasResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasResumidosConstantesFunciones.PRECIO)) {
				this.setMostrarprecioVentasResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasResumidosConstantesFunciones.MONTO)) {
				this.setMostrarmontoVentasResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasResumidosConstantesFunciones.CODIGOPRODUCTO)) {
				this.setMostrarcodigo_productoVentasResumidos(esAsigna);
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
		
		
		this.setActivaridVentasResumidos(esInicial);
		this.setActivarid_empresaVentasResumidos(esInicial);
		this.setActivarid_sucursalVentasResumidos(esInicial);
		this.setActivarfecha_emision_desdeVentasResumidos(esInicial);
		this.setActivarfecha_emision_hastaVentasResumidos(esInicial);
		this.setActivarnombre_completoVentasResumidos(esInicial);
		this.setActivarrucVentasResumidos(esInicial);
		this.setActivarnombre_productoVentasResumidos(esInicial);
		this.setActivarcantidadVentasResumidos(esInicial);
		this.setActivarprecioVentasResumidos(esInicial);
		this.setActivarmontoVentasResumidos(esInicial);
		this.setActivarcodigo_productoVentasResumidos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(VentasResumidosConstantesFunciones.ID)) {
				this.setActivaridVentasResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasResumidosConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaVentasResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasResumidosConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalVentasResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasResumidosConstantesFunciones.FECHAEMISIONDESDE)) {
				this.setActivarfecha_emision_desdeVentasResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasResumidosConstantesFunciones.FECHAEMISIONHASTA)) {
				this.setActivarfecha_emision_hastaVentasResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasResumidosConstantesFunciones.NOMBRECOMPLETO)) {
				this.setActivarnombre_completoVentasResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasResumidosConstantesFunciones.RUC)) {
				this.setActivarrucVentasResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasResumidosConstantesFunciones.NOMBREPRODUCTO)) {
				this.setActivarnombre_productoVentasResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasResumidosConstantesFunciones.CANTIDAD)) {
				this.setActivarcantidadVentasResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasResumidosConstantesFunciones.PRECIO)) {
				this.setActivarprecioVentasResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasResumidosConstantesFunciones.MONTO)) {
				this.setActivarmontoVentasResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasResumidosConstantesFunciones.CODIGOPRODUCTO)) {
				this.setActivarcodigo_productoVentasResumidos(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,VentasResumidosBeanSwingJInternalFrame ventasresumidosBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridVentasResumidos(esInicial);
		this.setResaltarid_empresaVentasResumidos(esInicial);
		this.setResaltarid_sucursalVentasResumidos(esInicial);
		this.setResaltarfecha_emision_desdeVentasResumidos(esInicial);
		this.setResaltarfecha_emision_hastaVentasResumidos(esInicial);
		this.setResaltarnombre_completoVentasResumidos(esInicial);
		this.setResaltarrucVentasResumidos(esInicial);
		this.setResaltarnombre_productoVentasResumidos(esInicial);
		this.setResaltarcantidadVentasResumidos(esInicial);
		this.setResaltarprecioVentasResumidos(esInicial);
		this.setResaltarmontoVentasResumidos(esInicial);
		this.setResaltarcodigo_productoVentasResumidos(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(VentasResumidosConstantesFunciones.ID)) {
				this.setResaltaridVentasResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasResumidosConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaVentasResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasResumidosConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalVentasResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasResumidosConstantesFunciones.FECHAEMISIONDESDE)) {
				this.setResaltarfecha_emision_desdeVentasResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasResumidosConstantesFunciones.FECHAEMISIONHASTA)) {
				this.setResaltarfecha_emision_hastaVentasResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasResumidosConstantesFunciones.NOMBRECOMPLETO)) {
				this.setResaltarnombre_completoVentasResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasResumidosConstantesFunciones.RUC)) {
				this.setResaltarrucVentasResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasResumidosConstantesFunciones.NOMBREPRODUCTO)) {
				this.setResaltarnombre_productoVentasResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasResumidosConstantesFunciones.CANTIDAD)) {
				this.setResaltarcantidadVentasResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasResumidosConstantesFunciones.PRECIO)) {
				this.setResaltarprecioVentasResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasResumidosConstantesFunciones.MONTO)) {
				this.setResaltarmontoVentasResumidos(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentasResumidosConstantesFunciones.CODIGOPRODUCTO)) {
				this.setResaltarcodigo_productoVentasResumidos(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,VentasResumidosBeanSwingJInternalFrame ventasresumidosBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaVentasResumidosVentasResumidos=true;

	public Boolean getMostrarBusquedaVentasResumidosVentasResumidos() {
		return this.mostrarBusquedaVentasResumidosVentasResumidos;
	}

	public void setMostrarBusquedaVentasResumidosVentasResumidos(Boolean visibilidadResaltar) {
		this.mostrarBusquedaVentasResumidosVentasResumidos= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaVentasResumidosVentasResumidos=true;

	public Boolean getActivarBusquedaVentasResumidosVentasResumidos() {
		return this.activarBusquedaVentasResumidosVentasResumidos;
	}

	public void setActivarBusquedaVentasResumidosVentasResumidos(Boolean habilitarResaltar) {
		this.activarBusquedaVentasResumidosVentasResumidos= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaVentasResumidosVentasResumidos=null;

	public Border getResaltarBusquedaVentasResumidosVentasResumidos() {
		return this.resaltarBusquedaVentasResumidosVentasResumidos;
	}

	public void setResaltarBusquedaVentasResumidosVentasResumidos(Border borderResaltar) {
		this.resaltarBusquedaVentasResumidosVentasResumidos= borderResaltar;
	}

	public void setResaltarBusquedaVentasResumidosVentasResumidos(ParametroGeneralUsuario parametroGeneralUsuario/*VentasResumidosBeanSwingJInternalFrame ventasresumidosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaVentasResumidosVentasResumidos= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}