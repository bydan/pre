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


import com.bydan.erp.inventario.util.report.ConsumosBodegasConstantesFunciones;
import com.bydan.erp.inventario.util.report.ConsumosBodegasParameterReturnGeneral;
//import com.bydan.erp.inventario.util.report.ConsumosBodegasParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.inventario.business.entity.*;
import com.bydan.erp.inventario.business.entity.report.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;
import com.bydan.erp.inventario.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.tesoreria.util.*;
import com.bydan.erp.inventario.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.inventario.business.dataaccess.*;
//import com.bydan.erp.inventario.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class ConsumosBodegasConstantesFunciones{		
	
	
	
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
	public static final String SNOMBREOPCION="ConsumosBodegas";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="ConsumosBodegas"+ConsumosBodegasConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="ConsumosBodegasHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="ConsumosBodegasHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=ConsumosBodegasConstantesFunciones.SCHEMA+"_"+ConsumosBodegasConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/ConsumosBodegasHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=ConsumosBodegasConstantesFunciones.SCHEMA+"_"+ConsumosBodegasConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=ConsumosBodegasConstantesFunciones.SCHEMA+"_"+ConsumosBodegasConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/ConsumosBodegasHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=ConsumosBodegasConstantesFunciones.SCHEMA+"_"+ConsumosBodegasConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ConsumosBodegasConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ConsumosBodegasHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ConsumosBodegasConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ConsumosBodegasConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/ConsumosBodegasHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+ConsumosBodegasConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=ConsumosBodegasConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+ConsumosBodegasConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=ConsumosBodegasConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+ConsumosBodegasConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Consumos Bodegases";
	public static final String SRELATIVEPATH="../../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Consumos Bodegas";
	public static final String SCLASSWEBTITULO_LOWER="Consumos Bodegas";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="ConsumosBodegas";
	public static final String OBJECTNAME="consumosbodegas";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="consumos_bodegas";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select consumosbodegas from "+ConsumosBodegasConstantesFunciones.SPERSISTENCENAME+" consumosbodegas";
	public static String QUERYSELECTNATIVE="select "+ConsumosBodegasConstantesFunciones.SCHEMA+"."+ConsumosBodegasConstantesFunciones.TABLENAME+".id,"+ConsumosBodegasConstantesFunciones.SCHEMA+"."+ConsumosBodegasConstantesFunciones.TABLENAME+".version_row,"+ConsumosBodegasConstantesFunciones.SCHEMA+"."+ConsumosBodegasConstantesFunciones.TABLENAME+".id_empresa,"+ConsumosBodegasConstantesFunciones.SCHEMA+"."+ConsumosBodegasConstantesFunciones.TABLENAME+".id_transaccion,"+ConsumosBodegasConstantesFunciones.SCHEMA+"."+ConsumosBodegasConstantesFunciones.TABLENAME+".id_linea,"+ConsumosBodegasConstantesFunciones.SCHEMA+"."+ConsumosBodegasConstantesFunciones.TABLENAME+".id_linea_grupo,"+ConsumosBodegasConstantesFunciones.SCHEMA+"."+ConsumosBodegasConstantesFunciones.TABLENAME+".id_linea_categoria,"+ConsumosBodegasConstantesFunciones.SCHEMA+"."+ConsumosBodegasConstantesFunciones.TABLENAME+".id_linea_marca,"+ConsumosBodegasConstantesFunciones.SCHEMA+"."+ConsumosBodegasConstantesFunciones.TABLENAME+".fecha_emision_desde,"+ConsumosBodegasConstantesFunciones.SCHEMA+"."+ConsumosBodegasConstantesFunciones.TABLENAME+".fecha_emision_hasta,"+ConsumosBodegasConstantesFunciones.SCHEMA+"."+ConsumosBodegasConstantesFunciones.TABLENAME+".nombre_producto,"+ConsumosBodegasConstantesFunciones.SCHEMA+"."+ConsumosBodegasConstantesFunciones.TABLENAME+".nombre_unidad,"+ConsumosBodegasConstantesFunciones.SCHEMA+"."+ConsumosBodegasConstantesFunciones.TABLENAME+".cantidad,"+ConsumosBodegasConstantesFunciones.SCHEMA+"."+ConsumosBodegasConstantesFunciones.TABLENAME+".costo_total,"+ConsumosBodegasConstantesFunciones.SCHEMA+"."+ConsumosBodegasConstantesFunciones.TABLENAME+".nombre_linea,"+ConsumosBodegasConstantesFunciones.SCHEMA+"."+ConsumosBodegasConstantesFunciones.TABLENAME+".nombre_linea_grupo,"+ConsumosBodegasConstantesFunciones.SCHEMA+"."+ConsumosBodegasConstantesFunciones.TABLENAME+".nombre_linea_categoria,"+ConsumosBodegasConstantesFunciones.SCHEMA+"."+ConsumosBodegasConstantesFunciones.TABLENAME+".nombre_linea_marca,"+ConsumosBodegasConstantesFunciones.SCHEMA+"."+ConsumosBodegasConstantesFunciones.TABLENAME+".codigo from "+ConsumosBodegasConstantesFunciones.SCHEMA+"."+ConsumosBodegasConstantesFunciones.TABLENAME;//+" as "+ConsumosBodegasConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDTRANSACCION= "id_transaccion";
    public static final String IDLINEA= "id_linea";
    public static final String IDLINEAGRUPO= "id_linea_grupo";
    public static final String IDLINEACATEGORIA= "id_linea_categoria";
    public static final String IDLINEAMARCA= "id_linea_marca";
    public static final String FECHAEMISIONDESDE= "fecha_emision_desde";
    public static final String FECHAEMISIONHASTA= "fecha_emision_hasta";
    public static final String NOMBREPRODUCTO= "nombre_producto";
    public static final String NOMBREUNIDAD= "nombre_unidad";
    public static final String CANTIDAD= "cantidad";
    public static final String COSTOTOTAL= "costo_total";
    public static final String NOMBRELINEA= "nombre_linea";
    public static final String NOMBRELINEAGRUPO= "nombre_linea_grupo";
    public static final String NOMBRELINEACATEGORIA= "nombre_linea_categoria";
    public static final String NOMBRELINEAMARCA= "nombre_linea_marca";
    public static final String CODIGO= "codigo";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDTRANSACCION= "Transaccion";
		public static final String LABEL_IDTRANSACCION_LOWER= "Transaccion";
    	public static final String LABEL_IDLINEA= "Linea";
		public static final String LABEL_IDLINEA_LOWER= "Linea";
    	public static final String LABEL_IDLINEAGRUPO= "Linea Grupo";
		public static final String LABEL_IDLINEAGRUPO_LOWER= "Linea Grupo";
    	public static final String LABEL_IDLINEACATEGORIA= "Linea Categoria";
		public static final String LABEL_IDLINEACATEGORIA_LOWER= "Linea Categoria";
    	public static final String LABEL_IDLINEAMARCA= "Linea Marca";
		public static final String LABEL_IDLINEAMARCA_LOWER= "Linea Marca";
    	public static final String LABEL_FECHAEMISIONDESDE= "Fecha Emision Desde";
		public static final String LABEL_FECHAEMISIONDESDE_LOWER= "Fecha Emision Desde";
    	public static final String LABEL_FECHAEMISIONHASTA= "Fecha Emision Hasta";
		public static final String LABEL_FECHAEMISIONHASTA_LOWER= "Fecha Emision Hasta";
    	public static final String LABEL_NOMBREPRODUCTO= "Nombre Producto";
		public static final String LABEL_NOMBREPRODUCTO_LOWER= "Nombre Producto";
    	public static final String LABEL_NOMBREUNIDAD= "Nombre Unad";
		public static final String LABEL_NOMBREUNIDAD_LOWER= "Nombre Unidad";
    	public static final String LABEL_CANTIDAD= "Cantad";
		public static final String LABEL_CANTIDAD_LOWER= "Cantidad";
    	public static final String LABEL_COSTOTOTAL= "Costo Total";
		public static final String LABEL_COSTOTOTAL_LOWER= "Costo Total";
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
	
		
		
		
		
		
		
		
		
		
		
	public static final String SREGEXNOMBRE_PRODUCTO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_PRODUCTO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE_UNIDAD=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE_UNIDAD=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
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
	
	public static String getConsumosBodegasLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(ConsumosBodegasConstantesFunciones.IDEMPRESA)) {sLabelColumna=ConsumosBodegasConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(ConsumosBodegasConstantesFunciones.IDTRANSACCION)) {sLabelColumna=ConsumosBodegasConstantesFunciones.LABEL_IDTRANSACCION;}
		if(sNombreColumna.equals(ConsumosBodegasConstantesFunciones.IDLINEA)) {sLabelColumna=ConsumosBodegasConstantesFunciones.LABEL_IDLINEA;}
		if(sNombreColumna.equals(ConsumosBodegasConstantesFunciones.IDLINEAGRUPO)) {sLabelColumna=ConsumosBodegasConstantesFunciones.LABEL_IDLINEAGRUPO;}
		if(sNombreColumna.equals(ConsumosBodegasConstantesFunciones.IDLINEACATEGORIA)) {sLabelColumna=ConsumosBodegasConstantesFunciones.LABEL_IDLINEACATEGORIA;}
		if(sNombreColumna.equals(ConsumosBodegasConstantesFunciones.IDLINEAMARCA)) {sLabelColumna=ConsumosBodegasConstantesFunciones.LABEL_IDLINEAMARCA;}
		if(sNombreColumna.equals(ConsumosBodegasConstantesFunciones.FECHAEMISIONDESDE)) {sLabelColumna=ConsumosBodegasConstantesFunciones.LABEL_FECHAEMISIONDESDE;}
		if(sNombreColumna.equals(ConsumosBodegasConstantesFunciones.FECHAEMISIONHASTA)) {sLabelColumna=ConsumosBodegasConstantesFunciones.LABEL_FECHAEMISIONHASTA;}
		if(sNombreColumna.equals(ConsumosBodegasConstantesFunciones.NOMBREPRODUCTO)) {sLabelColumna=ConsumosBodegasConstantesFunciones.LABEL_NOMBREPRODUCTO;}
		if(sNombreColumna.equals(ConsumosBodegasConstantesFunciones.NOMBREUNIDAD)) {sLabelColumna=ConsumosBodegasConstantesFunciones.LABEL_NOMBREUNIDAD;}
		if(sNombreColumna.equals(ConsumosBodegasConstantesFunciones.CANTIDAD)) {sLabelColumna=ConsumosBodegasConstantesFunciones.LABEL_CANTIDAD;}
		if(sNombreColumna.equals(ConsumosBodegasConstantesFunciones.COSTOTOTAL)) {sLabelColumna=ConsumosBodegasConstantesFunciones.LABEL_COSTOTOTAL;}
		if(sNombreColumna.equals(ConsumosBodegasConstantesFunciones.NOMBRELINEA)) {sLabelColumna=ConsumosBodegasConstantesFunciones.LABEL_NOMBRELINEA;}
		if(sNombreColumna.equals(ConsumosBodegasConstantesFunciones.NOMBRELINEAGRUPO)) {sLabelColumna=ConsumosBodegasConstantesFunciones.LABEL_NOMBRELINEAGRUPO;}
		if(sNombreColumna.equals(ConsumosBodegasConstantesFunciones.NOMBRELINEACATEGORIA)) {sLabelColumna=ConsumosBodegasConstantesFunciones.LABEL_NOMBRELINEACATEGORIA;}
		if(sNombreColumna.equals(ConsumosBodegasConstantesFunciones.NOMBRELINEAMARCA)) {sLabelColumna=ConsumosBodegasConstantesFunciones.LABEL_NOMBRELINEAMARCA;}
		if(sNombreColumna.equals(ConsumosBodegasConstantesFunciones.CODIGO)) {sLabelColumna=ConsumosBodegasConstantesFunciones.LABEL_CODIGO;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getConsumosBodegasDescripcion(ConsumosBodegas consumosbodegas) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(consumosbodegas !=null/* && consumosbodegas.getId()!=0*/) {
			sDescripcion=consumosbodegas.getcodigo();//consumosbodegasconsumosbodegas.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getConsumosBodegasDescripcionDetallado(ConsumosBodegas consumosbodegas) {
		String sDescripcion="";
			
		sDescripcion+=ConsumosBodegasConstantesFunciones.ID+"=";
		sDescripcion+=consumosbodegas.getId().toString()+",";
		sDescripcion+=ConsumosBodegasConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=consumosbodegas.getVersionRow().toString()+",";
		sDescripcion+=ConsumosBodegasConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=consumosbodegas.getid_empresa().toString()+",";
		sDescripcion+=ConsumosBodegasConstantesFunciones.IDTRANSACCION+"=";
		sDescripcion+=consumosbodegas.getid_transaccion().toString()+",";
		sDescripcion+=ConsumosBodegasConstantesFunciones.IDLINEA+"=";
		sDescripcion+=consumosbodegas.getid_linea().toString()+",";
		sDescripcion+=ConsumosBodegasConstantesFunciones.IDLINEAGRUPO+"=";
		sDescripcion+=consumosbodegas.getid_linea_grupo().toString()+",";
		sDescripcion+=ConsumosBodegasConstantesFunciones.IDLINEACATEGORIA+"=";
		sDescripcion+=consumosbodegas.getid_linea_categoria().toString()+",";
		sDescripcion+=ConsumosBodegasConstantesFunciones.IDLINEAMARCA+"=";
		sDescripcion+=consumosbodegas.getid_linea_marca().toString()+",";
		sDescripcion+=ConsumosBodegasConstantesFunciones.FECHAEMISIONDESDE+"=";
		sDescripcion+=consumosbodegas.getfecha_emision_desde().toString()+",";
		sDescripcion+=ConsumosBodegasConstantesFunciones.FECHAEMISIONHASTA+"=";
		sDescripcion+=consumosbodegas.getfecha_emision_hasta().toString()+",";
		sDescripcion+=ConsumosBodegasConstantesFunciones.NOMBREPRODUCTO+"=";
		sDescripcion+=consumosbodegas.getnombre_producto()+",";
		sDescripcion+=ConsumosBodegasConstantesFunciones.NOMBREUNIDAD+"=";
		sDescripcion+=consumosbodegas.getnombre_unidad()+",";
		sDescripcion+=ConsumosBodegasConstantesFunciones.CANTIDAD+"=";
		sDescripcion+=consumosbodegas.getcantidad().toString()+",";
		sDescripcion+=ConsumosBodegasConstantesFunciones.COSTOTOTAL+"=";
		sDescripcion+=consumosbodegas.getcosto_total().toString()+",";
		sDescripcion+=ConsumosBodegasConstantesFunciones.NOMBRELINEA+"=";
		sDescripcion+=consumosbodegas.getnombre_linea()+",";
		sDescripcion+=ConsumosBodegasConstantesFunciones.NOMBRELINEAGRUPO+"=";
		sDescripcion+=consumosbodegas.getnombre_linea_grupo()+",";
		sDescripcion+=ConsumosBodegasConstantesFunciones.NOMBRELINEACATEGORIA+"=";
		sDescripcion+=consumosbodegas.getnombre_linea_categoria()+",";
		sDescripcion+=ConsumosBodegasConstantesFunciones.NOMBRELINEAMARCA+"=";
		sDescripcion+=consumosbodegas.getnombre_linea_marca()+",";
		sDescripcion+=ConsumosBodegasConstantesFunciones.CODIGO+"=";
		sDescripcion+=consumosbodegas.getcodigo()+",";
			
		return sDescripcion;
	}
	
	public static void setConsumosBodegasDescripcion(ConsumosBodegas consumosbodegas,String sValor) throws Exception {			
		if(consumosbodegas !=null) {
			consumosbodegas.setcodigo(sValor);;//consumosbodegasconsumosbodegas.getcodigo().trim();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getTransaccionDescripcion(Transaccion transaccion) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(transaccion!=null/*&&transaccion.getId()>0*/) {
			sDescripcion=TransaccionConstantesFunciones.getTransaccionDescripcion(transaccion);
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
		} else if(sNombreIndice.equals("BusquedaConsumosBodegas")) {
			sNombreIndice="Tipo=  Por Transaccion Por Linea Por Linea Grupo Por Linea Categoria Por Linea Marca Por Fecha Emision Desde Por Fecha Emision Hasta";
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
		} else if(sNombreIndice.equals("FK_IdTransaccion")) {
			sNombreIndice="Tipo=  Por Transaccion";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceBusquedaConsumosBodegas(Long id_transaccion,Long id_linea,Long id_linea_grupo,Long id_linea_categoria,Long id_linea_marca,Date fecha_emision_desde,Date fecha_emision_hasta) {
		String sDetalleIndice=" Parametros->";
		if(id_transaccion!=null) {sDetalleIndice+=" Codigo Unico De Transaccion="+id_transaccion.toString();}
		if(id_linea!=null) {sDetalleIndice+=" Codigo Unico De Linea="+id_linea.toString();}
		if(id_linea_grupo!=null) {sDetalleIndice+=" Codigo Unico De Linea Grupo="+id_linea_grupo.toString();}
		if(id_linea_categoria!=null) {sDetalleIndice+=" Codigo Unico De Linea Categoria="+id_linea_categoria.toString();}
		if(id_linea_marca!=null) {sDetalleIndice+=" Codigo Unico De Linea Marca="+id_linea_marca.toString();}
		if(fecha_emision_desde!=null) {sDetalleIndice+=" Fecha Emision Desde="+fecha_emision_desde.toString();}
		if(fecha_emision_hasta!=null) {sDetalleIndice+=" Fecha Emision Hasta="+fecha_emision_hasta.toString();} 

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

	public static String getDetalleIndiceFK_IdTransaccion(Long id_transaccion) {
		String sDetalleIndice=" Parametros->";
		if(id_transaccion!=null) {sDetalleIndice+=" Codigo Unico De Transaccion="+id_transaccion.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosConsumosBodegas(ConsumosBodegas consumosbodegas,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		consumosbodegas.setnombre_producto(consumosbodegas.getnombre_producto().trim());
		consumosbodegas.setnombre_unidad(consumosbodegas.getnombre_unidad().trim());
		consumosbodegas.setnombre_linea(consumosbodegas.getnombre_linea().trim());
		consumosbodegas.setnombre_linea_grupo(consumosbodegas.getnombre_linea_grupo().trim());
		consumosbodegas.setnombre_linea_categoria(consumosbodegas.getnombre_linea_categoria().trim());
		consumosbodegas.setnombre_linea_marca(consumosbodegas.getnombre_linea_marca().trim());
		consumosbodegas.setcodigo(consumosbodegas.getcodigo().trim());
	}
	
	public static void quitarEspaciosConsumosBodegass(List<ConsumosBodegas> consumosbodegass,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(ConsumosBodegas consumosbodegas: consumosbodegass) {
			consumosbodegas.setnombre_producto(consumosbodegas.getnombre_producto().trim());
			consumosbodegas.setnombre_unidad(consumosbodegas.getnombre_unidad().trim());
			consumosbodegas.setnombre_linea(consumosbodegas.getnombre_linea().trim());
			consumosbodegas.setnombre_linea_grupo(consumosbodegas.getnombre_linea_grupo().trim());
			consumosbodegas.setnombre_linea_categoria(consumosbodegas.getnombre_linea_categoria().trim());
			consumosbodegas.setnombre_linea_marca(consumosbodegas.getnombre_linea_marca().trim());
			consumosbodegas.setcodigo(consumosbodegas.getcodigo().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresConsumosBodegas(ConsumosBodegas consumosbodegas,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && consumosbodegas.getConCambioAuxiliar()) {
			consumosbodegas.setIsDeleted(consumosbodegas.getIsDeletedAuxiliar());	
			consumosbodegas.setIsNew(consumosbodegas.getIsNewAuxiliar());	
			consumosbodegas.setIsChanged(consumosbodegas.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			consumosbodegas.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			consumosbodegas.setIsDeletedAuxiliar(false);	
			consumosbodegas.setIsNewAuxiliar(false);	
			consumosbodegas.setIsChangedAuxiliar(false);
			
			consumosbodegas.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresConsumosBodegass(List<ConsumosBodegas> consumosbodegass,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(ConsumosBodegas consumosbodegas : consumosbodegass) {
			if(conAsignarBase && consumosbodegas.getConCambioAuxiliar()) {
				consumosbodegas.setIsDeleted(consumosbodegas.getIsDeletedAuxiliar());	
				consumosbodegas.setIsNew(consumosbodegas.getIsNewAuxiliar());	
				consumosbodegas.setIsChanged(consumosbodegas.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				consumosbodegas.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				consumosbodegas.setIsDeletedAuxiliar(false);	
				consumosbodegas.setIsNewAuxiliar(false);	
				consumosbodegas.setIsChangedAuxiliar(false);
				
				consumosbodegas.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresConsumosBodegas(ConsumosBodegas consumosbodegas,Boolean conEnteros) throws Exception  {
		consumosbodegas.setcosto_total(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
			consumosbodegas.setcantidad(0);
		}
	}		
	
	public static void InicializarValoresConsumosBodegass(List<ConsumosBodegas> consumosbodegass,Boolean conEnteros) throws Exception  {
		
		for(ConsumosBodegas consumosbodegas: consumosbodegass) {
			consumosbodegas.setcosto_total(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
				consumosbodegas.setcantidad(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaConsumosBodegas(List<ConsumosBodegas> consumosbodegass,ConsumosBodegas consumosbodegasAux) throws Exception  {
		ConsumosBodegasConstantesFunciones.InicializarValoresConsumosBodegas(consumosbodegasAux,true);
		
		for(ConsumosBodegas consumosbodegas: consumosbodegass) {
			if(consumosbodegas.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			consumosbodegasAux.setcantidad(consumosbodegasAux.getcantidad()+consumosbodegas.getcantidad());			
			consumosbodegasAux.setcosto_total(consumosbodegasAux.getcosto_total()+consumosbodegas.getcosto_total());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesConsumosBodegas(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=ConsumosBodegasConstantesFunciones.getArrayColumnasGlobalesConsumosBodegas(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesConsumosBodegas(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(ConsumosBodegasConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(ConsumosBodegasConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoConsumosBodegas(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<ConsumosBodegas> consumosbodegass,ConsumosBodegas consumosbodegas,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(ConsumosBodegas consumosbodegasAux: consumosbodegass) {
			if(consumosbodegasAux!=null && consumosbodegas!=null) {
				if((consumosbodegasAux.getId()==null && consumosbodegas.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(consumosbodegasAux.getId()!=null && consumosbodegas.getId()!=null){
					if(consumosbodegasAux.getId().equals(consumosbodegas.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaConsumosBodegas(List<ConsumosBodegas> consumosbodegass) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double costo_totalTotal=0.0;
	
		for(ConsumosBodegas consumosbodegas: consumosbodegass) {			
			if(consumosbodegas.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			costo_totalTotal+=consumosbodegas.getcosto_total();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(ConsumosBodegasConstantesFunciones.COSTOTOTAL);
		datoGeneral.setsDescripcion(ConsumosBodegasConstantesFunciones.LABEL_COSTOTOTAL);
		datoGeneral.setdValorDouble(costo_totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaConsumosBodegas() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,ConsumosBodegasConstantesFunciones.LABEL_ID, ConsumosBodegasConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConsumosBodegasConstantesFunciones.LABEL_VERSIONROW, ConsumosBodegasConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConsumosBodegasConstantesFunciones.LABEL_NOMBREPRODUCTO, ConsumosBodegasConstantesFunciones.NOMBREPRODUCTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConsumosBodegasConstantesFunciones.LABEL_NOMBREUNIDAD, ConsumosBodegasConstantesFunciones.NOMBREUNIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConsumosBodegasConstantesFunciones.LABEL_CANTIDAD, ConsumosBodegasConstantesFunciones.CANTIDAD,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConsumosBodegasConstantesFunciones.LABEL_COSTOTOTAL, ConsumosBodegasConstantesFunciones.COSTOTOTAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConsumosBodegasConstantesFunciones.LABEL_NOMBRELINEA, ConsumosBodegasConstantesFunciones.NOMBRELINEA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConsumosBodegasConstantesFunciones.LABEL_NOMBRELINEAGRUPO, ConsumosBodegasConstantesFunciones.NOMBRELINEAGRUPO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConsumosBodegasConstantesFunciones.LABEL_NOMBRELINEACATEGORIA, ConsumosBodegasConstantesFunciones.NOMBRELINEACATEGORIA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConsumosBodegasConstantesFunciones.LABEL_NOMBRELINEAMARCA, ConsumosBodegasConstantesFunciones.NOMBRELINEAMARCA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,ConsumosBodegasConstantesFunciones.LABEL_CODIGO, ConsumosBodegasConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasConsumosBodegas() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=ConsumosBodegasConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConsumosBodegasConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConsumosBodegasConstantesFunciones.NOMBREPRODUCTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConsumosBodegasConstantesFunciones.NOMBREUNIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConsumosBodegasConstantesFunciones.CANTIDAD;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConsumosBodegasConstantesFunciones.COSTOTOTAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConsumosBodegasConstantesFunciones.NOMBRELINEA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConsumosBodegasConstantesFunciones.NOMBRELINEAGRUPO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConsumosBodegasConstantesFunciones.NOMBRELINEACATEGORIA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConsumosBodegasConstantesFunciones.NOMBRELINEAMARCA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=ConsumosBodegasConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarConsumosBodegas() throws Exception  {
		return ConsumosBodegasConstantesFunciones.getTiposSeleccionarConsumosBodegas(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarConsumosBodegas(Boolean conFk) throws Exception  {
		return ConsumosBodegasConstantesFunciones.getTiposSeleccionarConsumosBodegas(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarConsumosBodegas(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ConsumosBodegasConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(ConsumosBodegasConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ConsumosBodegasConstantesFunciones.LABEL_IDTRANSACCION);
			reporte.setsDescripcion(ConsumosBodegasConstantesFunciones.LABEL_IDTRANSACCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ConsumosBodegasConstantesFunciones.LABEL_IDLINEA);
			reporte.setsDescripcion(ConsumosBodegasConstantesFunciones.LABEL_IDLINEA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ConsumosBodegasConstantesFunciones.LABEL_IDLINEAGRUPO);
			reporte.setsDescripcion(ConsumosBodegasConstantesFunciones.LABEL_IDLINEAGRUPO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ConsumosBodegasConstantesFunciones.LABEL_IDLINEACATEGORIA);
			reporte.setsDescripcion(ConsumosBodegasConstantesFunciones.LABEL_IDLINEACATEGORIA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(ConsumosBodegasConstantesFunciones.LABEL_IDLINEAMARCA);
			reporte.setsDescripcion(ConsumosBodegasConstantesFunciones.LABEL_IDLINEAMARCA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ConsumosBodegasConstantesFunciones.LABEL_FECHAEMISIONDESDE);
			reporte.setsDescripcion(ConsumosBodegasConstantesFunciones.LABEL_FECHAEMISIONDESDE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ConsumosBodegasConstantesFunciones.LABEL_FECHAEMISIONHASTA);
			reporte.setsDescripcion(ConsumosBodegasConstantesFunciones.LABEL_FECHAEMISIONHASTA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ConsumosBodegasConstantesFunciones.LABEL_NOMBREPRODUCTO);
			reporte.setsDescripcion(ConsumosBodegasConstantesFunciones.LABEL_NOMBREPRODUCTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ConsumosBodegasConstantesFunciones.LABEL_NOMBREUNIDAD);
			reporte.setsDescripcion(ConsumosBodegasConstantesFunciones.LABEL_NOMBREUNIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ConsumosBodegasConstantesFunciones.LABEL_CANTIDAD);
			reporte.setsDescripcion(ConsumosBodegasConstantesFunciones.LABEL_CANTIDAD);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ConsumosBodegasConstantesFunciones.LABEL_COSTOTOTAL);
			reporte.setsDescripcion(ConsumosBodegasConstantesFunciones.LABEL_COSTOTOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ConsumosBodegasConstantesFunciones.LABEL_NOMBRELINEA);
			reporte.setsDescripcion(ConsumosBodegasConstantesFunciones.LABEL_NOMBRELINEA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ConsumosBodegasConstantesFunciones.LABEL_NOMBRELINEAGRUPO);
			reporte.setsDescripcion(ConsumosBodegasConstantesFunciones.LABEL_NOMBRELINEAGRUPO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ConsumosBodegasConstantesFunciones.LABEL_NOMBRELINEACATEGORIA);
			reporte.setsDescripcion(ConsumosBodegasConstantesFunciones.LABEL_NOMBRELINEACATEGORIA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ConsumosBodegasConstantesFunciones.LABEL_NOMBRELINEAMARCA);
			reporte.setsDescripcion(ConsumosBodegasConstantesFunciones.LABEL_NOMBRELINEAMARCA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(ConsumosBodegasConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(ConsumosBodegasConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesConsumosBodegas(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesConsumosBodegas(ConsumosBodegas consumosbodegasAux) throws Exception {
		
			consumosbodegasAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(consumosbodegasAux.getEmpresa()));
			consumosbodegasAux.settransaccion_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(consumosbodegasAux.getTransaccion()));
			consumosbodegasAux.setlinea_descripcion(LineaConstantesFunciones.getLineaDescripcion(consumosbodegasAux.getLinea()));
			consumosbodegasAux.setlineagrupo_descripcion(LineaConstantesFunciones.getLineaDescripcion(consumosbodegasAux.getLineaGrupo()));
			consumosbodegasAux.setlineacategoria_descripcion(LineaConstantesFunciones.getLineaDescripcion(consumosbodegasAux.getLineaCategoria()));
			consumosbodegasAux.setlineamarca_descripcion(LineaConstantesFunciones.getLineaDescripcion(consumosbodegasAux.getLineaMarca()));		
	}
	
	public static void refrescarForeignKeysDescripcionesConsumosBodegas(List<ConsumosBodegas> consumosbodegassTemp) throws Exception {
		for(ConsumosBodegas consumosbodegasAux:consumosbodegassTemp) {
			
			consumosbodegasAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(consumosbodegasAux.getEmpresa()));
			consumosbodegasAux.settransaccion_descripcion(TransaccionConstantesFunciones.getTransaccionDescripcion(consumosbodegasAux.getTransaccion()));
			consumosbodegasAux.setlinea_descripcion(LineaConstantesFunciones.getLineaDescripcion(consumosbodegasAux.getLinea()));
			consumosbodegasAux.setlineagrupo_descripcion(LineaConstantesFunciones.getLineaDescripcion(consumosbodegasAux.getLineaGrupo()));
			consumosbodegasAux.setlineacategoria_descripcion(LineaConstantesFunciones.getLineaDescripcion(consumosbodegasAux.getLineaCategoria()));
			consumosbodegasAux.setlineamarca_descripcion(LineaConstantesFunciones.getLineaDescripcion(consumosbodegasAux.getLineaMarca()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfConsumosBodegas(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Transaccion.class));
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
					if(clas.clas.equals(Transaccion.class)) {
						classes.add(new Classe(Transaccion.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfConsumosBodegas(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Transaccion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transaccion.class)); continue;
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

					if(Transaccion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Transaccion.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfConsumosBodegas(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return ConsumosBodegasConstantesFunciones.getClassesRelationshipsOfConsumosBodegas(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfConsumosBodegas(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfConsumosBodegas(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return ConsumosBodegasConstantesFunciones.getClassesRelationshipsFromStringsOfConsumosBodegas(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfConsumosBodegas(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(ConsumosBodegas consumosbodegas,List<ConsumosBodegas> consumosbodegass,Boolean permiteQuitar) throws Exception {
	}
	
	public static void actualizarSelectedLista(ConsumosBodegas consumosbodegas,List<ConsumosBodegas> consumosbodegass) throws Exception {
		try	{			
			for(ConsumosBodegas consumosbodegasLocal:consumosbodegass) {
				if(consumosbodegasLocal.getId().equals(consumosbodegas.getId())) {
					consumosbodegasLocal.setIsSelected(consumosbodegas.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesConsumosBodegas(List<ConsumosBodegas> consumosbodegassAux) throws Exception {
		//this.consumosbodegassAux=consumosbodegassAux;
		
		for(ConsumosBodegas consumosbodegasAux:consumosbodegassAux) {
			if(consumosbodegasAux.getIsChanged()) {
				consumosbodegasAux.setIsChanged(false);
			}		
			
			if(consumosbodegasAux.getIsNew()) {
				consumosbodegasAux.setIsNew(false);
			}	
			
			if(consumosbodegasAux.getIsDeleted()) {
				consumosbodegasAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesConsumosBodegas(ConsumosBodegas consumosbodegasAux) throws Exception {
		//this.consumosbodegasAux=consumosbodegasAux;
		
			if(consumosbodegasAux.getIsChanged()) {
				consumosbodegasAux.setIsChanged(false);
			}		
			
			if(consumosbodegasAux.getIsNew()) {
				consumosbodegasAux.setIsNew(false);
			}	
			
			if(consumosbodegasAux.getIsDeleted()) {
				consumosbodegasAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(ConsumosBodegas consumosbodegasAsignar,ConsumosBodegas consumosbodegas) throws Exception {
		consumosbodegasAsignar.setId(consumosbodegas.getId());	
		consumosbodegasAsignar.setVersionRow(consumosbodegas.getVersionRow());	
		consumosbodegasAsignar.setnombre_producto(consumosbodegas.getnombre_producto());	
		consumosbodegasAsignar.setnombre_unidad(consumosbodegas.getnombre_unidad());	
		consumosbodegasAsignar.setcantidad(consumosbodegas.getcantidad());	
		consumosbodegasAsignar.setcosto_total(consumosbodegas.getcosto_total());	
		consumosbodegasAsignar.setnombre_linea(consumosbodegas.getnombre_linea());	
		consumosbodegasAsignar.setnombre_linea_grupo(consumosbodegas.getnombre_linea_grupo());	
		consumosbodegasAsignar.setnombre_linea_categoria(consumosbodegas.getnombre_linea_categoria());	
		consumosbodegasAsignar.setnombre_linea_marca(consumosbodegas.getnombre_linea_marca());	
		consumosbodegasAsignar.setcodigo(consumosbodegas.getcodigo());	
	}
	
	public static void inicializarConsumosBodegas(ConsumosBodegas consumosbodegas) throws Exception {
		try {
				consumosbodegas.setId(0L);	
					
				consumosbodegas.setnombre_producto("");	
				consumosbodegas.setnombre_unidad("");	
				consumosbodegas.setcantidad(0);	
				consumosbodegas.setcosto_total(0.0);	
				consumosbodegas.setnombre_linea("");	
				consumosbodegas.setnombre_linea_grupo("");	
				consumosbodegas.setnombre_linea_categoria("");	
				consumosbodegas.setnombre_linea_marca("");	
				consumosbodegas.setcodigo("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderConsumosBodegas(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(ConsumosBodegasConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConsumosBodegasConstantesFunciones.LABEL_IDTRANSACCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConsumosBodegasConstantesFunciones.LABEL_IDLINEA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConsumosBodegasConstantesFunciones.LABEL_IDLINEAGRUPO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConsumosBodegasConstantesFunciones.LABEL_IDLINEACATEGORIA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConsumosBodegasConstantesFunciones.LABEL_IDLINEAMARCA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConsumosBodegasConstantesFunciones.LABEL_FECHAEMISIONDESDE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConsumosBodegasConstantesFunciones.LABEL_FECHAEMISIONHASTA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConsumosBodegasConstantesFunciones.LABEL_NOMBREPRODUCTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConsumosBodegasConstantesFunciones.LABEL_NOMBREUNIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConsumosBodegasConstantesFunciones.LABEL_CANTIDAD);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConsumosBodegasConstantesFunciones.LABEL_COSTOTOTAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConsumosBodegasConstantesFunciones.LABEL_NOMBRELINEA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConsumosBodegasConstantesFunciones.LABEL_NOMBRELINEAGRUPO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConsumosBodegasConstantesFunciones.LABEL_NOMBRELINEACATEGORIA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConsumosBodegasConstantesFunciones.LABEL_NOMBRELINEAMARCA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(ConsumosBodegasConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataConsumosBodegas(String sTipo,Row row,Workbook workbook,ConsumosBodegas consumosbodegas,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(consumosbodegas.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(consumosbodegas.gettransaccion_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(consumosbodegas.getlinea_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(consumosbodegas.getlineagrupo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(consumosbodegas.getlineacategoria_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(consumosbodegas.getlineamarca_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(consumosbodegas.getfecha_emision_desde());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(consumosbodegas.getfecha_emision_hasta());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(consumosbodegas.getnombre_producto());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(consumosbodegas.getnombre_unidad());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(consumosbodegas.getcantidad());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(consumosbodegas.getcosto_total());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(consumosbodegas.getnombre_linea());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(consumosbodegas.getnombre_linea_grupo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(consumosbodegas.getnombre_linea_categoria());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(consumosbodegas.getnombre_linea_marca());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(consumosbodegas.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryConsumosBodegas="";
	
	public String getsFinalQueryConsumosBodegas() {
		return this.sFinalQueryConsumosBodegas;
	}
	
	public void setsFinalQueryConsumosBodegas(String sFinalQueryConsumosBodegas) {
		this.sFinalQueryConsumosBodegas= sFinalQueryConsumosBodegas;
	}
	
	public Border resaltarSeleccionarConsumosBodegas=null;
	
	public Border setResaltarSeleccionarConsumosBodegas(ParametroGeneralUsuario parametroGeneralUsuario/*ConsumosBodegasBeanSwingJInternalFrame consumosbodegasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//consumosbodegasBeanSwingJInternalFrame.jTtoolBarConsumosBodegas.setBorder(borderResaltar);
		
		this.resaltarSeleccionarConsumosBodegas= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarConsumosBodegas() {
		return this.resaltarSeleccionarConsumosBodegas;
	}
	
	public void setResaltarSeleccionarConsumosBodegas(Border borderResaltarSeleccionarConsumosBodegas) {
		this.resaltarSeleccionarConsumosBodegas= borderResaltarSeleccionarConsumosBodegas;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridConsumosBodegas=null;
	public Boolean mostraridConsumosBodegas=true;
	public Boolean activaridConsumosBodegas=true;

	public Border resaltarid_empresaConsumosBodegas=null;
	public Boolean mostrarid_empresaConsumosBodegas=true;
	public Boolean activarid_empresaConsumosBodegas=true;
	public Boolean cargarid_empresaConsumosBodegas=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaConsumosBodegas=false;//ConEventDepend=true

	public Border resaltarid_transaccionConsumosBodegas=null;
	public Boolean mostrarid_transaccionConsumosBodegas=true;
	public Boolean activarid_transaccionConsumosBodegas=true;
	public Boolean cargarid_transaccionConsumosBodegas=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_transaccionConsumosBodegas=false;//ConEventDepend=true

	public Border resaltarid_lineaConsumosBodegas=null;
	public Boolean mostrarid_lineaConsumosBodegas=true;
	public Boolean activarid_lineaConsumosBodegas=true;
	public Boolean cargarid_lineaConsumosBodegas=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_lineaConsumosBodegas=false;//ConEventDepend=true

	public Border resaltarid_linea_grupoConsumosBodegas=null;
	public Boolean mostrarid_linea_grupoConsumosBodegas=true;
	public Boolean activarid_linea_grupoConsumosBodegas=true;
	public Boolean cargarid_linea_grupoConsumosBodegas=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_linea_grupoConsumosBodegas=false;//ConEventDepend=true

	public Border resaltarid_linea_categoriaConsumosBodegas=null;
	public Boolean mostrarid_linea_categoriaConsumosBodegas=true;
	public Boolean activarid_linea_categoriaConsumosBodegas=true;
	public Boolean cargarid_linea_categoriaConsumosBodegas=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_linea_categoriaConsumosBodegas=false;//ConEventDepend=true

	public Border resaltarid_linea_marcaConsumosBodegas=null;
	public Boolean mostrarid_linea_marcaConsumosBodegas=true;
	public Boolean activarid_linea_marcaConsumosBodegas=true;
	public Boolean cargarid_linea_marcaConsumosBodegas=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_linea_marcaConsumosBodegas=false;//ConEventDepend=true

	public Border resaltarfecha_emision_desdeConsumosBodegas=null;
	public Boolean mostrarfecha_emision_desdeConsumosBodegas=true;
	public Boolean activarfecha_emision_desdeConsumosBodegas=true;

	public Border resaltarfecha_emision_hastaConsumosBodegas=null;
	public Boolean mostrarfecha_emision_hastaConsumosBodegas=true;
	public Boolean activarfecha_emision_hastaConsumosBodegas=true;

	public Border resaltarnombre_productoConsumosBodegas=null;
	public Boolean mostrarnombre_productoConsumosBodegas=true;
	public Boolean activarnombre_productoConsumosBodegas=true;

	public Border resaltarnombre_unidadConsumosBodegas=null;
	public Boolean mostrarnombre_unidadConsumosBodegas=true;
	public Boolean activarnombre_unidadConsumosBodegas=true;

	public Border resaltarcantidadConsumosBodegas=null;
	public Boolean mostrarcantidadConsumosBodegas=true;
	public Boolean activarcantidadConsumosBodegas=true;

	public Border resaltarcosto_totalConsumosBodegas=null;
	public Boolean mostrarcosto_totalConsumosBodegas=true;
	public Boolean activarcosto_totalConsumosBodegas=true;

	public Border resaltarnombre_lineaConsumosBodegas=null;
	public Boolean mostrarnombre_lineaConsumosBodegas=true;
	public Boolean activarnombre_lineaConsumosBodegas=true;

	public Border resaltarnombre_linea_grupoConsumosBodegas=null;
	public Boolean mostrarnombre_linea_grupoConsumosBodegas=true;
	public Boolean activarnombre_linea_grupoConsumosBodegas=true;

	public Border resaltarnombre_linea_categoriaConsumosBodegas=null;
	public Boolean mostrarnombre_linea_categoriaConsumosBodegas=true;
	public Boolean activarnombre_linea_categoriaConsumosBodegas=true;

	public Border resaltarnombre_linea_marcaConsumosBodegas=null;
	public Boolean mostrarnombre_linea_marcaConsumosBodegas=true;
	public Boolean activarnombre_linea_marcaConsumosBodegas=true;

	public Border resaltarcodigoConsumosBodegas=null;
	public Boolean mostrarcodigoConsumosBodegas=true;
	public Boolean activarcodigoConsumosBodegas=true;

	
	

	public Border setResaltaridConsumosBodegas(ParametroGeneralUsuario parametroGeneralUsuario/*ConsumosBodegasBeanSwingJInternalFrame consumosbodegasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//consumosbodegasBeanSwingJInternalFrame.jTtoolBarConsumosBodegas.setBorder(borderResaltar);
		
		this.resaltaridConsumosBodegas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridConsumosBodegas() {
		return this.resaltaridConsumosBodegas;
	}

	public void setResaltaridConsumosBodegas(Border borderResaltar) {
		this.resaltaridConsumosBodegas= borderResaltar;
	}

	public Boolean getMostraridConsumosBodegas() {
		return this.mostraridConsumosBodegas;
	}

	public void setMostraridConsumosBodegas(Boolean mostraridConsumosBodegas) {
		this.mostraridConsumosBodegas= mostraridConsumosBodegas;
	}

	public Boolean getActivaridConsumosBodegas() {
		return this.activaridConsumosBodegas;
	}

	public void setActivaridConsumosBodegas(Boolean activaridConsumosBodegas) {
		this.activaridConsumosBodegas= activaridConsumosBodegas;
	}

	public Border setResaltarid_empresaConsumosBodegas(ParametroGeneralUsuario parametroGeneralUsuario/*ConsumosBodegasBeanSwingJInternalFrame consumosbodegasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//consumosbodegasBeanSwingJInternalFrame.jTtoolBarConsumosBodegas.setBorder(borderResaltar);
		
		this.resaltarid_empresaConsumosBodegas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaConsumosBodegas() {
		return this.resaltarid_empresaConsumosBodegas;
	}

	public void setResaltarid_empresaConsumosBodegas(Border borderResaltar) {
		this.resaltarid_empresaConsumosBodegas= borderResaltar;
	}

	public Boolean getMostrarid_empresaConsumosBodegas() {
		return this.mostrarid_empresaConsumosBodegas;
	}

	public void setMostrarid_empresaConsumosBodegas(Boolean mostrarid_empresaConsumosBodegas) {
		this.mostrarid_empresaConsumosBodegas= mostrarid_empresaConsumosBodegas;
	}

	public Boolean getActivarid_empresaConsumosBodegas() {
		return this.activarid_empresaConsumosBodegas;
	}

	public void setActivarid_empresaConsumosBodegas(Boolean activarid_empresaConsumosBodegas) {
		this.activarid_empresaConsumosBodegas= activarid_empresaConsumosBodegas;
	}

	public Boolean getCargarid_empresaConsumosBodegas() {
		return this.cargarid_empresaConsumosBodegas;
	}

	public void setCargarid_empresaConsumosBodegas(Boolean cargarid_empresaConsumosBodegas) {
		this.cargarid_empresaConsumosBodegas= cargarid_empresaConsumosBodegas;
	}

	public Border setResaltarid_transaccionConsumosBodegas(ParametroGeneralUsuario parametroGeneralUsuario/*ConsumosBodegasBeanSwingJInternalFrame consumosbodegasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//consumosbodegasBeanSwingJInternalFrame.jTtoolBarConsumosBodegas.setBorder(borderResaltar);
		
		this.resaltarid_transaccionConsumosBodegas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_transaccionConsumosBodegas() {
		return this.resaltarid_transaccionConsumosBodegas;
	}

	public void setResaltarid_transaccionConsumosBodegas(Border borderResaltar) {
		this.resaltarid_transaccionConsumosBodegas= borderResaltar;
	}

	public Boolean getMostrarid_transaccionConsumosBodegas() {
		return this.mostrarid_transaccionConsumosBodegas;
	}

	public void setMostrarid_transaccionConsumosBodegas(Boolean mostrarid_transaccionConsumosBodegas) {
		this.mostrarid_transaccionConsumosBodegas= mostrarid_transaccionConsumosBodegas;
	}

	public Boolean getActivarid_transaccionConsumosBodegas() {
		return this.activarid_transaccionConsumosBodegas;
	}

	public void setActivarid_transaccionConsumosBodegas(Boolean activarid_transaccionConsumosBodegas) {
		this.activarid_transaccionConsumosBodegas= activarid_transaccionConsumosBodegas;
	}

	public Boolean getCargarid_transaccionConsumosBodegas() {
		return this.cargarid_transaccionConsumosBodegas;
	}

	public void setCargarid_transaccionConsumosBodegas(Boolean cargarid_transaccionConsumosBodegas) {
		this.cargarid_transaccionConsumosBodegas= cargarid_transaccionConsumosBodegas;
	}

	public Border setResaltarid_lineaConsumosBodegas(ParametroGeneralUsuario parametroGeneralUsuario/*ConsumosBodegasBeanSwingJInternalFrame consumosbodegasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//consumosbodegasBeanSwingJInternalFrame.jTtoolBarConsumosBodegas.setBorder(borderResaltar);
		
		this.resaltarid_lineaConsumosBodegas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_lineaConsumosBodegas() {
		return this.resaltarid_lineaConsumosBodegas;
	}

	public void setResaltarid_lineaConsumosBodegas(Border borderResaltar) {
		this.resaltarid_lineaConsumosBodegas= borderResaltar;
	}

	public Boolean getMostrarid_lineaConsumosBodegas() {
		return this.mostrarid_lineaConsumosBodegas;
	}

	public void setMostrarid_lineaConsumosBodegas(Boolean mostrarid_lineaConsumosBodegas) {
		this.mostrarid_lineaConsumosBodegas= mostrarid_lineaConsumosBodegas;
	}

	public Boolean getActivarid_lineaConsumosBodegas() {
		return this.activarid_lineaConsumosBodegas;
	}

	public void setActivarid_lineaConsumosBodegas(Boolean activarid_lineaConsumosBodegas) {
		this.activarid_lineaConsumosBodegas= activarid_lineaConsumosBodegas;
	}

	public Boolean getCargarid_lineaConsumosBodegas() {
		return this.cargarid_lineaConsumosBodegas;
	}

	public void setCargarid_lineaConsumosBodegas(Boolean cargarid_lineaConsumosBodegas) {
		this.cargarid_lineaConsumosBodegas= cargarid_lineaConsumosBodegas;
	}

	public Border setResaltarid_linea_grupoConsumosBodegas(ParametroGeneralUsuario parametroGeneralUsuario/*ConsumosBodegasBeanSwingJInternalFrame consumosbodegasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//consumosbodegasBeanSwingJInternalFrame.jTtoolBarConsumosBodegas.setBorder(borderResaltar);
		
		this.resaltarid_linea_grupoConsumosBodegas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_linea_grupoConsumosBodegas() {
		return this.resaltarid_linea_grupoConsumosBodegas;
	}

	public void setResaltarid_linea_grupoConsumosBodegas(Border borderResaltar) {
		this.resaltarid_linea_grupoConsumosBodegas= borderResaltar;
	}

	public Boolean getMostrarid_linea_grupoConsumosBodegas() {
		return this.mostrarid_linea_grupoConsumosBodegas;
	}

	public void setMostrarid_linea_grupoConsumosBodegas(Boolean mostrarid_linea_grupoConsumosBodegas) {
		this.mostrarid_linea_grupoConsumosBodegas= mostrarid_linea_grupoConsumosBodegas;
	}

	public Boolean getActivarid_linea_grupoConsumosBodegas() {
		return this.activarid_linea_grupoConsumosBodegas;
	}

	public void setActivarid_linea_grupoConsumosBodegas(Boolean activarid_linea_grupoConsumosBodegas) {
		this.activarid_linea_grupoConsumosBodegas= activarid_linea_grupoConsumosBodegas;
	}

	public Boolean getCargarid_linea_grupoConsumosBodegas() {
		return this.cargarid_linea_grupoConsumosBodegas;
	}

	public void setCargarid_linea_grupoConsumosBodegas(Boolean cargarid_linea_grupoConsumosBodegas) {
		this.cargarid_linea_grupoConsumosBodegas= cargarid_linea_grupoConsumosBodegas;
	}

	public Border setResaltarid_linea_categoriaConsumosBodegas(ParametroGeneralUsuario parametroGeneralUsuario/*ConsumosBodegasBeanSwingJInternalFrame consumosbodegasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//consumosbodegasBeanSwingJInternalFrame.jTtoolBarConsumosBodegas.setBorder(borderResaltar);
		
		this.resaltarid_linea_categoriaConsumosBodegas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_linea_categoriaConsumosBodegas() {
		return this.resaltarid_linea_categoriaConsumosBodegas;
	}

	public void setResaltarid_linea_categoriaConsumosBodegas(Border borderResaltar) {
		this.resaltarid_linea_categoriaConsumosBodegas= borderResaltar;
	}

	public Boolean getMostrarid_linea_categoriaConsumosBodegas() {
		return this.mostrarid_linea_categoriaConsumosBodegas;
	}

	public void setMostrarid_linea_categoriaConsumosBodegas(Boolean mostrarid_linea_categoriaConsumosBodegas) {
		this.mostrarid_linea_categoriaConsumosBodegas= mostrarid_linea_categoriaConsumosBodegas;
	}

	public Boolean getActivarid_linea_categoriaConsumosBodegas() {
		return this.activarid_linea_categoriaConsumosBodegas;
	}

	public void setActivarid_linea_categoriaConsumosBodegas(Boolean activarid_linea_categoriaConsumosBodegas) {
		this.activarid_linea_categoriaConsumosBodegas= activarid_linea_categoriaConsumosBodegas;
	}

	public Boolean getCargarid_linea_categoriaConsumosBodegas() {
		return this.cargarid_linea_categoriaConsumosBodegas;
	}

	public void setCargarid_linea_categoriaConsumosBodegas(Boolean cargarid_linea_categoriaConsumosBodegas) {
		this.cargarid_linea_categoriaConsumosBodegas= cargarid_linea_categoriaConsumosBodegas;
	}

	public Border setResaltarid_linea_marcaConsumosBodegas(ParametroGeneralUsuario parametroGeneralUsuario/*ConsumosBodegasBeanSwingJInternalFrame consumosbodegasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//consumosbodegasBeanSwingJInternalFrame.jTtoolBarConsumosBodegas.setBorder(borderResaltar);
		
		this.resaltarid_linea_marcaConsumosBodegas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_linea_marcaConsumosBodegas() {
		return this.resaltarid_linea_marcaConsumosBodegas;
	}

	public void setResaltarid_linea_marcaConsumosBodegas(Border borderResaltar) {
		this.resaltarid_linea_marcaConsumosBodegas= borderResaltar;
	}

	public Boolean getMostrarid_linea_marcaConsumosBodegas() {
		return this.mostrarid_linea_marcaConsumosBodegas;
	}

	public void setMostrarid_linea_marcaConsumosBodegas(Boolean mostrarid_linea_marcaConsumosBodegas) {
		this.mostrarid_linea_marcaConsumosBodegas= mostrarid_linea_marcaConsumosBodegas;
	}

	public Boolean getActivarid_linea_marcaConsumosBodegas() {
		return this.activarid_linea_marcaConsumosBodegas;
	}

	public void setActivarid_linea_marcaConsumosBodegas(Boolean activarid_linea_marcaConsumosBodegas) {
		this.activarid_linea_marcaConsumosBodegas= activarid_linea_marcaConsumosBodegas;
	}

	public Boolean getCargarid_linea_marcaConsumosBodegas() {
		return this.cargarid_linea_marcaConsumosBodegas;
	}

	public void setCargarid_linea_marcaConsumosBodegas(Boolean cargarid_linea_marcaConsumosBodegas) {
		this.cargarid_linea_marcaConsumosBodegas= cargarid_linea_marcaConsumosBodegas;
	}

	public Border setResaltarfecha_emision_desdeConsumosBodegas(ParametroGeneralUsuario parametroGeneralUsuario/*ConsumosBodegasBeanSwingJInternalFrame consumosbodegasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//consumosbodegasBeanSwingJInternalFrame.jTtoolBarConsumosBodegas.setBorder(borderResaltar);
		
		this.resaltarfecha_emision_desdeConsumosBodegas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emision_desdeConsumosBodegas() {
		return this.resaltarfecha_emision_desdeConsumosBodegas;
	}

	public void setResaltarfecha_emision_desdeConsumosBodegas(Border borderResaltar) {
		this.resaltarfecha_emision_desdeConsumosBodegas= borderResaltar;
	}

	public Boolean getMostrarfecha_emision_desdeConsumosBodegas() {
		return this.mostrarfecha_emision_desdeConsumosBodegas;
	}

	public void setMostrarfecha_emision_desdeConsumosBodegas(Boolean mostrarfecha_emision_desdeConsumosBodegas) {
		this.mostrarfecha_emision_desdeConsumosBodegas= mostrarfecha_emision_desdeConsumosBodegas;
	}

	public Boolean getActivarfecha_emision_desdeConsumosBodegas() {
		return this.activarfecha_emision_desdeConsumosBodegas;
	}

	public void setActivarfecha_emision_desdeConsumosBodegas(Boolean activarfecha_emision_desdeConsumosBodegas) {
		this.activarfecha_emision_desdeConsumosBodegas= activarfecha_emision_desdeConsumosBodegas;
	}

	public Border setResaltarfecha_emision_hastaConsumosBodegas(ParametroGeneralUsuario parametroGeneralUsuario/*ConsumosBodegasBeanSwingJInternalFrame consumosbodegasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//consumosbodegasBeanSwingJInternalFrame.jTtoolBarConsumosBodegas.setBorder(borderResaltar);
		
		this.resaltarfecha_emision_hastaConsumosBodegas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_emision_hastaConsumosBodegas() {
		return this.resaltarfecha_emision_hastaConsumosBodegas;
	}

	public void setResaltarfecha_emision_hastaConsumosBodegas(Border borderResaltar) {
		this.resaltarfecha_emision_hastaConsumosBodegas= borderResaltar;
	}

	public Boolean getMostrarfecha_emision_hastaConsumosBodegas() {
		return this.mostrarfecha_emision_hastaConsumosBodegas;
	}

	public void setMostrarfecha_emision_hastaConsumosBodegas(Boolean mostrarfecha_emision_hastaConsumosBodegas) {
		this.mostrarfecha_emision_hastaConsumosBodegas= mostrarfecha_emision_hastaConsumosBodegas;
	}

	public Boolean getActivarfecha_emision_hastaConsumosBodegas() {
		return this.activarfecha_emision_hastaConsumosBodegas;
	}

	public void setActivarfecha_emision_hastaConsumosBodegas(Boolean activarfecha_emision_hastaConsumosBodegas) {
		this.activarfecha_emision_hastaConsumosBodegas= activarfecha_emision_hastaConsumosBodegas;
	}

	public Border setResaltarnombre_productoConsumosBodegas(ParametroGeneralUsuario parametroGeneralUsuario/*ConsumosBodegasBeanSwingJInternalFrame consumosbodegasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//consumosbodegasBeanSwingJInternalFrame.jTtoolBarConsumosBodegas.setBorder(borderResaltar);
		
		this.resaltarnombre_productoConsumosBodegas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_productoConsumosBodegas() {
		return this.resaltarnombre_productoConsumosBodegas;
	}

	public void setResaltarnombre_productoConsumosBodegas(Border borderResaltar) {
		this.resaltarnombre_productoConsumosBodegas= borderResaltar;
	}

	public Boolean getMostrarnombre_productoConsumosBodegas() {
		return this.mostrarnombre_productoConsumosBodegas;
	}

	public void setMostrarnombre_productoConsumosBodegas(Boolean mostrarnombre_productoConsumosBodegas) {
		this.mostrarnombre_productoConsumosBodegas= mostrarnombre_productoConsumosBodegas;
	}

	public Boolean getActivarnombre_productoConsumosBodegas() {
		return this.activarnombre_productoConsumosBodegas;
	}

	public void setActivarnombre_productoConsumosBodegas(Boolean activarnombre_productoConsumosBodegas) {
		this.activarnombre_productoConsumosBodegas= activarnombre_productoConsumosBodegas;
	}

	public Border setResaltarnombre_unidadConsumosBodegas(ParametroGeneralUsuario parametroGeneralUsuario/*ConsumosBodegasBeanSwingJInternalFrame consumosbodegasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//consumosbodegasBeanSwingJInternalFrame.jTtoolBarConsumosBodegas.setBorder(borderResaltar);
		
		this.resaltarnombre_unidadConsumosBodegas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_unidadConsumosBodegas() {
		return this.resaltarnombre_unidadConsumosBodegas;
	}

	public void setResaltarnombre_unidadConsumosBodegas(Border borderResaltar) {
		this.resaltarnombre_unidadConsumosBodegas= borderResaltar;
	}

	public Boolean getMostrarnombre_unidadConsumosBodegas() {
		return this.mostrarnombre_unidadConsumosBodegas;
	}

	public void setMostrarnombre_unidadConsumosBodegas(Boolean mostrarnombre_unidadConsumosBodegas) {
		this.mostrarnombre_unidadConsumosBodegas= mostrarnombre_unidadConsumosBodegas;
	}

	public Boolean getActivarnombre_unidadConsumosBodegas() {
		return this.activarnombre_unidadConsumosBodegas;
	}

	public void setActivarnombre_unidadConsumosBodegas(Boolean activarnombre_unidadConsumosBodegas) {
		this.activarnombre_unidadConsumosBodegas= activarnombre_unidadConsumosBodegas;
	}

	public Border setResaltarcantidadConsumosBodegas(ParametroGeneralUsuario parametroGeneralUsuario/*ConsumosBodegasBeanSwingJInternalFrame consumosbodegasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//consumosbodegasBeanSwingJInternalFrame.jTtoolBarConsumosBodegas.setBorder(borderResaltar);
		
		this.resaltarcantidadConsumosBodegas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcantidadConsumosBodegas() {
		return this.resaltarcantidadConsumosBodegas;
	}

	public void setResaltarcantidadConsumosBodegas(Border borderResaltar) {
		this.resaltarcantidadConsumosBodegas= borderResaltar;
	}

	public Boolean getMostrarcantidadConsumosBodegas() {
		return this.mostrarcantidadConsumosBodegas;
	}

	public void setMostrarcantidadConsumosBodegas(Boolean mostrarcantidadConsumosBodegas) {
		this.mostrarcantidadConsumosBodegas= mostrarcantidadConsumosBodegas;
	}

	public Boolean getActivarcantidadConsumosBodegas() {
		return this.activarcantidadConsumosBodegas;
	}

	public void setActivarcantidadConsumosBodegas(Boolean activarcantidadConsumosBodegas) {
		this.activarcantidadConsumosBodegas= activarcantidadConsumosBodegas;
	}

	public Border setResaltarcosto_totalConsumosBodegas(ParametroGeneralUsuario parametroGeneralUsuario/*ConsumosBodegasBeanSwingJInternalFrame consumosbodegasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//consumosbodegasBeanSwingJInternalFrame.jTtoolBarConsumosBodegas.setBorder(borderResaltar);
		
		this.resaltarcosto_totalConsumosBodegas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcosto_totalConsumosBodegas() {
		return this.resaltarcosto_totalConsumosBodegas;
	}

	public void setResaltarcosto_totalConsumosBodegas(Border borderResaltar) {
		this.resaltarcosto_totalConsumosBodegas= borderResaltar;
	}

	public Boolean getMostrarcosto_totalConsumosBodegas() {
		return this.mostrarcosto_totalConsumosBodegas;
	}

	public void setMostrarcosto_totalConsumosBodegas(Boolean mostrarcosto_totalConsumosBodegas) {
		this.mostrarcosto_totalConsumosBodegas= mostrarcosto_totalConsumosBodegas;
	}

	public Boolean getActivarcosto_totalConsumosBodegas() {
		return this.activarcosto_totalConsumosBodegas;
	}

	public void setActivarcosto_totalConsumosBodegas(Boolean activarcosto_totalConsumosBodegas) {
		this.activarcosto_totalConsumosBodegas= activarcosto_totalConsumosBodegas;
	}

	public Border setResaltarnombre_lineaConsumosBodegas(ParametroGeneralUsuario parametroGeneralUsuario/*ConsumosBodegasBeanSwingJInternalFrame consumosbodegasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//consumosbodegasBeanSwingJInternalFrame.jTtoolBarConsumosBodegas.setBorder(borderResaltar);
		
		this.resaltarnombre_lineaConsumosBodegas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_lineaConsumosBodegas() {
		return this.resaltarnombre_lineaConsumosBodegas;
	}

	public void setResaltarnombre_lineaConsumosBodegas(Border borderResaltar) {
		this.resaltarnombre_lineaConsumosBodegas= borderResaltar;
	}

	public Boolean getMostrarnombre_lineaConsumosBodegas() {
		return this.mostrarnombre_lineaConsumosBodegas;
	}

	public void setMostrarnombre_lineaConsumosBodegas(Boolean mostrarnombre_lineaConsumosBodegas) {
		this.mostrarnombre_lineaConsumosBodegas= mostrarnombre_lineaConsumosBodegas;
	}

	public Boolean getActivarnombre_lineaConsumosBodegas() {
		return this.activarnombre_lineaConsumosBodegas;
	}

	public void setActivarnombre_lineaConsumosBodegas(Boolean activarnombre_lineaConsumosBodegas) {
		this.activarnombre_lineaConsumosBodegas= activarnombre_lineaConsumosBodegas;
	}

	public Border setResaltarnombre_linea_grupoConsumosBodegas(ParametroGeneralUsuario parametroGeneralUsuario/*ConsumosBodegasBeanSwingJInternalFrame consumosbodegasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//consumosbodegasBeanSwingJInternalFrame.jTtoolBarConsumosBodegas.setBorder(borderResaltar);
		
		this.resaltarnombre_linea_grupoConsumosBodegas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_linea_grupoConsumosBodegas() {
		return this.resaltarnombre_linea_grupoConsumosBodegas;
	}

	public void setResaltarnombre_linea_grupoConsumosBodegas(Border borderResaltar) {
		this.resaltarnombre_linea_grupoConsumosBodegas= borderResaltar;
	}

	public Boolean getMostrarnombre_linea_grupoConsumosBodegas() {
		return this.mostrarnombre_linea_grupoConsumosBodegas;
	}

	public void setMostrarnombre_linea_grupoConsumosBodegas(Boolean mostrarnombre_linea_grupoConsumosBodegas) {
		this.mostrarnombre_linea_grupoConsumosBodegas= mostrarnombre_linea_grupoConsumosBodegas;
	}

	public Boolean getActivarnombre_linea_grupoConsumosBodegas() {
		return this.activarnombre_linea_grupoConsumosBodegas;
	}

	public void setActivarnombre_linea_grupoConsumosBodegas(Boolean activarnombre_linea_grupoConsumosBodegas) {
		this.activarnombre_linea_grupoConsumosBodegas= activarnombre_linea_grupoConsumosBodegas;
	}

	public Border setResaltarnombre_linea_categoriaConsumosBodegas(ParametroGeneralUsuario parametroGeneralUsuario/*ConsumosBodegasBeanSwingJInternalFrame consumosbodegasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//consumosbodegasBeanSwingJInternalFrame.jTtoolBarConsumosBodegas.setBorder(borderResaltar);
		
		this.resaltarnombre_linea_categoriaConsumosBodegas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_linea_categoriaConsumosBodegas() {
		return this.resaltarnombre_linea_categoriaConsumosBodegas;
	}

	public void setResaltarnombre_linea_categoriaConsumosBodegas(Border borderResaltar) {
		this.resaltarnombre_linea_categoriaConsumosBodegas= borderResaltar;
	}

	public Boolean getMostrarnombre_linea_categoriaConsumosBodegas() {
		return this.mostrarnombre_linea_categoriaConsumosBodegas;
	}

	public void setMostrarnombre_linea_categoriaConsumosBodegas(Boolean mostrarnombre_linea_categoriaConsumosBodegas) {
		this.mostrarnombre_linea_categoriaConsumosBodegas= mostrarnombre_linea_categoriaConsumosBodegas;
	}

	public Boolean getActivarnombre_linea_categoriaConsumosBodegas() {
		return this.activarnombre_linea_categoriaConsumosBodegas;
	}

	public void setActivarnombre_linea_categoriaConsumosBodegas(Boolean activarnombre_linea_categoriaConsumosBodegas) {
		this.activarnombre_linea_categoriaConsumosBodegas= activarnombre_linea_categoriaConsumosBodegas;
	}

	public Border setResaltarnombre_linea_marcaConsumosBodegas(ParametroGeneralUsuario parametroGeneralUsuario/*ConsumosBodegasBeanSwingJInternalFrame consumosbodegasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//consumosbodegasBeanSwingJInternalFrame.jTtoolBarConsumosBodegas.setBorder(borderResaltar);
		
		this.resaltarnombre_linea_marcaConsumosBodegas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombre_linea_marcaConsumosBodegas() {
		return this.resaltarnombre_linea_marcaConsumosBodegas;
	}

	public void setResaltarnombre_linea_marcaConsumosBodegas(Border borderResaltar) {
		this.resaltarnombre_linea_marcaConsumosBodegas= borderResaltar;
	}

	public Boolean getMostrarnombre_linea_marcaConsumosBodegas() {
		return this.mostrarnombre_linea_marcaConsumosBodegas;
	}

	public void setMostrarnombre_linea_marcaConsumosBodegas(Boolean mostrarnombre_linea_marcaConsumosBodegas) {
		this.mostrarnombre_linea_marcaConsumosBodegas= mostrarnombre_linea_marcaConsumosBodegas;
	}

	public Boolean getActivarnombre_linea_marcaConsumosBodegas() {
		return this.activarnombre_linea_marcaConsumosBodegas;
	}

	public void setActivarnombre_linea_marcaConsumosBodegas(Boolean activarnombre_linea_marcaConsumosBodegas) {
		this.activarnombre_linea_marcaConsumosBodegas= activarnombre_linea_marcaConsumosBodegas;
	}

	public Border setResaltarcodigoConsumosBodegas(ParametroGeneralUsuario parametroGeneralUsuario/*ConsumosBodegasBeanSwingJInternalFrame consumosbodegasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//consumosbodegasBeanSwingJInternalFrame.jTtoolBarConsumosBodegas.setBorder(borderResaltar);
		
		this.resaltarcodigoConsumosBodegas= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoConsumosBodegas() {
		return this.resaltarcodigoConsumosBodegas;
	}

	public void setResaltarcodigoConsumosBodegas(Border borderResaltar) {
		this.resaltarcodigoConsumosBodegas= borderResaltar;
	}

	public Boolean getMostrarcodigoConsumosBodegas() {
		return this.mostrarcodigoConsumosBodegas;
	}

	public void setMostrarcodigoConsumosBodegas(Boolean mostrarcodigoConsumosBodegas) {
		this.mostrarcodigoConsumosBodegas= mostrarcodigoConsumosBodegas;
	}

	public Boolean getActivarcodigoConsumosBodegas() {
		return this.activarcodigoConsumosBodegas;
	}

	public void setActivarcodigoConsumosBodegas(Boolean activarcodigoConsumosBodegas) {
		this.activarcodigoConsumosBodegas= activarcodigoConsumosBodegas;
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
		
		
		this.setMostraridConsumosBodegas(esInicial);
		this.setMostrarid_empresaConsumosBodegas(esInicial);
		this.setMostrarid_transaccionConsumosBodegas(esInicial);
		this.setMostrarid_lineaConsumosBodegas(esInicial);
		this.setMostrarid_linea_grupoConsumosBodegas(esInicial);
		this.setMostrarid_linea_categoriaConsumosBodegas(esInicial);
		this.setMostrarid_linea_marcaConsumosBodegas(esInicial);
		this.setMostrarfecha_emision_desdeConsumosBodegas(esInicial);
		this.setMostrarfecha_emision_hastaConsumosBodegas(esInicial);
		this.setMostrarnombre_productoConsumosBodegas(esInicial);
		this.setMostrarnombre_unidadConsumosBodegas(esInicial);
		this.setMostrarcantidadConsumosBodegas(esInicial);
		this.setMostrarcosto_totalConsumosBodegas(esInicial);
		this.setMostrarnombre_lineaConsumosBodegas(esInicial);
		this.setMostrarnombre_linea_grupoConsumosBodegas(esInicial);
		this.setMostrarnombre_linea_categoriaConsumosBodegas(esInicial);
		this.setMostrarnombre_linea_marcaConsumosBodegas(esInicial);
		this.setMostrarcodigoConsumosBodegas(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ConsumosBodegasConstantesFunciones.ID)) {
				this.setMostraridConsumosBodegas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsumosBodegasConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaConsumosBodegas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsumosBodegasConstantesFunciones.IDTRANSACCION)) {
				this.setMostrarid_transaccionConsumosBodegas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsumosBodegasConstantesFunciones.IDLINEA)) {
				this.setMostrarid_lineaConsumosBodegas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsumosBodegasConstantesFunciones.IDLINEAGRUPO)) {
				this.setMostrarid_linea_grupoConsumosBodegas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsumosBodegasConstantesFunciones.IDLINEACATEGORIA)) {
				this.setMostrarid_linea_categoriaConsumosBodegas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsumosBodegasConstantesFunciones.IDLINEAMARCA)) {
				this.setMostrarid_linea_marcaConsumosBodegas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsumosBodegasConstantesFunciones.FECHAEMISIONDESDE)) {
				this.setMostrarfecha_emision_desdeConsumosBodegas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsumosBodegasConstantesFunciones.FECHAEMISIONHASTA)) {
				this.setMostrarfecha_emision_hastaConsumosBodegas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsumosBodegasConstantesFunciones.NOMBREPRODUCTO)) {
				this.setMostrarnombre_productoConsumosBodegas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsumosBodegasConstantesFunciones.NOMBREUNIDAD)) {
				this.setMostrarnombre_unidadConsumosBodegas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsumosBodegasConstantesFunciones.CANTIDAD)) {
				this.setMostrarcantidadConsumosBodegas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsumosBodegasConstantesFunciones.COSTOTOTAL)) {
				this.setMostrarcosto_totalConsumosBodegas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsumosBodegasConstantesFunciones.NOMBRELINEA)) {
				this.setMostrarnombre_lineaConsumosBodegas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsumosBodegasConstantesFunciones.NOMBRELINEAGRUPO)) {
				this.setMostrarnombre_linea_grupoConsumosBodegas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsumosBodegasConstantesFunciones.NOMBRELINEACATEGORIA)) {
				this.setMostrarnombre_linea_categoriaConsumosBodegas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsumosBodegasConstantesFunciones.NOMBRELINEAMARCA)) {
				this.setMostrarnombre_linea_marcaConsumosBodegas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsumosBodegasConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoConsumosBodegas(esAsigna);
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
		
		
		this.setActivaridConsumosBodegas(esInicial);
		this.setActivarid_empresaConsumosBodegas(esInicial);
		this.setActivarid_transaccionConsumosBodegas(esInicial);
		this.setActivarid_lineaConsumosBodegas(esInicial);
		this.setActivarid_linea_grupoConsumosBodegas(esInicial);
		this.setActivarid_linea_categoriaConsumosBodegas(esInicial);
		this.setActivarid_linea_marcaConsumosBodegas(esInicial);
		this.setActivarfecha_emision_desdeConsumosBodegas(esInicial);
		this.setActivarfecha_emision_hastaConsumosBodegas(esInicial);
		this.setActivarnombre_productoConsumosBodegas(esInicial);
		this.setActivarnombre_unidadConsumosBodegas(esInicial);
		this.setActivarcantidadConsumosBodegas(esInicial);
		this.setActivarcosto_totalConsumosBodegas(esInicial);
		this.setActivarnombre_lineaConsumosBodegas(esInicial);
		this.setActivarnombre_linea_grupoConsumosBodegas(esInicial);
		this.setActivarnombre_linea_categoriaConsumosBodegas(esInicial);
		this.setActivarnombre_linea_marcaConsumosBodegas(esInicial);
		this.setActivarcodigoConsumosBodegas(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ConsumosBodegasConstantesFunciones.ID)) {
				this.setActivaridConsumosBodegas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsumosBodegasConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaConsumosBodegas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsumosBodegasConstantesFunciones.IDTRANSACCION)) {
				this.setActivarid_transaccionConsumosBodegas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsumosBodegasConstantesFunciones.IDLINEA)) {
				this.setActivarid_lineaConsumosBodegas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsumosBodegasConstantesFunciones.IDLINEAGRUPO)) {
				this.setActivarid_linea_grupoConsumosBodegas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsumosBodegasConstantesFunciones.IDLINEACATEGORIA)) {
				this.setActivarid_linea_categoriaConsumosBodegas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsumosBodegasConstantesFunciones.IDLINEAMARCA)) {
				this.setActivarid_linea_marcaConsumosBodegas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsumosBodegasConstantesFunciones.FECHAEMISIONDESDE)) {
				this.setActivarfecha_emision_desdeConsumosBodegas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsumosBodegasConstantesFunciones.FECHAEMISIONHASTA)) {
				this.setActivarfecha_emision_hastaConsumosBodegas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsumosBodegasConstantesFunciones.NOMBREPRODUCTO)) {
				this.setActivarnombre_productoConsumosBodegas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsumosBodegasConstantesFunciones.NOMBREUNIDAD)) {
				this.setActivarnombre_unidadConsumosBodegas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsumosBodegasConstantesFunciones.CANTIDAD)) {
				this.setActivarcantidadConsumosBodegas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsumosBodegasConstantesFunciones.COSTOTOTAL)) {
				this.setActivarcosto_totalConsumosBodegas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsumosBodegasConstantesFunciones.NOMBRELINEA)) {
				this.setActivarnombre_lineaConsumosBodegas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsumosBodegasConstantesFunciones.NOMBRELINEAGRUPO)) {
				this.setActivarnombre_linea_grupoConsumosBodegas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsumosBodegasConstantesFunciones.NOMBRELINEACATEGORIA)) {
				this.setActivarnombre_linea_categoriaConsumosBodegas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsumosBodegasConstantesFunciones.NOMBRELINEAMARCA)) {
				this.setActivarnombre_linea_marcaConsumosBodegas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsumosBodegasConstantesFunciones.CODIGO)) {
				this.setActivarcodigoConsumosBodegas(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,ConsumosBodegasBeanSwingJInternalFrame consumosbodegasBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridConsumosBodegas(esInicial);
		this.setResaltarid_empresaConsumosBodegas(esInicial);
		this.setResaltarid_transaccionConsumosBodegas(esInicial);
		this.setResaltarid_lineaConsumosBodegas(esInicial);
		this.setResaltarid_linea_grupoConsumosBodegas(esInicial);
		this.setResaltarid_linea_categoriaConsumosBodegas(esInicial);
		this.setResaltarid_linea_marcaConsumosBodegas(esInicial);
		this.setResaltarfecha_emision_desdeConsumosBodegas(esInicial);
		this.setResaltarfecha_emision_hastaConsumosBodegas(esInicial);
		this.setResaltarnombre_productoConsumosBodegas(esInicial);
		this.setResaltarnombre_unidadConsumosBodegas(esInicial);
		this.setResaltarcantidadConsumosBodegas(esInicial);
		this.setResaltarcosto_totalConsumosBodegas(esInicial);
		this.setResaltarnombre_lineaConsumosBodegas(esInicial);
		this.setResaltarnombre_linea_grupoConsumosBodegas(esInicial);
		this.setResaltarnombre_linea_categoriaConsumosBodegas(esInicial);
		this.setResaltarnombre_linea_marcaConsumosBodegas(esInicial);
		this.setResaltarcodigoConsumosBodegas(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(ConsumosBodegasConstantesFunciones.ID)) {
				this.setResaltaridConsumosBodegas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsumosBodegasConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaConsumosBodegas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsumosBodegasConstantesFunciones.IDTRANSACCION)) {
				this.setResaltarid_transaccionConsumosBodegas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsumosBodegasConstantesFunciones.IDLINEA)) {
				this.setResaltarid_lineaConsumosBodegas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsumosBodegasConstantesFunciones.IDLINEAGRUPO)) {
				this.setResaltarid_linea_grupoConsumosBodegas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsumosBodegasConstantesFunciones.IDLINEACATEGORIA)) {
				this.setResaltarid_linea_categoriaConsumosBodegas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsumosBodegasConstantesFunciones.IDLINEAMARCA)) {
				this.setResaltarid_linea_marcaConsumosBodegas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsumosBodegasConstantesFunciones.FECHAEMISIONDESDE)) {
				this.setResaltarfecha_emision_desdeConsumosBodegas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsumosBodegasConstantesFunciones.FECHAEMISIONHASTA)) {
				this.setResaltarfecha_emision_hastaConsumosBodegas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsumosBodegasConstantesFunciones.NOMBREPRODUCTO)) {
				this.setResaltarnombre_productoConsumosBodegas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsumosBodegasConstantesFunciones.NOMBREUNIDAD)) {
				this.setResaltarnombre_unidadConsumosBodegas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsumosBodegasConstantesFunciones.CANTIDAD)) {
				this.setResaltarcantidadConsumosBodegas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsumosBodegasConstantesFunciones.COSTOTOTAL)) {
				this.setResaltarcosto_totalConsumosBodegas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsumosBodegasConstantesFunciones.NOMBRELINEA)) {
				this.setResaltarnombre_lineaConsumosBodegas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsumosBodegasConstantesFunciones.NOMBRELINEAGRUPO)) {
				this.setResaltarnombre_linea_grupoConsumosBodegas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsumosBodegasConstantesFunciones.NOMBRELINEACATEGORIA)) {
				this.setResaltarnombre_linea_categoriaConsumosBodegas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsumosBodegasConstantesFunciones.NOMBRELINEAMARCA)) {
				this.setResaltarnombre_linea_marcaConsumosBodegas(esAsigna);
				continue;
			}

			if(campo.clase.equals(ConsumosBodegasConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoConsumosBodegas(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,ConsumosBodegasBeanSwingJInternalFrame consumosbodegasBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarBusquedaConsumosBodegasConsumosBodegas=true;

	public Boolean getMostrarBusquedaConsumosBodegasConsumosBodegas() {
		return this.mostrarBusquedaConsumosBodegasConsumosBodegas;
	}

	public void setMostrarBusquedaConsumosBodegasConsumosBodegas(Boolean visibilidadResaltar) {
		this.mostrarBusquedaConsumosBodegasConsumosBodegas= visibilidadResaltar;
	}	
	


	public Boolean activarBusquedaConsumosBodegasConsumosBodegas=true;

	public Boolean getActivarBusquedaConsumosBodegasConsumosBodegas() {
		return this.activarBusquedaConsumosBodegasConsumosBodegas;
	}

	public void setActivarBusquedaConsumosBodegasConsumosBodegas(Boolean habilitarResaltar) {
		this.activarBusquedaConsumosBodegasConsumosBodegas= habilitarResaltar;
	}	
	


	public Border resaltarBusquedaConsumosBodegasConsumosBodegas=null;

	public Border getResaltarBusquedaConsumosBodegasConsumosBodegas() {
		return this.resaltarBusquedaConsumosBodegasConsumosBodegas;
	}

	public void setResaltarBusquedaConsumosBodegasConsumosBodegas(Border borderResaltar) {
		this.resaltarBusquedaConsumosBodegasConsumosBodegas= borderResaltar;
	}

	public void setResaltarBusquedaConsumosBodegasConsumosBodegas(ParametroGeneralUsuario parametroGeneralUsuario/*ConsumosBodegasBeanSwingJInternalFrame consumosbodegasBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarBusquedaConsumosBodegasConsumosBodegas= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}