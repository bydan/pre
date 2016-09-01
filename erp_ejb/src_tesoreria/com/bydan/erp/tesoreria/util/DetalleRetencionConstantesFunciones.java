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
package com.bydan.erp.tesoreria.util;

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


import com.bydan.erp.tesoreria.util.DetalleRetencionConstantesFunciones;
import com.bydan.erp.tesoreria.util.DetalleRetencionParameterReturnGeneral;
//import com.bydan.erp.tesoreria.util.DetalleRetencionParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.tesoreria.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.tesoreria.business.dataaccess.*;
//import com.bydan.erp.tesoreria.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class DetalleRetencionConstantesFunciones extends DetalleRetencionConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="DetalleRetencion";
	public static final String SPATHOPCION="Tesoreria";	
	public static final String SPATHMODULO="tesoreria/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="DetalleRetencion"+DetalleRetencionConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="DetalleRetencionHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="DetalleRetencionHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=DetalleRetencionConstantesFunciones.SCHEMA+"_"+DetalleRetencionConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/DetalleRetencionHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=DetalleRetencionConstantesFunciones.SCHEMA+"_"+DetalleRetencionConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=DetalleRetencionConstantesFunciones.SCHEMA+"_"+DetalleRetencionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/DetalleRetencionHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=DetalleRetencionConstantesFunciones.SCHEMA+"_"+DetalleRetencionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleRetencionConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DetalleRetencionHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleRetencionConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleRetencionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DetalleRetencionHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetalleRetencionConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=DetalleRetencionConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+DetalleRetencionConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=DetalleRetencionConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+DetalleRetencionConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Detalle Retenciones";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="es";
	public static final String SCLASSWEBTITULO="Detalle Retencion";
	public static final String SCLASSWEBTITULO_LOWER="Detalle Retencion";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="DetalleRetencion";
	public static final String OBJECTNAME="detalleretencion";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_TESORERIA;	
	public static final String TABLENAME="detalle_retencion";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select detalleretencion from "+DetalleRetencionConstantesFunciones.SPERSISTENCENAME+" detalleretencion";
	public static String QUERYSELECTNATIVE="select "+DetalleRetencionConstantesFunciones.SCHEMA+"."+DetalleRetencionConstantesFunciones.TABLENAME+".id,"+DetalleRetencionConstantesFunciones.SCHEMA+"."+DetalleRetencionConstantesFunciones.TABLENAME+".version_row,"+DetalleRetencionConstantesFunciones.SCHEMA+"."+DetalleRetencionConstantesFunciones.TABLENAME+".id_empresa,"+DetalleRetencionConstantesFunciones.SCHEMA+"."+DetalleRetencionConstantesFunciones.TABLENAME+".id_empresa_destino,"+DetalleRetencionConstantesFunciones.SCHEMA+"."+DetalleRetencionConstantesFunciones.TABLENAME+".id_cuenta_contable,"+DetalleRetencionConstantesFunciones.SCHEMA+"."+DetalleRetencionConstantesFunciones.TABLENAME+".id_cuenta_contable_credito,"+DetalleRetencionConstantesFunciones.SCHEMA+"."+DetalleRetencionConstantesFunciones.TABLENAME+".descripcion,"+DetalleRetencionConstantesFunciones.SCHEMA+"."+DetalleRetencionConstantesFunciones.TABLENAME+".porcentaje,"+DetalleRetencionConstantesFunciones.SCHEMA+"."+DetalleRetencionConstantesFunciones.TABLENAME+".monto_minimo from "+DetalleRetencionConstantesFunciones.SCHEMA+"."+DetalleRetencionConstantesFunciones.TABLENAME;//+" as "+DetalleRetencionConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected DetalleRetencionConstantesFuncionesAdditional detalleretencionConstantesFuncionesAdditional=null;
	
	public DetalleRetencionConstantesFuncionesAdditional getDetalleRetencionConstantesFuncionesAdditional() {
		return this.detalleretencionConstantesFuncionesAdditional;
	}
	
	public void setDetalleRetencionConstantesFuncionesAdditional(DetalleRetencionConstantesFuncionesAdditional detalleretencionConstantesFuncionesAdditional) {
		try {
			this.detalleretencionConstantesFuncionesAdditional=detalleretencionConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDEMPRESADESTINO= "id_empresa_destino";
    public static final String IDCUENTACONTABLE= "id_cuenta_contable";
    public static final String IDCUENTACONTABLECREDITO= "id_cuenta_contable_credito";
    public static final String DESCRIPCION= "descripcion";
    public static final String PORCENTAJE= "porcentaje";
    public static final String MONTOMINIMO= "monto_minimo";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDEMPRESADESTINO= "Empresa Destino";
		public static final String LABEL_IDEMPRESADESTINO_LOWER= "Empresa Destino";
    	public static final String LABEL_IDCUENTACONTABLE= "Cuenta Contable";
		public static final String LABEL_IDCUENTACONTABLE_LOWER= "Cuenta Contable";
    	public static final String LABEL_IDCUENTACONTABLECREDITO= "Cuenta Contable Credito";
		public static final String LABEL_IDCUENTACONTABLECREDITO_LOWER= "Cuenta Contable Credito";
    	public static final String LABEL_DESCRIPCION= "Descripcion";
		public static final String LABEL_DESCRIPCION_LOWER= "Descripcion";
    	public static final String LABEL_PORCENTAJE= "Porcentaje";
		public static final String LABEL_PORCENTAJE_LOWER= "Porcentaje";
    	public static final String LABEL_MONTOMINIMO= "Monto Minimo";
		public static final String LABEL_MONTOMINIMO_LOWER= "Monto Minimo";
	
		
		
		
		
		
		
	public static final String SREGEXDESCRIPCION=ConstantesValidacion.SREGEXCADENA;
	public static final String SMENSAJEREGEXDESCRIPCION=ConstantesValidacion.SVALIDACIONCADENA;	
		
		
	
	public static String getDetalleRetencionLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(DetalleRetencionConstantesFunciones.IDEMPRESA)) {sLabelColumna=DetalleRetencionConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(DetalleRetencionConstantesFunciones.IDEMPRESADESTINO)) {sLabelColumna=DetalleRetencionConstantesFunciones.LABEL_IDEMPRESADESTINO;}
		if(sNombreColumna.equals(DetalleRetencionConstantesFunciones.IDCUENTACONTABLE)) {sLabelColumna=DetalleRetencionConstantesFunciones.LABEL_IDCUENTACONTABLE;}
		if(sNombreColumna.equals(DetalleRetencionConstantesFunciones.IDCUENTACONTABLECREDITO)) {sLabelColumna=DetalleRetencionConstantesFunciones.LABEL_IDCUENTACONTABLECREDITO;}
		if(sNombreColumna.equals(DetalleRetencionConstantesFunciones.DESCRIPCION)) {sLabelColumna=DetalleRetencionConstantesFunciones.LABEL_DESCRIPCION;}
		if(sNombreColumna.equals(DetalleRetencionConstantesFunciones.PORCENTAJE)) {sLabelColumna=DetalleRetencionConstantesFunciones.LABEL_PORCENTAJE;}
		if(sNombreColumna.equals(DetalleRetencionConstantesFunciones.MONTOMINIMO)) {sLabelColumna=DetalleRetencionConstantesFunciones.LABEL_MONTOMINIMO;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
	
	public static String getDetalleRetencionDescripcion(DetalleRetencion detalleretencion) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(detalleretencion !=null/* && detalleretencion.getId()!=0*/) {
			if(detalleretencion.getId()!=null) {
				sDescripcion=detalleretencion.getId().toString();
			}//detalleretenciondetalleretencion.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getDetalleRetencionDescripcionDetallado(DetalleRetencion detalleretencion) {
		String sDescripcion="";
			
		sDescripcion+=DetalleRetencionConstantesFunciones.ID+"=";
		sDescripcion+=detalleretencion.getId().toString()+",";
		sDescripcion+=DetalleRetencionConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=detalleretencion.getVersionRow().toString()+",";
		sDescripcion+=DetalleRetencionConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=detalleretencion.getid_empresa().toString()+",";
		sDescripcion+=DetalleRetencionConstantesFunciones.IDEMPRESADESTINO+"=";
		sDescripcion+=detalleretencion.getid_empresa_destino().toString()+",";
		sDescripcion+=DetalleRetencionConstantesFunciones.IDCUENTACONTABLE+"=";
		sDescripcion+=detalleretencion.getid_cuenta_contable().toString()+",";
		sDescripcion+=DetalleRetencionConstantesFunciones.IDCUENTACONTABLECREDITO+"=";
		sDescripcion+=detalleretencion.getid_cuenta_contable_credito().toString()+",";
		sDescripcion+=DetalleRetencionConstantesFunciones.DESCRIPCION+"=";
		sDescripcion+=detalleretencion.getdescripcion()+",";
		sDescripcion+=DetalleRetencionConstantesFunciones.PORCENTAJE+"=";
		sDescripcion+=detalleretencion.getporcentaje().toString()+",";
		sDescripcion+=DetalleRetencionConstantesFunciones.MONTOMINIMO+"=";
		sDescripcion+=detalleretencion.getmonto_minimo().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setDetalleRetencionDescripcion(DetalleRetencion detalleretencion,String sValor) throws Exception {			
		if(detalleretencion !=null) {
			//detalleretenciondetalleretencion.getId().toString();
		}		
	}
	
		

	public static String getEmpresaDescripcion(Empresa empresa) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(empresa!=null/*&&empresa.getId()>0*/) {
			sDescripcion=EmpresaConstantesFunciones.getEmpresaDescripcion(empresa);
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

	public static String getCuentaContableDescripcion(CuentaContable cuentacontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(cuentacontable!=null/*&&cuentacontable.getId()>0*/) {
			sDescripcion=CuentaContableConstantesFunciones.getCuentaContableDescripcion(cuentacontable);
		}

		return sDescripcion;
	}

	public static String getCuentaContableCreditoDescripcion(CuentaContable cuentacontable) {
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
		} else if(sNombreIndice.equals("FK_IdCuentaContable")) {
			sNombreIndice="Tipo=  Por Cuenta Contable";
		} else if(sNombreIndice.equals("FK_IdCuentaContableCredito")) {
			sNombreIndice="Tipo=  Por Cuenta Contable Credito";
		} else if(sNombreIndice.equals("FK_IdDetalleRetencion")) {
			sNombreIndice="Tipo=  Por Empresa Destino";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		}

		return sNombreIndice;
	}	 
	
	

	public static String getDetalleIndicePorId(Long id) {
		return "Parametros->Porid="+id.toString();
	}

	public static String getDetalleIndiceFK_IdCuentaContable(Long id_cuenta_contable) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable!=null) {sDetalleIndice+=" Codigo Unico De Cuenta Contable="+id_cuenta_contable.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContableCredito(Long id_cuenta_contable_credito) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable_credito!=null) {sDetalleIndice+=" Codigo Unico De Cuenta Contable Credito="+id_cuenta_contable_credito.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdDetalleRetencion(Long id_empresa_destino) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa_destino!=null) {sDetalleIndice+=" Codigo Unico De Empresa Destino="+id_empresa_destino.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEmpresa(Long id_empresa) {
		String sDetalleIndice=" Parametros->";
		if(id_empresa!=null) {sDetalleIndice+=" Codigo Unico De Empresa="+id_empresa.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosDetalleRetencion(DetalleRetencion detalleretencion,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		detalleretencion.setdescripcion(detalleretencion.getdescripcion().trim());
	}
	
	public static void quitarEspaciosDetalleRetencions(List<DetalleRetencion> detalleretencions,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(DetalleRetencion detalleretencion: detalleretencions) {
			detalleretencion.setdescripcion(detalleretencion.getdescripcion().trim());
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDetalleRetencion(DetalleRetencion detalleretencion,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && detalleretencion.getConCambioAuxiliar()) {
			detalleretencion.setIsDeleted(detalleretencion.getIsDeletedAuxiliar());	
			detalleretencion.setIsNew(detalleretencion.getIsNewAuxiliar());	
			detalleretencion.setIsChanged(detalleretencion.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			detalleretencion.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			detalleretencion.setIsDeletedAuxiliar(false);	
			detalleretencion.setIsNewAuxiliar(false);	
			detalleretencion.setIsChangedAuxiliar(false);
			
			detalleretencion.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDetalleRetencions(List<DetalleRetencion> detalleretencions,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(DetalleRetencion detalleretencion : detalleretencions) {
			if(conAsignarBase && detalleretencion.getConCambioAuxiliar()) {
				detalleretencion.setIsDeleted(detalleretencion.getIsDeletedAuxiliar());	
				detalleretencion.setIsNew(detalleretencion.getIsNewAuxiliar());	
				detalleretencion.setIsChanged(detalleretencion.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				detalleretencion.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				detalleretencion.setIsDeletedAuxiliar(false);	
				detalleretencion.setIsNewAuxiliar(false);	
				detalleretencion.setIsChangedAuxiliar(false);
				
				detalleretencion.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresDetalleRetencion(DetalleRetencion detalleretencion,Boolean conEnteros) throws Exception  {
		detalleretencion.setporcentaje(0.0);
		detalleretencion.setmonto_minimo(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresDetalleRetencions(List<DetalleRetencion> detalleretencions,Boolean conEnteros) throws Exception  {
		
		for(DetalleRetencion detalleretencion: detalleretencions) {
			detalleretencion.setporcentaje(0.0);
			detalleretencion.setmonto_minimo(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaDetalleRetencion(List<DetalleRetencion> detalleretencions,DetalleRetencion detalleretencionAux) throws Exception  {
		DetalleRetencionConstantesFunciones.InicializarValoresDetalleRetencion(detalleretencionAux,true);
		
		for(DetalleRetencion detalleretencion: detalleretencions) {
			if(detalleretencion.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			detalleretencionAux.setporcentaje(detalleretencionAux.getporcentaje()+detalleretencion.getporcentaje());			
			detalleretencionAux.setmonto_minimo(detalleretencionAux.getmonto_minimo()+detalleretencion.getmonto_minimo());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesDetalleRetencion(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=DetalleRetencionConstantesFunciones.getArrayColumnasGlobalesDetalleRetencion(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesDetalleRetencion(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetalleRetencionConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetalleRetencionConstantesFunciones.IDEMPRESA);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoDetalleRetencion(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<DetalleRetencion> detalleretencions,DetalleRetencion detalleretencion,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(DetalleRetencion detalleretencionAux: detalleretencions) {
			if(detalleretencionAux!=null && detalleretencion!=null) {
				if((detalleretencionAux.getId()==null && detalleretencion.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(detalleretencionAux.getId()!=null && detalleretencion.getId()!=null){
					if(detalleretencionAux.getId().equals(detalleretencion.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaDetalleRetencion(List<DetalleRetencion> detalleretencions) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double porcentajeTotal=0.0;
		Double monto_minimoTotal=0.0;
	
		for(DetalleRetencion detalleretencion: detalleretencions) {			
			if(detalleretencion.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			porcentajeTotal+=detalleretencion.getporcentaje();
			monto_minimoTotal+=detalleretencion.getmonto_minimo();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleRetencionConstantesFunciones.PORCENTAJE);
		datoGeneral.setsDescripcion(DetalleRetencionConstantesFunciones.LABEL_PORCENTAJE);
		datoGeneral.setdValorDouble(porcentajeTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetalleRetencionConstantesFunciones.MONTOMINIMO);
		datoGeneral.setsDescripcion(DetalleRetencionConstantesFunciones.LABEL_MONTOMINIMO);
		datoGeneral.setdValorDouble(monto_minimoTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaDetalleRetencion() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,DetalleRetencionConstantesFunciones.LABEL_ID, DetalleRetencionConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleRetencionConstantesFunciones.LABEL_VERSIONROW, DetalleRetencionConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleRetencionConstantesFunciones.LABEL_IDEMPRESA, DetalleRetencionConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleRetencionConstantesFunciones.LABEL_IDEMPRESADESTINO, DetalleRetencionConstantesFunciones.IDEMPRESADESTINO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleRetencionConstantesFunciones.LABEL_IDCUENTACONTABLE, DetalleRetencionConstantesFunciones.IDCUENTACONTABLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleRetencionConstantesFunciones.LABEL_IDCUENTACONTABLECREDITO, DetalleRetencionConstantesFunciones.IDCUENTACONTABLECREDITO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleRetencionConstantesFunciones.LABEL_DESCRIPCION, DetalleRetencionConstantesFunciones.DESCRIPCION,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleRetencionConstantesFunciones.LABEL_PORCENTAJE, DetalleRetencionConstantesFunciones.PORCENTAJE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetalleRetencionConstantesFunciones.LABEL_MONTOMINIMO, DetalleRetencionConstantesFunciones.MONTOMINIMO,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasDetalleRetencion() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=DetalleRetencionConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleRetencionConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleRetencionConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleRetencionConstantesFunciones.IDEMPRESADESTINO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleRetencionConstantesFunciones.IDCUENTACONTABLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleRetencionConstantesFunciones.IDCUENTACONTABLECREDITO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleRetencionConstantesFunciones.DESCRIPCION;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleRetencionConstantesFunciones.PORCENTAJE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetalleRetencionConstantesFunciones.MONTOMINIMO;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetalleRetencion() throws Exception  {
		return DetalleRetencionConstantesFunciones.getTiposSeleccionarDetalleRetencion(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetalleRetencion(Boolean conFk) throws Exception  {
		return DetalleRetencionConstantesFunciones.getTiposSeleccionarDetalleRetencion(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetalleRetencion(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleRetencionConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(DetalleRetencionConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleRetencionConstantesFunciones.LABEL_IDEMPRESADESTINO);
			reporte.setsDescripcion(DetalleRetencionConstantesFunciones.LABEL_IDEMPRESADESTINO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleRetencionConstantesFunciones.LABEL_IDCUENTACONTABLE);
			reporte.setsDescripcion(DetalleRetencionConstantesFunciones.LABEL_IDCUENTACONTABLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleRetencionConstantesFunciones.LABEL_IDCUENTACONTABLECREDITO);
			reporte.setsDescripcion(DetalleRetencionConstantesFunciones.LABEL_IDCUENTACONTABLECREDITO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conStringColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleRetencionConstantesFunciones.LABEL_DESCRIPCION);
			reporte.setsDescripcion(DetalleRetencionConstantesFunciones.LABEL_DESCRIPCION);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleRetencionConstantesFunciones.LABEL_PORCENTAJE);
			reporte.setsDescripcion(DetalleRetencionConstantesFunciones.LABEL_PORCENTAJE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetalleRetencionConstantesFunciones.LABEL_MONTOMINIMO);
			reporte.setsDescripcion(DetalleRetencionConstantesFunciones.LABEL_MONTOMINIMO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesDetalleRetencion(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesDetalleRetencion(DetalleRetencion detalleretencionAux) throws Exception {
		
			detalleretencionAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(detalleretencionAux.getEmpresa()));
			detalleretencionAux.setempresadestino_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(detalleretencionAux.getEmpresaDestino()));
			detalleretencionAux.setcuentacontable_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(detalleretencionAux.getCuentaContable()));
			detalleretencionAux.setcuentacontablecredito_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(detalleretencionAux.getCuentaContableCredito()));		
	}
	
	public static void refrescarForeignKeysDescripcionesDetalleRetencion(List<DetalleRetencion> detalleretencionsTemp) throws Exception {
		for(DetalleRetencion detalleretencionAux:detalleretencionsTemp) {
			
			detalleretencionAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(detalleretencionAux.getEmpresa()));
			detalleretencionAux.setempresadestino_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(detalleretencionAux.getEmpresaDestino()));
			detalleretencionAux.setcuentacontable_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(detalleretencionAux.getCuentaContable()));
			detalleretencionAux.setcuentacontablecredito_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(detalleretencionAux.getCuentaContableCredito()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfDetalleRetencion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(CuentaContable.class));
				classes.add(new Classe(CuentaContable.class));
				
			} else if(deepLoadType.equals(DeepLoadType.INCLUDE)) {
				
				for(Classe clas:classesP) {
					if(clas.clas.equals(Empresa.class)) {
						classes.add(new Classe(Empresa.class));
					}
				}

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

				
			} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {					
			}
			
			return classes;
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfDetalleRetencion(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				

				for(String sClasse:arrClasses) {

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
					}

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
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

					if(Empresa.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Empresa.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetalleRetencion(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return DetalleRetencionConstantesFunciones.getClassesRelationshipsOfDetalleRetencion(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetalleRetencion(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDetalleRetencion(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return DetalleRetencionConstantesFunciones.getClassesRelationshipsFromStringsOfDetalleRetencion(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDetalleRetencion(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(DetalleRetencion detalleretencion,List<DetalleRetencion> detalleretencions,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			DetalleRetencion detalleretencionEncontrado=null;
			
			for(DetalleRetencion detalleretencionLocal:detalleretencions) {
				if(detalleretencionLocal.getId().equals(detalleretencion.getId())) {
					detalleretencionEncontrado=detalleretencionLocal;
					
					detalleretencionLocal.setIsChanged(detalleretencion.getIsChanged());
					detalleretencionLocal.setIsNew(detalleretencion.getIsNew());
					detalleretencionLocal.setIsDeleted(detalleretencion.getIsDeleted());
					
					detalleretencionLocal.setGeneralEntityOriginal(detalleretencion.getGeneralEntityOriginal());
					
					detalleretencionLocal.setId(detalleretencion.getId());	
					detalleretencionLocal.setVersionRow(detalleretencion.getVersionRow());	
					detalleretencionLocal.setid_empresa(detalleretencion.getid_empresa());	
					detalleretencionLocal.setid_empresa_destino(detalleretencion.getid_empresa_destino());	
					detalleretencionLocal.setid_cuenta_contable(detalleretencion.getid_cuenta_contable());	
					detalleretencionLocal.setid_cuenta_contable_credito(detalleretencion.getid_cuenta_contable_credito());	
					detalleretencionLocal.setdescripcion(detalleretencion.getdescripcion());	
					detalleretencionLocal.setporcentaje(detalleretencion.getporcentaje());	
					detalleretencionLocal.setmonto_minimo(detalleretencion.getmonto_minimo());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!detalleretencion.getIsDeleted()) {
				if(!existe) {
					detalleretencions.add(detalleretencion);
				}
			} else {
				if(detalleretencionEncontrado!=null && permiteQuitar)  {
					detalleretencions.remove(detalleretencionEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(DetalleRetencion detalleretencion,List<DetalleRetencion> detalleretencions) throws Exception {
		try	{			
			for(DetalleRetencion detalleretencionLocal:detalleretencions) {
				if(detalleretencionLocal.getId().equals(detalleretencion.getId())) {
					detalleretencionLocal.setIsSelected(detalleretencion.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesDetalleRetencion(List<DetalleRetencion> detalleretencionsAux) throws Exception {
		//this.detalleretencionsAux=detalleretencionsAux;
		
		for(DetalleRetencion detalleretencionAux:detalleretencionsAux) {
			if(detalleretencionAux.getIsChanged()) {
				detalleretencionAux.setIsChanged(false);
			}		
			
			if(detalleretencionAux.getIsNew()) {
				detalleretencionAux.setIsNew(false);
			}	
			
			if(detalleretencionAux.getIsDeleted()) {
				detalleretencionAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesDetalleRetencion(DetalleRetencion detalleretencionAux) throws Exception {
		//this.detalleretencionAux=detalleretencionAux;
		
			if(detalleretencionAux.getIsChanged()) {
				detalleretencionAux.setIsChanged(false);
			}		
			
			if(detalleretencionAux.getIsNew()) {
				detalleretencionAux.setIsNew(false);
			}	
			
			if(detalleretencionAux.getIsDeleted()) {
				detalleretencionAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(DetalleRetencion detalleretencionAsignar,DetalleRetencion detalleretencion) throws Exception {
		detalleretencionAsignar.setId(detalleretencion.getId());	
		detalleretencionAsignar.setVersionRow(detalleretencion.getVersionRow());	
		detalleretencionAsignar.setid_empresa(detalleretencion.getid_empresa());
		detalleretencionAsignar.setempresa_descripcion(detalleretencion.getempresa_descripcion());	
		detalleretencionAsignar.setid_empresa_destino(detalleretencion.getid_empresa_destino());
		detalleretencionAsignar.setempresadestino_descripcion(detalleretencion.getempresadestino_descripcion());	
		detalleretencionAsignar.setid_cuenta_contable(detalleretencion.getid_cuenta_contable());
		detalleretencionAsignar.setcuentacontable_descripcion(detalleretencion.getcuentacontable_descripcion());	
		detalleretencionAsignar.setid_cuenta_contable_credito(detalleretencion.getid_cuenta_contable_credito());
		detalleretencionAsignar.setcuentacontablecredito_descripcion(detalleretencion.getcuentacontablecredito_descripcion());	
		detalleretencionAsignar.setdescripcion(detalleretencion.getdescripcion());	
		detalleretencionAsignar.setporcentaje(detalleretencion.getporcentaje());	
		detalleretencionAsignar.setmonto_minimo(detalleretencion.getmonto_minimo());	
	}
	
	public static void inicializarDetalleRetencion(DetalleRetencion detalleretencion) throws Exception {
		try {
				detalleretencion.setId(0L);	
					
				detalleretencion.setid_empresa(-1L);	
				detalleretencion.setid_empresa_destino(-1L);	
				detalleretencion.setid_cuenta_contable(-1L);	
				detalleretencion.setid_cuenta_contable_credito(-1L);	
				detalleretencion.setdescripcion("");	
				detalleretencion.setporcentaje(0.0);	
				detalleretencion.setmonto_minimo(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderDetalleRetencion(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleRetencionConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleRetencionConstantesFunciones.LABEL_IDEMPRESADESTINO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleRetencionConstantesFunciones.LABEL_IDCUENTACONTABLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleRetencionConstantesFunciones.LABEL_IDCUENTACONTABLECREDITO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleRetencionConstantesFunciones.LABEL_DESCRIPCION);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleRetencionConstantesFunciones.LABEL_PORCENTAJE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetalleRetencionConstantesFunciones.LABEL_MONTOMINIMO);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataDetalleRetencion(String sTipo,Row row,Workbook workbook,DetalleRetencion detalleretencion,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleretencion.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleretencion.getempresadestino_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleretencion.getcuentacontable_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleretencion.getcuentacontablecredito_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleretencion.getdescripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleretencion.getporcentaje());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detalleretencion.getmonto_minimo());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryDetalleRetencion=Constantes.SFINALQUERY;
	
	public String getsFinalQueryDetalleRetencion() {
		return this.sFinalQueryDetalleRetencion;
	}
	
	public void setsFinalQueryDetalleRetencion(String sFinalQueryDetalleRetencion) {
		this.sFinalQueryDetalleRetencion= sFinalQueryDetalleRetencion;
	}
	
	public Border resaltarSeleccionarDetalleRetencion=null;
	
	public Border setResaltarSeleccionarDetalleRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleRetencionBeanSwingJInternalFrame detalleretencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//detalleretencionBeanSwingJInternalFrame.jTtoolBarDetalleRetencion.setBorder(borderResaltar);
		
		this.resaltarSeleccionarDetalleRetencion= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarDetalleRetencion() {
		return this.resaltarSeleccionarDetalleRetencion;
	}
	
	public void setResaltarSeleccionarDetalleRetencion(Border borderResaltarSeleccionarDetalleRetencion) {
		this.resaltarSeleccionarDetalleRetencion= borderResaltarSeleccionarDetalleRetencion;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridDetalleRetencion=null;
	public Boolean mostraridDetalleRetencion=true;
	public Boolean activaridDetalleRetencion=true;

	public Border resaltarid_empresaDetalleRetencion=null;
	public Boolean mostrarid_empresaDetalleRetencion=true;
	public Boolean activarid_empresaDetalleRetencion=true;
	public Boolean cargarid_empresaDetalleRetencion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaDetalleRetencion=false;//ConEventDepend=true

	public Border resaltarid_empresa_destinoDetalleRetencion=null;
	public Boolean mostrarid_empresa_destinoDetalleRetencion=true;
	public Boolean activarid_empresa_destinoDetalleRetencion=true;
	public Boolean cargarid_empresa_destinoDetalleRetencion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresa_destinoDetalleRetencion=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contableDetalleRetencion=null;
	public Boolean mostrarid_cuenta_contableDetalleRetencion=true;
	public Boolean activarid_cuenta_contableDetalleRetencion=true;
	public Boolean cargarid_cuenta_contableDetalleRetencion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contableDetalleRetencion=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contable_creditoDetalleRetencion=null;
	public Boolean mostrarid_cuenta_contable_creditoDetalleRetencion=true;
	public Boolean activarid_cuenta_contable_creditoDetalleRetencion=true;
	public Boolean cargarid_cuenta_contable_creditoDetalleRetencion=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contable_creditoDetalleRetencion=false;//ConEventDepend=true

	public Border resaltardescripcionDetalleRetencion=null;
	public Boolean mostrardescripcionDetalleRetencion=true;
	public Boolean activardescripcionDetalleRetencion=true;

	public Border resaltarporcentajeDetalleRetencion=null;
	public Boolean mostrarporcentajeDetalleRetencion=true;
	public Boolean activarporcentajeDetalleRetencion=true;

	public Border resaltarmonto_minimoDetalleRetencion=null;
	public Boolean mostrarmonto_minimoDetalleRetencion=true;
	public Boolean activarmonto_minimoDetalleRetencion=true;

	
	

	public Border setResaltaridDetalleRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleRetencionBeanSwingJInternalFrame detalleretencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleretencionBeanSwingJInternalFrame.jTtoolBarDetalleRetencion.setBorder(borderResaltar);
		
		this.resaltaridDetalleRetencion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridDetalleRetencion() {
		return this.resaltaridDetalleRetencion;
	}

	public void setResaltaridDetalleRetencion(Border borderResaltar) {
		this.resaltaridDetalleRetencion= borderResaltar;
	}

	public Boolean getMostraridDetalleRetencion() {
		return this.mostraridDetalleRetencion;
	}

	public void setMostraridDetalleRetencion(Boolean mostraridDetalleRetencion) {
		this.mostraridDetalleRetencion= mostraridDetalleRetencion;
	}

	public Boolean getActivaridDetalleRetencion() {
		return this.activaridDetalleRetencion;
	}

	public void setActivaridDetalleRetencion(Boolean activaridDetalleRetencion) {
		this.activaridDetalleRetencion= activaridDetalleRetencion;
	}

	public Border setResaltarid_empresaDetalleRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleRetencionBeanSwingJInternalFrame detalleretencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleretencionBeanSwingJInternalFrame.jTtoolBarDetalleRetencion.setBorder(borderResaltar);
		
		this.resaltarid_empresaDetalleRetencion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaDetalleRetencion() {
		return this.resaltarid_empresaDetalleRetencion;
	}

	public void setResaltarid_empresaDetalleRetencion(Border borderResaltar) {
		this.resaltarid_empresaDetalleRetencion= borderResaltar;
	}

	public Boolean getMostrarid_empresaDetalleRetencion() {
		return this.mostrarid_empresaDetalleRetencion;
	}

	public void setMostrarid_empresaDetalleRetencion(Boolean mostrarid_empresaDetalleRetencion) {
		this.mostrarid_empresaDetalleRetencion= mostrarid_empresaDetalleRetencion;
	}

	public Boolean getActivarid_empresaDetalleRetencion() {
		return this.activarid_empresaDetalleRetencion;
	}

	public void setActivarid_empresaDetalleRetencion(Boolean activarid_empresaDetalleRetencion) {
		this.activarid_empresaDetalleRetencion= activarid_empresaDetalleRetencion;
	}

	public Boolean getCargarid_empresaDetalleRetencion() {
		return this.cargarid_empresaDetalleRetencion;
	}

	public void setCargarid_empresaDetalleRetencion(Boolean cargarid_empresaDetalleRetencion) {
		this.cargarid_empresaDetalleRetencion= cargarid_empresaDetalleRetencion;
	}

	public Border setResaltarid_empresa_destinoDetalleRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleRetencionBeanSwingJInternalFrame detalleretencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleretencionBeanSwingJInternalFrame.jTtoolBarDetalleRetencion.setBorder(borderResaltar);
		
		this.resaltarid_empresa_destinoDetalleRetencion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresa_destinoDetalleRetencion() {
		return this.resaltarid_empresa_destinoDetalleRetencion;
	}

	public void setResaltarid_empresa_destinoDetalleRetencion(Border borderResaltar) {
		this.resaltarid_empresa_destinoDetalleRetencion= borderResaltar;
	}

	public Boolean getMostrarid_empresa_destinoDetalleRetencion() {
		return this.mostrarid_empresa_destinoDetalleRetencion;
	}

	public void setMostrarid_empresa_destinoDetalleRetencion(Boolean mostrarid_empresa_destinoDetalleRetencion) {
		this.mostrarid_empresa_destinoDetalleRetencion= mostrarid_empresa_destinoDetalleRetencion;
	}

	public Boolean getActivarid_empresa_destinoDetalleRetencion() {
		return this.activarid_empresa_destinoDetalleRetencion;
	}

	public void setActivarid_empresa_destinoDetalleRetencion(Boolean activarid_empresa_destinoDetalleRetencion) {
		this.activarid_empresa_destinoDetalleRetencion= activarid_empresa_destinoDetalleRetencion;
	}

	public Boolean getCargarid_empresa_destinoDetalleRetencion() {
		return this.cargarid_empresa_destinoDetalleRetencion;
	}

	public void setCargarid_empresa_destinoDetalleRetencion(Boolean cargarid_empresa_destinoDetalleRetencion) {
		this.cargarid_empresa_destinoDetalleRetencion= cargarid_empresa_destinoDetalleRetencion;
	}

	public Border setResaltarid_cuenta_contableDetalleRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleRetencionBeanSwingJInternalFrame detalleretencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleretencionBeanSwingJInternalFrame.jTtoolBarDetalleRetencion.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contableDetalleRetencion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contableDetalleRetencion() {
		return this.resaltarid_cuenta_contableDetalleRetencion;
	}

	public void setResaltarid_cuenta_contableDetalleRetencion(Border borderResaltar) {
		this.resaltarid_cuenta_contableDetalleRetencion= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contableDetalleRetencion() {
		return this.mostrarid_cuenta_contableDetalleRetencion;
	}

	public void setMostrarid_cuenta_contableDetalleRetencion(Boolean mostrarid_cuenta_contableDetalleRetencion) {
		this.mostrarid_cuenta_contableDetalleRetencion= mostrarid_cuenta_contableDetalleRetencion;
	}

	public Boolean getActivarid_cuenta_contableDetalleRetencion() {
		return this.activarid_cuenta_contableDetalleRetencion;
	}

	public void setActivarid_cuenta_contableDetalleRetencion(Boolean activarid_cuenta_contableDetalleRetencion) {
		this.activarid_cuenta_contableDetalleRetencion= activarid_cuenta_contableDetalleRetencion;
	}

	public Boolean getCargarid_cuenta_contableDetalleRetencion() {
		return this.cargarid_cuenta_contableDetalleRetencion;
	}

	public void setCargarid_cuenta_contableDetalleRetencion(Boolean cargarid_cuenta_contableDetalleRetencion) {
		this.cargarid_cuenta_contableDetalleRetencion= cargarid_cuenta_contableDetalleRetencion;
	}

	public Border setResaltarid_cuenta_contable_creditoDetalleRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleRetencionBeanSwingJInternalFrame detalleretencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleretencionBeanSwingJInternalFrame.jTtoolBarDetalleRetencion.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contable_creditoDetalleRetencion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contable_creditoDetalleRetencion() {
		return this.resaltarid_cuenta_contable_creditoDetalleRetencion;
	}

	public void setResaltarid_cuenta_contable_creditoDetalleRetencion(Border borderResaltar) {
		this.resaltarid_cuenta_contable_creditoDetalleRetencion= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contable_creditoDetalleRetencion() {
		return this.mostrarid_cuenta_contable_creditoDetalleRetencion;
	}

	public void setMostrarid_cuenta_contable_creditoDetalleRetencion(Boolean mostrarid_cuenta_contable_creditoDetalleRetencion) {
		this.mostrarid_cuenta_contable_creditoDetalleRetencion= mostrarid_cuenta_contable_creditoDetalleRetencion;
	}

	public Boolean getActivarid_cuenta_contable_creditoDetalleRetencion() {
		return this.activarid_cuenta_contable_creditoDetalleRetencion;
	}

	public void setActivarid_cuenta_contable_creditoDetalleRetencion(Boolean activarid_cuenta_contable_creditoDetalleRetencion) {
		this.activarid_cuenta_contable_creditoDetalleRetencion= activarid_cuenta_contable_creditoDetalleRetencion;
	}

	public Boolean getCargarid_cuenta_contable_creditoDetalleRetencion() {
		return this.cargarid_cuenta_contable_creditoDetalleRetencion;
	}

	public void setCargarid_cuenta_contable_creditoDetalleRetencion(Boolean cargarid_cuenta_contable_creditoDetalleRetencion) {
		this.cargarid_cuenta_contable_creditoDetalleRetencion= cargarid_cuenta_contable_creditoDetalleRetencion;
	}

	public Border setResaltardescripcionDetalleRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleRetencionBeanSwingJInternalFrame detalleretencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleretencionBeanSwingJInternalFrame.jTtoolBarDetalleRetencion.setBorder(borderResaltar);
		
		this.resaltardescripcionDetalleRetencion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltardescripcionDetalleRetencion() {
		return this.resaltardescripcionDetalleRetencion;
	}

	public void setResaltardescripcionDetalleRetencion(Border borderResaltar) {
		this.resaltardescripcionDetalleRetencion= borderResaltar;
	}

	public Boolean getMostrardescripcionDetalleRetencion() {
		return this.mostrardescripcionDetalleRetencion;
	}

	public void setMostrardescripcionDetalleRetencion(Boolean mostrardescripcionDetalleRetencion) {
		this.mostrardescripcionDetalleRetencion= mostrardescripcionDetalleRetencion;
	}

	public Boolean getActivardescripcionDetalleRetencion() {
		return this.activardescripcionDetalleRetencion;
	}

	public void setActivardescripcionDetalleRetencion(Boolean activardescripcionDetalleRetencion) {
		this.activardescripcionDetalleRetencion= activardescripcionDetalleRetencion;
	}

	public Border setResaltarporcentajeDetalleRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleRetencionBeanSwingJInternalFrame detalleretencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleretencionBeanSwingJInternalFrame.jTtoolBarDetalleRetencion.setBorder(borderResaltar);
		
		this.resaltarporcentajeDetalleRetencion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarporcentajeDetalleRetencion() {
		return this.resaltarporcentajeDetalleRetencion;
	}

	public void setResaltarporcentajeDetalleRetencion(Border borderResaltar) {
		this.resaltarporcentajeDetalleRetencion= borderResaltar;
	}

	public Boolean getMostrarporcentajeDetalleRetencion() {
		return this.mostrarporcentajeDetalleRetencion;
	}

	public void setMostrarporcentajeDetalleRetencion(Boolean mostrarporcentajeDetalleRetencion) {
		this.mostrarporcentajeDetalleRetencion= mostrarporcentajeDetalleRetencion;
	}

	public Boolean getActivarporcentajeDetalleRetencion() {
		return this.activarporcentajeDetalleRetencion;
	}

	public void setActivarporcentajeDetalleRetencion(Boolean activarporcentajeDetalleRetencion) {
		this.activarporcentajeDetalleRetencion= activarporcentajeDetalleRetencion;
	}

	public Border setResaltarmonto_minimoDetalleRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleRetencionBeanSwingJInternalFrame detalleretencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detalleretencionBeanSwingJInternalFrame.jTtoolBarDetalleRetencion.setBorder(borderResaltar);
		
		this.resaltarmonto_minimoDetalleRetencion= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarmonto_minimoDetalleRetencion() {
		return this.resaltarmonto_minimoDetalleRetencion;
	}

	public void setResaltarmonto_minimoDetalleRetencion(Border borderResaltar) {
		this.resaltarmonto_minimoDetalleRetencion= borderResaltar;
	}

	public Boolean getMostrarmonto_minimoDetalleRetencion() {
		return this.mostrarmonto_minimoDetalleRetencion;
	}

	public void setMostrarmonto_minimoDetalleRetencion(Boolean mostrarmonto_minimoDetalleRetencion) {
		this.mostrarmonto_minimoDetalleRetencion= mostrarmonto_minimoDetalleRetencion;
	}

	public Boolean getActivarmonto_minimoDetalleRetencion() {
		return this.activarmonto_minimoDetalleRetencion;
	}

	public void setActivarmonto_minimoDetalleRetencion(Boolean activarmonto_minimoDetalleRetencion) {
		this.activarmonto_minimoDetalleRetencion= activarmonto_minimoDetalleRetencion;
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
		
		
		this.setMostraridDetalleRetencion(esInicial);
		this.setMostrarid_empresaDetalleRetencion(esInicial);
		this.setMostrarid_empresa_destinoDetalleRetencion(esInicial);
		this.setMostrarid_cuenta_contableDetalleRetencion(esInicial);
		this.setMostrarid_cuenta_contable_creditoDetalleRetencion(esInicial);
		this.setMostrardescripcionDetalleRetencion(esInicial);
		this.setMostrarporcentajeDetalleRetencion(esInicial);
		this.setMostrarmonto_minimoDetalleRetencion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetalleRetencionConstantesFunciones.ID)) {
				this.setMostraridDetalleRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleRetencionConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaDetalleRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleRetencionConstantesFunciones.IDEMPRESADESTINO)) {
				this.setMostrarid_empresa_destinoDetalleRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleRetencionConstantesFunciones.IDCUENTACONTABLE)) {
				this.setMostrarid_cuenta_contableDetalleRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleRetencionConstantesFunciones.IDCUENTACONTABLECREDITO)) {
				this.setMostrarid_cuenta_contable_creditoDetalleRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleRetencionConstantesFunciones.DESCRIPCION)) {
				this.setMostrardescripcionDetalleRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleRetencionConstantesFunciones.PORCENTAJE)) {
				this.setMostrarporcentajeDetalleRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleRetencionConstantesFunciones.MONTOMINIMO)) {
				this.setMostrarmonto_minimoDetalleRetencion(esAsigna);
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
		
		
		this.setActivaridDetalleRetencion(esInicial);
		this.setActivarid_empresaDetalleRetencion(esInicial);
		this.setActivarid_empresa_destinoDetalleRetencion(esInicial);
		this.setActivarid_cuenta_contableDetalleRetencion(esInicial);
		this.setActivarid_cuenta_contable_creditoDetalleRetencion(esInicial);
		this.setActivardescripcionDetalleRetencion(esInicial);
		this.setActivarporcentajeDetalleRetencion(esInicial);
		this.setActivarmonto_minimoDetalleRetencion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetalleRetencionConstantesFunciones.ID)) {
				this.setActivaridDetalleRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleRetencionConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaDetalleRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleRetencionConstantesFunciones.IDEMPRESADESTINO)) {
				this.setActivarid_empresa_destinoDetalleRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleRetencionConstantesFunciones.IDCUENTACONTABLE)) {
				this.setActivarid_cuenta_contableDetalleRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleRetencionConstantesFunciones.IDCUENTACONTABLECREDITO)) {
				this.setActivarid_cuenta_contable_creditoDetalleRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleRetencionConstantesFunciones.DESCRIPCION)) {
				this.setActivardescripcionDetalleRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleRetencionConstantesFunciones.PORCENTAJE)) {
				this.setActivarporcentajeDetalleRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleRetencionConstantesFunciones.MONTOMINIMO)) {
				this.setActivarmonto_minimoDetalleRetencion(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,DetalleRetencionBeanSwingJInternalFrame detalleretencionBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridDetalleRetencion(esInicial);
		this.setResaltarid_empresaDetalleRetencion(esInicial);
		this.setResaltarid_empresa_destinoDetalleRetencion(esInicial);
		this.setResaltarid_cuenta_contableDetalleRetencion(esInicial);
		this.setResaltarid_cuenta_contable_creditoDetalleRetencion(esInicial);
		this.setResaltardescripcionDetalleRetencion(esInicial);
		this.setResaltarporcentajeDetalleRetencion(esInicial);
		this.setResaltarmonto_minimoDetalleRetencion(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetalleRetencionConstantesFunciones.ID)) {
				this.setResaltaridDetalleRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleRetencionConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaDetalleRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleRetencionConstantesFunciones.IDEMPRESADESTINO)) {
				this.setResaltarid_empresa_destinoDetalleRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleRetencionConstantesFunciones.IDCUENTACONTABLE)) {
				this.setResaltarid_cuenta_contableDetalleRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleRetencionConstantesFunciones.IDCUENTACONTABLECREDITO)) {
				this.setResaltarid_cuenta_contable_creditoDetalleRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleRetencionConstantesFunciones.DESCRIPCION)) {
				this.setResaltardescripcionDetalleRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleRetencionConstantesFunciones.PORCENTAJE)) {
				this.setResaltarporcentajeDetalleRetencion(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetalleRetencionConstantesFunciones.MONTOMINIMO)) {
				this.setResaltarmonto_minimoDetalleRetencion(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,DetalleRetencionBeanSwingJInternalFrame detalleretencionBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdCuentaContableDetalleRetencion=true;

	public Boolean getMostrarFK_IdCuentaContableDetalleRetencion() {
		return this.mostrarFK_IdCuentaContableDetalleRetencion;
	}

	public void setMostrarFK_IdCuentaContableDetalleRetencion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCuentaContableDetalleRetencion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCuentaContableCreditoDetalleRetencion=true;

	public Boolean getMostrarFK_IdCuentaContableCreditoDetalleRetencion() {
		return this.mostrarFK_IdCuentaContableCreditoDetalleRetencion;
	}

	public void setMostrarFK_IdCuentaContableCreditoDetalleRetencion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCuentaContableCreditoDetalleRetencion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdDetalleRetencionDetalleRetencion=true;

	public Boolean getMostrarFK_IdDetalleRetencionDetalleRetencion() {
		return this.mostrarFK_IdDetalleRetencionDetalleRetencion;
	}

	public void setMostrarFK_IdDetalleRetencionDetalleRetencion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdDetalleRetencionDetalleRetencion= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaDetalleRetencion=true;

	public Boolean getMostrarFK_IdEmpresaDetalleRetencion() {
		return this.mostrarFK_IdEmpresaDetalleRetencion;
	}

	public void setMostrarFK_IdEmpresaDetalleRetencion(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaDetalleRetencion= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdCuentaContableDetalleRetencion=true;

	public Boolean getActivarFK_IdCuentaContableDetalleRetencion() {
		return this.activarFK_IdCuentaContableDetalleRetencion;
	}

	public void setActivarFK_IdCuentaContableDetalleRetencion(Boolean habilitarResaltar) {
		this.activarFK_IdCuentaContableDetalleRetencion= habilitarResaltar;
	}

	public Boolean activarFK_IdCuentaContableCreditoDetalleRetencion=true;

	public Boolean getActivarFK_IdCuentaContableCreditoDetalleRetencion() {
		return this.activarFK_IdCuentaContableCreditoDetalleRetencion;
	}

	public void setActivarFK_IdCuentaContableCreditoDetalleRetencion(Boolean habilitarResaltar) {
		this.activarFK_IdCuentaContableCreditoDetalleRetencion= habilitarResaltar;
	}

	public Boolean activarFK_IdDetalleRetencionDetalleRetencion=true;

	public Boolean getActivarFK_IdDetalleRetencionDetalleRetencion() {
		return this.activarFK_IdDetalleRetencionDetalleRetencion;
	}

	public void setActivarFK_IdDetalleRetencionDetalleRetencion(Boolean habilitarResaltar) {
		this.activarFK_IdDetalleRetencionDetalleRetencion= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaDetalleRetencion=true;

	public Boolean getActivarFK_IdEmpresaDetalleRetencion() {
		return this.activarFK_IdEmpresaDetalleRetencion;
	}

	public void setActivarFK_IdEmpresaDetalleRetencion(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaDetalleRetencion= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdCuentaContableDetalleRetencion=null;

	public Border getResaltarFK_IdCuentaContableDetalleRetencion() {
		return this.resaltarFK_IdCuentaContableDetalleRetencion;
	}

	public void setResaltarFK_IdCuentaContableDetalleRetencion(Border borderResaltar) {
		this.resaltarFK_IdCuentaContableDetalleRetencion= borderResaltar;
	}

	public void setResaltarFK_IdCuentaContableDetalleRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleRetencionBeanSwingJInternalFrame detalleretencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCuentaContableDetalleRetencion= borderResaltar;
	}

	public Border resaltarFK_IdCuentaContableCreditoDetalleRetencion=null;

	public Border getResaltarFK_IdCuentaContableCreditoDetalleRetencion() {
		return this.resaltarFK_IdCuentaContableCreditoDetalleRetencion;
	}

	public void setResaltarFK_IdCuentaContableCreditoDetalleRetencion(Border borderResaltar) {
		this.resaltarFK_IdCuentaContableCreditoDetalleRetencion= borderResaltar;
	}

	public void setResaltarFK_IdCuentaContableCreditoDetalleRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleRetencionBeanSwingJInternalFrame detalleretencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCuentaContableCreditoDetalleRetencion= borderResaltar;
	}

	public Border resaltarFK_IdDetalleRetencionDetalleRetencion=null;

	public Border getResaltarFK_IdDetalleRetencionDetalleRetencion() {
		return this.resaltarFK_IdDetalleRetencionDetalleRetencion;
	}

	public void setResaltarFK_IdDetalleRetencionDetalleRetencion(Border borderResaltar) {
		this.resaltarFK_IdDetalleRetencionDetalleRetencion= borderResaltar;
	}

	public void setResaltarFK_IdDetalleRetencionDetalleRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleRetencionBeanSwingJInternalFrame detalleretencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdDetalleRetencionDetalleRetencion= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaDetalleRetencion=null;

	public Border getResaltarFK_IdEmpresaDetalleRetencion() {
		return this.resaltarFK_IdEmpresaDetalleRetencion;
	}

	public void setResaltarFK_IdEmpresaDetalleRetencion(Border borderResaltar) {
		this.resaltarFK_IdEmpresaDetalleRetencion= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaDetalleRetencion(ParametroGeneralUsuario parametroGeneralUsuario/*DetalleRetencionBeanSwingJInternalFrame detalleretencionBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaDetalleRetencion= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}