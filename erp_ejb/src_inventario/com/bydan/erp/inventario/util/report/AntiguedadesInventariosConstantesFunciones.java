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
package com.bydan.erp.inventario.util.report;

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


import com.bydan.erp.inventario.util.report.AntiguedadesInventariosConstantesFunciones;
import com.bydan.erp.inventario.util.report.AntiguedadesInventariosParameterReturnGeneral;
//import com.bydan.erp.inventario.util.report.AntiguedadesInventariosParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.inventario.business.entity.report.*;



import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.inventario.util.*;
import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.inventario.business.dataaccess.*;
//import com.bydan.erp.inventario.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class AntiguedadesInventariosConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="AntiguedadesInventarios";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="AntiguedadesInventarios"+AntiguedadesInventariosConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="AntiguedadesInventariosHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="AntiguedadesInventariosHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=AntiguedadesInventariosConstantesFunciones.SCHEMA+"_"+AntiguedadesInventariosConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/AntiguedadesInventariosHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=AntiguedadesInventariosConstantesFunciones.SCHEMA+"_"+AntiguedadesInventariosConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=AntiguedadesInventariosConstantesFunciones.SCHEMA+"_"+AntiguedadesInventariosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/AntiguedadesInventariosHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=AntiguedadesInventariosConstantesFunciones.SCHEMA+"_"+AntiguedadesInventariosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+AntiguedadesInventariosConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/AntiguedadesInventariosHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+AntiguedadesInventariosConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+AntiguedadesInventariosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/AntiguedadesInventariosHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+AntiguedadesInventariosConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=AntiguedadesInventariosConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+AntiguedadesInventariosConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=AntiguedadesInventariosConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+AntiguedadesInventariosConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Antiguedades Inventarioses";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Antiguedades Inventarios";
	public static final String SCLASSWEBTITULO_LOWER="Antiguedades Inventarios";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="AntiguedadesInventarios";
	public static final String OBJECTNAME="antiguedadesinventarios";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="antiguedades_inventarios";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select antiguedadesinventarios from "+AntiguedadesInventariosConstantesFunciones.SPERSISTENCENAME+" antiguedadesinventarios";
	public static String QUERYSELECTNATIVE="select "+AntiguedadesInventariosConstantesFunciones.SCHEMA+"."+AntiguedadesInventariosConstantesFunciones.TABLENAME+".id,"+AntiguedadesInventariosConstantesFunciones.SCHEMA+"."+AntiguedadesInventariosConstantesFunciones.TABLENAME+".version_row,"+AntiguedadesInventariosConstantesFunciones.SCHEMA+"."+AntiguedadesInventariosConstantesFunciones.TABLENAME+".id_bodega,"+AntiguedadesInventariosConstantesFunciones.SCHEMA+"."+AntiguedadesInventariosConstantesFunciones.TABLENAME+".id_empresa,"+AntiguedadesInventariosConstantesFunciones.SCHEMA+"."+AntiguedadesInventariosConstantesFunciones.TABLENAME+".id_sucursal,"+AntiguedadesInventariosConstantesFunciones.SCHEMA+"."+AntiguedadesInventariosConstantesFunciones.TABLENAME+".id_linea,"+AntiguedadesInventariosConstantesFunciones.SCHEMA+"."+AntiguedadesInventariosConstantesFunciones.TABLENAME+".id_linea_grupo,"+AntiguedadesInventariosConstantesFunciones.SCHEMA+"."+AntiguedadesInventariosConstantesFunciones.TABLENAME+".id_linea_categoria,"+AntiguedadesInventariosConstantesFunciones.SCHEMA+"."+AntiguedadesInventariosConstantesFunciones.TABLENAME+".id_linea_marca,"+AntiguedadesInventariosConstantesFunciones.SCHEMA+"."+AntiguedadesInventariosConstantesFunciones.TABLENAME+".fecha_ultima_venta_hasta,"+AntiguedadesInventariosConstantesFunciones.SCHEMA+"."+AntiguedadesInventariosConstantesFunciones.TABLENAME+".nombre_sucursal,"+AntiguedadesInventariosConstantesFunciones.SCHEMA+"."+AntiguedadesInventariosConstantesFunciones.TABLENAME+".nombre_linea,"+AntiguedadesInventariosConstantesFunciones.SCHEMA+"."+AntiguedadesInventariosConstantesFunciones.TABLENAME+".nombre_linea_grupo,"+AntiguedadesInventariosConstantesFunciones.SCHEMA+"."+AntiguedadesInventariosConstantesFunciones.TABLENAME+".nombre_linea_categoria,"+AntiguedadesInventariosConstantesFunciones.SCHEMA+"."+AntiguedadesInventariosConstantesFunciones.TABLENAME+".nombre_linea_marca,"+AntiguedadesInventariosConstantesFunciones.SCHEMA+"."+AntiguedadesInventariosConstantesFunciones.TABLENAME+".codigo,"+AntiguedadesInventariosConstantesFunciones.SCHEMA+"."+AntiguedadesInventariosConstantesFunciones.TABLENAME+".nombre,"+AntiguedadesInventariosConstantesFunciones.SCHEMA+"."+AntiguedadesInventariosConstantesFunciones.TABLENAME+".nombre_bodega,"+AntiguedadesInventariosConstantesFunciones.SCHEMA+"."+AntiguedadesInventariosConstantesFunciones.TABLENAME+".nombre_unidad,"+AntiguedadesInventariosConstantesFunciones.SCHEMA+"."+AntiguedadesInventariosConstantesFunciones.TABLENAME+".cantidad_disponible,"+AntiguedadesInventariosConstantesFunciones.SCHEMA+"."+AntiguedadesInventariosConstantesFunciones.TABLENAME+".fecha_ultima_compra,"+AntiguedadesInventariosConstantesFunciones.SCHEMA+"."+AntiguedadesInventariosConstantesFunciones.TABLENAME+".fecha_ultima_venta from "+AntiguedadesInventariosConstantesFunciones.SCHEMA+"."+AntiguedadesInventariosConstantesFunciones.TABLENAME;//+" as "+AntiguedadesInventariosConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDBODEGA= "id_bodega";
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDLINEA= "id_linea";
    public static final String IDLINEAGRUPO= "id_linea_grupo";
    public static final String IDLINEACATEGORIA= "id_linea_categoria";
    public static final String IDLINEAMARCA= "id_linea_marca";
    public static final String FECHAULTIMAVENTAHASTA= "fecha_ultima_venta_hasta";
    public static final String NOMBRESUCURSAL= "nombre_sucursal";
    public static final String NOMBRELINEA= "nombre_linea";
    public static final String NOMBRELINEAGRUPO= "nombre_linea_grupo";
    public static final String NOMBRELINEACATEGORIA= "nombre_linea_categoria";
    public static final String NOMBRELINEAMARCA= "nombre_linea_marca";
    public static final String CODIGO= "codigo";
    public static final String NOMBRE= "nombre";
    public static final String NOMBREBODEGA= "nombre_bodega";
    public static final String NOMBREUNIDAD= "nombre_unidad";
    public static final String CANTIDADDISPONIBLE= "cantidad_disponible";
    public static final String FECHAULTIMACOMPRA= "fecha_ultima_compra";
    public static final String FECHAULTIMAVENTA= "fecha_ultima_venta";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDBODEGA= "Bodega";
		public static final String LABEL_IDBODEGA_LOWER= "Bodega";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDLINEA= "Linea";
		public static final String LABEL_IDLINEA_LOWER= "Linea";
    	public static final String LABEL_IDLINEAGRUPO= "Linea Grupo";
		public static final String LABEL_IDLINEAGRUPO_LOWER= "Linea Grupo";
    	public static final String LABEL_IDLINEACATEGORIA= "Linea Categoria";
		public static final String LABEL_IDLINEACATEGORIA_LOWER= "Linea Categoria";
    	public static final String LABEL_IDLINEAMARCA= "Linea Marca";
		public static final String LABEL_IDLINEAMARCA_LOWER= "Linea Marca";
    	public static final String LABEL_FECHAULTIMAVENTAHASTA= "Fecha Ultima Venta Hasta";
		public static final String LABEL_FECHAULTIMAVENTAHASTA_LOWER= "Fecha Ultima Venta Hasta";
    	public static final String LABEL_NOMBRESUCURSAL= "Nombre Sucursal";
		public static final String LABEL_NOMBRESUCURSAL_LOWER= "Nombre Sucursal";
    	public static final String LABEL_NOMBRELINEA= "Nombre Linea";
		public static final String LABEL_NOMBRELINEA_LOWER= "Nombre Linea";
    	public static final String LABEL_NOMBRELINEAGRUPO= "Nombre Linea Grupo";
		public static final String LABEL_NOMBRELINEAGRUPO_LOWER= "Nombre Linea Grupo";
    	public static final String LABEL_NOMBRELINEACATEGORIA= "Nombre Linea Categoria";
		public static final String LABEL_NOMBRELINEACATEGORIA_LOWER= "Nombre Linea Categoria";
    	public static final String LABEL_NOMBRELINEAMARCA= "Nombre Linea Marca";
		public static final String LABEL_NOMBRELINEAMARCA_LOWER= "Nombre Linea Marca";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_NOMBREBODEGA= "Nombre Bodega";
		public static final String LABEL_NOMBREBODEGA_LOWER= "Nombre Bodega";
    	public static final String LABEL_NOMBREUNIDAD= "Nombre Unad";
		public static final String LABEL_NOMBREUNIDAD_LOWER= "Nombre Unidad";
    	public static final String LABEL_CANTIDADDISPONIBLE= "Cantad Disponible";
		public static final String LABEL_CANTIDADDISPONIBLE_LOWER= "Cantidad Disponible";
    	public static final String LABEL_FECHAULTIMACOMPRA= "Fecha Ultima Compra";
		public static final String LABEL_FECHAULTIMACOMPRA_LOWER= "Fecha Ultima Compra";
    	public static final String LABEL_FECHAULTIMAVENTA= "Fecha Ultima Venta";
		public static final String LABEL_FECHAULTIMAVENTA_LOWER= "Fecha Ultima Venta";
	
		
		
		
		
		
		
		
		
		
		
	public static final String SREGEXNOMBRE_SUCURSAL=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_SUCURSAL=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_LINEA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_LINEA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_LINEA_GRUPO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_LINEA_GRUPO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_LINEA_CATEGORIA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_LINEA_CATEGORIA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_LINEA_MARCA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_LINEA_MARCA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_BODEGA=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_BODEGA=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_UNIDAD=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_UNIDAD=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
	
	public static String getAntiguedadesInventariosLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(AntiguedadesInventariosConstantesFunciones.IDBODEGA)) {sLabelColumna=AntiguedadesInventariosConstantesFunciones.LABEL_IDBODEGA;}
		if(sNombreColumna.equals(AntiguedadesInventariosConstantesFunciones.IDEMPRESA)) {sLabelColumna=AntiguedadesInventariosConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(AntiguedadesInventariosConstantesFunciones.IDSUCURSAL)) {sLabelColumna=AntiguedadesInventariosConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(AntiguedadesInventariosConstantesFunciones.IDLINEA)) {sLabelColumna=AntiguedadesInventariosConstantesFunciones.LABEL_IDLINEA;}
		if(sNombreColumna.equals(AntiguedadesInventariosConstantesFunciones.IDLINEAGRUPO)) {sLabelColumna=AntiguedadesInventariosConstantesFunciones.LABEL_IDLINEAGRUPO;}
		if(sNombreColumna.equals(AntiguedadesInventariosConstantesFunciones.IDLINEACATEGORIA)) {sLabelColumna=AntiguedadesInventariosConstantesFunciones.LABEL_IDLINEACATEGORIA;}
		if(sNombreColumna.equals(AntiguedadesInventariosConstantesFunciones.IDLINEAMARCA)) {sLabelColumna=AntiguedadesInventariosConstantesFunciones.LABEL_IDLINEAMARCA;}
		if(sNombreColumna.equals(AntiguedadesInventariosConstantesFunciones.FECHAULTIMAVENTAHASTA)) {sLabelColumna=AntiguedadesInventariosConstantesFunciones.LABEL_FECHAULTIMAVENTAHASTA;}
		if(sNombreColumna.equals(AntiguedadesInventariosConstantesFunciones.NOMBRESUCURSAL)) {sLabelColumna=AntiguedadesInventariosConstantesFunciones.LABEL_NOMBRESUCURSAL;}
		if(sNombreColumna.equals(AntiguedadesInventariosConstantesFunciones.NOMBRELINEA)) {sLabelColumna=AntiguedadesInventariosConstantesFunciones.LABEL_NOMBRELINEA;}
		if(sNombreColumna.equals(AntiguedadesInventariosConstantesFunciones.NOMBRELINEAGRUPO)) {sLabelColumna=AntiguedadesInventariosConstantesFunciones.LABEL_NOMBRELINEAGRUPO;}
		if(sNombreColumna.equals(AntiguedadesInventariosConstantesFunciones.NOMBRELINEACATEGORIA)) {sLabelColumna=AntiguedadesInventariosConstantesFunciones.LABEL_NOMBRELINEACATEGORIA;}
		if(sNombreColumna.equals(AntiguedadesInventariosConstantesFunciones.NOMBRELINEAMARCA)) {sLabelColumna=AntiguedadesInventariosConstantesFunciones.LABEL_NOMBRELINEAMARCA;}
		if(sNombreColumna.equals(AntiguedadesInventariosConstantesFunciones.CODIGO)) {sLabelColumna=AntiguedadesInventariosConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(AntiguedadesInventariosConstantesFunciones.NOMBRE)) {sLabelColumna=AntiguedadesInventariosConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(AntiguedadesInventariosConstantesFunciones.NOMBREBODEGA)) {sLabelColumna=AntiguedadesInventariosConstantesFunciones.LABEL_NOMBREBODEGA;}
		if(sNombreColumna.equals(AntiguedadesInventariosConstantesFunciones.NOMBREUNIDAD)) {sLabelColumna=AntiguedadesInventariosConstantesFunciones.LABEL_NOMBREUNIDAD;}
		if(sNombreColumna.equals(AntiguedadesInventariosConstantesFunciones.CANTIDADDISPONIBLE)) {sLabelColumna=AntiguedadesInventariosConstantesFunciones.LABEL_CANTIDADDISPONIBLE;}
		if(sNombreColumna.equals(AntiguedadesInventariosConstantesFunciones.FECHAULTIMACOMPRA)) {sLabelColumna=AntiguedadesInventariosConstantesFunciones.LABEL_FECHAULTIMACOMPRA;}
		if(sNombreColumna.equals(AntiguedadesInventariosConstantesFunciones.FECHAULTIMAVENTA)) {sLabelColumna=AntiguedadesInventariosConstantesFunciones.LABEL_FECHAULTIMAVENTA;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getAntiguedadesInventariosDescripcion(AntiguedadesInventarios antiguedadesinventarios) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(antiguedadesinventarios !=null/* && antiguedadesinventarios.getId()!=0*/) {
			sDescripcion=antiguedadesinventarios.getcodigo();//antiguedadesinventariosantiguedadesinventarios.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getAntiguedadesInventariosDescripcionDetallado(AntiguedadesInventarios antiguedadesinventarios) {
		String sDescripcion="";
			
		sDescripcion+=AntiguedadesInventariosConstantesFunciones.ID+"=";
		sDescripcion+=antiguedadesinventarios.getId().toString()+",";
		sDescripcion+=AntiguedadesInventariosConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=antiguedadesinventarios.getVersionRow().toString()+",";
		sDescripcion+=AntiguedadesInventariosConstantesFunciones.IDBODEGA+"=";
		sDescripcion+=antiguedadesinventarios.getid_bodega().toString()+",";
		sDescripcion+=AntiguedadesInventariosConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=antiguedadesinventarios.getid_empresa().toString()+",";
		sDescripcion+=AntiguedadesInventariosConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=antiguedadesinventarios.getid_sucursal().toString()+",";
		sDescripcion+=AntiguedadesInventariosConstantesFunciones.IDLINEA+"=";
		sDescripcion+=antiguedadesinventarios.getid_linea().toString()+",";
		sDescripcion+=AntiguedadesInventariosConstantesFunciones.IDLINEAGRUPO+"=";
		sDescripcion+=antiguedadesinventarios.getid_linea_grupo().toString()+",";
		sDescripcion+=AntiguedadesInventariosConstantesFunciones.IDLINEACATEGORIA+"=";
		sDescripcion+=antiguedadesinventarios.getid_linea_categoria().toString()+",";
		sDescripcion+=AntiguedadesInventariosConstantesFunciones.IDLINEAMARCA+"=";
		sDescripcion+=antiguedadesinventarios.getid_linea_marca().toString()+",";
		sDescripcion+=AntiguedadesInventariosConstantesFunciones.FECHAULTIMAVENTAHASTA+"=";
		sDescripcion+=antiguedadesinventarios.getfecha_ultima_venta_hasta().toString()+",";
		sDescripcion+=AntiguedadesInventariosConstantesFunciones.NOMBRESUCURSAL+"=";
		sDescripcion+=antiguedadesinventarios.getnombre_sucursal()+",";
		sDescripcion+=AntiguedadesInventariosConstantesFunciones.NOMBRELINEA+"=";
		sDescripcion+=antiguedadesinventarios.getnombre_linea()+",";
		sDescripcion+=AntiguedadesInventariosConstantesFunciones.NOMBRELINEAGRUPO+"=";
		sDescripcion+=antiguedadesinventarios.getnombre_linea_grupo()+",";
		sDescripcion+=AntiguedadesInventariosConstantesFunciones.NOMBRELINEACATEGORIA+"=";
		sDescripcion+=antiguedadesinventarios.getnombre_linea_categoria()+",";
		sDescripcion+=AntiguedadesInventariosConstantesFunciones.NOMBRELINEAMARCA+"=";
		sDescripcion+=antiguedadesinventarios.getnombre_linea_marca()+",";
		sDescripcion+=AntiguedadesInventariosConstantesFunciones.CODIGO+"=";
		sDescripcion+=antiguedadesinventarios.getcodigo()+",";
		sDescripcion+=AntiguedadesInventariosConstantesFunciones.NOMBRE+"=";
		sDescripcion+=antiguedadesinventarios.getnombre()+",";
		sDescripcion+=AntiguedadesInventariosConstantesFunciones.NOMBREBODEGA+"=";
		sDescripcion+=antiguedadesinventarios.getnombre_bodega()+",";
		sDescripcion+=AntiguedadesInventariosConstantesFunciones.NOMBREUNIDAD+"=";
		sDescripcion+=antiguedadesinventarios.getnombre_unidad()+",";
		sDescripcion+=AntiguedadesInventariosConstantesFunciones.CANTIDADDISPONIBLE+"=";
		sDescripcion+=antiguedadesinventarios.getcantidad_disponible().toString()+",";
		sDescripcion+=AntiguedadesInventariosConstantesFunciones.FECHAULTIMACOMPRA+"=";
		sDescripcion+=antiguedadesinventarios.getfecha_ultima_compra().toString()+",";
		sDescripcion+=AntiguedadesInventariosConstantesFunciones.FECHAULTIMAVENTA+"=";
		sDescripcion+=antiguedadesinventarios.getfecha_ultima_venta().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setAntiguedadesInventariosDescripcion(AntiguedadesInventarios antiguedadesinventarios,String sValor) throws Exception {			
		if(antiguedadesinventarios !=null) {
			antiguedadesinventarios.setcodigo(sValor);;//antiguedadesinventariosantiguedadesinventarios.getcodigo().trim();
		}		
	}
	
		

	public static String getBodegaDescripcion(Bodega bodega) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(bodega!=null/*&&bodega.getId()>0*/) {
			sDescripcion=BodegaConstantesFunciones.getBodegaDescripcion(bodega);
		}

		return sDescripcion;
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
		} else if(sNombreIndice.equals("BusquedaAntiguedadesInventarios")) {
			sNombreIndice="Tipo=  Por Bodega Por Linea Por Linea Grupo Por Linea Categoria Por Linea Marca Por Fecha Ultima Venta Hasta";
		} else if(sNombreIndice.equals("FK_IdBodega")) {
			sNombreIndice="Tipo=  Por Bodega";
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
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaAntiguedadesInventarios(Long id_bodega,Long id_linea,Long id_linea_grupo,Long id_linea_categoria,Long id_linea_marca,Date fecha_ultima_venta_hasta) {
		String sDetalleIndice=" Parametros->";
		if(id_bodega!=null) {sDetalleIndice+=" Codigo Unico De Bodega="+id_bodega.toString();}
		if(id_linea!=null) {sDetalleIndice+=" Codigo Unico De Linea="+id_linea.toString();}
		if(id_linea_grupo!=null) {sDetalleIndice+=" Codigo Unico De Linea Grupo="+id_linea_grupo.toString();}
		if(id_linea_categoria!=null) {sDetalleIndice+=" Codigo Unico De Linea Categoria="+id_linea_categoria.toString();}
		if(id_linea_marca!=null) {sDetalleIndice+=" Codigo Unico De Linea Marca="+id_linea_marca.toString();}
		if(fecha_ultima_venta_hasta!=null) {sDetalleIndice+=" Fecha Ultima Venta Hasta="+fecha_ultima_venta_hasta.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdBodega(Long id_bodega) {
		String sDetalleIndice=" Parametros->";
		if(id_bodega!=null) {sDetalleIndice+=" Codigo Unico De Bodega="+id_bodega.toString();} 

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

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosAntiguedadesInventarios(AntiguedadesInventarios antiguedadesinventarios,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		antiguedadesinventarios.setnombre_sucursal(antiguedadesinventarios.getnombre_sucursal().trim());
		antiguedadesinventarios.setnombre_linea(antiguedadesinventarios.getnombre_linea().trim());
		antiguedadesinventarios.setnombre_linea_grupo(antiguedadesinventarios.getnombre_linea_grupo().trim());
		antiguedadesinventarios.setnombre_linea_categoria(antiguedadesinventarios.getnombre_linea_categoria().trim());
		antiguedadesinventarios.setnombre_linea_marca(antiguedadesinventarios.getnombre_linea_marca().trim());
		antiguedadesinventarios.setcodigo(antiguedadesinventarios.getcodigo().trim());
		antiguedadesinventarios.setnombre(antiguedadesinventarios.getnombre().trim());
		antiguedadesinventarios.setnombre_bodega(antiguedadesinventarios.getnombre_bodega().trim());
		antiguedadesinventarios.setnombre_unidad(antiguedadesinventarios.getnombre_unidad().trim());
	}
	
	public static void quitarEspaciosAntiguedadesInventarioss(List<AntiguedadesInventarios> antiguedadesinventarioss,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(AntiguedadesInventarios antiguedadesinventarios: antiguedadesinventarioss) {
			antiguedadesinventarios.setnombre_sucursal(antiguedadesinventarios.getnombre_sucursal().trim());
			antiguedadesinventarios.setnombre_linea(antiguedadesinventarios.getnombre_linea().trim());
			antiguedadesinventarios.setnombre_linea_grupo(antiguedadesinventarios.getnombre_linea_grupo().trim());
			antiguedadesinventarios.setnombre_linea_categoria(antiguedadesinventarios.getnombre_linea_categoria().trim());
			antiguedadesinventarios.setnombre_linea_marca(antiguedadesinventarios.getnombre_linea_marca().trim());
			antiguedadesinventarios.setcodigo(antiguedadesinventarios.getcodigo().trim());
			antiguedadesinventarios.setnombre(antiguedadesinventarios.getnombre().trim());
			antiguedadesinventarios.setnombre_bodega(antiguedadesinventarios.getnombre_bodega().trim());
			antiguedadesinventarios.setnombre_unidad(antiguedadesinventarios.getnombre_unidad().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresAntiguedadesInventarios(AntiguedadesInventarios antiguedadesinventarios,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && antiguedadesinventarios.getConCambioAuxiliar()) {
			antiguedadesinventarios.setIsDeleted(antiguedadesinventarios.getIsDeletedAuxiliar());	
			antiguedadesinventarios.setIsNew(antiguedadesinventarios.getIsNewAuxiliar());	
			antiguedadesinventarios.setIsChanged(antiguedadesinventarios.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			antiguedadesinventarios.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			antiguedadesinventarios.setIsDeletedAuxiliar(false);	
			antiguedadesinventarios.setIsNewAuxiliar(false);	
			antiguedadesinventarios.setIsChangedAuxiliar(false);
			
			antiguedadesinventarios.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresAntiguedadesInventarioss(List<AntiguedadesInventarios> antiguedadesinventarioss,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(AntiguedadesInventarios antiguedadesinventarios : antiguedadesinventarioss) {
			if(conAsignarBase && antiguedadesinventarios.getConCambioAuxiliar()) {
				antiguedadesinventarios.setIsDeleted(antiguedadesinventarios.getIsDeletedAuxiliar());	
				antiguedadesinventarios.setIsNew(antiguedadesinventarios.getIsNewAuxiliar());	
				antiguedadesinventarios.setIsChanged(antiguedadesinventarios.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				antiguedadesinventarios.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				antiguedadesinventarios.setIsDeletedAuxiliar(false);	
				antiguedadesinventarios.setIsNewAuxiliar(false);	
				antiguedadesinventarios.setIsChangedAuxiliar(false);
				
				antiguedadesinventarios.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresAntiguedadesInventarios(AntiguedadesInventarios antiguedadesinventarios,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
			antiguedadesinventarios.setcantidad_disponible(0);
		}
	}		
	
	public static void InicializarValoresAntiguedadesInventarioss(List<AntiguedadesInventarios> antiguedadesinventarioss,Boolean conEnteros) throws Exception  {
		
		for(AntiguedadesInventarios antiguedadesinventarios: antiguedadesinventarioss) {
		
			if(conEnteros) {
				Short ish_value=0;
				
				antiguedadesinventarios.setcantidad_disponible(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaAntiguedadesInventarios(List<AntiguedadesInventarios> antiguedadesinventarioss,AntiguedadesInventarios antiguedadesinventariosAux) throws Exception  {
		AntiguedadesInventariosConstantesFunciones.InicializarValoresAntiguedadesInventarios(antiguedadesinventariosAux,true);
		
		for(AntiguedadesInventarios antiguedadesinventarios: antiguedadesinventarioss) {
			if(antiguedadesinventarios.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			antiguedadesinventariosAux.setcantidad_disponible(antiguedadesinventariosAux.getcantidad_disponible()+antiguedadesinventarios.getcantidad_disponible());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesAntiguedadesInventarios(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=AntiguedadesInventariosConstantesFunciones.getArrayColumnasGlobalesAntiguedadesInventarios(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesAntiguedadesInventarios(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(AntiguedadesInventariosConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(AntiguedadesInventariosConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(AntiguedadesInventariosConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(AntiguedadesInventariosConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoAntiguedadesInventarios(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<AntiguedadesInventarios> antiguedadesinventarioss,AntiguedadesInventarios antiguedadesinventarios,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(AntiguedadesInventarios antiguedadesinventariosAux: antiguedadesinventarioss) {
			if(antiguedadesinventariosAux!=null && antiguedadesinventarios!=null) {
				if((antiguedadesinventariosAux.getId()==null && antiguedadesinventarios.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(antiguedadesinventariosAux.getId()!=null && antiguedadesinventarios.getId()!=null){
					if(antiguedadesinventariosAux.getId().equals(antiguedadesinventarios.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaAntiguedadesInventarios(List<AntiguedadesInventarios> antiguedadesinventarioss) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(AntiguedadesInventarios antiguedadesinventarios: antiguedadesinventarioss) {			
			if(antiguedadesinventarios.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaAntiguedadesInventarios() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,AntiguedadesInventariosConstantesFunciones.LABEL_ID, AntiguedadesInventariosConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AntiguedadesInventariosConstantesFunciones.LABEL_VERSIONROW, AntiguedadesInventariosConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AntiguedadesInventariosConstantesFunciones.LABEL_NOMBRESUCURSAL, AntiguedadesInventariosConstantesFunciones.NOMBRESUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AntiguedadesInventariosConstantesFunciones.LABEL_NOMBRELINEA, AntiguedadesInventariosConstantesFunciones.NOMBRELINEA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AntiguedadesInventariosConstantesFunciones.LABEL_NOMBRELINEAGRUPO, AntiguedadesInventariosConstantesFunciones.NOMBRELINEAGRUPO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AntiguedadesInventariosConstantesFunciones.LABEL_NOMBRELINEACATEGORIA, AntiguedadesInventariosConstantesFunciones.NOMBRELINEACATEGORIA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AntiguedadesInventariosConstantesFunciones.LABEL_NOMBRELINEAMARCA, AntiguedadesInventariosConstantesFunciones.NOMBRELINEAMARCA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AntiguedadesInventariosConstantesFunciones.LABEL_CODIGO, AntiguedadesInventariosConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AntiguedadesInventariosConstantesFunciones.LABEL_NOMBRE, AntiguedadesInventariosConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AntiguedadesInventariosConstantesFunciones.LABEL_NOMBREBODEGA, AntiguedadesInventariosConstantesFunciones.NOMBREBODEGA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AntiguedadesInventariosConstantesFunciones.LABEL_NOMBREUNIDAD, AntiguedadesInventariosConstantesFunciones.NOMBREUNIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AntiguedadesInventariosConstantesFunciones.LABEL_CANTIDADDISPONIBLE, AntiguedadesInventariosConstantesFunciones.CANTIDADDISPONIBLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AntiguedadesInventariosConstantesFunciones.LABEL_FECHAULTIMACOMPRA, AntiguedadesInventariosConstantesFunciones.FECHAULTIMACOMPRA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,AntiguedadesInventariosConstantesFunciones.LABEL_FECHAULTIMAVENTA, AntiguedadesInventariosConstantesFunciones.FECHAULTIMAVENTA,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasAntiguedadesInventarios() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=AntiguedadesInventariosConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AntiguedadesInventariosConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AntiguedadesInventariosConstantesFunciones.NOMBRESUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AntiguedadesInventariosConstantesFunciones.NOMBRELINEA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AntiguedadesInventariosConstantesFunciones.NOMBRELINEAGRUPO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AntiguedadesInventariosConstantesFunciones.NOMBRELINEACATEGORIA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AntiguedadesInventariosConstantesFunciones.NOMBRELINEAMARCA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AntiguedadesInventariosConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AntiguedadesInventariosConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AntiguedadesInventariosConstantesFunciones.NOMBREBODEGA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AntiguedadesInventariosConstantesFunciones.NOMBREUNIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AntiguedadesInventariosConstantesFunciones.CANTIDADDISPONIBLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AntiguedadesInventariosConstantesFunciones.FECHAULTIMACOMPRA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=AntiguedadesInventariosConstantesFunciones.FECHAULTIMAVENTA;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarAntiguedadesInventarios() throws Exception  {
		return AntiguedadesInventariosConstantesFunciones.getTiposSeleccionarAntiguedadesInventarios(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarAntiguedadesInventarios(Boolean conFk) throws Exception  {
		return AntiguedadesInventariosConstantesFunciones.getTiposSeleccionarAntiguedadesInventarios(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarAntiguedadesInventarios(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(AntiguedadesInventariosConstantesFunciones.LABEL_IDBODEGA);
			reporte.setsDescripcion(AntiguedadesInventariosConstantesFunciones.LABEL_IDBODEGA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(AntiguedadesInventariosConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(AntiguedadesInventariosConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(AntiguedadesInventariosConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(AntiguedadesInventariosConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(AntiguedadesInventariosConstantesFunciones.LABEL_IDLINEA);
			reporte.setsDescripcion(AntiguedadesInventariosConstantesFunciones.LABEL_IDLINEA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(AntiguedadesInventariosConstantesFunciones.LABEL_IDLINEAGRUPO);
			reporte.setsDescripcion(AntiguedadesInventariosConstantesFunciones.LABEL_IDLINEAGRUPO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(AntiguedadesInventariosConstantesFunciones.LABEL_IDLINEACATEGORIA);
			reporte.setsDescripcion(AntiguedadesInventariosConstantesFunciones.LABEL_IDLINEACATEGORIA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(AntiguedadesInventariosConstantesFunciones.LABEL_IDLINEAMARCA);
			reporte.setsDescripcion(AntiguedadesInventariosConstantesFunciones.LABEL_IDLINEAMARCA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AntiguedadesInventariosConstantesFunciones.LABEL_FECHAULTIMAVENTAHASTA);
			reporte.setsDescripcion(AntiguedadesInventariosConstantesFunciones.LABEL_FECHAULTIMAVENTAHASTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AntiguedadesInventariosConstantesFunciones.LABEL_NOMBRESUCURSAL);
			reporte.setsDescripcion(AntiguedadesInventariosConstantesFunciones.LABEL_NOMBRESUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AntiguedadesInventariosConstantesFunciones.LABEL_NOMBRELINEA);
			reporte.setsDescripcion(AntiguedadesInventariosConstantesFunciones.LABEL_NOMBRELINEA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AntiguedadesInventariosConstantesFunciones.LABEL_NOMBRELINEAGRUPO);
			reporte.setsDescripcion(AntiguedadesInventariosConstantesFunciones.LABEL_NOMBRELINEAGRUPO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AntiguedadesInventariosConstantesFunciones.LABEL_NOMBRELINEACATEGORIA);
			reporte.setsDescripcion(AntiguedadesInventariosConstantesFunciones.LABEL_NOMBRELINEACATEGORIA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AntiguedadesInventariosConstantesFunciones.LABEL_NOMBRELINEAMARCA);
			reporte.setsDescripcion(AntiguedadesInventariosConstantesFunciones.LABEL_NOMBRELINEAMARCA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AntiguedadesInventariosConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(AntiguedadesInventariosConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AntiguedadesInventariosConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(AntiguedadesInventariosConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AntiguedadesInventariosConstantesFunciones.LABEL_NOMBREBODEGA);
			reporte.setsDescripcion(AntiguedadesInventariosConstantesFunciones.LABEL_NOMBREBODEGA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AntiguedadesInventariosConstantesFunciones.LABEL_NOMBREUNIDAD);
			reporte.setsDescripcion(AntiguedadesInventariosConstantesFunciones.LABEL_NOMBREUNIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AntiguedadesInventariosConstantesFunciones.LABEL_CANTIDADDISPONIBLE);
			reporte.setsDescripcion(AntiguedadesInventariosConstantesFunciones.LABEL_CANTIDADDISPONIBLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AntiguedadesInventariosConstantesFunciones.LABEL_FECHAULTIMACOMPRA);
			reporte.setsDescripcion(AntiguedadesInventariosConstantesFunciones.LABEL_FECHAULTIMACOMPRA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(AntiguedadesInventariosConstantesFunciones.LABEL_FECHAULTIMAVENTA);
			reporte.setsDescripcion(AntiguedadesInventariosConstantesFunciones.LABEL_FECHAULTIMAVENTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesAntiguedadesInventarios(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesAntiguedadesInventarios(AntiguedadesInventarios antiguedadesinventariosAux) throws Exception {
		
			antiguedadesinventariosAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(antiguedadesinventariosAux.getBodega()));
			antiguedadesinventariosAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(antiguedadesinventariosAux.getEmpresa()));
			antiguedadesinventariosAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(antiguedadesinventariosAux.getSucursal()));
			antiguedadesinventariosAux.setlinea_descripcion(LineaConstantesFunciones.getLineaDescripcion(antiguedadesinventariosAux.getLinea()));
			antiguedadesinventariosAux.setlineagrupo_descripcion(LineaConstantesFunciones.getLineaDescripcion(antiguedadesinventariosAux.getLineaGrupo()));
			antiguedadesinventariosAux.setlineacategoria_descripcion(LineaConstantesFunciones.getLineaDescripcion(antiguedadesinventariosAux.getLineaCategoria()));
			antiguedadesinventariosAux.setlineamarca_descripcion(LineaConstantesFunciones.getLineaDescripcion(antiguedadesinventariosAux.getLineaMarca()));		
	}
	
	public static void refrescarForeignKeysDescripcionesAntiguedadesInventarios(List<AntiguedadesInventarios> antiguedadesinventariossTemp) throws Exception {
		for(AntiguedadesInventarios antiguedadesinventariosAux:antiguedadesinventariossTemp) {
			
			antiguedadesinventariosAux.setbodega_descripcion(BodegaConstantesFunciones.getBodegaDescripcion(antiguedadesinventariosAux.getBodega()));
			antiguedadesinventariosAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(antiguedadesinventariosAux.getEmpresa()));
			antiguedadesinventariosAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(antiguedadesinventariosAux.getSucursal()));
			antiguedadesinventariosAux.setlinea_descripcion(LineaConstantesFunciones.getLineaDescripcion(antiguedadesinventariosAux.getLinea()));
			antiguedadesinventariosAux.setlineagrupo_descripcion(LineaConstantesFunciones.getLineaDescripcion(antiguedadesinventariosAux.getLineaGrupo()));
			antiguedadesinventariosAux.setlineacategoria_descripcion(LineaConstantesFunciones.getLineaDescripcion(antiguedadesinventariosAux.getLineaCategoria()));
			antiguedadesinventariosAux.setlineamarca_descripcion(LineaConstantesFunciones.getLineaDescripcion(antiguedadesinventariosAux.getLineaMarca()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfAntiguedadesInventarios(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Bodega.class));
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Linea.class));
				classes.add(new Classe(Linea.class));
				classes.add(new Classe(Linea.class));
				classes.add(new Classe(Linea.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Bodega.class)) {
						classes.add(new Classe(Bodega.class));
					}
				}

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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfAntiguedadesInventarios(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Bodega.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Bodega.class)); continue;
					}

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
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

					if(Bodega.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Bodega.class)); continue;
					}

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfAntiguedadesInventarios(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return AntiguedadesInventariosConstantesFunciones.getClassesRelationshipsOfAntiguedadesInventarios(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfAntiguedadesInventarios(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfAntiguedadesInventarios(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return AntiguedadesInventariosConstantesFunciones.getClassesRelationshipsFromStringsOfAntiguedadesInventarios(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfAntiguedadesInventarios(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(AntiguedadesInventarios antiguedadesinventarios,List<AntiguedadesInventarios> antiguedadesinventarioss,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(AntiguedadesInventarios antiguedadesinventarios,List<AntiguedadesInventarios> antiguedadesinventarioss) throws Exception {
		try	{			
			for(AntiguedadesInventarios antiguedadesinventariosLocal:antiguedadesinventarioss) {
				if(antiguedadesinventariosLocal.getId().equals(antiguedadesinventarios.getId())) {
					antiguedadesinventariosLocal.setIsSelected(antiguedadesinventarios.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesAntiguedadesInventarios(List<AntiguedadesInventarios> antiguedadesinventariossAux) throws Exception {
		//this.antiguedadesinventariossAux=antiguedadesinventariossAux;
		
		for(AntiguedadesInventarios antiguedadesinventariosAux:antiguedadesinventariossAux) {
			if(antiguedadesinventariosAux.getIsChanged()) {
				antiguedadesinventariosAux.setIsChanged(false);
			}		
			
			if(antiguedadesinventariosAux.getIsNew()) {
				antiguedadesinventariosAux.setIsNew(false);
			}	
			
			if(antiguedadesinventariosAux.getIsDeleted()) {
				antiguedadesinventariosAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesAntiguedadesInventarios(AntiguedadesInventarios antiguedadesinventariosAux) throws Exception {
		//this.antiguedadesinventariosAux=antiguedadesinventariosAux;
		
			if(antiguedadesinventariosAux.getIsChanged()) {
				antiguedadesinventariosAux.setIsChanged(false);
			}		
			
			if(antiguedadesinventariosAux.getIsNew()) {
				antiguedadesinventariosAux.setIsNew(false);
			}	
			
			if(antiguedadesinventariosAux.getIsDeleted()) {
				antiguedadesinventariosAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(AntiguedadesInventarios antiguedadesinventariosAsignar,AntiguedadesInventarios antiguedadesinventarios) throws Exception {
		antiguedadesinventariosAsignar.setId(antiguedadesinventarios.getId());	
		antiguedadesinventariosAsignar.setVersionRow(antiguedadesinventarios.getVersionRow());	
		antiguedadesinventariosAsignar.setnombre_sucursal(antiguedadesinventarios.getnombre_sucursal());	
		antiguedadesinventariosAsignar.setnombre_linea(antiguedadesinventarios.getnombre_linea());	
		antiguedadesinventariosAsignar.setnombre_linea_grupo(antiguedadesinventarios.getnombre_linea_grupo());	
		antiguedadesinventariosAsignar.setnombre_linea_categoria(antiguedadesinventarios.getnombre_linea_categoria());	
		antiguedadesinventariosAsignar.setnombre_linea_marca(antiguedadesinventarios.getnombre_linea_marca());	
		antiguedadesinventariosAsignar.setcodigo(antiguedadesinventarios.getcodigo());	
		antiguedadesinventariosAsignar.setnombre(antiguedadesinventarios.getnombre());	
		antiguedadesinventariosAsignar.setnombre_bodega(antiguedadesinventarios.getnombre_bodega());	
		antiguedadesinventariosAsignar.setnombre_unidad(antiguedadesinventarios.getnombre_unidad());	
		antiguedadesinventariosAsignar.setcantidad_disponible(antiguedadesinventarios.getcantidad_disponible());	
		antiguedadesinventariosAsignar.setfecha_ultima_compra(antiguedadesinventarios.getfecha_ultima_compra());	
		antiguedadesinventariosAsignar.setfecha_ultima_venta(antiguedadesinventarios.getfecha_ultima_venta());	
	}
	
	public static void inicializarAntiguedadesInventarios(AntiguedadesInventarios antiguedadesinventarios) throws Exception {
		try {
				antiguedadesinventarios.setId(0L);	
					
				antiguedadesinventarios.setnombre_sucursal("");	
				antiguedadesinventarios.setnombre_linea("");	
				antiguedadesinventarios.setnombre_linea_grupo("");	
				antiguedadesinventarios.setnombre_linea_categoria("");	
				antiguedadesinventarios.setnombre_linea_marca("");	
				antiguedadesinventarios.setcodigo("");	
				antiguedadesinventarios.setnombre("");	
				antiguedadesinventarios.setnombre_bodega("");	
				antiguedadesinventarios.setnombre_unidad("");	
				antiguedadesinventarios.setcantidad_disponible(0);	
				antiguedadesinventarios.setfecha_ultima_compra(new Date());	
				antiguedadesinventarios.setfecha_ultima_venta(new Date());	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderAntiguedadesInventarios(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(AntiguedadesInventariosConstantesFunciones.LABEL_IDBODEGA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AntiguedadesInventariosConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AntiguedadesInventariosConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AntiguedadesInventariosConstantesFunciones.LABEL_IDLINEA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AntiguedadesInventariosConstantesFunciones.LABEL_IDLINEAGRUPO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AntiguedadesInventariosConstantesFunciones.LABEL_IDLINEACATEGORIA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AntiguedadesInventariosConstantesFunciones.LABEL_IDLINEAMARCA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AntiguedadesInventariosConstantesFunciones.LABEL_FECHAULTIMAVENTAHASTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AntiguedadesInventariosConstantesFunciones.LABEL_NOMBRESUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AntiguedadesInventariosConstantesFunciones.LABEL_NOMBRELINEA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AntiguedadesInventariosConstantesFunciones.LABEL_NOMBRELINEAGRUPO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AntiguedadesInventariosConstantesFunciones.LABEL_NOMBRELINEACATEGORIA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AntiguedadesInventariosConstantesFunciones.LABEL_NOMBRELINEAMARCA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AntiguedadesInventariosConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AntiguedadesInventariosConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AntiguedadesInventariosConstantesFunciones.LABEL_NOMBREBODEGA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AntiguedadesInventariosConstantesFunciones.LABEL_NOMBREUNIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AntiguedadesInventariosConstantesFunciones.LABEL_CANTIDADDISPONIBLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AntiguedadesInventariosConstantesFunciones.LABEL_FECHAULTIMACOMPRA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(AntiguedadesInventariosConstantesFunciones.LABEL_FECHAULTIMAVENTA);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataAntiguedadesInventarios(String sTipo,Row row,Workbook workbook,AntiguedadesInventarios antiguedadesinventarios,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(antiguedadesinventarios.getbodega_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(antiguedadesinventarios.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(antiguedadesinventarios.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(antiguedadesinventarios.getlinea_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(antiguedadesinventarios.getlineagrupo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(antiguedadesinventarios.getlineacategoria_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(antiguedadesinventarios.getlineamarca_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(antiguedadesinventarios.getfecha_ultima_venta_hasta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(antiguedadesinventarios.getnombre_sucursal());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(antiguedadesinventarios.getnombre_linea());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(antiguedadesinventarios.getnombre_linea_grupo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(antiguedadesinventarios.getnombre_linea_categoria());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(antiguedadesinventarios.getnombre_linea_marca());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(antiguedadesinventarios.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(antiguedadesinventarios.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(antiguedadesinventarios.getnombre_bodega());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(antiguedadesinventarios.getnombre_unidad());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(antiguedadesinventarios.getcantidad_disponible());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(antiguedadesinventarios.getfecha_ultima_compra());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(antiguedadesinventarios.getfecha_ultima_venta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryAntiguedadesInventarios="";
	
	public String getsFinalQueryAntiguedadesInventarios() {
		return this.sFinalQueryAntiguedadesInventarios;
	}
	
	public void setsFinalQueryAntiguedadesInventarios(String sFinalQueryAntiguedadesInventarios) {
		this.sFinalQueryAntiguedadesInventarios= sFinalQueryAntiguedadesInventarios;
	}
	
	public Border resaltarSeleccionarAntiguedadesInventarios=null;
	
	public Border setResaltarSeleccionarAntiguedadesInventarios(ParametroGeneralUsuario parametroGeneralUsuario/*AntiguedadesInventariosBeanSwingJInternalFrame antiguedadesinventariosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//antiguedadesinventariosBeanSwingJInternalFrame.jTtoolBarAntiguedadesInventarios.setBorder(borderResaltar);
		
		this.resaltarSeleccionarAntiguedadesInventarios= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarAntiguedadesInventarios() {
		return this.resaltarSeleccionarAntiguedadesInventarios;
	}
	
	public void setResaltarSeleccionarAntiguedadesInventarios(Border borderResaltarSeleccionarAntiguedadesInventarios) {
		this.resaltarSeleccionarAntiguedadesInventarios= borderResaltarSeleccionarAntiguedadesInventarios;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridAntiguedadesInventarios=null;
	public Boolean mostraridAntiguedadesInventarios=true;
	public Boolean activaridAntiguedadesInventarios=true;

	public Border resaltarid_bodegaAntiguedadesInventarios=null;
	public Boolean mostrarid_bodegaAntiguedadesInventarios=true;
	public Boolean activarid_bodegaAntiguedadesInventarios=true;
	public Boolean cargarid_bodegaAntiguedadesInventarios=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_bodegaAntiguedadesInventarios=false;//ConEventDepend=true

	public Border resaltarid_empresaAntiguedadesInventarios=null;
	public Boolean mostrarid_empresaAntiguedadesInventarios=true;
	public Boolean activarid_empresaAntiguedadesInventarios=true;
	public Boolean cargarid_empresaAntiguedadesInventarios=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaAntiguedadesInventarios=false;//ConEventDepend=true

	public Border resaltarid_sucursalAntiguedadesInventarios=null;
	public Boolean mostrarid_sucursalAntiguedadesInventarios=true;
	public Boolean activarid_sucursalAntiguedadesInventarios=true;
	public Boolean cargarid_sucursalAntiguedadesInventarios=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalAntiguedadesInventarios=false;//ConEventDepend=true

	public Border resaltarid_lineaAntiguedadesInventarios=null;
	public Boolean mostrarid_lineaAntiguedadesInventarios=true;
	public Boolean activarid_lineaAntiguedadesInventarios=true;
	public Boolean cargarid_lineaAntiguedadesInventarios=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_lineaAntiguedadesInventarios=false;//ConEventDepend=true

	public Border resaltarid_linea_grupoAntiguedadesInventarios=null;
	public Boolean mostrarid_linea_grupoAntiguedadesInventarios=true;
	public Boolean activarid_linea_grupoAntiguedadesInventarios=true;
	public Boolean cargarid_linea_grupoAntiguedadesInventarios=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_linea_grupoAntiguedadesInventarios=false;//ConEventDepend=true

	public Border resaltarid_linea_categoriaAntiguedadesInventarios=null;
	public Boolean mostrarid_linea_categoriaAntiguedadesInventarios=true;
	public Boolean activarid_linea_categoriaAntiguedadesInventarios=true;
	public Boolean cargarid_linea_categoriaAntiguedadesInventarios=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_linea_categoriaAntiguedadesInventarios=false;//ConEventDepend=true

	public Border resaltarid_linea_marcaAntiguedadesInventarios=null;
	public Boolean mostrarid_linea_marcaAntiguedadesInventarios=true;
	public Boolean activarid_linea_marcaAntiguedadesInventarios=true;
	public Boolean cargarid_linea_marcaAntiguedadesInventarios=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_linea_marcaAntiguedadesInventarios=false;//ConEventDepend=true

	public Border resaltarfecha_ultima_venta_hastaAntiguedadesInventarios=null;
	public Boolean mostrarfecha_ultima_venta_hastaAntiguedadesInventarios=true;
	public Boolean activarfecha_ultima_venta_hastaAntiguedadesInventarios=true;

	public Border resaltarnombre_sucursalAntiguedadesInventarios=null;
	public Boolean mostrarnombre_sucursalAntiguedadesInventarios=true;
	public Boolean activarnombre_sucursalAntiguedadesInventarios=true;

	public Border resaltarnombre_lineaAntiguedadesInventarios=null;
	public Boolean mostrarnombre_lineaAntiguedadesInventarios=true;
	public Boolean activarnombre_lineaAntiguedadesInventarios=true;

	public Border resaltarnombre_linea_grupoAntiguedadesInventarios=null;
	public Boolean mostrarnombre_linea_grupoAntiguedadesInventarios=true;
	public Boolean activarnombre_linea_grupoAntiguedadesInventarios=true;

	public Border resaltarnombre_linea_categoriaAntiguedadesInventarios=null;
	public Boolean mostrarnombre_linea_categoriaAntiguedadesInventarios=true;
	public Boolean activarnombre_linea_categoriaAntiguedadesInventarios=true;

	public Border resaltarnombre_linea_marcaAntiguedadesInventarios=null;
	public Boolean mostrarnombre_linea_marcaAntiguedadesInventarios=true;
	public Boolean activarnombre_linea_marcaAntiguedadesInventarios=true;

	public Border resaltarcodigoAntiguedadesInventarios=null;
	public Boolean mostrarcodigoAntiguedadesInventarios=true;
	public Boolean activarcodigoAntiguedadesInventarios=true;

	public Border resaltarnombreAntiguedadesInventarios=null;
	public Boolean mostrarnombreAntiguedadesInventarios=true;
	public Boolean activarnombreAntiguedadesInventarios=true;

	public Border resaltarnombre_bodegaAntiguedadesInventarios=null;
	public Boolean mostrarnombre_bodegaAntiguedadesInventarios=true;
	public Boolean activarnombre_bodegaAntiguedadesInventarios=true;

	public Border resaltarnombre_unidadAntiguedadesInventarios=null;
	public Boolean mostrarnombre_unidadAntiguedadesInventarios=true;
	public Boolean activarnombre_unidadAntiguedadesInventarios=true;

	public Border resaltarcantidad_disponibleAntiguedadesInventarios=null;
	public Boolean mostrarcantidad_disponibleAntiguedadesInventarios=true;
	public Boolean activarcantidad_disponibleAntiguedadesInventarios=true;

	public Border resaltarfecha_ultima_compraAntiguedadesInventarios=null;
	public Boolean mostrarfecha_ultima_compraAntiguedadesInventarios=true;
	public Boolean activarfecha_ultima_compraAntiguedadesInventarios=true;

	public Border resaltarfecha_ultima_ventaAntiguedadesInventarios=null;
	public Boolean mostrarfecha_ultima_ventaAntiguedadesInventarios=true;
	public Boolean activarfecha_ultima_ventaAntiguedadesInventarios=true;

	
	

	public Border setResaltaridAntiguedadesInventarios(ParametroGeneralUsuario parametroGeneralUsuario/*AntiguedadesInventariosBeanSwingJInternalFrame antiguedadesinventariosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//antiguedadesinventariosBeanSwingJInternalFrame.jTtoolBarAntiguedadesInventarios.setBorder(borderResaltar);
		
		this.resaltaridAntiguedadesInventarios= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridAntiguedadesInventarios() {
		return this.resaltaridAntiguedadesInventarios;
	}

	public void setResaltaridAntiguedadesInventarios(Border borderResaltar) {
		this.resaltaridAntiguedadesInventarios= borderResaltar;
	}

	public Boolean getMostraridAntiguedadesInventarios() {
		return this.mostraridAntiguedadesInventarios;
	}

	public void setMostraridAntiguedadesInventarios(Boolean mostraridAntiguedadesInventarios) {
		this.mostraridAntiguedadesInventarios= mostraridAntiguedadesInventarios;
	}

	public Boolean getActivaridAntiguedadesInventarios() {
		return this.activaridAntiguedadesInventarios;
	}

	public void setActivaridAntiguedadesInventarios(Boolean activaridAntiguedadesInventarios) {
		this.activaridAntiguedadesInventarios= activaridAntiguedadesInventarios;
	}

	public Border setResaltarid_bodegaAntiguedadesInventarios(ParametroGeneralUsuario parametroGeneralUsuario/*AntiguedadesInventariosBeanSwingJInternalFrame antiguedadesinventariosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//antiguedadesinventariosBeanSwingJInternalFrame.jTtoolBarAntiguedadesInventarios.setBorder(borderResaltar);
		
		this.resaltarid_bodegaAntiguedadesInventarios= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_bodegaAntiguedadesInventarios() {
		return this.resaltarid_bodegaAntiguedadesInventarios;
	}

	public void setResaltarid_bodegaAntiguedadesInventarios(Border borderResaltar) {
		this.resaltarid_bodegaAntiguedadesInventarios= borderResaltar;
	}

	public Boolean getMostrarid_bodegaAntiguedadesInventarios() {
		return this.mostrarid_bodegaAntiguedadesInventarios;
	}

	public void setMostrarid_bodegaAntiguedadesInventarios(Boolean mostrarid_bodegaAntiguedadesInventarios) {
		this.mostrarid_bodegaAntiguedadesInventarios= mostrarid_bodegaAntiguedadesInventarios;
	}

	public Boolean getActivarid_bodegaAntiguedadesInventarios() {
		return this.activarid_bodegaAntiguedadesInventarios;
	}

	public void setActivarid_bodegaAntiguedadesInventarios(Boolean activarid_bodegaAntiguedadesInventarios) {
		this.activarid_bodegaAntiguedadesInventarios= activarid_bodegaAntiguedadesInventarios;
	}

	public Boolean getCargarid_bodegaAntiguedadesInventarios() {
		return this.cargarid_bodegaAntiguedadesInventarios;
	}

	public void setCargarid_bodegaAntiguedadesInventarios(Boolean cargarid_bodegaAntiguedadesInventarios) {
		this.cargarid_bodegaAntiguedadesInventarios= cargarid_bodegaAntiguedadesInventarios;
	}

	public Border setResaltarid_empresaAntiguedadesInventarios(ParametroGeneralUsuario parametroGeneralUsuario/*AntiguedadesInventariosBeanSwingJInternalFrame antiguedadesinventariosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//antiguedadesinventariosBeanSwingJInternalFrame.jTtoolBarAntiguedadesInventarios.setBorder(borderResaltar);
		
		this.resaltarid_empresaAntiguedadesInventarios= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaAntiguedadesInventarios() {
		return this.resaltarid_empresaAntiguedadesInventarios;
	}

	public void setResaltarid_empresaAntiguedadesInventarios(Border borderResaltar) {
		this.resaltarid_empresaAntiguedadesInventarios= borderResaltar;
	}

	public Boolean getMostrarid_empresaAntiguedadesInventarios() {
		return this.mostrarid_empresaAntiguedadesInventarios;
	}

	public void setMostrarid_empresaAntiguedadesInventarios(Boolean mostrarid_empresaAntiguedadesInventarios) {
		this.mostrarid_empresaAntiguedadesInventarios= mostrarid_empresaAntiguedadesInventarios;
	}

	public Boolean getActivarid_empresaAntiguedadesInventarios() {
		return this.activarid_empresaAntiguedadesInventarios;
	}

	public void setActivarid_empresaAntiguedadesInventarios(Boolean activarid_empresaAntiguedadesInventarios) {
		this.activarid_empresaAntiguedadesInventarios= activarid_empresaAntiguedadesInventarios;
	}

	public Boolean getCargarid_empresaAntiguedadesInventarios() {
		return this.cargarid_empresaAntiguedadesInventarios;
	}

	public void setCargarid_empresaAntiguedadesInventarios(Boolean cargarid_empresaAntiguedadesInventarios) {
		this.cargarid_empresaAntiguedadesInventarios= cargarid_empresaAntiguedadesInventarios;
	}

	public Border setResaltarid_sucursalAntiguedadesInventarios(ParametroGeneralUsuario parametroGeneralUsuario/*AntiguedadesInventariosBeanSwingJInternalFrame antiguedadesinventariosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//antiguedadesinventariosBeanSwingJInternalFrame.jTtoolBarAntiguedadesInventarios.setBorder(borderResaltar);
		
		this.resaltarid_sucursalAntiguedadesInventarios= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalAntiguedadesInventarios() {
		return this.resaltarid_sucursalAntiguedadesInventarios;
	}

	public void setResaltarid_sucursalAntiguedadesInventarios(Border borderResaltar) {
		this.resaltarid_sucursalAntiguedadesInventarios= borderResaltar;
	}

	public Boolean getMostrarid_sucursalAntiguedadesInventarios() {
		return this.mostrarid_sucursalAntiguedadesInventarios;
	}

	public void setMostrarid_sucursalAntiguedadesInventarios(Boolean mostrarid_sucursalAntiguedadesInventarios) {
		this.mostrarid_sucursalAntiguedadesInventarios= mostrarid_sucursalAntiguedadesInventarios;
	}

	public Boolean getActivarid_sucursalAntiguedadesInventarios() {
		return this.activarid_sucursalAntiguedadesInventarios;
	}

	public void setActivarid_sucursalAntiguedadesInventarios(Boolean activarid_sucursalAntiguedadesInventarios) {
		this.activarid_sucursalAntiguedadesInventarios= activarid_sucursalAntiguedadesInventarios;
	}

	public Boolean getCargarid_sucursalAntiguedadesInventarios() {
		return this.cargarid_sucursalAntiguedadesInventarios;
	}

	public void setCargarid_sucursalAntiguedadesInventarios(Boolean cargarid_sucursalAntiguedadesInventarios) {
		this.cargarid_sucursalAntiguedadesInventarios= cargarid_sucursalAntiguedadesInventarios;
	}

	public Border setResaltarid_lineaAntiguedadesInventarios(ParametroGeneralUsuario parametroGeneralUsuario/*AntiguedadesInventariosBeanSwingJInternalFrame antiguedadesinventariosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//antiguedadesinventariosBeanSwingJInternalFrame.jTtoolBarAntiguedadesInventarios.setBorder(borderResaltar);
		
		this.resaltarid_lineaAntiguedadesInventarios= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_lineaAntiguedadesInventarios() {
		return this.resaltarid_lineaAntiguedadesInventarios;
	}

	public void setResaltarid_lineaAntiguedadesInventarios(Border borderResaltar) {
		this.resaltarid_lineaAntiguedadesInventarios= borderResaltar;
	}

	public Boolean getMostrarid_lineaAntiguedadesInventarios() {
		return this.mostrarid_lineaAntiguedadesInventarios;
	}

	public void setMostrarid_lineaAntiguedadesInventarios(Boolean mostrarid_lineaAntiguedadesInventarios) {
		this.mostrarid_lineaAntiguedadesInventarios= mostrarid_lineaAntiguedadesInventarios;
	}

	public Boolean getActivarid_lineaAntiguedadesInventarios() {
		return this.activarid_lineaAntiguedadesInventarios;
	}

	public void setActivarid_lineaAntiguedadesInventarios(Boolean activarid_lineaAntiguedadesInventarios) {
		this.activarid_lineaAntiguedadesInventarios= activarid_lineaAntiguedadesInventarios;
	}

	public Boolean getCargarid_lineaAntiguedadesInventarios() {
		return this.cargarid_lineaAntiguedadesInventarios;
	}

	public void setCargarid_lineaAntiguedadesInventarios(Boolean cargarid_lineaAntiguedadesInventarios) {
		this.cargarid_lineaAntiguedadesInventarios= cargarid_lineaAntiguedadesInventarios;
	}

	public Border setResaltarid_linea_grupoAntiguedadesInventarios(ParametroGeneralUsuario parametroGeneralUsuario/*AntiguedadesInventariosBeanSwingJInternalFrame antiguedadesinventariosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//antiguedadesinventariosBeanSwingJInternalFrame.jTtoolBarAntiguedadesInventarios.setBorder(borderResaltar);
		
		this.resaltarid_linea_grupoAntiguedadesInventarios= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_linea_grupoAntiguedadesInventarios() {
		return this.resaltarid_linea_grupoAntiguedadesInventarios;
	}

	public void setResaltarid_linea_grupoAntiguedadesInventarios(Border borderResaltar) {
		this.resaltarid_linea_grupoAntiguedadesInventarios= borderResaltar;
	}

	public Boolean getMostrarid_linea_grupoAntiguedadesInventarios() {
		return this.mostrarid_linea_grupoAntiguedadesInventarios;
	}

	public void setMostrarid_linea_grupoAntiguedadesInventarios(Boolean mostrarid_linea_grupoAntiguedadesInventarios) {
		this.mostrarid_linea_grupoAntiguedadesInventarios= mostrarid_linea_grupoAntiguedadesInventarios;
	}

	public Boolean getActivarid_linea_grupoAntiguedadesInventarios() {
		return this.activarid_linea_grupoAntiguedadesInventarios;
	}

	public void setActivarid_linea_grupoAntiguedadesInventarios(Boolean activarid_linea_grupoAntiguedadesInventarios) {
		this.activarid_linea_grupoAntiguedadesInventarios= activarid_linea_grupoAntiguedadesInventarios;
	}

	public Boolean getCargarid_linea_grupoAntiguedadesInventarios() {
		return this.cargarid_linea_grupoAntiguedadesInventarios;
	}

	public void setCargarid_linea_grupoAntiguedadesInventarios(Boolean cargarid_linea_grupoAntiguedadesInventarios) {
		this.cargarid_linea_grupoAntiguedadesInventarios= cargarid_linea_grupoAntiguedadesInventarios;
	}

	public Border setResaltarid_linea_categoriaAntiguedadesInventarios(ParametroGeneralUsuario parametroGeneralUsuario/*AntiguedadesInventariosBeanSwingJInternalFrame antiguedadesinventariosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//antiguedadesinventariosBeanSwingJInternalFrame.jTtoolBarAntiguedadesInventarios.setBorder(borderResaltar);
		
		this.resaltarid_linea_categoriaAntiguedadesInventarios= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_linea_categoriaAntiguedadesInventarios() {
		return this.resaltarid_linea_categoriaAntiguedadesInventarios;
	}

	public void setResaltarid_linea_categoriaAntiguedadesInventarios(Border borderResaltar) {
		this.resaltarid_linea_categoriaAntiguedadesInventarios= borderResaltar;
	}

	public Boolean getMostrarid_linea_categoriaAntiguedadesInventarios() {
		return this.mostrarid_linea_categoriaAntiguedadesInventarios;
	}

	public void setMostrarid_linea_categoriaAntiguedadesInventarios(Boolean mostrarid_linea_categoriaAntiguedadesInventarios) {
		this.mostrarid_linea_categoriaAntiguedadesInventarios= mostrarid_linea_categoriaAntiguedadesInventarios;
	}

	public Boolean getActivarid_linea_categoriaAntiguedadesInventarios() {
		return this.activarid_linea_categoriaAntiguedadesInventarios;
	}

	public void setActivarid_linea_categoriaAntiguedadesInventarios(Boolean activarid_linea_categoriaAntiguedadesInventarios) {
		this.activarid_linea_categoriaAntiguedadesInventarios= activarid_linea_categoriaAntiguedadesInventarios;
	}

	public Boolean getCargarid_linea_categoriaAntiguedadesInventarios() {
		return this.cargarid_linea_categoriaAntiguedadesInventarios;
	}

	public void setCargarid_linea_categoriaAntiguedadesInventarios(Boolean cargarid_linea_categoriaAntiguedadesInventarios) {
		this.cargarid_linea_categoriaAntiguedadesInventarios= cargarid_linea_categoriaAntiguedadesInventarios;
	}

	public Border setResaltarid_linea_marcaAntiguedadesInventarios(ParametroGeneralUsuario parametroGeneralUsuario/*AntiguedadesInventariosBeanSwingJInternalFrame antiguedadesinventariosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//antiguedadesinventariosBeanSwingJInternalFrame.jTtoolBarAntiguedadesInventarios.setBorder(borderResaltar);
		
		this.resaltarid_linea_marcaAntiguedadesInventarios= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_linea_marcaAntiguedadesInventarios() {
		return this.resaltarid_linea_marcaAntiguedadesInventarios;
	}

	public void setResaltarid_linea_marcaAntiguedadesInventarios(Border borderResaltar) {
		this.resaltarid_linea_marcaAntiguedadesInventarios= borderResaltar;
	}

	public Boolean getMostrarid_linea_marcaAntiguedadesInventarios() {
		return this.mostrarid_linea_marcaAntiguedadesInventarios;
	}

	public void setMostrarid_linea_marcaAntiguedadesInventarios(Boolean mostrarid_linea_marcaAntiguedadesInventarios) {
		this.mostrarid_linea_marcaAntiguedadesInventarios= mostrarid_linea_marcaAntiguedadesInventarios;
	}

	public Boolean getActivarid_linea_marcaAntiguedadesInventarios() {
		return this.activarid_linea_marcaAntiguedadesInventarios;
	}

	public void setActivarid_linea_marcaAntiguedadesInventarios(Boolean activarid_linea_marcaAntiguedadesInventarios) {
		this.activarid_linea_marcaAntiguedadesInventarios= activarid_linea_marcaAntiguedadesInventarios;
	}

	public Boolean getCargarid_linea_marcaAntiguedadesInventarios() {
		return this.cargarid_linea_marcaAntiguedadesInventarios;
	}

	public void setCargarid_linea_marcaAntiguedadesInventarios(Boolean cargarid_linea_marcaAntiguedadesInventarios) {
		this.cargarid_linea_marcaAntiguedadesInventarios= cargarid_linea_marcaAntiguedadesInventarios;
	}

	public Border setResaltarfecha_ultima_venta_hastaAntiguedadesInventarios(ParametroGeneralUsuario parametroGeneralUsuario/*AntiguedadesInventariosBeanSwingJInternalFrame antiguedadesinventariosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//antiguedadesinventariosBeanSwingJInternalFrame.jTtoolBarAntiguedadesInventarios.setBorder(borderResaltar);
		
		this.resaltarfecha_ultima_venta_hastaAntiguedadesInventarios= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_ultima_venta_hastaAntiguedadesInventarios() {
		return this.resaltarfecha_ultima_venta_hastaAntiguedadesInventarios;
	}

	public void setResaltarfecha_ultima_venta_hastaAntiguedadesInventarios(Border borderResaltar) {
		this.resaltarfecha_ultima_venta_hastaAntiguedadesInventarios= borderResaltar;
	}

	public Boolean getMostrarfecha_ultima_venta_hastaAntiguedadesInventarios() {
		return this.mostrarfecha_ultima_venta_hastaAntiguedadesInventarios;
	}

	public void setMostrarfecha_ultima_venta_hastaAntiguedadesInventarios(Boolean mostrarfecha_ultima_venta_hastaAntiguedadesInventarios) {
		this.mostrarfecha_ultima_venta_hastaAntiguedadesInventarios= mostrarfecha_ultima_venta_hastaAntiguedadesInventarios;
	}

	public Boolean getActivarfecha_ultima_venta_hastaAntiguedadesInventarios() {
		return this.activarfecha_ultima_venta_hastaAntiguedadesInventarios;
	}

	public void setActivarfecha_ultima_venta_hastaAntiguedadesInventarios(Boolean activarfecha_ultima_venta_hastaAntiguedadesInventarios) {
		this.activarfecha_ultima_venta_hastaAntiguedadesInventarios= activarfecha_ultima_venta_hastaAntiguedadesInventarios;
	}

	public Border setResaltarnombre_sucursalAntiguedadesInventarios(ParametroGeneralUsuario parametroGeneralUsuario/*AntiguedadesInventariosBeanSwingJInternalFrame antiguedadesinventariosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//antiguedadesinventariosBeanSwingJInternalFrame.jTtoolBarAntiguedadesInventarios.setBorder(borderResaltar);
		
		this.resaltarnombre_sucursalAntiguedadesInventarios= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_sucursalAntiguedadesInventarios() {
		return this.resaltarnombre_sucursalAntiguedadesInventarios;
	}

	public void setResaltarnombre_sucursalAntiguedadesInventarios(Border borderResaltar) {
		this.resaltarnombre_sucursalAntiguedadesInventarios= borderResaltar;
	}

	public Boolean getMostrarnombre_sucursalAntiguedadesInventarios() {
		return this.mostrarnombre_sucursalAntiguedadesInventarios;
	}

	public void setMostrarnombre_sucursalAntiguedadesInventarios(Boolean mostrarnombre_sucursalAntiguedadesInventarios) {
		this.mostrarnombre_sucursalAntiguedadesInventarios= mostrarnombre_sucursalAntiguedadesInventarios;
	}

	public Boolean getActivarnombre_sucursalAntiguedadesInventarios() {
		return this.activarnombre_sucursalAntiguedadesInventarios;
	}

	public void setActivarnombre_sucursalAntiguedadesInventarios(Boolean activarnombre_sucursalAntiguedadesInventarios) {
		this.activarnombre_sucursalAntiguedadesInventarios= activarnombre_sucursalAntiguedadesInventarios;
	}

	public Border setResaltarnombre_lineaAntiguedadesInventarios(ParametroGeneralUsuario parametroGeneralUsuario/*AntiguedadesInventariosBeanSwingJInternalFrame antiguedadesinventariosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//antiguedadesinventariosBeanSwingJInternalFrame.jTtoolBarAntiguedadesInventarios.setBorder(borderResaltar);
		
		this.resaltarnombre_lineaAntiguedadesInventarios= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_lineaAntiguedadesInventarios() {
		return this.resaltarnombre_lineaAntiguedadesInventarios;
	}

	public void setResaltarnombre_lineaAntiguedadesInventarios(Border borderResaltar) {
		this.resaltarnombre_lineaAntiguedadesInventarios= borderResaltar;
	}

	public Boolean getMostrarnombre_lineaAntiguedadesInventarios() {
		return this.mostrarnombre_lineaAntiguedadesInventarios;
	}

	public void setMostrarnombre_lineaAntiguedadesInventarios(Boolean mostrarnombre_lineaAntiguedadesInventarios) {
		this.mostrarnombre_lineaAntiguedadesInventarios= mostrarnombre_lineaAntiguedadesInventarios;
	}

	public Boolean getActivarnombre_lineaAntiguedadesInventarios() {
		return this.activarnombre_lineaAntiguedadesInventarios;
	}

	public void setActivarnombre_lineaAntiguedadesInventarios(Boolean activarnombre_lineaAntiguedadesInventarios) {
		this.activarnombre_lineaAntiguedadesInventarios= activarnombre_lineaAntiguedadesInventarios;
	}

	public Border setResaltarnombre_linea_grupoAntiguedadesInventarios(ParametroGeneralUsuario parametroGeneralUsuario/*AntiguedadesInventariosBeanSwingJInternalFrame antiguedadesinventariosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//antiguedadesinventariosBeanSwingJInternalFrame.jTtoolBarAntiguedadesInventarios.setBorder(borderResaltar);
		
		this.resaltarnombre_linea_grupoAntiguedadesInventarios= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_linea_grupoAntiguedadesInventarios() {
		return this.resaltarnombre_linea_grupoAntiguedadesInventarios;
	}

	public void setResaltarnombre_linea_grupoAntiguedadesInventarios(Border borderResaltar) {
		this.resaltarnombre_linea_grupoAntiguedadesInventarios= borderResaltar;
	}

	public Boolean getMostrarnombre_linea_grupoAntiguedadesInventarios() {
		return this.mostrarnombre_linea_grupoAntiguedadesInventarios;
	}

	public void setMostrarnombre_linea_grupoAntiguedadesInventarios(Boolean mostrarnombre_linea_grupoAntiguedadesInventarios) {
		this.mostrarnombre_linea_grupoAntiguedadesInventarios= mostrarnombre_linea_grupoAntiguedadesInventarios;
	}

	public Boolean getActivarnombre_linea_grupoAntiguedadesInventarios() {
		return this.activarnombre_linea_grupoAntiguedadesInventarios;
	}

	public void setActivarnombre_linea_grupoAntiguedadesInventarios(Boolean activarnombre_linea_grupoAntiguedadesInventarios) {
		this.activarnombre_linea_grupoAntiguedadesInventarios= activarnombre_linea_grupoAntiguedadesInventarios;
	}

	public Border setResaltarnombre_linea_categoriaAntiguedadesInventarios(ParametroGeneralUsuario parametroGeneralUsuario/*AntiguedadesInventariosBeanSwingJInternalFrame antiguedadesinventariosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//antiguedadesinventariosBeanSwingJInternalFrame.jTtoolBarAntiguedadesInventarios.setBorder(borderResaltar);
		
		this.resaltarnombre_linea_categoriaAntiguedadesInventarios= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_linea_categoriaAntiguedadesInventarios() {
		return this.resaltarnombre_linea_categoriaAntiguedadesInventarios;
	}

	public void setResaltarnombre_linea_categoriaAntiguedadesInventarios(Border borderResaltar) {
		this.resaltarnombre_linea_categoriaAntiguedadesInventarios= borderResaltar;
	}

	public Boolean getMostrarnombre_linea_categoriaAntiguedadesInventarios() {
		return this.mostrarnombre_linea_categoriaAntiguedadesInventarios;
	}

	public void setMostrarnombre_linea_categoriaAntiguedadesInventarios(Boolean mostrarnombre_linea_categoriaAntiguedadesInventarios) {
		this.mostrarnombre_linea_categoriaAntiguedadesInventarios= mostrarnombre_linea_categoriaAntiguedadesInventarios;
	}

	public Boolean getActivarnombre_linea_categoriaAntiguedadesInventarios() {
		return this.activarnombre_linea_categoriaAntiguedadesInventarios;
	}

	public void setActivarnombre_linea_categoriaAntiguedadesInventarios(Boolean activarnombre_linea_categoriaAntiguedadesInventarios) {
		this.activarnombre_linea_categoriaAntiguedadesInventarios= activarnombre_linea_categoriaAntiguedadesInventarios;
	}

	public Border setResaltarnombre_linea_marcaAntiguedadesInventarios(ParametroGeneralUsuario parametroGeneralUsuario/*AntiguedadesInventariosBeanSwingJInternalFrame antiguedadesinventariosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//antiguedadesinventariosBeanSwingJInternalFrame.jTtoolBarAntiguedadesInventarios.setBorder(borderResaltar);
		
		this.resaltarnombre_linea_marcaAntiguedadesInventarios= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_linea_marcaAntiguedadesInventarios() {
		return this.resaltarnombre_linea_marcaAntiguedadesInventarios;
	}

	public void setResaltarnombre_linea_marcaAntiguedadesInventarios(Border borderResaltar) {
		this.resaltarnombre_linea_marcaAntiguedadesInventarios= borderResaltar;
	}

	public Boolean getMostrarnombre_linea_marcaAntiguedadesInventarios() {
		return this.mostrarnombre_linea_marcaAntiguedadesInventarios;
	}

	public void setMostrarnombre_linea_marcaAntiguedadesInventarios(Boolean mostrarnombre_linea_marcaAntiguedadesInventarios) {
		this.mostrarnombre_linea_marcaAntiguedadesInventarios= mostrarnombre_linea_marcaAntiguedadesInventarios;
	}

	public Boolean getActivarnombre_linea_marcaAntiguedadesInventarios() {
		return this.activarnombre_linea_marcaAntiguedadesInventarios;
	}

	public void setActivarnombre_linea_marcaAntiguedadesInventarios(Boolean activarnombre_linea_marcaAntiguedadesInventarios) {
		this.activarnombre_linea_marcaAntiguedadesInventarios= activarnombre_linea_marcaAntiguedadesInventarios;
	}

	public Border setResaltarcodigoAntiguedadesInventarios(ParametroGeneralUsuario parametroGeneralUsuario/*AntiguedadesInventariosBeanSwingJInternalFrame antiguedadesinventariosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//antiguedadesinventariosBeanSwingJInternalFrame.jTtoolBarAntiguedadesInventarios.setBorder(borderResaltar);
		
		this.resaltarcodigoAntiguedadesInventarios= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoAntiguedadesInventarios() {
		return this.resaltarcodigoAntiguedadesInventarios;
	}

	public void setResaltarcodigoAntiguedadesInventarios(Border borderResaltar) {
		this.resaltarcodigoAntiguedadesInventarios= borderResaltar;
	}

	public Boolean getMostrarcodigoAntiguedadesInventarios() {
		return this.mostrarcodigoAntiguedadesInventarios;
	}

	public void setMostrarcodigoAntiguedadesInventarios(Boolean mostrarcodigoAntiguedadesInventarios) {
		this.mostrarcodigoAntiguedadesInventarios= mostrarcodigoAntiguedadesInventarios;
	}

	public Boolean getActivarcodigoAntiguedadesInventarios() {
		return this.activarcodigoAntiguedadesInventarios;
	}

	public void setActivarcodigoAntiguedadesInventarios(Boolean activarcodigoAntiguedadesInventarios) {
		this.activarcodigoAntiguedadesInventarios= activarcodigoAntiguedadesInventarios;
	}

	public Border setResaltarnombreAntiguedadesInventarios(ParametroGeneralUsuario parametroGeneralUsuario/*AntiguedadesInventariosBeanSwingJInternalFrame antiguedadesinventariosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//antiguedadesinventariosBeanSwingJInternalFrame.jTtoolBarAntiguedadesInventarios.setBorder(borderResaltar);
		
		this.resaltarnombreAntiguedadesInventarios= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreAntiguedadesInventarios() {
		return this.resaltarnombreAntiguedadesInventarios;
	}

	public void setResaltarnombreAntiguedadesInventarios(Border borderResaltar) {
		this.resaltarnombreAntiguedadesInventarios= borderResaltar;
	}

	public Boolean getMostrarnombreAntiguedadesInventarios() {
		return this.mostrarnombreAntiguedadesInventarios;
	}

	public void setMostrarnombreAntiguedadesInventarios(Boolean mostrarnombreAntiguedadesInventarios) {
		this.mostrarnombreAntiguedadesInventarios= mostrarnombreAntiguedadesInventarios;
	}

	public Boolean getActivarnombreAntiguedadesInventarios() {
		return this.activarnombreAntiguedadesInventarios;
	}

	public void setActivarnombreAntiguedadesInventarios(Boolean activarnombreAntiguedadesInventarios) {
		this.activarnombreAntiguedadesInventarios= activarnombreAntiguedadesInventarios;
	}

	public Border setResaltarnombre_bodegaAntiguedadesInventarios(ParametroGeneralUsuario parametroGeneralUsuario/*AntiguedadesInventariosBeanSwingJInternalFrame antiguedadesinventariosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//antiguedadesinventariosBeanSwingJInternalFrame.jTtoolBarAntiguedadesInventarios.setBorder(borderResaltar);
		
		this.resaltarnombre_bodegaAntiguedadesInventarios= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_bodegaAntiguedadesInventarios() {
		return this.resaltarnombre_bodegaAntiguedadesInventarios;
	}

	public void setResaltarnombre_bodegaAntiguedadesInventarios(Border borderResaltar) {
		this.resaltarnombre_bodegaAntiguedadesInventarios= borderResaltar;
	}

	public Boolean getMostrarnombre_bodegaAntiguedadesInventarios() {
		return this.mostrarnombre_bodegaAntiguedadesInventarios;
	}

	public void setMostrarnombre_bodegaAntiguedadesInventarios(Boolean mostrarnombre_bodegaAntiguedadesInventarios) {
		this.mostrarnombre_bodegaAntiguedadesInventarios= mostrarnombre_bodegaAntiguedadesInventarios;
	}

	public Boolean getActivarnombre_bodegaAntiguedadesInventarios() {
		return this.activarnombre_bodegaAntiguedadesInventarios;
	}

	public void setActivarnombre_bodegaAntiguedadesInventarios(Boolean activarnombre_bodegaAntiguedadesInventarios) {
		this.activarnombre_bodegaAntiguedadesInventarios= activarnombre_bodegaAntiguedadesInventarios;
	}

	public Border setResaltarnombre_unidadAntiguedadesInventarios(ParametroGeneralUsuario parametroGeneralUsuario/*AntiguedadesInventariosBeanSwingJInternalFrame antiguedadesinventariosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//antiguedadesinventariosBeanSwingJInternalFrame.jTtoolBarAntiguedadesInventarios.setBorder(borderResaltar);
		
		this.resaltarnombre_unidadAntiguedadesInventarios= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_unidadAntiguedadesInventarios() {
		return this.resaltarnombre_unidadAntiguedadesInventarios;
	}

	public void setResaltarnombre_unidadAntiguedadesInventarios(Border borderResaltar) {
		this.resaltarnombre_unidadAntiguedadesInventarios= borderResaltar;
	}

	public Boolean getMostrarnombre_unidadAntiguedadesInventarios() {
		return this.mostrarnombre_unidadAntiguedadesInventarios;
	}

	public void setMostrarnombre_unidadAntiguedadesInventarios(Boolean mostrarnombre_unidadAntiguedadesInventarios) {
		this.mostrarnombre_unidadAntiguedadesInventarios= mostrarnombre_unidadAntiguedadesInventarios;
	}

	public Boolean getActivarnombre_unidadAntiguedadesInventarios() {
		return this.activarnombre_unidadAntiguedadesInventarios;
	}

	public void setActivarnombre_unidadAntiguedadesInventarios(Boolean activarnombre_unidadAntiguedadesInventarios) {
		this.activarnombre_unidadAntiguedadesInventarios= activarnombre_unidadAntiguedadesInventarios;
	}

	public Border setResaltarcantidad_disponibleAntiguedadesInventarios(ParametroGeneralUsuario parametroGeneralUsuario/*AntiguedadesInventariosBeanSwingJInternalFrame antiguedadesinventariosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//antiguedadesinventariosBeanSwingJInternalFrame.jTtoolBarAntiguedadesInventarios.setBorder(borderResaltar);
		
		this.resaltarcantidad_disponibleAntiguedadesInventarios= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcantidad_disponibleAntiguedadesInventarios() {
		return this.resaltarcantidad_disponibleAntiguedadesInventarios;
	}

	public void setResaltarcantidad_disponibleAntiguedadesInventarios(Border borderResaltar) {
		this.resaltarcantidad_disponibleAntiguedadesInventarios= borderResaltar;
	}

	public Boolean getMostrarcantidad_disponibleAntiguedadesInventarios() {
		return this.mostrarcantidad_disponibleAntiguedadesInventarios;
	}

	public void setMostrarcantidad_disponibleAntiguedadesInventarios(Boolean mostrarcantidad_disponibleAntiguedadesInventarios) {
		this.mostrarcantidad_disponibleAntiguedadesInventarios= mostrarcantidad_disponibleAntiguedadesInventarios;
	}

	public Boolean getActivarcantidad_disponibleAntiguedadesInventarios() {
		return this.activarcantidad_disponibleAntiguedadesInventarios;
	}

	public void setActivarcantidad_disponibleAntiguedadesInventarios(Boolean activarcantidad_disponibleAntiguedadesInventarios) {
		this.activarcantidad_disponibleAntiguedadesInventarios= activarcantidad_disponibleAntiguedadesInventarios;
	}

	public Border setResaltarfecha_ultima_compraAntiguedadesInventarios(ParametroGeneralUsuario parametroGeneralUsuario/*AntiguedadesInventariosBeanSwingJInternalFrame antiguedadesinventariosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//antiguedadesinventariosBeanSwingJInternalFrame.jTtoolBarAntiguedadesInventarios.setBorder(borderResaltar);
		
		this.resaltarfecha_ultima_compraAntiguedadesInventarios= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_ultima_compraAntiguedadesInventarios() {
		return this.resaltarfecha_ultima_compraAntiguedadesInventarios;
	}

	public void setResaltarfecha_ultima_compraAntiguedadesInventarios(Border borderResaltar) {
		this.resaltarfecha_ultima_compraAntiguedadesInventarios= borderResaltar;
	}

	public Boolean getMostrarfecha_ultima_compraAntiguedadesInventarios() {
		return this.mostrarfecha_ultima_compraAntiguedadesInventarios;
	}

	public void setMostrarfecha_ultima_compraAntiguedadesInventarios(Boolean mostrarfecha_ultima_compraAntiguedadesInventarios) {
		this.mostrarfecha_ultima_compraAntiguedadesInventarios= mostrarfecha_ultima_compraAntiguedadesInventarios;
	}

	public Boolean getActivarfecha_ultima_compraAntiguedadesInventarios() {
		return this.activarfecha_ultima_compraAntiguedadesInventarios;
	}

	public void setActivarfecha_ultima_compraAntiguedadesInventarios(Boolean activarfecha_ultima_compraAntiguedadesInventarios) {
		this.activarfecha_ultima_compraAntiguedadesInventarios= activarfecha_ultima_compraAntiguedadesInventarios;
	}

	public Border setResaltarfecha_ultima_ventaAntiguedadesInventarios(ParametroGeneralUsuario parametroGeneralUsuario/*AntiguedadesInventariosBeanSwingJInternalFrame antiguedadesinventariosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//antiguedadesinventariosBeanSwingJInternalFrame.jTtoolBarAntiguedadesInventarios.setBorder(borderResaltar);
		
		this.resaltarfecha_ultima_ventaAntiguedadesInventarios= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_ultima_ventaAntiguedadesInventarios() {
		return this.resaltarfecha_ultima_ventaAntiguedadesInventarios;
	}

	public void setResaltarfecha_ultima_ventaAntiguedadesInventarios(Border borderResaltar) {
		this.resaltarfecha_ultima_ventaAntiguedadesInventarios= borderResaltar;
	}

	public Boolean getMostrarfecha_ultima_ventaAntiguedadesInventarios() {
		return this.mostrarfecha_ultima_ventaAntiguedadesInventarios;
	}

	public void setMostrarfecha_ultima_ventaAntiguedadesInventarios(Boolean mostrarfecha_ultima_ventaAntiguedadesInventarios) {
		this.mostrarfecha_ultima_ventaAntiguedadesInventarios= mostrarfecha_ultima_ventaAntiguedadesInventarios;
	}

	public Boolean getActivarfecha_ultima_ventaAntiguedadesInventarios() {
		return this.activarfecha_ultima_ventaAntiguedadesInventarios;
	}

	public void setActivarfecha_ultima_ventaAntiguedadesInventarios(Boolean activarfecha_ultima_ventaAntiguedadesInventarios) {
		this.activarfecha_ultima_ventaAntiguedadesInventarios= activarfecha_ultima_ventaAntiguedadesInventarios;
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
		
		
		this.setMostraridAntiguedadesInventarios(esInicial);
		this.setMostrarid_bodegaAntiguedadesInventarios(esInicial);
		this.setMostrarid_empresaAntiguedadesInventarios(esInicial);
		this.setMostrarid_sucursalAntiguedadesInventarios(esInicial);
		this.setMostrarid_lineaAntiguedadesInventarios(esInicial);
		this.setMostrarid_linea_grupoAntiguedadesInventarios(esInicial);
		this.setMostrarid_linea_categoriaAntiguedadesInventarios(esInicial);
		this.setMostrarid_linea_marcaAntiguedadesInventarios(esInicial);
		this.setMostrarfecha_ultima_venta_hastaAntiguedadesInventarios(esInicial);
		this.setMostrarnombre_sucursalAntiguedadesInventarios(esInicial);
		this.setMostrarnombre_lineaAntiguedadesInventarios(esInicial);
		this.setMostrarnombre_linea_grupoAntiguedadesInventarios(esInicial);
		this.setMostrarnombre_linea_categoriaAntiguedadesInventarios(esInicial);
		this.setMostrarnombre_linea_marcaAntiguedadesInventarios(esInicial);
		this.setMostrarcodigoAntiguedadesInventarios(esInicial);
		this.setMostrarnombreAntiguedadesInventarios(esInicial);
		this.setMostrarnombre_bodegaAntiguedadesInventarios(esInicial);
		this.setMostrarnombre_unidadAntiguedadesInventarios(esInicial);
		this.setMostrarcantidad_disponibleAntiguedadesInventarios(esInicial);
		this.setMostrarfecha_ultima_compraAntiguedadesInventarios(esInicial);
		this.setMostrarfecha_ultima_ventaAntiguedadesInventarios(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(AntiguedadesInventariosConstantesFunciones.ID)) {
				this.setMostraridAntiguedadesInventarios(esAsigna);
				continue;
			}

			if(campo.clase.equals(AntiguedadesInventariosConstantesFunciones.IDBODEGA)) {
				this.setMostrarid_bodegaAntiguedadesInventarios(esAsigna);
				continue;
			}

			if(campo.clase.equals(AntiguedadesInventariosConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaAntiguedadesInventarios(esAsigna);
				continue;
			}

			if(campo.clase.equals(AntiguedadesInventariosConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalAntiguedadesInventarios(esAsigna);
				continue;
			}

			if(campo.clase.equals(AntiguedadesInventariosConstantesFunciones.IDLINEA)) {
				this.setMostrarid_lineaAntiguedadesInventarios(esAsigna);
				continue;
			}

			if(campo.clase.equals(AntiguedadesInventariosConstantesFunciones.IDLINEAGRUPO)) {
				this.setMostrarid_linea_grupoAntiguedadesInventarios(esAsigna);
				continue;
			}

			if(campo.clase.equals(AntiguedadesInventariosConstantesFunciones.IDLINEACATEGORIA)) {
				this.setMostrarid_linea_categoriaAntiguedadesInventarios(esAsigna);
				continue;
			}

			if(campo.clase.equals(AntiguedadesInventariosConstantesFunciones.IDLINEAMARCA)) {
				this.setMostrarid_linea_marcaAntiguedadesInventarios(esAsigna);
				continue;
			}

			if(campo.clase.equals(AntiguedadesInventariosConstantesFunciones.FECHAULTIMAVENTAHASTA)) {
				this.setMostrarfecha_ultima_venta_hastaAntiguedadesInventarios(esAsigna);
				continue;
			}

			if(campo.clase.equals(AntiguedadesInventariosConstantesFunciones.NOMBRESUCURSAL)) {
				this.setMostrarnombre_sucursalAntiguedadesInventarios(esAsigna);
				continue;
			}

			if(campo.clase.equals(AntiguedadesInventariosConstantesFunciones.NOMBRELINEA)) {
				this.setMostrarnombre_lineaAntiguedadesInventarios(esAsigna);
				continue;
			}

			if(campo.clase.equals(AntiguedadesInventariosConstantesFunciones.NOMBRELINEAGRUPO)) {
				this.setMostrarnombre_linea_grupoAntiguedadesInventarios(esAsigna);
				continue;
			}

			if(campo.clase.equals(AntiguedadesInventariosConstantesFunciones.NOMBRELINEACATEGORIA)) {
				this.setMostrarnombre_linea_categoriaAntiguedadesInventarios(esAsigna);
				continue;
			}

			if(campo.clase.equals(AntiguedadesInventariosConstantesFunciones.NOMBRELINEAMARCA)) {
				this.setMostrarnombre_linea_marcaAntiguedadesInventarios(esAsigna);
				continue;
			}

			if(campo.clase.equals(AntiguedadesInventariosConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoAntiguedadesInventarios(esAsigna);
				continue;
			}

			if(campo.clase.equals(AntiguedadesInventariosConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreAntiguedadesInventarios(esAsigna);
				continue;
			}

			if(campo.clase.equals(AntiguedadesInventariosConstantesFunciones.NOMBREBODEGA)) {
				this.setMostrarnombre_bodegaAntiguedadesInventarios(esAsigna);
				continue;
			}

			if(campo.clase.equals(AntiguedadesInventariosConstantesFunciones.NOMBREUNIDAD)) {
				this.setMostrarnombre_unidadAntiguedadesInventarios(esAsigna);
				continue;
			}

			if(campo.clase.equals(AntiguedadesInventariosConstantesFunciones.CANTIDADDISPONIBLE)) {
				this.setMostrarcantidad_disponibleAntiguedadesInventarios(esAsigna);
				continue;
			}

			if(campo.clase.equals(AntiguedadesInventariosConstantesFunciones.FECHAULTIMACOMPRA)) {
				this.setMostrarfecha_ultima_compraAntiguedadesInventarios(esAsigna);
				continue;
			}

			if(campo.clase.equals(AntiguedadesInventariosConstantesFunciones.FECHAULTIMAVENTA)) {
				this.setMostrarfecha_ultima_ventaAntiguedadesInventarios(esAsigna);
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
		
		
		this.setActivaridAntiguedadesInventarios(esInicial);
		this.setActivarid_bodegaAntiguedadesInventarios(esInicial);
		this.setActivarid_empresaAntiguedadesInventarios(esInicial);
		this.setActivarid_sucursalAntiguedadesInventarios(esInicial);
		this.setActivarid_lineaAntiguedadesInventarios(esInicial);
		this.setActivarid_linea_grupoAntiguedadesInventarios(esInicial);
		this.setActivarid_linea_categoriaAntiguedadesInventarios(esInicial);
		this.setActivarid_linea_marcaAntiguedadesInventarios(esInicial);
		this.setActivarfecha_ultima_venta_hastaAntiguedadesInventarios(esInicial);
		this.setActivarnombre_sucursalAntiguedadesInventarios(esInicial);
		this.setActivarnombre_lineaAntiguedadesInventarios(esInicial);
		this.setActivarnombre_linea_grupoAntiguedadesInventarios(esInicial);
		this.setActivarnombre_linea_categoriaAntiguedadesInventarios(esInicial);
		this.setActivarnombre_linea_marcaAntiguedadesInventarios(esInicial);
		this.setActivarcodigoAntiguedadesInventarios(esInicial);
		this.setActivarnombreAntiguedadesInventarios(esInicial);
		this.setActivarnombre_bodegaAntiguedadesInventarios(esInicial);
		this.setActivarnombre_unidadAntiguedadesInventarios(esInicial);
		this.setActivarcantidad_disponibleAntiguedadesInventarios(esInicial);
		this.setActivarfecha_ultima_compraAntiguedadesInventarios(esInicial);
		this.setActivarfecha_ultima_ventaAntiguedadesInventarios(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(AntiguedadesInventariosConstantesFunciones.ID)) {
				this.setActivaridAntiguedadesInventarios(esAsigna);
				continue;
			}

			if(campo.clase.equals(AntiguedadesInventariosConstantesFunciones.IDBODEGA)) {
				this.setActivarid_bodegaAntiguedadesInventarios(esAsigna);
				continue;
			}

			if(campo.clase.equals(AntiguedadesInventariosConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaAntiguedadesInventarios(esAsigna);
				continue;
			}

			if(campo.clase.equals(AntiguedadesInventariosConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalAntiguedadesInventarios(esAsigna);
				continue;
			}

			if(campo.clase.equals(AntiguedadesInventariosConstantesFunciones.IDLINEA)) {
				this.setActivarid_lineaAntiguedadesInventarios(esAsigna);
				continue;
			}

			if(campo.clase.equals(AntiguedadesInventariosConstantesFunciones.IDLINEAGRUPO)) {
				this.setActivarid_linea_grupoAntiguedadesInventarios(esAsigna);
				continue;
			}

			if(campo.clase.equals(AntiguedadesInventariosConstantesFunciones.IDLINEACATEGORIA)) {
				this.setActivarid_linea_categoriaAntiguedadesInventarios(esAsigna);
				continue;
			}

			if(campo.clase.equals(AntiguedadesInventariosConstantesFunciones.IDLINEAMARCA)) {
				this.setActivarid_linea_marcaAntiguedadesInventarios(esAsigna);
				continue;
			}

			if(campo.clase.equals(AntiguedadesInventariosConstantesFunciones.FECHAULTIMAVENTAHASTA)) {
				this.setActivarfecha_ultima_venta_hastaAntiguedadesInventarios(esAsigna);
				continue;
			}

			if(campo.clase.equals(AntiguedadesInventariosConstantesFunciones.NOMBRESUCURSAL)) {
				this.setActivarnombre_sucursalAntiguedadesInventarios(esAsigna);
				continue;
			}

			if(campo.clase.equals(AntiguedadesInventariosConstantesFunciones.NOMBRELINEA)) {
				this.setActivarnombre_lineaAntiguedadesInventarios(esAsigna);
				continue;
			}

			if(campo.clase.equals(AntiguedadesInventariosConstantesFunciones.NOMBRELINEAGRUPO)) {
				this.setActivarnombre_linea_grupoAntiguedadesInventarios(esAsigna);
				continue;
			}

			if(campo.clase.equals(AntiguedadesInventariosConstantesFunciones.NOMBRELINEACATEGORIA)) {
				this.setActivarnombre_linea_categoriaAntiguedadesInventarios(esAsigna);
				continue;
			}

			if(campo.clase.equals(AntiguedadesInventariosConstantesFunciones.NOMBRELINEAMARCA)) {
				this.setActivarnombre_linea_marcaAntiguedadesInventarios(esAsigna);
				continue;
			}

			if(campo.clase.equals(AntiguedadesInventariosConstantesFunciones.CODIGO)) {
				this.setActivarcodigoAntiguedadesInventarios(esAsigna);
				continue;
			}

			if(campo.clase.equals(AntiguedadesInventariosConstantesFunciones.NOMBRE)) {
				this.setActivarnombreAntiguedadesInventarios(esAsigna);
				continue;
			}

			if(campo.clase.equals(AntiguedadesInventariosConstantesFunciones.NOMBREBODEGA)) {
				this.setActivarnombre_bodegaAntiguedadesInventarios(esAsigna);
				continue;
			}

			if(campo.clase.equals(AntiguedadesInventariosConstantesFunciones.NOMBREUNIDAD)) {
				this.setActivarnombre_unidadAntiguedadesInventarios(esAsigna);
				continue;
			}

			if(campo.clase.equals(AntiguedadesInventariosConstantesFunciones.CANTIDADDISPONIBLE)) {
				this.setActivarcantidad_disponibleAntiguedadesInventarios(esAsigna);
				continue;
			}

			if(campo.clase.equals(AntiguedadesInventariosConstantesFunciones.FECHAULTIMACOMPRA)) {
				this.setActivarfecha_ultima_compraAntiguedadesInventarios(esAsigna);
				continue;
			}

			if(campo.clase.equals(AntiguedadesInventariosConstantesFunciones.FECHAULTIMAVENTA)) {
				this.setActivarfecha_ultima_ventaAntiguedadesInventarios(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,AntiguedadesInventariosBeanSwingJInternalFrame antiguedadesinventariosBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridAntiguedadesInventarios(esInicial);
		this.setResaltarid_bodegaAntiguedadesInventarios(esInicial);
		this.setResaltarid_empresaAntiguedadesInventarios(esInicial);
		this.setResaltarid_sucursalAntiguedadesInventarios(esInicial);
		this.setResaltarid_lineaAntiguedadesInventarios(esInicial);
		this.setResaltarid_linea_grupoAntiguedadesInventarios(esInicial);
		this.setResaltarid_linea_categoriaAntiguedadesInventarios(esInicial);
		this.setResaltarid_linea_marcaAntiguedadesInventarios(esInicial);
		this.setResaltarfecha_ultima_venta_hastaAntiguedadesInventarios(esInicial);
		this.setResaltarnombre_sucursalAntiguedadesInventarios(esInicial);
		this.setResaltarnombre_lineaAntiguedadesInventarios(esInicial);
		this.setResaltarnombre_linea_grupoAntiguedadesInventarios(esInicial);
		this.setResaltarnombre_linea_categoriaAntiguedadesInventarios(esInicial);
		this.setResaltarnombre_linea_marcaAntiguedadesInventarios(esInicial);
		this.setResaltarcodigoAntiguedadesInventarios(esInicial);
		this.setResaltarnombreAntiguedadesInventarios(esInicial);
		this.setResaltarnombre_bodegaAntiguedadesInventarios(esInicial);
		this.setResaltarnombre_unidadAntiguedadesInventarios(esInicial);
		this.setResaltarcantidad_disponibleAntiguedadesInventarios(esInicial);
		this.setResaltarfecha_ultima_compraAntiguedadesInventarios(esInicial);
		this.setResaltarfecha_ultima_ventaAntiguedadesInventarios(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(AntiguedadesInventariosConstantesFunciones.ID)) {
				this.setResaltaridAntiguedadesInventarios(esAsigna);
				continue;
			}

			if(campo.clase.equals(AntiguedadesInventariosConstantesFunciones.IDBODEGA)) {
				this.setResaltarid_bodegaAntiguedadesInventarios(esAsigna);
				continue;
			}

			if(campo.clase.equals(AntiguedadesInventariosConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaAntiguedadesInventarios(esAsigna);
				continue;
			}

			if(campo.clase.equals(AntiguedadesInventariosConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalAntiguedadesInventarios(esAsigna);
				continue;
			}

			if(campo.clase.equals(AntiguedadesInventariosConstantesFunciones.IDLINEA)) {
				this.setResaltarid_lineaAntiguedadesInventarios(esAsigna);
				continue;
			}

			if(campo.clase.equals(AntiguedadesInventariosConstantesFunciones.IDLINEAGRUPO)) {
				this.setResaltarid_linea_grupoAntiguedadesInventarios(esAsigna);
				continue;
			}

			if(campo.clase.equals(AntiguedadesInventariosConstantesFunciones.IDLINEACATEGORIA)) {
				this.setResaltarid_linea_categoriaAntiguedadesInventarios(esAsigna);
				continue;
			}

			if(campo.clase.equals(AntiguedadesInventariosConstantesFunciones.IDLINEAMARCA)) {
				this.setResaltarid_linea_marcaAntiguedadesInventarios(esAsigna);
				continue;
			}

			if(campo.clase.equals(AntiguedadesInventariosConstantesFunciones.FECHAULTIMAVENTAHASTA)) {
				this.setResaltarfecha_ultima_venta_hastaAntiguedadesInventarios(esAsigna);
				continue;
			}

			if(campo.clase.equals(AntiguedadesInventariosConstantesFunciones.NOMBRESUCURSAL)) {
				this.setResaltarnombre_sucursalAntiguedadesInventarios(esAsigna);
				continue;
			}

			if(campo.clase.equals(AntiguedadesInventariosConstantesFunciones.NOMBRELINEA)) {
				this.setResaltarnombre_lineaAntiguedadesInventarios(esAsigna);
				continue;
			}

			if(campo.clase.equals(AntiguedadesInventariosConstantesFunciones.NOMBRELINEAGRUPO)) {
				this.setResaltarnombre_linea_grupoAntiguedadesInventarios(esAsigna);
				continue;
			}

			if(campo.clase.equals(AntiguedadesInventariosConstantesFunciones.NOMBRELINEACATEGORIA)) {
				this.setResaltarnombre_linea_categoriaAntiguedadesInventarios(esAsigna);
				continue;
			}

			if(campo.clase.equals(AntiguedadesInventariosConstantesFunciones.NOMBRELINEAMARCA)) {
				this.setResaltarnombre_linea_marcaAntiguedadesInventarios(esAsigna);
				continue;
			}

			if(campo.clase.equals(AntiguedadesInventariosConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoAntiguedadesInventarios(esAsigna);
				continue;
			}

			if(campo.clase.equals(AntiguedadesInventariosConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreAntiguedadesInventarios(esAsigna);
				continue;
			}

			if(campo.clase.equals(AntiguedadesInventariosConstantesFunciones.NOMBREBODEGA)) {
				this.setResaltarnombre_bodegaAntiguedadesInventarios(esAsigna);
				continue;
			}

			if(campo.clase.equals(AntiguedadesInventariosConstantesFunciones.NOMBREUNIDAD)) {
				this.setResaltarnombre_unidadAntiguedadesInventarios(esAsigna);
				continue;
			}

			if(campo.clase.equals(AntiguedadesInventariosConstantesFunciones.CANTIDADDISPONIBLE)) {
				this.setResaltarcantidad_disponibleAntiguedadesInventarios(esAsigna);
				continue;
			}

			if(campo.clase.equals(AntiguedadesInventariosConstantesFunciones.FECHAULTIMACOMPRA)) {
				this.setResaltarfecha_ultima_compraAntiguedadesInventarios(esAsigna);
				continue;
			}

			if(campo.clase.equals(AntiguedadesInventariosConstantesFunciones.FECHAULTIMAVENTA)) {
				this.setResaltarfecha_ultima_ventaAntiguedadesInventarios(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,AntiguedadesInventariosBeanSwingJInternalFrame antiguedadesinventariosBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaAntiguedadesInventariosAntiguedadesInventarios=true;

	public Boolean getMostrarBusquedaAntiguedadesInventariosAntiguedadesInventarios() {
		return this.mostrarBusquedaAntiguedadesInventariosAntiguedadesInventarios;
	}

	public void setMostrarBusquedaAntiguedadesInventariosAntiguedadesInventarios(Boolean visibilidadResaltar) {
		this.mostrarBusquedaAntiguedadesInventariosAntiguedadesInventarios= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaAntiguedadesInventariosAntiguedadesInventarios=true;

	public Boolean getActivarBusquedaAntiguedadesInventariosAntiguedadesInventarios() {
		return this.activarBusquedaAntiguedadesInventariosAntiguedadesInventarios;
	}

	public void setActivarBusquedaAntiguedadesInventariosAntiguedadesInventarios(Boolean habilitarResaltar) {
		this.activarBusquedaAntiguedadesInventariosAntiguedadesInventarios= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaAntiguedadesInventariosAntiguedadesInventarios=null;

	public Border getResaltarBusquedaAntiguedadesInventariosAntiguedadesInventarios() {
		return this.resaltarBusquedaAntiguedadesInventariosAntiguedadesInventarios;
	}

	public void setResaltarBusquedaAntiguedadesInventariosAntiguedadesInventarios(Border borderResaltar) {
		this.resaltarBusquedaAntiguedadesInventariosAntiguedadesInventarios= borderResaltar;
	}

	public void setResaltarBusquedaAntiguedadesInventariosAntiguedadesInventarios(ParametroGeneralUsuario parametroGeneralUsuario/*AntiguedadesInventariosBeanSwingJInternalFrame antiguedadesinventariosBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaAntiguedadesInventariosAntiguedadesInventarios= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}