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
package com.bydan.erp.activosfijos.util;

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


import com.bydan.erp.activosfijos.util.MovimientoActivoFijoConstantesFunciones;
import com.bydan.erp.activosfijos.util.MovimientoActivoFijoParameterReturnGeneral;
//import com.bydan.erp.activosfijos.util.MovimientoActivoFijoParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.activosfijos.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;


import com.bydan.erp.seguridad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.activosfijos.business.dataaccess.*;
//import com.bydan.erp.activosfijos.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class MovimientoActivoFijoConstantesFunciones extends MovimientoActivoFijoConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="MovimientoActivoFijo";
	public static final String SPATHOPCION="ActivosFijos";	
	public static final String SPATHMODULO="activosfijos/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="MovimientoActivoFijo"+MovimientoActivoFijoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="MovimientoActivoFijoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="MovimientoActivoFijoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=MovimientoActivoFijoConstantesFunciones.SCHEMA+"_"+MovimientoActivoFijoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/MovimientoActivoFijoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=MovimientoActivoFijoConstantesFunciones.SCHEMA+"_"+MovimientoActivoFijoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=MovimientoActivoFijoConstantesFunciones.SCHEMA+"_"+MovimientoActivoFijoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/MovimientoActivoFijoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=MovimientoActivoFijoConstantesFunciones.SCHEMA+"_"+MovimientoActivoFijoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+MovimientoActivoFijoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/MovimientoActivoFijoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+MovimientoActivoFijoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+MovimientoActivoFijoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/MovimientoActivoFijoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+MovimientoActivoFijoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=MovimientoActivoFijoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+MovimientoActivoFijoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=MovimientoActivoFijoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+MovimientoActivoFijoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Movimiento Activo Fijos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Movimiento Activo Fijo";
	public static final String SCLASSWEBTITULO_LOWER="Movimiento Activo Fijo";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="MovimientoActivoFijo";
	public static final String OBJECTNAME="movimientoactivofijo";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_ACTIVOSFIJOS;	
	public static final String TABLENAME="movimiento_activo_fijo";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select movimientoactivofijo from "+MovimientoActivoFijoConstantesFunciones.SPERSISTENCENAME+" movimientoactivofijo";
	public static String QUERYSELECTNATIVE="select "+MovimientoActivoFijoConstantesFunciones.SCHEMA+"."+MovimientoActivoFijoConstantesFunciones.TABLENAME+".id,"+MovimientoActivoFijoConstantesFunciones.SCHEMA+"."+MovimientoActivoFijoConstantesFunciones.TABLENAME+".version_row,"+MovimientoActivoFijoConstantesFunciones.SCHEMA+"."+MovimientoActivoFijoConstantesFunciones.TABLENAME+".id_empresa,"+MovimientoActivoFijoConstantesFunciones.SCHEMA+"."+MovimientoActivoFijoConstantesFunciones.TABLENAME+".id_sucursal,"+MovimientoActivoFijoConstantesFunciones.SCHEMA+"."+MovimientoActivoFijoConstantesFunciones.TABLENAME+".id_usuario,"+MovimientoActivoFijoConstantesFunciones.SCHEMA+"."+MovimientoActivoFijoConstantesFunciones.TABLENAME+".secuencial,"+MovimientoActivoFijoConstantesFunciones.SCHEMA+"."+MovimientoActivoFijoConstantesFunciones.TABLENAME+".id_empresa_origen,"+MovimientoActivoFijoConstantesFunciones.SCHEMA+"."+MovimientoActivoFijoConstantesFunciones.TABLENAME+".id_sucursal_origen,"+MovimientoActivoFijoConstantesFunciones.SCHEMA+"."+MovimientoActivoFijoConstantesFunciones.TABLENAME+".id_detalle_activo_fijo_origen,"+MovimientoActivoFijoConstantesFunciones.SCHEMA+"."+MovimientoActivoFijoConstantesFunciones.TABLENAME+".id_empresa_destino,"+MovimientoActivoFijoConstantesFunciones.SCHEMA+"."+MovimientoActivoFijoConstantesFunciones.TABLENAME+".id_sucursal_destino,"+MovimientoActivoFijoConstantesFunciones.SCHEMA+"."+MovimientoActivoFijoConstantesFunciones.TABLENAME+".id_detalle_activo_fijo_destino,"+MovimientoActivoFijoConstantesFunciones.SCHEMA+"."+MovimientoActivoFijoConstantesFunciones.TABLENAME+".fecha,"+MovimientoActivoFijoConstantesFunciones.SCHEMA+"."+MovimientoActivoFijoConstantesFunciones.TABLENAME+".numero_documento,"+MovimientoActivoFijoConstantesFunciones.SCHEMA+"."+MovimientoActivoFijoConstantesFunciones.TABLENAME+".costo,"+MovimientoActivoFijoConstantesFunciones.SCHEMA+"."+MovimientoActivoFijoConstantesFunciones.TABLENAME+".depreciacion,"+MovimientoActivoFijoConstantesFunciones.SCHEMA+"."+MovimientoActivoFijoConstantesFunciones.TABLENAME+".costo_origen,"+MovimientoActivoFijoConstantesFunciones.SCHEMA+"."+MovimientoActivoFijoConstantesFunciones.TABLENAME+".depreciacion_origen,"+MovimientoActivoFijoConstantesFunciones.SCHEMA+"."+MovimientoActivoFijoConstantesFunciones.TABLENAME+".razon,"+MovimientoActivoFijoConstantesFunciones.SCHEMA+"."+MovimientoActivoFijoConstantesFunciones.TABLENAME+".descripcion from "+MovimientoActivoFijoConstantesFunciones.SCHEMA+"."+MovimientoActivoFijoConstantesFunciones.TABLENAME;//+" as "+MovimientoActivoFijoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected MovimientoActivoFijoConstantesFuncionesAdditional movimientoactivofijoConstantesFuncionesAdditional=null;
	
	public MovimientoActivoFijoConstantesFuncionesAdditional getMovimientoActivoFijoConstantesFuncionesAdditional() {
		return this.movimientoactivofijoConstantesFuncionesAdditional;
	}
	
	public void setMovimientoActivoFijoConstantesFuncionesAdditional(MovimientoActivoFijoConstantesFuncionesAdditional movimientoactivofijoConstantesFuncionesAdditional) {
		try {
			this.movimientoactivofijoConstantesFuncionesAdditional=movimientoactivofijoConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDUSUARIO= "id_usuario";
    public static final String SECUENCIAL= "secuencial";
    public static final String IDEMPRESAORIGEN= "id_empresa_origen";
    public static final String IDSUCURSALORIGEN= "id_sucursal_origen";
    public static final String IDDETALLEACTIVOFIJOORIGEN= "id_detalle_activo_fijo_origen";
    public static final String IDEMPRESADESTINO= "id_empresa_destino";
    public static final String IDSUCURSALDESTINO= "id_sucursal_destino";
    public static final String IDDETALLEACTIVOFIJODESTINO= "id_detalle_activo_fijo_destino";
    public static final String FECHA= "fecha";
    public static final String NUMERODOCUMENTO= "numero_documento";
    public static final String COSTO= "costo";
    public static final String DEPRECIACION= "depreciacion";
    public static final String COSTOORIGEN= "costo_origen";
    public static final String DEPRECIACIONORIGEN= "depreciacion_origen";
    public static final String RAZON= "razon";
    public static final String DESCRIPCION= "descripcion";
	//TITULO CAMPO
    	public static final String LABEL_ID= "";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDUSUARIO= "Usuario";
		public static final String LABEL_IDUSUARIO_LOWER= "Usuario";
    	public static final String LABEL_SECUENCIAL= "Secuencial";
		public static final String LABEL_SECUENCIAL_LOWER= "Secuencial";
    	public static final String LABEL_IDEMPRESAORIGEN= "Empresa Origen";
		public static final String LABEL_IDEMPRESAORIGEN_LOWER= "Empresa Origen";
    	public static final String LABEL_IDSUCURSALORIGEN= "Sucursal Origen";
		public static final String LABEL_IDSUCURSALORIGEN_LOWER= "Sucursal Origen";
    	public static final String LABEL_IDDETALLEACTIVOFIJOORIGEN= "Detalle Activo Fijo Origen";
		public static final String LABEL_IDDETALLEACTIVOFIJOORIGEN_LOWER= "Detalle Activo Fijo Origen";
    	public static final String LABEL_IDEMPRESADESTINO= "Empresa Destino";
		public static final String LABEL_IDEMPRESADESTINO_LOWER= "Empresa Destino";
    	public static final String LABEL_IDSUCURSALDESTINO= "Sucursal Destino";
		public static final String LABEL_IDSUCURSALDESTINO_LOWER= "Sucursal Destino";
    	public static final String LABEL_IDDETALLEACTIVOFIJODESTINO= "Detalle Activo Fijo Destino";
		public static final String LABEL_IDDETALLEACTIVOFIJODESTINO_LOWER= "Detalle Activo Fijo Destino";
    	public static final String LABEL_FECHA= "Fecha";
		public static final String LABEL_FECHA_LOWER= "Fecha";
    	public static final String LABEL_NUMERODOCUMENTO= "Numero Documento";
		public static final String LABEL_NUMERODOCUMENTO_LOWER= "Numero Documento";
    	public static final String LABEL_COSTO= "Costo";
		public static final String LABEL_COSTO_LOWER= "Costo";
    	public static final String LABEL_DEPRECIACION= "Depreciacion";
		public static final String LABEL_DEPRECIACION_LOWER= "Depreciacion";
    	public static final String LABEL_COSTOORIGEN= "Costo Origen";
		public static final String LABEL_COSTOORIGEN_LOWER= "Costo Origen";
    	public static final String LABEL_DEPRECIACIONORIGEN= "Depreciacion Origen";
		public static final String LABEL_DEPRECIACIONORIGEN_LOWER= "Depreciacion Origen";
    	public static final String LABEL_RAZON= "Razon";
		public static final String LABEL_RAZON_LOWER= "Razon";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
	
		
		
		
		
		
	public static final String SREGEXSECUENCIAL=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXSECUENCIAL=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
		
		
		
	public static final String SREGEXNUMERO_DOCUMENTO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNUMERO_DOCUMENTO=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
		
	public static final String SREGEXRAZON=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXRAZON=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
	
	public static String getMovimientoActivoFijoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(MovimientoActivoFijoConstantesFunciones.IDEMPRESA)) {sLabelColumna=MovimientoActivoFijoConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(MovimientoActivoFijoConstantesFunciones.IDSUCURSAL)) {sLabelColumna=MovimientoActivoFijoConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(MovimientoActivoFijoConstantesFunciones.IDUSUARIO)) {sLabelColumna=MovimientoActivoFijoConstantesFunciones.LABEL_IDUSUARIO;}
		if(sNombreColumna.equals(MovimientoActivoFijoConstantesFunciones.SECUENCIAL)) {sLabelColumna=MovimientoActivoFijoConstantesFunciones.LABEL_SECUENCIAL;}
		if(sNombreColumna.equals(MovimientoActivoFijoConstantesFunciones.IDEMPRESAORIGEN)) {sLabelColumna=MovimientoActivoFijoConstantesFunciones.LABEL_IDEMPRESAORIGEN;}
		if(sNombreColumna.equals(MovimientoActivoFijoConstantesFunciones.IDSUCURSALORIGEN)) {sLabelColumna=MovimientoActivoFijoConstantesFunciones.LABEL_IDSUCURSALORIGEN;}
		if(sNombreColumna.equals(MovimientoActivoFijoConstantesFunciones.IDDETALLEACTIVOFIJOORIGEN)) {sLabelColumna=MovimientoActivoFijoConstantesFunciones.LABEL_IDDETALLEACTIVOFIJOORIGEN;}
		if(sNombreColumna.equals(MovimientoActivoFijoConstantesFunciones.IDEMPRESADESTINO)) {sLabelColumna=MovimientoActivoFijoConstantesFunciones.LABEL_IDEMPRESADESTINO;}
		if(sNombreColumna.equals(MovimientoActivoFijoConstantesFunciones.IDSUCURSALDESTINO)) {sLabelColumna=MovimientoActivoFijoConstantesFunciones.LABEL_IDSUCURSALDESTINO;}
		if(sNombreColumna.equals(MovimientoActivoFijoConstantesFunciones.IDDETALLEACTIVOFIJODESTINO)) {sLabelColumna=MovimientoActivoFijoConstantesFunciones.LABEL_IDDETALLEACTIVOFIJODESTINO;}
		if(sNombreColumna.equals(MovimientoActivoFijoConstantesFunciones.FECHA)) {sLabelColumna=MovimientoActivoFijoConstantesFunciones.LABEL_FECHA;}
		if(sNombreColumna.equals(MovimientoActivoFijoConstantesFunciones.NUMERODOCUMENTO)) {sLabelColumna=MovimientoActivoFijoConstantesFunciones.LABEL_NUMERODOCUMENTO;}
		if(sNombreColumna.equals(MovimientoActivoFijoConstantesFunciones.COSTO)) {sLabelColumna=MovimientoActivoFijoConstantesFunciones.LABEL_COSTO;}
		if(sNombreColumna.equals(MovimientoActivoFijoConstantesFunciones.DEPRECIACION)) {sLabelColumna=MovimientoActivoFijoConstantesFunciones.LABEL_DEPRECIACION;}
		if(sNombreColumna.equals(MovimientoActivoFijoConstantesFunciones.COSTOORIGEN)) {sLabelColumna=MovimientoActivoFijoConstantesFunciones.LABEL_COSTOORIGEN;}
		if(sNombreColumna.equals(MovimientoActivoFijoConstantesFunciones.DEPRECIACIONORIGEN)) {sLabelColumna=MovimientoActivoFijoConstantesFunciones.LABEL_DEPRECIACIONORIGEN;}
		if(sNombreColumna.equals(MovimientoActivoFijoConstantesFunciones.RAZON)) {sLabelColumna=MovimientoActivoFijoConstantesFunciones.LABEL_RAZON;}
		if(sNombreColumna.equals(MovimientoActivoFijoConstantesFunciones.DESCRIPCION)) {sLabelColumna=MovimientoActivoFijoConstantesFunciones.LABEL_DESCRIPCION;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getMovimientoActivoFijoDescripcion(MovimientoActivoFijo movimientoactivofijo) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(movimientoactivofijo !=null/* && movimientoactivofijo.getId()!=0*/) {
			if(movimientoactivofijo.getId()!=null) {
				sDescripcion=movimientoactivofijo.getId().toString();
			}//movimientoactivofijomovimientoactivofijo.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getMovimientoActivoFijoDescripcionDetallado(MovimientoActivoFijo movimientoactivofijo) {
		String sDescripcion="";
			
		sDescripcion+=MovimientoActivoFijoConstantesFunciones.ID+"=";
		sDescripcion+=movimientoactivofijo.getId().toString()+",";
		sDescripcion+=MovimientoActivoFijoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=movimientoactivofijo.getVersionRow().toString()+",";
		sDescripcion+=MovimientoActivoFijoConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=movimientoactivofijo.getid_empresa().toString()+",";
		sDescripcion+=MovimientoActivoFijoConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=movimientoactivofijo.getid_sucursal().toString()+",";
		sDescripcion+=MovimientoActivoFijoConstantesFunciones.IDUSUARIO+"=";
		sDescripcion+=movimientoactivofijo.getid_usuario().toString()+",";
		sDescripcion+=MovimientoActivoFijoConstantesFunciones.SECUENCIAL+"=";
		sDescripcion+=movimientoactivofijo.getsecuencial()+",";
		sDescripcion+=MovimientoActivoFijoConstantesFunciones.IDEMPRESAORIGEN+"=";
		sDescripcion+=movimientoactivofijo.getid_empresa_origen().toString()+",";
		sDescripcion+=MovimientoActivoFijoConstantesFunciones.IDSUCURSALORIGEN+"=";
		sDescripcion+=movimientoactivofijo.getid_sucursal_origen().toString()+",";
		sDescripcion+=MovimientoActivoFijoConstantesFunciones.IDDETALLEACTIVOFIJOORIGEN+"=";
		sDescripcion+=movimientoactivofijo.getid_detalle_activo_fijo_origen().toString()+",";
		sDescripcion+=MovimientoActivoFijoConstantesFunciones.IDEMPRESADESTINO+"=";
		sDescripcion+=movimientoactivofijo.getid_empresa_destino().toString()+",";
		sDescripcion+=MovimientoActivoFijoConstantesFunciones.IDSUCURSALDESTINO+"=";
		sDescripcion+=movimientoactivofijo.getid_sucursal_destino().toString()+",";
		sDescripcion+=MovimientoActivoFijoConstantesFunciones.IDDETALLEACTIVOFIJODESTINO+"=";
		sDescripcion+=movimientoactivofijo.getid_detalle_activo_fijo_destino().toString()+",";
		sDescripcion+=MovimientoActivoFijoConstantesFunciones.FECHA+"=";
		sDescripcion+=movimientoactivofijo.getfecha().toString()+",";
		sDescripcion+=MovimientoActivoFijoConstantesFunciones.NUMERODOCUMENTO+"=";
		sDescripcion+=movimientoactivofijo.getnumero_documento()+",";
		sDescripcion+=MovimientoActivoFijoConstantesFunciones.COSTO+"=";
		sDescripcion+=movimientoactivofijo.getcosto().toString()+",";
		sDescripcion+=MovimientoActivoFijoConstantesFunciones.DEPRECIACION+"=";
		sDescripcion+=movimientoactivofijo.getdepreciacion().toString()+",";
		sDescripcion+=MovimientoActivoFijoConstantesFunciones.COSTOORIGEN+"=";
		sDescripcion+=movimientoactivofijo.getcosto_origen().toString()+",";
		sDescripcion+=MovimientoActivoFijoConstantesFunciones.DEPRECIACIONORIGEN+"=";
		sDescripcion+=movimientoactivofijo.getdepreciacion_origen().toString()+",";
		sDescripcion+=MovimientoActivoFijoConstantesFunciones.RAZON+"=";
		sDescripcion+=movimientoactivofijo.getrazon()+",";
		sDescripcion+=MovimientoActivoFijoConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=movimientoactivofijo.getdescripcion()+",";
			
		return sDescripcion;
	}
	
	public static void setMovimientoActivoFijoDescripcion(MovimientoActivoFijo movimientoactivofijo,String sValor) throws Exception {			
		if(movimientoactivofijo !=null) {
			//movimientoactivofijomovimientoactivofijo.getId().toString();
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

	public static String getUsuarioDescripcion(Usuario usuario) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(usuario!=null/*&&usuario.getId()>0*/) {
			sDescripcion=UsuarioConstantesFunciones.getUsuarioDescripcion(usuario);
		}

		return sDescripcion;
	}

	public static String getEmpresaOrigenDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getSucursalOrigenDescripcion(Sucursal sucursal) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(sucursal!=null/*&&sucursal.getId()>0*/) {
			sDescripcion=SucursalConstantesFunciones.getSucursalDescripcion(sucursal);
		}

		return sDescripcion;
	}

	public static String getDetalleActivoFijoOrigenDescripcion(DetalleActivoFijo detalleactivofijo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(detalleactivofijo!=null/*&&detalleactivofijo.getId()>0*/) {
			sDescripcion=DetalleActivoFijoConstantesFunciones.getDetalleActivoFijoDescripcion(detalleactivofijo);
		}

		return sDescripcion;
	}

	public static String getEmpresaDestinoDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getSucursalDestinoDescripcion(Sucursal sucursal) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(sucursal!=null/*&&sucursal.getId()>0*/) {
			sDescripcion=SucursalConstantesFunciones.getSucursalDescripcion(sucursal);
		}

		return sDescripcion;
	}

	public static String getDetalleActivoFijoDestinoDescripcion(DetalleActivoFijo detalleactivofijo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(detalleactivofijo!=null/*&&detalleactivofijo.getId()>0*/) {
			sDescripcion=DetalleActivoFijoConstantesFunciones.getDetalleActivoFijoDescripcion(detalleactivofijo);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdDetalleActivoFijoDestino")) {
			sNombreIndice="Tipo=  Por Detalle Activo Fijo Destino";
		} else if(sNombreIndice.equals("FK_IdDetalleActivoFijoOrigen")) {
			sNombreIndice="Tipo=  Por Detalle Activo Fijo Origen";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdEmpresaDestino")) {
			sNombreIndice="Tipo=  Por Empresa Destino";
		} else if(sNombreIndice.equals("FK_IdEmpresaOrigen")) {
			sNombreIndice="Tipo=  Por Empresa Origen";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		} else if(sNombreIndice.equals("FK_IdSucursalDestino")) {
			sNombreIndice="Tipo=  Por Sucursal Destino";
		} else if(sNombreIndice.equals("FK_IdSucursalOrigen")) {
			sNombreIndice="Tipo=  Por Sucursal Origen";
		} else if(sNombreIndice.equals("FK_IdUsuario")) {
			sNombreIndice="Tipo=  Por Usuario";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdDetalleActivoFijoDestino(Long id_detalle_activo_fijo_destino) {
		String sDetalleIndice=" Parametros->";
		if(id_detalle_activo_fijo_destino!=null) {sDetalleIndice+=" Codigo Unico De Detalle Activo Fijo Destino="+id_detalle_activo_fijo_destino.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdDetalleActivoFijoOrigen(Long id_detalle_activo_fijo_origen) {
		String sDetalleIndice=" Parametros->";
		if(id_detalle_activo_fijo_origen!=null) {sDetalleIndice+=" Codigo Unico De Detalle Activo Fijo Origen="+id_detalle_activo_fijo_origen.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresaDestino(Long id_empresa_destino) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa_destino!=null) {sDetalleIndice+=" Codigo Unico De Empresa Destino="+id_empresa_destino.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresaOrigen(Long id_empresa_origen) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa_origen!=null) {sDetalleIndice+=" Codigo Unico De Empresa Origen="+id_empresa_origen.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursalDestino(Long id_sucursal_destino) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal_destino!=null) {sDetalleIndice+=" Codigo Unico De Sucursal Destino="+id_sucursal_destino.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursalOrigen(Long id_sucursal_origen) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal_origen!=null) {sDetalleIndice+=" Codigo Unico De Sucursal Origen="+id_sucursal_origen.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdUsuario(Long id_usuario) {
		String sDetalleIndice=" Parametros->";
		if(id_usuario!=null) {sDetalleIndice+=" Codigo Unico De Usuario="+id_usuario.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosMovimientoActivoFijo(MovimientoActivoFijo movimientoactivofijo,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		movimientoactivofijo.setsecuencial(movimientoactivofijo.getsecuencial().trim());
		movimientoactivofijo.setnumero_documento(movimientoactivofijo.getnumero_documento().trim());
		movimientoactivofijo.setrazon(movimientoactivofijo.getrazon().trim());
		movimientoactivofijo.setdescripcion(movimientoactivofijo.getdescripcion().trim());
	}
	
	public static void quitarEspaciosMovimientoActivoFijos(List<MovimientoActivoFijo> movimientoactivofijos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(MovimientoActivoFijo movimientoactivofijo: movimientoactivofijos) {
			movimientoactivofijo.setsecuencial(movimientoactivofijo.getsecuencial().trim());
			movimientoactivofijo.setnumero_documento(movimientoactivofijo.getnumero_documento().trim());
			movimientoactivofijo.setrazon(movimientoactivofijo.getrazon().trim());
			movimientoactivofijo.setdescripcion(movimientoactivofijo.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresMovimientoActivoFijo(MovimientoActivoFijo movimientoactivofijo,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && movimientoactivofijo.getConCambioAuxiliar()) {
			movimientoactivofijo.setIsDeleted(movimientoactivofijo.getIsDeletedAuxiliar());	
			movimientoactivofijo.setIsNew(movimientoactivofijo.getIsNewAuxiliar());	
			movimientoactivofijo.setIsChanged(movimientoactivofijo.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			movimientoactivofijo.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			movimientoactivofijo.setIsDeletedAuxiliar(false);	
			movimientoactivofijo.setIsNewAuxiliar(false);	
			movimientoactivofijo.setIsChangedAuxiliar(false);
			
			movimientoactivofijo.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresMovimientoActivoFijos(List<MovimientoActivoFijo> movimientoactivofijos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(MovimientoActivoFijo movimientoactivofijo : movimientoactivofijos) {
			if(conAsignarBase && movimientoactivofijo.getConCambioAuxiliar()) {
				movimientoactivofijo.setIsDeleted(movimientoactivofijo.getIsDeletedAuxiliar());	
				movimientoactivofijo.setIsNew(movimientoactivofijo.getIsNewAuxiliar());	
				movimientoactivofijo.setIsChanged(movimientoactivofijo.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				movimientoactivofijo.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				movimientoactivofijo.setIsDeletedAuxiliar(false);	
				movimientoactivofijo.setIsNewAuxiliar(false);	
				movimientoactivofijo.setIsChangedAuxiliar(false);
				
				movimientoactivofijo.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresMovimientoActivoFijo(MovimientoActivoFijo movimientoactivofijo,Boolean conEnteros) throws Exception  {
		movimientoactivofijo.setcosto(0.0);
		movimientoactivofijo.setdepreciacion(0.0);
		movimientoactivofijo.setcosto_origen(0.0);
		movimientoactivofijo.setdepreciacion_origen(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresMovimientoActivoFijos(List<MovimientoActivoFijo> movimientoactivofijos,Boolean conEnteros) throws Exception  {
		
		for(MovimientoActivoFijo movimientoactivofijo: movimientoactivofijos) {
			movimientoactivofijo.setcosto(0.0);
			movimientoactivofijo.setdepreciacion(0.0);
			movimientoactivofijo.setcosto_origen(0.0);
			movimientoactivofijo.setdepreciacion_origen(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaMovimientoActivoFijo(List<MovimientoActivoFijo> movimientoactivofijos,MovimientoActivoFijo movimientoactivofijoAux) throws Exception  {
		MovimientoActivoFijoConstantesFunciones.InicializarValoresMovimientoActivoFijo(movimientoactivofijoAux,true);
		
		for(MovimientoActivoFijo movimientoactivofijo: movimientoactivofijos) {
			if(movimientoactivofijo.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			movimientoactivofijoAux.setcosto(movimientoactivofijoAux.getcosto()+movimientoactivofijo.getcosto());			
			movimientoactivofijoAux.setdepreciacion(movimientoactivofijoAux.getdepreciacion()+movimientoactivofijo.getdepreciacion());			
			movimientoactivofijoAux.setcosto_origen(movimientoactivofijoAux.getcosto_origen()+movimientoactivofijo.getcosto_origen());			
			movimientoactivofijoAux.setdepreciacion_origen(movimientoactivofijoAux.getdepreciacion_origen()+movimientoactivofijo.getdepreciacion_origen());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesMovimientoActivoFijo(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=MovimientoActivoFijoConstantesFunciones.getArrayColumnasGlobalesMovimientoActivoFijo(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesMovimientoActivoFijo(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(MovimientoActivoFijoConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(MovimientoActivoFijoConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(MovimientoActivoFijoConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(MovimientoActivoFijoConstantesFunciones.IDSUCURSAL);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(MovimientoActivoFijoConstantesFunciones.IDUSUARIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(MovimientoActivoFijoConstantesFunciones.IDUSUARIO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoMovimientoActivoFijo(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<MovimientoActivoFijo> movimientoactivofijos,MovimientoActivoFijo movimientoactivofijo,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(MovimientoActivoFijo movimientoactivofijoAux: movimientoactivofijos) {
			if(movimientoactivofijoAux!=null && movimientoactivofijo!=null) {
				if((movimientoactivofijoAux.getId()==null && movimientoactivofijo.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(movimientoactivofijoAux.getId()!=null && movimientoactivofijo.getId()!=null){
					if(movimientoactivofijoAux.getId().equals(movimientoactivofijo.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaMovimientoActivoFijo(List<MovimientoActivoFijo> movimientoactivofijos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double costoTotal=0.0;
		Double depreciacionTotal=0.0;
		Double costo_origenTotal=0.0;
		Double depreciacion_origenTotal=0.0;
	
		for(MovimientoActivoFijo movimientoactivofijo: movimientoactivofijos) {			
			if(movimientoactivofijo.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			costoTotal+=movimientoactivofijo.getcosto();
			depreciacionTotal+=movimientoactivofijo.getdepreciacion();
			costo_origenTotal+=movimientoactivofijo.getcosto_origen();
			depreciacion_origenTotal+=movimientoactivofijo.getdepreciacion_origen();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(MovimientoActivoFijoConstantesFunciones.COSTO);
		datoGeneral.setsDescripcion(MovimientoActivoFijoConstantesFunciones.LABEL_COSTO);
		datoGeneral.setdValorDouble(costoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(MovimientoActivoFijoConstantesFunciones.DEPRECIACION);
		datoGeneral.setsDescripcion(MovimientoActivoFijoConstantesFunciones.LABEL_DEPRECIACION);
		datoGeneral.setdValorDouble(depreciacionTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(MovimientoActivoFijoConstantesFunciones.COSTOORIGEN);
		datoGeneral.setsDescripcion(MovimientoActivoFijoConstantesFunciones.LABEL_COSTOORIGEN);
		datoGeneral.setdValorDouble(costo_origenTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(MovimientoActivoFijoConstantesFunciones.DEPRECIACIONORIGEN);
		datoGeneral.setsDescripcion(MovimientoActivoFijoConstantesFunciones.LABEL_DEPRECIACIONORIGEN);
		datoGeneral.setdValorDouble(depreciacion_origenTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaMovimientoActivoFijo() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,MovimientoActivoFijoConstantesFunciones.LABEL_ID, MovimientoActivoFijoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MovimientoActivoFijoConstantesFunciones.LABEL_VERSIONROW, MovimientoActivoFijoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MovimientoActivoFijoConstantesFunciones.LABEL_IDEMPRESA, MovimientoActivoFijoConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MovimientoActivoFijoConstantesFunciones.LABEL_IDSUCURSAL, MovimientoActivoFijoConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MovimientoActivoFijoConstantesFunciones.LABEL_IDUSUARIO, MovimientoActivoFijoConstantesFunciones.IDUSUARIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MovimientoActivoFijoConstantesFunciones.LABEL_SECUENCIAL, MovimientoActivoFijoConstantesFunciones.SECUENCIAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MovimientoActivoFijoConstantesFunciones.LABEL_IDEMPRESAORIGEN, MovimientoActivoFijoConstantesFunciones.IDEMPRESAORIGEN,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MovimientoActivoFijoConstantesFunciones.LABEL_IDSUCURSALORIGEN, MovimientoActivoFijoConstantesFunciones.IDSUCURSALORIGEN,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MovimientoActivoFijoConstantesFunciones.LABEL_IDDETALLEACTIVOFIJOORIGEN, MovimientoActivoFijoConstantesFunciones.IDDETALLEACTIVOFIJOORIGEN,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MovimientoActivoFijoConstantesFunciones.LABEL_IDEMPRESADESTINO, MovimientoActivoFijoConstantesFunciones.IDEMPRESADESTINO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MovimientoActivoFijoConstantesFunciones.LABEL_IDSUCURSALDESTINO, MovimientoActivoFijoConstantesFunciones.IDSUCURSALDESTINO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MovimientoActivoFijoConstantesFunciones.LABEL_IDDETALLEACTIVOFIJODESTINO, MovimientoActivoFijoConstantesFunciones.IDDETALLEACTIVOFIJODESTINO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MovimientoActivoFijoConstantesFunciones.LABEL_FECHA, MovimientoActivoFijoConstantesFunciones.FECHA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MovimientoActivoFijoConstantesFunciones.LABEL_NUMERODOCUMENTO, MovimientoActivoFijoConstantesFunciones.NUMERODOCUMENTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MovimientoActivoFijoConstantesFunciones.LABEL_COSTO, MovimientoActivoFijoConstantesFunciones.COSTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MovimientoActivoFijoConstantesFunciones.LABEL_DEPRECIACION, MovimientoActivoFijoConstantesFunciones.DEPRECIACION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MovimientoActivoFijoConstantesFunciones.LABEL_COSTOORIGEN, MovimientoActivoFijoConstantesFunciones.COSTOORIGEN,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MovimientoActivoFijoConstantesFunciones.LABEL_DEPRECIACIONORIGEN, MovimientoActivoFijoConstantesFunciones.DEPRECIACIONORIGEN,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MovimientoActivoFijoConstantesFunciones.LABEL_RAZON, MovimientoActivoFijoConstantesFunciones.RAZON,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,MovimientoActivoFijoConstantesFunciones.LABEL_DESCRIPCION, MovimientoActivoFijoConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasMovimientoActivoFijo() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=MovimientoActivoFijoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MovimientoActivoFijoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MovimientoActivoFijoConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MovimientoActivoFijoConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MovimientoActivoFijoConstantesFunciones.IDUSUARIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MovimientoActivoFijoConstantesFunciones.SECUENCIAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MovimientoActivoFijoConstantesFunciones.IDEMPRESAORIGEN;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MovimientoActivoFijoConstantesFunciones.IDSUCURSALORIGEN;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MovimientoActivoFijoConstantesFunciones.IDDETALLEACTIVOFIJOORIGEN;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MovimientoActivoFijoConstantesFunciones.IDEMPRESADESTINO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MovimientoActivoFijoConstantesFunciones.IDSUCURSALDESTINO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MovimientoActivoFijoConstantesFunciones.IDDETALLEACTIVOFIJODESTINO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MovimientoActivoFijoConstantesFunciones.FECHA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MovimientoActivoFijoConstantesFunciones.NUMERODOCUMENTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MovimientoActivoFijoConstantesFunciones.COSTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MovimientoActivoFijoConstantesFunciones.DEPRECIACION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MovimientoActivoFijoConstantesFunciones.COSTOORIGEN;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MovimientoActivoFijoConstantesFunciones.DEPRECIACIONORIGEN;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MovimientoActivoFijoConstantesFunciones.RAZON;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=MovimientoActivoFijoConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarMovimientoActivoFijo() throws Exception  {
		return MovimientoActivoFijoConstantesFunciones.getTiposSeleccionarMovimientoActivoFijo(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarMovimientoActivoFijo(Boolean conFk) throws Exception  {
		return MovimientoActivoFijoConstantesFunciones.getTiposSeleccionarMovimientoActivoFijo(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarMovimientoActivoFijo(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(MovimientoActivoFijoConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(MovimientoActivoFijoConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(MovimientoActivoFijoConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(MovimientoActivoFijoConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(MovimientoActivoFijoConstantesFunciones.LABEL_IDUSUARIO);
			reporte.setsDescripcion(MovimientoActivoFijoConstantesFunciones.LABEL_IDUSUARIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(MovimientoActivoFijoConstantesFunciones.LABEL_SECUENCIAL);
			reporte.setsDescripcion(MovimientoActivoFijoConstantesFunciones.LABEL_SECUENCIAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(MovimientoActivoFijoConstantesFunciones.LABEL_IDEMPRESAORIGEN);
			reporte.setsDescripcion(MovimientoActivoFijoConstantesFunciones.LABEL_IDEMPRESAORIGEN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(MovimientoActivoFijoConstantesFunciones.LABEL_IDSUCURSALORIGEN);
			reporte.setsDescripcion(MovimientoActivoFijoConstantesFunciones.LABEL_IDSUCURSALORIGEN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(MovimientoActivoFijoConstantesFunciones.LABEL_IDDETALLEACTIVOFIJOORIGEN);
			reporte.setsDescripcion(MovimientoActivoFijoConstantesFunciones.LABEL_IDDETALLEACTIVOFIJOORIGEN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(MovimientoActivoFijoConstantesFunciones.LABEL_IDEMPRESADESTINO);
			reporte.setsDescripcion(MovimientoActivoFijoConstantesFunciones.LABEL_IDEMPRESADESTINO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(MovimientoActivoFijoConstantesFunciones.LABEL_IDSUCURSALDESTINO);
			reporte.setsDescripcion(MovimientoActivoFijoConstantesFunciones.LABEL_IDSUCURSALDESTINO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(MovimientoActivoFijoConstantesFunciones.LABEL_IDDETALLEACTIVOFIJODESTINO);
			reporte.setsDescripcion(MovimientoActivoFijoConstantesFunciones.LABEL_IDDETALLEACTIVOFIJODESTINO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(MovimientoActivoFijoConstantesFunciones.LABEL_FECHA);
			reporte.setsDescripcion(MovimientoActivoFijoConstantesFunciones.LABEL_FECHA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(MovimientoActivoFijoConstantesFunciones.LABEL_NUMERODOCUMENTO);
			reporte.setsDescripcion(MovimientoActivoFijoConstantesFunciones.LABEL_NUMERODOCUMENTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(MovimientoActivoFijoConstantesFunciones.LABEL_COSTO);
			reporte.setsDescripcion(MovimientoActivoFijoConstantesFunciones.LABEL_COSTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(MovimientoActivoFijoConstantesFunciones.LABEL_DEPRECIACION);
			reporte.setsDescripcion(MovimientoActivoFijoConstantesFunciones.LABEL_DEPRECIACION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(MovimientoActivoFijoConstantesFunciones.LABEL_COSTOORIGEN);
			reporte.setsDescripcion(MovimientoActivoFijoConstantesFunciones.LABEL_COSTOORIGEN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(MovimientoActivoFijoConstantesFunciones.LABEL_DEPRECIACIONORIGEN);
			reporte.setsDescripcion(MovimientoActivoFijoConstantesFunciones.LABEL_DEPRECIACIONORIGEN);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(MovimientoActivoFijoConstantesFunciones.LABEL_RAZON);
			reporte.setsDescripcion(MovimientoActivoFijoConstantesFunciones.LABEL_RAZON);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(MovimientoActivoFijoConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(MovimientoActivoFijoConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesMovimientoActivoFijo(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesMovimientoActivoFijo(MovimientoActivoFijo movimientoactivofijoAux) throws Exception {
		
			movimientoactivofijoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(movimientoactivofijoAux.getEmpresa()));
			movimientoactivofijoAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(movimientoactivofijoAux.getSucursal()));
			movimientoactivofijoAux.setusuario_descripcion(UsuarioConstantesFunciones.getUsuarioDescripcion(movimientoactivofijoAux.getUsuario()));
			movimientoactivofijoAux.setempresaorigen_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(movimientoactivofijoAux.getEmpresaOrigen()));
			movimientoactivofijoAux.setsucursalorigen_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(movimientoactivofijoAux.getSucursalOrigen()));
			movimientoactivofijoAux.setdetalleactivofijoorigen_descripcion(DetalleActivoFijoConstantesFunciones.getDetalleActivoFijoDescripcion(movimientoactivofijoAux.getDetalleActivoFijoOrigen()));
			movimientoactivofijoAux.setempresadestino_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(movimientoactivofijoAux.getEmpresaDestino()));
			movimientoactivofijoAux.setsucursaldestino_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(movimientoactivofijoAux.getSucursalDestino()));
			movimientoactivofijoAux.setdetalleactivofijodestino_descripcion(DetalleActivoFijoConstantesFunciones.getDetalleActivoFijoDescripcion(movimientoactivofijoAux.getDetalleActivoFijoDestino()));		
	}
	
	public static void refrescarForeignKeysDescripcionesMovimientoActivoFijo(List<MovimientoActivoFijo> movimientoactivofijosTemp) throws Exception {
		for(MovimientoActivoFijo movimientoactivofijoAux:movimientoactivofijosTemp) {
			
			movimientoactivofijoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(movimientoactivofijoAux.getEmpresa()));
			movimientoactivofijoAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(movimientoactivofijoAux.getSucursal()));
			movimientoactivofijoAux.setusuario_descripcion(UsuarioConstantesFunciones.getUsuarioDescripcion(movimientoactivofijoAux.getUsuario()));
			movimientoactivofijoAux.setempresaorigen_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(movimientoactivofijoAux.getEmpresaOrigen()));
			movimientoactivofijoAux.setsucursalorigen_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(movimientoactivofijoAux.getSucursalOrigen()));
			movimientoactivofijoAux.setdetalleactivofijoorigen_descripcion(DetalleActivoFijoConstantesFunciones.getDetalleActivoFijoDescripcion(movimientoactivofijoAux.getDetalleActivoFijoOrigen()));
			movimientoactivofijoAux.setempresadestino_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(movimientoactivofijoAux.getEmpresaDestino()));
			movimientoactivofijoAux.setsucursaldestino_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(movimientoactivofijoAux.getSucursalDestino()));
			movimientoactivofijoAux.setdetalleactivofijodestino_descripcion(DetalleActivoFijoConstantesFunciones.getDetalleActivoFijoDescripcion(movimientoactivofijoAux.getDetalleActivoFijoDestino()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfMovimientoActivoFijo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(Usuario.class));
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(DetalleActivoFijo.class));
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(DetalleActivoFijo.class));
				
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
					if(clas.clas.equals(Usuario.class)) {
						classes.add(new Classe(Usuario.class));
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
					if(clas.clas.equals(DetalleActivoFijo.class)) {
						classes.add(new Classe(DetalleActivoFijo.class));
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
					if(clas.clas.equals(DetalleActivoFijo.class)) {
						classes.add(new Classe(DetalleActivoFijo.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfMovimientoActivoFijo(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(Usuario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Usuario.class)); continue;
					}

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(DetalleActivoFijo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleActivoFijo.class)); continue;
					}

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(DetalleActivoFijo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleActivoFijo.class)); continue;
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

					if(Usuario.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Usuario.class)); continue;
					}

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(DetalleActivoFijo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleActivoFijo.class)); continue;
					}

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(DetalleActivoFijo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleActivoFijo.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfMovimientoActivoFijo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return MovimientoActivoFijoConstantesFunciones.getClassesRelationshipsOfMovimientoActivoFijo(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfMovimientoActivoFijo(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfMovimientoActivoFijo(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return MovimientoActivoFijoConstantesFunciones.getClassesRelationshipsFromStringsOfMovimientoActivoFijo(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfMovimientoActivoFijo(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(MovimientoActivoFijo movimientoactivofijo,List<MovimientoActivoFijo> movimientoactivofijos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			MovimientoActivoFijo movimientoactivofijoEncontrado=null;
			
			for(MovimientoActivoFijo movimientoactivofijoLocal:movimientoactivofijos) {
				if(movimientoactivofijoLocal.getId().equals(movimientoactivofijo.getId())) {
					movimientoactivofijoEncontrado=movimientoactivofijoLocal;
					
					movimientoactivofijoLocal.setIsChanged(movimientoactivofijo.getIsChanged());
					movimientoactivofijoLocal.setIsNew(movimientoactivofijo.getIsNew());
					movimientoactivofijoLocal.setIsDeleted(movimientoactivofijo.getIsDeleted());
					
					movimientoactivofijoLocal.setGeneralEntityOriginal(movimientoactivofijo.getGeneralEntityOriginal());
					
					movimientoactivofijoLocal.setId(movimientoactivofijo.getId());	
					movimientoactivofijoLocal.setVersionRow(movimientoactivofijo.getVersionRow());	
					movimientoactivofijoLocal.setid_empresa(movimientoactivofijo.getid_empresa());	
					movimientoactivofijoLocal.setid_sucursal(movimientoactivofijo.getid_sucursal());	
					movimientoactivofijoLocal.setid_usuario(movimientoactivofijo.getid_usuario());	
					movimientoactivofijoLocal.setsecuencial(movimientoactivofijo.getsecuencial());	
					movimientoactivofijoLocal.setid_empresa_origen(movimientoactivofijo.getid_empresa_origen());	
					movimientoactivofijoLocal.setid_sucursal_origen(movimientoactivofijo.getid_sucursal_origen());	
					movimientoactivofijoLocal.setid_detalle_activo_fijo_origen(movimientoactivofijo.getid_detalle_activo_fijo_origen());	
					movimientoactivofijoLocal.setid_empresa_destino(movimientoactivofijo.getid_empresa_destino());	
					movimientoactivofijoLocal.setid_sucursal_destino(movimientoactivofijo.getid_sucursal_destino());	
					movimientoactivofijoLocal.setid_detalle_activo_fijo_destino(movimientoactivofijo.getid_detalle_activo_fijo_destino());	
					movimientoactivofijoLocal.setfecha(movimientoactivofijo.getfecha());	
					movimientoactivofijoLocal.setnumero_documento(movimientoactivofijo.getnumero_documento());	
					movimientoactivofijoLocal.setcosto(movimientoactivofijo.getcosto());	
					movimientoactivofijoLocal.setdepreciacion(movimientoactivofijo.getdepreciacion());	
					movimientoactivofijoLocal.setcosto_origen(movimientoactivofijo.getcosto_origen());	
					movimientoactivofijoLocal.setdepreciacion_origen(movimientoactivofijo.getdepreciacion_origen());	
					movimientoactivofijoLocal.setrazon(movimientoactivofijo.getrazon());	
					movimientoactivofijoLocal.setdescripcion(movimientoactivofijo.getdescripcion());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!movimientoactivofijo.getIsDeleted()) {
				if(!existe) {
					movimientoactivofijos.add(movimientoactivofijo);
				}
			} else {
				if(movimientoactivofijoEncontrado!=null && permiteQuitar)  {
					movimientoactivofijos.remove(movimientoactivofijoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(MovimientoActivoFijo movimientoactivofijo,List<MovimientoActivoFijo> movimientoactivofijos) throws Exception {
		try	{			
			for(MovimientoActivoFijo movimientoactivofijoLocal:movimientoactivofijos) {
				if(movimientoactivofijoLocal.getId().equals(movimientoactivofijo.getId())) {
					movimientoactivofijoLocal.setIsSelected(movimientoactivofijo.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesMovimientoActivoFijo(List<MovimientoActivoFijo> movimientoactivofijosAux) throws Exception {
		//this.movimientoactivofijosAux=movimientoactivofijosAux;
		
		for(MovimientoActivoFijo movimientoactivofijoAux:movimientoactivofijosAux) {
			if(movimientoactivofijoAux.getIsChanged()) {
				movimientoactivofijoAux.setIsChanged(false);
			}		
			
			if(movimientoactivofijoAux.getIsNew()) {
				movimientoactivofijoAux.setIsNew(false);
			}	
			
			if(movimientoactivofijoAux.getIsDeleted()) {
				movimientoactivofijoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesMovimientoActivoFijo(MovimientoActivoFijo movimientoactivofijoAux) throws Exception {
		//this.movimientoactivofijoAux=movimientoactivofijoAux;
		
			if(movimientoactivofijoAux.getIsChanged()) {
				movimientoactivofijoAux.setIsChanged(false);
			}		
			
			if(movimientoactivofijoAux.getIsNew()) {
				movimientoactivofijoAux.setIsNew(false);
			}	
			
			if(movimientoactivofijoAux.getIsDeleted()) {
				movimientoactivofijoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(MovimientoActivoFijo movimientoactivofijoAsignar,MovimientoActivoFijo movimientoactivofijo) throws Exception {
		movimientoactivofijoAsignar.setId(movimientoactivofijo.getId());	
		movimientoactivofijoAsignar.setVersionRow(movimientoactivofijo.getVersionRow());	
		movimientoactivofijoAsignar.setid_empresa(movimientoactivofijo.getid_empresa());
		movimientoactivofijoAsignar.setempresa_descripcion(movimientoactivofijo.getempresa_descripcion());	
		movimientoactivofijoAsignar.setid_sucursal(movimientoactivofijo.getid_sucursal());
		movimientoactivofijoAsignar.setsucursal_descripcion(movimientoactivofijo.getsucursal_descripcion());	
		movimientoactivofijoAsignar.setid_usuario(movimientoactivofijo.getid_usuario());
		movimientoactivofijoAsignar.setusuario_descripcion(movimientoactivofijo.getusuario_descripcion());	
		movimientoactivofijoAsignar.setsecuencial(movimientoactivofijo.getsecuencial());	
		movimientoactivofijoAsignar.setid_empresa_origen(movimientoactivofijo.getid_empresa_origen());
		movimientoactivofijoAsignar.setempresaorigen_descripcion(movimientoactivofijo.getempresaorigen_descripcion());	
		movimientoactivofijoAsignar.setid_sucursal_origen(movimientoactivofijo.getid_sucursal_origen());
		movimientoactivofijoAsignar.setsucursalorigen_descripcion(movimientoactivofijo.getsucursalorigen_descripcion());	
		movimientoactivofijoAsignar.setid_detalle_activo_fijo_origen(movimientoactivofijo.getid_detalle_activo_fijo_origen());
		movimientoactivofijoAsignar.setdetalleactivofijoorigen_descripcion(movimientoactivofijo.getdetalleactivofijoorigen_descripcion());	
		movimientoactivofijoAsignar.setid_empresa_destino(movimientoactivofijo.getid_empresa_destino());
		movimientoactivofijoAsignar.setempresadestino_descripcion(movimientoactivofijo.getempresadestino_descripcion());	
		movimientoactivofijoAsignar.setid_sucursal_destino(movimientoactivofijo.getid_sucursal_destino());
		movimientoactivofijoAsignar.setsucursaldestino_descripcion(movimientoactivofijo.getsucursaldestino_descripcion());	
		movimientoactivofijoAsignar.setid_detalle_activo_fijo_destino(movimientoactivofijo.getid_detalle_activo_fijo_destino());
		movimientoactivofijoAsignar.setdetalleactivofijodestino_descripcion(movimientoactivofijo.getdetalleactivofijodestino_descripcion());	
		movimientoactivofijoAsignar.setfecha(movimientoactivofijo.getfecha());	
		movimientoactivofijoAsignar.setnumero_documento(movimientoactivofijo.getnumero_documento());	
		movimientoactivofijoAsignar.setcosto(movimientoactivofijo.getcosto());	
		movimientoactivofijoAsignar.setdepreciacion(movimientoactivofijo.getdepreciacion());	
		movimientoactivofijoAsignar.setcosto_origen(movimientoactivofijo.getcosto_origen());	
		movimientoactivofijoAsignar.setdepreciacion_origen(movimientoactivofijo.getdepreciacion_origen());	
		movimientoactivofijoAsignar.setrazon(movimientoactivofijo.getrazon());	
		movimientoactivofijoAsignar.setdescripcion(movimientoactivofijo.getdescripcion());	
	}
	
	public static void inicializarMovimientoActivoFijo(MovimientoActivoFijo movimientoactivofijo) throws Exception {
		try {
				movimientoactivofijo.setId(0L);	
					
				movimientoactivofijo.setid_empresa(-1L);	
				movimientoactivofijo.setid_sucursal(-1L);	
				movimientoactivofijo.setid_usuario(-1L);	
				movimientoactivofijo.setsecuencial("");	
				movimientoactivofijo.setid_empresa_origen(-1L);	
				movimientoactivofijo.setid_sucursal_origen(-1L);	
				movimientoactivofijo.setid_detalle_activo_fijo_origen(-1L);	
				movimientoactivofijo.setid_empresa_destino(-1L);	
				movimientoactivofijo.setid_sucursal_destino(-1L);	
				movimientoactivofijo.setid_detalle_activo_fijo_destino(-1L);	
				movimientoactivofijo.setfecha(new Date());	
				movimientoactivofijo.setnumero_documento("");	
				movimientoactivofijo.setcosto(0.0);	
				movimientoactivofijo.setdepreciacion(0.0);	
				movimientoactivofijo.setcosto_origen(0.0);	
				movimientoactivofijo.setdepreciacion_origen(0.0);	
				movimientoactivofijo.setrazon("");	
				movimientoactivofijo.setdescripcion("");	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderMovimientoActivoFijo(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(MovimientoActivoFijoConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MovimientoActivoFijoConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MovimientoActivoFijoConstantesFunciones.LABEL_IDUSUARIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MovimientoActivoFijoConstantesFunciones.LABEL_SECUENCIAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MovimientoActivoFijoConstantesFunciones.LABEL_IDEMPRESAORIGEN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MovimientoActivoFijoConstantesFunciones.LABEL_IDSUCURSALORIGEN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MovimientoActivoFijoConstantesFunciones.LABEL_IDDETALLEACTIVOFIJOORIGEN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MovimientoActivoFijoConstantesFunciones.LABEL_IDEMPRESADESTINO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MovimientoActivoFijoConstantesFunciones.LABEL_IDSUCURSALDESTINO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MovimientoActivoFijoConstantesFunciones.LABEL_IDDETALLEACTIVOFIJODESTINO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MovimientoActivoFijoConstantesFunciones.LABEL_FECHA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MovimientoActivoFijoConstantesFunciones.LABEL_NUMERODOCUMENTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MovimientoActivoFijoConstantesFunciones.LABEL_COSTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MovimientoActivoFijoConstantesFunciones.LABEL_DEPRECIACION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MovimientoActivoFijoConstantesFunciones.LABEL_COSTOORIGEN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MovimientoActivoFijoConstantesFunciones.LABEL_DEPRECIACIONORIGEN);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MovimientoActivoFijoConstantesFunciones.LABEL_RAZON);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(MovimientoActivoFijoConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataMovimientoActivoFijo(String sTipo,Row row,Workbook workbook,MovimientoActivoFijo movimientoactivofijo,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(movimientoactivofijo.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(movimientoactivofijo.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(movimientoactivofijo.getusuario_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(movimientoactivofijo.getsecuencial());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(movimientoactivofijo.getempresaorigen_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(movimientoactivofijo.getsucursalorigen_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(movimientoactivofijo.getdetalleactivofijoorigen_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(movimientoactivofijo.getempresadestino_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(movimientoactivofijo.getsucursaldestino_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(movimientoactivofijo.getdetalleactivofijodestino_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(movimientoactivofijo.getfecha());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(movimientoactivofijo.getnumero_documento());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(movimientoactivofijo.getcosto());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(movimientoactivofijo.getdepreciacion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(movimientoactivofijo.getcosto_origen());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(movimientoactivofijo.getdepreciacion_origen());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(movimientoactivofijo.getrazon());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(movimientoactivofijo.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryMovimientoActivoFijo=Constantes.SFINALQUERY;
	
	public String getsFinalQueryMovimientoActivoFijo() {
		return this.sFinalQueryMovimientoActivoFijo;
	}
	
	public void setsFinalQueryMovimientoActivoFijo(String sFinalQueryMovimientoActivoFijo) {
		this.sFinalQueryMovimientoActivoFijo= sFinalQueryMovimientoActivoFijo;
	}
	
	public Border resaltarSeleccionarMovimientoActivoFijo=null;
	
	public Border setResaltarSeleccionarMovimientoActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*MovimientoActivoFijoBeanSwingJInternalFrame movimientoactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//movimientoactivofijoBeanSwingJInternalFrame.jTtoolBarMovimientoActivoFijo.setBorder(borderResaltar);
		
		this.resaltarSeleccionarMovimientoActivoFijo= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarMovimientoActivoFijo() {
		return this.resaltarSeleccionarMovimientoActivoFijo;
	}
	
	public void setResaltarSeleccionarMovimientoActivoFijo(Border borderResaltarSeleccionarMovimientoActivoFijo) {
		this.resaltarSeleccionarMovimientoActivoFijo= borderResaltarSeleccionarMovimientoActivoFijo;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridMovimientoActivoFijo=null;
	public Boolean mostraridMovimientoActivoFijo=true;
	public Boolean activaridMovimientoActivoFijo=true;

	public Border resaltarid_empresaMovimientoActivoFijo=null;
	public Boolean mostrarid_empresaMovimientoActivoFijo=true;
	public Boolean activarid_empresaMovimientoActivoFijo=true;
	public Boolean cargarid_empresaMovimientoActivoFijo=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaMovimientoActivoFijo=false;//ConEventDepend=true

	public Border resaltarid_sucursalMovimientoActivoFijo=null;
	public Boolean mostrarid_sucursalMovimientoActivoFijo=true;
	public Boolean activarid_sucursalMovimientoActivoFijo=true;
	public Boolean cargarid_sucursalMovimientoActivoFijo=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalMovimientoActivoFijo=false;//ConEventDepend=true

	public Border resaltarid_usuarioMovimientoActivoFijo=null;
	public Boolean mostrarid_usuarioMovimientoActivoFijo=true;
	public Boolean activarid_usuarioMovimientoActivoFijo=true;
	public Boolean cargarid_usuarioMovimientoActivoFijo=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_usuarioMovimientoActivoFijo=false;//ConEventDepend=true

	public Border resaltarsecuencialMovimientoActivoFijo=null;
	public Boolean mostrarsecuencialMovimientoActivoFijo=true;
	public Boolean activarsecuencialMovimientoActivoFijo=true;

	public Border resaltarid_empresa_origenMovimientoActivoFijo=null;
	public Boolean mostrarid_empresa_origenMovimientoActivoFijo=true;
	public Boolean activarid_empresa_origenMovimientoActivoFijo=true;
	public Boolean cargarid_empresa_origenMovimientoActivoFijo=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresa_origenMovimientoActivoFijo=false;//ConEventDepend=true

	public Border resaltarid_sucursal_origenMovimientoActivoFijo=null;
	public Boolean mostrarid_sucursal_origenMovimientoActivoFijo=true;
	public Boolean activarid_sucursal_origenMovimientoActivoFijo=true;
	public Boolean cargarid_sucursal_origenMovimientoActivoFijo=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursal_origenMovimientoActivoFijo=false;//ConEventDepend=true

	public Border resaltarid_detalle_activo_fijo_origenMovimientoActivoFijo=null;
	public Boolean mostrarid_detalle_activo_fijo_origenMovimientoActivoFijo=true;
	public Boolean activarid_detalle_activo_fijo_origenMovimientoActivoFijo=true;
	public Boolean cargarid_detalle_activo_fijo_origenMovimientoActivoFijo=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_detalle_activo_fijo_origenMovimientoActivoFijo=false;//ConEventDepend=true

	public Border resaltarid_empresa_destinoMovimientoActivoFijo=null;
	public Boolean mostrarid_empresa_destinoMovimientoActivoFijo=true;
	public Boolean activarid_empresa_destinoMovimientoActivoFijo=true;
	public Boolean cargarid_empresa_destinoMovimientoActivoFijo=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresa_destinoMovimientoActivoFijo=false;//ConEventDepend=true

	public Border resaltarid_sucursal_destinoMovimientoActivoFijo=null;
	public Boolean mostrarid_sucursal_destinoMovimientoActivoFijo=true;
	public Boolean activarid_sucursal_destinoMovimientoActivoFijo=true;
	public Boolean cargarid_sucursal_destinoMovimientoActivoFijo=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursal_destinoMovimientoActivoFijo=false;//ConEventDepend=true

	public Border resaltarid_detalle_activo_fijo_destinoMovimientoActivoFijo=null;
	public Boolean mostrarid_detalle_activo_fijo_destinoMovimientoActivoFijo=true;
	public Boolean activarid_detalle_activo_fijo_destinoMovimientoActivoFijo=true;
	public Boolean cargarid_detalle_activo_fijo_destinoMovimientoActivoFijo=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_detalle_activo_fijo_destinoMovimientoActivoFijo=false;//ConEventDepend=true

	public Border resaltarfechaMovimientoActivoFijo=null;
	public Boolean mostrarfechaMovimientoActivoFijo=true;
	public Boolean activarfechaMovimientoActivoFijo=false;

	public Border resaltarnumero_documentoMovimientoActivoFijo=null;
	public Boolean mostrarnumero_documentoMovimientoActivoFijo=true;
	public Boolean activarnumero_documentoMovimientoActivoFijo=true;

	public Border resaltarcostoMovimientoActivoFijo=null;
	public Boolean mostrarcostoMovimientoActivoFijo=true;
	public Boolean activarcostoMovimientoActivoFijo=true;

	public Border resaltardepreciacionMovimientoActivoFijo=null;
	public Boolean mostrardepreciacionMovimientoActivoFijo=true;
	public Boolean activardepreciacionMovimientoActivoFijo=true;

	public Border resaltarcosto_origenMovimientoActivoFijo=null;
	public Boolean mostrarcosto_origenMovimientoActivoFijo=true;
	public Boolean activarcosto_origenMovimientoActivoFijo=true;

	public Border resaltardepreciacion_origenMovimientoActivoFijo=null;
	public Boolean mostrardepreciacion_origenMovimientoActivoFijo=true;
	public Boolean activardepreciacion_origenMovimientoActivoFijo=true;

	public Border resaltarrazonMovimientoActivoFijo=null;
	public Boolean mostrarrazonMovimientoActivoFijo=true;
	public Boolean activarrazonMovimientoActivoFijo=true;

	public Border resaltardescripcionMovimientoActivoFijo=null;
	public Boolean mostrardescripcionMovimientoActivoFijo=true;
	public Boolean activardescripcionMovimientoActivoFijo=true;

	
	

	public Border setResaltaridMovimientoActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*MovimientoActivoFijoBeanSwingJInternalFrame movimientoactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//movimientoactivofijoBeanSwingJInternalFrame.jTtoolBarMovimientoActivoFijo.setBorder(borderResaltar);
		
		this.resaltaridMovimientoActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridMovimientoActivoFijo() {
		return this.resaltaridMovimientoActivoFijo;
	}

	public void setResaltaridMovimientoActivoFijo(Border borderResaltar) {
		this.resaltaridMovimientoActivoFijo= borderResaltar;
	}

	public Boolean getMostraridMovimientoActivoFijo() {
		return this.mostraridMovimientoActivoFijo;
	}

	public void setMostraridMovimientoActivoFijo(Boolean mostraridMovimientoActivoFijo) {
		this.mostraridMovimientoActivoFijo= mostraridMovimientoActivoFijo;
	}

	public Boolean getActivaridMovimientoActivoFijo() {
		return this.activaridMovimientoActivoFijo;
	}

	public void setActivaridMovimientoActivoFijo(Boolean activaridMovimientoActivoFijo) {
		this.activaridMovimientoActivoFijo= activaridMovimientoActivoFijo;
	}

	public Border setResaltarid_empresaMovimientoActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*MovimientoActivoFijoBeanSwingJInternalFrame movimientoactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//movimientoactivofijoBeanSwingJInternalFrame.jTtoolBarMovimientoActivoFijo.setBorder(borderResaltar);
		
		this.resaltarid_empresaMovimientoActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaMovimientoActivoFijo() {
		return this.resaltarid_empresaMovimientoActivoFijo;
	}

	public void setResaltarid_empresaMovimientoActivoFijo(Border borderResaltar) {
		this.resaltarid_empresaMovimientoActivoFijo= borderResaltar;
	}

	public Boolean getMostrarid_empresaMovimientoActivoFijo() {
		return this.mostrarid_empresaMovimientoActivoFijo;
	}

	public void setMostrarid_empresaMovimientoActivoFijo(Boolean mostrarid_empresaMovimientoActivoFijo) {
		this.mostrarid_empresaMovimientoActivoFijo= mostrarid_empresaMovimientoActivoFijo;
	}

	public Boolean getActivarid_empresaMovimientoActivoFijo() {
		return this.activarid_empresaMovimientoActivoFijo;
	}

	public void setActivarid_empresaMovimientoActivoFijo(Boolean activarid_empresaMovimientoActivoFijo) {
		this.activarid_empresaMovimientoActivoFijo= activarid_empresaMovimientoActivoFijo;
	}

	public Boolean getCargarid_empresaMovimientoActivoFijo() {
		return this.cargarid_empresaMovimientoActivoFijo;
	}

	public void setCargarid_empresaMovimientoActivoFijo(Boolean cargarid_empresaMovimientoActivoFijo) {
		this.cargarid_empresaMovimientoActivoFijo= cargarid_empresaMovimientoActivoFijo;
	}

	public Border setResaltarid_sucursalMovimientoActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*MovimientoActivoFijoBeanSwingJInternalFrame movimientoactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//movimientoactivofijoBeanSwingJInternalFrame.jTtoolBarMovimientoActivoFijo.setBorder(borderResaltar);
		
		this.resaltarid_sucursalMovimientoActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalMovimientoActivoFijo() {
		return this.resaltarid_sucursalMovimientoActivoFijo;
	}

	public void setResaltarid_sucursalMovimientoActivoFijo(Border borderResaltar) {
		this.resaltarid_sucursalMovimientoActivoFijo= borderResaltar;
	}

	public Boolean getMostrarid_sucursalMovimientoActivoFijo() {
		return this.mostrarid_sucursalMovimientoActivoFijo;
	}

	public void setMostrarid_sucursalMovimientoActivoFijo(Boolean mostrarid_sucursalMovimientoActivoFijo) {
		this.mostrarid_sucursalMovimientoActivoFijo= mostrarid_sucursalMovimientoActivoFijo;
	}

	public Boolean getActivarid_sucursalMovimientoActivoFijo() {
		return this.activarid_sucursalMovimientoActivoFijo;
	}

	public void setActivarid_sucursalMovimientoActivoFijo(Boolean activarid_sucursalMovimientoActivoFijo) {
		this.activarid_sucursalMovimientoActivoFijo= activarid_sucursalMovimientoActivoFijo;
	}

	public Boolean getCargarid_sucursalMovimientoActivoFijo() {
		return this.cargarid_sucursalMovimientoActivoFijo;
	}

	public void setCargarid_sucursalMovimientoActivoFijo(Boolean cargarid_sucursalMovimientoActivoFijo) {
		this.cargarid_sucursalMovimientoActivoFijo= cargarid_sucursalMovimientoActivoFijo;
	}

	public Border setResaltarid_usuarioMovimientoActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*MovimientoActivoFijoBeanSwingJInternalFrame movimientoactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//movimientoactivofijoBeanSwingJInternalFrame.jTtoolBarMovimientoActivoFijo.setBorder(borderResaltar);
		
		this.resaltarid_usuarioMovimientoActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_usuarioMovimientoActivoFijo() {
		return this.resaltarid_usuarioMovimientoActivoFijo;
	}

	public void setResaltarid_usuarioMovimientoActivoFijo(Border borderResaltar) {
		this.resaltarid_usuarioMovimientoActivoFijo= borderResaltar;
	}

	public Boolean getMostrarid_usuarioMovimientoActivoFijo() {
		return this.mostrarid_usuarioMovimientoActivoFijo;
	}

	public void setMostrarid_usuarioMovimientoActivoFijo(Boolean mostrarid_usuarioMovimientoActivoFijo) {
		this.mostrarid_usuarioMovimientoActivoFijo= mostrarid_usuarioMovimientoActivoFijo;
	}

	public Boolean getActivarid_usuarioMovimientoActivoFijo() {
		return this.activarid_usuarioMovimientoActivoFijo;
	}

	public void setActivarid_usuarioMovimientoActivoFijo(Boolean activarid_usuarioMovimientoActivoFijo) {
		this.activarid_usuarioMovimientoActivoFijo= activarid_usuarioMovimientoActivoFijo;
	}

	public Boolean getCargarid_usuarioMovimientoActivoFijo() {
		return this.cargarid_usuarioMovimientoActivoFijo;
	}

	public void setCargarid_usuarioMovimientoActivoFijo(Boolean cargarid_usuarioMovimientoActivoFijo) {
		this.cargarid_usuarioMovimientoActivoFijo= cargarid_usuarioMovimientoActivoFijo;
	}

	public Border setResaltarsecuencialMovimientoActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*MovimientoActivoFijoBeanSwingJInternalFrame movimientoactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//movimientoactivofijoBeanSwingJInternalFrame.jTtoolBarMovimientoActivoFijo.setBorder(borderResaltar);
		
		this.resaltarsecuencialMovimientoActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsecuencialMovimientoActivoFijo() {
		return this.resaltarsecuencialMovimientoActivoFijo;
	}

	public void setResaltarsecuencialMovimientoActivoFijo(Border borderResaltar) {
		this.resaltarsecuencialMovimientoActivoFijo= borderResaltar;
	}

	public Boolean getMostrarsecuencialMovimientoActivoFijo() {
		return this.mostrarsecuencialMovimientoActivoFijo;
	}

	public void setMostrarsecuencialMovimientoActivoFijo(Boolean mostrarsecuencialMovimientoActivoFijo) {
		this.mostrarsecuencialMovimientoActivoFijo= mostrarsecuencialMovimientoActivoFijo;
	}

	public Boolean getActivarsecuencialMovimientoActivoFijo() {
		return this.activarsecuencialMovimientoActivoFijo;
	}

	public void setActivarsecuencialMovimientoActivoFijo(Boolean activarsecuencialMovimientoActivoFijo) {
		this.activarsecuencialMovimientoActivoFijo= activarsecuencialMovimientoActivoFijo;
	}

	public Border setResaltarid_empresa_origenMovimientoActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*MovimientoActivoFijoBeanSwingJInternalFrame movimientoactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//movimientoactivofijoBeanSwingJInternalFrame.jTtoolBarMovimientoActivoFijo.setBorder(borderResaltar);
		
		this.resaltarid_empresa_origenMovimientoActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresa_origenMovimientoActivoFijo() {
		return this.resaltarid_empresa_origenMovimientoActivoFijo;
	}

	public void setResaltarid_empresa_origenMovimientoActivoFijo(Border borderResaltar) {
		this.resaltarid_empresa_origenMovimientoActivoFijo= borderResaltar;
	}

	public Boolean getMostrarid_empresa_origenMovimientoActivoFijo() {
		return this.mostrarid_empresa_origenMovimientoActivoFijo;
	}

	public void setMostrarid_empresa_origenMovimientoActivoFijo(Boolean mostrarid_empresa_origenMovimientoActivoFijo) {
		this.mostrarid_empresa_origenMovimientoActivoFijo= mostrarid_empresa_origenMovimientoActivoFijo;
	}

	public Boolean getActivarid_empresa_origenMovimientoActivoFijo() {
		return this.activarid_empresa_origenMovimientoActivoFijo;
	}

	public void setActivarid_empresa_origenMovimientoActivoFijo(Boolean activarid_empresa_origenMovimientoActivoFijo) {
		this.activarid_empresa_origenMovimientoActivoFijo= activarid_empresa_origenMovimientoActivoFijo;
	}

	public Boolean getCargarid_empresa_origenMovimientoActivoFijo() {
		return this.cargarid_empresa_origenMovimientoActivoFijo;
	}

	public void setCargarid_empresa_origenMovimientoActivoFijo(Boolean cargarid_empresa_origenMovimientoActivoFijo) {
		this.cargarid_empresa_origenMovimientoActivoFijo= cargarid_empresa_origenMovimientoActivoFijo;
	}

	public Border setResaltarid_sucursal_origenMovimientoActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*MovimientoActivoFijoBeanSwingJInternalFrame movimientoactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//movimientoactivofijoBeanSwingJInternalFrame.jTtoolBarMovimientoActivoFijo.setBorder(borderResaltar);
		
		this.resaltarid_sucursal_origenMovimientoActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursal_origenMovimientoActivoFijo() {
		return this.resaltarid_sucursal_origenMovimientoActivoFijo;
	}

	public void setResaltarid_sucursal_origenMovimientoActivoFijo(Border borderResaltar) {
		this.resaltarid_sucursal_origenMovimientoActivoFijo= borderResaltar;
	}

	public Boolean getMostrarid_sucursal_origenMovimientoActivoFijo() {
		return this.mostrarid_sucursal_origenMovimientoActivoFijo;
	}

	public void setMostrarid_sucursal_origenMovimientoActivoFijo(Boolean mostrarid_sucursal_origenMovimientoActivoFijo) {
		this.mostrarid_sucursal_origenMovimientoActivoFijo= mostrarid_sucursal_origenMovimientoActivoFijo;
	}

	public Boolean getActivarid_sucursal_origenMovimientoActivoFijo() {
		return this.activarid_sucursal_origenMovimientoActivoFijo;
	}

	public void setActivarid_sucursal_origenMovimientoActivoFijo(Boolean activarid_sucursal_origenMovimientoActivoFijo) {
		this.activarid_sucursal_origenMovimientoActivoFijo= activarid_sucursal_origenMovimientoActivoFijo;
	}

	public Boolean getCargarid_sucursal_origenMovimientoActivoFijo() {
		return this.cargarid_sucursal_origenMovimientoActivoFijo;
	}

	public void setCargarid_sucursal_origenMovimientoActivoFijo(Boolean cargarid_sucursal_origenMovimientoActivoFijo) {
		this.cargarid_sucursal_origenMovimientoActivoFijo= cargarid_sucursal_origenMovimientoActivoFijo;
	}

	public Border setResaltarid_detalle_activo_fijo_origenMovimientoActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*MovimientoActivoFijoBeanSwingJInternalFrame movimientoactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//movimientoactivofijoBeanSwingJInternalFrame.jTtoolBarMovimientoActivoFijo.setBorder(borderResaltar);
		
		this.resaltarid_detalle_activo_fijo_origenMovimientoActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_detalle_activo_fijo_origenMovimientoActivoFijo() {
		return this.resaltarid_detalle_activo_fijo_origenMovimientoActivoFijo;
	}

	public void setResaltarid_detalle_activo_fijo_origenMovimientoActivoFijo(Border borderResaltar) {
		this.resaltarid_detalle_activo_fijo_origenMovimientoActivoFijo= borderResaltar;
	}

	public Boolean getMostrarid_detalle_activo_fijo_origenMovimientoActivoFijo() {
		return this.mostrarid_detalle_activo_fijo_origenMovimientoActivoFijo;
	}

	public void setMostrarid_detalle_activo_fijo_origenMovimientoActivoFijo(Boolean mostrarid_detalle_activo_fijo_origenMovimientoActivoFijo) {
		this.mostrarid_detalle_activo_fijo_origenMovimientoActivoFijo= mostrarid_detalle_activo_fijo_origenMovimientoActivoFijo;
	}

	public Boolean getActivarid_detalle_activo_fijo_origenMovimientoActivoFijo() {
		return this.activarid_detalle_activo_fijo_origenMovimientoActivoFijo;
	}

	public void setActivarid_detalle_activo_fijo_origenMovimientoActivoFijo(Boolean activarid_detalle_activo_fijo_origenMovimientoActivoFijo) {
		this.activarid_detalle_activo_fijo_origenMovimientoActivoFijo= activarid_detalle_activo_fijo_origenMovimientoActivoFijo;
	}

	public Boolean getCargarid_detalle_activo_fijo_origenMovimientoActivoFijo() {
		return this.cargarid_detalle_activo_fijo_origenMovimientoActivoFijo;
	}

	public void setCargarid_detalle_activo_fijo_origenMovimientoActivoFijo(Boolean cargarid_detalle_activo_fijo_origenMovimientoActivoFijo) {
		this.cargarid_detalle_activo_fijo_origenMovimientoActivoFijo= cargarid_detalle_activo_fijo_origenMovimientoActivoFijo;
	}

	public Border setResaltarid_empresa_destinoMovimientoActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*MovimientoActivoFijoBeanSwingJInternalFrame movimientoactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//movimientoactivofijoBeanSwingJInternalFrame.jTtoolBarMovimientoActivoFijo.setBorder(borderResaltar);
		
		this.resaltarid_empresa_destinoMovimientoActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresa_destinoMovimientoActivoFijo() {
		return this.resaltarid_empresa_destinoMovimientoActivoFijo;
	}

	public void setResaltarid_empresa_destinoMovimientoActivoFijo(Border borderResaltar) {
		this.resaltarid_empresa_destinoMovimientoActivoFijo= borderResaltar;
	}

	public Boolean getMostrarid_empresa_destinoMovimientoActivoFijo() {
		return this.mostrarid_empresa_destinoMovimientoActivoFijo;
	}

	public void setMostrarid_empresa_destinoMovimientoActivoFijo(Boolean mostrarid_empresa_destinoMovimientoActivoFijo) {
		this.mostrarid_empresa_destinoMovimientoActivoFijo= mostrarid_empresa_destinoMovimientoActivoFijo;
	}

	public Boolean getActivarid_empresa_destinoMovimientoActivoFijo() {
		return this.activarid_empresa_destinoMovimientoActivoFijo;
	}

	public void setActivarid_empresa_destinoMovimientoActivoFijo(Boolean activarid_empresa_destinoMovimientoActivoFijo) {
		this.activarid_empresa_destinoMovimientoActivoFijo= activarid_empresa_destinoMovimientoActivoFijo;
	}

	public Boolean getCargarid_empresa_destinoMovimientoActivoFijo() {
		return this.cargarid_empresa_destinoMovimientoActivoFijo;
	}

	public void setCargarid_empresa_destinoMovimientoActivoFijo(Boolean cargarid_empresa_destinoMovimientoActivoFijo) {
		this.cargarid_empresa_destinoMovimientoActivoFijo= cargarid_empresa_destinoMovimientoActivoFijo;
	}

	public Border setResaltarid_sucursal_destinoMovimientoActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*MovimientoActivoFijoBeanSwingJInternalFrame movimientoactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//movimientoactivofijoBeanSwingJInternalFrame.jTtoolBarMovimientoActivoFijo.setBorder(borderResaltar);
		
		this.resaltarid_sucursal_destinoMovimientoActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursal_destinoMovimientoActivoFijo() {
		return this.resaltarid_sucursal_destinoMovimientoActivoFijo;
	}

	public void setResaltarid_sucursal_destinoMovimientoActivoFijo(Border borderResaltar) {
		this.resaltarid_sucursal_destinoMovimientoActivoFijo= borderResaltar;
	}

	public Boolean getMostrarid_sucursal_destinoMovimientoActivoFijo() {
		return this.mostrarid_sucursal_destinoMovimientoActivoFijo;
	}

	public void setMostrarid_sucursal_destinoMovimientoActivoFijo(Boolean mostrarid_sucursal_destinoMovimientoActivoFijo) {
		this.mostrarid_sucursal_destinoMovimientoActivoFijo= mostrarid_sucursal_destinoMovimientoActivoFijo;
	}

	public Boolean getActivarid_sucursal_destinoMovimientoActivoFijo() {
		return this.activarid_sucursal_destinoMovimientoActivoFijo;
	}

	public void setActivarid_sucursal_destinoMovimientoActivoFijo(Boolean activarid_sucursal_destinoMovimientoActivoFijo) {
		this.activarid_sucursal_destinoMovimientoActivoFijo= activarid_sucursal_destinoMovimientoActivoFijo;
	}

	public Boolean getCargarid_sucursal_destinoMovimientoActivoFijo() {
		return this.cargarid_sucursal_destinoMovimientoActivoFijo;
	}

	public void setCargarid_sucursal_destinoMovimientoActivoFijo(Boolean cargarid_sucursal_destinoMovimientoActivoFijo) {
		this.cargarid_sucursal_destinoMovimientoActivoFijo= cargarid_sucursal_destinoMovimientoActivoFijo;
	}

	public Border setResaltarid_detalle_activo_fijo_destinoMovimientoActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*MovimientoActivoFijoBeanSwingJInternalFrame movimientoactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//movimientoactivofijoBeanSwingJInternalFrame.jTtoolBarMovimientoActivoFijo.setBorder(borderResaltar);
		
		this.resaltarid_detalle_activo_fijo_destinoMovimientoActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_detalle_activo_fijo_destinoMovimientoActivoFijo() {
		return this.resaltarid_detalle_activo_fijo_destinoMovimientoActivoFijo;
	}

	public void setResaltarid_detalle_activo_fijo_destinoMovimientoActivoFijo(Border borderResaltar) {
		this.resaltarid_detalle_activo_fijo_destinoMovimientoActivoFijo= borderResaltar;
	}

	public Boolean getMostrarid_detalle_activo_fijo_destinoMovimientoActivoFijo() {
		return this.mostrarid_detalle_activo_fijo_destinoMovimientoActivoFijo;
	}

	public void setMostrarid_detalle_activo_fijo_destinoMovimientoActivoFijo(Boolean mostrarid_detalle_activo_fijo_destinoMovimientoActivoFijo) {
		this.mostrarid_detalle_activo_fijo_destinoMovimientoActivoFijo= mostrarid_detalle_activo_fijo_destinoMovimientoActivoFijo;
	}

	public Boolean getActivarid_detalle_activo_fijo_destinoMovimientoActivoFijo() {
		return this.activarid_detalle_activo_fijo_destinoMovimientoActivoFijo;
	}

	public void setActivarid_detalle_activo_fijo_destinoMovimientoActivoFijo(Boolean activarid_detalle_activo_fijo_destinoMovimientoActivoFijo) {
		this.activarid_detalle_activo_fijo_destinoMovimientoActivoFijo= activarid_detalle_activo_fijo_destinoMovimientoActivoFijo;
	}

	public Boolean getCargarid_detalle_activo_fijo_destinoMovimientoActivoFijo() {
		return this.cargarid_detalle_activo_fijo_destinoMovimientoActivoFijo;
	}

	public void setCargarid_detalle_activo_fijo_destinoMovimientoActivoFijo(Boolean cargarid_detalle_activo_fijo_destinoMovimientoActivoFijo) {
		this.cargarid_detalle_activo_fijo_destinoMovimientoActivoFijo= cargarid_detalle_activo_fijo_destinoMovimientoActivoFijo;
	}

	public Border setResaltarfechaMovimientoActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*MovimientoActivoFijoBeanSwingJInternalFrame movimientoactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//movimientoactivofijoBeanSwingJInternalFrame.jTtoolBarMovimientoActivoFijo.setBorder(borderResaltar);
		
		this.resaltarfechaMovimientoActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfechaMovimientoActivoFijo() {
		return this.resaltarfechaMovimientoActivoFijo;
	}

	public void setResaltarfechaMovimientoActivoFijo(Border borderResaltar) {
		this.resaltarfechaMovimientoActivoFijo= borderResaltar;
	}

	public Boolean getMostrarfechaMovimientoActivoFijo() {
		return this.mostrarfechaMovimientoActivoFijo;
	}

	public void setMostrarfechaMovimientoActivoFijo(Boolean mostrarfechaMovimientoActivoFijo) {
		this.mostrarfechaMovimientoActivoFijo= mostrarfechaMovimientoActivoFijo;
	}

	public Boolean getActivarfechaMovimientoActivoFijo() {
		return this.activarfechaMovimientoActivoFijo;
	}

	public void setActivarfechaMovimientoActivoFijo(Boolean activarfechaMovimientoActivoFijo) {
		this.activarfechaMovimientoActivoFijo= activarfechaMovimientoActivoFijo;
	}

	public Border setResaltarnumero_documentoMovimientoActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*MovimientoActivoFijoBeanSwingJInternalFrame movimientoactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//movimientoactivofijoBeanSwingJInternalFrame.jTtoolBarMovimientoActivoFijo.setBorder(borderResaltar);
		
		this.resaltarnumero_documentoMovimientoActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnumero_documentoMovimientoActivoFijo() {
		return this.resaltarnumero_documentoMovimientoActivoFijo;
	}

	public void setResaltarnumero_documentoMovimientoActivoFijo(Border borderResaltar) {
		this.resaltarnumero_documentoMovimientoActivoFijo= borderResaltar;
	}

	public Boolean getMostrarnumero_documentoMovimientoActivoFijo() {
		return this.mostrarnumero_documentoMovimientoActivoFijo;
	}

	public void setMostrarnumero_documentoMovimientoActivoFijo(Boolean mostrarnumero_documentoMovimientoActivoFijo) {
		this.mostrarnumero_documentoMovimientoActivoFijo= mostrarnumero_documentoMovimientoActivoFijo;
	}

	public Boolean getActivarnumero_documentoMovimientoActivoFijo() {
		return this.activarnumero_documentoMovimientoActivoFijo;
	}

	public void setActivarnumero_documentoMovimientoActivoFijo(Boolean activarnumero_documentoMovimientoActivoFijo) {
		this.activarnumero_documentoMovimientoActivoFijo= activarnumero_documentoMovimientoActivoFijo;
	}

	public Border setResaltarcostoMovimientoActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*MovimientoActivoFijoBeanSwingJInternalFrame movimientoactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//movimientoactivofijoBeanSwingJInternalFrame.jTtoolBarMovimientoActivoFijo.setBorder(borderResaltar);
		
		this.resaltarcostoMovimientoActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcostoMovimientoActivoFijo() {
		return this.resaltarcostoMovimientoActivoFijo;
	}

	public void setResaltarcostoMovimientoActivoFijo(Border borderResaltar) {
		this.resaltarcostoMovimientoActivoFijo= borderResaltar;
	}

	public Boolean getMostrarcostoMovimientoActivoFijo() {
		return this.mostrarcostoMovimientoActivoFijo;
	}

	public void setMostrarcostoMovimientoActivoFijo(Boolean mostrarcostoMovimientoActivoFijo) {
		this.mostrarcostoMovimientoActivoFijo= mostrarcostoMovimientoActivoFijo;
	}

	public Boolean getActivarcostoMovimientoActivoFijo() {
		return this.activarcostoMovimientoActivoFijo;
	}

	public void setActivarcostoMovimientoActivoFijo(Boolean activarcostoMovimientoActivoFijo) {
		this.activarcostoMovimientoActivoFijo= activarcostoMovimientoActivoFijo;
	}

	public Border setResaltardepreciacionMovimientoActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*MovimientoActivoFijoBeanSwingJInternalFrame movimientoactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//movimientoactivofijoBeanSwingJInternalFrame.jTtoolBarMovimientoActivoFijo.setBorder(borderResaltar);
		
		this.resaltardepreciacionMovimientoActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardepreciacionMovimientoActivoFijo() {
		return this.resaltardepreciacionMovimientoActivoFijo;
	}

	public void setResaltardepreciacionMovimientoActivoFijo(Border borderResaltar) {
		this.resaltardepreciacionMovimientoActivoFijo= borderResaltar;
	}

	public Boolean getMostrardepreciacionMovimientoActivoFijo() {
		return this.mostrardepreciacionMovimientoActivoFijo;
	}

	public void setMostrardepreciacionMovimientoActivoFijo(Boolean mostrardepreciacionMovimientoActivoFijo) {
		this.mostrardepreciacionMovimientoActivoFijo= mostrardepreciacionMovimientoActivoFijo;
	}

	public Boolean getActivardepreciacionMovimientoActivoFijo() {
		return this.activardepreciacionMovimientoActivoFijo;
	}

	public void setActivardepreciacionMovimientoActivoFijo(Boolean activardepreciacionMovimientoActivoFijo) {
		this.activardepreciacionMovimientoActivoFijo= activardepreciacionMovimientoActivoFijo;
	}

	public Border setResaltarcosto_origenMovimientoActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*MovimientoActivoFijoBeanSwingJInternalFrame movimientoactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//movimientoactivofijoBeanSwingJInternalFrame.jTtoolBarMovimientoActivoFijo.setBorder(borderResaltar);
		
		this.resaltarcosto_origenMovimientoActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcosto_origenMovimientoActivoFijo() {
		return this.resaltarcosto_origenMovimientoActivoFijo;
	}

	public void setResaltarcosto_origenMovimientoActivoFijo(Border borderResaltar) {
		this.resaltarcosto_origenMovimientoActivoFijo= borderResaltar;
	}

	public Boolean getMostrarcosto_origenMovimientoActivoFijo() {
		return this.mostrarcosto_origenMovimientoActivoFijo;
	}

	public void setMostrarcosto_origenMovimientoActivoFijo(Boolean mostrarcosto_origenMovimientoActivoFijo) {
		this.mostrarcosto_origenMovimientoActivoFijo= mostrarcosto_origenMovimientoActivoFijo;
	}

	public Boolean getActivarcosto_origenMovimientoActivoFijo() {
		return this.activarcosto_origenMovimientoActivoFijo;
	}

	public void setActivarcosto_origenMovimientoActivoFijo(Boolean activarcosto_origenMovimientoActivoFijo) {
		this.activarcosto_origenMovimientoActivoFijo= activarcosto_origenMovimientoActivoFijo;
	}

	public Border setResaltardepreciacion_origenMovimientoActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*MovimientoActivoFijoBeanSwingJInternalFrame movimientoactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//movimientoactivofijoBeanSwingJInternalFrame.jTtoolBarMovimientoActivoFijo.setBorder(borderResaltar);
		
		this.resaltardepreciacion_origenMovimientoActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardepreciacion_origenMovimientoActivoFijo() {
		return this.resaltardepreciacion_origenMovimientoActivoFijo;
	}

	public void setResaltardepreciacion_origenMovimientoActivoFijo(Border borderResaltar) {
		this.resaltardepreciacion_origenMovimientoActivoFijo= borderResaltar;
	}

	public Boolean getMostrardepreciacion_origenMovimientoActivoFijo() {
		return this.mostrardepreciacion_origenMovimientoActivoFijo;
	}

	public void setMostrardepreciacion_origenMovimientoActivoFijo(Boolean mostrardepreciacion_origenMovimientoActivoFijo) {
		this.mostrardepreciacion_origenMovimientoActivoFijo= mostrardepreciacion_origenMovimientoActivoFijo;
	}

	public Boolean getActivardepreciacion_origenMovimientoActivoFijo() {
		return this.activardepreciacion_origenMovimientoActivoFijo;
	}

	public void setActivardepreciacion_origenMovimientoActivoFijo(Boolean activardepreciacion_origenMovimientoActivoFijo) {
		this.activardepreciacion_origenMovimientoActivoFijo= activardepreciacion_origenMovimientoActivoFijo;
	}

	public Border setResaltarrazonMovimientoActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*MovimientoActivoFijoBeanSwingJInternalFrame movimientoactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//movimientoactivofijoBeanSwingJInternalFrame.jTtoolBarMovimientoActivoFijo.setBorder(borderResaltar);
		
		this.resaltarrazonMovimientoActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarrazonMovimientoActivoFijo() {
		return this.resaltarrazonMovimientoActivoFijo;
	}

	public void setResaltarrazonMovimientoActivoFijo(Border borderResaltar) {
		this.resaltarrazonMovimientoActivoFijo= borderResaltar;
	}

	public Boolean getMostrarrazonMovimientoActivoFijo() {
		return this.mostrarrazonMovimientoActivoFijo;
	}

	public void setMostrarrazonMovimientoActivoFijo(Boolean mostrarrazonMovimientoActivoFijo) {
		this.mostrarrazonMovimientoActivoFijo= mostrarrazonMovimientoActivoFijo;
	}

	public Boolean getActivarrazonMovimientoActivoFijo() {
		return this.activarrazonMovimientoActivoFijo;
	}

	public void setActivarrazonMovimientoActivoFijo(Boolean activarrazonMovimientoActivoFijo) {
		this.activarrazonMovimientoActivoFijo= activarrazonMovimientoActivoFijo;
	}

	public Border setResaltardescripcionMovimientoActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*MovimientoActivoFijoBeanSwingJInternalFrame movimientoactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//movimientoactivofijoBeanSwingJInternalFrame.jTtoolBarMovimientoActivoFijo.setBorder(borderResaltar);
		
		this.resaltardescripcionMovimientoActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionMovimientoActivoFijo() {
		return this.resaltardescripcionMovimientoActivoFijo;
	}

	public void setResaltardescripcionMovimientoActivoFijo(Border borderResaltar) {
		this.resaltardescripcionMovimientoActivoFijo= borderResaltar;
	}

	public Boolean getMostrardescripcionMovimientoActivoFijo() {
		return this.mostrardescripcionMovimientoActivoFijo;
	}

	public void setMostrardescripcionMovimientoActivoFijo(Boolean mostrardescripcionMovimientoActivoFijo) {
		this.mostrardescripcionMovimientoActivoFijo= mostrardescripcionMovimientoActivoFijo;
	}

	public Boolean getActivardescripcionMovimientoActivoFijo() {
		return this.activardescripcionMovimientoActivoFijo;
	}

	public void setActivardescripcionMovimientoActivoFijo(Boolean activardescripcionMovimientoActivoFijo) {
		this.activardescripcionMovimientoActivoFijo= activardescripcionMovimientoActivoFijo;
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
		
		
		this.setMostraridMovimientoActivoFijo(esInicial);
		this.setMostrarid_empresaMovimientoActivoFijo(esInicial);
		this.setMostrarid_sucursalMovimientoActivoFijo(esInicial);
		this.setMostrarid_usuarioMovimientoActivoFijo(esInicial);
		this.setMostrarsecuencialMovimientoActivoFijo(esInicial);
		this.setMostrarid_empresa_origenMovimientoActivoFijo(esInicial);
		this.setMostrarid_sucursal_origenMovimientoActivoFijo(esInicial);
		this.setMostrarid_detalle_activo_fijo_origenMovimientoActivoFijo(esInicial);
		this.setMostrarid_empresa_destinoMovimientoActivoFijo(esInicial);
		this.setMostrarid_sucursal_destinoMovimientoActivoFijo(esInicial);
		this.setMostrarid_detalle_activo_fijo_destinoMovimientoActivoFijo(esInicial);
		this.setMostrarfechaMovimientoActivoFijo(esInicial);
		this.setMostrarnumero_documentoMovimientoActivoFijo(esInicial);
		this.setMostrarcostoMovimientoActivoFijo(esInicial);
		this.setMostrardepreciacionMovimientoActivoFijo(esInicial);
		this.setMostrarcosto_origenMovimientoActivoFijo(esInicial);
		this.setMostrardepreciacion_origenMovimientoActivoFijo(esInicial);
		this.setMostrarrazonMovimientoActivoFijo(esInicial);
		this.setMostrardescripcionMovimientoActivoFijo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(MovimientoActivoFijoConstantesFunciones.ID)) {
				this.setMostraridMovimientoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoActivoFijoConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaMovimientoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoActivoFijoConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalMovimientoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoActivoFijoConstantesFunciones.IDUSUARIO)) {
				this.setMostrarid_usuarioMovimientoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoActivoFijoConstantesFunciones.SECUENCIAL)) {
				this.setMostrarsecuencialMovimientoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoActivoFijoConstantesFunciones.IDEMPRESAORIGEN)) {
				this.setMostrarid_empresa_origenMovimientoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoActivoFijoConstantesFunciones.IDSUCURSALORIGEN)) {
				this.setMostrarid_sucursal_origenMovimientoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoActivoFijoConstantesFunciones.IDDETALLEACTIVOFIJOORIGEN)) {
				this.setMostrarid_detalle_activo_fijo_origenMovimientoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoActivoFijoConstantesFunciones.IDEMPRESADESTINO)) {
				this.setMostrarid_empresa_destinoMovimientoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoActivoFijoConstantesFunciones.IDSUCURSALDESTINO)) {
				this.setMostrarid_sucursal_destinoMovimientoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoActivoFijoConstantesFunciones.IDDETALLEACTIVOFIJODESTINO)) {
				this.setMostrarid_detalle_activo_fijo_destinoMovimientoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoActivoFijoConstantesFunciones.FECHA)) {
				this.setMostrarfechaMovimientoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoActivoFijoConstantesFunciones.NUMERODOCUMENTO)) {
				this.setMostrarnumero_documentoMovimientoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoActivoFijoConstantesFunciones.COSTO)) {
				this.setMostrarcostoMovimientoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoActivoFijoConstantesFunciones.DEPRECIACION)) {
				this.setMostrardepreciacionMovimientoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoActivoFijoConstantesFunciones.COSTOORIGEN)) {
				this.setMostrarcosto_origenMovimientoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoActivoFijoConstantesFunciones.DEPRECIACIONORIGEN)) {
				this.setMostrardepreciacion_origenMovimientoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoActivoFijoConstantesFunciones.RAZON)) {
				this.setMostrarrazonMovimientoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoActivoFijoConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionMovimientoActivoFijo(esAsigna);
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
		
		
		this.setActivaridMovimientoActivoFijo(esInicial);
		this.setActivarid_empresaMovimientoActivoFijo(esInicial);
		this.setActivarid_sucursalMovimientoActivoFijo(esInicial);
		this.setActivarid_usuarioMovimientoActivoFijo(esInicial);
		this.setActivarsecuencialMovimientoActivoFijo(esInicial);
		this.setActivarid_empresa_origenMovimientoActivoFijo(esInicial);
		this.setActivarid_sucursal_origenMovimientoActivoFijo(esInicial);
		this.setActivarid_detalle_activo_fijo_origenMovimientoActivoFijo(esInicial);
		this.setActivarid_empresa_destinoMovimientoActivoFijo(esInicial);
		this.setActivarid_sucursal_destinoMovimientoActivoFijo(esInicial);
		this.setActivarid_detalle_activo_fijo_destinoMovimientoActivoFijo(esInicial);
		this.setActivarfechaMovimientoActivoFijo(esInicial);
		this.setActivarnumero_documentoMovimientoActivoFijo(esInicial);
		this.setActivarcostoMovimientoActivoFijo(esInicial);
		this.setActivardepreciacionMovimientoActivoFijo(esInicial);
		this.setActivarcosto_origenMovimientoActivoFijo(esInicial);
		this.setActivardepreciacion_origenMovimientoActivoFijo(esInicial);
		this.setActivarrazonMovimientoActivoFijo(esInicial);
		this.setActivardescripcionMovimientoActivoFijo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(MovimientoActivoFijoConstantesFunciones.ID)) {
				this.setActivaridMovimientoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoActivoFijoConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaMovimientoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoActivoFijoConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalMovimientoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoActivoFijoConstantesFunciones.IDUSUARIO)) {
				this.setActivarid_usuarioMovimientoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoActivoFijoConstantesFunciones.SECUENCIAL)) {
				this.setActivarsecuencialMovimientoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoActivoFijoConstantesFunciones.IDEMPRESAORIGEN)) {
				this.setActivarid_empresa_origenMovimientoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoActivoFijoConstantesFunciones.IDSUCURSALORIGEN)) {
				this.setActivarid_sucursal_origenMovimientoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoActivoFijoConstantesFunciones.IDDETALLEACTIVOFIJOORIGEN)) {
				this.setActivarid_detalle_activo_fijo_origenMovimientoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoActivoFijoConstantesFunciones.IDEMPRESADESTINO)) {
				this.setActivarid_empresa_destinoMovimientoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoActivoFijoConstantesFunciones.IDSUCURSALDESTINO)) {
				this.setActivarid_sucursal_destinoMovimientoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoActivoFijoConstantesFunciones.IDDETALLEACTIVOFIJODESTINO)) {
				this.setActivarid_detalle_activo_fijo_destinoMovimientoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoActivoFijoConstantesFunciones.FECHA)) {
				this.setActivarfechaMovimientoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoActivoFijoConstantesFunciones.NUMERODOCUMENTO)) {
				this.setActivarnumero_documentoMovimientoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoActivoFijoConstantesFunciones.COSTO)) {
				this.setActivarcostoMovimientoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoActivoFijoConstantesFunciones.DEPRECIACION)) {
				this.setActivardepreciacionMovimientoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoActivoFijoConstantesFunciones.COSTOORIGEN)) {
				this.setActivarcosto_origenMovimientoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoActivoFijoConstantesFunciones.DEPRECIACIONORIGEN)) {
				this.setActivardepreciacion_origenMovimientoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoActivoFijoConstantesFunciones.RAZON)) {
				this.setActivarrazonMovimientoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoActivoFijoConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionMovimientoActivoFijo(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,MovimientoActivoFijoBeanSwingJInternalFrame movimientoactivofijoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridMovimientoActivoFijo(esInicial);
		this.setResaltarid_empresaMovimientoActivoFijo(esInicial);
		this.setResaltarid_sucursalMovimientoActivoFijo(esInicial);
		this.setResaltarid_usuarioMovimientoActivoFijo(esInicial);
		this.setResaltarsecuencialMovimientoActivoFijo(esInicial);
		this.setResaltarid_empresa_origenMovimientoActivoFijo(esInicial);
		this.setResaltarid_sucursal_origenMovimientoActivoFijo(esInicial);
		this.setResaltarid_detalle_activo_fijo_origenMovimientoActivoFijo(esInicial);
		this.setResaltarid_empresa_destinoMovimientoActivoFijo(esInicial);
		this.setResaltarid_sucursal_destinoMovimientoActivoFijo(esInicial);
		this.setResaltarid_detalle_activo_fijo_destinoMovimientoActivoFijo(esInicial);
		this.setResaltarfechaMovimientoActivoFijo(esInicial);
		this.setResaltarnumero_documentoMovimientoActivoFijo(esInicial);
		this.setResaltarcostoMovimientoActivoFijo(esInicial);
		this.setResaltardepreciacionMovimientoActivoFijo(esInicial);
		this.setResaltarcosto_origenMovimientoActivoFijo(esInicial);
		this.setResaltardepreciacion_origenMovimientoActivoFijo(esInicial);
		this.setResaltarrazonMovimientoActivoFijo(esInicial);
		this.setResaltardescripcionMovimientoActivoFijo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(MovimientoActivoFijoConstantesFunciones.ID)) {
				this.setResaltaridMovimientoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoActivoFijoConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaMovimientoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoActivoFijoConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalMovimientoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoActivoFijoConstantesFunciones.IDUSUARIO)) {
				this.setResaltarid_usuarioMovimientoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoActivoFijoConstantesFunciones.SECUENCIAL)) {
				this.setResaltarsecuencialMovimientoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoActivoFijoConstantesFunciones.IDEMPRESAORIGEN)) {
				this.setResaltarid_empresa_origenMovimientoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoActivoFijoConstantesFunciones.IDSUCURSALORIGEN)) {
				this.setResaltarid_sucursal_origenMovimientoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoActivoFijoConstantesFunciones.IDDETALLEACTIVOFIJOORIGEN)) {
				this.setResaltarid_detalle_activo_fijo_origenMovimientoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoActivoFijoConstantesFunciones.IDEMPRESADESTINO)) {
				this.setResaltarid_empresa_destinoMovimientoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoActivoFijoConstantesFunciones.IDSUCURSALDESTINO)) {
				this.setResaltarid_sucursal_destinoMovimientoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoActivoFijoConstantesFunciones.IDDETALLEACTIVOFIJODESTINO)) {
				this.setResaltarid_detalle_activo_fijo_destinoMovimientoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoActivoFijoConstantesFunciones.FECHA)) {
				this.setResaltarfechaMovimientoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoActivoFijoConstantesFunciones.NUMERODOCUMENTO)) {
				this.setResaltarnumero_documentoMovimientoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoActivoFijoConstantesFunciones.COSTO)) {
				this.setResaltarcostoMovimientoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoActivoFijoConstantesFunciones.DEPRECIACION)) {
				this.setResaltardepreciacionMovimientoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoActivoFijoConstantesFunciones.COSTOORIGEN)) {
				this.setResaltarcosto_origenMovimientoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoActivoFijoConstantesFunciones.DEPRECIACIONORIGEN)) {
				this.setResaltardepreciacion_origenMovimientoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoActivoFijoConstantesFunciones.RAZON)) {
				this.setResaltarrazonMovimientoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(MovimientoActivoFijoConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionMovimientoActivoFijo(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,MovimientoActivoFijoBeanSwingJInternalFrame movimientoactivofijoBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdDetalleActivoFijoDestinoMovimientoActivoFijo=true;

	public Boolean getMostrarFK_IdDetalleActivoFijoDestinoMovimientoActivoFijo() {
		return this.mostrarFK_IdDetalleActivoFijoDestinoMovimientoActivoFijo;
	}

	public void setMostrarFK_IdDetalleActivoFijoDestinoMovimientoActivoFijo(Boolean visibilidadResaltar) {
		this.mostrarFK_IdDetalleActivoFijoDestinoMovimientoActivoFijo= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdDetalleActivoFijoOrigenMovimientoActivoFijo=true;

	public Boolean getMostrarFK_IdDetalleActivoFijoOrigenMovimientoActivoFijo() {
		return this.mostrarFK_IdDetalleActivoFijoOrigenMovimientoActivoFijo;
	}

	public void setMostrarFK_IdDetalleActivoFijoOrigenMovimientoActivoFijo(Boolean visibilidadResaltar) {
		this.mostrarFK_IdDetalleActivoFijoOrigenMovimientoActivoFijo= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaMovimientoActivoFijo=true;

	public Boolean getMostrarFK_IdEmpresaMovimientoActivoFijo() {
		return this.mostrarFK_IdEmpresaMovimientoActivoFijo;
	}

	public void setMostrarFK_IdEmpresaMovimientoActivoFijo(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaMovimientoActivoFijo= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaDestinoMovimientoActivoFijo=true;

	public Boolean getMostrarFK_IdEmpresaDestinoMovimientoActivoFijo() {
		return this.mostrarFK_IdEmpresaDestinoMovimientoActivoFijo;
	}

	public void setMostrarFK_IdEmpresaDestinoMovimientoActivoFijo(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaDestinoMovimientoActivoFijo= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaOrigenMovimientoActivoFijo=true;

	public Boolean getMostrarFK_IdEmpresaOrigenMovimientoActivoFijo() {
		return this.mostrarFK_IdEmpresaOrigenMovimientoActivoFijo;
	}

	public void setMostrarFK_IdEmpresaOrigenMovimientoActivoFijo(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaOrigenMovimientoActivoFijo= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalMovimientoActivoFijo=true;

	public Boolean getMostrarFK_IdSucursalMovimientoActivoFijo() {
		return this.mostrarFK_IdSucursalMovimientoActivoFijo;
	}

	public void setMostrarFK_IdSucursalMovimientoActivoFijo(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalMovimientoActivoFijo= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalDestinoMovimientoActivoFijo=true;

	public Boolean getMostrarFK_IdSucursalDestinoMovimientoActivoFijo() {
		return this.mostrarFK_IdSucursalDestinoMovimientoActivoFijo;
	}

	public void setMostrarFK_IdSucursalDestinoMovimientoActivoFijo(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalDestinoMovimientoActivoFijo= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalOrigenMovimientoActivoFijo=true;

	public Boolean getMostrarFK_IdSucursalOrigenMovimientoActivoFijo() {
		return this.mostrarFK_IdSucursalOrigenMovimientoActivoFijo;
	}

	public void setMostrarFK_IdSucursalOrigenMovimientoActivoFijo(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalOrigenMovimientoActivoFijo= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdUsuarioMovimientoActivoFijo=true;

	public Boolean getMostrarFK_IdUsuarioMovimientoActivoFijo() {
		return this.mostrarFK_IdUsuarioMovimientoActivoFijo;
	}

	public void setMostrarFK_IdUsuarioMovimientoActivoFijo(Boolean visibilidadResaltar) {
		this.mostrarFK_IdUsuarioMovimientoActivoFijo= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdDetalleActivoFijoDestinoMovimientoActivoFijo=true;

	public Boolean getActivarFK_IdDetalleActivoFijoDestinoMovimientoActivoFijo() {
		return this.activarFK_IdDetalleActivoFijoDestinoMovimientoActivoFijo;
	}

	public void setActivarFK_IdDetalleActivoFijoDestinoMovimientoActivoFijo(Boolean habilitarResaltar) {
		this.activarFK_IdDetalleActivoFijoDestinoMovimientoActivoFijo= habilitarResaltar;
	}

	public Boolean activarFK_IdDetalleActivoFijoOrigenMovimientoActivoFijo=true;

	public Boolean getActivarFK_IdDetalleActivoFijoOrigenMovimientoActivoFijo() {
		return this.activarFK_IdDetalleActivoFijoOrigenMovimientoActivoFijo;
	}

	public void setActivarFK_IdDetalleActivoFijoOrigenMovimientoActivoFijo(Boolean habilitarResaltar) {
		this.activarFK_IdDetalleActivoFijoOrigenMovimientoActivoFijo= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaMovimientoActivoFijo=true;

	public Boolean getActivarFK_IdEmpresaMovimientoActivoFijo() {
		return this.activarFK_IdEmpresaMovimientoActivoFijo;
	}

	public void setActivarFK_IdEmpresaMovimientoActivoFijo(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaMovimientoActivoFijo= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaDestinoMovimientoActivoFijo=true;

	public Boolean getActivarFK_IdEmpresaDestinoMovimientoActivoFijo() {
		return this.activarFK_IdEmpresaDestinoMovimientoActivoFijo;
	}

	public void setActivarFK_IdEmpresaDestinoMovimientoActivoFijo(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaDestinoMovimientoActivoFijo= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaOrigenMovimientoActivoFijo=true;

	public Boolean getActivarFK_IdEmpresaOrigenMovimientoActivoFijo() {
		return this.activarFK_IdEmpresaOrigenMovimientoActivoFijo;
	}

	public void setActivarFK_IdEmpresaOrigenMovimientoActivoFijo(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaOrigenMovimientoActivoFijo= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalMovimientoActivoFijo=true;

	public Boolean getActivarFK_IdSucursalMovimientoActivoFijo() {
		return this.activarFK_IdSucursalMovimientoActivoFijo;
	}

	public void setActivarFK_IdSucursalMovimientoActivoFijo(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalMovimientoActivoFijo= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalDestinoMovimientoActivoFijo=true;

	public Boolean getActivarFK_IdSucursalDestinoMovimientoActivoFijo() {
		return this.activarFK_IdSucursalDestinoMovimientoActivoFijo;
	}

	public void setActivarFK_IdSucursalDestinoMovimientoActivoFijo(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalDestinoMovimientoActivoFijo= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalOrigenMovimientoActivoFijo=true;

	public Boolean getActivarFK_IdSucursalOrigenMovimientoActivoFijo() {
		return this.activarFK_IdSucursalOrigenMovimientoActivoFijo;
	}

	public void setActivarFK_IdSucursalOrigenMovimientoActivoFijo(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalOrigenMovimientoActivoFijo= habilitarResaltar;
	}

	public Boolean activarFK_IdUsuarioMovimientoActivoFijo=true;

	public Boolean getActivarFK_IdUsuarioMovimientoActivoFijo() {
		return this.activarFK_IdUsuarioMovimientoActivoFijo;
	}

	public void setActivarFK_IdUsuarioMovimientoActivoFijo(Boolean habilitarResaltar) {
		this.activarFK_IdUsuarioMovimientoActivoFijo= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdDetalleActivoFijoDestinoMovimientoActivoFijo=null;

	public Border getResaltarFK_IdDetalleActivoFijoDestinoMovimientoActivoFijo() {
		return this.resaltarFK_IdDetalleActivoFijoDestinoMovimientoActivoFijo;
	}

	public void setResaltarFK_IdDetalleActivoFijoDestinoMovimientoActivoFijo(Border borderResaltar) {
		this.resaltarFK_IdDetalleActivoFijoDestinoMovimientoActivoFijo= borderResaltar;
	}

	public void setResaltarFK_IdDetalleActivoFijoDestinoMovimientoActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*MovimientoActivoFijoBeanSwingJInternalFrame movimientoactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdDetalleActivoFijoDestinoMovimientoActivoFijo= borderResaltar;
	}

	public Border resaltarFK_IdDetalleActivoFijoOrigenMovimientoActivoFijo=null;

	public Border getResaltarFK_IdDetalleActivoFijoOrigenMovimientoActivoFijo() {
		return this.resaltarFK_IdDetalleActivoFijoOrigenMovimientoActivoFijo;
	}

	public void setResaltarFK_IdDetalleActivoFijoOrigenMovimientoActivoFijo(Border borderResaltar) {
		this.resaltarFK_IdDetalleActivoFijoOrigenMovimientoActivoFijo= borderResaltar;
	}

	public void setResaltarFK_IdDetalleActivoFijoOrigenMovimientoActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*MovimientoActivoFijoBeanSwingJInternalFrame movimientoactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdDetalleActivoFijoOrigenMovimientoActivoFijo= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaMovimientoActivoFijo=null;

	public Border getResaltarFK_IdEmpresaMovimientoActivoFijo() {
		return this.resaltarFK_IdEmpresaMovimientoActivoFijo;
	}

	public void setResaltarFK_IdEmpresaMovimientoActivoFijo(Border borderResaltar) {
		this.resaltarFK_IdEmpresaMovimientoActivoFijo= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaMovimientoActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*MovimientoActivoFijoBeanSwingJInternalFrame movimientoactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaMovimientoActivoFijo= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaDestinoMovimientoActivoFijo=null;

	public Border getResaltarFK_IdEmpresaDestinoMovimientoActivoFijo() {
		return this.resaltarFK_IdEmpresaDestinoMovimientoActivoFijo;
	}

	public void setResaltarFK_IdEmpresaDestinoMovimientoActivoFijo(Border borderResaltar) {
		this.resaltarFK_IdEmpresaDestinoMovimientoActivoFijo= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaDestinoMovimientoActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*MovimientoActivoFijoBeanSwingJInternalFrame movimientoactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaDestinoMovimientoActivoFijo= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaOrigenMovimientoActivoFijo=null;

	public Border getResaltarFK_IdEmpresaOrigenMovimientoActivoFijo() {
		return this.resaltarFK_IdEmpresaOrigenMovimientoActivoFijo;
	}

	public void setResaltarFK_IdEmpresaOrigenMovimientoActivoFijo(Border borderResaltar) {
		this.resaltarFK_IdEmpresaOrigenMovimientoActivoFijo= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaOrigenMovimientoActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*MovimientoActivoFijoBeanSwingJInternalFrame movimientoactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaOrigenMovimientoActivoFijo= borderResaltar;
	}

	public Border resaltarFK_IdSucursalMovimientoActivoFijo=null;

	public Border getResaltarFK_IdSucursalMovimientoActivoFijo() {
		return this.resaltarFK_IdSucursalMovimientoActivoFijo;
	}

	public void setResaltarFK_IdSucursalMovimientoActivoFijo(Border borderResaltar) {
		this.resaltarFK_IdSucursalMovimientoActivoFijo= borderResaltar;
	}

	public void setResaltarFK_IdSucursalMovimientoActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*MovimientoActivoFijoBeanSwingJInternalFrame movimientoactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalMovimientoActivoFijo= borderResaltar;
	}

	public Border resaltarFK_IdSucursalDestinoMovimientoActivoFijo=null;

	public Border getResaltarFK_IdSucursalDestinoMovimientoActivoFijo() {
		return this.resaltarFK_IdSucursalDestinoMovimientoActivoFijo;
	}

	public void setResaltarFK_IdSucursalDestinoMovimientoActivoFijo(Border borderResaltar) {
		this.resaltarFK_IdSucursalDestinoMovimientoActivoFijo= borderResaltar;
	}

	public void setResaltarFK_IdSucursalDestinoMovimientoActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*MovimientoActivoFijoBeanSwingJInternalFrame movimientoactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalDestinoMovimientoActivoFijo= borderResaltar;
	}

	public Border resaltarFK_IdSucursalOrigenMovimientoActivoFijo=null;

	public Border getResaltarFK_IdSucursalOrigenMovimientoActivoFijo() {
		return this.resaltarFK_IdSucursalOrigenMovimientoActivoFijo;
	}

	public void setResaltarFK_IdSucursalOrigenMovimientoActivoFijo(Border borderResaltar) {
		this.resaltarFK_IdSucursalOrigenMovimientoActivoFijo= borderResaltar;
	}

	public void setResaltarFK_IdSucursalOrigenMovimientoActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*MovimientoActivoFijoBeanSwingJInternalFrame movimientoactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalOrigenMovimientoActivoFijo= borderResaltar;
	}

	public Border resaltarFK_IdUsuarioMovimientoActivoFijo=null;

	public Border getResaltarFK_IdUsuarioMovimientoActivoFijo() {
		return this.resaltarFK_IdUsuarioMovimientoActivoFijo;
	}

	public void setResaltarFK_IdUsuarioMovimientoActivoFijo(Border borderResaltar) {
		this.resaltarFK_IdUsuarioMovimientoActivoFijo= borderResaltar;
	}

	public void setResaltarFK_IdUsuarioMovimientoActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*MovimientoActivoFijoBeanSwingJInternalFrame movimientoactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdUsuarioMovimientoActivoFijo= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}