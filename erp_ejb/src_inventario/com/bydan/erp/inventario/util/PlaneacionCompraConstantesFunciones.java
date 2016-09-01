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
package com.bydan.erp.inventario.util;

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


import com.bydan.erp.inventario.util.PlaneacionCompraConstantesFunciones;
import com.bydan.erp.inventario.util.PlaneacionCompraParameterReturnGeneral;
//import com.bydan.erp.inventario.util.PlaneacionCompraParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.inventario.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.nomina.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.nomina.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.inventario.business.dataaccess.*;
//import com.bydan.erp.inventario.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class PlaneacionCompraConstantesFunciones extends PlaneacionCompraConstantesFuncionesAdditional {		
	
	
	
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
	
	
	public static final String SFINALQUERY=Constantes.SFINALQUERY;	
	public static final String SNOMBREOPCION="PlaneacionCompra";
	public static final String SPATHOPCION="Inventario";	
	public static final String SPATHMODULO="inventario/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="PlaneacionCompra"+PlaneacionCompraConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="PlaneacionCompraHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="PlaneacionCompraHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=PlaneacionCompraConstantesFunciones.SCHEMA+"_"+PlaneacionCompraConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/PlaneacionCompraHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=PlaneacionCompraConstantesFunciones.SCHEMA+"_"+PlaneacionCompraConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=PlaneacionCompraConstantesFunciones.SCHEMA+"_"+PlaneacionCompraConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/PlaneacionCompraHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=PlaneacionCompraConstantesFunciones.SCHEMA+"_"+PlaneacionCompraConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PlaneacionCompraConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/PlaneacionCompraHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PlaneacionCompraConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PlaneacionCompraConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/PlaneacionCompraHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+PlaneacionCompraConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=PlaneacionCompraConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+PlaneacionCompraConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=PlaneacionCompraConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+PlaneacionCompraConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Planeacion Compras";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Planeacion Compra";
	public static final String SCLASSWEBTITULO_LOWER="Planeacion Compra";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="PlaneacionCompra";
	public static final String OBJECTNAME="planeacioncompra";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_INVENTARIO;	
	public static final String TABLENAME="planeacion_compra";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select planeacioncompra from "+PlaneacionCompraConstantesFunciones.SPERSISTENCENAME+" planeacioncompra";
	public static String QUERYSELECTNATIVE="select "+PlaneacionCompraConstantesFunciones.SCHEMA+"."+PlaneacionCompraConstantesFunciones.TABLENAME+".id,"+PlaneacionCompraConstantesFunciones.SCHEMA+"."+PlaneacionCompraConstantesFunciones.TABLENAME+".version_row,"+PlaneacionCompraConstantesFunciones.SCHEMA+"."+PlaneacionCompraConstantesFunciones.TABLENAME+".id_empresa,"+PlaneacionCompraConstantesFunciones.SCHEMA+"."+PlaneacionCompraConstantesFunciones.TABLENAME+".id_sucursal,"+PlaneacionCompraConstantesFunciones.SCHEMA+"."+PlaneacionCompraConstantesFunciones.TABLENAME+".id_ejercicio,"+PlaneacionCompraConstantesFunciones.SCHEMA+"."+PlaneacionCompraConstantesFunciones.TABLENAME+".id_periodo,"+PlaneacionCompraConstantesFunciones.SCHEMA+"."+PlaneacionCompraConstantesFunciones.TABLENAME+".id_empleado,"+PlaneacionCompraConstantesFunciones.SCHEMA+"."+PlaneacionCompraConstantesFunciones.TABLENAME+".id_usuario,"+PlaneacionCompraConstantesFunciones.SCHEMA+"."+PlaneacionCompraConstantesFunciones.TABLENAME+".id_formato,"+PlaneacionCompraConstantesFunciones.SCHEMA+"."+PlaneacionCompraConstantesFunciones.TABLENAME+".numero_pre_impreso,"+PlaneacionCompraConstantesFunciones.SCHEMA+"."+PlaneacionCompraConstantesFunciones.TABLENAME+".fecha,"+PlaneacionCompraConstantesFunciones.SCHEMA+"."+PlaneacionCompraConstantesFunciones.TABLENAME+".id_mes_inicio,"+PlaneacionCompraConstantesFunciones.SCHEMA+"."+PlaneacionCompraConstantesFunciones.TABLENAME+".id_mes_fin,"+PlaneacionCompraConstantesFunciones.SCHEMA+"."+PlaneacionCompraConstantesFunciones.TABLENAME+".numero_meses,"+PlaneacionCompraConstantesFunciones.SCHEMA+"."+PlaneacionCompraConstantesFunciones.TABLENAME+".fecha_corte,"+PlaneacionCompraConstantesFunciones.SCHEMA+"."+PlaneacionCompraConstantesFunciones.TABLENAME+".codigo_pedido,"+PlaneacionCompraConstantesFunciones.SCHEMA+"."+PlaneacionCompraConstantesFunciones.TABLENAME+".descripcion1,"+PlaneacionCompraConstantesFunciones.SCHEMA+"."+PlaneacionCompraConstantesFunciones.TABLENAME+".descripcion2,"+PlaneacionCompraConstantesFunciones.SCHEMA+"."+PlaneacionCompraConstantesFunciones.TABLENAME+".descripcion3 from "+PlaneacionCompraConstantesFunciones.SCHEMA+"."+PlaneacionCompraConstantesFunciones.TABLENAME;//+" as "+PlaneacionCompraConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected PlaneacionCompraConstantesFuncionesAdditional planeacioncompraConstantesFuncionesAdditional=null;
	
	public PlaneacionCompraConstantesFuncionesAdditional getPlaneacionCompraConstantesFuncionesAdditional() {
		return this.planeacioncompraConstantesFuncionesAdditional;
	}
	
	public void setPlaneacionCompraConstantesFuncionesAdditional(PlaneacionCompraConstantesFuncionesAdditional planeacioncompraConstantesFuncionesAdditional) {
		try {
			this.planeacioncompraConstantesFuncionesAdditional=planeacioncompraConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDEJERCICIO= "id_ejercicio";
    public static final String IDPERIODO= "id_periodo";
    public static final String IDEMPLEADO= "id_empleado";
    public static final String IDUSUARIO= "id_usuario";
    public static final String IDFORMATO= "id_formato";
    public static final String NUMEROPREIMPRESO= "numero_pre_impreso";
    public static final String FECHA= "fecha";
    public static final String IDMESINICIO= "id_mes_inicio";
    public static final String IDMESFIN= "id_mes_fin";
    public static final String NUMEROMESES= "numero_meses";
    public static final String FECHACORTE= "fecha_corte";
    public static final String CODIGOPEDIDO= "codigo_pedido";
    public static final String DESCRIPCION1= "descripcion1";
    public static final String DESCRIPCION2= "descripcion2";
    public static final String DESCRIPCION3= "descripcion3";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Version Row";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDEJERCICIO= "Ejercicio";
		public static final String LABEL_IDEJERCICIO_LOWER= "Ejercicio";
    	public static final String LABEL_IDPERIODO= "Periodo";
		public static final String LABEL_IDPERIODO_LOWER= "Periodo";
    	public static final String LABEL_IDEMPLEADO= "Empleado";
		public static final String LABEL_IDEMPLEADO_LOWER= "Empleado";
    	public static final String LABEL_IDUSUARIO= "Usuario";
		public static final String LABEL_IDUSUARIO_LOWER= "Usuario";
    	public static final String LABEL_IDFORMATO= "Formato";
		public static final String LABEL_IDFORMATO_LOWER= "Formato";
    	public static final String LABEL_NUMEROPREIMPRESO= "Numero Pre Impreso";
		public static final String LABEL_NUMEROPREIMPRESO_LOWER= "Numero Pre Impreso";
    	public static final String LABEL_FECHA= "Fecha";
		public static final String LABEL_FECHA_LOWER= "Fecha";
    	public static final String LABEL_IDMESINICIO= "Mes Inicio";
		public static final String LABEL_IDMESINICIO_LOWER= "Mes Inicio";
    	public static final String LABEL_IDMESFIN= "Mes Fin";
		public static final String LABEL_IDMESFIN_LOWER= "Mes Fin";
    	public static final String LABEL_NUMEROMESES= "Numero Meses";
		public static final String LABEL_NUMEROMESES_LOWER= "Numero Meses";
    	public static final String LABEL_FECHACORTE= "Fecha Corte";
		public static final String LABEL_FECHACORTE_LOWER= "Fecha Corte";
    	public static final String LABEL_CODIGOPEDIDO= "Codigo Pedido";
		public static final String LABEL_CODIGOPEDIDO_LOWER= "Codigo Pedido";
    	public static final String LABEL_DESCRIPCION1= "Descripcion1";
		public static final String LABEL_DESCRIPCION1_LOWER= "Descripcion1";
    	public static final String LABEL_DESCRIPCION2= "Descripcion2";
		public static final String LABEL_DESCRIPCION2_LOWER= "Descripcion2";
    	public static final String LABEL_DESCRIPCION3= "Descripcion3";
		public static final String LABEL_DESCRIPCION3_LOWER= "Descripcion3";
	
		
		
		
		
		
		
		
		
		
	public static final String SREGEXNUMERO_PRE_IMPRESO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_PRE_IMPRESO=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
	public static final String SREGEXCODIGO_PEDIDO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO_PEDIDO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXDESCRIPCION1=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION1=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXDESCRIPCION2=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION2=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXDESCRIPCION3=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION3=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getPlaneacionCompraLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(PlaneacionCompraConstantesFunciones.IDEMPRESA)) {sLabelColumna=PlaneacionCompraConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(PlaneacionCompraConstantesFunciones.IDSUCURSAL)) {sLabelColumna=PlaneacionCompraConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(PlaneacionCompraConstantesFunciones.IDEJERCICIO)) {sLabelColumna=PlaneacionCompraConstantesFunciones.LABEL_IDEJERCICIO;}
		if(sNombreColumna.equals(PlaneacionCompraConstantesFunciones.IDPERIODO)) {sLabelColumna=PlaneacionCompraConstantesFunciones.LABEL_IDPERIODO;}
		if(sNombreColumna.equals(PlaneacionCompraConstantesFunciones.IDEMPLEADO)) {sLabelColumna=PlaneacionCompraConstantesFunciones.LABEL_IDEMPLEADO;}
		if(sNombreColumna.equals(PlaneacionCompraConstantesFunciones.IDUSUARIO)) {sLabelColumna=PlaneacionCompraConstantesFunciones.LABEL_IDUSUARIO;}
		if(sNombreColumna.equals(PlaneacionCompraConstantesFunciones.IDFORMATO)) {sLabelColumna=PlaneacionCompraConstantesFunciones.LABEL_IDFORMATO;}
		if(sNombreColumna.equals(PlaneacionCompraConstantesFunciones.NUMEROPREIMPRESO)) {sLabelColumna=PlaneacionCompraConstantesFunciones.LABEL_NUMEROPREIMPRESO;}
		if(sNombreColumna.equals(PlaneacionCompraConstantesFunciones.FECHA)) {sLabelColumna=PlaneacionCompraConstantesFunciones.LABEL_FECHA;}
		if(sNombreColumna.equals(PlaneacionCompraConstantesFunciones.IDMESINICIO)) {sLabelColumna=PlaneacionCompraConstantesFunciones.LABEL_IDMESINICIO;}
		if(sNombreColumna.equals(PlaneacionCompraConstantesFunciones.IDMESFIN)) {sLabelColumna=PlaneacionCompraConstantesFunciones.LABEL_IDMESFIN;}
		if(sNombreColumna.equals(PlaneacionCompraConstantesFunciones.NUMEROMESES)) {sLabelColumna=PlaneacionCompraConstantesFunciones.LABEL_NUMEROMESES;}
		if(sNombreColumna.equals(PlaneacionCompraConstantesFunciones.FECHACORTE)) {sLabelColumna=PlaneacionCompraConstantesFunciones.LABEL_FECHACORTE;}
		if(sNombreColumna.equals(PlaneacionCompraConstantesFunciones.CODIGOPEDIDO)) {sLabelColumna=PlaneacionCompraConstantesFunciones.LABEL_CODIGOPEDIDO;}
		if(sNombreColumna.equals(PlaneacionCompraConstantesFunciones.DESCRIPCION1)) {sLabelColumna=PlaneacionCompraConstantesFunciones.LABEL_DESCRIPCION1;}
		if(sNombreColumna.equals(PlaneacionCompraConstantesFunciones.DESCRIPCION2)) {sLabelColumna=PlaneacionCompraConstantesFunciones.LABEL_DESCRIPCION2;}
		if(sNombreColumna.equals(PlaneacionCompraConstantesFunciones.DESCRIPCION3)) {sLabelColumna=PlaneacionCompraConstantesFunciones.LABEL_DESCRIPCION3;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getPlaneacionCompraDescripcion(PlaneacionCompra planeacioncompra) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(planeacioncompra !=null/* && planeacioncompra.getId()!=0*/) {
			if(planeacioncompra.getId()!=null) {
				sDescripcion=planeacioncompra.getId().toString();
			}//planeacioncompraplaneacioncompra.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getPlaneacionCompraDescripcionDetallado(PlaneacionCompra planeacioncompra) {
		String sDescripcion="";
			
		sDescripcion+=PlaneacionCompraConstantesFunciones.ID+"=";
		sDescripcion+=planeacioncompra.getId().toString()+",";
		sDescripcion+=PlaneacionCompraConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=planeacioncompra.getVersionRow().toString()+",";
		sDescripcion+=PlaneacionCompraConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=planeacioncompra.getid_empresa().toString()+",";
		sDescripcion+=PlaneacionCompraConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=planeacioncompra.getid_sucursal().toString()+",";
		sDescripcion+=PlaneacionCompraConstantesFunciones.IDEJERCICIO+"=";
		sDescripcion+=planeacioncompra.getid_ejercicio().toString()+",";
		sDescripcion+=PlaneacionCompraConstantesFunciones.IDPERIODO+"=";
		sDescripcion+=planeacioncompra.getid_periodo().toString()+",";
		sDescripcion+=PlaneacionCompraConstantesFunciones.IDEMPLEADO+"=";
		sDescripcion+=planeacioncompra.getid_empleado().toString()+",";
		sDescripcion+=PlaneacionCompraConstantesFunciones.IDUSUARIO+"=";
		sDescripcion+=planeacioncompra.getid_usuario().toString()+",";
		sDescripcion+=PlaneacionCompraConstantesFunciones.IDFORMATO+"=";
		sDescripcion+=planeacioncompra.getid_formato().toString()+",";
		sDescripcion+=PlaneacionCompraConstantesFunciones.NUMEROPREIMPRESO+"=";
		sDescripcion+=planeacioncompra.getnumero_pre_impreso()+",";
		sDescripcion+=PlaneacionCompraConstantesFunciones.FECHA+"=";
		sDescripcion+=planeacioncompra.getfecha().toString()+",";
		sDescripcion+=PlaneacionCompraConstantesFunciones.IDMESINICIO+"=";
		sDescripcion+=planeacioncompra.getid_mes_inicio().toString()+",";
		sDescripcion+=PlaneacionCompraConstantesFunciones.IDMESFIN+"=";
		sDescripcion+=planeacioncompra.getid_mes_fin().toString()+",";
		sDescripcion+=PlaneacionCompraConstantesFunciones.NUMEROMESES+"=";
		sDescripcion+=planeacioncompra.getnumero_meses().toString()+",";
		sDescripcion+=PlaneacionCompraConstantesFunciones.FECHACORTE+"=";
		sDescripcion+=planeacioncompra.getfecha_corte().toString()+",";
		sDescripcion+=PlaneacionCompraConstantesFunciones.CODIGOPEDIDO+"=";
		sDescripcion+=planeacioncompra.getcodigo_pedido()+",";
		sDescripcion+=PlaneacionCompraConstantesFunciones.DESCRIPCION1+"=";
		sDescripcion+=planeacioncompra.getdescripcion1()+",";
		sDescripcion+=PlaneacionCompraConstantesFunciones.DESCRIPCION2+"=";
		sDescripcion+=planeacioncompra.getdescripcion2()+",";
		sDescripcion+=PlaneacionCompraConstantesFunciones.DESCRIPCION3+"=";
		sDescripcion+=planeacioncompra.getdescripcion3()+",";
			
		return sDescripcion;
	}
	
	public static void setPlaneacionCompraDescripcion(PlaneacionCompra planeacioncompra,String sValor) throws Exception {			
		if(planeacioncompra !=null) {
			//planeacioncompraplaneacioncompra.getId().toString();
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

	public static String getEjercicioDescripcion(Ejercicio ejercicio) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(ejercicio!=null/*&&ejercicio.getId()>0*/) {
			sDescripcion=EjercicioConstantesFunciones.getEjercicioDescripcion(ejercicio);
		}

		return sDescripcion;
	}

	public static String getPeriodoDescripcion(Periodo periodo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(periodo!=null/*&&periodo.getId()>0*/) {
			sDescripcion=PeriodoConstantesFunciones.getPeriodoDescripcion(periodo);
		}

		return sDescripcion;
	}

	public static String getEmpleadoDescripcion(Empleado empleado) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empleado!=null/*&&empleado.getId()>0*/) {
			sDescripcion=EmpleadoConstantesFunciones.getEmpleadoDescripcion(empleado);
		}

		return sDescripcion;
	}

	public static String getUsuarioDescripcion(Usuario usuario) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(usuario!=null/*&&usuario.getId()>0*/) {
			sDescripcion=UsuarioConstantesFunciones.getUsuarioDescripcion(usuario);
		}

		return sDescripcion;
	}

	public static String getFormatoDescripcion(Formato formato) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(formato!=null/*&&formato.getId()>0*/) {
			sDescripcion=FormatoConstantesFunciones.getFormatoDescripcion(formato);
		}

		return sDescripcion;
	}

	public static String getMesInicioDescripcion(Mes mes) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(mes!=null/*&&mes.getId()>0*/) {
			sDescripcion=MesConstantesFunciones.getMesDescripcion(mes);
		}

		return sDescripcion;
	}

	public static String getMesFinDescripcion(Mes mes) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(mes!=null/*&&mes.getId()>0*/) {
			sDescripcion=MesConstantesFunciones.getMesDescripcion(mes);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdEjercicio")) {
			sNombreIndice="Tipo=  Por Ejercicio";
		} else if(sNombreIndice.equals("FK_IdEmpleado")) {
			sNombreIndice="Tipo=  Por Empleado";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdFormato")) {
			sNombreIndice="Tipo=  Por Formato";
		} else if(sNombreIndice.equals("FK_IdMesFin")) {
			sNombreIndice="Tipo=  Por Mes Fin";
		} else if(sNombreIndice.equals("FK_IdMesInicio")) {
			sNombreIndice="Tipo=  Por Mes Inicio";
		} else if(sNombreIndice.equals("FK_IdPeriodo")) {
			sNombreIndice="Tipo=  Por Periodo";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		} else if(sNombreIndice.equals("FK_IdUsuario")) {
			sNombreIndice="Tipo=  Por Usuario";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdEjercicio(Long id_ejercicio) {
		String sDetalleIndice=" Parametros->";
		if(id_ejercicio!=null) {sDetalleIndice+=" Codigo Unico De Ejercicio="+id_ejercicio.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpleado(Long id_empleado) {
		String sDetalleIndice=" Parametros->";
		if(id_empleado!=null) {sDetalleIndice+=" Codigo Unico De Empleado="+id_empleado.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdFormato(Long id_formato) {
		String sDetalleIndice=" Parametros->";
		if(id_formato!=null) {sDetalleIndice+=" Codigo Unico De Formato="+id_formato.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdMesFin(Long id_mes_fin) {
		String sDetalleIndice=" Parametros->";
		if(id_mes_fin!=null) {sDetalleIndice+=" Codigo Unico De Mes Fin="+id_mes_fin.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdMesInicio(Long id_mes_inicio) {
		String sDetalleIndice=" Parametros->";
		if(id_mes_inicio!=null) {sDetalleIndice+=" Codigo Unico De Mes Inicio="+id_mes_inicio.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdPeriodo(Long id_periodo) {
		String sDetalleIndice=" Parametros->";
		if(id_periodo!=null) {sDetalleIndice+=" Codigo Unico De Periodo="+id_periodo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdUsuario(Long id_usuario) {
		String sDetalleIndice=" Parametros->";
		if(id_usuario!=null) {sDetalleIndice+=" Codigo Unico De Usuario="+id_usuario.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosPlaneacionCompra(PlaneacionCompra planeacioncompra,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		planeacioncompra.setnumero_pre_impreso(planeacioncompra.getnumero_pre_impreso().trim());
		planeacioncompra.setcodigo_pedido(planeacioncompra.getcodigo_pedido().trim());
		planeacioncompra.setdescripcion1(planeacioncompra.getdescripcion1().trim());
		planeacioncompra.setdescripcion2(planeacioncompra.getdescripcion2().trim());
		planeacioncompra.setdescripcion3(planeacioncompra.getdescripcion3().trim());
	}
	
	public static void quitarEspaciosPlaneacionCompras(List<PlaneacionCompra> planeacioncompras,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(PlaneacionCompra planeacioncompra: planeacioncompras) {
			planeacioncompra.setnumero_pre_impreso(planeacioncompra.getnumero_pre_impreso().trim());
			planeacioncompra.setcodigo_pedido(planeacioncompra.getcodigo_pedido().trim());
			planeacioncompra.setdescripcion1(planeacioncompra.getdescripcion1().trim());
			planeacioncompra.setdescripcion2(planeacioncompra.getdescripcion2().trim());
			planeacioncompra.setdescripcion3(planeacioncompra.getdescripcion3().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresPlaneacionCompra(PlaneacionCompra planeacioncompra,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && planeacioncompra.getConCambioAuxiliar()) {
			planeacioncompra.setIsDeleted(planeacioncompra.getIsDeletedAuxiliar());	
			planeacioncompra.setIsNew(planeacioncompra.getIsNewAuxiliar());	
			planeacioncompra.setIsChanged(planeacioncompra.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			planeacioncompra.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			planeacioncompra.setIsDeletedAuxiliar(false);	
			planeacioncompra.setIsNewAuxiliar(false);	
			planeacioncompra.setIsChangedAuxiliar(false);
			
			planeacioncompra.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresPlaneacionCompras(List<PlaneacionCompra> planeacioncompras,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(PlaneacionCompra planeacioncompra : planeacioncompras) {
			if(conAsignarBase && planeacioncompra.getConCambioAuxiliar()) {
				planeacioncompra.setIsDeleted(planeacioncompra.getIsDeletedAuxiliar());	
				planeacioncompra.setIsNew(planeacioncompra.getIsNewAuxiliar());	
				planeacioncompra.setIsChanged(planeacioncompra.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				planeacioncompra.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				planeacioncompra.setIsDeletedAuxiliar(false);	
				planeacioncompra.setIsNewAuxiliar(false);	
				planeacioncompra.setIsChangedAuxiliar(false);
				
				planeacioncompra.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresPlaneacionCompra(PlaneacionCompra planeacioncompra,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
			planeacioncompra.setnumero_meses(0);
		}
	}		
	
	public static void InicializarValoresPlaneacionCompras(List<PlaneacionCompra> planeacioncompras,Boolean conEnteros) throws Exception  {
		
		for(PlaneacionCompra planeacioncompra: planeacioncompras) {
		
			if(conEnteros) {
				Short ish_value=0;
				
				planeacioncompra.setnumero_meses(0);
			}
		}				
	}
	
	public static void TotalizarValoresFilaPlaneacionCompra(List<PlaneacionCompra> planeacioncompras,PlaneacionCompra planeacioncompraAux) throws Exception  {
		PlaneacionCompraConstantesFunciones.InicializarValoresPlaneacionCompra(planeacioncompraAux,true);
		
		for(PlaneacionCompra planeacioncompra: planeacioncompras) {
			if(planeacioncompra.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			planeacioncompraAux.setnumero_meses(planeacioncompraAux.getnumero_meses()+planeacioncompra.getnumero_meses());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesPlaneacionCompra(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=PlaneacionCompraConstantesFunciones.getArrayColumnasGlobalesPlaneacionCompra(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesPlaneacionCompra(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(PlaneacionCompraConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(PlaneacionCompraConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(PlaneacionCompraConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(PlaneacionCompraConstantesFunciones.IDSUCURSAL);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(PlaneacionCompraConstantesFunciones.IDEJERCICIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(PlaneacionCompraConstantesFunciones.IDEJERCICIO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(PlaneacionCompraConstantesFunciones.IDPERIODO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(PlaneacionCompraConstantesFunciones.IDPERIODO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(PlaneacionCompraConstantesFunciones.IDUSUARIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(PlaneacionCompraConstantesFunciones.IDUSUARIO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoPlaneacionCompra(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<PlaneacionCompra> planeacioncompras,PlaneacionCompra planeacioncompra,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(PlaneacionCompra planeacioncompraAux: planeacioncompras) {
			if(planeacioncompraAux!=null && planeacioncompra!=null) {
				if((planeacioncompraAux.getId()==null && planeacioncompra.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(planeacioncompraAux.getId()!=null && planeacioncompra.getId()!=null){
					if(planeacioncompraAux.getId().equals(planeacioncompra.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaPlaneacionCompra(List<PlaneacionCompra> planeacioncompras) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(PlaneacionCompra planeacioncompra: planeacioncompras) {			
			if(planeacioncompra.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaPlaneacionCompra() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,PlaneacionCompraConstantesFunciones.LABEL_ID, PlaneacionCompraConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PlaneacionCompraConstantesFunciones.LABEL_VERSIONROW, PlaneacionCompraConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PlaneacionCompraConstantesFunciones.LABEL_IDEMPRESA, PlaneacionCompraConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PlaneacionCompraConstantesFunciones.LABEL_IDSUCURSAL, PlaneacionCompraConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PlaneacionCompraConstantesFunciones.LABEL_IDEJERCICIO, PlaneacionCompraConstantesFunciones.IDEJERCICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PlaneacionCompraConstantesFunciones.LABEL_IDPERIODO, PlaneacionCompraConstantesFunciones.IDPERIODO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PlaneacionCompraConstantesFunciones.LABEL_IDEMPLEADO, PlaneacionCompraConstantesFunciones.IDEMPLEADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PlaneacionCompraConstantesFunciones.LABEL_IDUSUARIO, PlaneacionCompraConstantesFunciones.IDUSUARIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PlaneacionCompraConstantesFunciones.LABEL_IDFORMATO, PlaneacionCompraConstantesFunciones.IDFORMATO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PlaneacionCompraConstantesFunciones.LABEL_NUMEROPREIMPRESO, PlaneacionCompraConstantesFunciones.NUMEROPREIMPRESO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PlaneacionCompraConstantesFunciones.LABEL_FECHA, PlaneacionCompraConstantesFunciones.FECHA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PlaneacionCompraConstantesFunciones.LABEL_IDMESINICIO, PlaneacionCompraConstantesFunciones.IDMESINICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PlaneacionCompraConstantesFunciones.LABEL_IDMESFIN, PlaneacionCompraConstantesFunciones.IDMESFIN,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PlaneacionCompraConstantesFunciones.LABEL_NUMEROMESES, PlaneacionCompraConstantesFunciones.NUMEROMESES,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PlaneacionCompraConstantesFunciones.LABEL_FECHACORTE, PlaneacionCompraConstantesFunciones.FECHACORTE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PlaneacionCompraConstantesFunciones.LABEL_CODIGOPEDIDO, PlaneacionCompraConstantesFunciones.CODIGOPEDIDO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PlaneacionCompraConstantesFunciones.LABEL_DESCRIPCION1, PlaneacionCompraConstantesFunciones.DESCRIPCION1,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PlaneacionCompraConstantesFunciones.LABEL_DESCRIPCION2, PlaneacionCompraConstantesFunciones.DESCRIPCION2,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,PlaneacionCompraConstantesFunciones.LABEL_DESCRIPCION3, PlaneacionCompraConstantesFunciones.DESCRIPCION3,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasPlaneacionCompra() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=PlaneacionCompraConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PlaneacionCompraConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PlaneacionCompraConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PlaneacionCompraConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PlaneacionCompraConstantesFunciones.IDEJERCICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PlaneacionCompraConstantesFunciones.IDPERIODO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PlaneacionCompraConstantesFunciones.IDEMPLEADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PlaneacionCompraConstantesFunciones.IDUSUARIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PlaneacionCompraConstantesFunciones.IDFORMATO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PlaneacionCompraConstantesFunciones.NUMEROPREIMPRESO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PlaneacionCompraConstantesFunciones.FECHA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PlaneacionCompraConstantesFunciones.IDMESINICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PlaneacionCompraConstantesFunciones.IDMESFIN;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PlaneacionCompraConstantesFunciones.NUMEROMESES;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PlaneacionCompraConstantesFunciones.FECHACORTE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PlaneacionCompraConstantesFunciones.CODIGOPEDIDO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PlaneacionCompraConstantesFunciones.DESCRIPCION1;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PlaneacionCompraConstantesFunciones.DESCRIPCION2;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=PlaneacionCompraConstantesFunciones.DESCRIPCION3;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPlaneacionCompra() throws Exception  {
		return PlaneacionCompraConstantesFunciones.getTiposSeleccionarPlaneacionCompra(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPlaneacionCompra(Boolean conFk) throws Exception  {
		return PlaneacionCompraConstantesFunciones.getTiposSeleccionarPlaneacionCompra(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarPlaneacionCompra(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PlaneacionCompraConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(PlaneacionCompraConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PlaneacionCompraConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(PlaneacionCompraConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PlaneacionCompraConstantesFunciones.LABEL_IDEJERCICIO);
			reporte.setsDescripcion(PlaneacionCompraConstantesFunciones.LABEL_IDEJERCICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PlaneacionCompraConstantesFunciones.LABEL_IDPERIODO);
			reporte.setsDescripcion(PlaneacionCompraConstantesFunciones.LABEL_IDPERIODO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PlaneacionCompraConstantesFunciones.LABEL_IDEMPLEADO);
			reporte.setsDescripcion(PlaneacionCompraConstantesFunciones.LABEL_IDEMPLEADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PlaneacionCompraConstantesFunciones.LABEL_IDUSUARIO);
			reporte.setsDescripcion(PlaneacionCompraConstantesFunciones.LABEL_IDUSUARIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PlaneacionCompraConstantesFunciones.LABEL_IDFORMATO);
			reporte.setsDescripcion(PlaneacionCompraConstantesFunciones.LABEL_IDFORMATO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PlaneacionCompraConstantesFunciones.LABEL_NUMEROPREIMPRESO);
			reporte.setsDescripcion(PlaneacionCompraConstantesFunciones.LABEL_NUMEROPREIMPRESO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PlaneacionCompraConstantesFunciones.LABEL_FECHA);
			reporte.setsDescripcion(PlaneacionCompraConstantesFunciones.LABEL_FECHA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PlaneacionCompraConstantesFunciones.LABEL_IDMESINICIO);
			reporte.setsDescripcion(PlaneacionCompraConstantesFunciones.LABEL_IDMESINICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(PlaneacionCompraConstantesFunciones.LABEL_IDMESFIN);
			reporte.setsDescripcion(PlaneacionCompraConstantesFunciones.LABEL_IDMESFIN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PlaneacionCompraConstantesFunciones.LABEL_NUMEROMESES);
			reporte.setsDescripcion(PlaneacionCompraConstantesFunciones.LABEL_NUMEROMESES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PlaneacionCompraConstantesFunciones.LABEL_FECHACORTE);
			reporte.setsDescripcion(PlaneacionCompraConstantesFunciones.LABEL_FECHACORTE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PlaneacionCompraConstantesFunciones.LABEL_CODIGOPEDIDO);
			reporte.setsDescripcion(PlaneacionCompraConstantesFunciones.LABEL_CODIGOPEDIDO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PlaneacionCompraConstantesFunciones.LABEL_DESCRIPCION1);
			reporte.setsDescripcion(PlaneacionCompraConstantesFunciones.LABEL_DESCRIPCION1);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PlaneacionCompraConstantesFunciones.LABEL_DESCRIPCION2);
			reporte.setsDescripcion(PlaneacionCompraConstantesFunciones.LABEL_DESCRIPCION2);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(PlaneacionCompraConstantesFunciones.LABEL_DESCRIPCION3);
			reporte.setsDescripcion(PlaneacionCompraConstantesFunciones.LABEL_DESCRIPCION3);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesPlaneacionCompra(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesPlaneacionCompra(PlaneacionCompra planeacioncompraAux) throws Exception {
		
			planeacioncompraAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(planeacioncompraAux.getEmpresa()));
			planeacioncompraAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(planeacioncompraAux.getSucursal()));
			planeacioncompraAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(planeacioncompraAux.getEjercicio()));
			planeacioncompraAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(planeacioncompraAux.getPeriodo()));
			planeacioncompraAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(planeacioncompraAux.getEmpleado()));
			planeacioncompraAux.setusuario_descripcion(UsuarioConstantesFunciones.getUsuarioDescripcion(planeacioncompraAux.getUsuario()));
			planeacioncompraAux.setformato_descripcion(FormatoConstantesFunciones.getFormatoDescripcion(planeacioncompraAux.getFormato()));
			planeacioncompraAux.setmesinicio_descripcion(MesConstantesFunciones.getMesDescripcion(planeacioncompraAux.getMesInicio()));
			planeacioncompraAux.setmesfin_descripcion(MesConstantesFunciones.getMesDescripcion(planeacioncompraAux.getMesFin()));		
	}
	
	public static void refrescarForeignKeysDescripcionesPlaneacionCompra(List<PlaneacionCompra> planeacioncomprasTemp) throws Exception {
		for(PlaneacionCompra planeacioncompraAux:planeacioncomprasTemp) {
			
			planeacioncompraAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(planeacioncompraAux.getEmpresa()));
			planeacioncompraAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(planeacioncompraAux.getSucursal()));
			planeacioncompraAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(planeacioncompraAux.getEjercicio()));
			planeacioncompraAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(planeacioncompraAux.getPeriodo()));
			planeacioncompraAux.setempleado_descripcion(EmpleadoConstantesFunciones.getEmpleadoDescripcion(planeacioncompraAux.getEmpleado()));
			planeacioncompraAux.setusuario_descripcion(UsuarioConstantesFunciones.getUsuarioDescripcion(planeacioncompraAux.getUsuario()));
			planeacioncompraAux.setformato_descripcion(FormatoConstantesFunciones.getFormatoDescripcion(planeacioncompraAux.getFormato()));
			planeacioncompraAux.setmesinicio_descripcion(MesConstantesFunciones.getMesDescripcion(planeacioncompraAux.getMesInicio()));
			planeacioncompraAux.setmesfin_descripcion(MesConstantesFunciones.getMesDescripcion(planeacioncompraAux.getMesFin()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfPlaneacionCompra(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Ejercicio.class));
				classes.add(new Classe(Periodo.class));
				classes.add(new Classe(Empleado.class));
				classes.add(new Classe(Usuario.class));
				classes.add(new Classe(Formato.class));
				classes.add(new Classe(Mes.class));
				classes.add(new Classe(Mes.class));
				
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
					if(clas.clas.equals(Ejercicio.class)) {
						classes.add(new Classe(Ejercicio.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Periodo.class)) {
						classes.add(new Classe(Periodo.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Empleado.class)) {
						classes.add(new Classe(Empleado.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Usuario.class)) {
						classes.add(new Classe(Usuario.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Formato.class)) {
						classes.add(new Classe(Formato.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Mes.class)) {
						classes.add(new Classe(Mes.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Mes.class)) {
						classes.add(new Classe(Mes.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfPlaneacionCompra(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(Ejercicio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ejercicio.class)); continue;
					}

					if(Periodo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Periodo.class)); continue;
					}

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}

					if(Usuario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Usuario.class)); continue;
					}

					if(Formato.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Formato.class)); continue;
					}

					if(Mes.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Mes.class)); continue;
					}

					if(Mes.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Mes.class)); continue;
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

					if(Ejercicio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ejercicio.class)); continue;
					}

					if(Periodo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Periodo.class)); continue;
					}

					if(Empleado.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empleado.class)); continue;
					}

					if(Usuario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Usuario.class)); continue;
					}

					if(Formato.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Formato.class)); continue;
					}

					if(Mes.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Mes.class)); continue;
					}

					if(Mes.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Mes.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfPlaneacionCompra(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return PlaneacionCompraConstantesFunciones.getClassesRelationshipsOfPlaneacionCompra(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfPlaneacionCompra(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(DetallePlaneacionCompra.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(DetallePlaneacionCompra.class)) {
						classes.add(new Classe(DetallePlaneacionCompra.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfPlaneacionCompra(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return PlaneacionCompraConstantesFunciones.getClassesRelationshipsFromStringsOfPlaneacionCompra(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfPlaneacionCompra(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(DetallePlaneacionCompra.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetallePlaneacionCompra.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(DetallePlaneacionCompra.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetallePlaneacionCompra.class)); continue;
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
	
	//FUNCIONES CONTROLLER
	public static void actualizarLista(PlaneacionCompra planeacioncompra,List<PlaneacionCompra> planeacioncompras,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			PlaneacionCompra planeacioncompraEncontrado=null;
			
			for(PlaneacionCompra planeacioncompraLocal:planeacioncompras) {
				if(planeacioncompraLocal.getId().equals(planeacioncompra.getId())) {
					planeacioncompraEncontrado=planeacioncompraLocal;
					
					planeacioncompraLocal.setIsChanged(planeacioncompra.getIsChanged());
					planeacioncompraLocal.setIsNew(planeacioncompra.getIsNew());
					planeacioncompraLocal.setIsDeleted(planeacioncompra.getIsDeleted());
					
					planeacioncompraLocal.setGeneralEntityOriginal(planeacioncompra.getGeneralEntityOriginal());
					
					planeacioncompraLocal.setId(planeacioncompra.getId());	
					planeacioncompraLocal.setVersionRow(planeacioncompra.getVersionRow());	
					planeacioncompraLocal.setid_empresa(planeacioncompra.getid_empresa());	
					planeacioncompraLocal.setid_sucursal(planeacioncompra.getid_sucursal());	
					planeacioncompraLocal.setid_ejercicio(planeacioncompra.getid_ejercicio());	
					planeacioncompraLocal.setid_periodo(planeacioncompra.getid_periodo());	
					planeacioncompraLocal.setid_empleado(planeacioncompra.getid_empleado());	
					planeacioncompraLocal.setid_usuario(planeacioncompra.getid_usuario());	
					planeacioncompraLocal.setid_formato(planeacioncompra.getid_formato());	
					planeacioncompraLocal.setnumero_pre_impreso(planeacioncompra.getnumero_pre_impreso());	
					planeacioncompraLocal.setfecha(planeacioncompra.getfecha());	
					planeacioncompraLocal.setid_mes_inicio(planeacioncompra.getid_mes_inicio());	
					planeacioncompraLocal.setid_mes_fin(planeacioncompra.getid_mes_fin());	
					planeacioncompraLocal.setnumero_meses(planeacioncompra.getnumero_meses());	
					planeacioncompraLocal.setfecha_corte(planeacioncompra.getfecha_corte());	
					planeacioncompraLocal.setcodigo_pedido(planeacioncompra.getcodigo_pedido());	
					planeacioncompraLocal.setdescripcion1(planeacioncompra.getdescripcion1());	
					planeacioncompraLocal.setdescripcion2(planeacioncompra.getdescripcion2());	
					planeacioncompraLocal.setdescripcion3(planeacioncompra.getdescripcion3());	
					
					
					planeacioncompraLocal.setDetallePlaneacionCompras(planeacioncompra.getDetallePlaneacionCompras());
					
					existe=true;
					break;
				}
			}
			
			if(!planeacioncompra.getIsDeleted()) {
				if(!existe) {
					planeacioncompras.add(planeacioncompra);
				}
			} else {
				if(planeacioncompraEncontrado!=null && permiteQuitar)  {
					planeacioncompras.remove(planeacioncompraEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(PlaneacionCompra planeacioncompra,List<PlaneacionCompra> planeacioncompras) throws Exception {
		try	{			
			for(PlaneacionCompra planeacioncompraLocal:planeacioncompras) {
				if(planeacioncompraLocal.getId().equals(planeacioncompra.getId())) {
					planeacioncompraLocal.setIsSelected(planeacioncompra.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesPlaneacionCompra(List<PlaneacionCompra> planeacioncomprasAux) throws Exception {
		//this.planeacioncomprasAux=planeacioncomprasAux;
		
		for(PlaneacionCompra planeacioncompraAux:planeacioncomprasAux) {
			if(planeacioncompraAux.getIsChanged()) {
				planeacioncompraAux.setIsChanged(false);
			}		
			
			if(planeacioncompraAux.getIsNew()) {
				planeacioncompraAux.setIsNew(false);
			}	
			
			if(planeacioncompraAux.getIsDeleted()) {
				planeacioncompraAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesPlaneacionCompra(PlaneacionCompra planeacioncompraAux) throws Exception {
		//this.planeacioncompraAux=planeacioncompraAux;
		
			if(planeacioncompraAux.getIsChanged()) {
				planeacioncompraAux.setIsChanged(false);
			}		
			
			if(planeacioncompraAux.getIsNew()) {
				planeacioncompraAux.setIsNew(false);
			}	
			
			if(planeacioncompraAux.getIsDeleted()) {
				planeacioncompraAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(PlaneacionCompra planeacioncompraAsignar,PlaneacionCompra planeacioncompra) throws Exception {
		planeacioncompraAsignar.setId(planeacioncompra.getId());	
		planeacioncompraAsignar.setVersionRow(planeacioncompra.getVersionRow());	
		planeacioncompraAsignar.setid_empresa(planeacioncompra.getid_empresa());
		planeacioncompraAsignar.setempresa_descripcion(planeacioncompra.getempresa_descripcion());	
		planeacioncompraAsignar.setid_sucursal(planeacioncompra.getid_sucursal());
		planeacioncompraAsignar.setsucursal_descripcion(planeacioncompra.getsucursal_descripcion());	
		planeacioncompraAsignar.setid_ejercicio(planeacioncompra.getid_ejercicio());
		planeacioncompraAsignar.setejercicio_descripcion(planeacioncompra.getejercicio_descripcion());	
		planeacioncompraAsignar.setid_periodo(planeacioncompra.getid_periodo());
		planeacioncompraAsignar.setperiodo_descripcion(planeacioncompra.getperiodo_descripcion());	
		planeacioncompraAsignar.setid_empleado(planeacioncompra.getid_empleado());
		planeacioncompraAsignar.setempleado_descripcion(planeacioncompra.getempleado_descripcion());	
		planeacioncompraAsignar.setid_usuario(planeacioncompra.getid_usuario());
		planeacioncompraAsignar.setusuario_descripcion(planeacioncompra.getusuario_descripcion());	
		planeacioncompraAsignar.setid_formato(planeacioncompra.getid_formato());
		planeacioncompraAsignar.setformato_descripcion(planeacioncompra.getformato_descripcion());	
		planeacioncompraAsignar.setnumero_pre_impreso(planeacioncompra.getnumero_pre_impreso());	
		planeacioncompraAsignar.setfecha(planeacioncompra.getfecha());	
		planeacioncompraAsignar.setid_mes_inicio(planeacioncompra.getid_mes_inicio());
		planeacioncompraAsignar.setmesinicio_descripcion(planeacioncompra.getmesinicio_descripcion());	
		planeacioncompraAsignar.setid_mes_fin(planeacioncompra.getid_mes_fin());
		planeacioncompraAsignar.setmesfin_descripcion(planeacioncompra.getmesfin_descripcion());	
		planeacioncompraAsignar.setnumero_meses(planeacioncompra.getnumero_meses());	
		planeacioncompraAsignar.setfecha_corte(planeacioncompra.getfecha_corte());	
		planeacioncompraAsignar.setcodigo_pedido(planeacioncompra.getcodigo_pedido());	
		planeacioncompraAsignar.setdescripcion1(planeacioncompra.getdescripcion1());	
		planeacioncompraAsignar.setdescripcion2(planeacioncompra.getdescripcion2());	
		planeacioncompraAsignar.setdescripcion3(planeacioncompra.getdescripcion3());	
	}
	
	public static void inicializarPlaneacionCompra(PlaneacionCompra planeacioncompra) throws Exception {
		try {
				planeacioncompra.setId(0L);	
					
				planeacioncompra.setid_empresa(-1L);	
				planeacioncompra.setid_sucursal(-1L);	
				planeacioncompra.setid_ejercicio(-1L);	
				planeacioncompra.setid_periodo(-1L);	
				planeacioncompra.setid_empleado(-1L);	
				planeacioncompra.setid_usuario(-1L);	
				planeacioncompra.setid_formato(-1L);	
				planeacioncompra.setnumero_pre_impreso("");	
				planeacioncompra.setfecha(new Date());	
				planeacioncompra.setid_mes_inicio(-1L);	
				planeacioncompra.setid_mes_fin(-1L);	
				planeacioncompra.setnumero_meses(0);	
				planeacioncompra.setfecha_corte(new Date());	
				planeacioncompra.setcodigo_pedido("");	
				planeacioncompra.setdescripcion1("");	
				planeacioncompra.setdescripcion2("");	
				planeacioncompra.setdescripcion3("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderPlaneacionCompra(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(PlaneacionCompraConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PlaneacionCompraConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PlaneacionCompraConstantesFunciones.LABEL_IDEJERCICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PlaneacionCompraConstantesFunciones.LABEL_IDPERIODO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PlaneacionCompraConstantesFunciones.LABEL_IDEMPLEADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PlaneacionCompraConstantesFunciones.LABEL_IDUSUARIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PlaneacionCompraConstantesFunciones.LABEL_IDFORMATO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PlaneacionCompraConstantesFunciones.LABEL_NUMEROPREIMPRESO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PlaneacionCompraConstantesFunciones.LABEL_FECHA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PlaneacionCompraConstantesFunciones.LABEL_IDMESINICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PlaneacionCompraConstantesFunciones.LABEL_IDMESFIN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PlaneacionCompraConstantesFunciones.LABEL_NUMEROMESES);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PlaneacionCompraConstantesFunciones.LABEL_FECHACORTE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PlaneacionCompraConstantesFunciones.LABEL_CODIGOPEDIDO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PlaneacionCompraConstantesFunciones.LABEL_DESCRIPCION1);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PlaneacionCompraConstantesFunciones.LABEL_DESCRIPCION2);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(PlaneacionCompraConstantesFunciones.LABEL_DESCRIPCION3);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataPlaneacionCompra(String sTipo,Row row,Workbook workbook,PlaneacionCompra planeacioncompra,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(planeacioncompra.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(planeacioncompra.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(planeacioncompra.getejercicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(planeacioncompra.getperiodo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(planeacioncompra.getempleado_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(planeacioncompra.getusuario_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(planeacioncompra.getformato_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(planeacioncompra.getnumero_pre_impreso());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(planeacioncompra.getfecha());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(planeacioncompra.getmesinicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(planeacioncompra.getmesfin_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(planeacioncompra.getnumero_meses());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(planeacioncompra.getfecha_corte());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(planeacioncompra.getcodigo_pedido());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(planeacioncompra.getdescripcion1());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(planeacioncompra.getdescripcion2());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(planeacioncompra.getdescripcion3());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryPlaneacionCompra=Constantes.SFINALQUERY;
	
	public String getsFinalQueryPlaneacionCompra() {
		return this.sFinalQueryPlaneacionCompra;
	}
	
	public void setsFinalQueryPlaneacionCompra(String sFinalQueryPlaneacionCompra) {
		this.sFinalQueryPlaneacionCompra= sFinalQueryPlaneacionCompra;
	}
	
	public Border resaltarSeleccionarPlaneacionCompra=null;
	
	public Border setResaltarSeleccionarPlaneacionCompra(ParametroGeneralUsuario parametroGeneralUsuario/*PlaneacionCompraBeanSwingJInternalFrame planeacioncompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//planeacioncompraBeanSwingJInternalFrame.jTtoolBarPlaneacionCompra.setBorder(borderResaltar);
		
		this.resaltarSeleccionarPlaneacionCompra= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarPlaneacionCompra() {
		return this.resaltarSeleccionarPlaneacionCompra;
	}
	
	public void setResaltarSeleccionarPlaneacionCompra(Border borderResaltarSeleccionarPlaneacionCompra) {
		this.resaltarSeleccionarPlaneacionCompra= borderResaltarSeleccionarPlaneacionCompra;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridPlaneacionCompra=null;
	public Boolean mostraridPlaneacionCompra=true;
	public Boolean activaridPlaneacionCompra=true;

	public Border resaltarid_empresaPlaneacionCompra=null;
	public Boolean mostrarid_empresaPlaneacionCompra=true;
	public Boolean activarid_empresaPlaneacionCompra=true;
	public Boolean cargarid_empresaPlaneacionCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaPlaneacionCompra=false;//ConEventDepend=true

	public Border resaltarid_sucursalPlaneacionCompra=null;
	public Boolean mostrarid_sucursalPlaneacionCompra=true;
	public Boolean activarid_sucursalPlaneacionCompra=true;
	public Boolean cargarid_sucursalPlaneacionCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalPlaneacionCompra=false;//ConEventDepend=true

	public Border resaltarid_ejercicioPlaneacionCompra=null;
	public Boolean mostrarid_ejercicioPlaneacionCompra=true;
	public Boolean activarid_ejercicioPlaneacionCompra=true;
	public Boolean cargarid_ejercicioPlaneacionCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ejercicioPlaneacionCompra=false;//ConEventDepend=true

	public Border resaltarid_periodoPlaneacionCompra=null;
	public Boolean mostrarid_periodoPlaneacionCompra=true;
	public Boolean activarid_periodoPlaneacionCompra=true;
	public Boolean cargarid_periodoPlaneacionCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_periodoPlaneacionCompra=false;//ConEventDepend=true

	public Border resaltarid_empleadoPlaneacionCompra=null;
	public Boolean mostrarid_empleadoPlaneacionCompra=true;
	public Boolean activarid_empleadoPlaneacionCompra=true;
	public Boolean cargarid_empleadoPlaneacionCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empleadoPlaneacionCompra=false;//ConEventDepend=true

	public Border resaltarid_usuarioPlaneacionCompra=null;
	public Boolean mostrarid_usuarioPlaneacionCompra=true;
	public Boolean activarid_usuarioPlaneacionCompra=true;
	public Boolean cargarid_usuarioPlaneacionCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_usuarioPlaneacionCompra=false;//ConEventDepend=true

	public Border resaltarid_formatoPlaneacionCompra=null;
	public Boolean mostrarid_formatoPlaneacionCompra=true;
	public Boolean activarid_formatoPlaneacionCompra=true;
	public Boolean cargarid_formatoPlaneacionCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_formatoPlaneacionCompra=false;//ConEventDepend=true

	public Border resaltarnumero_pre_impresoPlaneacionCompra=null;
	public Boolean mostrarnumero_pre_impresoPlaneacionCompra=true;
	public Boolean activarnumero_pre_impresoPlaneacionCompra=true;

	public Border resaltarfechaPlaneacionCompra=null;
	public Boolean mostrarfechaPlaneacionCompra=true;
	public Boolean activarfechaPlaneacionCompra=false;

	public Border resaltarid_mes_inicioPlaneacionCompra=null;
	public Boolean mostrarid_mes_inicioPlaneacionCompra=true;
	public Boolean activarid_mes_inicioPlaneacionCompra=true;
	public Boolean cargarid_mes_inicioPlaneacionCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_mes_inicioPlaneacionCompra=false;//ConEventDepend=true

	public Border resaltarid_mes_finPlaneacionCompra=null;
	public Boolean mostrarid_mes_finPlaneacionCompra=true;
	public Boolean activarid_mes_finPlaneacionCompra=true;
	public Boolean cargarid_mes_finPlaneacionCompra=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_mes_finPlaneacionCompra=false;//ConEventDepend=true

	public Border resaltarnumero_mesesPlaneacionCompra=null;
	public Boolean mostrarnumero_mesesPlaneacionCompra=true;
	public Boolean activarnumero_mesesPlaneacionCompra=true;

	public Border resaltarfecha_cortePlaneacionCompra=null;
	public Boolean mostrarfecha_cortePlaneacionCompra=true;
	public Boolean activarfecha_cortePlaneacionCompra=false;

	public Border resaltarcodigo_pedidoPlaneacionCompra=null;
	public Boolean mostrarcodigo_pedidoPlaneacionCompra=true;
	public Boolean activarcodigo_pedidoPlaneacionCompra=true;

	public Border resaltardescripcion1PlaneacionCompra=null;
	public Boolean mostrardescripcion1PlaneacionCompra=true;
	public Boolean activardescripcion1PlaneacionCompra=true;

	public Border resaltardescripcion2PlaneacionCompra=null;
	public Boolean mostrardescripcion2PlaneacionCompra=true;
	public Boolean activardescripcion2PlaneacionCompra=true;

	public Border resaltardescripcion3PlaneacionCompra=null;
	public Boolean mostrardescripcion3PlaneacionCompra=true;
	public Boolean activardescripcion3PlaneacionCompra=true;

	
	

	public Border setResaltaridPlaneacionCompra(ParametroGeneralUsuario parametroGeneralUsuario/*PlaneacionCompraBeanSwingJInternalFrame planeacioncompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//planeacioncompraBeanSwingJInternalFrame.jTtoolBarPlaneacionCompra.setBorder(borderResaltar);
		
		this.resaltaridPlaneacionCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridPlaneacionCompra() {
		return this.resaltaridPlaneacionCompra;
	}

	public void setResaltaridPlaneacionCompra(Border borderResaltar) {
		this.resaltaridPlaneacionCompra= borderResaltar;
	}

	public Boolean getMostraridPlaneacionCompra() {
		return this.mostraridPlaneacionCompra;
	}

	public void setMostraridPlaneacionCompra(Boolean mostraridPlaneacionCompra) {
		this.mostraridPlaneacionCompra= mostraridPlaneacionCompra;
	}

	public Boolean getActivaridPlaneacionCompra() {
		return this.activaridPlaneacionCompra;
	}

	public void setActivaridPlaneacionCompra(Boolean activaridPlaneacionCompra) {
		this.activaridPlaneacionCompra= activaridPlaneacionCompra;
	}

	public Border setResaltarid_empresaPlaneacionCompra(ParametroGeneralUsuario parametroGeneralUsuario/*PlaneacionCompraBeanSwingJInternalFrame planeacioncompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//planeacioncompraBeanSwingJInternalFrame.jTtoolBarPlaneacionCompra.setBorder(borderResaltar);
		
		this.resaltarid_empresaPlaneacionCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaPlaneacionCompra() {
		return this.resaltarid_empresaPlaneacionCompra;
	}

	public void setResaltarid_empresaPlaneacionCompra(Border borderResaltar) {
		this.resaltarid_empresaPlaneacionCompra= borderResaltar;
	}

	public Boolean getMostrarid_empresaPlaneacionCompra() {
		return this.mostrarid_empresaPlaneacionCompra;
	}

	public void setMostrarid_empresaPlaneacionCompra(Boolean mostrarid_empresaPlaneacionCompra) {
		this.mostrarid_empresaPlaneacionCompra= mostrarid_empresaPlaneacionCompra;
	}

	public Boolean getActivarid_empresaPlaneacionCompra() {
		return this.activarid_empresaPlaneacionCompra;
	}

	public void setActivarid_empresaPlaneacionCompra(Boolean activarid_empresaPlaneacionCompra) {
		this.activarid_empresaPlaneacionCompra= activarid_empresaPlaneacionCompra;
	}

	public Boolean getCargarid_empresaPlaneacionCompra() {
		return this.cargarid_empresaPlaneacionCompra;
	}

	public void setCargarid_empresaPlaneacionCompra(Boolean cargarid_empresaPlaneacionCompra) {
		this.cargarid_empresaPlaneacionCompra= cargarid_empresaPlaneacionCompra;
	}

	public Border setResaltarid_sucursalPlaneacionCompra(ParametroGeneralUsuario parametroGeneralUsuario/*PlaneacionCompraBeanSwingJInternalFrame planeacioncompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//planeacioncompraBeanSwingJInternalFrame.jTtoolBarPlaneacionCompra.setBorder(borderResaltar);
		
		this.resaltarid_sucursalPlaneacionCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalPlaneacionCompra() {
		return this.resaltarid_sucursalPlaneacionCompra;
	}

	public void setResaltarid_sucursalPlaneacionCompra(Border borderResaltar) {
		this.resaltarid_sucursalPlaneacionCompra= borderResaltar;
	}

	public Boolean getMostrarid_sucursalPlaneacionCompra() {
		return this.mostrarid_sucursalPlaneacionCompra;
	}

	public void setMostrarid_sucursalPlaneacionCompra(Boolean mostrarid_sucursalPlaneacionCompra) {
		this.mostrarid_sucursalPlaneacionCompra= mostrarid_sucursalPlaneacionCompra;
	}

	public Boolean getActivarid_sucursalPlaneacionCompra() {
		return this.activarid_sucursalPlaneacionCompra;
	}

	public void setActivarid_sucursalPlaneacionCompra(Boolean activarid_sucursalPlaneacionCompra) {
		this.activarid_sucursalPlaneacionCompra= activarid_sucursalPlaneacionCompra;
	}

	public Boolean getCargarid_sucursalPlaneacionCompra() {
		return this.cargarid_sucursalPlaneacionCompra;
	}

	public void setCargarid_sucursalPlaneacionCompra(Boolean cargarid_sucursalPlaneacionCompra) {
		this.cargarid_sucursalPlaneacionCompra= cargarid_sucursalPlaneacionCompra;
	}

	public Border setResaltarid_ejercicioPlaneacionCompra(ParametroGeneralUsuario parametroGeneralUsuario/*PlaneacionCompraBeanSwingJInternalFrame planeacioncompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//planeacioncompraBeanSwingJInternalFrame.jTtoolBarPlaneacionCompra.setBorder(borderResaltar);
		
		this.resaltarid_ejercicioPlaneacionCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ejercicioPlaneacionCompra() {
		return this.resaltarid_ejercicioPlaneacionCompra;
	}

	public void setResaltarid_ejercicioPlaneacionCompra(Border borderResaltar) {
		this.resaltarid_ejercicioPlaneacionCompra= borderResaltar;
	}

	public Boolean getMostrarid_ejercicioPlaneacionCompra() {
		return this.mostrarid_ejercicioPlaneacionCompra;
	}

	public void setMostrarid_ejercicioPlaneacionCompra(Boolean mostrarid_ejercicioPlaneacionCompra) {
		this.mostrarid_ejercicioPlaneacionCompra= mostrarid_ejercicioPlaneacionCompra;
	}

	public Boolean getActivarid_ejercicioPlaneacionCompra() {
		return this.activarid_ejercicioPlaneacionCompra;
	}

	public void setActivarid_ejercicioPlaneacionCompra(Boolean activarid_ejercicioPlaneacionCompra) {
		this.activarid_ejercicioPlaneacionCompra= activarid_ejercicioPlaneacionCompra;
	}

	public Boolean getCargarid_ejercicioPlaneacionCompra() {
		return this.cargarid_ejercicioPlaneacionCompra;
	}

	public void setCargarid_ejercicioPlaneacionCompra(Boolean cargarid_ejercicioPlaneacionCompra) {
		this.cargarid_ejercicioPlaneacionCompra= cargarid_ejercicioPlaneacionCompra;
	}

	public Border setResaltarid_periodoPlaneacionCompra(ParametroGeneralUsuario parametroGeneralUsuario/*PlaneacionCompraBeanSwingJInternalFrame planeacioncompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//planeacioncompraBeanSwingJInternalFrame.jTtoolBarPlaneacionCompra.setBorder(borderResaltar);
		
		this.resaltarid_periodoPlaneacionCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_periodoPlaneacionCompra() {
		return this.resaltarid_periodoPlaneacionCompra;
	}

	public void setResaltarid_periodoPlaneacionCompra(Border borderResaltar) {
		this.resaltarid_periodoPlaneacionCompra= borderResaltar;
	}

	public Boolean getMostrarid_periodoPlaneacionCompra() {
		return this.mostrarid_periodoPlaneacionCompra;
	}

	public void setMostrarid_periodoPlaneacionCompra(Boolean mostrarid_periodoPlaneacionCompra) {
		this.mostrarid_periodoPlaneacionCompra= mostrarid_periodoPlaneacionCompra;
	}

	public Boolean getActivarid_periodoPlaneacionCompra() {
		return this.activarid_periodoPlaneacionCompra;
	}

	public void setActivarid_periodoPlaneacionCompra(Boolean activarid_periodoPlaneacionCompra) {
		this.activarid_periodoPlaneacionCompra= activarid_periodoPlaneacionCompra;
	}

	public Boolean getCargarid_periodoPlaneacionCompra() {
		return this.cargarid_periodoPlaneacionCompra;
	}

	public void setCargarid_periodoPlaneacionCompra(Boolean cargarid_periodoPlaneacionCompra) {
		this.cargarid_periodoPlaneacionCompra= cargarid_periodoPlaneacionCompra;
	}

	public Border setResaltarid_empleadoPlaneacionCompra(ParametroGeneralUsuario parametroGeneralUsuario/*PlaneacionCompraBeanSwingJInternalFrame planeacioncompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//planeacioncompraBeanSwingJInternalFrame.jTtoolBarPlaneacionCompra.setBorder(borderResaltar);
		
		this.resaltarid_empleadoPlaneacionCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empleadoPlaneacionCompra() {
		return this.resaltarid_empleadoPlaneacionCompra;
	}

	public void setResaltarid_empleadoPlaneacionCompra(Border borderResaltar) {
		this.resaltarid_empleadoPlaneacionCompra= borderResaltar;
	}

	public Boolean getMostrarid_empleadoPlaneacionCompra() {
		return this.mostrarid_empleadoPlaneacionCompra;
	}

	public void setMostrarid_empleadoPlaneacionCompra(Boolean mostrarid_empleadoPlaneacionCompra) {
		this.mostrarid_empleadoPlaneacionCompra= mostrarid_empleadoPlaneacionCompra;
	}

	public Boolean getActivarid_empleadoPlaneacionCompra() {
		return this.activarid_empleadoPlaneacionCompra;
	}

	public void setActivarid_empleadoPlaneacionCompra(Boolean activarid_empleadoPlaneacionCompra) {
		this.activarid_empleadoPlaneacionCompra= activarid_empleadoPlaneacionCompra;
	}

	public Boolean getCargarid_empleadoPlaneacionCompra() {
		return this.cargarid_empleadoPlaneacionCompra;
	}

	public void setCargarid_empleadoPlaneacionCompra(Boolean cargarid_empleadoPlaneacionCompra) {
		this.cargarid_empleadoPlaneacionCompra= cargarid_empleadoPlaneacionCompra;
	}

	public Border setResaltarid_usuarioPlaneacionCompra(ParametroGeneralUsuario parametroGeneralUsuario/*PlaneacionCompraBeanSwingJInternalFrame planeacioncompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//planeacioncompraBeanSwingJInternalFrame.jTtoolBarPlaneacionCompra.setBorder(borderResaltar);
		
		this.resaltarid_usuarioPlaneacionCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_usuarioPlaneacionCompra() {
		return this.resaltarid_usuarioPlaneacionCompra;
	}

	public void setResaltarid_usuarioPlaneacionCompra(Border borderResaltar) {
		this.resaltarid_usuarioPlaneacionCompra= borderResaltar;
	}

	public Boolean getMostrarid_usuarioPlaneacionCompra() {
		return this.mostrarid_usuarioPlaneacionCompra;
	}

	public void setMostrarid_usuarioPlaneacionCompra(Boolean mostrarid_usuarioPlaneacionCompra) {
		this.mostrarid_usuarioPlaneacionCompra= mostrarid_usuarioPlaneacionCompra;
	}

	public Boolean getActivarid_usuarioPlaneacionCompra() {
		return this.activarid_usuarioPlaneacionCompra;
	}

	public void setActivarid_usuarioPlaneacionCompra(Boolean activarid_usuarioPlaneacionCompra) {
		this.activarid_usuarioPlaneacionCompra= activarid_usuarioPlaneacionCompra;
	}

	public Boolean getCargarid_usuarioPlaneacionCompra() {
		return this.cargarid_usuarioPlaneacionCompra;
	}

	public void setCargarid_usuarioPlaneacionCompra(Boolean cargarid_usuarioPlaneacionCompra) {
		this.cargarid_usuarioPlaneacionCompra= cargarid_usuarioPlaneacionCompra;
	}

	public Border setResaltarid_formatoPlaneacionCompra(ParametroGeneralUsuario parametroGeneralUsuario/*PlaneacionCompraBeanSwingJInternalFrame planeacioncompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//planeacioncompraBeanSwingJInternalFrame.jTtoolBarPlaneacionCompra.setBorder(borderResaltar);
		
		this.resaltarid_formatoPlaneacionCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_formatoPlaneacionCompra() {
		return this.resaltarid_formatoPlaneacionCompra;
	}

	public void setResaltarid_formatoPlaneacionCompra(Border borderResaltar) {
		this.resaltarid_formatoPlaneacionCompra= borderResaltar;
	}

	public Boolean getMostrarid_formatoPlaneacionCompra() {
		return this.mostrarid_formatoPlaneacionCompra;
	}

	public void setMostrarid_formatoPlaneacionCompra(Boolean mostrarid_formatoPlaneacionCompra) {
		this.mostrarid_formatoPlaneacionCompra= mostrarid_formatoPlaneacionCompra;
	}

	public Boolean getActivarid_formatoPlaneacionCompra() {
		return this.activarid_formatoPlaneacionCompra;
	}

	public void setActivarid_formatoPlaneacionCompra(Boolean activarid_formatoPlaneacionCompra) {
		this.activarid_formatoPlaneacionCompra= activarid_formatoPlaneacionCompra;
	}

	public Boolean getCargarid_formatoPlaneacionCompra() {
		return this.cargarid_formatoPlaneacionCompra;
	}

	public void setCargarid_formatoPlaneacionCompra(Boolean cargarid_formatoPlaneacionCompra) {
		this.cargarid_formatoPlaneacionCompra= cargarid_formatoPlaneacionCompra;
	}

	public Border setResaltarnumero_pre_impresoPlaneacionCompra(ParametroGeneralUsuario parametroGeneralUsuario/*PlaneacionCompraBeanSwingJInternalFrame planeacioncompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//planeacioncompraBeanSwingJInternalFrame.jTtoolBarPlaneacionCompra.setBorder(borderResaltar);
		
		this.resaltarnumero_pre_impresoPlaneacionCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_pre_impresoPlaneacionCompra() {
		return this.resaltarnumero_pre_impresoPlaneacionCompra;
	}

	public void setResaltarnumero_pre_impresoPlaneacionCompra(Border borderResaltar) {
		this.resaltarnumero_pre_impresoPlaneacionCompra= borderResaltar;
	}

	public Boolean getMostrarnumero_pre_impresoPlaneacionCompra() {
		return this.mostrarnumero_pre_impresoPlaneacionCompra;
	}

	public void setMostrarnumero_pre_impresoPlaneacionCompra(Boolean mostrarnumero_pre_impresoPlaneacionCompra) {
		this.mostrarnumero_pre_impresoPlaneacionCompra= mostrarnumero_pre_impresoPlaneacionCompra;
	}

	public Boolean getActivarnumero_pre_impresoPlaneacionCompra() {
		return this.activarnumero_pre_impresoPlaneacionCompra;
	}

	public void setActivarnumero_pre_impresoPlaneacionCompra(Boolean activarnumero_pre_impresoPlaneacionCompra) {
		this.activarnumero_pre_impresoPlaneacionCompra= activarnumero_pre_impresoPlaneacionCompra;
	}

	public Border setResaltarfechaPlaneacionCompra(ParametroGeneralUsuario parametroGeneralUsuario/*PlaneacionCompraBeanSwingJInternalFrame planeacioncompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//planeacioncompraBeanSwingJInternalFrame.jTtoolBarPlaneacionCompra.setBorder(borderResaltar);
		
		this.resaltarfechaPlaneacionCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfechaPlaneacionCompra() {
		return this.resaltarfechaPlaneacionCompra;
	}

	public void setResaltarfechaPlaneacionCompra(Border borderResaltar) {
		this.resaltarfechaPlaneacionCompra= borderResaltar;
	}

	public Boolean getMostrarfechaPlaneacionCompra() {
		return this.mostrarfechaPlaneacionCompra;
	}

	public void setMostrarfechaPlaneacionCompra(Boolean mostrarfechaPlaneacionCompra) {
		this.mostrarfechaPlaneacionCompra= mostrarfechaPlaneacionCompra;
	}

	public Boolean getActivarfechaPlaneacionCompra() {
		return this.activarfechaPlaneacionCompra;
	}

	public void setActivarfechaPlaneacionCompra(Boolean activarfechaPlaneacionCompra) {
		this.activarfechaPlaneacionCompra= activarfechaPlaneacionCompra;
	}

	public Border setResaltarid_mes_inicioPlaneacionCompra(ParametroGeneralUsuario parametroGeneralUsuario/*PlaneacionCompraBeanSwingJInternalFrame planeacioncompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//planeacioncompraBeanSwingJInternalFrame.jTtoolBarPlaneacionCompra.setBorder(borderResaltar);
		
		this.resaltarid_mes_inicioPlaneacionCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_mes_inicioPlaneacionCompra() {
		return this.resaltarid_mes_inicioPlaneacionCompra;
	}

	public void setResaltarid_mes_inicioPlaneacionCompra(Border borderResaltar) {
		this.resaltarid_mes_inicioPlaneacionCompra= borderResaltar;
	}

	public Boolean getMostrarid_mes_inicioPlaneacionCompra() {
		return this.mostrarid_mes_inicioPlaneacionCompra;
	}

	public void setMostrarid_mes_inicioPlaneacionCompra(Boolean mostrarid_mes_inicioPlaneacionCompra) {
		this.mostrarid_mes_inicioPlaneacionCompra= mostrarid_mes_inicioPlaneacionCompra;
	}

	public Boolean getActivarid_mes_inicioPlaneacionCompra() {
		return this.activarid_mes_inicioPlaneacionCompra;
	}

	public void setActivarid_mes_inicioPlaneacionCompra(Boolean activarid_mes_inicioPlaneacionCompra) {
		this.activarid_mes_inicioPlaneacionCompra= activarid_mes_inicioPlaneacionCompra;
	}

	public Boolean getCargarid_mes_inicioPlaneacionCompra() {
		return this.cargarid_mes_inicioPlaneacionCompra;
	}

	public void setCargarid_mes_inicioPlaneacionCompra(Boolean cargarid_mes_inicioPlaneacionCompra) {
		this.cargarid_mes_inicioPlaneacionCompra= cargarid_mes_inicioPlaneacionCompra;
	}

	public Border setResaltarid_mes_finPlaneacionCompra(ParametroGeneralUsuario parametroGeneralUsuario/*PlaneacionCompraBeanSwingJInternalFrame planeacioncompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//planeacioncompraBeanSwingJInternalFrame.jTtoolBarPlaneacionCompra.setBorder(borderResaltar);
		
		this.resaltarid_mes_finPlaneacionCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_mes_finPlaneacionCompra() {
		return this.resaltarid_mes_finPlaneacionCompra;
	}

	public void setResaltarid_mes_finPlaneacionCompra(Border borderResaltar) {
		this.resaltarid_mes_finPlaneacionCompra= borderResaltar;
	}

	public Boolean getMostrarid_mes_finPlaneacionCompra() {
		return this.mostrarid_mes_finPlaneacionCompra;
	}

	public void setMostrarid_mes_finPlaneacionCompra(Boolean mostrarid_mes_finPlaneacionCompra) {
		this.mostrarid_mes_finPlaneacionCompra= mostrarid_mes_finPlaneacionCompra;
	}

	public Boolean getActivarid_mes_finPlaneacionCompra() {
		return this.activarid_mes_finPlaneacionCompra;
	}

	public void setActivarid_mes_finPlaneacionCompra(Boolean activarid_mes_finPlaneacionCompra) {
		this.activarid_mes_finPlaneacionCompra= activarid_mes_finPlaneacionCompra;
	}

	public Boolean getCargarid_mes_finPlaneacionCompra() {
		return this.cargarid_mes_finPlaneacionCompra;
	}

	public void setCargarid_mes_finPlaneacionCompra(Boolean cargarid_mes_finPlaneacionCompra) {
		this.cargarid_mes_finPlaneacionCompra= cargarid_mes_finPlaneacionCompra;
	}

	public Border setResaltarnumero_mesesPlaneacionCompra(ParametroGeneralUsuario parametroGeneralUsuario/*PlaneacionCompraBeanSwingJInternalFrame planeacioncompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//planeacioncompraBeanSwingJInternalFrame.jTtoolBarPlaneacionCompra.setBorder(borderResaltar);
		
		this.resaltarnumero_mesesPlaneacionCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_mesesPlaneacionCompra() {
		return this.resaltarnumero_mesesPlaneacionCompra;
	}

	public void setResaltarnumero_mesesPlaneacionCompra(Border borderResaltar) {
		this.resaltarnumero_mesesPlaneacionCompra= borderResaltar;
	}

	public Boolean getMostrarnumero_mesesPlaneacionCompra() {
		return this.mostrarnumero_mesesPlaneacionCompra;
	}

	public void setMostrarnumero_mesesPlaneacionCompra(Boolean mostrarnumero_mesesPlaneacionCompra) {
		this.mostrarnumero_mesesPlaneacionCompra= mostrarnumero_mesesPlaneacionCompra;
	}

	public Boolean getActivarnumero_mesesPlaneacionCompra() {
		return this.activarnumero_mesesPlaneacionCompra;
	}

	public void setActivarnumero_mesesPlaneacionCompra(Boolean activarnumero_mesesPlaneacionCompra) {
		this.activarnumero_mesesPlaneacionCompra= activarnumero_mesesPlaneacionCompra;
	}

	public Border setResaltarfecha_cortePlaneacionCompra(ParametroGeneralUsuario parametroGeneralUsuario/*PlaneacionCompraBeanSwingJInternalFrame planeacioncompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//planeacioncompraBeanSwingJInternalFrame.jTtoolBarPlaneacionCompra.setBorder(borderResaltar);
		
		this.resaltarfecha_cortePlaneacionCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_cortePlaneacionCompra() {
		return this.resaltarfecha_cortePlaneacionCompra;
	}

	public void setResaltarfecha_cortePlaneacionCompra(Border borderResaltar) {
		this.resaltarfecha_cortePlaneacionCompra= borderResaltar;
	}

	public Boolean getMostrarfecha_cortePlaneacionCompra() {
		return this.mostrarfecha_cortePlaneacionCompra;
	}

	public void setMostrarfecha_cortePlaneacionCompra(Boolean mostrarfecha_cortePlaneacionCompra) {
		this.mostrarfecha_cortePlaneacionCompra= mostrarfecha_cortePlaneacionCompra;
	}

	public Boolean getActivarfecha_cortePlaneacionCompra() {
		return this.activarfecha_cortePlaneacionCompra;
	}

	public void setActivarfecha_cortePlaneacionCompra(Boolean activarfecha_cortePlaneacionCompra) {
		this.activarfecha_cortePlaneacionCompra= activarfecha_cortePlaneacionCompra;
	}

	public Border setResaltarcodigo_pedidoPlaneacionCompra(ParametroGeneralUsuario parametroGeneralUsuario/*PlaneacionCompraBeanSwingJInternalFrame planeacioncompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//planeacioncompraBeanSwingJInternalFrame.jTtoolBarPlaneacionCompra.setBorder(borderResaltar);
		
		this.resaltarcodigo_pedidoPlaneacionCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigo_pedidoPlaneacionCompra() {
		return this.resaltarcodigo_pedidoPlaneacionCompra;
	}

	public void setResaltarcodigo_pedidoPlaneacionCompra(Border borderResaltar) {
		this.resaltarcodigo_pedidoPlaneacionCompra= borderResaltar;
	}

	public Boolean getMostrarcodigo_pedidoPlaneacionCompra() {
		return this.mostrarcodigo_pedidoPlaneacionCompra;
	}

	public void setMostrarcodigo_pedidoPlaneacionCompra(Boolean mostrarcodigo_pedidoPlaneacionCompra) {
		this.mostrarcodigo_pedidoPlaneacionCompra= mostrarcodigo_pedidoPlaneacionCompra;
	}

	public Boolean getActivarcodigo_pedidoPlaneacionCompra() {
		return this.activarcodigo_pedidoPlaneacionCompra;
	}

	public void setActivarcodigo_pedidoPlaneacionCompra(Boolean activarcodigo_pedidoPlaneacionCompra) {
		this.activarcodigo_pedidoPlaneacionCompra= activarcodigo_pedidoPlaneacionCompra;
	}

	public Border setResaltardescripcion1PlaneacionCompra(ParametroGeneralUsuario parametroGeneralUsuario/*PlaneacionCompraBeanSwingJInternalFrame planeacioncompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//planeacioncompraBeanSwingJInternalFrame.jTtoolBarPlaneacionCompra.setBorder(borderResaltar);
		
		this.resaltardescripcion1PlaneacionCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcion1PlaneacionCompra() {
		return this.resaltardescripcion1PlaneacionCompra;
	}

	public void setResaltardescripcion1PlaneacionCompra(Border borderResaltar) {
		this.resaltardescripcion1PlaneacionCompra= borderResaltar;
	}

	public Boolean getMostrardescripcion1PlaneacionCompra() {
		return this.mostrardescripcion1PlaneacionCompra;
	}

	public void setMostrardescripcion1PlaneacionCompra(Boolean mostrardescripcion1PlaneacionCompra) {
		this.mostrardescripcion1PlaneacionCompra= mostrardescripcion1PlaneacionCompra;
	}

	public Boolean getActivardescripcion1PlaneacionCompra() {
		return this.activardescripcion1PlaneacionCompra;
	}

	public void setActivardescripcion1PlaneacionCompra(Boolean activardescripcion1PlaneacionCompra) {
		this.activardescripcion1PlaneacionCompra= activardescripcion1PlaneacionCompra;
	}

	public Border setResaltardescripcion2PlaneacionCompra(ParametroGeneralUsuario parametroGeneralUsuario/*PlaneacionCompraBeanSwingJInternalFrame planeacioncompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//planeacioncompraBeanSwingJInternalFrame.jTtoolBarPlaneacionCompra.setBorder(borderResaltar);
		
		this.resaltardescripcion2PlaneacionCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcion2PlaneacionCompra() {
		return this.resaltardescripcion2PlaneacionCompra;
	}

	public void setResaltardescripcion2PlaneacionCompra(Border borderResaltar) {
		this.resaltardescripcion2PlaneacionCompra= borderResaltar;
	}

	public Boolean getMostrardescripcion2PlaneacionCompra() {
		return this.mostrardescripcion2PlaneacionCompra;
	}

	public void setMostrardescripcion2PlaneacionCompra(Boolean mostrardescripcion2PlaneacionCompra) {
		this.mostrardescripcion2PlaneacionCompra= mostrardescripcion2PlaneacionCompra;
	}

	public Boolean getActivardescripcion2PlaneacionCompra() {
		return this.activardescripcion2PlaneacionCompra;
	}

	public void setActivardescripcion2PlaneacionCompra(Boolean activardescripcion2PlaneacionCompra) {
		this.activardescripcion2PlaneacionCompra= activardescripcion2PlaneacionCompra;
	}

	public Border setResaltardescripcion3PlaneacionCompra(ParametroGeneralUsuario parametroGeneralUsuario/*PlaneacionCompraBeanSwingJInternalFrame planeacioncompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//planeacioncompraBeanSwingJInternalFrame.jTtoolBarPlaneacionCompra.setBorder(borderResaltar);
		
		this.resaltardescripcion3PlaneacionCompra= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcion3PlaneacionCompra() {
		return this.resaltardescripcion3PlaneacionCompra;
	}

	public void setResaltardescripcion3PlaneacionCompra(Border borderResaltar) {
		this.resaltardescripcion3PlaneacionCompra= borderResaltar;
	}

	public Boolean getMostrardescripcion3PlaneacionCompra() {
		return this.mostrardescripcion3PlaneacionCompra;
	}

	public void setMostrardescripcion3PlaneacionCompra(Boolean mostrardescripcion3PlaneacionCompra) {
		this.mostrardescripcion3PlaneacionCompra= mostrardescripcion3PlaneacionCompra;
	}

	public Boolean getActivardescripcion3PlaneacionCompra() {
		return this.activardescripcion3PlaneacionCompra;
	}

	public void setActivardescripcion3PlaneacionCompra(Boolean activardescripcion3PlaneacionCompra) {
		this.activardescripcion3PlaneacionCompra= activardescripcion3PlaneacionCompra;
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
		
		
		this.setMostraridPlaneacionCompra(esInicial);
		this.setMostrarid_empresaPlaneacionCompra(esInicial);
		this.setMostrarid_sucursalPlaneacionCompra(esInicial);
		this.setMostrarid_ejercicioPlaneacionCompra(esInicial);
		this.setMostrarid_periodoPlaneacionCompra(esInicial);
		this.setMostrarid_empleadoPlaneacionCompra(esInicial);
		this.setMostrarid_usuarioPlaneacionCompra(esInicial);
		this.setMostrarid_formatoPlaneacionCompra(esInicial);
		this.setMostrarnumero_pre_impresoPlaneacionCompra(esInicial);
		this.setMostrarfechaPlaneacionCompra(esInicial);
		this.setMostrarid_mes_inicioPlaneacionCompra(esInicial);
		this.setMostrarid_mes_finPlaneacionCompra(esInicial);
		this.setMostrarnumero_mesesPlaneacionCompra(esInicial);
		this.setMostrarfecha_cortePlaneacionCompra(esInicial);
		this.setMostrarcodigo_pedidoPlaneacionCompra(esInicial);
		this.setMostrardescripcion1PlaneacionCompra(esInicial);
		this.setMostrardescripcion2PlaneacionCompra(esInicial);
		this.setMostrardescripcion3PlaneacionCompra(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PlaneacionCompraConstantesFunciones.ID)) {
				this.setMostraridPlaneacionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlaneacionCompraConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaPlaneacionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlaneacionCompraConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalPlaneacionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlaneacionCompraConstantesFunciones.IDEJERCICIO)) {
				this.setMostrarid_ejercicioPlaneacionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlaneacionCompraConstantesFunciones.IDPERIODO)) {
				this.setMostrarid_periodoPlaneacionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlaneacionCompraConstantesFunciones.IDEMPLEADO)) {
				this.setMostrarid_empleadoPlaneacionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlaneacionCompraConstantesFunciones.IDUSUARIO)) {
				this.setMostrarid_usuarioPlaneacionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlaneacionCompraConstantesFunciones.IDFORMATO)) {
				this.setMostrarid_formatoPlaneacionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlaneacionCompraConstantesFunciones.NUMEROPREIMPRESO)) {
				this.setMostrarnumero_pre_impresoPlaneacionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlaneacionCompraConstantesFunciones.FECHA)) {
				this.setMostrarfechaPlaneacionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlaneacionCompraConstantesFunciones.IDMESINICIO)) {
				this.setMostrarid_mes_inicioPlaneacionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlaneacionCompraConstantesFunciones.IDMESFIN)) {
				this.setMostrarid_mes_finPlaneacionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlaneacionCompraConstantesFunciones.NUMEROMESES)) {
				this.setMostrarnumero_mesesPlaneacionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlaneacionCompraConstantesFunciones.FECHACORTE)) {
				this.setMostrarfecha_cortePlaneacionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlaneacionCompraConstantesFunciones.CODIGOPEDIDO)) {
				this.setMostrarcodigo_pedidoPlaneacionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlaneacionCompraConstantesFunciones.DESCRIPCION1)) {
				this.setMostrardescripcion1PlaneacionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlaneacionCompraConstantesFunciones.DESCRIPCION2)) {
				this.setMostrardescripcion2PlaneacionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlaneacionCompraConstantesFunciones.DESCRIPCION3)) {
				this.setMostrardescripcion3PlaneacionCompra(esAsigna);
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
		
		
		this.setActivaridPlaneacionCompra(esInicial);
		this.setActivarid_empresaPlaneacionCompra(esInicial);
		this.setActivarid_sucursalPlaneacionCompra(esInicial);
		this.setActivarid_ejercicioPlaneacionCompra(esInicial);
		this.setActivarid_periodoPlaneacionCompra(esInicial);
		this.setActivarid_empleadoPlaneacionCompra(esInicial);
		this.setActivarid_usuarioPlaneacionCompra(esInicial);
		this.setActivarid_formatoPlaneacionCompra(esInicial);
		this.setActivarnumero_pre_impresoPlaneacionCompra(esInicial);
		this.setActivarfechaPlaneacionCompra(esInicial);
		this.setActivarid_mes_inicioPlaneacionCompra(esInicial);
		this.setActivarid_mes_finPlaneacionCompra(esInicial);
		this.setActivarnumero_mesesPlaneacionCompra(esInicial);
		this.setActivarfecha_cortePlaneacionCompra(esInicial);
		this.setActivarcodigo_pedidoPlaneacionCompra(esInicial);
		this.setActivardescripcion1PlaneacionCompra(esInicial);
		this.setActivardescripcion2PlaneacionCompra(esInicial);
		this.setActivardescripcion3PlaneacionCompra(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PlaneacionCompraConstantesFunciones.ID)) {
				this.setActivaridPlaneacionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlaneacionCompraConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaPlaneacionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlaneacionCompraConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalPlaneacionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlaneacionCompraConstantesFunciones.IDEJERCICIO)) {
				this.setActivarid_ejercicioPlaneacionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlaneacionCompraConstantesFunciones.IDPERIODO)) {
				this.setActivarid_periodoPlaneacionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlaneacionCompraConstantesFunciones.IDEMPLEADO)) {
				this.setActivarid_empleadoPlaneacionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlaneacionCompraConstantesFunciones.IDUSUARIO)) {
				this.setActivarid_usuarioPlaneacionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlaneacionCompraConstantesFunciones.IDFORMATO)) {
				this.setActivarid_formatoPlaneacionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlaneacionCompraConstantesFunciones.NUMEROPREIMPRESO)) {
				this.setActivarnumero_pre_impresoPlaneacionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlaneacionCompraConstantesFunciones.FECHA)) {
				this.setActivarfechaPlaneacionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlaneacionCompraConstantesFunciones.IDMESINICIO)) {
				this.setActivarid_mes_inicioPlaneacionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlaneacionCompraConstantesFunciones.IDMESFIN)) {
				this.setActivarid_mes_finPlaneacionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlaneacionCompraConstantesFunciones.NUMEROMESES)) {
				this.setActivarnumero_mesesPlaneacionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlaneacionCompraConstantesFunciones.FECHACORTE)) {
				this.setActivarfecha_cortePlaneacionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlaneacionCompraConstantesFunciones.CODIGOPEDIDO)) {
				this.setActivarcodigo_pedidoPlaneacionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlaneacionCompraConstantesFunciones.DESCRIPCION1)) {
				this.setActivardescripcion1PlaneacionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlaneacionCompraConstantesFunciones.DESCRIPCION2)) {
				this.setActivardescripcion2PlaneacionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlaneacionCompraConstantesFunciones.DESCRIPCION3)) {
				this.setActivardescripcion3PlaneacionCompra(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,PlaneacionCompraBeanSwingJInternalFrame planeacioncompraBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridPlaneacionCompra(esInicial);
		this.setResaltarid_empresaPlaneacionCompra(esInicial);
		this.setResaltarid_sucursalPlaneacionCompra(esInicial);
		this.setResaltarid_ejercicioPlaneacionCompra(esInicial);
		this.setResaltarid_periodoPlaneacionCompra(esInicial);
		this.setResaltarid_empleadoPlaneacionCompra(esInicial);
		this.setResaltarid_usuarioPlaneacionCompra(esInicial);
		this.setResaltarid_formatoPlaneacionCompra(esInicial);
		this.setResaltarnumero_pre_impresoPlaneacionCompra(esInicial);
		this.setResaltarfechaPlaneacionCompra(esInicial);
		this.setResaltarid_mes_inicioPlaneacionCompra(esInicial);
		this.setResaltarid_mes_finPlaneacionCompra(esInicial);
		this.setResaltarnumero_mesesPlaneacionCompra(esInicial);
		this.setResaltarfecha_cortePlaneacionCompra(esInicial);
		this.setResaltarcodigo_pedidoPlaneacionCompra(esInicial);
		this.setResaltardescripcion1PlaneacionCompra(esInicial);
		this.setResaltardescripcion2PlaneacionCompra(esInicial);
		this.setResaltardescripcion3PlaneacionCompra(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(PlaneacionCompraConstantesFunciones.ID)) {
				this.setResaltaridPlaneacionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlaneacionCompraConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaPlaneacionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlaneacionCompraConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalPlaneacionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlaneacionCompraConstantesFunciones.IDEJERCICIO)) {
				this.setResaltarid_ejercicioPlaneacionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlaneacionCompraConstantesFunciones.IDPERIODO)) {
				this.setResaltarid_periodoPlaneacionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlaneacionCompraConstantesFunciones.IDEMPLEADO)) {
				this.setResaltarid_empleadoPlaneacionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlaneacionCompraConstantesFunciones.IDUSUARIO)) {
				this.setResaltarid_usuarioPlaneacionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlaneacionCompraConstantesFunciones.IDFORMATO)) {
				this.setResaltarid_formatoPlaneacionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlaneacionCompraConstantesFunciones.NUMEROPREIMPRESO)) {
				this.setResaltarnumero_pre_impresoPlaneacionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlaneacionCompraConstantesFunciones.FECHA)) {
				this.setResaltarfechaPlaneacionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlaneacionCompraConstantesFunciones.IDMESINICIO)) {
				this.setResaltarid_mes_inicioPlaneacionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlaneacionCompraConstantesFunciones.IDMESFIN)) {
				this.setResaltarid_mes_finPlaneacionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlaneacionCompraConstantesFunciones.NUMEROMESES)) {
				this.setResaltarnumero_mesesPlaneacionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlaneacionCompraConstantesFunciones.FECHACORTE)) {
				this.setResaltarfecha_cortePlaneacionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlaneacionCompraConstantesFunciones.CODIGOPEDIDO)) {
				this.setResaltarcodigo_pedidoPlaneacionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlaneacionCompraConstantesFunciones.DESCRIPCION1)) {
				this.setResaltardescripcion1PlaneacionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlaneacionCompraConstantesFunciones.DESCRIPCION2)) {
				this.setResaltardescripcion2PlaneacionCompra(esAsigna);
				continue;
			}

			if(campo.clase.equals(PlaneacionCompraConstantesFunciones.DESCRIPCION3)) {
				this.setResaltardescripcion3PlaneacionCompra(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarDetallePlaneacionCompraPlaneacionCompra=null;

	public Border getResaltarDetallePlaneacionCompraPlaneacionCompra() {
		return this.resaltarDetallePlaneacionCompraPlaneacionCompra;
	}

	public void setResaltarDetallePlaneacionCompraPlaneacionCompra(Border borderResaltarDetallePlaneacionCompra) {
		if(borderResaltarDetallePlaneacionCompra!=null) {
			this.resaltarDetallePlaneacionCompraPlaneacionCompra= borderResaltarDetallePlaneacionCompra;
		}
	}

	public Border setResaltarDetallePlaneacionCompraPlaneacionCompra(ParametroGeneralUsuario parametroGeneralUsuario/*PlaneacionCompraBeanSwingJInternalFrame planeacioncompraBeanSwingJInternalFrame*/) {
		Border borderResaltarDetallePlaneacionCompra=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//planeacioncompraBeanSwingJInternalFrame.jTtoolBarPlaneacionCompra.setBorder(borderResaltarDetallePlaneacionCompra);
			
		this.resaltarDetallePlaneacionCompraPlaneacionCompra= borderResaltarDetallePlaneacionCompra;

		 return borderResaltarDetallePlaneacionCompra;
	}



	public Boolean mostrarDetallePlaneacionCompraPlaneacionCompra=true;

	public Boolean getMostrarDetallePlaneacionCompraPlaneacionCompra() {
		return this.mostrarDetallePlaneacionCompraPlaneacionCompra;
	}

	public void setMostrarDetallePlaneacionCompraPlaneacionCompra(Boolean visibilidadResaltarDetallePlaneacionCompra) {
		this.mostrarDetallePlaneacionCompraPlaneacionCompra= visibilidadResaltarDetallePlaneacionCompra;
	}



	public Boolean activarDetallePlaneacionCompraPlaneacionCompra=true;

	public Boolean gethabilitarResaltarDetallePlaneacionCompraPlaneacionCompra() {
		return this.activarDetallePlaneacionCompraPlaneacionCompra;
	}

	public void setActivarDetallePlaneacionCompraPlaneacionCompra(Boolean habilitarResaltarDetallePlaneacionCompra) {
		this.activarDetallePlaneacionCompraPlaneacionCompra= habilitarResaltarDetallePlaneacionCompra;
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

		this.setMostrarDetallePlaneacionCompraPlaneacionCompra(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetallePlaneacionCompra.class)) {
				this.setMostrarDetallePlaneacionCompraPlaneacionCompra(esAsigna);
				continue;
			}
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

		this.setActivarDetallePlaneacionCompraPlaneacionCompra(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetallePlaneacionCompra.class)) {
				this.setActivarDetallePlaneacionCompraPlaneacionCompra(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,PlaneacionCompraBeanSwingJInternalFrame planeacioncompraBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarDetallePlaneacionCompraPlaneacionCompra(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetallePlaneacionCompra.class)) {
				this.setResaltarDetallePlaneacionCompraPlaneacionCompra(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarFK_IdEjercicioPlaneacionCompra=true;

	public Boolean getMostrarFK_IdEjercicioPlaneacionCompra() {
		return this.mostrarFK_IdEjercicioPlaneacionCompra;
	}

	public void setMostrarFK_IdEjercicioPlaneacionCompra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEjercicioPlaneacionCompra= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpleadoPlaneacionCompra=true;

	public Boolean getMostrarFK_IdEmpleadoPlaneacionCompra() {
		return this.mostrarFK_IdEmpleadoPlaneacionCompra;
	}

	public void setMostrarFK_IdEmpleadoPlaneacionCompra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpleadoPlaneacionCompra= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaPlaneacionCompra=true;

	public Boolean getMostrarFK_IdEmpresaPlaneacionCompra() {
		return this.mostrarFK_IdEmpresaPlaneacionCompra;
	}

	public void setMostrarFK_IdEmpresaPlaneacionCompra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaPlaneacionCompra= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdFormatoPlaneacionCompra=true;

	public Boolean getMostrarFK_IdFormatoPlaneacionCompra() {
		return this.mostrarFK_IdFormatoPlaneacionCompra;
	}

	public void setMostrarFK_IdFormatoPlaneacionCompra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdFormatoPlaneacionCompra= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdMesFinPlaneacionCompra=true;

	public Boolean getMostrarFK_IdMesFinPlaneacionCompra() {
		return this.mostrarFK_IdMesFinPlaneacionCompra;
	}

	public void setMostrarFK_IdMesFinPlaneacionCompra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdMesFinPlaneacionCompra= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdMesInicioPlaneacionCompra=true;

	public Boolean getMostrarFK_IdMesInicioPlaneacionCompra() {
		return this.mostrarFK_IdMesInicioPlaneacionCompra;
	}

	public void setMostrarFK_IdMesInicioPlaneacionCompra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdMesInicioPlaneacionCompra= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPeriodoPlaneacionCompra=true;

	public Boolean getMostrarFK_IdPeriodoPlaneacionCompra() {
		return this.mostrarFK_IdPeriodoPlaneacionCompra;
	}

	public void setMostrarFK_IdPeriodoPlaneacionCompra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPeriodoPlaneacionCompra= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalPlaneacionCompra=true;

	public Boolean getMostrarFK_IdSucursalPlaneacionCompra() {
		return this.mostrarFK_IdSucursalPlaneacionCompra;
	}

	public void setMostrarFK_IdSucursalPlaneacionCompra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalPlaneacionCompra= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdUsuarioPlaneacionCompra=true;

	public Boolean getMostrarFK_IdUsuarioPlaneacionCompra() {
		return this.mostrarFK_IdUsuarioPlaneacionCompra;
	}

	public void setMostrarFK_IdUsuarioPlaneacionCompra(Boolean visibilidadResaltar) {
		this.mostrarFK_IdUsuarioPlaneacionCompra= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdEjercicioPlaneacionCompra=true;

	public Boolean getActivarFK_IdEjercicioPlaneacionCompra() {
		return this.activarFK_IdEjercicioPlaneacionCompra;
	}

	public void setActivarFK_IdEjercicioPlaneacionCompra(Boolean habilitarResaltar) {
		this.activarFK_IdEjercicioPlaneacionCompra= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpleadoPlaneacionCompra=true;

	public Boolean getActivarFK_IdEmpleadoPlaneacionCompra() {
		return this.activarFK_IdEmpleadoPlaneacionCompra;
	}

	public void setActivarFK_IdEmpleadoPlaneacionCompra(Boolean habilitarResaltar) {
		this.activarFK_IdEmpleadoPlaneacionCompra= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaPlaneacionCompra=true;

	public Boolean getActivarFK_IdEmpresaPlaneacionCompra() {
		return this.activarFK_IdEmpresaPlaneacionCompra;
	}

	public void setActivarFK_IdEmpresaPlaneacionCompra(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaPlaneacionCompra= habilitarResaltar;
	}

	public Boolean activarFK_IdFormatoPlaneacionCompra=true;

	public Boolean getActivarFK_IdFormatoPlaneacionCompra() {
		return this.activarFK_IdFormatoPlaneacionCompra;
	}

	public void setActivarFK_IdFormatoPlaneacionCompra(Boolean habilitarResaltar) {
		this.activarFK_IdFormatoPlaneacionCompra= habilitarResaltar;
	}

	public Boolean activarFK_IdMesFinPlaneacionCompra=true;

	public Boolean getActivarFK_IdMesFinPlaneacionCompra() {
		return this.activarFK_IdMesFinPlaneacionCompra;
	}

	public void setActivarFK_IdMesFinPlaneacionCompra(Boolean habilitarResaltar) {
		this.activarFK_IdMesFinPlaneacionCompra= habilitarResaltar;
	}

	public Boolean activarFK_IdMesInicioPlaneacionCompra=true;

	public Boolean getActivarFK_IdMesInicioPlaneacionCompra() {
		return this.activarFK_IdMesInicioPlaneacionCompra;
	}

	public void setActivarFK_IdMesInicioPlaneacionCompra(Boolean habilitarResaltar) {
		this.activarFK_IdMesInicioPlaneacionCompra= habilitarResaltar;
	}

	public Boolean activarFK_IdPeriodoPlaneacionCompra=true;

	public Boolean getActivarFK_IdPeriodoPlaneacionCompra() {
		return this.activarFK_IdPeriodoPlaneacionCompra;
	}

	public void setActivarFK_IdPeriodoPlaneacionCompra(Boolean habilitarResaltar) {
		this.activarFK_IdPeriodoPlaneacionCompra= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalPlaneacionCompra=true;

	public Boolean getActivarFK_IdSucursalPlaneacionCompra() {
		return this.activarFK_IdSucursalPlaneacionCompra;
	}

	public void setActivarFK_IdSucursalPlaneacionCompra(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalPlaneacionCompra= habilitarResaltar;
	}

	public Boolean activarFK_IdUsuarioPlaneacionCompra=true;

	public Boolean getActivarFK_IdUsuarioPlaneacionCompra() {
		return this.activarFK_IdUsuarioPlaneacionCompra;
	}

	public void setActivarFK_IdUsuarioPlaneacionCompra(Boolean habilitarResaltar) {
		this.activarFK_IdUsuarioPlaneacionCompra= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdEjercicioPlaneacionCompra=null;

	public Border getResaltarFK_IdEjercicioPlaneacionCompra() {
		return this.resaltarFK_IdEjercicioPlaneacionCompra;
	}

	public void setResaltarFK_IdEjercicioPlaneacionCompra(Border borderResaltar) {
		this.resaltarFK_IdEjercicioPlaneacionCompra= borderResaltar;
	}

	public void setResaltarFK_IdEjercicioPlaneacionCompra(ParametroGeneralUsuario parametroGeneralUsuario/*PlaneacionCompraBeanSwingJInternalFrame planeacioncompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEjercicioPlaneacionCompra= borderResaltar;
	}

	public Border resaltarFK_IdEmpleadoPlaneacionCompra=null;

	public Border getResaltarFK_IdEmpleadoPlaneacionCompra() {
		return this.resaltarFK_IdEmpleadoPlaneacionCompra;
	}

	public void setResaltarFK_IdEmpleadoPlaneacionCompra(Border borderResaltar) {
		this.resaltarFK_IdEmpleadoPlaneacionCompra= borderResaltar;
	}

	public void setResaltarFK_IdEmpleadoPlaneacionCompra(ParametroGeneralUsuario parametroGeneralUsuario/*PlaneacionCompraBeanSwingJInternalFrame planeacioncompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpleadoPlaneacionCompra= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaPlaneacionCompra=null;

	public Border getResaltarFK_IdEmpresaPlaneacionCompra() {
		return this.resaltarFK_IdEmpresaPlaneacionCompra;
	}

	public void setResaltarFK_IdEmpresaPlaneacionCompra(Border borderResaltar) {
		this.resaltarFK_IdEmpresaPlaneacionCompra= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaPlaneacionCompra(ParametroGeneralUsuario parametroGeneralUsuario/*PlaneacionCompraBeanSwingJInternalFrame planeacioncompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaPlaneacionCompra= borderResaltar;
	}

	public Border resaltarFK_IdFormatoPlaneacionCompra=null;

	public Border getResaltarFK_IdFormatoPlaneacionCompra() {
		return this.resaltarFK_IdFormatoPlaneacionCompra;
	}

	public void setResaltarFK_IdFormatoPlaneacionCompra(Border borderResaltar) {
		this.resaltarFK_IdFormatoPlaneacionCompra= borderResaltar;
	}

	public void setResaltarFK_IdFormatoPlaneacionCompra(ParametroGeneralUsuario parametroGeneralUsuario/*PlaneacionCompraBeanSwingJInternalFrame planeacioncompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdFormatoPlaneacionCompra= borderResaltar;
	}

	public Border resaltarFK_IdMesFinPlaneacionCompra=null;

	public Border getResaltarFK_IdMesFinPlaneacionCompra() {
		return this.resaltarFK_IdMesFinPlaneacionCompra;
	}

	public void setResaltarFK_IdMesFinPlaneacionCompra(Border borderResaltar) {
		this.resaltarFK_IdMesFinPlaneacionCompra= borderResaltar;
	}

	public void setResaltarFK_IdMesFinPlaneacionCompra(ParametroGeneralUsuario parametroGeneralUsuario/*PlaneacionCompraBeanSwingJInternalFrame planeacioncompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdMesFinPlaneacionCompra= borderResaltar;
	}

	public Border resaltarFK_IdMesInicioPlaneacionCompra=null;

	public Border getResaltarFK_IdMesInicioPlaneacionCompra() {
		return this.resaltarFK_IdMesInicioPlaneacionCompra;
	}

	public void setResaltarFK_IdMesInicioPlaneacionCompra(Border borderResaltar) {
		this.resaltarFK_IdMesInicioPlaneacionCompra= borderResaltar;
	}

	public void setResaltarFK_IdMesInicioPlaneacionCompra(ParametroGeneralUsuario parametroGeneralUsuario/*PlaneacionCompraBeanSwingJInternalFrame planeacioncompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdMesInicioPlaneacionCompra= borderResaltar;
	}

	public Border resaltarFK_IdPeriodoPlaneacionCompra=null;

	public Border getResaltarFK_IdPeriodoPlaneacionCompra() {
		return this.resaltarFK_IdPeriodoPlaneacionCompra;
	}

	public void setResaltarFK_IdPeriodoPlaneacionCompra(Border borderResaltar) {
		this.resaltarFK_IdPeriodoPlaneacionCompra= borderResaltar;
	}

	public void setResaltarFK_IdPeriodoPlaneacionCompra(ParametroGeneralUsuario parametroGeneralUsuario/*PlaneacionCompraBeanSwingJInternalFrame planeacioncompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPeriodoPlaneacionCompra= borderResaltar;
	}

	public Border resaltarFK_IdSucursalPlaneacionCompra=null;

	public Border getResaltarFK_IdSucursalPlaneacionCompra() {
		return this.resaltarFK_IdSucursalPlaneacionCompra;
	}

	public void setResaltarFK_IdSucursalPlaneacionCompra(Border borderResaltar) {
		this.resaltarFK_IdSucursalPlaneacionCompra= borderResaltar;
	}

	public void setResaltarFK_IdSucursalPlaneacionCompra(ParametroGeneralUsuario parametroGeneralUsuario/*PlaneacionCompraBeanSwingJInternalFrame planeacioncompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalPlaneacionCompra= borderResaltar;
	}

	public Border resaltarFK_IdUsuarioPlaneacionCompra=null;

	public Border getResaltarFK_IdUsuarioPlaneacionCompra() {
		return this.resaltarFK_IdUsuarioPlaneacionCompra;
	}

	public void setResaltarFK_IdUsuarioPlaneacionCompra(Border borderResaltar) {
		this.resaltarFK_IdUsuarioPlaneacionCompra= borderResaltar;
	}

	public void setResaltarFK_IdUsuarioPlaneacionCompra(ParametroGeneralUsuario parametroGeneralUsuario/*PlaneacionCompraBeanSwingJInternalFrame planeacioncompraBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdUsuarioPlaneacionCompra= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}