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
package com.bydan.erp.puntoventa.util.report;

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


import com.bydan.erp.puntoventa.util.report.VentaPorLineaConstantesFunciones;
import com.bydan.erp.puntoventa.util.report.VentaPorLineaParameterReturnGeneral;
//import com.bydan.erp.puntoventa.util.report.VentaPorLineaParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.puntoventa.business.entity.*;
import com.bydan.erp.puntoventa.business.entity.report.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.inventario.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.puntoventa.business.dataaccess.*;
//import com.bydan.erp.puntoventa.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class VentaPorLineaConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="VentaPorLinea";
	public static final String SPATHOPCION="PuntoVenta";	
	public static final String SPATHMODULO="puntoventa/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="VentaPorLinea"+VentaPorLineaConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="VentaPorLineaHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="VentaPorLineaHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=VentaPorLineaConstantesFunciones.SCHEMA+"_"+VentaPorLineaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/VentaPorLineaHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=VentaPorLineaConstantesFunciones.SCHEMA+"_"+VentaPorLineaConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=VentaPorLineaConstantesFunciones.SCHEMA+"_"+VentaPorLineaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/VentaPorLineaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=VentaPorLineaConstantesFunciones.SCHEMA+"_"+VentaPorLineaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+VentaPorLineaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/VentaPorLineaHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+VentaPorLineaConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+VentaPorLineaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/VentaPorLineaHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+VentaPorLineaConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=VentaPorLineaConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+VentaPorLineaConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=VentaPorLineaConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+VentaPorLineaConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Venta Por Lineas";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Venta Por Linea";
	public static final String SCLASSWEBTITULO_LOWER="Venta Por Linea";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="VentaPorLinea";
	public static final String OBJECTNAME="ventaporlinea";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_PUNTOVENTA;	
	public static final String TABLENAME="venta_por_linea";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select ventaporlinea from "+VentaPorLineaConstantesFunciones.SPERSISTENCENAME+" ventaporlinea";
	public static String QUERYSELECTNATIVE="select "+VentaPorLineaConstantesFunciones.SCHEMA+"."+VentaPorLineaConstantesFunciones.TABLENAME+".id,"+VentaPorLineaConstantesFunciones.SCHEMA+"."+VentaPorLineaConstantesFunciones.TABLENAME+".version_row,"+VentaPorLineaConstantesFunciones.SCHEMA+"."+VentaPorLineaConstantesFunciones.TABLENAME+".id_empresa,"+VentaPorLineaConstantesFunciones.SCHEMA+"."+VentaPorLineaConstantesFunciones.TABLENAME+".id_sucursal,"+VentaPorLineaConstantesFunciones.SCHEMA+"."+VentaPorLineaConstantesFunciones.TABLENAME+".id_producto,"+VentaPorLineaConstantesFunciones.SCHEMA+"."+VentaPorLineaConstantesFunciones.TABLENAME+".id_linea,"+VentaPorLineaConstantesFunciones.SCHEMA+"."+VentaPorLineaConstantesFunciones.TABLENAME+".id_linea_grupo,"+VentaPorLineaConstantesFunciones.SCHEMA+"."+VentaPorLineaConstantesFunciones.TABLENAME+".id_linea_categoria,"+VentaPorLineaConstantesFunciones.SCHEMA+"."+VentaPorLineaConstantesFunciones.TABLENAME+".id_linea_marca,"+VentaPorLineaConstantesFunciones.SCHEMA+"."+VentaPorLineaConstantesFunciones.TABLENAME+".fecha_desde,"+VentaPorLineaConstantesFunciones.SCHEMA+"."+VentaPorLineaConstantesFunciones.TABLENAME+".fecha_hasta,"+VentaPorLineaConstantesFunciones.SCHEMA+"."+VentaPorLineaConstantesFunciones.TABLENAME+".nombre_producto,"+VentaPorLineaConstantesFunciones.SCHEMA+"."+VentaPorLineaConstantesFunciones.TABLENAME+".nombre_linea,"+VentaPorLineaConstantesFunciones.SCHEMA+"."+VentaPorLineaConstantesFunciones.TABLENAME+".nombre_grupo,"+VentaPorLineaConstantesFunciones.SCHEMA+"."+VentaPorLineaConstantesFunciones.TABLENAME+".nombre_categoria,"+VentaPorLineaConstantesFunciones.SCHEMA+"."+VentaPorLineaConstantesFunciones.TABLENAME+".nombre_marca,"+VentaPorLineaConstantesFunciones.SCHEMA+"."+VentaPorLineaConstantesFunciones.TABLENAME+".fecha,"+VentaPorLineaConstantesFunciones.SCHEMA+"."+VentaPorLineaConstantesFunciones.TABLENAME+".secuencial,"+VentaPorLineaConstantesFunciones.SCHEMA+"."+VentaPorLineaConstantesFunciones.TABLENAME+".cantidad,"+VentaPorLineaConstantesFunciones.SCHEMA+"."+VentaPorLineaConstantesFunciones.TABLENAME+".precio,"+VentaPorLineaConstantesFunciones.SCHEMA+"."+VentaPorLineaConstantesFunciones.TABLENAME+".descuento,"+VentaPorLineaConstantesFunciones.SCHEMA+"."+VentaPorLineaConstantesFunciones.TABLENAME+".iva,"+VentaPorLineaConstantesFunciones.SCHEMA+"."+VentaPorLineaConstantesFunciones.TABLENAME+".ice from "+VentaPorLineaConstantesFunciones.SCHEMA+"."+VentaPorLineaConstantesFunciones.TABLENAME;//+" as "+VentaPorLineaConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDPRODUCTO= "id_producto";
    public static final String IDLINEA= "id_linea";
    public static final String IDLINEAGRUPO= "id_linea_grupo";
    public static final String IDLINEACATEGORIA= "id_linea_categoria";
    public static final String IDLINEAMARCA= "id_linea_marca";
    public static final String FECHADESDE= "fecha_desde";
    public static final String FECHAHASTA= "fecha_hasta";
    public static final String NOMBREPRODUCTO= "nombre_producto";
    public static final String NOMBRELINEA= "nombre_linea";
    public static final String NOMBREGRUPO= "nombre_grupo";
    public static final String NOMBRECATEGORIA= "nombre_categoria";
    public static final String NOMBREMARCA= "nombre_marca";
    public static final String FECHA= "fecha";
    public static final String SECUENCIAL= "secuencial";
    public static final String CANTIDAD= "cantidad";
    public static final String PRECIO= "precio";
    public static final String DESCUENTO= "descuento";
    public static final String IVA= "iva";
    public static final String ICE= "ice";
	//TITULO CAMPO
    	public static final String LABEL_ID= "";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDPRODUCTO= "Producto";
		public static final String LABEL_IDPRODUCTO_LOWER= "Producto";
    	public static final String LABEL_IDLINEA= "Linea";
		public static final String LABEL_IDLINEA_LOWER= "Linea";
    	public static final String LABEL_IDLINEAGRUPO= "Linea Grupo";
		public static final String LABEL_IDLINEAGRUPO_LOWER= "Linea Grupo";
    	public static final String LABEL_IDLINEACATEGORIA= "Linea Categoria";
		public static final String LABEL_IDLINEACATEGORIA_LOWER= "Linea Categoria";
    	public static final String LABEL_IDLINEAMARCA= "Linea Marca";
		public static final String LABEL_IDLINEAMARCA_LOWER= "Linea Marca";
    	public static final String LABEL_FECHADESDE= "Fecha Desde";
		public static final String LABEL_FECHADESDE_LOWER= "Fecha Desde";
    	public static final String LABEL_FECHAHASTA= "Fecha Hasta";
		public static final String LABEL_FECHAHASTA_LOWER= "Fecha Hasta";
    	public static final String LABEL_NOMBREPRODUCTO= "Nombre Producto";
		public static final String LABEL_NOMBREPRODUCTO_LOWER= "Nombre Producto";
    	public static final String LABEL_NOMBRELINEA= "Nombre Linea";
		public static final String LABEL_NOMBRELINEA_LOWER= "Nombre Linea";
    	public static final String LABEL_NOMBREGRUPO= "Nombre Grupo";
		public static final String LABEL_NOMBREGRUPO_LOWER= "Nombre Grupo";
    	public static final String LABEL_NOMBRECATEGORIA= "Nombre Categoria";
		public static final String LABEL_NOMBRECATEGORIA_LOWER= "Nombre Categoria";
    	public static final String LABEL_NOMBREMARCA= "Nombre Marca";
		public static final String LABEL_NOMBREMARCA_LOWER= "Nombre Marca";
    	public static final String LABEL_FECHA= "Fecha";
		public static final String LABEL_FECHA_LOWER= "Fecha";
    	public static final String LABEL_SECUENCIAL= "Secuencial";
		public static final String LABEL_SECUENCIAL_LOWER= "Secuencial";
    	public static final String LABEL_CANTIDAD= "Cantad";
		public static final String LABEL_CANTIDAD_LOWER= "Cantidad";
    	public static final String LABEL_PRECIO= "Precio";
		public static final String LABEL_PRECIO_LOWER= "Precio";
    	public static final String LABEL_DESCUENTO= "Descuento";
		public static final String LABEL_DESCUENTO_LOWER= "Descuento";
    	public static final String LABEL_IVA= "Iva";
		public static final String LABEL_IVA_LOWER= "Iva";
    	public static final String LABEL_ICE= "Ice";
		public static final String LABEL_ICE_LOWER= "Ice";
	
		
		
		
		
		
		
		
		
		
		
		
	public static final String SREGEXNOMBRE_PRODUCTO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_PRODUCTO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_LINEA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_LINEA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_GRUPO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_GRUPO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_CATEGORIA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_CATEGORIA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_MARCA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_MARCA=ConstantesValidacion.SVALIDACIONCADENA;	
		
	public static final String SREGEXSECUENCIAL=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXSECUENCIAL=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
	
	public static String getVentaPorLineaLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(VentaPorLineaConstantesFunciones.IDEMPRESA)) {sLabelColumna=VentaPorLineaConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(VentaPorLineaConstantesFunciones.IDSUCURSAL)) {sLabelColumna=VentaPorLineaConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(VentaPorLineaConstantesFunciones.IDPRODUCTO)) {sLabelColumna=VentaPorLineaConstantesFunciones.LABEL_IDPRODUCTO;}
		if(sNombreColumna.equals(VentaPorLineaConstantesFunciones.IDLINEA)) {sLabelColumna=VentaPorLineaConstantesFunciones.LABEL_IDLINEA;}
		if(sNombreColumna.equals(VentaPorLineaConstantesFunciones.IDLINEAGRUPO)) {sLabelColumna=VentaPorLineaConstantesFunciones.LABEL_IDLINEAGRUPO;}
		if(sNombreColumna.equals(VentaPorLineaConstantesFunciones.IDLINEACATEGORIA)) {sLabelColumna=VentaPorLineaConstantesFunciones.LABEL_IDLINEACATEGORIA;}
		if(sNombreColumna.equals(VentaPorLineaConstantesFunciones.IDLINEAMARCA)) {sLabelColumna=VentaPorLineaConstantesFunciones.LABEL_IDLINEAMARCA;}
		if(sNombreColumna.equals(VentaPorLineaConstantesFunciones.FECHADESDE)) {sLabelColumna=VentaPorLineaConstantesFunciones.LABEL_FECHADESDE;}
		if(sNombreColumna.equals(VentaPorLineaConstantesFunciones.FECHAHASTA)) {sLabelColumna=VentaPorLineaConstantesFunciones.LABEL_FECHAHASTA;}
		if(sNombreColumna.equals(VentaPorLineaConstantesFunciones.NOMBREPRODUCTO)) {sLabelColumna=VentaPorLineaConstantesFunciones.LABEL_NOMBREPRODUCTO;}
		if(sNombreColumna.equals(VentaPorLineaConstantesFunciones.NOMBRELINEA)) {sLabelColumna=VentaPorLineaConstantesFunciones.LABEL_NOMBRELINEA;}
		if(sNombreColumna.equals(VentaPorLineaConstantesFunciones.NOMBREGRUPO)) {sLabelColumna=VentaPorLineaConstantesFunciones.LABEL_NOMBREGRUPO;}
		if(sNombreColumna.equals(VentaPorLineaConstantesFunciones.NOMBRECATEGORIA)) {sLabelColumna=VentaPorLineaConstantesFunciones.LABEL_NOMBRECATEGORIA;}
		if(sNombreColumna.equals(VentaPorLineaConstantesFunciones.NOMBREMARCA)) {sLabelColumna=VentaPorLineaConstantesFunciones.LABEL_NOMBREMARCA;}
		if(sNombreColumna.equals(VentaPorLineaConstantesFunciones.FECHA)) {sLabelColumna=VentaPorLineaConstantesFunciones.LABEL_FECHA;}
		if(sNombreColumna.equals(VentaPorLineaConstantesFunciones.SECUENCIAL)) {sLabelColumna=VentaPorLineaConstantesFunciones.LABEL_SECUENCIAL;}
		if(sNombreColumna.equals(VentaPorLineaConstantesFunciones.CANTIDAD)) {sLabelColumna=VentaPorLineaConstantesFunciones.LABEL_CANTIDAD;}
		if(sNombreColumna.equals(VentaPorLineaConstantesFunciones.PRECIO)) {sLabelColumna=VentaPorLineaConstantesFunciones.LABEL_PRECIO;}
		if(sNombreColumna.equals(VentaPorLineaConstantesFunciones.DESCUENTO)) {sLabelColumna=VentaPorLineaConstantesFunciones.LABEL_DESCUENTO;}
		if(sNombreColumna.equals(VentaPorLineaConstantesFunciones.IVA)) {sLabelColumna=VentaPorLineaConstantesFunciones.LABEL_IVA;}
		if(sNombreColumna.equals(VentaPorLineaConstantesFunciones.ICE)) {sLabelColumna=VentaPorLineaConstantesFunciones.LABEL_ICE;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getVentaPorLineaDescripcion(VentaPorLinea ventaporlinea) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(ventaporlinea !=null/* && ventaporlinea.getId()!=0*/) {
			if(ventaporlinea.getId()!=null) {
				sDescripcion=ventaporlinea.getId().toString();
			}//ventaporlineaventaporlinea.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getVentaPorLineaDescripcionDetallado(VentaPorLinea ventaporlinea) {
		String sDescripcion="";
			
		sDescripcion+=VentaPorLineaConstantesFunciones.ID+"=";
		sDescripcion+=ventaporlinea.getId().toString()+",";
		sDescripcion+=VentaPorLineaConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=ventaporlinea.getVersionRow().toString()+",";
		sDescripcion+=VentaPorLineaConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=ventaporlinea.getid_empresa().toString()+",";
		sDescripcion+=VentaPorLineaConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=ventaporlinea.getid_sucursal().toString()+",";
		sDescripcion+=VentaPorLineaConstantesFunciones.IDPRODUCTO+"=";
		sDescripcion+=ventaporlinea.getid_producto().toString()+",";
		sDescripcion+=VentaPorLineaConstantesFunciones.IDLINEA+"=";
		sDescripcion+=ventaporlinea.getid_linea().toString()+",";
		sDescripcion+=VentaPorLineaConstantesFunciones.IDLINEAGRUPO+"=";
		sDescripcion+=ventaporlinea.getid_linea_grupo().toString()+",";
		sDescripcion+=VentaPorLineaConstantesFunciones.IDLINEACATEGORIA+"=";
		sDescripcion+=ventaporlinea.getid_linea_categoria().toString()+",";
		sDescripcion+=VentaPorLineaConstantesFunciones.IDLINEAMARCA+"=";
		sDescripcion+=ventaporlinea.getid_linea_marca().toString()+",";
		sDescripcion+=VentaPorLineaConstantesFunciones.FECHADESDE+"=";
		sDescripcion+=ventaporlinea.getfecha_desde().toString()+",";
		sDescripcion+=VentaPorLineaConstantesFunciones.FECHAHASTA+"=";
		sDescripcion+=ventaporlinea.getfecha_hasta().toString()+",";
		sDescripcion+=VentaPorLineaConstantesFunciones.NOMBREPRODUCTO+"=";
		sDescripcion+=ventaporlinea.getnombre_producto()+",";
		sDescripcion+=VentaPorLineaConstantesFunciones.NOMBRELINEA+"=";
		sDescripcion+=ventaporlinea.getnombre_linea()+",";
		sDescripcion+=VentaPorLineaConstantesFunciones.NOMBREGRUPO+"=";
		sDescripcion+=ventaporlinea.getnombre_grupo()+",";
		sDescripcion+=VentaPorLineaConstantesFunciones.NOMBRECATEGORIA+"=";
		sDescripcion+=ventaporlinea.getnombre_categoria()+",";
		sDescripcion+=VentaPorLineaConstantesFunciones.NOMBREMARCA+"=";
		sDescripcion+=ventaporlinea.getnombre_marca()+",";
		sDescripcion+=VentaPorLineaConstantesFunciones.FECHA+"=";
		sDescripcion+=ventaporlinea.getfecha().toString()+",";
		sDescripcion+=VentaPorLineaConstantesFunciones.SECUENCIAL+"=";
		sDescripcion+=ventaporlinea.getsecuencial()+",";
		sDescripcion+=VentaPorLineaConstantesFunciones.CANTIDAD+"=";
		sDescripcion+=ventaporlinea.getcantidad().toString()+",";
		sDescripcion+=VentaPorLineaConstantesFunciones.PRECIO+"=";
		sDescripcion+=ventaporlinea.getprecio().toString()+",";
		sDescripcion+=VentaPorLineaConstantesFunciones.DESCUENTO+"=";
		sDescripcion+=ventaporlinea.getdescuento().toString()+",";
		sDescripcion+=VentaPorLineaConstantesFunciones.IVA+"=";
		sDescripcion+=ventaporlinea.getiva().toString()+",";
		sDescripcion+=VentaPorLineaConstantesFunciones.ICE+"=";
		sDescripcion+=ventaporlinea.getice().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setVentaPorLineaDescripcion(VentaPorLinea ventaporlinea,String sValor) throws Exception {			
		if(ventaporlinea !=null) {
			//ventaporlineaventaporlinea.getId().toString();
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

	public static String getProductoDescripcion(Producto producto) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(producto!=null/*&&producto.getId()>0*/) {
			sDescripcion=ProductoConstantesFunciones.getProductoDescripcion(producto);
		}

		return sDescripcion;
	}

	public static String getLineaDescripcion(Linea linea) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(linea!=null/*&&linea.getId()>0*/) {
			sDescripcion=LineaConstantesFunciones.getLineaDescripcion(linea);
		}

		return sDescripcion;
	}

	public static String getLineaGrupoDescripcion(Linea linea) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(linea!=null/*&&linea.getId()>0*/) {
			sDescripcion=LineaConstantesFunciones.getLineaDescripcion(linea);
		}

		return sDescripcion;
	}

	public static String getLineaCategoriaDescripcion(Linea linea) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(linea!=null/*&&linea.getId()>0*/) {
			sDescripcion=LineaConstantesFunciones.getLineaDescripcion(linea);
		}

		return sDescripcion;
	}

	public static String getLineaMarcaDescripcion(Linea linea) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(linea!=null/*&&linea.getId()>0*/) {
			sDescripcion=LineaConstantesFunciones.getLineaDescripcion(linea);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("BusquedaVentaPorLinea")) {
			sNombreIndice="Tipo=  Por Fecha Desde Por Fecha Hasta";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdLinea")) {
			sNombreIndice="Tipo=  Por Linea";
		} else if(sNombreIndice.equals("FK_IdLineaCategoria")) {
			sNombreIndice="Tipo=  Por Linea Categoria";
		} else if(sNombreIndice.equals("FK_IdLineaGrupo")) {
			sNombreIndice="Tipo=  Por Linea Grupo";
		} else if(sNombreIndice.equals("FK_IdLineaMarca")) {
			sNombreIndice="Tipo=  Por Linea Marca";
		} else if(sNombreIndice.equals("FK_IdProducto")) {
			sNombreIndice="Tipo=  Por Producto";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaVentaPorLinea(Date fecha_desde,Date fecha_hasta) {
		String sDetalleIndice=" Parametros->";
		if(fecha_desde!=null) {sDetalleIndice+=" Fecha Desde="+fecha_desde.toString();}
		if(fecha_hasta!=null) {sDetalleIndice+=" Fecha Hasta="+fecha_hasta.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdLinea(Long id_linea) {
		String sDetalleIndice=" Parametros->";
		if(id_linea!=null) {sDetalleIndice+=" Codigo Unico De Linea="+id_linea.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdLineaCategoria(Long id_linea_categoria) {
		String sDetalleIndice=" Parametros->";
		if(id_linea_categoria!=null) {sDetalleIndice+=" Codigo Unico De Linea Categoria="+id_linea_categoria.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdLineaGrupo(Long id_linea_grupo) {
		String sDetalleIndice=" Parametros->";
		if(id_linea_grupo!=null) {sDetalleIndice+=" Codigo Unico De Linea Grupo="+id_linea_grupo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdLineaMarca(Long id_linea_marca) {
		String sDetalleIndice=" Parametros->";
		if(id_linea_marca!=null) {sDetalleIndice+=" Codigo Unico De Linea Marca="+id_linea_marca.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdProducto(Long id_producto) {
		String sDetalleIndice=" Parametros->";
		if(id_producto!=null) {sDetalleIndice+=" Codigo Unico De Producto="+id_producto.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosVentaPorLinea(VentaPorLinea ventaporlinea,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ventaporlinea.setnombre_producto(ventaporlinea.getnombre_producto().trim());
		ventaporlinea.setnombre_linea(ventaporlinea.getnombre_linea().trim());
		ventaporlinea.setnombre_grupo(ventaporlinea.getnombre_grupo().trim());
		ventaporlinea.setnombre_categoria(ventaporlinea.getnombre_categoria().trim());
		ventaporlinea.setnombre_marca(ventaporlinea.getnombre_marca().trim());
		ventaporlinea.setsecuencial(ventaporlinea.getsecuencial().trim());
	}
	
	public static void quitarEspaciosVentaPorLineas(List<VentaPorLinea> ventaporlineas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(VentaPorLinea ventaporlinea: ventaporlineas) {
			ventaporlinea.setnombre_producto(ventaporlinea.getnombre_producto().trim());
			ventaporlinea.setnombre_linea(ventaporlinea.getnombre_linea().trim());
			ventaporlinea.setnombre_grupo(ventaporlinea.getnombre_grupo().trim());
			ventaporlinea.setnombre_categoria(ventaporlinea.getnombre_categoria().trim());
			ventaporlinea.setnombre_marca(ventaporlinea.getnombre_marca().trim());
			ventaporlinea.setsecuencial(ventaporlinea.getsecuencial().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresVentaPorLinea(VentaPorLinea ventaporlinea,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && ventaporlinea.getConCambioAuxiliar()) {
			ventaporlinea.setIsDeleted(ventaporlinea.getIsDeletedAuxiliar());	
			ventaporlinea.setIsNew(ventaporlinea.getIsNewAuxiliar());	
			ventaporlinea.setIsChanged(ventaporlinea.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			ventaporlinea.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			ventaporlinea.setIsDeletedAuxiliar(false);	
			ventaporlinea.setIsNewAuxiliar(false);	
			ventaporlinea.setIsChangedAuxiliar(false);
			
			ventaporlinea.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresVentaPorLineas(List<VentaPorLinea> ventaporlineas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(VentaPorLinea ventaporlinea : ventaporlineas) {
			if(conAsignarBase && ventaporlinea.getConCambioAuxiliar()) {
				ventaporlinea.setIsDeleted(ventaporlinea.getIsDeletedAuxiliar());	
				ventaporlinea.setIsNew(ventaporlinea.getIsNewAuxiliar());	
				ventaporlinea.setIsChanged(ventaporlinea.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				ventaporlinea.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				ventaporlinea.setIsDeletedAuxiliar(false);	
				ventaporlinea.setIsNewAuxiliar(false);	
				ventaporlinea.setIsChangedAuxiliar(false);
				
				ventaporlinea.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresVentaPorLinea(VentaPorLinea ventaporlinea,Boolean conEnteros) throws Exception  {
		ventaporlinea.setcantidad(0.0);
		ventaporlinea.setprecio(0.0);
		ventaporlinea.setdescuento(0.0);
		ventaporlinea.setiva(0.0);
		ventaporlinea.setice(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresVentaPorLineas(List<VentaPorLinea> ventaporlineas,Boolean conEnteros) throws Exception  {
		
		for(VentaPorLinea ventaporlinea: ventaporlineas) {
			ventaporlinea.setcantidad(0.0);
			ventaporlinea.setprecio(0.0);
			ventaporlinea.setdescuento(0.0);
			ventaporlinea.setiva(0.0);
			ventaporlinea.setice(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaVentaPorLinea(List<VentaPorLinea> ventaporlineas,VentaPorLinea ventaporlineaAux) throws Exception  {
		VentaPorLineaConstantesFunciones.InicializarValoresVentaPorLinea(ventaporlineaAux,true);
		
		for(VentaPorLinea ventaporlinea: ventaporlineas) {
			if(ventaporlinea.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			ventaporlineaAux.setcantidad(ventaporlineaAux.getcantidad()+ventaporlinea.getcantidad());			
			ventaporlineaAux.setprecio(ventaporlineaAux.getprecio()+ventaporlinea.getprecio());			
			ventaporlineaAux.setdescuento(ventaporlineaAux.getdescuento()+ventaporlinea.getdescuento());			
			ventaporlineaAux.setiva(ventaporlineaAux.getiva()+ventaporlinea.getiva());			
			ventaporlineaAux.setice(ventaporlineaAux.getice()+ventaporlinea.getice());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesVentaPorLinea(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=VentaPorLineaConstantesFunciones.getArrayColumnasGlobalesVentaPorLinea(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesVentaPorLinea(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(VentaPorLineaConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(VentaPorLineaConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(VentaPorLineaConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(VentaPorLineaConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoVentaPorLinea(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<VentaPorLinea> ventaporlineas,VentaPorLinea ventaporlinea,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(VentaPorLinea ventaporlineaAux: ventaporlineas) {
			if(ventaporlineaAux!=null && ventaporlinea!=null) {
				if((ventaporlineaAux.getId()==null && ventaporlinea.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(ventaporlineaAux.getId()!=null && ventaporlinea.getId()!=null){
					if(ventaporlineaAux.getId().equals(ventaporlinea.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaVentaPorLinea(List<VentaPorLinea> ventaporlineas) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double cantidadTotal=0.0;
		Double precioTotal=0.0;
		Double descuentoTotal=0.0;
		Double ivaTotal=0.0;
		Double iceTotal=0.0;
	
		for(VentaPorLinea ventaporlinea: ventaporlineas) {			
			if(ventaporlinea.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			cantidadTotal+=ventaporlinea.getcantidad();
			precioTotal+=ventaporlinea.getprecio();
			descuentoTotal+=ventaporlinea.getdescuento();
			ivaTotal+=ventaporlinea.getiva();
			iceTotal+=ventaporlinea.getice();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(VentaPorLineaConstantesFunciones.CANTIDAD);
		datoGeneral.setsDescripcion(VentaPorLineaConstantesFunciones.LABEL_CANTIDAD);
		datoGeneral.setdValorDouble(cantidadTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(VentaPorLineaConstantesFunciones.PRECIO);
		datoGeneral.setsDescripcion(VentaPorLineaConstantesFunciones.LABEL_PRECIO);
		datoGeneral.setdValorDouble(precioTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(VentaPorLineaConstantesFunciones.DESCUENTO);
		datoGeneral.setsDescripcion(VentaPorLineaConstantesFunciones.LABEL_DESCUENTO);
		datoGeneral.setdValorDouble(descuentoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(VentaPorLineaConstantesFunciones.IVA);
		datoGeneral.setsDescripcion(VentaPorLineaConstantesFunciones.LABEL_IVA);
		datoGeneral.setdValorDouble(ivaTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(VentaPorLineaConstantesFunciones.ICE);
		datoGeneral.setsDescripcion(VentaPorLineaConstantesFunciones.LABEL_ICE);
		datoGeneral.setdValorDouble(iceTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaVentaPorLinea() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,VentaPorLineaConstantesFunciones.LABEL_ID, VentaPorLineaConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VentaPorLineaConstantesFunciones.LABEL_VERSIONROW, VentaPorLineaConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VentaPorLineaConstantesFunciones.LABEL_IDPRODUCTO, VentaPorLineaConstantesFunciones.IDPRODUCTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VentaPorLineaConstantesFunciones.LABEL_IDLINEA, VentaPorLineaConstantesFunciones.IDLINEA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VentaPorLineaConstantesFunciones.LABEL_IDLINEAGRUPO, VentaPorLineaConstantesFunciones.IDLINEAGRUPO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VentaPorLineaConstantesFunciones.LABEL_IDLINEACATEGORIA, VentaPorLineaConstantesFunciones.IDLINEACATEGORIA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VentaPorLineaConstantesFunciones.LABEL_IDLINEAMARCA, VentaPorLineaConstantesFunciones.IDLINEAMARCA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VentaPorLineaConstantesFunciones.LABEL_NOMBREPRODUCTO, VentaPorLineaConstantesFunciones.NOMBREPRODUCTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VentaPorLineaConstantesFunciones.LABEL_NOMBRELINEA, VentaPorLineaConstantesFunciones.NOMBRELINEA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VentaPorLineaConstantesFunciones.LABEL_NOMBREGRUPO, VentaPorLineaConstantesFunciones.NOMBREGRUPO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VentaPorLineaConstantesFunciones.LABEL_NOMBRECATEGORIA, VentaPorLineaConstantesFunciones.NOMBRECATEGORIA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VentaPorLineaConstantesFunciones.LABEL_NOMBREMARCA, VentaPorLineaConstantesFunciones.NOMBREMARCA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VentaPorLineaConstantesFunciones.LABEL_FECHA, VentaPorLineaConstantesFunciones.FECHA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VentaPorLineaConstantesFunciones.LABEL_SECUENCIAL, VentaPorLineaConstantesFunciones.SECUENCIAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VentaPorLineaConstantesFunciones.LABEL_CANTIDAD, VentaPorLineaConstantesFunciones.CANTIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VentaPorLineaConstantesFunciones.LABEL_PRECIO, VentaPorLineaConstantesFunciones.PRECIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VentaPorLineaConstantesFunciones.LABEL_DESCUENTO, VentaPorLineaConstantesFunciones.DESCUENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VentaPorLineaConstantesFunciones.LABEL_IVA, VentaPorLineaConstantesFunciones.IVA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,VentaPorLineaConstantesFunciones.LABEL_ICE, VentaPorLineaConstantesFunciones.ICE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasVentaPorLinea() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=VentaPorLineaConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VentaPorLineaConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VentaPorLineaConstantesFunciones.IDPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VentaPorLineaConstantesFunciones.IDLINEA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VentaPorLineaConstantesFunciones.IDLINEAGRUPO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VentaPorLineaConstantesFunciones.IDLINEACATEGORIA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VentaPorLineaConstantesFunciones.IDLINEAMARCA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VentaPorLineaConstantesFunciones.NOMBREPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VentaPorLineaConstantesFunciones.NOMBRELINEA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VentaPorLineaConstantesFunciones.NOMBREGRUPO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VentaPorLineaConstantesFunciones.NOMBRECATEGORIA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VentaPorLineaConstantesFunciones.NOMBREMARCA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VentaPorLineaConstantesFunciones.FECHA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VentaPorLineaConstantesFunciones.SECUENCIAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VentaPorLineaConstantesFunciones.CANTIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VentaPorLineaConstantesFunciones.PRECIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VentaPorLineaConstantesFunciones.DESCUENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VentaPorLineaConstantesFunciones.IVA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=VentaPorLineaConstantesFunciones.ICE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarVentaPorLinea() throws Exception  {
		return VentaPorLineaConstantesFunciones.getTiposSeleccionarVentaPorLinea(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarVentaPorLinea(Boolean conFk) throws Exception  {
		return VentaPorLineaConstantesFunciones.getTiposSeleccionarVentaPorLinea(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarVentaPorLinea(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(VentaPorLineaConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(VentaPorLineaConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(VentaPorLineaConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(VentaPorLineaConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(VentaPorLineaConstantesFunciones.LABEL_IDPRODUCTO);
			reporte.setsDescripcion(VentaPorLineaConstantesFunciones.LABEL_IDPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(VentaPorLineaConstantesFunciones.LABEL_IDLINEA);
			reporte.setsDescripcion(VentaPorLineaConstantesFunciones.LABEL_IDLINEA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(VentaPorLineaConstantesFunciones.LABEL_IDLINEAGRUPO);
			reporte.setsDescripcion(VentaPorLineaConstantesFunciones.LABEL_IDLINEAGRUPO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(VentaPorLineaConstantesFunciones.LABEL_IDLINEACATEGORIA);
			reporte.setsDescripcion(VentaPorLineaConstantesFunciones.LABEL_IDLINEACATEGORIA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(VentaPorLineaConstantesFunciones.LABEL_IDLINEAMARCA);
			reporte.setsDescripcion(VentaPorLineaConstantesFunciones.LABEL_IDLINEAMARCA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VentaPorLineaConstantesFunciones.LABEL_FECHADESDE);
			reporte.setsDescripcion(VentaPorLineaConstantesFunciones.LABEL_FECHADESDE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VentaPorLineaConstantesFunciones.LABEL_FECHAHASTA);
			reporte.setsDescripcion(VentaPorLineaConstantesFunciones.LABEL_FECHAHASTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VentaPorLineaConstantesFunciones.LABEL_NOMBREPRODUCTO);
			reporte.setsDescripcion(VentaPorLineaConstantesFunciones.LABEL_NOMBREPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VentaPorLineaConstantesFunciones.LABEL_NOMBRELINEA);
			reporte.setsDescripcion(VentaPorLineaConstantesFunciones.LABEL_NOMBRELINEA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VentaPorLineaConstantesFunciones.LABEL_NOMBREGRUPO);
			reporte.setsDescripcion(VentaPorLineaConstantesFunciones.LABEL_NOMBREGRUPO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VentaPorLineaConstantesFunciones.LABEL_NOMBRECATEGORIA);
			reporte.setsDescripcion(VentaPorLineaConstantesFunciones.LABEL_NOMBRECATEGORIA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VentaPorLineaConstantesFunciones.LABEL_NOMBREMARCA);
			reporte.setsDescripcion(VentaPorLineaConstantesFunciones.LABEL_NOMBREMARCA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VentaPorLineaConstantesFunciones.LABEL_FECHA);
			reporte.setsDescripcion(VentaPorLineaConstantesFunciones.LABEL_FECHA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VentaPorLineaConstantesFunciones.LABEL_SECUENCIAL);
			reporte.setsDescripcion(VentaPorLineaConstantesFunciones.LABEL_SECUENCIAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VentaPorLineaConstantesFunciones.LABEL_CANTIDAD);
			reporte.setsDescripcion(VentaPorLineaConstantesFunciones.LABEL_CANTIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VentaPorLineaConstantesFunciones.LABEL_PRECIO);
			reporte.setsDescripcion(VentaPorLineaConstantesFunciones.LABEL_PRECIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VentaPorLineaConstantesFunciones.LABEL_DESCUENTO);
			reporte.setsDescripcion(VentaPorLineaConstantesFunciones.LABEL_DESCUENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VentaPorLineaConstantesFunciones.LABEL_IVA);
			reporte.setsDescripcion(VentaPorLineaConstantesFunciones.LABEL_IVA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(VentaPorLineaConstantesFunciones.LABEL_ICE);
			reporte.setsDescripcion(VentaPorLineaConstantesFunciones.LABEL_ICE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesVentaPorLinea(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesVentaPorLinea(VentaPorLinea ventaporlineaAux) throws Exception {
		
			ventaporlineaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(ventaporlineaAux.getEmpresa()));
			ventaporlineaAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(ventaporlineaAux.getSucursal()));
			ventaporlineaAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(ventaporlineaAux.getProducto()));
			ventaporlineaAux.setlinea_descripcion(LineaConstantesFunciones.getLineaDescripcion(ventaporlineaAux.getLinea()));
			ventaporlineaAux.setlineagrupo_descripcion(LineaConstantesFunciones.getLineaDescripcion(ventaporlineaAux.getLineaGrupo()));
			ventaporlineaAux.setlineacategoria_descripcion(LineaConstantesFunciones.getLineaDescripcion(ventaporlineaAux.getLineaCategoria()));
			ventaporlineaAux.setlineamarca_descripcion(LineaConstantesFunciones.getLineaDescripcion(ventaporlineaAux.getLineaMarca()));		
	}
	
	public static void refrescarForeignKeysDescripcionesVentaPorLinea(List<VentaPorLinea> ventaporlineasTemp) throws Exception {
		for(VentaPorLinea ventaporlineaAux:ventaporlineasTemp) {
			
			ventaporlineaAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(ventaporlineaAux.getEmpresa()));
			ventaporlineaAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(ventaporlineaAux.getSucursal()));
			ventaporlineaAux.setproducto_descripcion(ProductoConstantesFunciones.getProductoDescripcion(ventaporlineaAux.getProducto()));
			ventaporlineaAux.setlinea_descripcion(LineaConstantesFunciones.getLineaDescripcion(ventaporlineaAux.getLinea()));
			ventaporlineaAux.setlineagrupo_descripcion(LineaConstantesFunciones.getLineaDescripcion(ventaporlineaAux.getLineaGrupo()));
			ventaporlineaAux.setlineacategoria_descripcion(LineaConstantesFunciones.getLineaDescripcion(ventaporlineaAux.getLineaCategoria()));
			ventaporlineaAux.setlineamarca_descripcion(LineaConstantesFunciones.getLineaDescripcion(ventaporlineaAux.getLineaMarca()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfVentaPorLinea(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Producto.class));
				classes.add(new Classe(Linea.class));
				classes.add(new Classe(Linea.class));
				classes.add(new Classe(Linea.class));
				classes.add(new Classe(Linea.class));
				
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
					if(clas.clas.equals(Producto.class)) {
						classes.add(new Classe(Producto.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Linea.class)) {
						classes.add(new Classe(Linea.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Linea.class)) {
						classes.add(new Classe(Linea.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Linea.class)) {
						classes.add(new Classe(Linea.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Linea.class)) {
						classes.add(new Classe(Linea.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfVentaPorLinea(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(Producto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Producto.class)); continue;
					}

					if(Linea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Linea.class)); continue;
					}

					if(Linea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Linea.class)); continue;
					}

					if(Linea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Linea.class)); continue;
					}

					if(Linea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Linea.class)); continue;
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

					if(Producto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Producto.class)); continue;
					}

					if(Linea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Linea.class)); continue;
					}

					if(Linea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Linea.class)); continue;
					}

					if(Linea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Linea.class)); continue;
					}

					if(Linea.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Linea.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfVentaPorLinea(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return VentaPorLineaConstantesFunciones.getClassesRelationshipsOfVentaPorLinea(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfVentaPorLinea(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfVentaPorLinea(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return VentaPorLineaConstantesFunciones.getClassesRelationshipsFromStringsOfVentaPorLinea(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfVentaPorLinea(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(VentaPorLinea ventaporlinea,List<VentaPorLinea> ventaporlineas,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(VentaPorLinea ventaporlinea,List<VentaPorLinea> ventaporlineas) throws Exception {
		try	{			
			for(VentaPorLinea ventaporlineaLocal:ventaporlineas) {
				if(ventaporlineaLocal.getId().equals(ventaporlinea.getId())) {
					ventaporlineaLocal.setIsSelected(ventaporlinea.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesVentaPorLinea(List<VentaPorLinea> ventaporlineasAux) throws Exception {
		//this.ventaporlineasAux=ventaporlineasAux;
		
		for(VentaPorLinea ventaporlineaAux:ventaporlineasAux) {
			if(ventaporlineaAux.getIsChanged()) {
				ventaporlineaAux.setIsChanged(false);
			}		
			
			if(ventaporlineaAux.getIsNew()) {
				ventaporlineaAux.setIsNew(false);
			}	
			
			if(ventaporlineaAux.getIsDeleted()) {
				ventaporlineaAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesVentaPorLinea(VentaPorLinea ventaporlineaAux) throws Exception {
		//this.ventaporlineaAux=ventaporlineaAux;
		
			if(ventaporlineaAux.getIsChanged()) {
				ventaporlineaAux.setIsChanged(false);
			}		
			
			if(ventaporlineaAux.getIsNew()) {
				ventaporlineaAux.setIsNew(false);
			}	
			
			if(ventaporlineaAux.getIsDeleted()) {
				ventaporlineaAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(VentaPorLinea ventaporlineaAsignar,VentaPorLinea ventaporlinea) throws Exception {
		ventaporlineaAsignar.setId(ventaporlinea.getId());	
		ventaporlineaAsignar.setVersionRow(ventaporlinea.getVersionRow());	
		ventaporlineaAsignar.setid_producto(ventaporlinea.getid_producto());
		ventaporlineaAsignar.setproducto_descripcion(ventaporlinea.getproducto_descripcion());	
		ventaporlineaAsignar.setid_linea(ventaporlinea.getid_linea());
		ventaporlineaAsignar.setlinea_descripcion(ventaporlinea.getlinea_descripcion());	
		ventaporlineaAsignar.setid_linea_grupo(ventaporlinea.getid_linea_grupo());
		ventaporlineaAsignar.setlineagrupo_descripcion(ventaporlinea.getlineagrupo_descripcion());	
		ventaporlineaAsignar.setid_linea_categoria(ventaporlinea.getid_linea_categoria());
		ventaporlineaAsignar.setlineacategoria_descripcion(ventaporlinea.getlineacategoria_descripcion());	
		ventaporlineaAsignar.setid_linea_marca(ventaporlinea.getid_linea_marca());
		ventaporlineaAsignar.setlineamarca_descripcion(ventaporlinea.getlineamarca_descripcion());	
		ventaporlineaAsignar.setnombre_producto(ventaporlinea.getnombre_producto());	
		ventaporlineaAsignar.setnombre_linea(ventaporlinea.getnombre_linea());	
		ventaporlineaAsignar.setnombre_grupo(ventaporlinea.getnombre_grupo());	
		ventaporlineaAsignar.setnombre_categoria(ventaporlinea.getnombre_categoria());	
		ventaporlineaAsignar.setnombre_marca(ventaporlinea.getnombre_marca());	
		ventaporlineaAsignar.setfecha(ventaporlinea.getfecha());	
		ventaporlineaAsignar.setsecuencial(ventaporlinea.getsecuencial());	
		ventaporlineaAsignar.setcantidad(ventaporlinea.getcantidad());	
		ventaporlineaAsignar.setprecio(ventaporlinea.getprecio());	
		ventaporlineaAsignar.setdescuento(ventaporlinea.getdescuento());	
		ventaporlineaAsignar.setiva(ventaporlinea.getiva());	
		ventaporlineaAsignar.setice(ventaporlinea.getice());	
	}
	
	public static void inicializarVentaPorLinea(VentaPorLinea ventaporlinea) throws Exception {
		try {
				ventaporlinea.setId(0L);	
					
				ventaporlinea.setid_producto(-1L);	
				ventaporlinea.setid_linea(-1L);	
				ventaporlinea.setid_linea_grupo(-1L);	
				ventaporlinea.setid_linea_categoria(-1L);	
				ventaporlinea.setid_linea_marca(-1L);	
				ventaporlinea.setnombre_producto("");	
				ventaporlinea.setnombre_linea("");	
				ventaporlinea.setnombre_grupo("");	
				ventaporlinea.setnombre_categoria("");	
				ventaporlinea.setnombre_marca("");	
				ventaporlinea.setfecha(new Date());	
				ventaporlinea.setsecuencial("");	
				ventaporlinea.setcantidad(0.0);	
				ventaporlinea.setprecio(0.0);	
				ventaporlinea.setdescuento(0.0);	
				ventaporlinea.setiva(0.0);	
				ventaporlinea.setice(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderVentaPorLinea(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(VentaPorLineaConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VentaPorLineaConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VentaPorLineaConstantesFunciones.LABEL_IDPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VentaPorLineaConstantesFunciones.LABEL_IDLINEA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VentaPorLineaConstantesFunciones.LABEL_IDLINEAGRUPO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VentaPorLineaConstantesFunciones.LABEL_IDLINEACATEGORIA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VentaPorLineaConstantesFunciones.LABEL_IDLINEAMARCA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VentaPorLineaConstantesFunciones.LABEL_FECHADESDE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VentaPorLineaConstantesFunciones.LABEL_FECHAHASTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VentaPorLineaConstantesFunciones.LABEL_NOMBREPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VentaPorLineaConstantesFunciones.LABEL_NOMBRELINEA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VentaPorLineaConstantesFunciones.LABEL_NOMBREGRUPO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VentaPorLineaConstantesFunciones.LABEL_NOMBRECATEGORIA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VentaPorLineaConstantesFunciones.LABEL_NOMBREMARCA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VentaPorLineaConstantesFunciones.LABEL_FECHA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VentaPorLineaConstantesFunciones.LABEL_SECUENCIAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VentaPorLineaConstantesFunciones.LABEL_CANTIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VentaPorLineaConstantesFunciones.LABEL_PRECIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VentaPorLineaConstantesFunciones.LABEL_DESCUENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VentaPorLineaConstantesFunciones.LABEL_IVA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(VentaPorLineaConstantesFunciones.LABEL_ICE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataVentaPorLinea(String sTipo,Row row,Workbook workbook,VentaPorLinea ventaporlinea,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(ventaporlinea.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ventaporlinea.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ventaporlinea.getproducto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ventaporlinea.getlinea_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ventaporlinea.getlineagrupo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ventaporlinea.getlineacategoria_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ventaporlinea.getlineamarca_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ventaporlinea.getfecha_desde());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ventaporlinea.getfecha_hasta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ventaporlinea.getnombre_producto());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ventaporlinea.getnombre_linea());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ventaporlinea.getnombre_grupo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ventaporlinea.getnombre_categoria());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ventaporlinea.getnombre_marca());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ventaporlinea.getfecha());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ventaporlinea.getsecuencial());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ventaporlinea.getcantidad());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ventaporlinea.getprecio());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ventaporlinea.getdescuento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ventaporlinea.getiva());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(ventaporlinea.getice());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryVentaPorLinea="";
	
	public String getsFinalQueryVentaPorLinea() {
		return this.sFinalQueryVentaPorLinea;
	}
	
	public void setsFinalQueryVentaPorLinea(String sFinalQueryVentaPorLinea) {
		this.sFinalQueryVentaPorLinea= sFinalQueryVentaPorLinea;
	}
	
	public Border resaltarSeleccionarVentaPorLinea=null;
	
	public Border setResaltarSeleccionarVentaPorLinea(ParametroGeneralUsuario parametroGeneralUsuario/*VentaPorLineaBeanSwingJInternalFrame ventaporlineaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//ventaporlineaBeanSwingJInternalFrame.jTtoolBarVentaPorLinea.setBorder(borderResaltar);
		
		this.resaltarSeleccionarVentaPorLinea= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarVentaPorLinea() {
		return this.resaltarSeleccionarVentaPorLinea;
	}
	
	public void setResaltarSeleccionarVentaPorLinea(Border borderResaltarSeleccionarVentaPorLinea) {
		this.resaltarSeleccionarVentaPorLinea= borderResaltarSeleccionarVentaPorLinea;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridVentaPorLinea=null;
	public Boolean mostraridVentaPorLinea=true;
	public Boolean activaridVentaPorLinea=true;

	public Border resaltarid_empresaVentaPorLinea=null;
	public Boolean mostrarid_empresaVentaPorLinea=true;
	public Boolean activarid_empresaVentaPorLinea=true;
	public Boolean cargarid_empresaVentaPorLinea=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaVentaPorLinea=false;//ConEventDepend=true

	public Border resaltarid_sucursalVentaPorLinea=null;
	public Boolean mostrarid_sucursalVentaPorLinea=true;
	public Boolean activarid_sucursalVentaPorLinea=true;
	public Boolean cargarid_sucursalVentaPorLinea=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalVentaPorLinea=false;//ConEventDepend=true

	public Border resaltarid_productoVentaPorLinea=null;
	public Boolean mostrarid_productoVentaPorLinea=true;
	public Boolean activarid_productoVentaPorLinea=true;
	public Boolean cargarid_productoVentaPorLinea=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_productoVentaPorLinea=false;//ConEventDepend=true

	public Border resaltarid_lineaVentaPorLinea=null;
	public Boolean mostrarid_lineaVentaPorLinea=true;
	public Boolean activarid_lineaVentaPorLinea=false;
	public Boolean cargarid_lineaVentaPorLinea=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_lineaVentaPorLinea=false;//ConEventDepend=true

	public Border resaltarid_linea_grupoVentaPorLinea=null;
	public Boolean mostrarid_linea_grupoVentaPorLinea=true;
	public Boolean activarid_linea_grupoVentaPorLinea=false;
	public Boolean cargarid_linea_grupoVentaPorLinea=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_linea_grupoVentaPorLinea=false;//ConEventDepend=true

	public Border resaltarid_linea_categoriaVentaPorLinea=null;
	public Boolean mostrarid_linea_categoriaVentaPorLinea=true;
	public Boolean activarid_linea_categoriaVentaPorLinea=false;
	public Boolean cargarid_linea_categoriaVentaPorLinea=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_linea_categoriaVentaPorLinea=false;//ConEventDepend=true

	public Border resaltarid_linea_marcaVentaPorLinea=null;
	public Boolean mostrarid_linea_marcaVentaPorLinea=true;
	public Boolean activarid_linea_marcaVentaPorLinea=false;
	public Boolean cargarid_linea_marcaVentaPorLinea=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_linea_marcaVentaPorLinea=false;//ConEventDepend=true

	public Border resaltarfecha_desdeVentaPorLinea=null;
	public Boolean mostrarfecha_desdeVentaPorLinea=true;
	public Boolean activarfecha_desdeVentaPorLinea=true;

	public Border resaltarfecha_hastaVentaPorLinea=null;
	public Boolean mostrarfecha_hastaVentaPorLinea=true;
	public Boolean activarfecha_hastaVentaPorLinea=true;

	public Border resaltarnombre_productoVentaPorLinea=null;
	public Boolean mostrarnombre_productoVentaPorLinea=true;
	public Boolean activarnombre_productoVentaPorLinea=true;

	public Border resaltarnombre_lineaVentaPorLinea=null;
	public Boolean mostrarnombre_lineaVentaPorLinea=true;
	public Boolean activarnombre_lineaVentaPorLinea=true;

	public Border resaltarnombre_grupoVentaPorLinea=null;
	public Boolean mostrarnombre_grupoVentaPorLinea=true;
	public Boolean activarnombre_grupoVentaPorLinea=true;

	public Border resaltarnombre_categoriaVentaPorLinea=null;
	public Boolean mostrarnombre_categoriaVentaPorLinea=true;
	public Boolean activarnombre_categoriaVentaPorLinea=true;

	public Border resaltarnombre_marcaVentaPorLinea=null;
	public Boolean mostrarnombre_marcaVentaPorLinea=true;
	public Boolean activarnombre_marcaVentaPorLinea=true;

	public Border resaltarfechaVentaPorLinea=null;
	public Boolean mostrarfechaVentaPorLinea=true;
	public Boolean activarfechaVentaPorLinea=true;

	public Border resaltarsecuencialVentaPorLinea=null;
	public Boolean mostrarsecuencialVentaPorLinea=true;
	public Boolean activarsecuencialVentaPorLinea=true;

	public Border resaltarcantidadVentaPorLinea=null;
	public Boolean mostrarcantidadVentaPorLinea=true;
	public Boolean activarcantidadVentaPorLinea=true;

	public Border resaltarprecioVentaPorLinea=null;
	public Boolean mostrarprecioVentaPorLinea=true;
	public Boolean activarprecioVentaPorLinea=true;

	public Border resaltardescuentoVentaPorLinea=null;
	public Boolean mostrardescuentoVentaPorLinea=true;
	public Boolean activardescuentoVentaPorLinea=true;

	public Border resaltarivaVentaPorLinea=null;
	public Boolean mostrarivaVentaPorLinea=true;
	public Boolean activarivaVentaPorLinea=true;

	public Border resaltariceVentaPorLinea=null;
	public Boolean mostrariceVentaPorLinea=true;
	public Boolean activariceVentaPorLinea=true;

	
	

	public Border setResaltaridVentaPorLinea(ParametroGeneralUsuario parametroGeneralUsuario/*VentaPorLineaBeanSwingJInternalFrame ventaporlineaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventaporlineaBeanSwingJInternalFrame.jTtoolBarVentaPorLinea.setBorder(borderResaltar);
		
		this.resaltaridVentaPorLinea= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridVentaPorLinea() {
		return this.resaltaridVentaPorLinea;
	}

	public void setResaltaridVentaPorLinea(Border borderResaltar) {
		this.resaltaridVentaPorLinea= borderResaltar;
	}

	public Boolean getMostraridVentaPorLinea() {
		return this.mostraridVentaPorLinea;
	}

	public void setMostraridVentaPorLinea(Boolean mostraridVentaPorLinea) {
		this.mostraridVentaPorLinea= mostraridVentaPorLinea;
	}

	public Boolean getActivaridVentaPorLinea() {
		return this.activaridVentaPorLinea;
	}

	public void setActivaridVentaPorLinea(Boolean activaridVentaPorLinea) {
		this.activaridVentaPorLinea= activaridVentaPorLinea;
	}

	public Border setResaltarid_empresaVentaPorLinea(ParametroGeneralUsuario parametroGeneralUsuario/*VentaPorLineaBeanSwingJInternalFrame ventaporlineaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventaporlineaBeanSwingJInternalFrame.jTtoolBarVentaPorLinea.setBorder(borderResaltar);
		
		this.resaltarid_empresaVentaPorLinea= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaVentaPorLinea() {
		return this.resaltarid_empresaVentaPorLinea;
	}

	public void setResaltarid_empresaVentaPorLinea(Border borderResaltar) {
		this.resaltarid_empresaVentaPorLinea= borderResaltar;
	}

	public Boolean getMostrarid_empresaVentaPorLinea() {
		return this.mostrarid_empresaVentaPorLinea;
	}

	public void setMostrarid_empresaVentaPorLinea(Boolean mostrarid_empresaVentaPorLinea) {
		this.mostrarid_empresaVentaPorLinea= mostrarid_empresaVentaPorLinea;
	}

	public Boolean getActivarid_empresaVentaPorLinea() {
		return this.activarid_empresaVentaPorLinea;
	}

	public void setActivarid_empresaVentaPorLinea(Boolean activarid_empresaVentaPorLinea) {
		this.activarid_empresaVentaPorLinea= activarid_empresaVentaPorLinea;
	}

	public Boolean getCargarid_empresaVentaPorLinea() {
		return this.cargarid_empresaVentaPorLinea;
	}

	public void setCargarid_empresaVentaPorLinea(Boolean cargarid_empresaVentaPorLinea) {
		this.cargarid_empresaVentaPorLinea= cargarid_empresaVentaPorLinea;
	}

	public Border setResaltarid_sucursalVentaPorLinea(ParametroGeneralUsuario parametroGeneralUsuario/*VentaPorLineaBeanSwingJInternalFrame ventaporlineaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventaporlineaBeanSwingJInternalFrame.jTtoolBarVentaPorLinea.setBorder(borderResaltar);
		
		this.resaltarid_sucursalVentaPorLinea= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalVentaPorLinea() {
		return this.resaltarid_sucursalVentaPorLinea;
	}

	public void setResaltarid_sucursalVentaPorLinea(Border borderResaltar) {
		this.resaltarid_sucursalVentaPorLinea= borderResaltar;
	}

	public Boolean getMostrarid_sucursalVentaPorLinea() {
		return this.mostrarid_sucursalVentaPorLinea;
	}

	public void setMostrarid_sucursalVentaPorLinea(Boolean mostrarid_sucursalVentaPorLinea) {
		this.mostrarid_sucursalVentaPorLinea= mostrarid_sucursalVentaPorLinea;
	}

	public Boolean getActivarid_sucursalVentaPorLinea() {
		return this.activarid_sucursalVentaPorLinea;
	}

	public void setActivarid_sucursalVentaPorLinea(Boolean activarid_sucursalVentaPorLinea) {
		this.activarid_sucursalVentaPorLinea= activarid_sucursalVentaPorLinea;
	}

	public Boolean getCargarid_sucursalVentaPorLinea() {
		return this.cargarid_sucursalVentaPorLinea;
	}

	public void setCargarid_sucursalVentaPorLinea(Boolean cargarid_sucursalVentaPorLinea) {
		this.cargarid_sucursalVentaPorLinea= cargarid_sucursalVentaPorLinea;
	}

	public Border setResaltarid_productoVentaPorLinea(ParametroGeneralUsuario parametroGeneralUsuario/*VentaPorLineaBeanSwingJInternalFrame ventaporlineaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventaporlineaBeanSwingJInternalFrame.jTtoolBarVentaPorLinea.setBorder(borderResaltar);
		
		this.resaltarid_productoVentaPorLinea= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_productoVentaPorLinea() {
		return this.resaltarid_productoVentaPorLinea;
	}

	public void setResaltarid_productoVentaPorLinea(Border borderResaltar) {
		this.resaltarid_productoVentaPorLinea= borderResaltar;
	}

	public Boolean getMostrarid_productoVentaPorLinea() {
		return this.mostrarid_productoVentaPorLinea;
	}

	public void setMostrarid_productoVentaPorLinea(Boolean mostrarid_productoVentaPorLinea) {
		this.mostrarid_productoVentaPorLinea= mostrarid_productoVentaPorLinea;
	}

	public Boolean getActivarid_productoVentaPorLinea() {
		return this.activarid_productoVentaPorLinea;
	}

	public void setActivarid_productoVentaPorLinea(Boolean activarid_productoVentaPorLinea) {
		this.activarid_productoVentaPorLinea= activarid_productoVentaPorLinea;
	}

	public Boolean getCargarid_productoVentaPorLinea() {
		return this.cargarid_productoVentaPorLinea;
	}

	public void setCargarid_productoVentaPorLinea(Boolean cargarid_productoVentaPorLinea) {
		this.cargarid_productoVentaPorLinea= cargarid_productoVentaPorLinea;
	}

	public Border setResaltarid_lineaVentaPorLinea(ParametroGeneralUsuario parametroGeneralUsuario/*VentaPorLineaBeanSwingJInternalFrame ventaporlineaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventaporlineaBeanSwingJInternalFrame.jTtoolBarVentaPorLinea.setBorder(borderResaltar);
		
		this.resaltarid_lineaVentaPorLinea= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_lineaVentaPorLinea() {
		return this.resaltarid_lineaVentaPorLinea;
	}

	public void setResaltarid_lineaVentaPorLinea(Border borderResaltar) {
		this.resaltarid_lineaVentaPorLinea= borderResaltar;
	}

	public Boolean getMostrarid_lineaVentaPorLinea() {
		return this.mostrarid_lineaVentaPorLinea;
	}

	public void setMostrarid_lineaVentaPorLinea(Boolean mostrarid_lineaVentaPorLinea) {
		this.mostrarid_lineaVentaPorLinea= mostrarid_lineaVentaPorLinea;
	}

	public Boolean getActivarid_lineaVentaPorLinea() {
		return this.activarid_lineaVentaPorLinea;
	}

	public void setActivarid_lineaVentaPorLinea(Boolean activarid_lineaVentaPorLinea) {
		this.activarid_lineaVentaPorLinea= activarid_lineaVentaPorLinea;
	}

	public Boolean getCargarid_lineaVentaPorLinea() {
		return this.cargarid_lineaVentaPorLinea;
	}

	public void setCargarid_lineaVentaPorLinea(Boolean cargarid_lineaVentaPorLinea) {
		this.cargarid_lineaVentaPorLinea= cargarid_lineaVentaPorLinea;
	}

	public Border setResaltarid_linea_grupoVentaPorLinea(ParametroGeneralUsuario parametroGeneralUsuario/*VentaPorLineaBeanSwingJInternalFrame ventaporlineaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventaporlineaBeanSwingJInternalFrame.jTtoolBarVentaPorLinea.setBorder(borderResaltar);
		
		this.resaltarid_linea_grupoVentaPorLinea= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_linea_grupoVentaPorLinea() {
		return this.resaltarid_linea_grupoVentaPorLinea;
	}

	public void setResaltarid_linea_grupoVentaPorLinea(Border borderResaltar) {
		this.resaltarid_linea_grupoVentaPorLinea= borderResaltar;
	}

	public Boolean getMostrarid_linea_grupoVentaPorLinea() {
		return this.mostrarid_linea_grupoVentaPorLinea;
	}

	public void setMostrarid_linea_grupoVentaPorLinea(Boolean mostrarid_linea_grupoVentaPorLinea) {
		this.mostrarid_linea_grupoVentaPorLinea= mostrarid_linea_grupoVentaPorLinea;
	}

	public Boolean getActivarid_linea_grupoVentaPorLinea() {
		return this.activarid_linea_grupoVentaPorLinea;
	}

	public void setActivarid_linea_grupoVentaPorLinea(Boolean activarid_linea_grupoVentaPorLinea) {
		this.activarid_linea_grupoVentaPorLinea= activarid_linea_grupoVentaPorLinea;
	}

	public Boolean getCargarid_linea_grupoVentaPorLinea() {
		return this.cargarid_linea_grupoVentaPorLinea;
	}

	public void setCargarid_linea_grupoVentaPorLinea(Boolean cargarid_linea_grupoVentaPorLinea) {
		this.cargarid_linea_grupoVentaPorLinea= cargarid_linea_grupoVentaPorLinea;
	}

	public Border setResaltarid_linea_categoriaVentaPorLinea(ParametroGeneralUsuario parametroGeneralUsuario/*VentaPorLineaBeanSwingJInternalFrame ventaporlineaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventaporlineaBeanSwingJInternalFrame.jTtoolBarVentaPorLinea.setBorder(borderResaltar);
		
		this.resaltarid_linea_categoriaVentaPorLinea= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_linea_categoriaVentaPorLinea() {
		return this.resaltarid_linea_categoriaVentaPorLinea;
	}

	public void setResaltarid_linea_categoriaVentaPorLinea(Border borderResaltar) {
		this.resaltarid_linea_categoriaVentaPorLinea= borderResaltar;
	}

	public Boolean getMostrarid_linea_categoriaVentaPorLinea() {
		return this.mostrarid_linea_categoriaVentaPorLinea;
	}

	public void setMostrarid_linea_categoriaVentaPorLinea(Boolean mostrarid_linea_categoriaVentaPorLinea) {
		this.mostrarid_linea_categoriaVentaPorLinea= mostrarid_linea_categoriaVentaPorLinea;
	}

	public Boolean getActivarid_linea_categoriaVentaPorLinea() {
		return this.activarid_linea_categoriaVentaPorLinea;
	}

	public void setActivarid_linea_categoriaVentaPorLinea(Boolean activarid_linea_categoriaVentaPorLinea) {
		this.activarid_linea_categoriaVentaPorLinea= activarid_linea_categoriaVentaPorLinea;
	}

	public Boolean getCargarid_linea_categoriaVentaPorLinea() {
		return this.cargarid_linea_categoriaVentaPorLinea;
	}

	public void setCargarid_linea_categoriaVentaPorLinea(Boolean cargarid_linea_categoriaVentaPorLinea) {
		this.cargarid_linea_categoriaVentaPorLinea= cargarid_linea_categoriaVentaPorLinea;
	}

	public Border setResaltarid_linea_marcaVentaPorLinea(ParametroGeneralUsuario parametroGeneralUsuario/*VentaPorLineaBeanSwingJInternalFrame ventaporlineaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventaporlineaBeanSwingJInternalFrame.jTtoolBarVentaPorLinea.setBorder(borderResaltar);
		
		this.resaltarid_linea_marcaVentaPorLinea= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_linea_marcaVentaPorLinea() {
		return this.resaltarid_linea_marcaVentaPorLinea;
	}

	public void setResaltarid_linea_marcaVentaPorLinea(Border borderResaltar) {
		this.resaltarid_linea_marcaVentaPorLinea= borderResaltar;
	}

	public Boolean getMostrarid_linea_marcaVentaPorLinea() {
		return this.mostrarid_linea_marcaVentaPorLinea;
	}

	public void setMostrarid_linea_marcaVentaPorLinea(Boolean mostrarid_linea_marcaVentaPorLinea) {
		this.mostrarid_linea_marcaVentaPorLinea= mostrarid_linea_marcaVentaPorLinea;
	}

	public Boolean getActivarid_linea_marcaVentaPorLinea() {
		return this.activarid_linea_marcaVentaPorLinea;
	}

	public void setActivarid_linea_marcaVentaPorLinea(Boolean activarid_linea_marcaVentaPorLinea) {
		this.activarid_linea_marcaVentaPorLinea= activarid_linea_marcaVentaPorLinea;
	}

	public Boolean getCargarid_linea_marcaVentaPorLinea() {
		return this.cargarid_linea_marcaVentaPorLinea;
	}

	public void setCargarid_linea_marcaVentaPorLinea(Boolean cargarid_linea_marcaVentaPorLinea) {
		this.cargarid_linea_marcaVentaPorLinea= cargarid_linea_marcaVentaPorLinea;
	}

	public Border setResaltarfecha_desdeVentaPorLinea(ParametroGeneralUsuario parametroGeneralUsuario/*VentaPorLineaBeanSwingJInternalFrame ventaporlineaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventaporlineaBeanSwingJInternalFrame.jTtoolBarVentaPorLinea.setBorder(borderResaltar);
		
		this.resaltarfecha_desdeVentaPorLinea= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_desdeVentaPorLinea() {
		return this.resaltarfecha_desdeVentaPorLinea;
	}

	public void setResaltarfecha_desdeVentaPorLinea(Border borderResaltar) {
		this.resaltarfecha_desdeVentaPorLinea= borderResaltar;
	}

	public Boolean getMostrarfecha_desdeVentaPorLinea() {
		return this.mostrarfecha_desdeVentaPorLinea;
	}

	public void setMostrarfecha_desdeVentaPorLinea(Boolean mostrarfecha_desdeVentaPorLinea) {
		this.mostrarfecha_desdeVentaPorLinea= mostrarfecha_desdeVentaPorLinea;
	}

	public Boolean getActivarfecha_desdeVentaPorLinea() {
		return this.activarfecha_desdeVentaPorLinea;
	}

	public void setActivarfecha_desdeVentaPorLinea(Boolean activarfecha_desdeVentaPorLinea) {
		this.activarfecha_desdeVentaPorLinea= activarfecha_desdeVentaPorLinea;
	}

	public Border setResaltarfecha_hastaVentaPorLinea(ParametroGeneralUsuario parametroGeneralUsuario/*VentaPorLineaBeanSwingJInternalFrame ventaporlineaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventaporlineaBeanSwingJInternalFrame.jTtoolBarVentaPorLinea.setBorder(borderResaltar);
		
		this.resaltarfecha_hastaVentaPorLinea= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_hastaVentaPorLinea() {
		return this.resaltarfecha_hastaVentaPorLinea;
	}

	public void setResaltarfecha_hastaVentaPorLinea(Border borderResaltar) {
		this.resaltarfecha_hastaVentaPorLinea= borderResaltar;
	}

	public Boolean getMostrarfecha_hastaVentaPorLinea() {
		return this.mostrarfecha_hastaVentaPorLinea;
	}

	public void setMostrarfecha_hastaVentaPorLinea(Boolean mostrarfecha_hastaVentaPorLinea) {
		this.mostrarfecha_hastaVentaPorLinea= mostrarfecha_hastaVentaPorLinea;
	}

	public Boolean getActivarfecha_hastaVentaPorLinea() {
		return this.activarfecha_hastaVentaPorLinea;
	}

	public void setActivarfecha_hastaVentaPorLinea(Boolean activarfecha_hastaVentaPorLinea) {
		this.activarfecha_hastaVentaPorLinea= activarfecha_hastaVentaPorLinea;
	}

	public Border setResaltarnombre_productoVentaPorLinea(ParametroGeneralUsuario parametroGeneralUsuario/*VentaPorLineaBeanSwingJInternalFrame ventaporlineaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventaporlineaBeanSwingJInternalFrame.jTtoolBarVentaPorLinea.setBorder(borderResaltar);
		
		this.resaltarnombre_productoVentaPorLinea= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_productoVentaPorLinea() {
		return this.resaltarnombre_productoVentaPorLinea;
	}

	public void setResaltarnombre_productoVentaPorLinea(Border borderResaltar) {
		this.resaltarnombre_productoVentaPorLinea= borderResaltar;
	}

	public Boolean getMostrarnombre_productoVentaPorLinea() {
		return this.mostrarnombre_productoVentaPorLinea;
	}

	public void setMostrarnombre_productoVentaPorLinea(Boolean mostrarnombre_productoVentaPorLinea) {
		this.mostrarnombre_productoVentaPorLinea= mostrarnombre_productoVentaPorLinea;
	}

	public Boolean getActivarnombre_productoVentaPorLinea() {
		return this.activarnombre_productoVentaPorLinea;
	}

	public void setActivarnombre_productoVentaPorLinea(Boolean activarnombre_productoVentaPorLinea) {
		this.activarnombre_productoVentaPorLinea= activarnombre_productoVentaPorLinea;
	}

	public Border setResaltarnombre_lineaVentaPorLinea(ParametroGeneralUsuario parametroGeneralUsuario/*VentaPorLineaBeanSwingJInternalFrame ventaporlineaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventaporlineaBeanSwingJInternalFrame.jTtoolBarVentaPorLinea.setBorder(borderResaltar);
		
		this.resaltarnombre_lineaVentaPorLinea= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_lineaVentaPorLinea() {
		return this.resaltarnombre_lineaVentaPorLinea;
	}

	public void setResaltarnombre_lineaVentaPorLinea(Border borderResaltar) {
		this.resaltarnombre_lineaVentaPorLinea= borderResaltar;
	}

	public Boolean getMostrarnombre_lineaVentaPorLinea() {
		return this.mostrarnombre_lineaVentaPorLinea;
	}

	public void setMostrarnombre_lineaVentaPorLinea(Boolean mostrarnombre_lineaVentaPorLinea) {
		this.mostrarnombre_lineaVentaPorLinea= mostrarnombre_lineaVentaPorLinea;
	}

	public Boolean getActivarnombre_lineaVentaPorLinea() {
		return this.activarnombre_lineaVentaPorLinea;
	}

	public void setActivarnombre_lineaVentaPorLinea(Boolean activarnombre_lineaVentaPorLinea) {
		this.activarnombre_lineaVentaPorLinea= activarnombre_lineaVentaPorLinea;
	}

	public Border setResaltarnombre_grupoVentaPorLinea(ParametroGeneralUsuario parametroGeneralUsuario/*VentaPorLineaBeanSwingJInternalFrame ventaporlineaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventaporlineaBeanSwingJInternalFrame.jTtoolBarVentaPorLinea.setBorder(borderResaltar);
		
		this.resaltarnombre_grupoVentaPorLinea= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_grupoVentaPorLinea() {
		return this.resaltarnombre_grupoVentaPorLinea;
	}

	public void setResaltarnombre_grupoVentaPorLinea(Border borderResaltar) {
		this.resaltarnombre_grupoVentaPorLinea= borderResaltar;
	}

	public Boolean getMostrarnombre_grupoVentaPorLinea() {
		return this.mostrarnombre_grupoVentaPorLinea;
	}

	public void setMostrarnombre_grupoVentaPorLinea(Boolean mostrarnombre_grupoVentaPorLinea) {
		this.mostrarnombre_grupoVentaPorLinea= mostrarnombre_grupoVentaPorLinea;
	}

	public Boolean getActivarnombre_grupoVentaPorLinea() {
		return this.activarnombre_grupoVentaPorLinea;
	}

	public void setActivarnombre_grupoVentaPorLinea(Boolean activarnombre_grupoVentaPorLinea) {
		this.activarnombre_grupoVentaPorLinea= activarnombre_grupoVentaPorLinea;
	}

	public Border setResaltarnombre_categoriaVentaPorLinea(ParametroGeneralUsuario parametroGeneralUsuario/*VentaPorLineaBeanSwingJInternalFrame ventaporlineaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventaporlineaBeanSwingJInternalFrame.jTtoolBarVentaPorLinea.setBorder(borderResaltar);
		
		this.resaltarnombre_categoriaVentaPorLinea= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_categoriaVentaPorLinea() {
		return this.resaltarnombre_categoriaVentaPorLinea;
	}

	public void setResaltarnombre_categoriaVentaPorLinea(Border borderResaltar) {
		this.resaltarnombre_categoriaVentaPorLinea= borderResaltar;
	}

	public Boolean getMostrarnombre_categoriaVentaPorLinea() {
		return this.mostrarnombre_categoriaVentaPorLinea;
	}

	public void setMostrarnombre_categoriaVentaPorLinea(Boolean mostrarnombre_categoriaVentaPorLinea) {
		this.mostrarnombre_categoriaVentaPorLinea= mostrarnombre_categoriaVentaPorLinea;
	}

	public Boolean getActivarnombre_categoriaVentaPorLinea() {
		return this.activarnombre_categoriaVentaPorLinea;
	}

	public void setActivarnombre_categoriaVentaPorLinea(Boolean activarnombre_categoriaVentaPorLinea) {
		this.activarnombre_categoriaVentaPorLinea= activarnombre_categoriaVentaPorLinea;
	}

	public Border setResaltarnombre_marcaVentaPorLinea(ParametroGeneralUsuario parametroGeneralUsuario/*VentaPorLineaBeanSwingJInternalFrame ventaporlineaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventaporlineaBeanSwingJInternalFrame.jTtoolBarVentaPorLinea.setBorder(borderResaltar);
		
		this.resaltarnombre_marcaVentaPorLinea= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_marcaVentaPorLinea() {
		return this.resaltarnombre_marcaVentaPorLinea;
	}

	public void setResaltarnombre_marcaVentaPorLinea(Border borderResaltar) {
		this.resaltarnombre_marcaVentaPorLinea= borderResaltar;
	}

	public Boolean getMostrarnombre_marcaVentaPorLinea() {
		return this.mostrarnombre_marcaVentaPorLinea;
	}

	public void setMostrarnombre_marcaVentaPorLinea(Boolean mostrarnombre_marcaVentaPorLinea) {
		this.mostrarnombre_marcaVentaPorLinea= mostrarnombre_marcaVentaPorLinea;
	}

	public Boolean getActivarnombre_marcaVentaPorLinea() {
		return this.activarnombre_marcaVentaPorLinea;
	}

	public void setActivarnombre_marcaVentaPorLinea(Boolean activarnombre_marcaVentaPorLinea) {
		this.activarnombre_marcaVentaPorLinea= activarnombre_marcaVentaPorLinea;
	}

	public Border setResaltarfechaVentaPorLinea(ParametroGeneralUsuario parametroGeneralUsuario/*VentaPorLineaBeanSwingJInternalFrame ventaporlineaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventaporlineaBeanSwingJInternalFrame.jTtoolBarVentaPorLinea.setBorder(borderResaltar);
		
		this.resaltarfechaVentaPorLinea= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfechaVentaPorLinea() {
		return this.resaltarfechaVentaPorLinea;
	}

	public void setResaltarfechaVentaPorLinea(Border borderResaltar) {
		this.resaltarfechaVentaPorLinea= borderResaltar;
	}

	public Boolean getMostrarfechaVentaPorLinea() {
		return this.mostrarfechaVentaPorLinea;
	}

	public void setMostrarfechaVentaPorLinea(Boolean mostrarfechaVentaPorLinea) {
		this.mostrarfechaVentaPorLinea= mostrarfechaVentaPorLinea;
	}

	public Boolean getActivarfechaVentaPorLinea() {
		return this.activarfechaVentaPorLinea;
	}

	public void setActivarfechaVentaPorLinea(Boolean activarfechaVentaPorLinea) {
		this.activarfechaVentaPorLinea= activarfechaVentaPorLinea;
	}

	public Border setResaltarsecuencialVentaPorLinea(ParametroGeneralUsuario parametroGeneralUsuario/*VentaPorLineaBeanSwingJInternalFrame ventaporlineaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventaporlineaBeanSwingJInternalFrame.jTtoolBarVentaPorLinea.setBorder(borderResaltar);
		
		this.resaltarsecuencialVentaPorLinea= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsecuencialVentaPorLinea() {
		return this.resaltarsecuencialVentaPorLinea;
	}

	public void setResaltarsecuencialVentaPorLinea(Border borderResaltar) {
		this.resaltarsecuencialVentaPorLinea= borderResaltar;
	}

	public Boolean getMostrarsecuencialVentaPorLinea() {
		return this.mostrarsecuencialVentaPorLinea;
	}

	public void setMostrarsecuencialVentaPorLinea(Boolean mostrarsecuencialVentaPorLinea) {
		this.mostrarsecuencialVentaPorLinea= mostrarsecuencialVentaPorLinea;
	}

	public Boolean getActivarsecuencialVentaPorLinea() {
		return this.activarsecuencialVentaPorLinea;
	}

	public void setActivarsecuencialVentaPorLinea(Boolean activarsecuencialVentaPorLinea) {
		this.activarsecuencialVentaPorLinea= activarsecuencialVentaPorLinea;
	}

	public Border setResaltarcantidadVentaPorLinea(ParametroGeneralUsuario parametroGeneralUsuario/*VentaPorLineaBeanSwingJInternalFrame ventaporlineaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventaporlineaBeanSwingJInternalFrame.jTtoolBarVentaPorLinea.setBorder(borderResaltar);
		
		this.resaltarcantidadVentaPorLinea= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcantidadVentaPorLinea() {
		return this.resaltarcantidadVentaPorLinea;
	}

	public void setResaltarcantidadVentaPorLinea(Border borderResaltar) {
		this.resaltarcantidadVentaPorLinea= borderResaltar;
	}

	public Boolean getMostrarcantidadVentaPorLinea() {
		return this.mostrarcantidadVentaPorLinea;
	}

	public void setMostrarcantidadVentaPorLinea(Boolean mostrarcantidadVentaPorLinea) {
		this.mostrarcantidadVentaPorLinea= mostrarcantidadVentaPorLinea;
	}

	public Boolean getActivarcantidadVentaPorLinea() {
		return this.activarcantidadVentaPorLinea;
	}

	public void setActivarcantidadVentaPorLinea(Boolean activarcantidadVentaPorLinea) {
		this.activarcantidadVentaPorLinea= activarcantidadVentaPorLinea;
	}

	public Border setResaltarprecioVentaPorLinea(ParametroGeneralUsuario parametroGeneralUsuario/*VentaPorLineaBeanSwingJInternalFrame ventaporlineaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventaporlineaBeanSwingJInternalFrame.jTtoolBarVentaPorLinea.setBorder(borderResaltar);
		
		this.resaltarprecioVentaPorLinea= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarprecioVentaPorLinea() {
		return this.resaltarprecioVentaPorLinea;
	}

	public void setResaltarprecioVentaPorLinea(Border borderResaltar) {
		this.resaltarprecioVentaPorLinea= borderResaltar;
	}

	public Boolean getMostrarprecioVentaPorLinea() {
		return this.mostrarprecioVentaPorLinea;
	}

	public void setMostrarprecioVentaPorLinea(Boolean mostrarprecioVentaPorLinea) {
		this.mostrarprecioVentaPorLinea= mostrarprecioVentaPorLinea;
	}

	public Boolean getActivarprecioVentaPorLinea() {
		return this.activarprecioVentaPorLinea;
	}

	public void setActivarprecioVentaPorLinea(Boolean activarprecioVentaPorLinea) {
		this.activarprecioVentaPorLinea= activarprecioVentaPorLinea;
	}

	public Border setResaltardescuentoVentaPorLinea(ParametroGeneralUsuario parametroGeneralUsuario/*VentaPorLineaBeanSwingJInternalFrame ventaporlineaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventaporlineaBeanSwingJInternalFrame.jTtoolBarVentaPorLinea.setBorder(borderResaltar);
		
		this.resaltardescuentoVentaPorLinea= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescuentoVentaPorLinea() {
		return this.resaltardescuentoVentaPorLinea;
	}

	public void setResaltardescuentoVentaPorLinea(Border borderResaltar) {
		this.resaltardescuentoVentaPorLinea= borderResaltar;
	}

	public Boolean getMostrardescuentoVentaPorLinea() {
		return this.mostrardescuentoVentaPorLinea;
	}

	public void setMostrardescuentoVentaPorLinea(Boolean mostrardescuentoVentaPorLinea) {
		this.mostrardescuentoVentaPorLinea= mostrardescuentoVentaPorLinea;
	}

	public Boolean getActivardescuentoVentaPorLinea() {
		return this.activardescuentoVentaPorLinea;
	}

	public void setActivardescuentoVentaPorLinea(Boolean activardescuentoVentaPorLinea) {
		this.activardescuentoVentaPorLinea= activardescuentoVentaPorLinea;
	}

	public Border setResaltarivaVentaPorLinea(ParametroGeneralUsuario parametroGeneralUsuario/*VentaPorLineaBeanSwingJInternalFrame ventaporlineaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventaporlineaBeanSwingJInternalFrame.jTtoolBarVentaPorLinea.setBorder(borderResaltar);
		
		this.resaltarivaVentaPorLinea= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarivaVentaPorLinea() {
		return this.resaltarivaVentaPorLinea;
	}

	public void setResaltarivaVentaPorLinea(Border borderResaltar) {
		this.resaltarivaVentaPorLinea= borderResaltar;
	}

	public Boolean getMostrarivaVentaPorLinea() {
		return this.mostrarivaVentaPorLinea;
	}

	public void setMostrarivaVentaPorLinea(Boolean mostrarivaVentaPorLinea) {
		this.mostrarivaVentaPorLinea= mostrarivaVentaPorLinea;
	}

	public Boolean getActivarivaVentaPorLinea() {
		return this.activarivaVentaPorLinea;
	}

	public void setActivarivaVentaPorLinea(Boolean activarivaVentaPorLinea) {
		this.activarivaVentaPorLinea= activarivaVentaPorLinea;
	}

	public Border setResaltariceVentaPorLinea(ParametroGeneralUsuario parametroGeneralUsuario/*VentaPorLineaBeanSwingJInternalFrame ventaporlineaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//ventaporlineaBeanSwingJInternalFrame.jTtoolBarVentaPorLinea.setBorder(borderResaltar);
		
		this.resaltariceVentaPorLinea= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltariceVentaPorLinea() {
		return this.resaltariceVentaPorLinea;
	}

	public void setResaltariceVentaPorLinea(Border borderResaltar) {
		this.resaltariceVentaPorLinea= borderResaltar;
	}

	public Boolean getMostrariceVentaPorLinea() {
		return this.mostrariceVentaPorLinea;
	}

	public void setMostrariceVentaPorLinea(Boolean mostrariceVentaPorLinea) {
		this.mostrariceVentaPorLinea= mostrariceVentaPorLinea;
	}

	public Boolean getActivariceVentaPorLinea() {
		return this.activariceVentaPorLinea;
	}

	public void setActivariceVentaPorLinea(Boolean activariceVentaPorLinea) {
		this.activariceVentaPorLinea= activariceVentaPorLinea;
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
		
		
		this.setMostraridVentaPorLinea(esInicial);
		this.setMostrarid_empresaVentaPorLinea(esInicial);
		this.setMostrarid_sucursalVentaPorLinea(esInicial);
		this.setMostrarid_productoVentaPorLinea(esInicial);
		this.setMostrarid_lineaVentaPorLinea(esInicial);
		this.setMostrarid_linea_grupoVentaPorLinea(esInicial);
		this.setMostrarid_linea_categoriaVentaPorLinea(esInicial);
		this.setMostrarid_linea_marcaVentaPorLinea(esInicial);
		this.setMostrarfecha_desdeVentaPorLinea(esInicial);
		this.setMostrarfecha_hastaVentaPorLinea(esInicial);
		this.setMostrarnombre_productoVentaPorLinea(esInicial);
		this.setMostrarnombre_lineaVentaPorLinea(esInicial);
		this.setMostrarnombre_grupoVentaPorLinea(esInicial);
		this.setMostrarnombre_categoriaVentaPorLinea(esInicial);
		this.setMostrarnombre_marcaVentaPorLinea(esInicial);
		this.setMostrarfechaVentaPorLinea(esInicial);
		this.setMostrarsecuencialVentaPorLinea(esInicial);
		this.setMostrarcantidadVentaPorLinea(esInicial);
		this.setMostrarprecioVentaPorLinea(esInicial);
		this.setMostrardescuentoVentaPorLinea(esInicial);
		this.setMostrarivaVentaPorLinea(esInicial);
		this.setMostrariceVentaPorLinea(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(VentaPorLineaConstantesFunciones.ID)) {
				this.setMostraridVentaPorLinea(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentaPorLineaConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaVentaPorLinea(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentaPorLineaConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalVentaPorLinea(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentaPorLineaConstantesFunciones.IDPRODUCTO)) {
				this.setMostrarid_productoVentaPorLinea(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentaPorLineaConstantesFunciones.IDLINEA)) {
				this.setMostrarid_lineaVentaPorLinea(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentaPorLineaConstantesFunciones.IDLINEAGRUPO)) {
				this.setMostrarid_linea_grupoVentaPorLinea(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentaPorLineaConstantesFunciones.IDLINEACATEGORIA)) {
				this.setMostrarid_linea_categoriaVentaPorLinea(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentaPorLineaConstantesFunciones.IDLINEAMARCA)) {
				this.setMostrarid_linea_marcaVentaPorLinea(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentaPorLineaConstantesFunciones.FECHADESDE)) {
				this.setMostrarfecha_desdeVentaPorLinea(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentaPorLineaConstantesFunciones.FECHAHASTA)) {
				this.setMostrarfecha_hastaVentaPorLinea(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentaPorLineaConstantesFunciones.NOMBREPRODUCTO)) {
				this.setMostrarnombre_productoVentaPorLinea(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentaPorLineaConstantesFunciones.NOMBRELINEA)) {
				this.setMostrarnombre_lineaVentaPorLinea(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentaPorLineaConstantesFunciones.NOMBREGRUPO)) {
				this.setMostrarnombre_grupoVentaPorLinea(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentaPorLineaConstantesFunciones.NOMBRECATEGORIA)) {
				this.setMostrarnombre_categoriaVentaPorLinea(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentaPorLineaConstantesFunciones.NOMBREMARCA)) {
				this.setMostrarnombre_marcaVentaPorLinea(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentaPorLineaConstantesFunciones.FECHA)) {
				this.setMostrarfechaVentaPorLinea(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentaPorLineaConstantesFunciones.SECUENCIAL)) {
				this.setMostrarsecuencialVentaPorLinea(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentaPorLineaConstantesFunciones.CANTIDAD)) {
				this.setMostrarcantidadVentaPorLinea(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentaPorLineaConstantesFunciones.PRECIO)) {
				this.setMostrarprecioVentaPorLinea(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentaPorLineaConstantesFunciones.DESCUENTO)) {
				this.setMostrardescuentoVentaPorLinea(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentaPorLineaConstantesFunciones.IVA)) {
				this.setMostrarivaVentaPorLinea(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentaPorLineaConstantesFunciones.ICE)) {
				this.setMostrariceVentaPorLinea(esAsigna);
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
		
		
		this.setActivaridVentaPorLinea(esInicial);
		this.setActivarid_empresaVentaPorLinea(esInicial);
		this.setActivarid_sucursalVentaPorLinea(esInicial);
		this.setActivarid_productoVentaPorLinea(esInicial);
		this.setActivarid_lineaVentaPorLinea(esInicial);
		this.setActivarid_linea_grupoVentaPorLinea(esInicial);
		this.setActivarid_linea_categoriaVentaPorLinea(esInicial);
		this.setActivarid_linea_marcaVentaPorLinea(esInicial);
		this.setActivarfecha_desdeVentaPorLinea(esInicial);
		this.setActivarfecha_hastaVentaPorLinea(esInicial);
		this.setActivarnombre_productoVentaPorLinea(esInicial);
		this.setActivarnombre_lineaVentaPorLinea(esInicial);
		this.setActivarnombre_grupoVentaPorLinea(esInicial);
		this.setActivarnombre_categoriaVentaPorLinea(esInicial);
		this.setActivarnombre_marcaVentaPorLinea(esInicial);
		this.setActivarfechaVentaPorLinea(esInicial);
		this.setActivarsecuencialVentaPorLinea(esInicial);
		this.setActivarcantidadVentaPorLinea(esInicial);
		this.setActivarprecioVentaPorLinea(esInicial);
		this.setActivardescuentoVentaPorLinea(esInicial);
		this.setActivarivaVentaPorLinea(esInicial);
		this.setActivariceVentaPorLinea(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(VentaPorLineaConstantesFunciones.ID)) {
				this.setActivaridVentaPorLinea(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentaPorLineaConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaVentaPorLinea(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentaPorLineaConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalVentaPorLinea(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentaPorLineaConstantesFunciones.IDPRODUCTO)) {
				this.setActivarid_productoVentaPorLinea(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentaPorLineaConstantesFunciones.IDLINEA)) {
				this.setActivarid_lineaVentaPorLinea(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentaPorLineaConstantesFunciones.IDLINEAGRUPO)) {
				this.setActivarid_linea_grupoVentaPorLinea(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentaPorLineaConstantesFunciones.IDLINEACATEGORIA)) {
				this.setActivarid_linea_categoriaVentaPorLinea(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentaPorLineaConstantesFunciones.IDLINEAMARCA)) {
				this.setActivarid_linea_marcaVentaPorLinea(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentaPorLineaConstantesFunciones.FECHADESDE)) {
				this.setActivarfecha_desdeVentaPorLinea(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentaPorLineaConstantesFunciones.FECHAHASTA)) {
				this.setActivarfecha_hastaVentaPorLinea(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentaPorLineaConstantesFunciones.NOMBREPRODUCTO)) {
				this.setActivarnombre_productoVentaPorLinea(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentaPorLineaConstantesFunciones.NOMBRELINEA)) {
				this.setActivarnombre_lineaVentaPorLinea(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentaPorLineaConstantesFunciones.NOMBREGRUPO)) {
				this.setActivarnombre_grupoVentaPorLinea(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentaPorLineaConstantesFunciones.NOMBRECATEGORIA)) {
				this.setActivarnombre_categoriaVentaPorLinea(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentaPorLineaConstantesFunciones.NOMBREMARCA)) {
				this.setActivarnombre_marcaVentaPorLinea(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentaPorLineaConstantesFunciones.FECHA)) {
				this.setActivarfechaVentaPorLinea(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentaPorLineaConstantesFunciones.SECUENCIAL)) {
				this.setActivarsecuencialVentaPorLinea(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentaPorLineaConstantesFunciones.CANTIDAD)) {
				this.setActivarcantidadVentaPorLinea(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentaPorLineaConstantesFunciones.PRECIO)) {
				this.setActivarprecioVentaPorLinea(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentaPorLineaConstantesFunciones.DESCUENTO)) {
				this.setActivardescuentoVentaPorLinea(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentaPorLineaConstantesFunciones.IVA)) {
				this.setActivarivaVentaPorLinea(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentaPorLineaConstantesFunciones.ICE)) {
				this.setActivariceVentaPorLinea(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,VentaPorLineaBeanSwingJInternalFrame ventaporlineaBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridVentaPorLinea(esInicial);
		this.setResaltarid_empresaVentaPorLinea(esInicial);
		this.setResaltarid_sucursalVentaPorLinea(esInicial);
		this.setResaltarid_productoVentaPorLinea(esInicial);
		this.setResaltarid_lineaVentaPorLinea(esInicial);
		this.setResaltarid_linea_grupoVentaPorLinea(esInicial);
		this.setResaltarid_linea_categoriaVentaPorLinea(esInicial);
		this.setResaltarid_linea_marcaVentaPorLinea(esInicial);
		this.setResaltarfecha_desdeVentaPorLinea(esInicial);
		this.setResaltarfecha_hastaVentaPorLinea(esInicial);
		this.setResaltarnombre_productoVentaPorLinea(esInicial);
		this.setResaltarnombre_lineaVentaPorLinea(esInicial);
		this.setResaltarnombre_grupoVentaPorLinea(esInicial);
		this.setResaltarnombre_categoriaVentaPorLinea(esInicial);
		this.setResaltarnombre_marcaVentaPorLinea(esInicial);
		this.setResaltarfechaVentaPorLinea(esInicial);
		this.setResaltarsecuencialVentaPorLinea(esInicial);
		this.setResaltarcantidadVentaPorLinea(esInicial);
		this.setResaltarprecioVentaPorLinea(esInicial);
		this.setResaltardescuentoVentaPorLinea(esInicial);
		this.setResaltarivaVentaPorLinea(esInicial);
		this.setResaltariceVentaPorLinea(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(VentaPorLineaConstantesFunciones.ID)) {
				this.setResaltaridVentaPorLinea(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentaPorLineaConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaVentaPorLinea(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentaPorLineaConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalVentaPorLinea(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentaPorLineaConstantesFunciones.IDPRODUCTO)) {
				this.setResaltarid_productoVentaPorLinea(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentaPorLineaConstantesFunciones.IDLINEA)) {
				this.setResaltarid_lineaVentaPorLinea(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentaPorLineaConstantesFunciones.IDLINEAGRUPO)) {
				this.setResaltarid_linea_grupoVentaPorLinea(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentaPorLineaConstantesFunciones.IDLINEACATEGORIA)) {
				this.setResaltarid_linea_categoriaVentaPorLinea(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentaPorLineaConstantesFunciones.IDLINEAMARCA)) {
				this.setResaltarid_linea_marcaVentaPorLinea(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentaPorLineaConstantesFunciones.FECHADESDE)) {
				this.setResaltarfecha_desdeVentaPorLinea(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentaPorLineaConstantesFunciones.FECHAHASTA)) {
				this.setResaltarfecha_hastaVentaPorLinea(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentaPorLineaConstantesFunciones.NOMBREPRODUCTO)) {
				this.setResaltarnombre_productoVentaPorLinea(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentaPorLineaConstantesFunciones.NOMBRELINEA)) {
				this.setResaltarnombre_lineaVentaPorLinea(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentaPorLineaConstantesFunciones.NOMBREGRUPO)) {
				this.setResaltarnombre_grupoVentaPorLinea(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentaPorLineaConstantesFunciones.NOMBRECATEGORIA)) {
				this.setResaltarnombre_categoriaVentaPorLinea(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentaPorLineaConstantesFunciones.NOMBREMARCA)) {
				this.setResaltarnombre_marcaVentaPorLinea(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentaPorLineaConstantesFunciones.FECHA)) {
				this.setResaltarfechaVentaPorLinea(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentaPorLineaConstantesFunciones.SECUENCIAL)) {
				this.setResaltarsecuencialVentaPorLinea(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentaPorLineaConstantesFunciones.CANTIDAD)) {
				this.setResaltarcantidadVentaPorLinea(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentaPorLineaConstantesFunciones.PRECIO)) {
				this.setResaltarprecioVentaPorLinea(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentaPorLineaConstantesFunciones.DESCUENTO)) {
				this.setResaltardescuentoVentaPorLinea(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentaPorLineaConstantesFunciones.IVA)) {
				this.setResaltarivaVentaPorLinea(esAsigna);
				continue;
			}

			if(campo.clase.equals(VentaPorLineaConstantesFunciones.ICE)) {
				this.setResaltariceVentaPorLinea(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,VentaPorLineaBeanSwingJInternalFrame ventaporlineaBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaVentaPorLineaVentaPorLinea=true;

	public Boolean getMostrarBusquedaVentaPorLineaVentaPorLinea() {
		return this.mostrarBusquedaVentaPorLineaVentaPorLinea;
	}

	public void setMostrarBusquedaVentaPorLineaVentaPorLinea(Boolean visibilidadResaltar) {
		this.mostrarBusquedaVentaPorLineaVentaPorLinea= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaVentaPorLineaVentaPorLinea=true;

	public Boolean getActivarBusquedaVentaPorLineaVentaPorLinea() {
		return this.activarBusquedaVentaPorLineaVentaPorLinea;
	}

	public void setActivarBusquedaVentaPorLineaVentaPorLinea(Boolean habilitarResaltar) {
		this.activarBusquedaVentaPorLineaVentaPorLinea= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaVentaPorLineaVentaPorLinea=null;

	public Border getResaltarBusquedaVentaPorLineaVentaPorLinea() {
		return this.resaltarBusquedaVentaPorLineaVentaPorLinea;
	}

	public void setResaltarBusquedaVentaPorLineaVentaPorLinea(Border borderResaltar) {
		this.resaltarBusquedaVentaPorLineaVentaPorLinea= borderResaltar;
	}

	public void setResaltarBusquedaVentaPorLineaVentaPorLinea(ParametroGeneralUsuario parametroGeneralUsuario/*VentaPorLineaBeanSwingJInternalFrame ventaporlineaBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaVentaPorLineaVentaPorLinea= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}