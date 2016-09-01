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


import com.bydan.erp.activosfijos.util.DepreciacionActivoFijoConstantesFunciones;
import com.bydan.erp.activosfijos.util.DepreciacionActivoFijoParameterReturnGeneral;
//import com.bydan.erp.activosfijos.util.DepreciacionActivoFijoParameterGeneral;

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
final public class DepreciacionActivoFijoConstantesFunciones extends DepreciacionActivoFijoConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="DepreciacionActivoFijo";
	public static final String SPATHOPCION="ActivosFijos";	
	public static final String SPATHMODULO="activosfijos/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="DepreciacionActivoFijo"+DepreciacionActivoFijoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="DepreciacionActivoFijoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="DepreciacionActivoFijoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=DepreciacionActivoFijoConstantesFunciones.SCHEMA+"_"+DepreciacionActivoFijoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/DepreciacionActivoFijoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=DepreciacionActivoFijoConstantesFunciones.SCHEMA+"_"+DepreciacionActivoFijoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=DepreciacionActivoFijoConstantesFunciones.SCHEMA+"_"+DepreciacionActivoFijoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/DepreciacionActivoFijoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=DepreciacionActivoFijoConstantesFunciones.SCHEMA+"_"+DepreciacionActivoFijoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DepreciacionActivoFijoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DepreciacionActivoFijoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DepreciacionActivoFijoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DepreciacionActivoFijoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DepreciacionActivoFijoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DepreciacionActivoFijoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=DepreciacionActivoFijoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+DepreciacionActivoFijoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=DepreciacionActivoFijoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+DepreciacionActivoFijoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Depreciacion Activo Fijos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Depreciacion Activo Fijo";
	public static final String SCLASSWEBTITULO_LOWER="Depreciacion Activo Fijo";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="DepreciacionActivoFijo";
	public static final String OBJECTNAME="depreciacionactivofijo";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_ACTIVOSFIJOS;	
	public static final String TABLENAME="depreciacion_activo_fijo";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select depreciacionactivofijo from "+DepreciacionActivoFijoConstantesFunciones.SPERSISTENCENAME+" depreciacionactivofijo";
	public static String QUERYSELECTNATIVE="select "+DepreciacionActivoFijoConstantesFunciones.SCHEMA+"."+DepreciacionActivoFijoConstantesFunciones.TABLENAME+".id,"+DepreciacionActivoFijoConstantesFunciones.SCHEMA+"."+DepreciacionActivoFijoConstantesFunciones.TABLENAME+".version_row,"+DepreciacionActivoFijoConstantesFunciones.SCHEMA+"."+DepreciacionActivoFijoConstantesFunciones.TABLENAME+".id_empresa,"+DepreciacionActivoFijoConstantesFunciones.SCHEMA+"."+DepreciacionActivoFijoConstantesFunciones.TABLENAME+".id_sucursal,"+DepreciacionActivoFijoConstantesFunciones.SCHEMA+"."+DepreciacionActivoFijoConstantesFunciones.TABLENAME+".id_detalle_activo_fijo,"+DepreciacionActivoFijoConstantesFunciones.SCHEMA+"."+DepreciacionActivoFijoConstantesFunciones.TABLENAME+".id_tipo_depreciacion_empresa,"+DepreciacionActivoFijoConstantesFunciones.SCHEMA+"."+DepreciacionActivoFijoConstantesFunciones.TABLENAME+".id_estado_depre_acti,"+DepreciacionActivoFijoConstantesFunciones.SCHEMA+"."+DepreciacionActivoFijoConstantesFunciones.TABLENAME+".id_anio,"+DepreciacionActivoFijoConstantesFunciones.SCHEMA+"."+DepreciacionActivoFijoConstantesFunciones.TABLENAME+".id_mes,"+DepreciacionActivoFijoConstantesFunciones.SCHEMA+"."+DepreciacionActivoFijoConstantesFunciones.TABLENAME+".fecha_compra,"+DepreciacionActivoFijoConstantesFunciones.SCHEMA+"."+DepreciacionActivoFijoConstantesFunciones.TABLENAME+".fecha_depre_acti,"+DepreciacionActivoFijoConstantesFunciones.SCHEMA+"."+DepreciacionActivoFijoConstantesFunciones.TABLENAME+".porcentaje,"+DepreciacionActivoFijoConstantesFunciones.SCHEMA+"."+DepreciacionActivoFijoConstantesFunciones.TABLENAME+".costo,"+DepreciacionActivoFijoConstantesFunciones.SCHEMA+"."+DepreciacionActivoFijoConstantesFunciones.TABLENAME+".valor_acumulado,"+DepreciacionActivoFijoConstantesFunciones.SCHEMA+"."+DepreciacionActivoFijoConstantesFunciones.TABLENAME+".valor_total,"+DepreciacionActivoFijoConstantesFunciones.SCHEMA+"."+DepreciacionActivoFijoConstantesFunciones.TABLENAME+".valor_gasto,"+DepreciacionActivoFijoConstantesFunciones.SCHEMA+"."+DepreciacionActivoFijoConstantesFunciones.TABLENAME+".fecha from "+DepreciacionActivoFijoConstantesFunciones.SCHEMA+"."+DepreciacionActivoFijoConstantesFunciones.TABLENAME;//+" as "+DepreciacionActivoFijoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected DepreciacionActivoFijoConstantesFuncionesAdditional depreciacionactivofijoConstantesFuncionesAdditional=null;
	
	public DepreciacionActivoFijoConstantesFuncionesAdditional getDepreciacionActivoFijoConstantesFuncionesAdditional() {
		return this.depreciacionactivofijoConstantesFuncionesAdditional;
	}
	
	public void setDepreciacionActivoFijoConstantesFuncionesAdditional(DepreciacionActivoFijoConstantesFuncionesAdditional depreciacionactivofijoConstantesFuncionesAdditional) {
		try {
			this.depreciacionactivofijoConstantesFuncionesAdditional=depreciacionactivofijoConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDDETALLEACTIVOFIJO= "id_detalle_activo_fijo";
    public static final String IDTIPODEPRECIACIONEMPRESA= "id_tipo_depreciacion_empresa";
    public static final String IDESTADODEPREACTI= "id_estado_depre_acti";
    public static final String IDANIO= "id_anio";
    public static final String IDMES= "id_mes";
    public static final String FECHACOMPRA= "fecha_compra";
    public static final String FECHADEPREACTI= "fecha_depre_acti";
    public static final String PORCENTAJE= "porcentaje";
    public static final String COSTO= "costo";
    public static final String VALORACUMULADO= "valor_acumulado";
    public static final String VALORTOTAL= "valor_total";
    public static final String VALORGASTO= "valor_gasto";
    public static final String FECHA= "fecha";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDDETALLEACTIVOFIJO= "Detalle Activo Fijo";
		public static final String LABEL_IDDETALLEACTIVOFIJO_LOWER= "Detalle Activo Fijo";
    	public static final String LABEL_IDTIPODEPRECIACIONEMPRESA= "Tipo Depreciacion Empresa";
		public static final String LABEL_IDTIPODEPRECIACIONEMPRESA_LOWER= "Tipo Depreciacion Empresa";
    	public static final String LABEL_IDESTADODEPREACTI= "Estado Depre Acti";
		public static final String LABEL_IDESTADODEPREACTI_LOWER= "Estado Depre Acti";
    	public static final String LABEL_IDANIO= "Anio";
		public static final String LABEL_IDANIO_LOWER= "Anio";
    	public static final String LABEL_IDMES= "Mes";
		public static final String LABEL_IDMES_LOWER= "Mes";
    	public static final String LABEL_FECHACOMPRA= "Fecha Compra";
		public static final String LABEL_FECHACOMPRA_LOWER= "Fecha Compra";
    	public static final String LABEL_FECHADEPREACTI= "Fecha Depre Acti";
		public static final String LABEL_FECHADEPREACTI_LOWER= "Fecha Depre Acti";
    	public static final String LABEL_PORCENTAJE= "Porcentaje";
		public static final String LABEL_PORCENTAJE_LOWER= "Porcentaje";
    	public static final String LABEL_COSTO= "Costo";
		public static final String LABEL_COSTO_LOWER= "Costo";
    	public static final String LABEL_VALORACUMULADO= "Valor Acumulado";
		public static final String LABEL_VALORACUMULADO_LOWER= "Valor Acumulado";
    	public static final String LABEL_VALORTOTAL= "Valor Total";
		public static final String LABEL_VALORTOTAL_LOWER= "Valor Total";
    	public static final String LABEL_VALORGASTO= "Valor Gasto";
		public static final String LABEL_VALORGASTO_LOWER= "Valor Gasto";
    	public static final String LABEL_FECHA= "Fecha";
		public static final String LABEL_FECHA_LOWER= "Fecha";
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	public static String getDepreciacionActivoFijoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(DepreciacionActivoFijoConstantesFunciones.IDEMPRESA)) {sLabelColumna=DepreciacionActivoFijoConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(DepreciacionActivoFijoConstantesFunciones.IDSUCURSAL)) {sLabelColumna=DepreciacionActivoFijoConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(DepreciacionActivoFijoConstantesFunciones.IDDETALLEACTIVOFIJO)) {sLabelColumna=DepreciacionActivoFijoConstantesFunciones.LABEL_IDDETALLEACTIVOFIJO;}
		if(sNombreColumna.equals(DepreciacionActivoFijoConstantesFunciones.IDTIPODEPRECIACIONEMPRESA)) {sLabelColumna=DepreciacionActivoFijoConstantesFunciones.LABEL_IDTIPODEPRECIACIONEMPRESA;}
		if(sNombreColumna.equals(DepreciacionActivoFijoConstantesFunciones.IDESTADODEPREACTI)) {sLabelColumna=DepreciacionActivoFijoConstantesFunciones.LABEL_IDESTADODEPREACTI;}
		if(sNombreColumna.equals(DepreciacionActivoFijoConstantesFunciones.IDANIO)) {sLabelColumna=DepreciacionActivoFijoConstantesFunciones.LABEL_IDANIO;}
		if(sNombreColumna.equals(DepreciacionActivoFijoConstantesFunciones.IDMES)) {sLabelColumna=DepreciacionActivoFijoConstantesFunciones.LABEL_IDMES;}
		if(sNombreColumna.equals(DepreciacionActivoFijoConstantesFunciones.FECHACOMPRA)) {sLabelColumna=DepreciacionActivoFijoConstantesFunciones.LABEL_FECHACOMPRA;}
		if(sNombreColumna.equals(DepreciacionActivoFijoConstantesFunciones.FECHADEPREACTI)) {sLabelColumna=DepreciacionActivoFijoConstantesFunciones.LABEL_FECHADEPREACTI;}
		if(sNombreColumna.equals(DepreciacionActivoFijoConstantesFunciones.PORCENTAJE)) {sLabelColumna=DepreciacionActivoFijoConstantesFunciones.LABEL_PORCENTAJE;}
		if(sNombreColumna.equals(DepreciacionActivoFijoConstantesFunciones.COSTO)) {sLabelColumna=DepreciacionActivoFijoConstantesFunciones.LABEL_COSTO;}
		if(sNombreColumna.equals(DepreciacionActivoFijoConstantesFunciones.VALORACUMULADO)) {sLabelColumna=DepreciacionActivoFijoConstantesFunciones.LABEL_VALORACUMULADO;}
		if(sNombreColumna.equals(DepreciacionActivoFijoConstantesFunciones.VALORTOTAL)) {sLabelColumna=DepreciacionActivoFijoConstantesFunciones.LABEL_VALORTOTAL;}
		if(sNombreColumna.equals(DepreciacionActivoFijoConstantesFunciones.VALORGASTO)) {sLabelColumna=DepreciacionActivoFijoConstantesFunciones.LABEL_VALORGASTO;}
		if(sNombreColumna.equals(DepreciacionActivoFijoConstantesFunciones.FECHA)) {sLabelColumna=DepreciacionActivoFijoConstantesFunciones.LABEL_FECHA;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	
	public static String getDepreciacionActivoFijoDescripcion(DepreciacionActivoFijo depreciacionactivofijo) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(depreciacionactivofijo !=null/* && depreciacionactivofijo.getId()!=0*/) {
			if(depreciacionactivofijo.getId()!=null) {
				sDescripcion=depreciacionactivofijo.getId().toString();
			}//depreciacionactivofijodepreciacionactivofijo.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getDepreciacionActivoFijoDescripcionDetallado(DepreciacionActivoFijo depreciacionactivofijo) {
		String sDescripcion="";
			
		sDescripcion+=DepreciacionActivoFijoConstantesFunciones.ID+"=";
		sDescripcion+=depreciacionactivofijo.getId().toString()+",";
		sDescripcion+=DepreciacionActivoFijoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=depreciacionactivofijo.getVersionRow().toString()+",";
		sDescripcion+=DepreciacionActivoFijoConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=depreciacionactivofijo.getid_empresa().toString()+",";
		sDescripcion+=DepreciacionActivoFijoConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=depreciacionactivofijo.getid_sucursal().toString()+",";
		sDescripcion+=DepreciacionActivoFijoConstantesFunciones.IDDETALLEACTIVOFIJO+"=";
		sDescripcion+=depreciacionactivofijo.getid_detalle_activo_fijo().toString()+",";
		sDescripcion+=DepreciacionActivoFijoConstantesFunciones.IDTIPODEPRECIACIONEMPRESA+"=";
		sDescripcion+=depreciacionactivofijo.getid_tipo_depreciacion_empresa().toString()+",";
		sDescripcion+=DepreciacionActivoFijoConstantesFunciones.IDESTADODEPREACTI+"=";
		sDescripcion+=depreciacionactivofijo.getid_estado_depre_acti().toString()+",";
		sDescripcion+=DepreciacionActivoFijoConstantesFunciones.IDANIO+"=";
		sDescripcion+=depreciacionactivofijo.getid_anio().toString()+",";
		sDescripcion+=DepreciacionActivoFijoConstantesFunciones.IDMES+"=";
		sDescripcion+=depreciacionactivofijo.getid_mes().toString()+",";
		sDescripcion+=DepreciacionActivoFijoConstantesFunciones.FECHACOMPRA+"=";
		sDescripcion+=depreciacionactivofijo.getfecha_compra().toString()+",";
		sDescripcion+=DepreciacionActivoFijoConstantesFunciones.FECHADEPREACTI+"=";
		sDescripcion+=depreciacionactivofijo.getfecha_depre_acti().toString()+",";
		sDescripcion+=DepreciacionActivoFijoConstantesFunciones.PORCENTAJE+"=";
		sDescripcion+=depreciacionactivofijo.getporcentaje().toString()+",";
		sDescripcion+=DepreciacionActivoFijoConstantesFunciones.COSTO+"=";
		sDescripcion+=depreciacionactivofijo.getcosto().toString()+",";
		sDescripcion+=DepreciacionActivoFijoConstantesFunciones.VALORACUMULADO+"=";
		sDescripcion+=depreciacionactivofijo.getvalor_acumulado().toString()+",";
		sDescripcion+=DepreciacionActivoFijoConstantesFunciones.VALORTOTAL+"=";
		sDescripcion+=depreciacionactivofijo.getvalor_total().toString()+",";
		sDescripcion+=DepreciacionActivoFijoConstantesFunciones.VALORGASTO+"=";
		sDescripcion+=depreciacionactivofijo.getvalor_gasto().toString()+",";
		sDescripcion+=DepreciacionActivoFijoConstantesFunciones.FECHA+"=";
		sDescripcion+=depreciacionactivofijo.getfecha().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setDepreciacionActivoFijoDescripcion(DepreciacionActivoFijo depreciacionactivofijo,String sValor) throws Exception {			
		if(depreciacionactivofijo !=null) {
			//depreciacionactivofijodepreciacionactivofijo.getId().toString();
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

	public static String getDetalleActivoFijoDescripcion(DetalleActivoFijo detalleactivofijo) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(detalleactivofijo!=null/*&&detalleactivofijo.getId()>0*/) {
			sDescripcion=DetalleActivoFijoConstantesFunciones.getDetalleActivoFijoDescripcion(detalleactivofijo);
		}

		return sDescripcion;
	}

	public static String getTipoDepreciacionEmpresaDescripcion(TipoDepreciacionEmpresa tipodepreciacionempresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(tipodepreciacionempresa!=null/*&&tipodepreciacionempresa.getId()>0*/) {
			sDescripcion=TipoDepreciacionEmpresaConstantesFunciones.getTipoDepreciacionEmpresaDescripcion(tipodepreciacionempresa);
		}

		return sDescripcion;
	}

	public static String getEstadoDepreActiDescripcion(EstadoDepreActi estadodepreacti) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(estadodepreacti!=null/*&&estadodepreacti.getId()>0*/) {
			sDescripcion=EstadoDepreActiConstantesFunciones.getEstadoDepreActiDescripcion(estadodepreacti);
		}

		return sDescripcion;
	}

	public static String getAnioDescripcion(Anio anio) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(anio!=null/*&&anio.getId()>0*/) {
			sDescripcion=AnioConstantesFunciones.getAnioDescripcion(anio);
		}

		return sDescripcion;
	}

	public static String getMesDescripcion(Mes mes) {
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
		} else if(sNombreIndice.equals("FK_IdAnio")) {
			sNombreIndice="Tipo=  Por Anio";
		} else if(sNombreIndice.equals("FK_IdDepreciacionActivoFijo")) {
			sNombreIndice="Tipo=  Por Estado Depre Acti";
		} else if(sNombreIndice.equals("FK_IdDetalleActivoFijo")) {
			sNombreIndice="Tipo=  Por Detalle Activo Fijo";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdMes")) {
			sNombreIndice="Tipo=  Por Mes";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
		} else if(sNombreIndice.equals("FK_IdTipoDepreciacionEmpresa")) {
			sNombreIndice="Tipo=  Por Tipo Depreciacion Empresa";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdAnio(Long id_anio) {
		String sDetalleIndice=" Parametros->";
		if(id_anio!=null) {sDetalleIndice+=" Codigo Unico De Anio="+id_anio.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdDepreciacionActivoFijo(Long id_estado_depre_acti) {
		String sDetalleIndice=" Parametros->";
		if(id_estado_depre_acti!=null) {sDetalleIndice+=" Codigo Unico De Estado Depre Acti="+id_estado_depre_acti.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdDetalleActivoFijo(Long id_detalle_activo_fijo) {
		String sDetalleIndice=" Parametros->";
		if(id_detalle_activo_fijo!=null) {sDetalleIndice+=" Codigo Unico De Detalle Activo Fijo="+id_detalle_activo_fijo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdMes(Long id_mes) {
		String sDetalleIndice=" Parametros->";
		if(id_mes!=null) {sDetalleIndice+=" Codigo Unico De Mes="+id_mes.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdTipoDepreciacionEmpresa(Long id_tipo_depreciacion_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_tipo_depreciacion_empresa!=null) {sDetalleIndice+=" Codigo Unico De Tipo Depreciacion Empresa="+id_tipo_depreciacion_empresa.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosDepreciacionActivoFijo(DepreciacionActivoFijo depreciacionactivofijo,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosDepreciacionActivoFijos(List<DepreciacionActivoFijo> depreciacionactivofijos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(DepreciacionActivoFijo depreciacionactivofijo: depreciacionactivofijos) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDepreciacionActivoFijo(DepreciacionActivoFijo depreciacionactivofijo,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && depreciacionactivofijo.getConCambioAuxiliar()) {
			depreciacionactivofijo.setIsDeleted(depreciacionactivofijo.getIsDeletedAuxiliar());	
			depreciacionactivofijo.setIsNew(depreciacionactivofijo.getIsNewAuxiliar());	
			depreciacionactivofijo.setIsChanged(depreciacionactivofijo.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			depreciacionactivofijo.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			depreciacionactivofijo.setIsDeletedAuxiliar(false);	
			depreciacionactivofijo.setIsNewAuxiliar(false);	
			depreciacionactivofijo.setIsChangedAuxiliar(false);
			
			depreciacionactivofijo.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDepreciacionActivoFijos(List<DepreciacionActivoFijo> depreciacionactivofijos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(DepreciacionActivoFijo depreciacionactivofijo : depreciacionactivofijos) {
			if(conAsignarBase && depreciacionactivofijo.getConCambioAuxiliar()) {
				depreciacionactivofijo.setIsDeleted(depreciacionactivofijo.getIsDeletedAuxiliar());	
				depreciacionactivofijo.setIsNew(depreciacionactivofijo.getIsNewAuxiliar());	
				depreciacionactivofijo.setIsChanged(depreciacionactivofijo.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				depreciacionactivofijo.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				depreciacionactivofijo.setIsDeletedAuxiliar(false);	
				depreciacionactivofijo.setIsNewAuxiliar(false);	
				depreciacionactivofijo.setIsChangedAuxiliar(false);
				
				depreciacionactivofijo.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresDepreciacionActivoFijo(DepreciacionActivoFijo depreciacionactivofijo,Boolean conEnteros) throws Exception  {
		depreciacionactivofijo.setporcentaje(0.0);
		depreciacionactivofijo.setcosto(0.0);
		depreciacionactivofijo.setvalor_acumulado(0.0);
		depreciacionactivofijo.setvalor_total(0.0);
		depreciacionactivofijo.setvalor_gasto(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresDepreciacionActivoFijos(List<DepreciacionActivoFijo> depreciacionactivofijos,Boolean conEnteros) throws Exception  {
		
		for(DepreciacionActivoFijo depreciacionactivofijo: depreciacionactivofijos) {
			depreciacionactivofijo.setporcentaje(0.0);
			depreciacionactivofijo.setcosto(0.0);
			depreciacionactivofijo.setvalor_acumulado(0.0);
			depreciacionactivofijo.setvalor_total(0.0);
			depreciacionactivofijo.setvalor_gasto(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaDepreciacionActivoFijo(List<DepreciacionActivoFijo> depreciacionactivofijos,DepreciacionActivoFijo depreciacionactivofijoAux) throws Exception  {
		DepreciacionActivoFijoConstantesFunciones.InicializarValoresDepreciacionActivoFijo(depreciacionactivofijoAux,true);
		
		for(DepreciacionActivoFijo depreciacionactivofijo: depreciacionactivofijos) {
			if(depreciacionactivofijo.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			depreciacionactivofijoAux.setporcentaje(depreciacionactivofijoAux.getporcentaje()+depreciacionactivofijo.getporcentaje());			
			depreciacionactivofijoAux.setcosto(depreciacionactivofijoAux.getcosto()+depreciacionactivofijo.getcosto());			
			depreciacionactivofijoAux.setvalor_acumulado(depreciacionactivofijoAux.getvalor_acumulado()+depreciacionactivofijo.getvalor_acumulado());			
			depreciacionactivofijoAux.setvalor_total(depreciacionactivofijoAux.getvalor_total()+depreciacionactivofijo.getvalor_total());			
			depreciacionactivofijoAux.setvalor_gasto(depreciacionactivofijoAux.getvalor_gasto()+depreciacionactivofijo.getvalor_gasto());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesDepreciacionActivoFijo(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=DepreciacionActivoFijoConstantesFunciones.getArrayColumnasGlobalesDepreciacionActivoFijo(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesDepreciacionActivoFijo(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DepreciacionActivoFijoConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DepreciacionActivoFijoConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DepreciacionActivoFijoConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DepreciacionActivoFijoConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoDepreciacionActivoFijo(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<DepreciacionActivoFijo> depreciacionactivofijos,DepreciacionActivoFijo depreciacionactivofijo,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(DepreciacionActivoFijo depreciacionactivofijoAux: depreciacionactivofijos) {
			if(depreciacionactivofijoAux!=null && depreciacionactivofijo!=null) {
				if((depreciacionactivofijoAux.getId()==null && depreciacionactivofijo.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(depreciacionactivofijoAux.getId()!=null && depreciacionactivofijo.getId()!=null){
					if(depreciacionactivofijoAux.getId().equals(depreciacionactivofijo.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaDepreciacionActivoFijo(List<DepreciacionActivoFijo> depreciacionactivofijos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double porcentajeTotal=0.0;
		Double costoTotal=0.0;
		Double valor_acumuladoTotal=0.0;
		Double valor_totalTotal=0.0;
		Double valor_gastoTotal=0.0;
	
		for(DepreciacionActivoFijo depreciacionactivofijo: depreciacionactivofijos) {			
			if(depreciacionactivofijo.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			porcentajeTotal+=depreciacionactivofijo.getporcentaje();
			costoTotal+=depreciacionactivofijo.getcosto();
			valor_acumuladoTotal+=depreciacionactivofijo.getvalor_acumulado();
			valor_totalTotal+=depreciacionactivofijo.getvalor_total();
			valor_gastoTotal+=depreciacionactivofijo.getvalor_gasto();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DepreciacionActivoFijoConstantesFunciones.PORCENTAJE);
		datoGeneral.setsDescripcion(DepreciacionActivoFijoConstantesFunciones.LABEL_PORCENTAJE);
		datoGeneral.setdValorDouble(porcentajeTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DepreciacionActivoFijoConstantesFunciones.COSTO);
		datoGeneral.setsDescripcion(DepreciacionActivoFijoConstantesFunciones.LABEL_COSTO);
		datoGeneral.setdValorDouble(costoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DepreciacionActivoFijoConstantesFunciones.VALORACUMULADO);
		datoGeneral.setsDescripcion(DepreciacionActivoFijoConstantesFunciones.LABEL_VALORACUMULADO);
		datoGeneral.setdValorDouble(valor_acumuladoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DepreciacionActivoFijoConstantesFunciones.VALORTOTAL);
		datoGeneral.setsDescripcion(DepreciacionActivoFijoConstantesFunciones.LABEL_VALORTOTAL);
		datoGeneral.setdValorDouble(valor_totalTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DepreciacionActivoFijoConstantesFunciones.VALORGASTO);
		datoGeneral.setsDescripcion(DepreciacionActivoFijoConstantesFunciones.LABEL_VALORGASTO);
		datoGeneral.setdValorDouble(valor_gastoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaDepreciacionActivoFijo() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,DepreciacionActivoFijoConstantesFunciones.LABEL_ID, DepreciacionActivoFijoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DepreciacionActivoFijoConstantesFunciones.LABEL_VERSIONROW, DepreciacionActivoFijoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DepreciacionActivoFijoConstantesFunciones.LABEL_IDEMPRESA, DepreciacionActivoFijoConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DepreciacionActivoFijoConstantesFunciones.LABEL_IDSUCURSAL, DepreciacionActivoFijoConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DepreciacionActivoFijoConstantesFunciones.LABEL_IDDETALLEACTIVOFIJO, DepreciacionActivoFijoConstantesFunciones.IDDETALLEACTIVOFIJO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DepreciacionActivoFijoConstantesFunciones.LABEL_IDTIPODEPRECIACIONEMPRESA, DepreciacionActivoFijoConstantesFunciones.IDTIPODEPRECIACIONEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DepreciacionActivoFijoConstantesFunciones.LABEL_IDESTADODEPREACTI, DepreciacionActivoFijoConstantesFunciones.IDESTADODEPREACTI,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DepreciacionActivoFijoConstantesFunciones.LABEL_IDANIO, DepreciacionActivoFijoConstantesFunciones.IDANIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DepreciacionActivoFijoConstantesFunciones.LABEL_IDMES, DepreciacionActivoFijoConstantesFunciones.IDMES,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DepreciacionActivoFijoConstantesFunciones.LABEL_FECHACOMPRA, DepreciacionActivoFijoConstantesFunciones.FECHACOMPRA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DepreciacionActivoFijoConstantesFunciones.LABEL_FECHADEPREACTI, DepreciacionActivoFijoConstantesFunciones.FECHADEPREACTI,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DepreciacionActivoFijoConstantesFunciones.LABEL_PORCENTAJE, DepreciacionActivoFijoConstantesFunciones.PORCENTAJE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DepreciacionActivoFijoConstantesFunciones.LABEL_COSTO, DepreciacionActivoFijoConstantesFunciones.COSTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DepreciacionActivoFijoConstantesFunciones.LABEL_VALORACUMULADO, DepreciacionActivoFijoConstantesFunciones.VALORACUMULADO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DepreciacionActivoFijoConstantesFunciones.LABEL_VALORTOTAL, DepreciacionActivoFijoConstantesFunciones.VALORTOTAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DepreciacionActivoFijoConstantesFunciones.LABEL_VALORGASTO, DepreciacionActivoFijoConstantesFunciones.VALORGASTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DepreciacionActivoFijoConstantesFunciones.LABEL_FECHA, DepreciacionActivoFijoConstantesFunciones.FECHA,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasDepreciacionActivoFijo() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=DepreciacionActivoFijoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DepreciacionActivoFijoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DepreciacionActivoFijoConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DepreciacionActivoFijoConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DepreciacionActivoFijoConstantesFunciones.IDDETALLEACTIVOFIJO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DepreciacionActivoFijoConstantesFunciones.IDTIPODEPRECIACIONEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DepreciacionActivoFijoConstantesFunciones.IDESTADODEPREACTI;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DepreciacionActivoFijoConstantesFunciones.IDANIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DepreciacionActivoFijoConstantesFunciones.IDMES;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DepreciacionActivoFijoConstantesFunciones.FECHACOMPRA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DepreciacionActivoFijoConstantesFunciones.FECHADEPREACTI;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DepreciacionActivoFijoConstantesFunciones.PORCENTAJE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DepreciacionActivoFijoConstantesFunciones.COSTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DepreciacionActivoFijoConstantesFunciones.VALORACUMULADO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DepreciacionActivoFijoConstantesFunciones.VALORTOTAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DepreciacionActivoFijoConstantesFunciones.VALORGASTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DepreciacionActivoFijoConstantesFunciones.FECHA;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDepreciacionActivoFijo() throws Exception  {
		return DepreciacionActivoFijoConstantesFunciones.getTiposSeleccionarDepreciacionActivoFijo(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDepreciacionActivoFijo(Boolean conFk) throws Exception  {
		return DepreciacionActivoFijoConstantesFunciones.getTiposSeleccionarDepreciacionActivoFijo(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDepreciacionActivoFijo(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DepreciacionActivoFijoConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(DepreciacionActivoFijoConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DepreciacionActivoFijoConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(DepreciacionActivoFijoConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DepreciacionActivoFijoConstantesFunciones.LABEL_IDDETALLEACTIVOFIJO);
			reporte.setsDescripcion(DepreciacionActivoFijoConstantesFunciones.LABEL_IDDETALLEACTIVOFIJO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DepreciacionActivoFijoConstantesFunciones.LABEL_IDTIPODEPRECIACIONEMPRESA);
			reporte.setsDescripcion(DepreciacionActivoFijoConstantesFunciones.LABEL_IDTIPODEPRECIACIONEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DepreciacionActivoFijoConstantesFunciones.LABEL_IDESTADODEPREACTI);
			reporte.setsDescripcion(DepreciacionActivoFijoConstantesFunciones.LABEL_IDESTADODEPREACTI);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DepreciacionActivoFijoConstantesFunciones.LABEL_IDANIO);
			reporte.setsDescripcion(DepreciacionActivoFijoConstantesFunciones.LABEL_IDANIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DepreciacionActivoFijoConstantesFunciones.LABEL_IDMES);
			reporte.setsDescripcion(DepreciacionActivoFijoConstantesFunciones.LABEL_IDMES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DepreciacionActivoFijoConstantesFunciones.LABEL_FECHACOMPRA);
			reporte.setsDescripcion(DepreciacionActivoFijoConstantesFunciones.LABEL_FECHACOMPRA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DepreciacionActivoFijoConstantesFunciones.LABEL_FECHADEPREACTI);
			reporte.setsDescripcion(DepreciacionActivoFijoConstantesFunciones.LABEL_FECHADEPREACTI);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DepreciacionActivoFijoConstantesFunciones.LABEL_PORCENTAJE);
			reporte.setsDescripcion(DepreciacionActivoFijoConstantesFunciones.LABEL_PORCENTAJE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DepreciacionActivoFijoConstantesFunciones.LABEL_COSTO);
			reporte.setsDescripcion(DepreciacionActivoFijoConstantesFunciones.LABEL_COSTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DepreciacionActivoFijoConstantesFunciones.LABEL_VALORACUMULADO);
			reporte.setsDescripcion(DepreciacionActivoFijoConstantesFunciones.LABEL_VALORACUMULADO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DepreciacionActivoFijoConstantesFunciones.LABEL_VALORTOTAL);
			reporte.setsDescripcion(DepreciacionActivoFijoConstantesFunciones.LABEL_VALORTOTAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DepreciacionActivoFijoConstantesFunciones.LABEL_VALORGASTO);
			reporte.setsDescripcion(DepreciacionActivoFijoConstantesFunciones.LABEL_VALORGASTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFechaColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DepreciacionActivoFijoConstantesFunciones.LABEL_FECHA);
			reporte.setsDescripcion(DepreciacionActivoFijoConstantesFunciones.LABEL_FECHA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesDepreciacionActivoFijo(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesDepreciacionActivoFijo(DepreciacionActivoFijo depreciacionactivofijoAux) throws Exception {
		
			depreciacionactivofijoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(depreciacionactivofijoAux.getEmpresa()));
			depreciacionactivofijoAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(depreciacionactivofijoAux.getSucursal()));
			depreciacionactivofijoAux.setdetalleactivofijo_descripcion(DetalleActivoFijoConstantesFunciones.getDetalleActivoFijoDescripcion(depreciacionactivofijoAux.getDetalleActivoFijo()));
			depreciacionactivofijoAux.settipodepreciacionempresa_descripcion(TipoDepreciacionEmpresaConstantesFunciones.getTipoDepreciacionEmpresaDescripcion(depreciacionactivofijoAux.getTipoDepreciacionEmpresa()));
			depreciacionactivofijoAux.setestadodepreacti_descripcion(EstadoDepreActiConstantesFunciones.getEstadoDepreActiDescripcion(depreciacionactivofijoAux.getEstadoDepreActi()));
			depreciacionactivofijoAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(depreciacionactivofijoAux.getAnio()));
			depreciacionactivofijoAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(depreciacionactivofijoAux.getMes()));		
	}
	
	public static void refrescarForeignKeysDescripcionesDepreciacionActivoFijo(List<DepreciacionActivoFijo> depreciacionactivofijosTemp) throws Exception {
		for(DepreciacionActivoFijo depreciacionactivofijoAux:depreciacionactivofijosTemp) {
			
			depreciacionactivofijoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(depreciacionactivofijoAux.getEmpresa()));
			depreciacionactivofijoAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(depreciacionactivofijoAux.getSucursal()));
			depreciacionactivofijoAux.setdetalleactivofijo_descripcion(DetalleActivoFijoConstantesFunciones.getDetalleActivoFijoDescripcion(depreciacionactivofijoAux.getDetalleActivoFijo()));
			depreciacionactivofijoAux.settipodepreciacionempresa_descripcion(TipoDepreciacionEmpresaConstantesFunciones.getTipoDepreciacionEmpresaDescripcion(depreciacionactivofijoAux.getTipoDepreciacionEmpresa()));
			depreciacionactivofijoAux.setestadodepreacti_descripcion(EstadoDepreActiConstantesFunciones.getEstadoDepreActiDescripcion(depreciacionactivofijoAux.getEstadoDepreActi()));
			depreciacionactivofijoAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(depreciacionactivofijoAux.getAnio()));
			depreciacionactivofijoAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(depreciacionactivofijoAux.getMes()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfDepreciacionActivoFijo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(DetalleActivoFijo.class));
				classes.add(new Classe(TipoDepreciacionEmpresa.class));
				classes.add(new Classe(EstadoDepreActi.class));
				classes.add(new Classe(Anio.class));
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
					if(clas.clas.equals(DetalleActivoFijo.class)) {
						classes.add(new Classe(DetalleActivoFijo.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(TipoDepreciacionEmpresa.class)) {
						classes.add(new Classe(TipoDepreciacionEmpresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(EstadoDepreActi.class)) {
						classes.add(new Classe(EstadoDepreActi.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(Anio.class)) {
						classes.add(new Classe(Anio.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfDepreciacionActivoFijo(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(DetalleActivoFijo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleActivoFijo.class)); continue;
					}

					if(TipoDepreciacionEmpresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoDepreciacionEmpresa.class)); continue;
					}

					if(EstadoDepreActi.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoDepreActi.class)); continue;
					}

					if(Anio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Anio.class)); continue;
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

					if(DetalleActivoFijo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleActivoFijo.class)); continue;
					}

					if(TipoDepreciacionEmpresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(TipoDepreciacionEmpresa.class)); continue;
					}

					if(EstadoDepreActi.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(EstadoDepreActi.class)); continue;
					}

					if(Anio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Anio.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfDepreciacionActivoFijo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return DepreciacionActivoFijoConstantesFunciones.getClassesRelationshipsOfDepreciacionActivoFijo(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDepreciacionActivoFijo(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDepreciacionActivoFijo(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return DepreciacionActivoFijoConstantesFunciones.getClassesRelationshipsFromStringsOfDepreciacionActivoFijo(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDepreciacionActivoFijo(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(DepreciacionActivoFijo depreciacionactivofijo,List<DepreciacionActivoFijo> depreciacionactivofijos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			DepreciacionActivoFijo depreciacionactivofijoEncontrado=null;
			
			for(DepreciacionActivoFijo depreciacionactivofijoLocal:depreciacionactivofijos) {
				if(depreciacionactivofijoLocal.getId().equals(depreciacionactivofijo.getId())) {
					depreciacionactivofijoEncontrado=depreciacionactivofijoLocal;
					
					depreciacionactivofijoLocal.setIsChanged(depreciacionactivofijo.getIsChanged());
					depreciacionactivofijoLocal.setIsNew(depreciacionactivofijo.getIsNew());
					depreciacionactivofijoLocal.setIsDeleted(depreciacionactivofijo.getIsDeleted());
					
					depreciacionactivofijoLocal.setGeneralEntityOriginal(depreciacionactivofijo.getGeneralEntityOriginal());
					
					depreciacionactivofijoLocal.setId(depreciacionactivofijo.getId());	
					depreciacionactivofijoLocal.setVersionRow(depreciacionactivofijo.getVersionRow());	
					depreciacionactivofijoLocal.setid_empresa(depreciacionactivofijo.getid_empresa());	
					depreciacionactivofijoLocal.setid_sucursal(depreciacionactivofijo.getid_sucursal());	
					depreciacionactivofijoLocal.setid_detalle_activo_fijo(depreciacionactivofijo.getid_detalle_activo_fijo());	
					depreciacionactivofijoLocal.setid_tipo_depreciacion_empresa(depreciacionactivofijo.getid_tipo_depreciacion_empresa());	
					depreciacionactivofijoLocal.setid_estado_depre_acti(depreciacionactivofijo.getid_estado_depre_acti());	
					depreciacionactivofijoLocal.setid_anio(depreciacionactivofijo.getid_anio());	
					depreciacionactivofijoLocal.setid_mes(depreciacionactivofijo.getid_mes());	
					depreciacionactivofijoLocal.setfecha_compra(depreciacionactivofijo.getfecha_compra());	
					depreciacionactivofijoLocal.setfecha_depre_acti(depreciacionactivofijo.getfecha_depre_acti());	
					depreciacionactivofijoLocal.setporcentaje(depreciacionactivofijo.getporcentaje());	
					depreciacionactivofijoLocal.setcosto(depreciacionactivofijo.getcosto());	
					depreciacionactivofijoLocal.setvalor_acumulado(depreciacionactivofijo.getvalor_acumulado());	
					depreciacionactivofijoLocal.setvalor_total(depreciacionactivofijo.getvalor_total());	
					depreciacionactivofijoLocal.setvalor_gasto(depreciacionactivofijo.getvalor_gasto());	
					depreciacionactivofijoLocal.setfecha(depreciacionactivofijo.getfecha());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!depreciacionactivofijo.getIsDeleted()) {
				if(!existe) {
					depreciacionactivofijos.add(depreciacionactivofijo);
				}
			} else {
				if(depreciacionactivofijoEncontrado!=null && permiteQuitar)  {
					depreciacionactivofijos.remove(depreciacionactivofijoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(DepreciacionActivoFijo depreciacionactivofijo,List<DepreciacionActivoFijo> depreciacionactivofijos) throws Exception {
		try	{			
			for(DepreciacionActivoFijo depreciacionactivofijoLocal:depreciacionactivofijos) {
				if(depreciacionactivofijoLocal.getId().equals(depreciacionactivofijo.getId())) {
					depreciacionactivofijoLocal.setIsSelected(depreciacionactivofijo.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesDepreciacionActivoFijo(List<DepreciacionActivoFijo> depreciacionactivofijosAux) throws Exception {
		//this.depreciacionactivofijosAux=depreciacionactivofijosAux;
		
		for(DepreciacionActivoFijo depreciacionactivofijoAux:depreciacionactivofijosAux) {
			if(depreciacionactivofijoAux.getIsChanged()) {
				depreciacionactivofijoAux.setIsChanged(false);
			}		
			
			if(depreciacionactivofijoAux.getIsNew()) {
				depreciacionactivofijoAux.setIsNew(false);
			}	
			
			if(depreciacionactivofijoAux.getIsDeleted()) {
				depreciacionactivofijoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesDepreciacionActivoFijo(DepreciacionActivoFijo depreciacionactivofijoAux) throws Exception {
		//this.depreciacionactivofijoAux=depreciacionactivofijoAux;
		
			if(depreciacionactivofijoAux.getIsChanged()) {
				depreciacionactivofijoAux.setIsChanged(false);
			}		
			
			if(depreciacionactivofijoAux.getIsNew()) {
				depreciacionactivofijoAux.setIsNew(false);
			}	
			
			if(depreciacionactivofijoAux.getIsDeleted()) {
				depreciacionactivofijoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(DepreciacionActivoFijo depreciacionactivofijoAsignar,DepreciacionActivoFijo depreciacionactivofijo) throws Exception {
		depreciacionactivofijoAsignar.setId(depreciacionactivofijo.getId());	
		depreciacionactivofijoAsignar.setVersionRow(depreciacionactivofijo.getVersionRow());	
		depreciacionactivofijoAsignar.setid_empresa(depreciacionactivofijo.getid_empresa());
		depreciacionactivofijoAsignar.setempresa_descripcion(depreciacionactivofijo.getempresa_descripcion());	
		depreciacionactivofijoAsignar.setid_sucursal(depreciacionactivofijo.getid_sucursal());
		depreciacionactivofijoAsignar.setsucursal_descripcion(depreciacionactivofijo.getsucursal_descripcion());	
		depreciacionactivofijoAsignar.setid_detalle_activo_fijo(depreciacionactivofijo.getid_detalle_activo_fijo());
		depreciacionactivofijoAsignar.setdetalleactivofijo_descripcion(depreciacionactivofijo.getdetalleactivofijo_descripcion());	
		depreciacionactivofijoAsignar.setid_tipo_depreciacion_empresa(depreciacionactivofijo.getid_tipo_depreciacion_empresa());
		depreciacionactivofijoAsignar.settipodepreciacionempresa_descripcion(depreciacionactivofijo.gettipodepreciacionempresa_descripcion());	
		depreciacionactivofijoAsignar.setid_estado_depre_acti(depreciacionactivofijo.getid_estado_depre_acti());
		depreciacionactivofijoAsignar.setestadodepreacti_descripcion(depreciacionactivofijo.getestadodepreacti_descripcion());	
		depreciacionactivofijoAsignar.setid_anio(depreciacionactivofijo.getid_anio());
		depreciacionactivofijoAsignar.setanio_descripcion(depreciacionactivofijo.getanio_descripcion());	
		depreciacionactivofijoAsignar.setid_mes(depreciacionactivofijo.getid_mes());
		depreciacionactivofijoAsignar.setmes_descripcion(depreciacionactivofijo.getmes_descripcion());	
		depreciacionactivofijoAsignar.setfecha_compra(depreciacionactivofijo.getfecha_compra());	
		depreciacionactivofijoAsignar.setfecha_depre_acti(depreciacionactivofijo.getfecha_depre_acti());	
		depreciacionactivofijoAsignar.setporcentaje(depreciacionactivofijo.getporcentaje());	
		depreciacionactivofijoAsignar.setcosto(depreciacionactivofijo.getcosto());	
		depreciacionactivofijoAsignar.setvalor_acumulado(depreciacionactivofijo.getvalor_acumulado());	
		depreciacionactivofijoAsignar.setvalor_total(depreciacionactivofijo.getvalor_total());	
		depreciacionactivofijoAsignar.setvalor_gasto(depreciacionactivofijo.getvalor_gasto());	
		depreciacionactivofijoAsignar.setfecha(depreciacionactivofijo.getfecha());	
	}
	
	public static void inicializarDepreciacionActivoFijo(DepreciacionActivoFijo depreciacionactivofijo) throws Exception {
		try {
				depreciacionactivofijo.setId(0L);	
					
				depreciacionactivofijo.setid_empresa(-1L);	
				depreciacionactivofijo.setid_sucursal(-1L);	
				depreciacionactivofijo.setid_detalle_activo_fijo(-1L);	
				depreciacionactivofijo.setid_tipo_depreciacion_empresa(-1L);	
				depreciacionactivofijo.setid_estado_depre_acti(-1L);	
				depreciacionactivofijo.setid_anio(null);	
				depreciacionactivofijo.setid_mes(null);	
				depreciacionactivofijo.setfecha_compra(new Date());	
				depreciacionactivofijo.setfecha_depre_acti(new Date());	
				depreciacionactivofijo.setporcentaje(0.0);	
				depreciacionactivofijo.setcosto(0.0);	
				depreciacionactivofijo.setvalor_acumulado(0.0);	
				depreciacionactivofijo.setvalor_total(0.0);	
				depreciacionactivofijo.setvalor_gasto(0.0);	
				depreciacionactivofijo.setfecha(new Date());	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderDepreciacionActivoFijo(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(DepreciacionActivoFijoConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DepreciacionActivoFijoConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DepreciacionActivoFijoConstantesFunciones.LABEL_IDDETALLEACTIVOFIJO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DepreciacionActivoFijoConstantesFunciones.LABEL_IDTIPODEPRECIACIONEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DepreciacionActivoFijoConstantesFunciones.LABEL_IDESTADODEPREACTI);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DepreciacionActivoFijoConstantesFunciones.LABEL_IDANIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DepreciacionActivoFijoConstantesFunciones.LABEL_IDMES);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DepreciacionActivoFijoConstantesFunciones.LABEL_FECHACOMPRA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DepreciacionActivoFijoConstantesFunciones.LABEL_FECHADEPREACTI);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DepreciacionActivoFijoConstantesFunciones.LABEL_PORCENTAJE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DepreciacionActivoFijoConstantesFunciones.LABEL_COSTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DepreciacionActivoFijoConstantesFunciones.LABEL_VALORACUMULADO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DepreciacionActivoFijoConstantesFunciones.LABEL_VALORTOTAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DepreciacionActivoFijoConstantesFunciones.LABEL_VALORGASTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DepreciacionActivoFijoConstantesFunciones.LABEL_FECHA);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataDepreciacionActivoFijo(String sTipo,Row row,Workbook workbook,DepreciacionActivoFijo depreciacionactivofijo,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(depreciacionactivofijo.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(depreciacionactivofijo.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(depreciacionactivofijo.getdetalleactivofijo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(depreciacionactivofijo.gettipodepreciacionempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(depreciacionactivofijo.getestadodepreacti_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(depreciacionactivofijo.getanio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(depreciacionactivofijo.getmes_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(depreciacionactivofijo.getfecha_compra());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(depreciacionactivofijo.getfecha_depre_acti());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(depreciacionactivofijo.getporcentaje());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(depreciacionactivofijo.getcosto());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(depreciacionactivofijo.getvalor_acumulado());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(depreciacionactivofijo.getvalor_total());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(depreciacionactivofijo.getvalor_gasto());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(depreciacionactivofijo.getfecha());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryDepreciacionActivoFijo=Constantes.SFINALQUERY;
	
	public String getsFinalQueryDepreciacionActivoFijo() {
		return this.sFinalQueryDepreciacionActivoFijo;
	}
	
	public void setsFinalQueryDepreciacionActivoFijo(String sFinalQueryDepreciacionActivoFijo) {
		this.sFinalQueryDepreciacionActivoFijo= sFinalQueryDepreciacionActivoFijo;
	}
	
	public Border resaltarSeleccionarDepreciacionActivoFijo=null;
	
	public Border setResaltarSeleccionarDepreciacionActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*DepreciacionActivoFijoBeanSwingJInternalFrame depreciacionactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//depreciacionactivofijoBeanSwingJInternalFrame.jTtoolBarDepreciacionActivoFijo.setBorder(borderResaltar);
		
		this.resaltarSeleccionarDepreciacionActivoFijo= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarDepreciacionActivoFijo() {
		return this.resaltarSeleccionarDepreciacionActivoFijo;
	}
	
	public void setResaltarSeleccionarDepreciacionActivoFijo(Border borderResaltarSeleccionarDepreciacionActivoFijo) {
		this.resaltarSeleccionarDepreciacionActivoFijo= borderResaltarSeleccionarDepreciacionActivoFijo;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridDepreciacionActivoFijo=null;
	public Boolean mostraridDepreciacionActivoFijo=true;
	public Boolean activaridDepreciacionActivoFijo=true;

	public Border resaltarid_empresaDepreciacionActivoFijo=null;
	public Boolean mostrarid_empresaDepreciacionActivoFijo=true;
	public Boolean activarid_empresaDepreciacionActivoFijo=true;
	public Boolean cargarid_empresaDepreciacionActivoFijo=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaDepreciacionActivoFijo=false;//ConEventDepend=true

	public Border resaltarid_sucursalDepreciacionActivoFijo=null;
	public Boolean mostrarid_sucursalDepreciacionActivoFijo=true;
	public Boolean activarid_sucursalDepreciacionActivoFijo=true;
	public Boolean cargarid_sucursalDepreciacionActivoFijo=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalDepreciacionActivoFijo=false;//ConEventDepend=true

	public Border resaltarid_detalle_activo_fijoDepreciacionActivoFijo=null;
	public Boolean mostrarid_detalle_activo_fijoDepreciacionActivoFijo=true;
	public Boolean activarid_detalle_activo_fijoDepreciacionActivoFijo=true;
	public Boolean cargarid_detalle_activo_fijoDepreciacionActivoFijo=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_detalle_activo_fijoDepreciacionActivoFijo=false;//ConEventDepend=true

	public Border resaltarid_tipo_depreciacion_empresaDepreciacionActivoFijo=null;
	public Boolean mostrarid_tipo_depreciacion_empresaDepreciacionActivoFijo=true;
	public Boolean activarid_tipo_depreciacion_empresaDepreciacionActivoFijo=true;
	public Boolean cargarid_tipo_depreciacion_empresaDepreciacionActivoFijo=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_tipo_depreciacion_empresaDepreciacionActivoFijo=false;//ConEventDepend=true

	public Border resaltarid_estado_depre_actiDepreciacionActivoFijo=null;
	public Boolean mostrarid_estado_depre_actiDepreciacionActivoFijo=true;
	public Boolean activarid_estado_depre_actiDepreciacionActivoFijo=true;
	public Boolean cargarid_estado_depre_actiDepreciacionActivoFijo=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_estado_depre_actiDepreciacionActivoFijo=false;//ConEventDepend=true

	public Border resaltarid_anioDepreciacionActivoFijo=null;
	public Boolean mostrarid_anioDepreciacionActivoFijo=true;
	public Boolean activarid_anioDepreciacionActivoFijo=true;
	public Boolean cargarid_anioDepreciacionActivoFijo=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_anioDepreciacionActivoFijo=false;//ConEventDepend=true

	public Border resaltarid_mesDepreciacionActivoFijo=null;
	public Boolean mostrarid_mesDepreciacionActivoFijo=true;
	public Boolean activarid_mesDepreciacionActivoFijo=true;
	public Boolean cargarid_mesDepreciacionActivoFijo=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_mesDepreciacionActivoFijo=false;//ConEventDepend=true

	public Border resaltarfecha_compraDepreciacionActivoFijo=null;
	public Boolean mostrarfecha_compraDepreciacionActivoFijo=true;
	public Boolean activarfecha_compraDepreciacionActivoFijo=false;

	public Border resaltarfecha_depre_actiDepreciacionActivoFijo=null;
	public Boolean mostrarfecha_depre_actiDepreciacionActivoFijo=true;
	public Boolean activarfecha_depre_actiDepreciacionActivoFijo=false;

	public Border resaltarporcentajeDepreciacionActivoFijo=null;
	public Boolean mostrarporcentajeDepreciacionActivoFijo=true;
	public Boolean activarporcentajeDepreciacionActivoFijo=true;

	public Border resaltarcostoDepreciacionActivoFijo=null;
	public Boolean mostrarcostoDepreciacionActivoFijo=true;
	public Boolean activarcostoDepreciacionActivoFijo=true;

	public Border resaltarvalor_acumuladoDepreciacionActivoFijo=null;
	public Boolean mostrarvalor_acumuladoDepreciacionActivoFijo=true;
	public Boolean activarvalor_acumuladoDepreciacionActivoFijo=true;

	public Border resaltarvalor_totalDepreciacionActivoFijo=null;
	public Boolean mostrarvalor_totalDepreciacionActivoFijo=true;
	public Boolean activarvalor_totalDepreciacionActivoFijo=true;

	public Border resaltarvalor_gastoDepreciacionActivoFijo=null;
	public Boolean mostrarvalor_gastoDepreciacionActivoFijo=true;
	public Boolean activarvalor_gastoDepreciacionActivoFijo=true;

	public Border resaltarfechaDepreciacionActivoFijo=null;
	public Boolean mostrarfechaDepreciacionActivoFijo=true;
	public Boolean activarfechaDepreciacionActivoFijo=false;

	
	

	public Border setResaltaridDepreciacionActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*DepreciacionActivoFijoBeanSwingJInternalFrame depreciacionactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//depreciacionactivofijoBeanSwingJInternalFrame.jTtoolBarDepreciacionActivoFijo.setBorder(borderResaltar);
		
		this.resaltaridDepreciacionActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridDepreciacionActivoFijo() {
		return this.resaltaridDepreciacionActivoFijo;
	}

	public void setResaltaridDepreciacionActivoFijo(Border borderResaltar) {
		this.resaltaridDepreciacionActivoFijo= borderResaltar;
	}

	public Boolean getMostraridDepreciacionActivoFijo() {
		return this.mostraridDepreciacionActivoFijo;
	}

	public void setMostraridDepreciacionActivoFijo(Boolean mostraridDepreciacionActivoFijo) {
		this.mostraridDepreciacionActivoFijo= mostraridDepreciacionActivoFijo;
	}

	public Boolean getActivaridDepreciacionActivoFijo() {
		return this.activaridDepreciacionActivoFijo;
	}

	public void setActivaridDepreciacionActivoFijo(Boolean activaridDepreciacionActivoFijo) {
		this.activaridDepreciacionActivoFijo= activaridDepreciacionActivoFijo;
	}

	public Border setResaltarid_empresaDepreciacionActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*DepreciacionActivoFijoBeanSwingJInternalFrame depreciacionactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//depreciacionactivofijoBeanSwingJInternalFrame.jTtoolBarDepreciacionActivoFijo.setBorder(borderResaltar);
		
		this.resaltarid_empresaDepreciacionActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaDepreciacionActivoFijo() {
		return this.resaltarid_empresaDepreciacionActivoFijo;
	}

	public void setResaltarid_empresaDepreciacionActivoFijo(Border borderResaltar) {
		this.resaltarid_empresaDepreciacionActivoFijo= borderResaltar;
	}

	public Boolean getMostrarid_empresaDepreciacionActivoFijo() {
		return this.mostrarid_empresaDepreciacionActivoFijo;
	}

	public void setMostrarid_empresaDepreciacionActivoFijo(Boolean mostrarid_empresaDepreciacionActivoFijo) {
		this.mostrarid_empresaDepreciacionActivoFijo= mostrarid_empresaDepreciacionActivoFijo;
	}

	public Boolean getActivarid_empresaDepreciacionActivoFijo() {
		return this.activarid_empresaDepreciacionActivoFijo;
	}

	public void setActivarid_empresaDepreciacionActivoFijo(Boolean activarid_empresaDepreciacionActivoFijo) {
		this.activarid_empresaDepreciacionActivoFijo= activarid_empresaDepreciacionActivoFijo;
	}

	public Boolean getCargarid_empresaDepreciacionActivoFijo() {
		return this.cargarid_empresaDepreciacionActivoFijo;
	}

	public void setCargarid_empresaDepreciacionActivoFijo(Boolean cargarid_empresaDepreciacionActivoFijo) {
		this.cargarid_empresaDepreciacionActivoFijo= cargarid_empresaDepreciacionActivoFijo;
	}

	public Border setResaltarid_sucursalDepreciacionActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*DepreciacionActivoFijoBeanSwingJInternalFrame depreciacionactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//depreciacionactivofijoBeanSwingJInternalFrame.jTtoolBarDepreciacionActivoFijo.setBorder(borderResaltar);
		
		this.resaltarid_sucursalDepreciacionActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalDepreciacionActivoFijo() {
		return this.resaltarid_sucursalDepreciacionActivoFijo;
	}

	public void setResaltarid_sucursalDepreciacionActivoFijo(Border borderResaltar) {
		this.resaltarid_sucursalDepreciacionActivoFijo= borderResaltar;
	}

	public Boolean getMostrarid_sucursalDepreciacionActivoFijo() {
		return this.mostrarid_sucursalDepreciacionActivoFijo;
	}

	public void setMostrarid_sucursalDepreciacionActivoFijo(Boolean mostrarid_sucursalDepreciacionActivoFijo) {
		this.mostrarid_sucursalDepreciacionActivoFijo= mostrarid_sucursalDepreciacionActivoFijo;
	}

	public Boolean getActivarid_sucursalDepreciacionActivoFijo() {
		return this.activarid_sucursalDepreciacionActivoFijo;
	}

	public void setActivarid_sucursalDepreciacionActivoFijo(Boolean activarid_sucursalDepreciacionActivoFijo) {
		this.activarid_sucursalDepreciacionActivoFijo= activarid_sucursalDepreciacionActivoFijo;
	}

	public Boolean getCargarid_sucursalDepreciacionActivoFijo() {
		return this.cargarid_sucursalDepreciacionActivoFijo;
	}

	public void setCargarid_sucursalDepreciacionActivoFijo(Boolean cargarid_sucursalDepreciacionActivoFijo) {
		this.cargarid_sucursalDepreciacionActivoFijo= cargarid_sucursalDepreciacionActivoFijo;
	}

	public Border setResaltarid_detalle_activo_fijoDepreciacionActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*DepreciacionActivoFijoBeanSwingJInternalFrame depreciacionactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//depreciacionactivofijoBeanSwingJInternalFrame.jTtoolBarDepreciacionActivoFijo.setBorder(borderResaltar);
		
		this.resaltarid_detalle_activo_fijoDepreciacionActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_detalle_activo_fijoDepreciacionActivoFijo() {
		return this.resaltarid_detalle_activo_fijoDepreciacionActivoFijo;
	}

	public void setResaltarid_detalle_activo_fijoDepreciacionActivoFijo(Border borderResaltar) {
		this.resaltarid_detalle_activo_fijoDepreciacionActivoFijo= borderResaltar;
	}

	public Boolean getMostrarid_detalle_activo_fijoDepreciacionActivoFijo() {
		return this.mostrarid_detalle_activo_fijoDepreciacionActivoFijo;
	}

	public void setMostrarid_detalle_activo_fijoDepreciacionActivoFijo(Boolean mostrarid_detalle_activo_fijoDepreciacionActivoFijo) {
		this.mostrarid_detalle_activo_fijoDepreciacionActivoFijo= mostrarid_detalle_activo_fijoDepreciacionActivoFijo;
	}

	public Boolean getActivarid_detalle_activo_fijoDepreciacionActivoFijo() {
		return this.activarid_detalle_activo_fijoDepreciacionActivoFijo;
	}

	public void setActivarid_detalle_activo_fijoDepreciacionActivoFijo(Boolean activarid_detalle_activo_fijoDepreciacionActivoFijo) {
		this.activarid_detalle_activo_fijoDepreciacionActivoFijo= activarid_detalle_activo_fijoDepreciacionActivoFijo;
	}

	public Boolean getCargarid_detalle_activo_fijoDepreciacionActivoFijo() {
		return this.cargarid_detalle_activo_fijoDepreciacionActivoFijo;
	}

	public void setCargarid_detalle_activo_fijoDepreciacionActivoFijo(Boolean cargarid_detalle_activo_fijoDepreciacionActivoFijo) {
		this.cargarid_detalle_activo_fijoDepreciacionActivoFijo= cargarid_detalle_activo_fijoDepreciacionActivoFijo;
	}

	public Border setResaltarid_tipo_depreciacion_empresaDepreciacionActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*DepreciacionActivoFijoBeanSwingJInternalFrame depreciacionactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//depreciacionactivofijoBeanSwingJInternalFrame.jTtoolBarDepreciacionActivoFijo.setBorder(borderResaltar);
		
		this.resaltarid_tipo_depreciacion_empresaDepreciacionActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_tipo_depreciacion_empresaDepreciacionActivoFijo() {
		return this.resaltarid_tipo_depreciacion_empresaDepreciacionActivoFijo;
	}

	public void setResaltarid_tipo_depreciacion_empresaDepreciacionActivoFijo(Border borderResaltar) {
		this.resaltarid_tipo_depreciacion_empresaDepreciacionActivoFijo= borderResaltar;
	}

	public Boolean getMostrarid_tipo_depreciacion_empresaDepreciacionActivoFijo() {
		return this.mostrarid_tipo_depreciacion_empresaDepreciacionActivoFijo;
	}

	public void setMostrarid_tipo_depreciacion_empresaDepreciacionActivoFijo(Boolean mostrarid_tipo_depreciacion_empresaDepreciacionActivoFijo) {
		this.mostrarid_tipo_depreciacion_empresaDepreciacionActivoFijo= mostrarid_tipo_depreciacion_empresaDepreciacionActivoFijo;
	}

	public Boolean getActivarid_tipo_depreciacion_empresaDepreciacionActivoFijo() {
		return this.activarid_tipo_depreciacion_empresaDepreciacionActivoFijo;
	}

	public void setActivarid_tipo_depreciacion_empresaDepreciacionActivoFijo(Boolean activarid_tipo_depreciacion_empresaDepreciacionActivoFijo) {
		this.activarid_tipo_depreciacion_empresaDepreciacionActivoFijo= activarid_tipo_depreciacion_empresaDepreciacionActivoFijo;
	}

	public Boolean getCargarid_tipo_depreciacion_empresaDepreciacionActivoFijo() {
		return this.cargarid_tipo_depreciacion_empresaDepreciacionActivoFijo;
	}

	public void setCargarid_tipo_depreciacion_empresaDepreciacionActivoFijo(Boolean cargarid_tipo_depreciacion_empresaDepreciacionActivoFijo) {
		this.cargarid_tipo_depreciacion_empresaDepreciacionActivoFijo= cargarid_tipo_depreciacion_empresaDepreciacionActivoFijo;
	}

	public Border setResaltarid_estado_depre_actiDepreciacionActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*DepreciacionActivoFijoBeanSwingJInternalFrame depreciacionactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//depreciacionactivofijoBeanSwingJInternalFrame.jTtoolBarDepreciacionActivoFijo.setBorder(borderResaltar);
		
		this.resaltarid_estado_depre_actiDepreciacionActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_estado_depre_actiDepreciacionActivoFijo() {
		return this.resaltarid_estado_depre_actiDepreciacionActivoFijo;
	}

	public void setResaltarid_estado_depre_actiDepreciacionActivoFijo(Border borderResaltar) {
		this.resaltarid_estado_depre_actiDepreciacionActivoFijo= borderResaltar;
	}

	public Boolean getMostrarid_estado_depre_actiDepreciacionActivoFijo() {
		return this.mostrarid_estado_depre_actiDepreciacionActivoFijo;
	}

	public void setMostrarid_estado_depre_actiDepreciacionActivoFijo(Boolean mostrarid_estado_depre_actiDepreciacionActivoFijo) {
		this.mostrarid_estado_depre_actiDepreciacionActivoFijo= mostrarid_estado_depre_actiDepreciacionActivoFijo;
	}

	public Boolean getActivarid_estado_depre_actiDepreciacionActivoFijo() {
		return this.activarid_estado_depre_actiDepreciacionActivoFijo;
	}

	public void setActivarid_estado_depre_actiDepreciacionActivoFijo(Boolean activarid_estado_depre_actiDepreciacionActivoFijo) {
		this.activarid_estado_depre_actiDepreciacionActivoFijo= activarid_estado_depre_actiDepreciacionActivoFijo;
	}

	public Boolean getCargarid_estado_depre_actiDepreciacionActivoFijo() {
		return this.cargarid_estado_depre_actiDepreciacionActivoFijo;
	}

	public void setCargarid_estado_depre_actiDepreciacionActivoFijo(Boolean cargarid_estado_depre_actiDepreciacionActivoFijo) {
		this.cargarid_estado_depre_actiDepreciacionActivoFijo= cargarid_estado_depre_actiDepreciacionActivoFijo;
	}

	public Border setResaltarid_anioDepreciacionActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*DepreciacionActivoFijoBeanSwingJInternalFrame depreciacionactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//depreciacionactivofijoBeanSwingJInternalFrame.jTtoolBarDepreciacionActivoFijo.setBorder(borderResaltar);
		
		this.resaltarid_anioDepreciacionActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_anioDepreciacionActivoFijo() {
		return this.resaltarid_anioDepreciacionActivoFijo;
	}

	public void setResaltarid_anioDepreciacionActivoFijo(Border borderResaltar) {
		this.resaltarid_anioDepreciacionActivoFijo= borderResaltar;
	}

	public Boolean getMostrarid_anioDepreciacionActivoFijo() {
		return this.mostrarid_anioDepreciacionActivoFijo;
	}

	public void setMostrarid_anioDepreciacionActivoFijo(Boolean mostrarid_anioDepreciacionActivoFijo) {
		this.mostrarid_anioDepreciacionActivoFijo= mostrarid_anioDepreciacionActivoFijo;
	}

	public Boolean getActivarid_anioDepreciacionActivoFijo() {
		return this.activarid_anioDepreciacionActivoFijo;
	}

	public void setActivarid_anioDepreciacionActivoFijo(Boolean activarid_anioDepreciacionActivoFijo) {
		this.activarid_anioDepreciacionActivoFijo= activarid_anioDepreciacionActivoFijo;
	}

	public Boolean getCargarid_anioDepreciacionActivoFijo() {
		return this.cargarid_anioDepreciacionActivoFijo;
	}

	public void setCargarid_anioDepreciacionActivoFijo(Boolean cargarid_anioDepreciacionActivoFijo) {
		this.cargarid_anioDepreciacionActivoFijo= cargarid_anioDepreciacionActivoFijo;
	}

	public Border setResaltarid_mesDepreciacionActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*DepreciacionActivoFijoBeanSwingJInternalFrame depreciacionactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//depreciacionactivofijoBeanSwingJInternalFrame.jTtoolBarDepreciacionActivoFijo.setBorder(borderResaltar);
		
		this.resaltarid_mesDepreciacionActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_mesDepreciacionActivoFijo() {
		return this.resaltarid_mesDepreciacionActivoFijo;
	}

	public void setResaltarid_mesDepreciacionActivoFijo(Border borderResaltar) {
		this.resaltarid_mesDepreciacionActivoFijo= borderResaltar;
	}

	public Boolean getMostrarid_mesDepreciacionActivoFijo() {
		return this.mostrarid_mesDepreciacionActivoFijo;
	}

	public void setMostrarid_mesDepreciacionActivoFijo(Boolean mostrarid_mesDepreciacionActivoFijo) {
		this.mostrarid_mesDepreciacionActivoFijo= mostrarid_mesDepreciacionActivoFijo;
	}

	public Boolean getActivarid_mesDepreciacionActivoFijo() {
		return this.activarid_mesDepreciacionActivoFijo;
	}

	public void setActivarid_mesDepreciacionActivoFijo(Boolean activarid_mesDepreciacionActivoFijo) {
		this.activarid_mesDepreciacionActivoFijo= activarid_mesDepreciacionActivoFijo;
	}

	public Boolean getCargarid_mesDepreciacionActivoFijo() {
		return this.cargarid_mesDepreciacionActivoFijo;
	}

	public void setCargarid_mesDepreciacionActivoFijo(Boolean cargarid_mesDepreciacionActivoFijo) {
		this.cargarid_mesDepreciacionActivoFijo= cargarid_mesDepreciacionActivoFijo;
	}

	public Border setResaltarfecha_compraDepreciacionActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*DepreciacionActivoFijoBeanSwingJInternalFrame depreciacionactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//depreciacionactivofijoBeanSwingJInternalFrame.jTtoolBarDepreciacionActivoFijo.setBorder(borderResaltar);
		
		this.resaltarfecha_compraDepreciacionActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_compraDepreciacionActivoFijo() {
		return this.resaltarfecha_compraDepreciacionActivoFijo;
	}

	public void setResaltarfecha_compraDepreciacionActivoFijo(Border borderResaltar) {
		this.resaltarfecha_compraDepreciacionActivoFijo= borderResaltar;
	}

	public Boolean getMostrarfecha_compraDepreciacionActivoFijo() {
		return this.mostrarfecha_compraDepreciacionActivoFijo;
	}

	public void setMostrarfecha_compraDepreciacionActivoFijo(Boolean mostrarfecha_compraDepreciacionActivoFijo) {
		this.mostrarfecha_compraDepreciacionActivoFijo= mostrarfecha_compraDepreciacionActivoFijo;
	}

	public Boolean getActivarfecha_compraDepreciacionActivoFijo() {
		return this.activarfecha_compraDepreciacionActivoFijo;
	}

	public void setActivarfecha_compraDepreciacionActivoFijo(Boolean activarfecha_compraDepreciacionActivoFijo) {
		this.activarfecha_compraDepreciacionActivoFijo= activarfecha_compraDepreciacionActivoFijo;
	}

	public Border setResaltarfecha_depre_actiDepreciacionActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*DepreciacionActivoFijoBeanSwingJInternalFrame depreciacionactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//depreciacionactivofijoBeanSwingJInternalFrame.jTtoolBarDepreciacionActivoFijo.setBorder(borderResaltar);
		
		this.resaltarfecha_depre_actiDepreciacionActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfecha_depre_actiDepreciacionActivoFijo() {
		return this.resaltarfecha_depre_actiDepreciacionActivoFijo;
	}

	public void setResaltarfecha_depre_actiDepreciacionActivoFijo(Border borderResaltar) {
		this.resaltarfecha_depre_actiDepreciacionActivoFijo= borderResaltar;
	}

	public Boolean getMostrarfecha_depre_actiDepreciacionActivoFijo() {
		return this.mostrarfecha_depre_actiDepreciacionActivoFijo;
	}

	public void setMostrarfecha_depre_actiDepreciacionActivoFijo(Boolean mostrarfecha_depre_actiDepreciacionActivoFijo) {
		this.mostrarfecha_depre_actiDepreciacionActivoFijo= mostrarfecha_depre_actiDepreciacionActivoFijo;
	}

	public Boolean getActivarfecha_depre_actiDepreciacionActivoFijo() {
		return this.activarfecha_depre_actiDepreciacionActivoFijo;
	}

	public void setActivarfecha_depre_actiDepreciacionActivoFijo(Boolean activarfecha_depre_actiDepreciacionActivoFijo) {
		this.activarfecha_depre_actiDepreciacionActivoFijo= activarfecha_depre_actiDepreciacionActivoFijo;
	}

	public Border setResaltarporcentajeDepreciacionActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*DepreciacionActivoFijoBeanSwingJInternalFrame depreciacionactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//depreciacionactivofijoBeanSwingJInternalFrame.jTtoolBarDepreciacionActivoFijo.setBorder(borderResaltar);
		
		this.resaltarporcentajeDepreciacionActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarporcentajeDepreciacionActivoFijo() {
		return this.resaltarporcentajeDepreciacionActivoFijo;
	}

	public void setResaltarporcentajeDepreciacionActivoFijo(Border borderResaltar) {
		this.resaltarporcentajeDepreciacionActivoFijo= borderResaltar;
	}

	public Boolean getMostrarporcentajeDepreciacionActivoFijo() {
		return this.mostrarporcentajeDepreciacionActivoFijo;
	}

	public void setMostrarporcentajeDepreciacionActivoFijo(Boolean mostrarporcentajeDepreciacionActivoFijo) {
		this.mostrarporcentajeDepreciacionActivoFijo= mostrarporcentajeDepreciacionActivoFijo;
	}

	public Boolean getActivarporcentajeDepreciacionActivoFijo() {
		return this.activarporcentajeDepreciacionActivoFijo;
	}

	public void setActivarporcentajeDepreciacionActivoFijo(Boolean activarporcentajeDepreciacionActivoFijo) {
		this.activarporcentajeDepreciacionActivoFijo= activarporcentajeDepreciacionActivoFijo;
	}

	public Border setResaltarcostoDepreciacionActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*DepreciacionActivoFijoBeanSwingJInternalFrame depreciacionactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//depreciacionactivofijoBeanSwingJInternalFrame.jTtoolBarDepreciacionActivoFijo.setBorder(borderResaltar);
		
		this.resaltarcostoDepreciacionActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcostoDepreciacionActivoFijo() {
		return this.resaltarcostoDepreciacionActivoFijo;
	}

	public void setResaltarcostoDepreciacionActivoFijo(Border borderResaltar) {
		this.resaltarcostoDepreciacionActivoFijo= borderResaltar;
	}

	public Boolean getMostrarcostoDepreciacionActivoFijo() {
		return this.mostrarcostoDepreciacionActivoFijo;
	}

	public void setMostrarcostoDepreciacionActivoFijo(Boolean mostrarcostoDepreciacionActivoFijo) {
		this.mostrarcostoDepreciacionActivoFijo= mostrarcostoDepreciacionActivoFijo;
	}

	public Boolean getActivarcostoDepreciacionActivoFijo() {
		return this.activarcostoDepreciacionActivoFijo;
	}

	public void setActivarcostoDepreciacionActivoFijo(Boolean activarcostoDepreciacionActivoFijo) {
		this.activarcostoDepreciacionActivoFijo= activarcostoDepreciacionActivoFijo;
	}

	public Border setResaltarvalor_acumuladoDepreciacionActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*DepreciacionActivoFijoBeanSwingJInternalFrame depreciacionactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//depreciacionactivofijoBeanSwingJInternalFrame.jTtoolBarDepreciacionActivoFijo.setBorder(borderResaltar);
		
		this.resaltarvalor_acumuladoDepreciacionActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_acumuladoDepreciacionActivoFijo() {
		return this.resaltarvalor_acumuladoDepreciacionActivoFijo;
	}

	public void setResaltarvalor_acumuladoDepreciacionActivoFijo(Border borderResaltar) {
		this.resaltarvalor_acumuladoDepreciacionActivoFijo= borderResaltar;
	}

	public Boolean getMostrarvalor_acumuladoDepreciacionActivoFijo() {
		return this.mostrarvalor_acumuladoDepreciacionActivoFijo;
	}

	public void setMostrarvalor_acumuladoDepreciacionActivoFijo(Boolean mostrarvalor_acumuladoDepreciacionActivoFijo) {
		this.mostrarvalor_acumuladoDepreciacionActivoFijo= mostrarvalor_acumuladoDepreciacionActivoFijo;
	}

	public Boolean getActivarvalor_acumuladoDepreciacionActivoFijo() {
		return this.activarvalor_acumuladoDepreciacionActivoFijo;
	}

	public void setActivarvalor_acumuladoDepreciacionActivoFijo(Boolean activarvalor_acumuladoDepreciacionActivoFijo) {
		this.activarvalor_acumuladoDepreciacionActivoFijo= activarvalor_acumuladoDepreciacionActivoFijo;
	}

	public Border setResaltarvalor_totalDepreciacionActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*DepreciacionActivoFijoBeanSwingJInternalFrame depreciacionactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//depreciacionactivofijoBeanSwingJInternalFrame.jTtoolBarDepreciacionActivoFijo.setBorder(borderResaltar);
		
		this.resaltarvalor_totalDepreciacionActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_totalDepreciacionActivoFijo() {
		return this.resaltarvalor_totalDepreciacionActivoFijo;
	}

	public void setResaltarvalor_totalDepreciacionActivoFijo(Border borderResaltar) {
		this.resaltarvalor_totalDepreciacionActivoFijo= borderResaltar;
	}

	public Boolean getMostrarvalor_totalDepreciacionActivoFijo() {
		return this.mostrarvalor_totalDepreciacionActivoFijo;
	}

	public void setMostrarvalor_totalDepreciacionActivoFijo(Boolean mostrarvalor_totalDepreciacionActivoFijo) {
		this.mostrarvalor_totalDepreciacionActivoFijo= mostrarvalor_totalDepreciacionActivoFijo;
	}

	public Boolean getActivarvalor_totalDepreciacionActivoFijo() {
		return this.activarvalor_totalDepreciacionActivoFijo;
	}

	public void setActivarvalor_totalDepreciacionActivoFijo(Boolean activarvalor_totalDepreciacionActivoFijo) {
		this.activarvalor_totalDepreciacionActivoFijo= activarvalor_totalDepreciacionActivoFijo;
	}

	public Border setResaltarvalor_gastoDepreciacionActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*DepreciacionActivoFijoBeanSwingJInternalFrame depreciacionactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//depreciacionactivofijoBeanSwingJInternalFrame.jTtoolBarDepreciacionActivoFijo.setBorder(borderResaltar);
		
		this.resaltarvalor_gastoDepreciacionActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalor_gastoDepreciacionActivoFijo() {
		return this.resaltarvalor_gastoDepreciacionActivoFijo;
	}

	public void setResaltarvalor_gastoDepreciacionActivoFijo(Border borderResaltar) {
		this.resaltarvalor_gastoDepreciacionActivoFijo= borderResaltar;
	}

	public Boolean getMostrarvalor_gastoDepreciacionActivoFijo() {
		return this.mostrarvalor_gastoDepreciacionActivoFijo;
	}

	public void setMostrarvalor_gastoDepreciacionActivoFijo(Boolean mostrarvalor_gastoDepreciacionActivoFijo) {
		this.mostrarvalor_gastoDepreciacionActivoFijo= mostrarvalor_gastoDepreciacionActivoFijo;
	}

	public Boolean getActivarvalor_gastoDepreciacionActivoFijo() {
		return this.activarvalor_gastoDepreciacionActivoFijo;
	}

	public void setActivarvalor_gastoDepreciacionActivoFijo(Boolean activarvalor_gastoDepreciacionActivoFijo) {
		this.activarvalor_gastoDepreciacionActivoFijo= activarvalor_gastoDepreciacionActivoFijo;
	}

	public Border setResaltarfechaDepreciacionActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*DepreciacionActivoFijoBeanSwingJInternalFrame depreciacionactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//depreciacionactivofijoBeanSwingJInternalFrame.jTtoolBarDepreciacionActivoFijo.setBorder(borderResaltar);
		
		this.resaltarfechaDepreciacionActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarfechaDepreciacionActivoFijo() {
		return this.resaltarfechaDepreciacionActivoFijo;
	}

	public void setResaltarfechaDepreciacionActivoFijo(Border borderResaltar) {
		this.resaltarfechaDepreciacionActivoFijo= borderResaltar;
	}

	public Boolean getMostrarfechaDepreciacionActivoFijo() {
		return this.mostrarfechaDepreciacionActivoFijo;
	}

	public void setMostrarfechaDepreciacionActivoFijo(Boolean mostrarfechaDepreciacionActivoFijo) {
		this.mostrarfechaDepreciacionActivoFijo= mostrarfechaDepreciacionActivoFijo;
	}

	public Boolean getActivarfechaDepreciacionActivoFijo() {
		return this.activarfechaDepreciacionActivoFijo;
	}

	public void setActivarfechaDepreciacionActivoFijo(Boolean activarfechaDepreciacionActivoFijo) {
		this.activarfechaDepreciacionActivoFijo= activarfechaDepreciacionActivoFijo;
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
		
		
		this.setMostraridDepreciacionActivoFijo(esInicial);
		this.setMostrarid_empresaDepreciacionActivoFijo(esInicial);
		this.setMostrarid_sucursalDepreciacionActivoFijo(esInicial);
		this.setMostrarid_detalle_activo_fijoDepreciacionActivoFijo(esInicial);
		this.setMostrarid_tipo_depreciacion_empresaDepreciacionActivoFijo(esInicial);
		this.setMostrarid_estado_depre_actiDepreciacionActivoFijo(esInicial);
		this.setMostrarid_anioDepreciacionActivoFijo(esInicial);
		this.setMostrarid_mesDepreciacionActivoFijo(esInicial);
		this.setMostrarfecha_compraDepreciacionActivoFijo(esInicial);
		this.setMostrarfecha_depre_actiDepreciacionActivoFijo(esInicial);
		this.setMostrarporcentajeDepreciacionActivoFijo(esInicial);
		this.setMostrarcostoDepreciacionActivoFijo(esInicial);
		this.setMostrarvalor_acumuladoDepreciacionActivoFijo(esInicial);
		this.setMostrarvalor_totalDepreciacionActivoFijo(esInicial);
		this.setMostrarvalor_gastoDepreciacionActivoFijo(esInicial);
		this.setMostrarfechaDepreciacionActivoFijo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DepreciacionActivoFijoConstantesFunciones.ID)) {
				this.setMostraridDepreciacionActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DepreciacionActivoFijoConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaDepreciacionActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DepreciacionActivoFijoConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalDepreciacionActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DepreciacionActivoFijoConstantesFunciones.IDDETALLEACTIVOFIJO)) {
				this.setMostrarid_detalle_activo_fijoDepreciacionActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DepreciacionActivoFijoConstantesFunciones.IDTIPODEPRECIACIONEMPRESA)) {
				this.setMostrarid_tipo_depreciacion_empresaDepreciacionActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DepreciacionActivoFijoConstantesFunciones.IDESTADODEPREACTI)) {
				this.setMostrarid_estado_depre_actiDepreciacionActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DepreciacionActivoFijoConstantesFunciones.IDANIO)) {
				this.setMostrarid_anioDepreciacionActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DepreciacionActivoFijoConstantesFunciones.IDMES)) {
				this.setMostrarid_mesDepreciacionActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DepreciacionActivoFijoConstantesFunciones.FECHACOMPRA)) {
				this.setMostrarfecha_compraDepreciacionActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DepreciacionActivoFijoConstantesFunciones.FECHADEPREACTI)) {
				this.setMostrarfecha_depre_actiDepreciacionActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DepreciacionActivoFijoConstantesFunciones.PORCENTAJE)) {
				this.setMostrarporcentajeDepreciacionActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DepreciacionActivoFijoConstantesFunciones.COSTO)) {
				this.setMostrarcostoDepreciacionActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DepreciacionActivoFijoConstantesFunciones.VALORACUMULADO)) {
				this.setMostrarvalor_acumuladoDepreciacionActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DepreciacionActivoFijoConstantesFunciones.VALORTOTAL)) {
				this.setMostrarvalor_totalDepreciacionActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DepreciacionActivoFijoConstantesFunciones.VALORGASTO)) {
				this.setMostrarvalor_gastoDepreciacionActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DepreciacionActivoFijoConstantesFunciones.FECHA)) {
				this.setMostrarfechaDepreciacionActivoFijo(esAsigna);
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
		
		
		this.setActivaridDepreciacionActivoFijo(esInicial);
		this.setActivarid_empresaDepreciacionActivoFijo(esInicial);
		this.setActivarid_sucursalDepreciacionActivoFijo(esInicial);
		this.setActivarid_detalle_activo_fijoDepreciacionActivoFijo(esInicial);
		this.setActivarid_tipo_depreciacion_empresaDepreciacionActivoFijo(esInicial);
		this.setActivarid_estado_depre_actiDepreciacionActivoFijo(esInicial);
		this.setActivarid_anioDepreciacionActivoFijo(esInicial);
		this.setActivarid_mesDepreciacionActivoFijo(esInicial);
		this.setActivarfecha_compraDepreciacionActivoFijo(esInicial);
		this.setActivarfecha_depre_actiDepreciacionActivoFijo(esInicial);
		this.setActivarporcentajeDepreciacionActivoFijo(esInicial);
		this.setActivarcostoDepreciacionActivoFijo(esInicial);
		this.setActivarvalor_acumuladoDepreciacionActivoFijo(esInicial);
		this.setActivarvalor_totalDepreciacionActivoFijo(esInicial);
		this.setActivarvalor_gastoDepreciacionActivoFijo(esInicial);
		this.setActivarfechaDepreciacionActivoFijo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DepreciacionActivoFijoConstantesFunciones.ID)) {
				this.setActivaridDepreciacionActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DepreciacionActivoFijoConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaDepreciacionActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DepreciacionActivoFijoConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalDepreciacionActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DepreciacionActivoFijoConstantesFunciones.IDDETALLEACTIVOFIJO)) {
				this.setActivarid_detalle_activo_fijoDepreciacionActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DepreciacionActivoFijoConstantesFunciones.IDTIPODEPRECIACIONEMPRESA)) {
				this.setActivarid_tipo_depreciacion_empresaDepreciacionActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DepreciacionActivoFijoConstantesFunciones.IDESTADODEPREACTI)) {
				this.setActivarid_estado_depre_actiDepreciacionActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DepreciacionActivoFijoConstantesFunciones.IDANIO)) {
				this.setActivarid_anioDepreciacionActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DepreciacionActivoFijoConstantesFunciones.IDMES)) {
				this.setActivarid_mesDepreciacionActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DepreciacionActivoFijoConstantesFunciones.FECHACOMPRA)) {
				this.setActivarfecha_compraDepreciacionActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DepreciacionActivoFijoConstantesFunciones.FECHADEPREACTI)) {
				this.setActivarfecha_depre_actiDepreciacionActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DepreciacionActivoFijoConstantesFunciones.PORCENTAJE)) {
				this.setActivarporcentajeDepreciacionActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DepreciacionActivoFijoConstantesFunciones.COSTO)) {
				this.setActivarcostoDepreciacionActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DepreciacionActivoFijoConstantesFunciones.VALORACUMULADO)) {
				this.setActivarvalor_acumuladoDepreciacionActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DepreciacionActivoFijoConstantesFunciones.VALORTOTAL)) {
				this.setActivarvalor_totalDepreciacionActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DepreciacionActivoFijoConstantesFunciones.VALORGASTO)) {
				this.setActivarvalor_gastoDepreciacionActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DepreciacionActivoFijoConstantesFunciones.FECHA)) {
				this.setActivarfechaDepreciacionActivoFijo(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,DepreciacionActivoFijoBeanSwingJInternalFrame depreciacionactivofijoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridDepreciacionActivoFijo(esInicial);
		this.setResaltarid_empresaDepreciacionActivoFijo(esInicial);
		this.setResaltarid_sucursalDepreciacionActivoFijo(esInicial);
		this.setResaltarid_detalle_activo_fijoDepreciacionActivoFijo(esInicial);
		this.setResaltarid_tipo_depreciacion_empresaDepreciacionActivoFijo(esInicial);
		this.setResaltarid_estado_depre_actiDepreciacionActivoFijo(esInicial);
		this.setResaltarid_anioDepreciacionActivoFijo(esInicial);
		this.setResaltarid_mesDepreciacionActivoFijo(esInicial);
		this.setResaltarfecha_compraDepreciacionActivoFijo(esInicial);
		this.setResaltarfecha_depre_actiDepreciacionActivoFijo(esInicial);
		this.setResaltarporcentajeDepreciacionActivoFijo(esInicial);
		this.setResaltarcostoDepreciacionActivoFijo(esInicial);
		this.setResaltarvalor_acumuladoDepreciacionActivoFijo(esInicial);
		this.setResaltarvalor_totalDepreciacionActivoFijo(esInicial);
		this.setResaltarvalor_gastoDepreciacionActivoFijo(esInicial);
		this.setResaltarfechaDepreciacionActivoFijo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DepreciacionActivoFijoConstantesFunciones.ID)) {
				this.setResaltaridDepreciacionActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DepreciacionActivoFijoConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaDepreciacionActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DepreciacionActivoFijoConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalDepreciacionActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DepreciacionActivoFijoConstantesFunciones.IDDETALLEACTIVOFIJO)) {
				this.setResaltarid_detalle_activo_fijoDepreciacionActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DepreciacionActivoFijoConstantesFunciones.IDTIPODEPRECIACIONEMPRESA)) {
				this.setResaltarid_tipo_depreciacion_empresaDepreciacionActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DepreciacionActivoFijoConstantesFunciones.IDESTADODEPREACTI)) {
				this.setResaltarid_estado_depre_actiDepreciacionActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DepreciacionActivoFijoConstantesFunciones.IDANIO)) {
				this.setResaltarid_anioDepreciacionActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DepreciacionActivoFijoConstantesFunciones.IDMES)) {
				this.setResaltarid_mesDepreciacionActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DepreciacionActivoFijoConstantesFunciones.FECHACOMPRA)) {
				this.setResaltarfecha_compraDepreciacionActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DepreciacionActivoFijoConstantesFunciones.FECHADEPREACTI)) {
				this.setResaltarfecha_depre_actiDepreciacionActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DepreciacionActivoFijoConstantesFunciones.PORCENTAJE)) {
				this.setResaltarporcentajeDepreciacionActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DepreciacionActivoFijoConstantesFunciones.COSTO)) {
				this.setResaltarcostoDepreciacionActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DepreciacionActivoFijoConstantesFunciones.VALORACUMULADO)) {
				this.setResaltarvalor_acumuladoDepreciacionActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DepreciacionActivoFijoConstantesFunciones.VALORTOTAL)) {
				this.setResaltarvalor_totalDepreciacionActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DepreciacionActivoFijoConstantesFunciones.VALORGASTO)) {
				this.setResaltarvalor_gastoDepreciacionActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DepreciacionActivoFijoConstantesFunciones.FECHA)) {
				this.setResaltarfechaDepreciacionActivoFijo(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,DepreciacionActivoFijoBeanSwingJInternalFrame depreciacionactivofijoBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdAnioDepreciacionActivoFijo=true;

	public Boolean getMostrarFK_IdAnioDepreciacionActivoFijo() {
		return this.mostrarFK_IdAnioDepreciacionActivoFijo;
	}

	public void setMostrarFK_IdAnioDepreciacionActivoFijo(Boolean visibilidadResaltar) {
		this.mostrarFK_IdAnioDepreciacionActivoFijo= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdDepreciacionActivoFijoDepreciacionActivoFijo=true;

	public Boolean getMostrarFK_IdDepreciacionActivoFijoDepreciacionActivoFijo() {
		return this.mostrarFK_IdDepreciacionActivoFijoDepreciacionActivoFijo;
	}

	public void setMostrarFK_IdDepreciacionActivoFijoDepreciacionActivoFijo(Boolean visibilidadResaltar) {
		this.mostrarFK_IdDepreciacionActivoFijoDepreciacionActivoFijo= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdDetalleActivoFijoDepreciacionActivoFijo=true;

	public Boolean getMostrarFK_IdDetalleActivoFijoDepreciacionActivoFijo() {
		return this.mostrarFK_IdDetalleActivoFijoDepreciacionActivoFijo;
	}

	public void setMostrarFK_IdDetalleActivoFijoDepreciacionActivoFijo(Boolean visibilidadResaltar) {
		this.mostrarFK_IdDetalleActivoFijoDepreciacionActivoFijo= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaDepreciacionActivoFijo=true;

	public Boolean getMostrarFK_IdEmpresaDepreciacionActivoFijo() {
		return this.mostrarFK_IdEmpresaDepreciacionActivoFijo;
	}

	public void setMostrarFK_IdEmpresaDepreciacionActivoFijo(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaDepreciacionActivoFijo= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdMesDepreciacionActivoFijo=true;

	public Boolean getMostrarFK_IdMesDepreciacionActivoFijo() {
		return this.mostrarFK_IdMesDepreciacionActivoFijo;
	}

	public void setMostrarFK_IdMesDepreciacionActivoFijo(Boolean visibilidadResaltar) {
		this.mostrarFK_IdMesDepreciacionActivoFijo= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalDepreciacionActivoFijo=true;

	public Boolean getMostrarFK_IdSucursalDepreciacionActivoFijo() {
		return this.mostrarFK_IdSucursalDepreciacionActivoFijo;
	}

	public void setMostrarFK_IdSucursalDepreciacionActivoFijo(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalDepreciacionActivoFijo= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdTipoDepreciacionEmpresaDepreciacionActivoFijo=true;

	public Boolean getMostrarFK_IdTipoDepreciacionEmpresaDepreciacionActivoFijo() {
		return this.mostrarFK_IdTipoDepreciacionEmpresaDepreciacionActivoFijo;
	}

	public void setMostrarFK_IdTipoDepreciacionEmpresaDepreciacionActivoFijo(Boolean visibilidadResaltar) {
		this.mostrarFK_IdTipoDepreciacionEmpresaDepreciacionActivoFijo= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdAnioDepreciacionActivoFijo=true;

	public Boolean getActivarFK_IdAnioDepreciacionActivoFijo() {
		return this.activarFK_IdAnioDepreciacionActivoFijo;
	}

	public void setActivarFK_IdAnioDepreciacionActivoFijo(Boolean habilitarResaltar) {
		this.activarFK_IdAnioDepreciacionActivoFijo= habilitarResaltar;
	}

	public Boolean activarFK_IdDepreciacionActivoFijoDepreciacionActivoFijo=true;

	public Boolean getActivarFK_IdDepreciacionActivoFijoDepreciacionActivoFijo() {
		return this.activarFK_IdDepreciacionActivoFijoDepreciacionActivoFijo;
	}

	public void setActivarFK_IdDepreciacionActivoFijoDepreciacionActivoFijo(Boolean habilitarResaltar) {
		this.activarFK_IdDepreciacionActivoFijoDepreciacionActivoFijo= habilitarResaltar;
	}

	public Boolean activarFK_IdDetalleActivoFijoDepreciacionActivoFijo=true;

	public Boolean getActivarFK_IdDetalleActivoFijoDepreciacionActivoFijo() {
		return this.activarFK_IdDetalleActivoFijoDepreciacionActivoFijo;
	}

	public void setActivarFK_IdDetalleActivoFijoDepreciacionActivoFijo(Boolean habilitarResaltar) {
		this.activarFK_IdDetalleActivoFijoDepreciacionActivoFijo= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaDepreciacionActivoFijo=true;

	public Boolean getActivarFK_IdEmpresaDepreciacionActivoFijo() {
		return this.activarFK_IdEmpresaDepreciacionActivoFijo;
	}

	public void setActivarFK_IdEmpresaDepreciacionActivoFijo(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaDepreciacionActivoFijo= habilitarResaltar;
	}

	public Boolean activarFK_IdMesDepreciacionActivoFijo=true;

	public Boolean getActivarFK_IdMesDepreciacionActivoFijo() {
		return this.activarFK_IdMesDepreciacionActivoFijo;
	}

	public void setActivarFK_IdMesDepreciacionActivoFijo(Boolean habilitarResaltar) {
		this.activarFK_IdMesDepreciacionActivoFijo= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalDepreciacionActivoFijo=true;

	public Boolean getActivarFK_IdSucursalDepreciacionActivoFijo() {
		return this.activarFK_IdSucursalDepreciacionActivoFijo;
	}

	public void setActivarFK_IdSucursalDepreciacionActivoFijo(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalDepreciacionActivoFijo= habilitarResaltar;
	}

	public Boolean activarFK_IdTipoDepreciacionEmpresaDepreciacionActivoFijo=true;

	public Boolean getActivarFK_IdTipoDepreciacionEmpresaDepreciacionActivoFijo() {
		return this.activarFK_IdTipoDepreciacionEmpresaDepreciacionActivoFijo;
	}

	public void setActivarFK_IdTipoDepreciacionEmpresaDepreciacionActivoFijo(Boolean habilitarResaltar) {
		this.activarFK_IdTipoDepreciacionEmpresaDepreciacionActivoFijo= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdAnioDepreciacionActivoFijo=null;

	public Border getResaltarFK_IdAnioDepreciacionActivoFijo() {
		return this.resaltarFK_IdAnioDepreciacionActivoFijo;
	}

	public void setResaltarFK_IdAnioDepreciacionActivoFijo(Border borderResaltar) {
		this.resaltarFK_IdAnioDepreciacionActivoFijo= borderResaltar;
	}

	public void setResaltarFK_IdAnioDepreciacionActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*DepreciacionActivoFijoBeanSwingJInternalFrame depreciacionactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdAnioDepreciacionActivoFijo= borderResaltar;
	}

	public Border resaltarFK_IdDepreciacionActivoFijoDepreciacionActivoFijo=null;

	public Border getResaltarFK_IdDepreciacionActivoFijoDepreciacionActivoFijo() {
		return this.resaltarFK_IdDepreciacionActivoFijoDepreciacionActivoFijo;
	}

	public void setResaltarFK_IdDepreciacionActivoFijoDepreciacionActivoFijo(Border borderResaltar) {
		this.resaltarFK_IdDepreciacionActivoFijoDepreciacionActivoFijo= borderResaltar;
	}

	public void setResaltarFK_IdDepreciacionActivoFijoDepreciacionActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*DepreciacionActivoFijoBeanSwingJInternalFrame depreciacionactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdDepreciacionActivoFijoDepreciacionActivoFijo= borderResaltar;
	}

	public Border resaltarFK_IdDetalleActivoFijoDepreciacionActivoFijo=null;

	public Border getResaltarFK_IdDetalleActivoFijoDepreciacionActivoFijo() {
		return this.resaltarFK_IdDetalleActivoFijoDepreciacionActivoFijo;
	}

	public void setResaltarFK_IdDetalleActivoFijoDepreciacionActivoFijo(Border borderResaltar) {
		this.resaltarFK_IdDetalleActivoFijoDepreciacionActivoFijo= borderResaltar;
	}

	public void setResaltarFK_IdDetalleActivoFijoDepreciacionActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*DepreciacionActivoFijoBeanSwingJInternalFrame depreciacionactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdDetalleActivoFijoDepreciacionActivoFijo= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaDepreciacionActivoFijo=null;

	public Border getResaltarFK_IdEmpresaDepreciacionActivoFijo() {
		return this.resaltarFK_IdEmpresaDepreciacionActivoFijo;
	}

	public void setResaltarFK_IdEmpresaDepreciacionActivoFijo(Border borderResaltar) {
		this.resaltarFK_IdEmpresaDepreciacionActivoFijo= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaDepreciacionActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*DepreciacionActivoFijoBeanSwingJInternalFrame depreciacionactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaDepreciacionActivoFijo= borderResaltar;
	}

	public Border resaltarFK_IdMesDepreciacionActivoFijo=null;

	public Border getResaltarFK_IdMesDepreciacionActivoFijo() {
		return this.resaltarFK_IdMesDepreciacionActivoFijo;
	}

	public void setResaltarFK_IdMesDepreciacionActivoFijo(Border borderResaltar) {
		this.resaltarFK_IdMesDepreciacionActivoFijo= borderResaltar;
	}

	public void setResaltarFK_IdMesDepreciacionActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*DepreciacionActivoFijoBeanSwingJInternalFrame depreciacionactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdMesDepreciacionActivoFijo= borderResaltar;
	}

	public Border resaltarFK_IdSucursalDepreciacionActivoFijo=null;

	public Border getResaltarFK_IdSucursalDepreciacionActivoFijo() {
		return this.resaltarFK_IdSucursalDepreciacionActivoFijo;
	}

	public void setResaltarFK_IdSucursalDepreciacionActivoFijo(Border borderResaltar) {
		this.resaltarFK_IdSucursalDepreciacionActivoFijo= borderResaltar;
	}

	public void setResaltarFK_IdSucursalDepreciacionActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*DepreciacionActivoFijoBeanSwingJInternalFrame depreciacionactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalDepreciacionActivoFijo= borderResaltar;
	}

	public Border resaltarFK_IdTipoDepreciacionEmpresaDepreciacionActivoFijo=null;

	public Border getResaltarFK_IdTipoDepreciacionEmpresaDepreciacionActivoFijo() {
		return this.resaltarFK_IdTipoDepreciacionEmpresaDepreciacionActivoFijo;
	}

	public void setResaltarFK_IdTipoDepreciacionEmpresaDepreciacionActivoFijo(Border borderResaltar) {
		this.resaltarFK_IdTipoDepreciacionEmpresaDepreciacionActivoFijo= borderResaltar;
	}

	public void setResaltarFK_IdTipoDepreciacionEmpresaDepreciacionActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*DepreciacionActivoFijoBeanSwingJInternalFrame depreciacionactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdTipoDepreciacionEmpresaDepreciacionActivoFijo= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}