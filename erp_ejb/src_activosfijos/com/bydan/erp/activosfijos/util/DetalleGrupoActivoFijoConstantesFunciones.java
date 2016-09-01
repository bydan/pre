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


import com.bydan.erp.activosfijos.util.DetalleGrupoActivoFijoConstantesFunciones;
import com.bydan.erp.activosfijos.util.DetalleGrupoActivoFijoParameterReturnGeneral;
//import com.bydan.erp.activosfijos.util.DetalleGrupoActivoFijoParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.activosfijos.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;
import com.bydan.erp.cartera.business.entity.*;
import com.bydan.erp.facturacion.business.entity.*;
import com.bydan.erp.activosfijos.business.entity.*;
import com.bydan.erp.tesoreria.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;
import com.bydan.erp.cartera.util.*;
import com.bydan.erp.facturacion.util.*;
import com.bydan.erp.activosfijos.util.*;
import com.bydan.erp.tesoreria.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.activosfijos.business.dataaccess.*;
//import com.bydan.erp.activosfijos.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class DetalleGrupoActivoFijoConstantesFunciones extends DetalleGrupoActivoFijoConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="DetalleGrupoActivoFijo";
	public static final String SPATHOPCION="ActivosFijos";	
	public static final String SPATHMODULO="activosfijos/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="DetalleGrupoActivoFijo"+DetalleGrupoActivoFijoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="DetalleGrupoActivoFijoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="DetalleGrupoActivoFijoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=DetalleGrupoActivoFijoConstantesFunciones.SCHEMA+"_"+DetalleGrupoActivoFijoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/DetalleGrupoActivoFijoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=DetalleGrupoActivoFijoConstantesFunciones.SCHEMA+"_"+DetalleGrupoActivoFijoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=DetalleGrupoActivoFijoConstantesFunciones.SCHEMA+"_"+DetalleGrupoActivoFijoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/DetalleGrupoActivoFijoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=DetalleGrupoActivoFijoConstantesFunciones.SCHEMA+"_"+DetalleGrupoActivoFijoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleGrupoActivoFijoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DetalleGrupoActivoFijoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleGrupoActivoFijoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleGrupoActivoFijoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DetalleGrupoActivoFijoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleGrupoActivoFijoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=DetalleGrupoActivoFijoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+DetalleGrupoActivoFijoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=DetalleGrupoActivoFijoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+DetalleGrupoActivoFijoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Detalle Grupo Activo Fijos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Detalle Grupo Activo Fijo";
	public static final String SCLASSWEBTITULO_LOWER="Detalle Grupo Activo Fijo";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="DetalleGrupoActivoFijo";
	public static final String OBJECTNAME="detallegrupoactivofijo";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_ACTIVOSFIJOS;	
	public static final String TABLENAME="detalle_grupo_activo_fijo";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select detallegrupoactivofijo from "+DetalleGrupoActivoFijoConstantesFunciones.SPERSISTENCENAME+" detallegrupoactivofijo";
	public static String QUERYSELECTNATIVE="select "+DetalleGrupoActivoFijoConstantesFunciones.SCHEMA+"."+DetalleGrupoActivoFijoConstantesFunciones.TABLENAME+".id,"+DetalleGrupoActivoFijoConstantesFunciones.SCHEMA+"."+DetalleGrupoActivoFijoConstantesFunciones.TABLENAME+".version_row,"+DetalleGrupoActivoFijoConstantesFunciones.SCHEMA+"."+DetalleGrupoActivoFijoConstantesFunciones.TABLENAME+".id_empresa,"+DetalleGrupoActivoFijoConstantesFunciones.SCHEMA+"."+DetalleGrupoActivoFijoConstantesFunciones.TABLENAME+".codigo,"+DetalleGrupoActivoFijoConstantesFunciones.SCHEMA+"."+DetalleGrupoActivoFijoConstantesFunciones.TABLENAME+".nombre,"+DetalleGrupoActivoFijoConstantesFunciones.SCHEMA+"."+DetalleGrupoActivoFijoConstantesFunciones.TABLENAME+".siglas,"+DetalleGrupoActivoFijoConstantesFunciones.SCHEMA+"."+DetalleGrupoActivoFijoConstantesFunciones.TABLENAME+".id_cuenta_contable_costo_original,"+DetalleGrupoActivoFijoConstantesFunciones.SCHEMA+"."+DetalleGrupoActivoFijoConstantesFunciones.TABLENAME+".id_cuenta_contable_depre_normal,"+DetalleGrupoActivoFijoConstantesFunciones.SCHEMA+"."+DetalleGrupoActivoFijoConstantesFunciones.TABLENAME+".id_cuenta_contable_depre_gasto_normal from "+DetalleGrupoActivoFijoConstantesFunciones.SCHEMA+"."+DetalleGrupoActivoFijoConstantesFunciones.TABLENAME;//+" as "+DetalleGrupoActivoFijoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected DetalleGrupoActivoFijoConstantesFuncionesAdditional detallegrupoactivofijoConstantesFuncionesAdditional=null;
	
	public DetalleGrupoActivoFijoConstantesFuncionesAdditional getDetalleGrupoActivoFijoConstantesFuncionesAdditional() {
		return this.detallegrupoactivofijoConstantesFuncionesAdditional;
	}
	
	public void setDetalleGrupoActivoFijoConstantesFuncionesAdditional(DetalleGrupoActivoFijoConstantesFuncionesAdditional detallegrupoactivofijoConstantesFuncionesAdditional) {
		try {
			this.detallegrupoactivofijoConstantesFuncionesAdditional=detallegrupoactivofijoConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String CODIGO= "codigo";
    public static final String NOMBRE= "nombre";
    public static final String SIGLAS= "siglas";
    public static final String IDCUENTACONTABLECOSTOORIGINAL= "id_cuenta_contable_costo_original";
    public static final String IDCUENTACONTABLEDEPRENORMAL= "id_cuenta_contable_depre_normal";
    public static final String IDCUENTACONTABLEDEPREGASTONORMAL= "id_cuenta_contable_depre_gasto_normal";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_CODIGO= "Codigo";
		public static final String LABEL_CODIGO_LOWER= "Codigo";
    	public static final String LABEL_NOMBRE= "Nombre";
		public static final String LABEL_NOMBRE_LOWER= "Nombre";
    	public static final String LABEL_SIGLAS= "Siglas";
		public static final String LABEL_SIGLAS_LOWER= "Siglas";
    	public static final String LABEL_IDCUENTACONTABLECOSTOORIGINAL= "Cuenta Contable Costo Original";
		public static final String LABEL_IDCUENTACONTABLECOSTOORIGINAL_LOWER= "Cuenta Contable Costo Original";
    	public static final String LABEL_IDCUENTACONTABLEDEPRENORMAL= "Cuenta Contable Depre Normal";
		public static final String LABEL_IDCUENTACONTABLEDEPRENORMAL_LOWER= "Cuenta Contable Depre Normal";
    	public static final String LABEL_IDCUENTACONTABLEDEPREGASTONORMAL= "Cuenta Contable Depre Gasto Normal";
		public static final String LABEL_IDCUENTACONTABLEDEPREGASTONORMAL_LOWER= "Cuenta Contable Depre Gasto Normal";
	
		
		
		
	public static final String SREGEXCODIGO=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXCODIGO=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXNOMBRE=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXNOMBRE=ConstantesValidacion.SVALIDACIONCADENA;	
	public static final String SREGEXSIGLAS=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXSIGLAS=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
		
	
	public static String getDetalleGrupoActivoFijoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(DetalleGrupoActivoFijoConstantesFunciones.IDEMPRESA)) {sLabelColumna=DetalleGrupoActivoFijoConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(DetalleGrupoActivoFijoConstantesFunciones.CODIGO)) {sLabelColumna=DetalleGrupoActivoFijoConstantesFunciones.LABEL_CODIGO;}
		if(sNombreColumna.equals(DetalleGrupoActivoFijoConstantesFunciones.NOMBRE)) {sLabelColumna=DetalleGrupoActivoFijoConstantesFunciones.LABEL_NOMBRE;}
		if(sNombreColumna.equals(DetalleGrupoActivoFijoConstantesFunciones.SIGLAS)) {sLabelColumna=DetalleGrupoActivoFijoConstantesFunciones.LABEL_SIGLAS;}
		if(sNombreColumna.equals(DetalleGrupoActivoFijoConstantesFunciones.IDCUENTACONTABLECOSTOORIGINAL)) {sLabelColumna=DetalleGrupoActivoFijoConstantesFunciones.LABEL_IDCUENTACONTABLECOSTOORIGINAL;}
		if(sNombreColumna.equals(DetalleGrupoActivoFijoConstantesFunciones.IDCUENTACONTABLEDEPRENORMAL)) {sLabelColumna=DetalleGrupoActivoFijoConstantesFunciones.LABEL_IDCUENTACONTABLEDEPRENORMAL;}
		if(sNombreColumna.equals(DetalleGrupoActivoFijoConstantesFunciones.IDCUENTACONTABLEDEPREGASTONORMAL)) {sLabelColumna=DetalleGrupoActivoFijoConstantesFunciones.LABEL_IDCUENTACONTABLEDEPREGASTONORMAL;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
	
	public static String getDetalleGrupoActivoFijoDescripcion(DetalleGrupoActivoFijo detallegrupoactivofijo) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(detallegrupoactivofijo !=null/* && detallegrupoactivofijo.getId()!=0*/) {
			sDescripcion=detallegrupoactivofijo.getcodigo();//detallegrupoactivofijodetallegrupoactivofijo.getcodigo().trim();
		}
			
		return sDescripcion;
	}
	
	public static String getDetalleGrupoActivoFijoDescripcionDetallado(DetalleGrupoActivoFijo detallegrupoactivofijo) {
		String sDescripcion="";
			
		sDescripcion+=DetalleGrupoActivoFijoConstantesFunciones.ID+"=";
		sDescripcion+=detallegrupoactivofijo.getId().toString()+",";
		sDescripcion+=DetalleGrupoActivoFijoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=detallegrupoactivofijo.getVersionRow().toString()+",";
		sDescripcion+=DetalleGrupoActivoFijoConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=detallegrupoactivofijo.getid_empresa().toString()+",";
		sDescripcion+=DetalleGrupoActivoFijoConstantesFunciones.CODIGO+"=";
		sDescripcion+=detallegrupoactivofijo.getcodigo()+",";
		sDescripcion+=DetalleGrupoActivoFijoConstantesFunciones.NOMBRE+"=";
		sDescripcion+=detallegrupoactivofijo.getnombre()+",";
		sDescripcion+=DetalleGrupoActivoFijoConstantesFunciones.SIGLAS+"=";
		sDescripcion+=detallegrupoactivofijo.getsiglas()+",";
		sDescripcion+=DetalleGrupoActivoFijoConstantesFunciones.IDCUENTACONTABLECOSTOORIGINAL+"=";
		sDescripcion+=detallegrupoactivofijo.getid_cuenta_contable_costo_original().toString()+",";
		sDescripcion+=DetalleGrupoActivoFijoConstantesFunciones.IDCUENTACONTABLEDEPRENORMAL+"=";
		sDescripcion+=detallegrupoactivofijo.getid_cuenta_contable_depre_normal().toString()+",";
		sDescripcion+=DetalleGrupoActivoFijoConstantesFunciones.IDCUENTACONTABLEDEPREGASTONORMAL+"=";
		sDescripcion+=detallegrupoactivofijo.getid_cuenta_contable_depre_gasto_normal().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setDetalleGrupoActivoFijoDescripcion(DetalleGrupoActivoFijo detallegrupoactivofijo,String sValor) throws Exception {			
		if(detallegrupoactivofijo !=null) {
			detallegrupoactivofijo.setcodigo(sValor);;//detallegrupoactivofijodetallegrupoactivofijo.getcodigo().trim();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
		}

		return sDescripcion;
	}

	public static String getCuentaContableCostoOriginalDescripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}

	public static String getCuentaContableDepreNormalDescripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}

	public static String getCuentaContableDepreGastoNormalDescripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}
	
	
	
	
	public static String getNombreIndice(String sNombreIndice) {
		if(sNombreIndice.equals("Todos")) {
			sNombreIndice="Tipo=Todos";
		} else if(sNombreIndice.equals("PorId")) {
			sNombreIndice="Tipo=Por Id";
		} else if(sNombreIndice.equals("FK_IdCuentaContableCostoOriginal")) {
			sNombreIndice="Tipo=  Por Cuenta Contable Costo Original";
		} else if(sNombreIndice.equals("FK_IdCuentaContableDepreGastoNormal")) {
			sNombreIndice="Tipo=  Por Cuenta Contable Depre Gasto Normal";
		} else if(sNombreIndice.equals("FK_IdCuentaContableDepreNormal")) {
			sNombreIndice="Tipo=  Por Cuenta Contable Depre Normal";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdCuentaContableCostoOriginal(Long id_cuenta_contable_costo_original) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable_costo_original!=null) {sDetalleIndice+=" Codigo Unico De Cuenta Contable Costo Original="+id_cuenta_contable_costo_original.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContableDepreGastoNormal(Long id_cuenta_contable_depre_gasto_normal) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable_depre_gasto_normal!=null) {sDetalleIndice+=" Codigo Unico De Cuenta Contable Depre Gasto Normal="+id_cuenta_contable_depre_gasto_normal.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContableDepreNormal(Long id_cuenta_contable_depre_normal) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable_depre_normal!=null) {sDetalleIndice+=" Codigo Unico De Cuenta Contable Depre Normal="+id_cuenta_contable_depre_normal.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosDetalleGrupoActivoFijo(DetalleGrupoActivoFijo detallegrupoactivofijo,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		detallegrupoactivofijo.setcodigo(detallegrupoactivofijo.getcodigo().trim());
		detallegrupoactivofijo.setnombre(detallegrupoactivofijo.getnombre().trim());
		detallegrupoactivofijo.setsiglas(detallegrupoactivofijo.getsiglas().trim());
	}
	
	public static void quitarEspaciosDetalleGrupoActivoFijos(List<DetalleGrupoActivoFijo> detallegrupoactivofijos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(DetalleGrupoActivoFijo detallegrupoactivofijo: detallegrupoactivofijos) {
			detallegrupoactivofijo.setcodigo(detallegrupoactivofijo.getcodigo().trim());
			detallegrupoactivofijo.setnombre(detallegrupoactivofijo.getnombre().trim());
			detallegrupoactivofijo.setsiglas(detallegrupoactivofijo.getsiglas().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDetalleGrupoActivoFijo(DetalleGrupoActivoFijo detallegrupoactivofijo,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && detallegrupoactivofijo.getConCambioAuxiliar()) {
			detallegrupoactivofijo.setIsDeleted(detallegrupoactivofijo.getIsDeletedAuxiliar());	
			detallegrupoactivofijo.setIsNew(detallegrupoactivofijo.getIsNewAuxiliar());	
			detallegrupoactivofijo.setIsChanged(detallegrupoactivofijo.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			detallegrupoactivofijo.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			detallegrupoactivofijo.setIsDeletedAuxiliar(false);	
			detallegrupoactivofijo.setIsNewAuxiliar(false);	
			detallegrupoactivofijo.setIsChangedAuxiliar(false);
			
			detallegrupoactivofijo.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDetalleGrupoActivoFijos(List<DetalleGrupoActivoFijo> detallegrupoactivofijos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(DetalleGrupoActivoFijo detallegrupoactivofijo : detallegrupoactivofijos) {
			if(conAsignarBase && detallegrupoactivofijo.getConCambioAuxiliar()) {
				detallegrupoactivofijo.setIsDeleted(detallegrupoactivofijo.getIsDeletedAuxiliar());	
				detallegrupoactivofijo.setIsNew(detallegrupoactivofijo.getIsNewAuxiliar());	
				detallegrupoactivofijo.setIsChanged(detallegrupoactivofijo.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				detallegrupoactivofijo.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				detallegrupoactivofijo.setIsDeletedAuxiliar(false);	
				detallegrupoactivofijo.setIsNewAuxiliar(false);	
				detallegrupoactivofijo.setIsChangedAuxiliar(false);
				
				detallegrupoactivofijo.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresDetalleGrupoActivoFijo(DetalleGrupoActivoFijo detallegrupoactivofijo,Boolean conEnteros) throws Exception  {
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresDetalleGrupoActivoFijos(List<DetalleGrupoActivoFijo> detallegrupoactivofijos,Boolean conEnteros) throws Exception  {
		
		for(DetalleGrupoActivoFijo detallegrupoactivofijo: detallegrupoactivofijos) {
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaDetalleGrupoActivoFijo(List<DetalleGrupoActivoFijo> detallegrupoactivofijos,DetalleGrupoActivoFijo detallegrupoactivofijoAux) throws Exception  {
		DetalleGrupoActivoFijoConstantesFunciones.InicializarValoresDetalleGrupoActivoFijo(detallegrupoactivofijoAux,true);
		
		for(DetalleGrupoActivoFijo detallegrupoactivofijo: detallegrupoactivofijos) {
			if(detallegrupoactivofijo.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesDetalleGrupoActivoFijo(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=DetalleGrupoActivoFijoConstantesFunciones.getArrayColumnasGlobalesDetalleGrupoActivoFijo(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesDetalleGrupoActivoFijo(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetalleGrupoActivoFijoConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetalleGrupoActivoFijoConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoDetalleGrupoActivoFijo(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<DetalleGrupoActivoFijo> detallegrupoactivofijos,DetalleGrupoActivoFijo detallegrupoactivofijo,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(DetalleGrupoActivoFijo detallegrupoactivofijoAux: detallegrupoactivofijos) {
			if(detallegrupoactivofijoAux!=null && detallegrupoactivofijo!=null) {
				if((detallegrupoactivofijoAux.getId()==null && detallegrupoactivofijo.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(detallegrupoactivofijoAux.getId()!=null && detallegrupoactivofijo.getId()!=null){
					if(detallegrupoactivofijoAux.getId().equals(detallegrupoactivofijo.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaDetalleGrupoActivoFijo(List<DetalleGrupoActivoFijo> detallegrupoactivofijos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
	
		for(DetalleGrupoActivoFijo detallegrupoactivofijo: detallegrupoactivofijos) {			
			if(detallegrupoactivofijo.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
		}
		
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaDetalleGrupoActivoFijo() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,DetalleGrupoActivoFijoConstantesFunciones.LABEL_ID, DetalleGrupoActivoFijoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleGrupoActivoFijoConstantesFunciones.LABEL_VERSIONROW, DetalleGrupoActivoFijoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleGrupoActivoFijoConstantesFunciones.LABEL_IDEMPRESA, DetalleGrupoActivoFijoConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleGrupoActivoFijoConstantesFunciones.LABEL_CODIGO, DetalleGrupoActivoFijoConstantesFunciones.CODIGO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleGrupoActivoFijoConstantesFunciones.LABEL_NOMBRE, DetalleGrupoActivoFijoConstantesFunciones.NOMBRE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleGrupoActivoFijoConstantesFunciones.LABEL_SIGLAS, DetalleGrupoActivoFijoConstantesFunciones.SIGLAS,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleGrupoActivoFijoConstantesFunciones.LABEL_IDCUENTACONTABLECOSTOORIGINAL, DetalleGrupoActivoFijoConstantesFunciones.IDCUENTACONTABLECOSTOORIGINAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleGrupoActivoFijoConstantesFunciones.LABEL_IDCUENTACONTABLEDEPRENORMAL, DetalleGrupoActivoFijoConstantesFunciones.IDCUENTACONTABLEDEPRENORMAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleGrupoActivoFijoConstantesFunciones.LABEL_IDCUENTACONTABLEDEPREGASTONORMAL, DetalleGrupoActivoFijoConstantesFunciones.IDCUENTACONTABLEDEPREGASTONORMAL,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasDetalleGrupoActivoFijo() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=DetalleGrupoActivoFijoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleGrupoActivoFijoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleGrupoActivoFijoConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleGrupoActivoFijoConstantesFunciones.CODIGO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleGrupoActivoFijoConstantesFunciones.NOMBRE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleGrupoActivoFijoConstantesFunciones.SIGLAS;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleGrupoActivoFijoConstantesFunciones.IDCUENTACONTABLECOSTOORIGINAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleGrupoActivoFijoConstantesFunciones.IDCUENTACONTABLEDEPRENORMAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleGrupoActivoFijoConstantesFunciones.IDCUENTACONTABLEDEPREGASTONORMAL;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetalleGrupoActivoFijo() throws Exception  {
		return DetalleGrupoActivoFijoConstantesFunciones.getTiposSeleccionarDetalleGrupoActivoFijo(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetalleGrupoActivoFijo(Boolean conFk) throws Exception  {
		return DetalleGrupoActivoFijoConstantesFunciones.getTiposSeleccionarDetalleGrupoActivoFijo(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetalleGrupoActivoFijo(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleGrupoActivoFijoConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(DetalleGrupoActivoFijoConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleGrupoActivoFijoConstantesFunciones.LABEL_CODIGO);
			reporte.setsDescripcion(DetalleGrupoActivoFijoConstantesFunciones.LABEL_CODIGO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleGrupoActivoFijoConstantesFunciones.LABEL_NOMBRE);
			reporte.setsDescripcion(DetalleGrupoActivoFijoConstantesFunciones.LABEL_NOMBRE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleGrupoActivoFijoConstantesFunciones.LABEL_SIGLAS);
			reporte.setsDescripcion(DetalleGrupoActivoFijoConstantesFunciones.LABEL_SIGLAS);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleGrupoActivoFijoConstantesFunciones.LABEL_IDCUENTACONTABLECOSTOORIGINAL);
			reporte.setsDescripcion(DetalleGrupoActivoFijoConstantesFunciones.LABEL_IDCUENTACONTABLECOSTOORIGINAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleGrupoActivoFijoConstantesFunciones.LABEL_IDCUENTACONTABLEDEPRENORMAL);
			reporte.setsDescripcion(DetalleGrupoActivoFijoConstantesFunciones.LABEL_IDCUENTACONTABLEDEPRENORMAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleGrupoActivoFijoConstantesFunciones.LABEL_IDCUENTACONTABLEDEPREGASTONORMAL);
			reporte.setsDescripcion(DetalleGrupoActivoFijoConstantesFunciones.LABEL_IDCUENTACONTABLEDEPREGASTONORMAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesDetalleGrupoActivoFijo(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesDetalleGrupoActivoFijo(DetalleGrupoActivoFijo detallegrupoactivofijoAux) throws Exception {
		
			detallegrupoactivofijoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(detallegrupoactivofijoAux.getEmpresa()));
			detallegrupoactivofijoAux.setcuentacontablecostooriginal_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(detallegrupoactivofijoAux.getCuentaContableCostoOriginal()));
			detallegrupoactivofijoAux.setcuentacontabledeprenormal_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(detallegrupoactivofijoAux.getCuentaContableDepreNormal()));
			detallegrupoactivofijoAux.setcuentacontabledepregastonormal_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(detallegrupoactivofijoAux.getCuentaContableDepreGastoNormal()));		
	}
	
	public static void refrescarForeignKeysDescripcionesDetalleGrupoActivoFijo(List<DetalleGrupoActivoFijo> detallegrupoactivofijosTemp) throws Exception {
		for(DetalleGrupoActivoFijo detallegrupoactivofijoAux:detallegrupoactivofijosTemp) {
			
			detallegrupoactivofijoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(detallegrupoactivofijoAux.getEmpresa()));
			detallegrupoactivofijoAux.setcuentacontablecostooriginal_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(detallegrupoactivofijoAux.getCuentaContableCostoOriginal()));
			detallegrupoactivofijoAux.setcuentacontabledeprenormal_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(detallegrupoactivofijoAux.getCuentaContableDepreNormal()));
			detallegrupoactivofijoAux.setcuentacontabledepregastonormal_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(detallegrupoactivofijoAux.getCuentaContableDepreGastoNormal()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfDetalleGrupoActivoFijo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(CuentaContable.class));
				classes.add(new Classe(CuentaContable.class));
				classes.add(new Classe(CuentaContable.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CuentaContable.class)) {
						classes.add(new Classe(CuentaContable.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CuentaContable.class)) {
						classes.add(new Classe(CuentaContable.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CuentaContable.class)) {
						classes.add(new Classe(CuentaContable.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfDetalleGrupoActivoFijo(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
					}

					if(CuentaContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContable.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetalleGrupoActivoFijo(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return DetalleGrupoActivoFijoConstantesFunciones.getClassesRelationshipsOfDetalleGrupoActivoFijo(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetalleGrupoActivoFijo(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(DetalleActivoFijo.class));
				classes.add(new Classe(CuentaContaDetaGrupoActi.class));
				classes.add(new Classe(SubGrupoActivoFijo.class));
				classes.add(new Classe(GastoDepreciacion.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(DetalleActivoFijo.class)) {
						classes.add(new Classe(DetalleActivoFijo.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(CuentaContaDetaGrupoActi.class)) {
						classes.add(new Classe(CuentaContaDetaGrupoActi.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(SubGrupoActivoFijo.class)) {
						classes.add(new Classe(SubGrupoActivoFijo.class)); break;
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(GastoDepreciacion.class)) {
						classes.add(new Classe(GastoDepreciacion.class)); break;
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDetalleGrupoActivoFijo(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return DetalleGrupoActivoFijoConstantesFunciones.getClassesRelationshipsFromStringsOfDetalleGrupoActivoFijo(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDetalleGrupoActivoFijo(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();			
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(DetalleActivoFijo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleActivoFijo.class)); continue;
					}

					if(CuentaContaDetaGrupoActi.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContaDetaGrupoActi.class)); continue;
					}

					if(SubGrupoActivoFijo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(SubGrupoActivoFijo.class)); continue;
					}

					if(GastoDepreciacion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(GastoDepreciacion.class)); continue;
					}
				}
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				

				for(String sClasse:arrClasses) {

					if(DetalleActivoFijo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleActivoFijo.class)); continue;
					}

					if(CuentaContaDetaGrupoActi.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CuentaContaDetaGrupoActi.class)); continue;
					}

					if(SubGrupoActivoFijo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(SubGrupoActivoFijo.class)); continue;
					}

					if(GastoDepreciacion.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(GastoDepreciacion.class)); continue;
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
	public static void actualizarLista(DetalleGrupoActivoFijo detallegrupoactivofijo,List<DetalleGrupoActivoFijo> detallegrupoactivofijos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			DetalleGrupoActivoFijo detallegrupoactivofijoEncontrado=null;
			
			for(DetalleGrupoActivoFijo detallegrupoactivofijoLocal:detallegrupoactivofijos) {
				if(detallegrupoactivofijoLocal.getId().equals(detallegrupoactivofijo.getId())) {
					detallegrupoactivofijoEncontrado=detallegrupoactivofijoLocal;
					
					detallegrupoactivofijoLocal.setIsChanged(detallegrupoactivofijo.getIsChanged());
					detallegrupoactivofijoLocal.setIsNew(detallegrupoactivofijo.getIsNew());
					detallegrupoactivofijoLocal.setIsDeleted(detallegrupoactivofijo.getIsDeleted());
					
					detallegrupoactivofijoLocal.setGeneralEntityOriginal(detallegrupoactivofijo.getGeneralEntityOriginal());
					
					detallegrupoactivofijoLocal.setId(detallegrupoactivofijo.getId());	
					detallegrupoactivofijoLocal.setVersionRow(detallegrupoactivofijo.getVersionRow());	
					detallegrupoactivofijoLocal.setid_empresa(detallegrupoactivofijo.getid_empresa());	
					detallegrupoactivofijoLocal.setcodigo(detallegrupoactivofijo.getcodigo());	
					detallegrupoactivofijoLocal.setnombre(detallegrupoactivofijo.getnombre());	
					detallegrupoactivofijoLocal.setsiglas(detallegrupoactivofijo.getsiglas());	
					detallegrupoactivofijoLocal.setid_cuenta_contable_costo_original(detallegrupoactivofijo.getid_cuenta_contable_costo_original());	
					detallegrupoactivofijoLocal.setid_cuenta_contable_depre_normal(detallegrupoactivofijo.getid_cuenta_contable_depre_normal());	
					detallegrupoactivofijoLocal.setid_cuenta_contable_depre_gasto_normal(detallegrupoactivofijo.getid_cuenta_contable_depre_gasto_normal());	
					
					
					detallegrupoactivofijoLocal.setDetalleActivoFijos(detallegrupoactivofijo.getDetalleActivoFijos());
					detallegrupoactivofijoLocal.setCuentaContaDetaGrupoActis(detallegrupoactivofijo.getCuentaContaDetaGrupoActis());
					detallegrupoactivofijoLocal.setSubGrupoActivoFijos(detallegrupoactivofijo.getSubGrupoActivoFijos());
					detallegrupoactivofijoLocal.setGastoDepreciacions(detallegrupoactivofijo.getGastoDepreciacions());
					
					existe=true;
					break;
				}
			}
			
			if(!detallegrupoactivofijo.getIsDeleted()) {
				if(!existe) {
					detallegrupoactivofijos.add(detallegrupoactivofijo);
				}
			} else {
				if(detallegrupoactivofijoEncontrado!=null && permiteQuitar)  {
					detallegrupoactivofijos.remove(detallegrupoactivofijoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(DetalleGrupoActivoFijo detallegrupoactivofijo,List<DetalleGrupoActivoFijo> detallegrupoactivofijos) throws Exception {
		try	{			
			for(DetalleGrupoActivoFijo detallegrupoactivofijoLocal:detallegrupoactivofijos) {
				if(detallegrupoactivofijoLocal.getId().equals(detallegrupoactivofijo.getId())) {
					detallegrupoactivofijoLocal.setIsSelected(detallegrupoactivofijo.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesDetalleGrupoActivoFijo(List<DetalleGrupoActivoFijo> detallegrupoactivofijosAux) throws Exception {
		//this.detallegrupoactivofijosAux=detallegrupoactivofijosAux;
		
		for(DetalleGrupoActivoFijo detallegrupoactivofijoAux:detallegrupoactivofijosAux) {
			if(detallegrupoactivofijoAux.getIsChanged()) {
				detallegrupoactivofijoAux.setIsChanged(false);
			}		
			
			if(detallegrupoactivofijoAux.getIsNew()) {
				detallegrupoactivofijoAux.setIsNew(false);
			}	
			
			if(detallegrupoactivofijoAux.getIsDeleted()) {
				detallegrupoactivofijoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesDetalleGrupoActivoFijo(DetalleGrupoActivoFijo detallegrupoactivofijoAux) throws Exception {
		//this.detallegrupoactivofijoAux=detallegrupoactivofijoAux;
		
			if(detallegrupoactivofijoAux.getIsChanged()) {
				detallegrupoactivofijoAux.setIsChanged(false);
			}		
			
			if(detallegrupoactivofijoAux.getIsNew()) {
				detallegrupoactivofijoAux.setIsNew(false);
			}	
			
			if(detallegrupoactivofijoAux.getIsDeleted()) {
				detallegrupoactivofijoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(DetalleGrupoActivoFijo detallegrupoactivofijoAsignar,DetalleGrupoActivoFijo detallegrupoactivofijo) throws Exception {
		detallegrupoactivofijoAsignar.setId(detallegrupoactivofijo.getId());	
		detallegrupoactivofijoAsignar.setVersionRow(detallegrupoactivofijo.getVersionRow());	
		detallegrupoactivofijoAsignar.setid_empresa(detallegrupoactivofijo.getid_empresa());
		detallegrupoactivofijoAsignar.setempresa_descripcion(detallegrupoactivofijo.getempresa_descripcion());	
		detallegrupoactivofijoAsignar.setcodigo(detallegrupoactivofijo.getcodigo());	
		detallegrupoactivofijoAsignar.setnombre(detallegrupoactivofijo.getnombre());	
		detallegrupoactivofijoAsignar.setsiglas(detallegrupoactivofijo.getsiglas());	
		detallegrupoactivofijoAsignar.setid_cuenta_contable_costo_original(detallegrupoactivofijo.getid_cuenta_contable_costo_original());
		detallegrupoactivofijoAsignar.setcuentacontablecostooriginal_descripcion(detallegrupoactivofijo.getcuentacontablecostooriginal_descripcion());	
		detallegrupoactivofijoAsignar.setid_cuenta_contable_depre_normal(detallegrupoactivofijo.getid_cuenta_contable_depre_normal());
		detallegrupoactivofijoAsignar.setcuentacontabledeprenormal_descripcion(detallegrupoactivofijo.getcuentacontabledeprenormal_descripcion());	
		detallegrupoactivofijoAsignar.setid_cuenta_contable_depre_gasto_normal(detallegrupoactivofijo.getid_cuenta_contable_depre_gasto_normal());
		detallegrupoactivofijoAsignar.setcuentacontabledepregastonormal_descripcion(detallegrupoactivofijo.getcuentacontabledepregastonormal_descripcion());	
	}
	
	public static void inicializarDetalleGrupoActivoFijo(DetalleGrupoActivoFijo detallegrupoactivofijo) throws Exception {
		try {
				detallegrupoactivofijo.setId(0L);	
					
				detallegrupoactivofijo.setid_empresa(-1L);	
				detallegrupoactivofijo.setcodigo("");	
				detallegrupoactivofijo.setnombre("");	
				detallegrupoactivofijo.setsiglas("");	
				detallegrupoactivofijo.setid_cuenta_contable_costo_original(null);	
				detallegrupoactivofijo.setid_cuenta_contable_depre_normal(null);	
				detallegrupoactivofijo.setid_cuenta_contable_depre_gasto_normal(null);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderDetalleGrupoActivoFijo(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleGrupoActivoFijoConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleGrupoActivoFijoConstantesFunciones.LABEL_CODIGO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleGrupoActivoFijoConstantesFunciones.LABEL_NOMBRE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleGrupoActivoFijoConstantesFunciones.LABEL_SIGLAS);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleGrupoActivoFijoConstantesFunciones.LABEL_IDCUENTACONTABLECOSTOORIGINAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleGrupoActivoFijoConstantesFunciones.LABEL_IDCUENTACONTABLEDEPRENORMAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleGrupoActivoFijoConstantesFunciones.LABEL_IDCUENTACONTABLEDEPREGASTONORMAL);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataDetalleGrupoActivoFijo(String sTipo,Row row,Workbook workbook,DetalleGrupoActivoFijo detallegrupoactivofijo,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(detallegrupoactivofijo.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallegrupoactivofijo.getcodigo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallegrupoactivofijo.getnombre());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallegrupoactivofijo.getsiglas());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallegrupoactivofijo.getcuentacontablecostooriginal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallegrupoactivofijo.getcuentacontabledeprenormal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallegrupoactivofijo.getcuentacontabledepregastonormal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryDetalleGrupoActivoFijo=Constantes.SFINALQUERY;
	
	public String getsFinalQueryDetalleGrupoActivoFijo() {
		return this.sFinalQueryDetalleGrupoActivoFijo;
	}
	
	public void setsFinalQueryDetalleGrupoActivoFijo(String sFinalQueryDetalleGrupoActivoFijo) {
		this.sFinalQueryDetalleGrupoActivoFijo= sFinalQueryDetalleGrupoActivoFijo;
	}
	
	public Border resaltarSeleccionarDetalleGrupoActivoFijo=null;
	
	public Border setResaltarSeleccionarDetalleGrupoActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleGrupoActivoFijoBeanSwingJInternalFrame detallegrupoactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//detallegrupoactivofijoBeanSwingJInternalFrame.jTtoolBarDetalleGrupoActivoFijo.setBorder(borderResaltar);
		
		this.resaltarSeleccionarDetalleGrupoActivoFijo= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarDetalleGrupoActivoFijo() {
		return this.resaltarSeleccionarDetalleGrupoActivoFijo;
	}
	
	public void setResaltarSeleccionarDetalleGrupoActivoFijo(Border borderResaltarSeleccionarDetalleGrupoActivoFijo) {
		this.resaltarSeleccionarDetalleGrupoActivoFijo= borderResaltarSeleccionarDetalleGrupoActivoFijo;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridDetalleGrupoActivoFijo=null;
	public Boolean mostraridDetalleGrupoActivoFijo=true;
	public Boolean activaridDetalleGrupoActivoFijo=true;

	public Border resaltarid_empresaDetalleGrupoActivoFijo=null;
	public Boolean mostrarid_empresaDetalleGrupoActivoFijo=true;
	public Boolean activarid_empresaDetalleGrupoActivoFijo=true;
	public Boolean cargarid_empresaDetalleGrupoActivoFijo=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaDetalleGrupoActivoFijo=false;//ConEventDepend=true

	public Border resaltarcodigoDetalleGrupoActivoFijo=null;
	public Boolean mostrarcodigoDetalleGrupoActivoFijo=true;
	public Boolean activarcodigoDetalleGrupoActivoFijo=true;

	public Border resaltarnombreDetalleGrupoActivoFijo=null;
	public Boolean mostrarnombreDetalleGrupoActivoFijo=true;
	public Boolean activarnombreDetalleGrupoActivoFijo=true;

	public Border resaltarsiglasDetalleGrupoActivoFijo=null;
	public Boolean mostrarsiglasDetalleGrupoActivoFijo=true;
	public Boolean activarsiglasDetalleGrupoActivoFijo=true;

	public Border resaltarid_cuenta_contable_costo_originalDetalleGrupoActivoFijo=null;
	public Boolean mostrarid_cuenta_contable_costo_originalDetalleGrupoActivoFijo=true;
	public Boolean activarid_cuenta_contable_costo_originalDetalleGrupoActivoFijo=true;
	public Boolean cargarid_cuenta_contable_costo_originalDetalleGrupoActivoFijo=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_costo_originalDetalleGrupoActivoFijo=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contable_depre_normalDetalleGrupoActivoFijo=null;
	public Boolean mostrarid_cuenta_contable_depre_normalDetalleGrupoActivoFijo=true;
	public Boolean activarid_cuenta_contable_depre_normalDetalleGrupoActivoFijo=true;
	public Boolean cargarid_cuenta_contable_depre_normalDetalleGrupoActivoFijo=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_depre_normalDetalleGrupoActivoFijo=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contable_depre_gasto_normalDetalleGrupoActivoFijo=null;
	public Boolean mostrarid_cuenta_contable_depre_gasto_normalDetalleGrupoActivoFijo=true;
	public Boolean activarid_cuenta_contable_depre_gasto_normalDetalleGrupoActivoFijo=true;
	public Boolean cargarid_cuenta_contable_depre_gasto_normalDetalleGrupoActivoFijo=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_depre_gasto_normalDetalleGrupoActivoFijo=false;//ConEventDepend=true

	
	

	public Border setResaltaridDetalleGrupoActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleGrupoActivoFijoBeanSwingJInternalFrame detallegrupoactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallegrupoactivofijoBeanSwingJInternalFrame.jTtoolBarDetalleGrupoActivoFijo.setBorder(borderResaltar);
		
		this.resaltaridDetalleGrupoActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridDetalleGrupoActivoFijo() {
		return this.resaltaridDetalleGrupoActivoFijo;
	}

	public void setResaltaridDetalleGrupoActivoFijo(Border borderResaltar) {
		this.resaltaridDetalleGrupoActivoFijo= borderResaltar;
	}

	public Boolean getMostraridDetalleGrupoActivoFijo() {
		return this.mostraridDetalleGrupoActivoFijo;
	}

	public void setMostraridDetalleGrupoActivoFijo(Boolean mostraridDetalleGrupoActivoFijo) {
		this.mostraridDetalleGrupoActivoFijo= mostraridDetalleGrupoActivoFijo;
	}

	public Boolean getActivaridDetalleGrupoActivoFijo() {
		return this.activaridDetalleGrupoActivoFijo;
	}

	public void setActivaridDetalleGrupoActivoFijo(Boolean activaridDetalleGrupoActivoFijo) {
		this.activaridDetalleGrupoActivoFijo= activaridDetalleGrupoActivoFijo;
	}

	public Border setResaltarid_empresaDetalleGrupoActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleGrupoActivoFijoBeanSwingJInternalFrame detallegrupoactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallegrupoactivofijoBeanSwingJInternalFrame.jTtoolBarDetalleGrupoActivoFijo.setBorder(borderResaltar);
		
		this.resaltarid_empresaDetalleGrupoActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaDetalleGrupoActivoFijo() {
		return this.resaltarid_empresaDetalleGrupoActivoFijo;
	}

	public void setResaltarid_empresaDetalleGrupoActivoFijo(Border borderResaltar) {
		this.resaltarid_empresaDetalleGrupoActivoFijo= borderResaltar;
	}

	public Boolean getMostrarid_empresaDetalleGrupoActivoFijo() {
		return this.mostrarid_empresaDetalleGrupoActivoFijo;
	}

	public void setMostrarid_empresaDetalleGrupoActivoFijo(Boolean mostrarid_empresaDetalleGrupoActivoFijo) {
		this.mostrarid_empresaDetalleGrupoActivoFijo= mostrarid_empresaDetalleGrupoActivoFijo;
	}

	public Boolean getActivarid_empresaDetalleGrupoActivoFijo() {
		return this.activarid_empresaDetalleGrupoActivoFijo;
	}

	public void setActivarid_empresaDetalleGrupoActivoFijo(Boolean activarid_empresaDetalleGrupoActivoFijo) {
		this.activarid_empresaDetalleGrupoActivoFijo= activarid_empresaDetalleGrupoActivoFijo;
	}

	public Boolean getCargarid_empresaDetalleGrupoActivoFijo() {
		return this.cargarid_empresaDetalleGrupoActivoFijo;
	}

	public void setCargarid_empresaDetalleGrupoActivoFijo(Boolean cargarid_empresaDetalleGrupoActivoFijo) {
		this.cargarid_empresaDetalleGrupoActivoFijo= cargarid_empresaDetalleGrupoActivoFijo;
	}

	public Border setResaltarcodigoDetalleGrupoActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleGrupoActivoFijoBeanSwingJInternalFrame detallegrupoactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallegrupoactivofijoBeanSwingJInternalFrame.jTtoolBarDetalleGrupoActivoFijo.setBorder(borderResaltar);
		
		this.resaltarcodigoDetalleGrupoActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarcodigoDetalleGrupoActivoFijo() {
		return this.resaltarcodigoDetalleGrupoActivoFijo;
	}

	public void setResaltarcodigoDetalleGrupoActivoFijo(Border borderResaltar) {
		this.resaltarcodigoDetalleGrupoActivoFijo= borderResaltar;
	}

	public Boolean getMostrarcodigoDetalleGrupoActivoFijo() {
		return this.mostrarcodigoDetalleGrupoActivoFijo;
	}

	public void setMostrarcodigoDetalleGrupoActivoFijo(Boolean mostrarcodigoDetalleGrupoActivoFijo) {
		this.mostrarcodigoDetalleGrupoActivoFijo= mostrarcodigoDetalleGrupoActivoFijo;
	}

	public Boolean getActivarcodigoDetalleGrupoActivoFijo() {
		return this.activarcodigoDetalleGrupoActivoFijo;
	}

	public void setActivarcodigoDetalleGrupoActivoFijo(Boolean activarcodigoDetalleGrupoActivoFijo) {
		this.activarcodigoDetalleGrupoActivoFijo= activarcodigoDetalleGrupoActivoFijo;
	}

	public Border setResaltarnombreDetalleGrupoActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleGrupoActivoFijoBeanSwingJInternalFrame detallegrupoactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallegrupoactivofijoBeanSwingJInternalFrame.jTtoolBarDetalleGrupoActivoFijo.setBorder(borderResaltar);
		
		this.resaltarnombreDetalleGrupoActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarnombreDetalleGrupoActivoFijo() {
		return this.resaltarnombreDetalleGrupoActivoFijo;
	}

	public void setResaltarnombreDetalleGrupoActivoFijo(Border borderResaltar) {
		this.resaltarnombreDetalleGrupoActivoFijo= borderResaltar;
	}

	public Boolean getMostrarnombreDetalleGrupoActivoFijo() {
		return this.mostrarnombreDetalleGrupoActivoFijo;
	}

	public void setMostrarnombreDetalleGrupoActivoFijo(Boolean mostrarnombreDetalleGrupoActivoFijo) {
		this.mostrarnombreDetalleGrupoActivoFijo= mostrarnombreDetalleGrupoActivoFijo;
	}

	public Boolean getActivarnombreDetalleGrupoActivoFijo() {
		return this.activarnombreDetalleGrupoActivoFijo;
	}

	public void setActivarnombreDetalleGrupoActivoFijo(Boolean activarnombreDetalleGrupoActivoFijo) {
		this.activarnombreDetalleGrupoActivoFijo= activarnombreDetalleGrupoActivoFijo;
	}

	public Border setResaltarsiglasDetalleGrupoActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleGrupoActivoFijoBeanSwingJInternalFrame detallegrupoactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallegrupoactivofijoBeanSwingJInternalFrame.jTtoolBarDetalleGrupoActivoFijo.setBorder(borderResaltar);
		
		this.resaltarsiglasDetalleGrupoActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarsiglasDetalleGrupoActivoFijo() {
		return this.resaltarsiglasDetalleGrupoActivoFijo;
	}

	public void setResaltarsiglasDetalleGrupoActivoFijo(Border borderResaltar) {
		this.resaltarsiglasDetalleGrupoActivoFijo= borderResaltar;
	}

	public Boolean getMostrarsiglasDetalleGrupoActivoFijo() {
		return this.mostrarsiglasDetalleGrupoActivoFijo;
	}

	public void setMostrarsiglasDetalleGrupoActivoFijo(Boolean mostrarsiglasDetalleGrupoActivoFijo) {
		this.mostrarsiglasDetalleGrupoActivoFijo= mostrarsiglasDetalleGrupoActivoFijo;
	}

	public Boolean getActivarsiglasDetalleGrupoActivoFijo() {
		return this.activarsiglasDetalleGrupoActivoFijo;
	}

	public void setActivarsiglasDetalleGrupoActivoFijo(Boolean activarsiglasDetalleGrupoActivoFijo) {
		this.activarsiglasDetalleGrupoActivoFijo= activarsiglasDetalleGrupoActivoFijo;
	}

	public Border setResaltarid_cuenta_contable_costo_originalDetalleGrupoActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleGrupoActivoFijoBeanSwingJInternalFrame detallegrupoactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallegrupoactivofijoBeanSwingJInternalFrame.jTtoolBarDetalleGrupoActivoFijo.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_costo_originalDetalleGrupoActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_costo_originalDetalleGrupoActivoFijo() {
		return this.resaltarid_cuenta_contable_costo_originalDetalleGrupoActivoFijo;
	}

	public void setResaltarid_cuenta_contable_costo_originalDetalleGrupoActivoFijo(Border borderResaltar) {
		this.resaltarid_cuenta_contable_costo_originalDetalleGrupoActivoFijo= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_costo_originalDetalleGrupoActivoFijo() {
		return this.mostrarid_cuenta_contable_costo_originalDetalleGrupoActivoFijo;
	}

	public void setMostrarid_cuenta_contable_costo_originalDetalleGrupoActivoFijo(Boolean mostrarid_cuenta_contable_costo_originalDetalleGrupoActivoFijo) {
		this.mostrarid_cuenta_contable_costo_originalDetalleGrupoActivoFijo= mostrarid_cuenta_contable_costo_originalDetalleGrupoActivoFijo;
	}

	public Boolean getActivarid_cuenta_contable_costo_originalDetalleGrupoActivoFijo() {
		return this.activarid_cuenta_contable_costo_originalDetalleGrupoActivoFijo;
	}

	public void setActivarid_cuenta_contable_costo_originalDetalleGrupoActivoFijo(Boolean activarid_cuenta_contable_costo_originalDetalleGrupoActivoFijo) {
		this.activarid_cuenta_contable_costo_originalDetalleGrupoActivoFijo= activarid_cuenta_contable_costo_originalDetalleGrupoActivoFijo;
	}

	public Boolean getCargarid_cuenta_contable_costo_originalDetalleGrupoActivoFijo() {
		return this.cargarid_cuenta_contable_costo_originalDetalleGrupoActivoFijo;
	}

	public void setCargarid_cuenta_contable_costo_originalDetalleGrupoActivoFijo(Boolean cargarid_cuenta_contable_costo_originalDetalleGrupoActivoFijo) {
		this.cargarid_cuenta_contable_costo_originalDetalleGrupoActivoFijo= cargarid_cuenta_contable_costo_originalDetalleGrupoActivoFijo;
	}

	public Border setResaltarid_cuenta_contable_depre_normalDetalleGrupoActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleGrupoActivoFijoBeanSwingJInternalFrame detallegrupoactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallegrupoactivofijoBeanSwingJInternalFrame.jTtoolBarDetalleGrupoActivoFijo.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_depre_normalDetalleGrupoActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_depre_normalDetalleGrupoActivoFijo() {
		return this.resaltarid_cuenta_contable_depre_normalDetalleGrupoActivoFijo;
	}

	public void setResaltarid_cuenta_contable_depre_normalDetalleGrupoActivoFijo(Border borderResaltar) {
		this.resaltarid_cuenta_contable_depre_normalDetalleGrupoActivoFijo= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_depre_normalDetalleGrupoActivoFijo() {
		return this.mostrarid_cuenta_contable_depre_normalDetalleGrupoActivoFijo;
	}

	public void setMostrarid_cuenta_contable_depre_normalDetalleGrupoActivoFijo(Boolean mostrarid_cuenta_contable_depre_normalDetalleGrupoActivoFijo) {
		this.mostrarid_cuenta_contable_depre_normalDetalleGrupoActivoFijo= mostrarid_cuenta_contable_depre_normalDetalleGrupoActivoFijo;
	}

	public Boolean getActivarid_cuenta_contable_depre_normalDetalleGrupoActivoFijo() {
		return this.activarid_cuenta_contable_depre_normalDetalleGrupoActivoFijo;
	}

	public void setActivarid_cuenta_contable_depre_normalDetalleGrupoActivoFijo(Boolean activarid_cuenta_contable_depre_normalDetalleGrupoActivoFijo) {
		this.activarid_cuenta_contable_depre_normalDetalleGrupoActivoFijo= activarid_cuenta_contable_depre_normalDetalleGrupoActivoFijo;
	}

	public Boolean getCargarid_cuenta_contable_depre_normalDetalleGrupoActivoFijo() {
		return this.cargarid_cuenta_contable_depre_normalDetalleGrupoActivoFijo;
	}

	public void setCargarid_cuenta_contable_depre_normalDetalleGrupoActivoFijo(Boolean cargarid_cuenta_contable_depre_normalDetalleGrupoActivoFijo) {
		this.cargarid_cuenta_contable_depre_normalDetalleGrupoActivoFijo= cargarid_cuenta_contable_depre_normalDetalleGrupoActivoFijo;
	}

	public Border setResaltarid_cuenta_contable_depre_gasto_normalDetalleGrupoActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleGrupoActivoFijoBeanSwingJInternalFrame detallegrupoactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallegrupoactivofijoBeanSwingJInternalFrame.jTtoolBarDetalleGrupoActivoFijo.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_depre_gasto_normalDetalleGrupoActivoFijo= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_depre_gasto_normalDetalleGrupoActivoFijo() {
		return this.resaltarid_cuenta_contable_depre_gasto_normalDetalleGrupoActivoFijo;
	}

	public void setResaltarid_cuenta_contable_depre_gasto_normalDetalleGrupoActivoFijo(Border borderResaltar) {
		this.resaltarid_cuenta_contable_depre_gasto_normalDetalleGrupoActivoFijo= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_depre_gasto_normalDetalleGrupoActivoFijo() {
		return this.mostrarid_cuenta_contable_depre_gasto_normalDetalleGrupoActivoFijo;
	}

	public void setMostrarid_cuenta_contable_depre_gasto_normalDetalleGrupoActivoFijo(Boolean mostrarid_cuenta_contable_depre_gasto_normalDetalleGrupoActivoFijo) {
		this.mostrarid_cuenta_contable_depre_gasto_normalDetalleGrupoActivoFijo= mostrarid_cuenta_contable_depre_gasto_normalDetalleGrupoActivoFijo;
	}

	public Boolean getActivarid_cuenta_contable_depre_gasto_normalDetalleGrupoActivoFijo() {
		return this.activarid_cuenta_contable_depre_gasto_normalDetalleGrupoActivoFijo;
	}

	public void setActivarid_cuenta_contable_depre_gasto_normalDetalleGrupoActivoFijo(Boolean activarid_cuenta_contable_depre_gasto_normalDetalleGrupoActivoFijo) {
		this.activarid_cuenta_contable_depre_gasto_normalDetalleGrupoActivoFijo= activarid_cuenta_contable_depre_gasto_normalDetalleGrupoActivoFijo;
	}

	public Boolean getCargarid_cuenta_contable_depre_gasto_normalDetalleGrupoActivoFijo() {
		return this.cargarid_cuenta_contable_depre_gasto_normalDetalleGrupoActivoFijo;
	}

	public void setCargarid_cuenta_contable_depre_gasto_normalDetalleGrupoActivoFijo(Boolean cargarid_cuenta_contable_depre_gasto_normalDetalleGrupoActivoFijo) {
		this.cargarid_cuenta_contable_depre_gasto_normalDetalleGrupoActivoFijo= cargarid_cuenta_contable_depre_gasto_normalDetalleGrupoActivoFijo;
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
		
		
		this.setMostraridDetalleGrupoActivoFijo(esInicial);
		this.setMostrarid_empresaDetalleGrupoActivoFijo(esInicial);
		this.setMostrarcodigoDetalleGrupoActivoFijo(esInicial);
		this.setMostrarnombreDetalleGrupoActivoFijo(esInicial);
		this.setMostrarsiglasDetalleGrupoActivoFijo(esInicial);
		this.setMostrarid_cuenta_contable_costo_originalDetalleGrupoActivoFijo(esInicial);
		this.setMostrarid_cuenta_contable_depre_normalDetalleGrupoActivoFijo(esInicial);
		this.setMostrarid_cuenta_contable_depre_gasto_normalDetalleGrupoActivoFijo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetalleGrupoActivoFijoConstantesFunciones.ID)) {
				this.setMostraridDetalleGrupoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleGrupoActivoFijoConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaDetalleGrupoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleGrupoActivoFijoConstantesFunciones.CODIGO)) {
				this.setMostrarcodigoDetalleGrupoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleGrupoActivoFijoConstantesFunciones.NOMBRE)) {
				this.setMostrarnombreDetalleGrupoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleGrupoActivoFijoConstantesFunciones.SIGLAS)) {
				this.setMostrarsiglasDetalleGrupoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleGrupoActivoFijoConstantesFunciones.IDCUENTACONTABLECOSTOORIGINAL)) {
				this.setMostrarid_cuenta_contable_costo_originalDetalleGrupoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleGrupoActivoFijoConstantesFunciones.IDCUENTACONTABLEDEPRENORMAL)) {
				this.setMostrarid_cuenta_contable_depre_normalDetalleGrupoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleGrupoActivoFijoConstantesFunciones.IDCUENTACONTABLEDEPREGASTONORMAL)) {
				this.setMostrarid_cuenta_contable_depre_gasto_normalDetalleGrupoActivoFijo(esAsigna);
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
		
		
		this.setActivaridDetalleGrupoActivoFijo(esInicial);
		this.setActivarid_empresaDetalleGrupoActivoFijo(esInicial);
		this.setActivarcodigoDetalleGrupoActivoFijo(esInicial);
		this.setActivarnombreDetalleGrupoActivoFijo(esInicial);
		this.setActivarsiglasDetalleGrupoActivoFijo(esInicial);
		this.setActivarid_cuenta_contable_costo_originalDetalleGrupoActivoFijo(esInicial);
		this.setActivarid_cuenta_contable_depre_normalDetalleGrupoActivoFijo(esInicial);
		this.setActivarid_cuenta_contable_depre_gasto_normalDetalleGrupoActivoFijo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetalleGrupoActivoFijoConstantesFunciones.ID)) {
				this.setActivaridDetalleGrupoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleGrupoActivoFijoConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaDetalleGrupoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleGrupoActivoFijoConstantesFunciones.CODIGO)) {
				this.setActivarcodigoDetalleGrupoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleGrupoActivoFijoConstantesFunciones.NOMBRE)) {
				this.setActivarnombreDetalleGrupoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleGrupoActivoFijoConstantesFunciones.SIGLAS)) {
				this.setActivarsiglasDetalleGrupoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleGrupoActivoFijoConstantesFunciones.IDCUENTACONTABLECOSTOORIGINAL)) {
				this.setActivarid_cuenta_contable_costo_originalDetalleGrupoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleGrupoActivoFijoConstantesFunciones.IDCUENTACONTABLEDEPRENORMAL)) {
				this.setActivarid_cuenta_contable_depre_normalDetalleGrupoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleGrupoActivoFijoConstantesFunciones.IDCUENTACONTABLEDEPREGASTONORMAL)) {
				this.setActivarid_cuenta_contable_depre_gasto_normalDetalleGrupoActivoFijo(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,DetalleGrupoActivoFijoBeanSwingJInternalFrame detallegrupoactivofijoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridDetalleGrupoActivoFijo(esInicial);
		this.setResaltarid_empresaDetalleGrupoActivoFijo(esInicial);
		this.setResaltarcodigoDetalleGrupoActivoFijo(esInicial);
		this.setResaltarnombreDetalleGrupoActivoFijo(esInicial);
		this.setResaltarsiglasDetalleGrupoActivoFijo(esInicial);
		this.setResaltarid_cuenta_contable_costo_originalDetalleGrupoActivoFijo(esInicial);
		this.setResaltarid_cuenta_contable_depre_normalDetalleGrupoActivoFijo(esInicial);
		this.setResaltarid_cuenta_contable_depre_gasto_normalDetalleGrupoActivoFijo(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetalleGrupoActivoFijoConstantesFunciones.ID)) {
				this.setResaltaridDetalleGrupoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleGrupoActivoFijoConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaDetalleGrupoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleGrupoActivoFijoConstantesFunciones.CODIGO)) {
				this.setResaltarcodigoDetalleGrupoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleGrupoActivoFijoConstantesFunciones.NOMBRE)) {
				this.setResaltarnombreDetalleGrupoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleGrupoActivoFijoConstantesFunciones.SIGLAS)) {
				this.setResaltarsiglasDetalleGrupoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleGrupoActivoFijoConstantesFunciones.IDCUENTACONTABLECOSTOORIGINAL)) {
				this.setResaltarid_cuenta_contable_costo_originalDetalleGrupoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleGrupoActivoFijoConstantesFunciones.IDCUENTACONTABLEDEPRENORMAL)) {
				this.setResaltarid_cuenta_contable_depre_normalDetalleGrupoActivoFijo(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleGrupoActivoFijoConstantesFunciones.IDCUENTACONTABLEDEPREGASTONORMAL)) {
				this.setResaltarid_cuenta_contable_depre_gasto_normalDetalleGrupoActivoFijo(esAsigna);
				continue;
			}
		}
	}
	
	

	public Border resaltarDetalleActivoFijoDetalleGrupoActivoFijo=null;

	public Border getResaltarDetalleActivoFijoDetalleGrupoActivoFijo() {
		return this.resaltarDetalleActivoFijoDetalleGrupoActivoFijo;
	}

	public void setResaltarDetalleActivoFijoDetalleGrupoActivoFijo(Border borderResaltarDetalleActivoFijo) {
		if(borderResaltarDetalleActivoFijo!=null) {
			this.resaltarDetalleActivoFijoDetalleGrupoActivoFijo= borderResaltarDetalleActivoFijo;
		}
	}

	public Border setResaltarDetalleActivoFijoDetalleGrupoActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleGrupoActivoFijoBeanSwingJInternalFrame detallegrupoactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltarDetalleActivoFijo=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//detallegrupoactivofijoBeanSwingJInternalFrame.jTtoolBarDetalleGrupoActivoFijo.setBorder(borderResaltarDetalleActivoFijo);
			
		this.resaltarDetalleActivoFijoDetalleGrupoActivoFijo= borderResaltarDetalleActivoFijo;

		 return borderResaltarDetalleActivoFijo;
	}



	public Boolean mostrarDetalleActivoFijoDetalleGrupoActivoFijo=true;

	public Boolean getMostrarDetalleActivoFijoDetalleGrupoActivoFijo() {
		return this.mostrarDetalleActivoFijoDetalleGrupoActivoFijo;
	}

	public void setMostrarDetalleActivoFijoDetalleGrupoActivoFijo(Boolean visibilidadResaltarDetalleActivoFijo) {
		this.mostrarDetalleActivoFijoDetalleGrupoActivoFijo= visibilidadResaltarDetalleActivoFijo;
	}



	public Boolean activarDetalleActivoFijoDetalleGrupoActivoFijo=true;

	public Boolean gethabilitarResaltarDetalleActivoFijoDetalleGrupoActivoFijo() {
		return this.activarDetalleActivoFijoDetalleGrupoActivoFijo;
	}

	public void setActivarDetalleActivoFijoDetalleGrupoActivoFijo(Boolean habilitarResaltarDetalleActivoFijo) {
		this.activarDetalleActivoFijoDetalleGrupoActivoFijo= habilitarResaltarDetalleActivoFijo;
	}


	public Border resaltarCuentaContaDetaGrupoActiDetalleGrupoActivoFijo=null;

	public Border getResaltarCuentaContaDetaGrupoActiDetalleGrupoActivoFijo() {
		return this.resaltarCuentaContaDetaGrupoActiDetalleGrupoActivoFijo;
	}

	public void setResaltarCuentaContaDetaGrupoActiDetalleGrupoActivoFijo(Border borderResaltarCuentaContaDetaGrupoActi) {
		if(borderResaltarCuentaContaDetaGrupoActi!=null) {
			this.resaltarCuentaContaDetaGrupoActiDetalleGrupoActivoFijo= borderResaltarCuentaContaDetaGrupoActi;
		}
	}

	public Border setResaltarCuentaContaDetaGrupoActiDetalleGrupoActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleGrupoActivoFijoBeanSwingJInternalFrame detallegrupoactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltarCuentaContaDetaGrupoActi=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//detallegrupoactivofijoBeanSwingJInternalFrame.jTtoolBarDetalleGrupoActivoFijo.setBorder(borderResaltarCuentaContaDetaGrupoActi);
			
		this.resaltarCuentaContaDetaGrupoActiDetalleGrupoActivoFijo= borderResaltarCuentaContaDetaGrupoActi;

		 return borderResaltarCuentaContaDetaGrupoActi;
	}



	public Boolean mostrarCuentaContaDetaGrupoActiDetalleGrupoActivoFijo=true;

	public Boolean getMostrarCuentaContaDetaGrupoActiDetalleGrupoActivoFijo() {
		return this.mostrarCuentaContaDetaGrupoActiDetalleGrupoActivoFijo;
	}

	public void setMostrarCuentaContaDetaGrupoActiDetalleGrupoActivoFijo(Boolean visibilidadResaltarCuentaContaDetaGrupoActi) {
		this.mostrarCuentaContaDetaGrupoActiDetalleGrupoActivoFijo= visibilidadResaltarCuentaContaDetaGrupoActi;
	}



	public Boolean activarCuentaContaDetaGrupoActiDetalleGrupoActivoFijo=true;

	public Boolean gethabilitarResaltarCuentaContaDetaGrupoActiDetalleGrupoActivoFijo() {
		return this.activarCuentaContaDetaGrupoActiDetalleGrupoActivoFijo;
	}

	public void setActivarCuentaContaDetaGrupoActiDetalleGrupoActivoFijo(Boolean habilitarResaltarCuentaContaDetaGrupoActi) {
		this.activarCuentaContaDetaGrupoActiDetalleGrupoActivoFijo= habilitarResaltarCuentaContaDetaGrupoActi;
	}


	public Border resaltarSubGrupoActivoFijoDetalleGrupoActivoFijo=null;

	public Border getResaltarSubGrupoActivoFijoDetalleGrupoActivoFijo() {
		return this.resaltarSubGrupoActivoFijoDetalleGrupoActivoFijo;
	}

	public void setResaltarSubGrupoActivoFijoDetalleGrupoActivoFijo(Border borderResaltarSubGrupoActivoFijo) {
		if(borderResaltarSubGrupoActivoFijo!=null) {
			this.resaltarSubGrupoActivoFijoDetalleGrupoActivoFijo= borderResaltarSubGrupoActivoFijo;
		}
	}

	public Border setResaltarSubGrupoActivoFijoDetalleGrupoActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleGrupoActivoFijoBeanSwingJInternalFrame detallegrupoactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltarSubGrupoActivoFijo=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//detallegrupoactivofijoBeanSwingJInternalFrame.jTtoolBarDetalleGrupoActivoFijo.setBorder(borderResaltarSubGrupoActivoFijo);
			
		this.resaltarSubGrupoActivoFijoDetalleGrupoActivoFijo= borderResaltarSubGrupoActivoFijo;

		 return borderResaltarSubGrupoActivoFijo;
	}



	public Boolean mostrarSubGrupoActivoFijoDetalleGrupoActivoFijo=true;

	public Boolean getMostrarSubGrupoActivoFijoDetalleGrupoActivoFijo() {
		return this.mostrarSubGrupoActivoFijoDetalleGrupoActivoFijo;
	}

	public void setMostrarSubGrupoActivoFijoDetalleGrupoActivoFijo(Boolean visibilidadResaltarSubGrupoActivoFijo) {
		this.mostrarSubGrupoActivoFijoDetalleGrupoActivoFijo= visibilidadResaltarSubGrupoActivoFijo;
	}



	public Boolean activarSubGrupoActivoFijoDetalleGrupoActivoFijo=true;

	public Boolean gethabilitarResaltarSubGrupoActivoFijoDetalleGrupoActivoFijo() {
		return this.activarSubGrupoActivoFijoDetalleGrupoActivoFijo;
	}

	public void setActivarSubGrupoActivoFijoDetalleGrupoActivoFijo(Boolean habilitarResaltarSubGrupoActivoFijo) {
		this.activarSubGrupoActivoFijoDetalleGrupoActivoFijo= habilitarResaltarSubGrupoActivoFijo;
	}


	public Border resaltarGastoDepreciacionDetalleGrupoActivoFijo=null;

	public Border getResaltarGastoDepreciacionDetalleGrupoActivoFijo() {
		return this.resaltarGastoDepreciacionDetalleGrupoActivoFijo;
	}

	public void setResaltarGastoDepreciacionDetalleGrupoActivoFijo(Border borderResaltarGastoDepreciacion) {
		if(borderResaltarGastoDepreciacion!=null) {
			this.resaltarGastoDepreciacionDetalleGrupoActivoFijo= borderResaltarGastoDepreciacion;
		}
	}

	public Border setResaltarGastoDepreciacionDetalleGrupoActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleGrupoActivoFijoBeanSwingJInternalFrame detallegrupoactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltarGastoDepreciacion=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			

		//detallegrupoactivofijoBeanSwingJInternalFrame.jTtoolBarDetalleGrupoActivoFijo.setBorder(borderResaltarGastoDepreciacion);
			
		this.resaltarGastoDepreciacionDetalleGrupoActivoFijo= borderResaltarGastoDepreciacion;

		 return borderResaltarGastoDepreciacion;
	}



	public Boolean mostrarGastoDepreciacionDetalleGrupoActivoFijo=true;

	public Boolean getMostrarGastoDepreciacionDetalleGrupoActivoFijo() {
		return this.mostrarGastoDepreciacionDetalleGrupoActivoFijo;
	}

	public void setMostrarGastoDepreciacionDetalleGrupoActivoFijo(Boolean visibilidadResaltarGastoDepreciacion) {
		this.mostrarGastoDepreciacionDetalleGrupoActivoFijo= visibilidadResaltarGastoDepreciacion;
	}



	public Boolean activarGastoDepreciacionDetalleGrupoActivoFijo=true;

	public Boolean gethabilitarResaltarGastoDepreciacionDetalleGrupoActivoFijo() {
		return this.activarGastoDepreciacionDetalleGrupoActivoFijo;
	}

	public void setActivarGastoDepreciacionDetalleGrupoActivoFijo(Boolean habilitarResaltarGastoDepreciacion) {
		this.activarGastoDepreciacionDetalleGrupoActivoFijo= habilitarResaltarGastoDepreciacion;
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

		this.setMostrarDetalleActivoFijoDetalleGrupoActivoFijo(esInicial);
		this.setMostrarCuentaContaDetaGrupoActiDetalleGrupoActivoFijo(esInicial);
		this.setMostrarSubGrupoActivoFijoDetalleGrupoActivoFijo(esInicial);
		this.setMostrarGastoDepreciacionDetalleGrupoActivoFijo(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetalleActivoFijo.class)) {
				this.setMostrarDetalleActivoFijoDetalleGrupoActivoFijo(esAsigna);
				continue;
			}

			if(clase.clas.equals(CuentaContaDetaGrupoActi.class)) {
				this.setMostrarCuentaContaDetaGrupoActiDetalleGrupoActivoFijo(esAsigna);
				continue;
			}

			if(clase.clas.equals(SubGrupoActivoFijo.class)) {
				this.setMostrarSubGrupoActivoFijoDetalleGrupoActivoFijo(esAsigna);
				continue;
			}

			if(clase.clas.equals(GastoDepreciacion.class)) {
				this.setMostrarGastoDepreciacionDetalleGrupoActivoFijo(esAsigna);
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

		this.setActivarDetalleActivoFijoDetalleGrupoActivoFijo(esInicial);
		this.setActivarCuentaContaDetaGrupoActiDetalleGrupoActivoFijo(esInicial);
		this.setActivarSubGrupoActivoFijoDetalleGrupoActivoFijo(esInicial);
		this.setActivarGastoDepreciacionDetalleGrupoActivoFijo(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetalleActivoFijo.class)) {
				this.setActivarDetalleActivoFijoDetalleGrupoActivoFijo(esAsigna);
				continue;
			}

			if(clase.clas.equals(CuentaContaDetaGrupoActi.class)) {
				this.setActivarCuentaContaDetaGrupoActiDetalleGrupoActivoFijo(esAsigna);
				continue;
			}

			if(clase.clas.equals(SubGrupoActivoFijo.class)) {
				this.setActivarSubGrupoActivoFijoDetalleGrupoActivoFijo(esAsigna);
				continue;
			}

			if(clase.clas.equals(GastoDepreciacion.class)) {
				this.setActivarGastoDepreciacionDetalleGrupoActivoFijo(esAsigna);
				continue;
			}
		}		
	}
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,DetalleGrupoActivoFijoBeanSwingJInternalFrame detallegrupoactivofijoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
		
		
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}

		this.setResaltarDetalleActivoFijoDetalleGrupoActivoFijo(esInicial);
		this.setResaltarCuentaContaDetaGrupoActiDetalleGrupoActivoFijo(esInicial);
		this.setResaltarSubGrupoActivoFijoDetalleGrupoActivoFijo(esInicial);
		this.setResaltarGastoDepreciacionDetalleGrupoActivoFijo(esInicial);

		for(Classe clase:clases) {

			if(clase.clas.equals(DetalleActivoFijo.class)) {
				this.setResaltarDetalleActivoFijoDetalleGrupoActivoFijo(esAsigna);
				continue;
			}

			if(clase.clas.equals(CuentaContaDetaGrupoActi.class)) {
				this.setResaltarCuentaContaDetaGrupoActiDetalleGrupoActivoFijo(esAsigna);
				continue;
			}

			if(clase.clas.equals(SubGrupoActivoFijo.class)) {
				this.setResaltarSubGrupoActivoFijoDetalleGrupoActivoFijo(esAsigna);
				continue;
			}

			if(clase.clas.equals(GastoDepreciacion.class)) {
				this.setResaltarGastoDepreciacionDetalleGrupoActivoFijo(esAsigna);
				continue;
			}
		}		
	}
	
	


	public Boolean mostrarFK_IdCuentaContableCostoOriginalDetalleGrupoActivoFijo=true;

	public Boolean getMostrarFK_IdCuentaContableCostoOriginalDetalleGrupoActivoFijo() {
		return this.mostrarFK_IdCuentaContableCostoOriginalDetalleGrupoActivoFijo;
	}

	public void setMostrarFK_IdCuentaContableCostoOriginalDetalleGrupoActivoFijo(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCuentaContableCostoOriginalDetalleGrupoActivoFijo= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCuentaContableDepreGastoNormalDetalleGrupoActivoFijo=true;

	public Boolean getMostrarFK_IdCuentaContableDepreGastoNormalDetalleGrupoActivoFijo() {
		return this.mostrarFK_IdCuentaContableDepreGastoNormalDetalleGrupoActivoFijo;
	}

	public void setMostrarFK_IdCuentaContableDepreGastoNormalDetalleGrupoActivoFijo(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCuentaContableDepreGastoNormalDetalleGrupoActivoFijo= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCuentaContableDepreNormalDetalleGrupoActivoFijo=true;

	public Boolean getMostrarFK_IdCuentaContableDepreNormalDetalleGrupoActivoFijo() {
		return this.mostrarFK_IdCuentaContableDepreNormalDetalleGrupoActivoFijo;
	}

	public void setMostrarFK_IdCuentaContableDepreNormalDetalleGrupoActivoFijo(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCuentaContableDepreNormalDetalleGrupoActivoFijo= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaDetalleGrupoActivoFijo=true;

	public Boolean getMostrarFK_IdEmpresaDetalleGrupoActivoFijo() {
		return this.mostrarFK_IdEmpresaDetalleGrupoActivoFijo;
	}

	public void setMostrarFK_IdEmpresaDetalleGrupoActivoFijo(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaDetalleGrupoActivoFijo= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdCuentaContableCostoOriginalDetalleGrupoActivoFijo=true;

	public Boolean getActivarFK_IdCuentaContableCostoOriginalDetalleGrupoActivoFijo() {
		return this.activarFK_IdCuentaContableCostoOriginalDetalleGrupoActivoFijo;
	}

	public void setActivarFK_IdCuentaContableCostoOriginalDetalleGrupoActivoFijo(Boolean habilitarResaltar) {
		this.activarFK_IdCuentaContableCostoOriginalDetalleGrupoActivoFijo= habilitarResaltar;
	}

	public Boolean activarFK_IdCuentaContableDepreGastoNormalDetalleGrupoActivoFijo=true;

	public Boolean getActivarFK_IdCuentaContableDepreGastoNormalDetalleGrupoActivoFijo() {
		return this.activarFK_IdCuentaContableDepreGastoNormalDetalleGrupoActivoFijo;
	}

	public void setActivarFK_IdCuentaContableDepreGastoNormalDetalleGrupoActivoFijo(Boolean habilitarResaltar) {
		this.activarFK_IdCuentaContableDepreGastoNormalDetalleGrupoActivoFijo= habilitarResaltar;
	}

	public Boolean activarFK_IdCuentaContableDepreNormalDetalleGrupoActivoFijo=true;

	public Boolean getActivarFK_IdCuentaContableDepreNormalDetalleGrupoActivoFijo() {
		return this.activarFK_IdCuentaContableDepreNormalDetalleGrupoActivoFijo;
	}

	public void setActivarFK_IdCuentaContableDepreNormalDetalleGrupoActivoFijo(Boolean habilitarResaltar) {
		this.activarFK_IdCuentaContableDepreNormalDetalleGrupoActivoFijo= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaDetalleGrupoActivoFijo=true;

	public Boolean getActivarFK_IdEmpresaDetalleGrupoActivoFijo() {
		return this.activarFK_IdEmpresaDetalleGrupoActivoFijo;
	}

	public void setActivarFK_IdEmpresaDetalleGrupoActivoFijo(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaDetalleGrupoActivoFijo= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdCuentaContableCostoOriginalDetalleGrupoActivoFijo=null;

	public Border getResaltarFK_IdCuentaContableCostoOriginalDetalleGrupoActivoFijo() {
		return this.resaltarFK_IdCuentaContableCostoOriginalDetalleGrupoActivoFijo;
	}

	public void setResaltarFK_IdCuentaContableCostoOriginalDetalleGrupoActivoFijo(Border borderResaltar) {
		this.resaltarFK_IdCuentaContableCostoOriginalDetalleGrupoActivoFijo= borderResaltar;
	}

	public void setResaltarFK_IdCuentaContableCostoOriginalDetalleGrupoActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleGrupoActivoFijoBeanSwingJInternalFrame detallegrupoactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCuentaContableCostoOriginalDetalleGrupoActivoFijo= borderResaltar;
	}

	public Border resaltarFK_IdCuentaContableDepreGastoNormalDetalleGrupoActivoFijo=null;

	public Border getResaltarFK_IdCuentaContableDepreGastoNormalDetalleGrupoActivoFijo() {
		return this.resaltarFK_IdCuentaContableDepreGastoNormalDetalleGrupoActivoFijo;
	}

	public void setResaltarFK_IdCuentaContableDepreGastoNormalDetalleGrupoActivoFijo(Border borderResaltar) {
		this.resaltarFK_IdCuentaContableDepreGastoNormalDetalleGrupoActivoFijo= borderResaltar;
	}

	public void setResaltarFK_IdCuentaContableDepreGastoNormalDetalleGrupoActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleGrupoActivoFijoBeanSwingJInternalFrame detallegrupoactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCuentaContableDepreGastoNormalDetalleGrupoActivoFijo= borderResaltar;
	}

	public Border resaltarFK_IdCuentaContableDepreNormalDetalleGrupoActivoFijo=null;

	public Border getResaltarFK_IdCuentaContableDepreNormalDetalleGrupoActivoFijo() {
		return this.resaltarFK_IdCuentaContableDepreNormalDetalleGrupoActivoFijo;
	}

	public void setResaltarFK_IdCuentaContableDepreNormalDetalleGrupoActivoFijo(Border borderResaltar) {
		this.resaltarFK_IdCuentaContableDepreNormalDetalleGrupoActivoFijo= borderResaltar;
	}

	public void setResaltarFK_IdCuentaContableDepreNormalDetalleGrupoActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleGrupoActivoFijoBeanSwingJInternalFrame detallegrupoactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCuentaContableDepreNormalDetalleGrupoActivoFijo= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaDetalleGrupoActivoFijo=null;

	public Border getResaltarFK_IdEmpresaDetalleGrupoActivoFijo() {
		return this.resaltarFK_IdEmpresaDetalleGrupoActivoFijo;
	}

	public void setResaltarFK_IdEmpresaDetalleGrupoActivoFijo(Border borderResaltar) {
		this.resaltarFK_IdEmpresaDetalleGrupoActivoFijo= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaDetalleGrupoActivoFijo(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleGrupoActivoFijoBeanSwingJInternalFrame detallegrupoactivofijoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaDetalleGrupoActivoFijo= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}