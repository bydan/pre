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


import com.bydan.erp.activosfijos.util.GastoDepreciacionCentroCostoConstantesFunciones;
import com.bydan.erp.activosfijos.util.GastoDepreciacionCentroCostoParameterReturnGeneral;
//import com.bydan.erp.activosfijos.util.GastoDepreciacionCentroCostoParameterGeneral;

import com.bydan.framework.erp.business.logic.DatosCliente;
import com.bydan.framework.erp.util.*;

import com.bydan.erp.activosfijos.business.entity.*;



import com.bydan.erp.seguridad.business.entity.*;
import com.bydan.erp.contabilidad.business.entity.*;


import com.bydan.erp.seguridad.util.*;
import com.bydan.erp.contabilidad.util.*;



//import com.bydan.framework.erp.util.*;
//import com.bydan.framework.erp.business.logic.*;
//import com.bydan.erp.activosfijos.business.dataaccess.*;
//import com.bydan.erp.activosfijos.business.logic.*;
//import java.sql.SQLException;

//CONTROL_INCLUDE
import com.bydan.erp.seguridad.business.entity.*;



@SuppressWarnings("unused")
final public class GastoDepreciacionCentroCostoConstantesFunciones extends GastoDepreciacionCentroCostoConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="GastoDepreciacionCentroCosto";
	public static final String SPATHOPCION="ActivosFijos";	
	public static final String SPATHMODULO="activosfijos/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="GastoDepreciacionCentroCosto"+GastoDepreciacionCentroCostoConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="GastoDepreciacionCentroCostoHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="GastoDepreciacionCentroCostoHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=GastoDepreciacionCentroCostoConstantesFunciones.SCHEMA+"_"+GastoDepreciacionCentroCostoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/GastoDepreciacionCentroCostoHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=GastoDepreciacionCentroCostoConstantesFunciones.SCHEMA+"_"+GastoDepreciacionCentroCostoConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=GastoDepreciacionCentroCostoConstantesFunciones.SCHEMA+"_"+GastoDepreciacionCentroCostoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/GastoDepreciacionCentroCostoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=GastoDepreciacionCentroCostoConstantesFunciones.SCHEMA+"_"+GastoDepreciacionCentroCostoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+GastoDepreciacionCentroCostoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/GastoDepreciacionCentroCostoHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+GastoDepreciacionCentroCostoConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+GastoDepreciacionCentroCostoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/GastoDepreciacionCentroCostoHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+GastoDepreciacionCentroCostoConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=GastoDepreciacionCentroCostoConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+GastoDepreciacionCentroCostoConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=GastoDepreciacionCentroCostoConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+GastoDepreciacionCentroCostoConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Gasto Depreciacion Centro Costos";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Gasto Depreciacion Centro Costo";
	public static final String SCLASSWEBTITULO_LOWER="Gasto Depreciacion Centro Costo";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="GastoDepreciacionCentroCosto";
	public static final String OBJECTNAME="gastodepreciacioncentrocosto";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_ACTIVOSFIJOS;	
	public static final String TABLENAME="gasto_depreciacion_centro_costo";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select gastodepreciacioncentrocosto from "+GastoDepreciacionCentroCostoConstantesFunciones.SPERSISTENCENAME+" gastodepreciacioncentrocosto";
	public static String QUERYSELECTNATIVE="select "+GastoDepreciacionCentroCostoConstantesFunciones.SCHEMA+"."+GastoDepreciacionCentroCostoConstantesFunciones.TABLENAME+".id,"+GastoDepreciacionCentroCostoConstantesFunciones.SCHEMA+"."+GastoDepreciacionCentroCostoConstantesFunciones.TABLENAME+".version_row,"+GastoDepreciacionCentroCostoConstantesFunciones.SCHEMA+"."+GastoDepreciacionCentroCostoConstantesFunciones.TABLENAME+".id_empresa,"+GastoDepreciacionCentroCostoConstantesFunciones.SCHEMA+"."+GastoDepreciacionCentroCostoConstantesFunciones.TABLENAME+".id_sucursal,"+GastoDepreciacionCentroCostoConstantesFunciones.SCHEMA+"."+GastoDepreciacionCentroCostoConstantesFunciones.TABLENAME+".id_centro_costo,"+GastoDepreciacionCentroCostoConstantesFunciones.SCHEMA+"."+GastoDepreciacionCentroCostoConstantesFunciones.TABLENAME+".id_detalle_activo_fijo,"+GastoDepreciacionCentroCostoConstantesFunciones.SCHEMA+"."+GastoDepreciacionCentroCostoConstantesFunciones.TABLENAME+".id_cuenta_contable,"+GastoDepreciacionCentroCostoConstantesFunciones.SCHEMA+"."+GastoDepreciacionCentroCostoConstantesFunciones.TABLENAME+".porcentaje from "+GastoDepreciacionCentroCostoConstantesFunciones.SCHEMA+"."+GastoDepreciacionCentroCostoConstantesFunciones.TABLENAME;//+" as "+GastoDepreciacionCentroCostoConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected GastoDepreciacionCentroCostoConstantesFuncionesAdditional gastodepreciacioncentrocostoConstantesFuncionesAdditional=null;
	
	public GastoDepreciacionCentroCostoConstantesFuncionesAdditional getGastoDepreciacionCentroCostoConstantesFuncionesAdditional() {
		return this.gastodepreciacioncentrocostoConstantesFuncionesAdditional;
	}
	
	public void setGastoDepreciacionCentroCostoConstantesFuncionesAdditional(GastoDepreciacionCentroCostoConstantesFuncionesAdditional gastodepreciacioncentrocostoConstantesFuncionesAdditional) {
		try {
			this.gastodepreciacioncentrocostoConstantesFuncionesAdditional=gastodepreciacioncentrocostoConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDCENTROCOSTO= "id_centro_costo";
    public static final String IDDETALLEACTIVOFIJO= "id_detalle_activo_fijo";
    public static final String IDCUENTACONTABLE= "id_cuenta_contable";
    public static final String PORCENTAJE= "porcentaje";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDCENTROCOSTO= "Centro Costo";
		public static final String LABEL_IDCENTROCOSTO_LOWER= "Centro Costo";
    	public static final String LABEL_IDDETALLEACTIVOFIJO= "Detalle Activo Fijo";
		public static final String LABEL_IDDETALLEACTIVOFIJO_LOWER= "Detalle Activo Fijo";
    	public static final String LABEL_IDCUENTACONTABLE= "Cuenta Contable";
		public static final String LABEL_IDCUENTACONTABLE_LOWER= "Cuenta Contable";
    	public static final String LABEL_PORCENTAJE= "Porcentaje";
		public static final String LABEL_PORCENTAJE_LOWER= "Porcentaje";
	
		
		
		
		
		
		
		
		
	
	public static String getGastoDepreciacionCentroCostoLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(GastoDepreciacionCentroCostoConstantesFunciones.IDEMPRESA)) {sLabelColumna=GastoDepreciacionCentroCostoConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(GastoDepreciacionCentroCostoConstantesFunciones.IDSUCURSAL)) {sLabelColumna=GastoDepreciacionCentroCostoConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(GastoDepreciacionCentroCostoConstantesFunciones.IDCENTROCOSTO)) {sLabelColumna=GastoDepreciacionCentroCostoConstantesFunciones.LABEL_IDCENTROCOSTO;}
		if(sNombreColumna.equals(GastoDepreciacionCentroCostoConstantesFunciones.IDDETALLEACTIVOFIJO)) {sLabelColumna=GastoDepreciacionCentroCostoConstantesFunciones.LABEL_IDDETALLEACTIVOFIJO;}
		if(sNombreColumna.equals(GastoDepreciacionCentroCostoConstantesFunciones.IDCUENTACONTABLE)) {sLabelColumna=GastoDepreciacionCentroCostoConstantesFunciones.LABEL_IDCUENTACONTABLE;}
		if(sNombreColumna.equals(GastoDepreciacionCentroCostoConstantesFunciones.PORCENTAJE)) {sLabelColumna=GastoDepreciacionCentroCostoConstantesFunciones.LABEL_PORCENTAJE;}
		
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
	
	
	
			
			
			
			
			
			
			
			
	
	public static String getGastoDepreciacionCentroCostoDescripcion(GastoDepreciacionCentroCosto gastodepreciacioncentrocosto) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(gastodepreciacioncentrocosto !=null/* && gastodepreciacioncentrocosto.getId()!=0*/) {
			if(gastodepreciacioncentrocosto.getId()!=null) {
				sDescripcion=gastodepreciacioncentrocosto.getId().toString();
			}//gastodepreciacioncentrocostogastodepreciacioncentrocosto.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getGastoDepreciacionCentroCostoDescripcionDetallado(GastoDepreciacionCentroCosto gastodepreciacioncentrocosto) {
		String sDescripcion="";
			
		sDescripcion+=GastoDepreciacionCentroCostoConstantesFunciones.ID+"=";
		sDescripcion+=gastodepreciacioncentrocosto.getId().toString()+",";
		sDescripcion+=GastoDepreciacionCentroCostoConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=gastodepreciacioncentrocosto.getVersionRow().toString()+",";
		sDescripcion+=GastoDepreciacionCentroCostoConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=gastodepreciacioncentrocosto.getid_empresa().toString()+",";
		sDescripcion+=GastoDepreciacionCentroCostoConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=gastodepreciacioncentrocosto.getid_sucursal().toString()+",";
		sDescripcion+=GastoDepreciacionCentroCostoConstantesFunciones.IDCENTROCOSTO+"=";
		sDescripcion+=gastodepreciacioncentrocosto.getid_centro_costo().toString()+",";
		sDescripcion+=GastoDepreciacionCentroCostoConstantesFunciones.IDDETALLEACTIVOFIJO+"=";
		sDescripcion+=gastodepreciacioncentrocosto.getid_detalle_activo_fijo().toString()+",";
		sDescripcion+=GastoDepreciacionCentroCostoConstantesFunciones.IDCUENTACONTABLE+"=";
		sDescripcion+=gastodepreciacioncentrocosto.getid_cuenta_contable().toString()+",";
		sDescripcion+=GastoDepreciacionCentroCostoConstantesFunciones.PORCENTAJE+"=";
		sDescripcion+=gastodepreciacioncentrocosto.getporcentaje().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setGastoDepreciacionCentroCostoDescripcion(GastoDepreciacionCentroCosto gastodepreciacioncentrocosto,String sValor) throws Exception {			
		if(gastodepreciacioncentrocosto !=null) {
			//gastodepreciacioncentrocostogastodepreciacioncentrocosto.getId().toString();
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

	public static String getCentroCostoDescripcion(CentroCosto centrocosto) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(centrocosto!=null/*&&centrocosto.getId()>0*/) {
			sDescripcion=CentroCostoConstantesFunciones.getCentroCostoDescripcion(centrocosto);
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

	public static String getCuentaContableDescripcion(CuentaContable cuentacontable) {
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
		} else if(sNombreIndice.equals("FK_IdCentroCosto")) {
			sNombreIndice="Tipo=  Por Centro Costo";
		} else if(sNombreIndice.equals("FK_IdCuentaContable")) {
			sNombreIndice="Tipo=  Por Cuenta Contable";
		} else if(sNombreIndice.equals("FK_IdDetalleActivoFijo")) {
			sNombreIndice="Tipo=  Por Detalle Activo Fijo";
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

	public static String getDetalleIndiceFK_IdCentroCosto(Long id_centro_costo) {
		String sDetalleIndice=" Parametros->";
		if(id_centro_costo!=null) {sDetalleIndice+=" Codigo Unico De Centro Costo="+id_centro_costo.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdCuentaContable(Long id_cuenta_contable) {
		String sDetalleIndice=" Parametros->";
		if(id_cuenta_contable!=null) {sDetalleIndice+=" Codigo Unico De Cuenta Contable="+id_cuenta_contable.toString();} 

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

	public static String getDetalleIndiceFK_IdSucursal(Long id_sucursal) {
		String sDetalleIndice=" Parametros->";
		if(id_sucursal!=null) {sDetalleIndice+=" Codigo Unico De Sucursal="+id_sucursal.toString();} 

		return sDetalleIndice;
	}
	
	
	
	
	
	
	public static void quitarEspaciosGastoDepreciacionCentroCosto(GastoDepreciacionCentroCosto gastodepreciacioncentrocosto,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosGastoDepreciacionCentroCostos(List<GastoDepreciacionCentroCosto> gastodepreciacioncentrocostos,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(GastoDepreciacionCentroCosto gastodepreciacioncentrocosto: gastodepreciacioncentrocostos) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresGastoDepreciacionCentroCosto(GastoDepreciacionCentroCosto gastodepreciacioncentrocosto,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && gastodepreciacioncentrocosto.getConCambioAuxiliar()) {
			gastodepreciacioncentrocosto.setIsDeleted(gastodepreciacioncentrocosto.getIsDeletedAuxiliar());	
			gastodepreciacioncentrocosto.setIsNew(gastodepreciacioncentrocosto.getIsNewAuxiliar());	
			gastodepreciacioncentrocosto.setIsChanged(gastodepreciacioncentrocosto.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			gastodepreciacioncentrocosto.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			gastodepreciacioncentrocosto.setIsDeletedAuxiliar(false);	
			gastodepreciacioncentrocosto.setIsNewAuxiliar(false);	
			gastodepreciacioncentrocosto.setIsChangedAuxiliar(false);
			
			gastodepreciacioncentrocosto.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresGastoDepreciacionCentroCostos(List<GastoDepreciacionCentroCosto> gastodepreciacioncentrocostos,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(GastoDepreciacionCentroCosto gastodepreciacioncentrocosto : gastodepreciacioncentrocostos) {
			if(conAsignarBase && gastodepreciacioncentrocosto.getConCambioAuxiliar()) {
				gastodepreciacioncentrocosto.setIsDeleted(gastodepreciacioncentrocosto.getIsDeletedAuxiliar());	
				gastodepreciacioncentrocosto.setIsNew(gastodepreciacioncentrocosto.getIsNewAuxiliar());	
				gastodepreciacioncentrocosto.setIsChanged(gastodepreciacioncentrocosto.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				gastodepreciacioncentrocosto.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				gastodepreciacioncentrocosto.setIsDeletedAuxiliar(false);	
				gastodepreciacioncentrocosto.setIsNewAuxiliar(false);	
				gastodepreciacioncentrocosto.setIsChangedAuxiliar(false);
				
				gastodepreciacioncentrocosto.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresGastoDepreciacionCentroCosto(GastoDepreciacionCentroCosto gastodepreciacioncentrocosto,Boolean conEnteros) throws Exception  {
		gastodepreciacioncentrocosto.setporcentaje(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresGastoDepreciacionCentroCostos(List<GastoDepreciacionCentroCosto> gastodepreciacioncentrocostos,Boolean conEnteros) throws Exception  {
		
		for(GastoDepreciacionCentroCosto gastodepreciacioncentrocosto: gastodepreciacioncentrocostos) {
			gastodepreciacioncentrocosto.setporcentaje(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaGastoDepreciacionCentroCosto(List<GastoDepreciacionCentroCosto> gastodepreciacioncentrocostos,GastoDepreciacionCentroCosto gastodepreciacioncentrocostoAux) throws Exception  {
		GastoDepreciacionCentroCostoConstantesFunciones.InicializarValoresGastoDepreciacionCentroCosto(gastodepreciacioncentrocostoAux,true);
		
		for(GastoDepreciacionCentroCosto gastodepreciacioncentrocosto: gastodepreciacioncentrocostos) {
			if(gastodepreciacioncentrocosto.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			gastodepreciacioncentrocostoAux.setporcentaje(gastodepreciacioncentrocostoAux.getporcentaje()+gastodepreciacioncentrocosto.getporcentaje());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesGastoDepreciacionCentroCosto(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=GastoDepreciacionCentroCostoConstantesFunciones.getArrayColumnasGlobalesGastoDepreciacionCentroCosto(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesGastoDepreciacionCentroCosto(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(GastoDepreciacionCentroCostoConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(GastoDepreciacionCentroCostoConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(GastoDepreciacionCentroCostoConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(GastoDepreciacionCentroCostoConstantesFunciones.IDSUCURSAL);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoGastoDepreciacionCentroCosto(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<GastoDepreciacionCentroCosto> gastodepreciacioncentrocostos,GastoDepreciacionCentroCosto gastodepreciacioncentrocosto,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(GastoDepreciacionCentroCosto gastodepreciacioncentrocostoAux: gastodepreciacioncentrocostos) {
			if(gastodepreciacioncentrocostoAux!=null && gastodepreciacioncentrocosto!=null) {
				if((gastodepreciacioncentrocostoAux.getId()==null && gastodepreciacioncentrocosto.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(gastodepreciacioncentrocostoAux.getId()!=null && gastodepreciacioncentrocosto.getId()!=null){
					if(gastodepreciacioncentrocostoAux.getId().equals(gastodepreciacioncentrocosto.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaGastoDepreciacionCentroCosto(List<GastoDepreciacionCentroCosto> gastodepreciacioncentrocostos) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double porcentajeTotal=0.0;
	
		for(GastoDepreciacionCentroCosto gastodepreciacioncentrocosto: gastodepreciacioncentrocostos) {			
			if(gastodepreciacioncentrocosto.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			porcentajeTotal+=gastodepreciacioncentrocosto.getporcentaje();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(GastoDepreciacionCentroCostoConstantesFunciones.PORCENTAJE);
		datoGeneral.setsDescripcion(GastoDepreciacionCentroCostoConstantesFunciones.LABEL_PORCENTAJE);
		datoGeneral.setdValorDouble(porcentajeTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaGastoDepreciacionCentroCosto() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,GastoDepreciacionCentroCostoConstantesFunciones.LABEL_ID, GastoDepreciacionCentroCostoConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GastoDepreciacionCentroCostoConstantesFunciones.LABEL_VERSIONROW, GastoDepreciacionCentroCostoConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GastoDepreciacionCentroCostoConstantesFunciones.LABEL_IDEMPRESA, GastoDepreciacionCentroCostoConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GastoDepreciacionCentroCostoConstantesFunciones.LABEL_IDSUCURSAL, GastoDepreciacionCentroCostoConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GastoDepreciacionCentroCostoConstantesFunciones.LABEL_IDCENTROCOSTO, GastoDepreciacionCentroCostoConstantesFunciones.IDCENTROCOSTO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GastoDepreciacionCentroCostoConstantesFunciones.LABEL_IDDETALLEACTIVOFIJO, GastoDepreciacionCentroCostoConstantesFunciones.IDDETALLEACTIVOFIJO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GastoDepreciacionCentroCostoConstantesFunciones.LABEL_IDCUENTACONTABLE, GastoDepreciacionCentroCostoConstantesFunciones.IDCUENTACONTABLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,GastoDepreciacionCentroCostoConstantesFunciones.LABEL_PORCENTAJE, GastoDepreciacionCentroCostoConstantesFunciones.PORCENTAJE,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasGastoDepreciacionCentroCosto() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=GastoDepreciacionCentroCostoConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GastoDepreciacionCentroCostoConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GastoDepreciacionCentroCostoConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GastoDepreciacionCentroCostoConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GastoDepreciacionCentroCostoConstantesFunciones.IDCENTROCOSTO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GastoDepreciacionCentroCostoConstantesFunciones.IDDETALLEACTIVOFIJO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GastoDepreciacionCentroCostoConstantesFunciones.IDCUENTACONTABLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=GastoDepreciacionCentroCostoConstantesFunciones.PORCENTAJE;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarGastoDepreciacionCentroCosto() throws Exception  {
		return GastoDepreciacionCentroCostoConstantesFunciones.getTiposSeleccionarGastoDepreciacionCentroCosto(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarGastoDepreciacionCentroCosto(Boolean conFk) throws Exception  {
		return GastoDepreciacionCentroCostoConstantesFunciones.getTiposSeleccionarGastoDepreciacionCentroCosto(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarGastoDepreciacionCentroCosto(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(GastoDepreciacionCentroCostoConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(GastoDepreciacionCentroCostoConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(GastoDepreciacionCentroCostoConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(GastoDepreciacionCentroCostoConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(GastoDepreciacionCentroCostoConstantesFunciones.LABEL_IDCENTROCOSTO);
			reporte.setsDescripcion(GastoDepreciacionCentroCostoConstantesFunciones.LABEL_IDCENTROCOSTO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(GastoDepreciacionCentroCostoConstantesFunciones.LABEL_IDDETALLEACTIVOFIJO);
			reporte.setsDescripcion(GastoDepreciacionCentroCostoConstantesFunciones.LABEL_IDDETALLEACTIVOFIJO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(GastoDepreciacionCentroCostoConstantesFunciones.LABEL_IDCUENTACONTABLE);
			reporte.setsDescripcion(GastoDepreciacionCentroCostoConstantesFunciones.LABEL_IDCUENTACONTABLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(GastoDepreciacionCentroCostoConstantesFunciones.LABEL_PORCENTAJE);
			reporte.setsDescripcion(GastoDepreciacionCentroCostoConstantesFunciones.LABEL_PORCENTAJE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesGastoDepreciacionCentroCosto(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesGastoDepreciacionCentroCosto(GastoDepreciacionCentroCosto gastodepreciacioncentrocostoAux) throws Exception {
		
			gastodepreciacioncentrocostoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(gastodepreciacioncentrocostoAux.getEmpresa()));
			gastodepreciacioncentrocostoAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(gastodepreciacioncentrocostoAux.getSucursal()));
			gastodepreciacioncentrocostoAux.setcentrocosto_descripcion(CentroCostoConstantesFunciones.getCentroCostoDescripcion(gastodepreciacioncentrocostoAux.getCentroCosto()));
			gastodepreciacioncentrocostoAux.setdetalleactivofijo_descripcion(DetalleActivoFijoConstantesFunciones.getDetalleActivoFijoDescripcion(gastodepreciacioncentrocostoAux.getDetalleActivoFijo()));
			gastodepreciacioncentrocostoAux.setcuentacontable_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(gastodepreciacioncentrocostoAux.getCuentaContable()));		
	}
	
	public static void refrescarForeignKeysDescripcionesGastoDepreciacionCentroCosto(List<GastoDepreciacionCentroCosto> gastodepreciacioncentrocostosTemp) throws Exception {
		for(GastoDepreciacionCentroCosto gastodepreciacioncentrocostoAux:gastodepreciacioncentrocostosTemp) {
			
			gastodepreciacioncentrocostoAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(gastodepreciacioncentrocostoAux.getEmpresa()));
			gastodepreciacioncentrocostoAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(gastodepreciacioncentrocostoAux.getSucursal()));
			gastodepreciacioncentrocostoAux.setcentrocosto_descripcion(CentroCostoConstantesFunciones.getCentroCostoDescripcion(gastodepreciacioncentrocostoAux.getCentroCosto()));
			gastodepreciacioncentrocostoAux.setdetalleactivofijo_descripcion(DetalleActivoFijoConstantesFunciones.getDetalleActivoFijoDescripcion(gastodepreciacioncentrocostoAux.getDetalleActivoFijo()));
			gastodepreciacioncentrocostoAux.setcuentacontable_descripcion(CuentaContableConstantesFunciones.getCuentaContableDescripcion(gastodepreciacioncentrocostoAux.getCuentaContable()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfGastoDepreciacionCentroCosto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(CentroCosto.class));
				classes.add(new Classe(DetalleActivoFijo.class));
				classes.add(new Classe(CuentaContable.class));
				
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
					if(clas.clas.equals(CentroCosto.class)) {
						classes.add(new Classe(CentroCosto.class));
					}
				}

				for(Classe clas:classesP) {
					if(clas.clas.equals(DetalleActivoFijo.class)) {
						classes.add(new Classe(DetalleActivoFijo.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfGastoDepreciacionCentroCosto(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(CentroCosto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CentroCosto.class)); continue;
					}

					if(DetalleActivoFijo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleActivoFijo.class)); continue;
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

					if(Sucursal.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Sucursal.class)); continue;
					}

					if(CentroCosto.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(CentroCosto.class)); continue;
					}

					if(DetalleActivoFijo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(DetalleActivoFijo.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfGastoDepreciacionCentroCosto(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return GastoDepreciacionCentroCostoConstantesFunciones.getClassesRelationshipsOfGastoDepreciacionCentroCosto(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfGastoDepreciacionCentroCosto(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfGastoDepreciacionCentroCosto(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return GastoDepreciacionCentroCostoConstantesFunciones.getClassesRelationshipsFromStringsOfGastoDepreciacionCentroCosto(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfGastoDepreciacionCentroCosto(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(GastoDepreciacionCentroCosto gastodepreciacioncentrocosto,List<GastoDepreciacionCentroCosto> gastodepreciacioncentrocostos,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			GastoDepreciacionCentroCosto gastodepreciacioncentrocostoEncontrado=null;
			
			for(GastoDepreciacionCentroCosto gastodepreciacioncentrocostoLocal:gastodepreciacioncentrocostos) {
				if(gastodepreciacioncentrocostoLocal.getId().equals(gastodepreciacioncentrocosto.getId())) {
					gastodepreciacioncentrocostoEncontrado=gastodepreciacioncentrocostoLocal;
					
					gastodepreciacioncentrocostoLocal.setIsChanged(gastodepreciacioncentrocosto.getIsChanged());
					gastodepreciacioncentrocostoLocal.setIsNew(gastodepreciacioncentrocosto.getIsNew());
					gastodepreciacioncentrocostoLocal.setIsDeleted(gastodepreciacioncentrocosto.getIsDeleted());
					
					gastodepreciacioncentrocostoLocal.setGeneralEntityOriginal(gastodepreciacioncentrocosto.getGeneralEntityOriginal());
					
					gastodepreciacioncentrocostoLocal.setId(gastodepreciacioncentrocosto.getId());	
					gastodepreciacioncentrocostoLocal.setVersionRow(gastodepreciacioncentrocosto.getVersionRow());	
					gastodepreciacioncentrocostoLocal.setid_empresa(gastodepreciacioncentrocosto.getid_empresa());	
					gastodepreciacioncentrocostoLocal.setid_sucursal(gastodepreciacioncentrocosto.getid_sucursal());	
					gastodepreciacioncentrocostoLocal.setid_centro_costo(gastodepreciacioncentrocosto.getid_centro_costo());	
					gastodepreciacioncentrocostoLocal.setid_detalle_activo_fijo(gastodepreciacioncentrocosto.getid_detalle_activo_fijo());	
					gastodepreciacioncentrocostoLocal.setid_cuenta_contable(gastodepreciacioncentrocosto.getid_cuenta_contable());	
					gastodepreciacioncentrocostoLocal.setporcentaje(gastodepreciacioncentrocosto.getporcentaje());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!gastodepreciacioncentrocosto.getIsDeleted()) {
				if(!existe) {
					gastodepreciacioncentrocostos.add(gastodepreciacioncentrocosto);
				}
			} else {
				if(gastodepreciacioncentrocostoEncontrado!=null && permiteQuitar)  {
					gastodepreciacioncentrocostos.remove(gastodepreciacioncentrocostoEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(GastoDepreciacionCentroCosto gastodepreciacioncentrocosto,List<GastoDepreciacionCentroCosto> gastodepreciacioncentrocostos) throws Exception {
		try	{			
			for(GastoDepreciacionCentroCosto gastodepreciacioncentrocostoLocal:gastodepreciacioncentrocostos) {
				if(gastodepreciacioncentrocostoLocal.getId().equals(gastodepreciacioncentrocosto.getId())) {
					gastodepreciacioncentrocostoLocal.setIsSelected(gastodepreciacioncentrocosto.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesGastoDepreciacionCentroCosto(List<GastoDepreciacionCentroCosto> gastodepreciacioncentrocostosAux) throws Exception {
		//this.gastodepreciacioncentrocostosAux=gastodepreciacioncentrocostosAux;
		
		for(GastoDepreciacionCentroCosto gastodepreciacioncentrocostoAux:gastodepreciacioncentrocostosAux) {
			if(gastodepreciacioncentrocostoAux.getIsChanged()) {
				gastodepreciacioncentrocostoAux.setIsChanged(false);
			}		
			
			if(gastodepreciacioncentrocostoAux.getIsNew()) {
				gastodepreciacioncentrocostoAux.setIsNew(false);
			}	
			
			if(gastodepreciacioncentrocostoAux.getIsDeleted()) {
				gastodepreciacioncentrocostoAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesGastoDepreciacionCentroCosto(GastoDepreciacionCentroCosto gastodepreciacioncentrocostoAux) throws Exception {
		//this.gastodepreciacioncentrocostoAux=gastodepreciacioncentrocostoAux;
		
			if(gastodepreciacioncentrocostoAux.getIsChanged()) {
				gastodepreciacioncentrocostoAux.setIsChanged(false);
			}		
			
			if(gastodepreciacioncentrocostoAux.getIsNew()) {
				gastodepreciacioncentrocostoAux.setIsNew(false);
			}	
			
			if(gastodepreciacioncentrocostoAux.getIsDeleted()) {
				gastodepreciacioncentrocostoAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(GastoDepreciacionCentroCosto gastodepreciacioncentrocostoAsignar,GastoDepreciacionCentroCosto gastodepreciacioncentrocosto) throws Exception {
		gastodepreciacioncentrocostoAsignar.setId(gastodepreciacioncentrocosto.getId());	
		gastodepreciacioncentrocostoAsignar.setVersionRow(gastodepreciacioncentrocosto.getVersionRow());	
		gastodepreciacioncentrocostoAsignar.setid_empresa(gastodepreciacioncentrocosto.getid_empresa());
		gastodepreciacioncentrocostoAsignar.setempresa_descripcion(gastodepreciacioncentrocosto.getempresa_descripcion());	
		gastodepreciacioncentrocostoAsignar.setid_sucursal(gastodepreciacioncentrocosto.getid_sucursal());
		gastodepreciacioncentrocostoAsignar.setsucursal_descripcion(gastodepreciacioncentrocosto.getsucursal_descripcion());	
		gastodepreciacioncentrocostoAsignar.setid_centro_costo(gastodepreciacioncentrocosto.getid_centro_costo());
		gastodepreciacioncentrocostoAsignar.setcentrocosto_descripcion(gastodepreciacioncentrocosto.getcentrocosto_descripcion());	
		gastodepreciacioncentrocostoAsignar.setid_detalle_activo_fijo(gastodepreciacioncentrocosto.getid_detalle_activo_fijo());
		gastodepreciacioncentrocostoAsignar.setdetalleactivofijo_descripcion(gastodepreciacioncentrocosto.getdetalleactivofijo_descripcion());	
		gastodepreciacioncentrocostoAsignar.setid_cuenta_contable(gastodepreciacioncentrocosto.getid_cuenta_contable());
		gastodepreciacioncentrocostoAsignar.setcuentacontable_descripcion(gastodepreciacioncentrocosto.getcuentacontable_descripcion());	
		gastodepreciacioncentrocostoAsignar.setporcentaje(gastodepreciacioncentrocosto.getporcentaje());	
	}
	
	public static void inicializarGastoDepreciacionCentroCosto(GastoDepreciacionCentroCosto gastodepreciacioncentrocosto) throws Exception {
		try {
				gastodepreciacioncentrocosto.setId(0L);	
					
				gastodepreciacioncentrocosto.setid_empresa(-1L);	
				gastodepreciacioncentrocosto.setid_sucursal(-1L);	
				gastodepreciacioncentrocosto.setid_centro_costo(null);	
				gastodepreciacioncentrocosto.setid_detalle_activo_fijo(-1L);	
				gastodepreciacioncentrocosto.setid_cuenta_contable(-1L);	
				gastodepreciacioncentrocosto.setporcentaje(0.0);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderGastoDepreciacionCentroCosto(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(GastoDepreciacionCentroCostoConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GastoDepreciacionCentroCostoConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GastoDepreciacionCentroCostoConstantesFunciones.LABEL_IDCENTROCOSTO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GastoDepreciacionCentroCostoConstantesFunciones.LABEL_IDDETALLEACTIVOFIJO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GastoDepreciacionCentroCostoConstantesFunciones.LABEL_IDCUENTACONTABLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(GastoDepreciacionCentroCostoConstantesFunciones.LABEL_PORCENTAJE);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataGastoDepreciacionCentroCosto(String sTipo,Row row,Workbook workbook,GastoDepreciacionCentroCosto gastodepreciacioncentrocosto,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(gastodepreciacioncentrocosto.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(gastodepreciacioncentrocosto.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(gastodepreciacioncentrocosto.getcentrocosto_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(gastodepreciacioncentrocosto.getdetalleactivofijo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(gastodepreciacioncentrocosto.getcuentacontable_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(gastodepreciacioncentrocosto.getporcentaje());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryGastoDepreciacionCentroCosto=Constantes.SFINALQUERY;
	
	public String getsFinalQueryGastoDepreciacionCentroCosto() {
		return this.sFinalQueryGastoDepreciacionCentroCosto;
	}
	
	public void setsFinalQueryGastoDepreciacionCentroCosto(String sFinalQueryGastoDepreciacionCentroCosto) {
		this.sFinalQueryGastoDepreciacionCentroCosto= sFinalQueryGastoDepreciacionCentroCosto;
	}
	
	public Border resaltarSeleccionarGastoDepreciacionCentroCosto=null;
	
	public Border setResaltarSeleccionarGastoDepreciacionCentroCosto(ParametroGeneralUsuario parametroGeneralUsuario/*GastoDepreciacionCentroCostoBeanSwingJInternalFrame gastodepreciacioncentrocostoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//gastodepreciacioncentrocostoBeanSwingJInternalFrame.jTtoolBarGastoDepreciacionCentroCosto.setBorder(borderResaltar);
		
		this.resaltarSeleccionarGastoDepreciacionCentroCosto= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarGastoDepreciacionCentroCosto() {
		return this.resaltarSeleccionarGastoDepreciacionCentroCosto;
	}
	
	public void setResaltarSeleccionarGastoDepreciacionCentroCosto(Border borderResaltarSeleccionarGastoDepreciacionCentroCosto) {
		this.resaltarSeleccionarGastoDepreciacionCentroCosto= borderResaltarSeleccionarGastoDepreciacionCentroCosto;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridGastoDepreciacionCentroCosto=null;
	public Boolean mostraridGastoDepreciacionCentroCosto=true;
	public Boolean activaridGastoDepreciacionCentroCosto=true;

	public Border resaltarid_empresaGastoDepreciacionCentroCosto=null;
	public Boolean mostrarid_empresaGastoDepreciacionCentroCosto=true;
	public Boolean activarid_empresaGastoDepreciacionCentroCosto=true;
	public Boolean cargarid_empresaGastoDepreciacionCentroCosto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaGastoDepreciacionCentroCosto=false;//ConEventDepend=true

	public Border resaltarid_sucursalGastoDepreciacionCentroCosto=null;
	public Boolean mostrarid_sucursalGastoDepreciacionCentroCosto=true;
	public Boolean activarid_sucursalGastoDepreciacionCentroCosto=true;
	public Boolean cargarid_sucursalGastoDepreciacionCentroCosto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalGastoDepreciacionCentroCosto=false;//ConEventDepend=true

	public Border resaltarid_centro_costoGastoDepreciacionCentroCosto=null;
	public Boolean mostrarid_centro_costoGastoDepreciacionCentroCosto=true;
	public Boolean activarid_centro_costoGastoDepreciacionCentroCosto=true;
	public Boolean cargarid_centro_costoGastoDepreciacionCentroCosto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_centro_costoGastoDepreciacionCentroCosto=false;//ConEventDepend=true

	public Border resaltarid_detalle_activo_fijoGastoDepreciacionCentroCosto=null;
	public Boolean mostrarid_detalle_activo_fijoGastoDepreciacionCentroCosto=true;
	public Boolean activarid_detalle_activo_fijoGastoDepreciacionCentroCosto=true;
	public Boolean cargarid_detalle_activo_fijoGastoDepreciacionCentroCosto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_detalle_activo_fijoGastoDepreciacionCentroCosto=false;//ConEventDepend=true

	public Border resaltarid_cuenta_contableGastoDepreciacionCentroCosto=null;
	public Boolean mostrarid_cuenta_contableGastoDepreciacionCentroCosto=true;
	public Boolean activarid_cuenta_contableGastoDepreciacionCentroCosto=true;
	public Boolean cargarid_cuenta_contableGastoDepreciacionCentroCosto=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_cuenta_contableGastoDepreciacionCentroCosto=false;//ConEventDepend=true

	public Border resaltarporcentajeGastoDepreciacionCentroCosto=null;
	public Boolean mostrarporcentajeGastoDepreciacionCentroCosto=true;
	public Boolean activarporcentajeGastoDepreciacionCentroCosto=true;

	
	

	public Border setResaltaridGastoDepreciacionCentroCosto(ParametroGeneralUsuario parametroGeneralUsuario/*GastoDepreciacionCentroCostoBeanSwingJInternalFrame gastodepreciacioncentrocostoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//gastodepreciacioncentrocostoBeanSwingJInternalFrame.jTtoolBarGastoDepreciacionCentroCosto.setBorder(borderResaltar);
		
		this.resaltaridGastoDepreciacionCentroCosto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridGastoDepreciacionCentroCosto() {
		return this.resaltaridGastoDepreciacionCentroCosto;
	}

	public void setResaltaridGastoDepreciacionCentroCosto(Border borderResaltar) {
		this.resaltaridGastoDepreciacionCentroCosto= borderResaltar;
	}

	public Boolean getMostraridGastoDepreciacionCentroCosto() {
		return this.mostraridGastoDepreciacionCentroCosto;
	}

	public void setMostraridGastoDepreciacionCentroCosto(Boolean mostraridGastoDepreciacionCentroCosto) {
		this.mostraridGastoDepreciacionCentroCosto= mostraridGastoDepreciacionCentroCosto;
	}

	public Boolean getActivaridGastoDepreciacionCentroCosto() {
		return this.activaridGastoDepreciacionCentroCosto;
	}

	public void setActivaridGastoDepreciacionCentroCosto(Boolean activaridGastoDepreciacionCentroCosto) {
		this.activaridGastoDepreciacionCentroCosto= activaridGastoDepreciacionCentroCosto;
	}

	public Border setResaltarid_empresaGastoDepreciacionCentroCosto(ParametroGeneralUsuario parametroGeneralUsuario/*GastoDepreciacionCentroCostoBeanSwingJInternalFrame gastodepreciacioncentrocostoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//gastodepreciacioncentrocostoBeanSwingJInternalFrame.jTtoolBarGastoDepreciacionCentroCosto.setBorder(borderResaltar);
		
		this.resaltarid_empresaGastoDepreciacionCentroCosto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaGastoDepreciacionCentroCosto() {
		return this.resaltarid_empresaGastoDepreciacionCentroCosto;
	}

	public void setResaltarid_empresaGastoDepreciacionCentroCosto(Border borderResaltar) {
		this.resaltarid_empresaGastoDepreciacionCentroCosto= borderResaltar;
	}

	public Boolean getMostrarid_empresaGastoDepreciacionCentroCosto() {
		return this.mostrarid_empresaGastoDepreciacionCentroCosto;
	}

	public void setMostrarid_empresaGastoDepreciacionCentroCosto(Boolean mostrarid_empresaGastoDepreciacionCentroCosto) {
		this.mostrarid_empresaGastoDepreciacionCentroCosto= mostrarid_empresaGastoDepreciacionCentroCosto;
	}

	public Boolean getActivarid_empresaGastoDepreciacionCentroCosto() {
		return this.activarid_empresaGastoDepreciacionCentroCosto;
	}

	public void setActivarid_empresaGastoDepreciacionCentroCosto(Boolean activarid_empresaGastoDepreciacionCentroCosto) {
		this.activarid_empresaGastoDepreciacionCentroCosto= activarid_empresaGastoDepreciacionCentroCosto;
	}

	public Boolean getCargarid_empresaGastoDepreciacionCentroCosto() {
		return this.cargarid_empresaGastoDepreciacionCentroCosto;
	}

	public void setCargarid_empresaGastoDepreciacionCentroCosto(Boolean cargarid_empresaGastoDepreciacionCentroCosto) {
		this.cargarid_empresaGastoDepreciacionCentroCosto= cargarid_empresaGastoDepreciacionCentroCosto;
	}

	public Border setResaltarid_sucursalGastoDepreciacionCentroCosto(ParametroGeneralUsuario parametroGeneralUsuario/*GastoDepreciacionCentroCostoBeanSwingJInternalFrame gastodepreciacioncentrocostoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//gastodepreciacioncentrocostoBeanSwingJInternalFrame.jTtoolBarGastoDepreciacionCentroCosto.setBorder(borderResaltar);
		
		this.resaltarid_sucursalGastoDepreciacionCentroCosto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalGastoDepreciacionCentroCosto() {
		return this.resaltarid_sucursalGastoDepreciacionCentroCosto;
	}

	public void setResaltarid_sucursalGastoDepreciacionCentroCosto(Border borderResaltar) {
		this.resaltarid_sucursalGastoDepreciacionCentroCosto= borderResaltar;
	}

	public Boolean getMostrarid_sucursalGastoDepreciacionCentroCosto() {
		return this.mostrarid_sucursalGastoDepreciacionCentroCosto;
	}

	public void setMostrarid_sucursalGastoDepreciacionCentroCosto(Boolean mostrarid_sucursalGastoDepreciacionCentroCosto) {
		this.mostrarid_sucursalGastoDepreciacionCentroCosto= mostrarid_sucursalGastoDepreciacionCentroCosto;
	}

	public Boolean getActivarid_sucursalGastoDepreciacionCentroCosto() {
		return this.activarid_sucursalGastoDepreciacionCentroCosto;
	}

	public void setActivarid_sucursalGastoDepreciacionCentroCosto(Boolean activarid_sucursalGastoDepreciacionCentroCosto) {
		this.activarid_sucursalGastoDepreciacionCentroCosto= activarid_sucursalGastoDepreciacionCentroCosto;
	}

	public Boolean getCargarid_sucursalGastoDepreciacionCentroCosto() {
		return this.cargarid_sucursalGastoDepreciacionCentroCosto;
	}

	public void setCargarid_sucursalGastoDepreciacionCentroCosto(Boolean cargarid_sucursalGastoDepreciacionCentroCosto) {
		this.cargarid_sucursalGastoDepreciacionCentroCosto= cargarid_sucursalGastoDepreciacionCentroCosto;
	}

	public Border setResaltarid_centro_costoGastoDepreciacionCentroCosto(ParametroGeneralUsuario parametroGeneralUsuario/*GastoDepreciacionCentroCostoBeanSwingJInternalFrame gastodepreciacioncentrocostoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//gastodepreciacioncentrocostoBeanSwingJInternalFrame.jTtoolBarGastoDepreciacionCentroCosto.setBorder(borderResaltar);
		
		this.resaltarid_centro_costoGastoDepreciacionCentroCosto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_centro_costoGastoDepreciacionCentroCosto() {
		return this.resaltarid_centro_costoGastoDepreciacionCentroCosto;
	}

	public void setResaltarid_centro_costoGastoDepreciacionCentroCosto(Border borderResaltar) {
		this.resaltarid_centro_costoGastoDepreciacionCentroCosto= borderResaltar;
	}

	public Boolean getMostrarid_centro_costoGastoDepreciacionCentroCosto() {
		return this.mostrarid_centro_costoGastoDepreciacionCentroCosto;
	}

	public void setMostrarid_centro_costoGastoDepreciacionCentroCosto(Boolean mostrarid_centro_costoGastoDepreciacionCentroCosto) {
		this.mostrarid_centro_costoGastoDepreciacionCentroCosto= mostrarid_centro_costoGastoDepreciacionCentroCosto;
	}

	public Boolean getActivarid_centro_costoGastoDepreciacionCentroCosto() {
		return this.activarid_centro_costoGastoDepreciacionCentroCosto;
	}

	public void setActivarid_centro_costoGastoDepreciacionCentroCosto(Boolean activarid_centro_costoGastoDepreciacionCentroCosto) {
		this.activarid_centro_costoGastoDepreciacionCentroCosto= activarid_centro_costoGastoDepreciacionCentroCosto;
	}

	public Boolean getCargarid_centro_costoGastoDepreciacionCentroCosto() {
		return this.cargarid_centro_costoGastoDepreciacionCentroCosto;
	}

	public void setCargarid_centro_costoGastoDepreciacionCentroCosto(Boolean cargarid_centro_costoGastoDepreciacionCentroCosto) {
		this.cargarid_centro_costoGastoDepreciacionCentroCosto= cargarid_centro_costoGastoDepreciacionCentroCosto;
	}

	public Border setResaltarid_detalle_activo_fijoGastoDepreciacionCentroCosto(ParametroGeneralUsuario parametroGeneralUsuario/*GastoDepreciacionCentroCostoBeanSwingJInternalFrame gastodepreciacioncentrocostoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//gastodepreciacioncentrocostoBeanSwingJInternalFrame.jTtoolBarGastoDepreciacionCentroCosto.setBorder(borderResaltar);
		
		this.resaltarid_detalle_activo_fijoGastoDepreciacionCentroCosto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_detalle_activo_fijoGastoDepreciacionCentroCosto() {
		return this.resaltarid_detalle_activo_fijoGastoDepreciacionCentroCosto;
	}

	public void setResaltarid_detalle_activo_fijoGastoDepreciacionCentroCosto(Border borderResaltar) {
		this.resaltarid_detalle_activo_fijoGastoDepreciacionCentroCosto= borderResaltar;
	}

	public Boolean getMostrarid_detalle_activo_fijoGastoDepreciacionCentroCosto() {
		return this.mostrarid_detalle_activo_fijoGastoDepreciacionCentroCosto;
	}

	public void setMostrarid_detalle_activo_fijoGastoDepreciacionCentroCosto(Boolean mostrarid_detalle_activo_fijoGastoDepreciacionCentroCosto) {
		this.mostrarid_detalle_activo_fijoGastoDepreciacionCentroCosto= mostrarid_detalle_activo_fijoGastoDepreciacionCentroCosto;
	}

	public Boolean getActivarid_detalle_activo_fijoGastoDepreciacionCentroCosto() {
		return this.activarid_detalle_activo_fijoGastoDepreciacionCentroCosto;
	}

	public void setActivarid_detalle_activo_fijoGastoDepreciacionCentroCosto(Boolean activarid_detalle_activo_fijoGastoDepreciacionCentroCosto) {
		this.activarid_detalle_activo_fijoGastoDepreciacionCentroCosto= activarid_detalle_activo_fijoGastoDepreciacionCentroCosto;
	}

	public Boolean getCargarid_detalle_activo_fijoGastoDepreciacionCentroCosto() {
		return this.cargarid_detalle_activo_fijoGastoDepreciacionCentroCosto;
	}

	public void setCargarid_detalle_activo_fijoGastoDepreciacionCentroCosto(Boolean cargarid_detalle_activo_fijoGastoDepreciacionCentroCosto) {
		this.cargarid_detalle_activo_fijoGastoDepreciacionCentroCosto= cargarid_detalle_activo_fijoGastoDepreciacionCentroCosto;
	}

	public Border setResaltarid_cuenta_contableGastoDepreciacionCentroCosto(ParametroGeneralUsuario parametroGeneralUsuario/*GastoDepreciacionCentroCostoBeanSwingJInternalFrame gastodepreciacioncentrocostoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//gastodepreciacioncentrocostoBeanSwingJInternalFrame.jTtoolBarGastoDepreciacionCentroCosto.setBorder(borderResaltar);
		
		this.resaltarid_cuenta_contableGastoDepreciacionCentroCosto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_cuenta_contableGastoDepreciacionCentroCosto() {
		return this.resaltarid_cuenta_contableGastoDepreciacionCentroCosto;
	}

	public void setResaltarid_cuenta_contableGastoDepreciacionCentroCosto(Border borderResaltar) {
		this.resaltarid_cuenta_contableGastoDepreciacionCentroCosto= borderResaltar;
	}

	public Boolean getMostrarid_cuenta_contableGastoDepreciacionCentroCosto() {
		return this.mostrarid_cuenta_contableGastoDepreciacionCentroCosto;
	}

	public void setMostrarid_cuenta_contableGastoDepreciacionCentroCosto(Boolean mostrarid_cuenta_contableGastoDepreciacionCentroCosto) {
		this.mostrarid_cuenta_contableGastoDepreciacionCentroCosto= mostrarid_cuenta_contableGastoDepreciacionCentroCosto;
	}

	public Boolean getActivarid_cuenta_contableGastoDepreciacionCentroCosto() {
		return this.activarid_cuenta_contableGastoDepreciacionCentroCosto;
	}

	public void setActivarid_cuenta_contableGastoDepreciacionCentroCosto(Boolean activarid_cuenta_contableGastoDepreciacionCentroCosto) {
		this.activarid_cuenta_contableGastoDepreciacionCentroCosto= activarid_cuenta_contableGastoDepreciacionCentroCosto;
	}

	public Boolean getCargarid_cuenta_contableGastoDepreciacionCentroCosto() {
		return this.cargarid_cuenta_contableGastoDepreciacionCentroCosto;
	}

	public void setCargarid_cuenta_contableGastoDepreciacionCentroCosto(Boolean cargarid_cuenta_contableGastoDepreciacionCentroCosto) {
		this.cargarid_cuenta_contableGastoDepreciacionCentroCosto= cargarid_cuenta_contableGastoDepreciacionCentroCosto;
	}

	public Border setResaltarporcentajeGastoDepreciacionCentroCosto(ParametroGeneralUsuario parametroGeneralUsuario/*GastoDepreciacionCentroCostoBeanSwingJInternalFrame gastodepreciacioncentrocostoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//gastodepreciacioncentrocostoBeanSwingJInternalFrame.jTtoolBarGastoDepreciacionCentroCosto.setBorder(borderResaltar);
		
		this.resaltarporcentajeGastoDepreciacionCentroCosto= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarporcentajeGastoDepreciacionCentroCosto() {
		return this.resaltarporcentajeGastoDepreciacionCentroCosto;
	}

	public void setResaltarporcentajeGastoDepreciacionCentroCosto(Border borderResaltar) {
		this.resaltarporcentajeGastoDepreciacionCentroCosto= borderResaltar;
	}

	public Boolean getMostrarporcentajeGastoDepreciacionCentroCosto() {
		return this.mostrarporcentajeGastoDepreciacionCentroCosto;
	}

	public void setMostrarporcentajeGastoDepreciacionCentroCosto(Boolean mostrarporcentajeGastoDepreciacionCentroCosto) {
		this.mostrarporcentajeGastoDepreciacionCentroCosto= mostrarporcentajeGastoDepreciacionCentroCosto;
	}

	public Boolean getActivarporcentajeGastoDepreciacionCentroCosto() {
		return this.activarporcentajeGastoDepreciacionCentroCosto;
	}

	public void setActivarporcentajeGastoDepreciacionCentroCosto(Boolean activarporcentajeGastoDepreciacionCentroCosto) {
		this.activarporcentajeGastoDepreciacionCentroCosto= activarporcentajeGastoDepreciacionCentroCosto;
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
		
		
		this.setMostraridGastoDepreciacionCentroCosto(esInicial);
		this.setMostrarid_empresaGastoDepreciacionCentroCosto(esInicial);
		this.setMostrarid_sucursalGastoDepreciacionCentroCosto(esInicial);
		this.setMostrarid_centro_costoGastoDepreciacionCentroCosto(esInicial);
		this.setMostrarid_detalle_activo_fijoGastoDepreciacionCentroCosto(esInicial);
		this.setMostrarid_cuenta_contableGastoDepreciacionCentroCosto(esInicial);
		this.setMostrarporcentajeGastoDepreciacionCentroCosto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(GastoDepreciacionCentroCostoConstantesFunciones.ID)) {
				this.setMostraridGastoDepreciacionCentroCosto(esAsigna);
				continue;
			}

			if(campo.clase.equals(GastoDepreciacionCentroCostoConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaGastoDepreciacionCentroCosto(esAsigna);
				continue;
			}

			if(campo.clase.equals(GastoDepreciacionCentroCostoConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalGastoDepreciacionCentroCosto(esAsigna);
				continue;
			}

			if(campo.clase.equals(GastoDepreciacionCentroCostoConstantesFunciones.IDCENTROCOSTO)) {
				this.setMostrarid_centro_costoGastoDepreciacionCentroCosto(esAsigna);
				continue;
			}

			if(campo.clase.equals(GastoDepreciacionCentroCostoConstantesFunciones.IDDETALLEACTIVOFIJO)) {
				this.setMostrarid_detalle_activo_fijoGastoDepreciacionCentroCosto(esAsigna);
				continue;
			}

			if(campo.clase.equals(GastoDepreciacionCentroCostoConstantesFunciones.IDCUENTACONTABLE)) {
				this.setMostrarid_cuenta_contableGastoDepreciacionCentroCosto(esAsigna);
				continue;
			}

			if(campo.clase.equals(GastoDepreciacionCentroCostoConstantesFunciones.PORCENTAJE)) {
				this.setMostrarporcentajeGastoDepreciacionCentroCosto(esAsigna);
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
		
		
		this.setActivaridGastoDepreciacionCentroCosto(esInicial);
		this.setActivarid_empresaGastoDepreciacionCentroCosto(esInicial);
		this.setActivarid_sucursalGastoDepreciacionCentroCosto(esInicial);
		this.setActivarid_centro_costoGastoDepreciacionCentroCosto(esInicial);
		this.setActivarid_detalle_activo_fijoGastoDepreciacionCentroCosto(esInicial);
		this.setActivarid_cuenta_contableGastoDepreciacionCentroCosto(esInicial);
		this.setActivarporcentajeGastoDepreciacionCentroCosto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(GastoDepreciacionCentroCostoConstantesFunciones.ID)) {
				this.setActivaridGastoDepreciacionCentroCosto(esAsigna);
				continue;
			}

			if(campo.clase.equals(GastoDepreciacionCentroCostoConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaGastoDepreciacionCentroCosto(esAsigna);
				continue;
			}

			if(campo.clase.equals(GastoDepreciacionCentroCostoConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalGastoDepreciacionCentroCosto(esAsigna);
				continue;
			}

			if(campo.clase.equals(GastoDepreciacionCentroCostoConstantesFunciones.IDCENTROCOSTO)) {
				this.setActivarid_centro_costoGastoDepreciacionCentroCosto(esAsigna);
				continue;
			}

			if(campo.clase.equals(GastoDepreciacionCentroCostoConstantesFunciones.IDDETALLEACTIVOFIJO)) {
				this.setActivarid_detalle_activo_fijoGastoDepreciacionCentroCosto(esAsigna);
				continue;
			}

			if(campo.clase.equals(GastoDepreciacionCentroCostoConstantesFunciones.IDCUENTACONTABLE)) {
				this.setActivarid_cuenta_contableGastoDepreciacionCentroCosto(esAsigna);
				continue;
			}

			if(campo.clase.equals(GastoDepreciacionCentroCostoConstantesFunciones.PORCENTAJE)) {
				this.setActivarporcentajeGastoDepreciacionCentroCosto(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,GastoDepreciacionCentroCostoBeanSwingJInternalFrame gastodepreciacioncentrocostoBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridGastoDepreciacionCentroCosto(esInicial);
		this.setResaltarid_empresaGastoDepreciacionCentroCosto(esInicial);
		this.setResaltarid_sucursalGastoDepreciacionCentroCosto(esInicial);
		this.setResaltarid_centro_costoGastoDepreciacionCentroCosto(esInicial);
		this.setResaltarid_detalle_activo_fijoGastoDepreciacionCentroCosto(esInicial);
		this.setResaltarid_cuenta_contableGastoDepreciacionCentroCosto(esInicial);
		this.setResaltarporcentajeGastoDepreciacionCentroCosto(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(GastoDepreciacionCentroCostoConstantesFunciones.ID)) {
				this.setResaltaridGastoDepreciacionCentroCosto(esAsigna);
				continue;
			}

			if(campo.clase.equals(GastoDepreciacionCentroCostoConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaGastoDepreciacionCentroCosto(esAsigna);
				continue;
			}

			if(campo.clase.equals(GastoDepreciacionCentroCostoConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalGastoDepreciacionCentroCosto(esAsigna);
				continue;
			}

			if(campo.clase.equals(GastoDepreciacionCentroCostoConstantesFunciones.IDCENTROCOSTO)) {
				this.setResaltarid_centro_costoGastoDepreciacionCentroCosto(esAsigna);
				continue;
			}

			if(campo.clase.equals(GastoDepreciacionCentroCostoConstantesFunciones.IDDETALLEACTIVOFIJO)) {
				this.setResaltarid_detalle_activo_fijoGastoDepreciacionCentroCosto(esAsigna);
				continue;
			}

			if(campo.clase.equals(GastoDepreciacionCentroCostoConstantesFunciones.IDCUENTACONTABLE)) {
				this.setResaltarid_cuenta_contableGastoDepreciacionCentroCosto(esAsigna);
				continue;
			}

			if(campo.clase.equals(GastoDepreciacionCentroCostoConstantesFunciones.PORCENTAJE)) {
				this.setResaltarporcentajeGastoDepreciacionCentroCosto(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,GastoDepreciacionCentroCostoBeanSwingJInternalFrame gastodepreciacioncentrocostoBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdCentroCostoGastoDepreciacionCentroCosto=true;

	public Boolean getMostrarFK_IdCentroCostoGastoDepreciacionCentroCosto() {
		return this.mostrarFK_IdCentroCostoGastoDepreciacionCentroCosto;
	}

	public void setMostrarFK_IdCentroCostoGastoDepreciacionCentroCosto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCentroCostoGastoDepreciacionCentroCosto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdCuentaContableGastoDepreciacionCentroCosto=true;

	public Boolean getMostrarFK_IdCuentaContableGastoDepreciacionCentroCosto() {
		return this.mostrarFK_IdCuentaContableGastoDepreciacionCentroCosto;
	}

	public void setMostrarFK_IdCuentaContableGastoDepreciacionCentroCosto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdCuentaContableGastoDepreciacionCentroCosto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdDetalleActivoFijoGastoDepreciacionCentroCosto=true;

	public Boolean getMostrarFK_IdDetalleActivoFijoGastoDepreciacionCentroCosto() {
		return this.mostrarFK_IdDetalleActivoFijoGastoDepreciacionCentroCosto;
	}

	public void setMostrarFK_IdDetalleActivoFijoGastoDepreciacionCentroCosto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdDetalleActivoFijoGastoDepreciacionCentroCosto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaGastoDepreciacionCentroCosto=true;

	public Boolean getMostrarFK_IdEmpresaGastoDepreciacionCentroCosto() {
		return this.mostrarFK_IdEmpresaGastoDepreciacionCentroCosto;
	}

	public void setMostrarFK_IdEmpresaGastoDepreciacionCentroCosto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaGastoDepreciacionCentroCosto= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalGastoDepreciacionCentroCosto=true;

	public Boolean getMostrarFK_IdSucursalGastoDepreciacionCentroCosto() {
		return this.mostrarFK_IdSucursalGastoDepreciacionCentroCosto;
	}

	public void setMostrarFK_IdSucursalGastoDepreciacionCentroCosto(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalGastoDepreciacionCentroCosto= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdCentroCostoGastoDepreciacionCentroCosto=true;

	public Boolean getActivarFK_IdCentroCostoGastoDepreciacionCentroCosto() {
		return this.activarFK_IdCentroCostoGastoDepreciacionCentroCosto;
	}

	public void setActivarFK_IdCentroCostoGastoDepreciacionCentroCosto(Boolean habilitarResaltar) {
		this.activarFK_IdCentroCostoGastoDepreciacionCentroCosto= habilitarResaltar;
	}

	public Boolean activarFK_IdCuentaContableGastoDepreciacionCentroCosto=true;

	public Boolean getActivarFK_IdCuentaContableGastoDepreciacionCentroCosto() {
		return this.activarFK_IdCuentaContableGastoDepreciacionCentroCosto;
	}

	public void setActivarFK_IdCuentaContableGastoDepreciacionCentroCosto(Boolean habilitarResaltar) {
		this.activarFK_IdCuentaContableGastoDepreciacionCentroCosto= habilitarResaltar;
	}

	public Boolean activarFK_IdDetalleActivoFijoGastoDepreciacionCentroCosto=true;

	public Boolean getActivarFK_IdDetalleActivoFijoGastoDepreciacionCentroCosto() {
		return this.activarFK_IdDetalleActivoFijoGastoDepreciacionCentroCosto;
	}

	public void setActivarFK_IdDetalleActivoFijoGastoDepreciacionCentroCosto(Boolean habilitarResaltar) {
		this.activarFK_IdDetalleActivoFijoGastoDepreciacionCentroCosto= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaGastoDepreciacionCentroCosto=true;

	public Boolean getActivarFK_IdEmpresaGastoDepreciacionCentroCosto() {
		return this.activarFK_IdEmpresaGastoDepreciacionCentroCosto;
	}

	public void setActivarFK_IdEmpresaGastoDepreciacionCentroCosto(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaGastoDepreciacionCentroCosto= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalGastoDepreciacionCentroCosto=true;

	public Boolean getActivarFK_IdSucursalGastoDepreciacionCentroCosto() {
		return this.activarFK_IdSucursalGastoDepreciacionCentroCosto;
	}

	public void setActivarFK_IdSucursalGastoDepreciacionCentroCosto(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalGastoDepreciacionCentroCosto= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdCentroCostoGastoDepreciacionCentroCosto=null;

	public Border getResaltarFK_IdCentroCostoGastoDepreciacionCentroCosto() {
		return this.resaltarFK_IdCentroCostoGastoDepreciacionCentroCosto;
	}

	public void setResaltarFK_IdCentroCostoGastoDepreciacionCentroCosto(Border borderResaltar) {
		this.resaltarFK_IdCentroCostoGastoDepreciacionCentroCosto= borderResaltar;
	}

	public void setResaltarFK_IdCentroCostoGastoDepreciacionCentroCosto(ParametroGeneralUsuario parametroGeneralUsuario/*GastoDepreciacionCentroCostoBeanSwingJInternalFrame gastodepreciacioncentrocostoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCentroCostoGastoDepreciacionCentroCosto= borderResaltar;
	}

	public Border resaltarFK_IdCuentaContableGastoDepreciacionCentroCosto=null;

	public Border getResaltarFK_IdCuentaContableGastoDepreciacionCentroCosto() {
		return this.resaltarFK_IdCuentaContableGastoDepreciacionCentroCosto;
	}

	public void setResaltarFK_IdCuentaContableGastoDepreciacionCentroCosto(Border borderResaltar) {
		this.resaltarFK_IdCuentaContableGastoDepreciacionCentroCosto= borderResaltar;
	}

	public void setResaltarFK_IdCuentaContableGastoDepreciacionCentroCosto(ParametroGeneralUsuario parametroGeneralUsuario/*GastoDepreciacionCentroCostoBeanSwingJInternalFrame gastodepreciacioncentrocostoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdCuentaContableGastoDepreciacionCentroCosto= borderResaltar;
	}

	public Border resaltarFK_IdDetalleActivoFijoGastoDepreciacionCentroCosto=null;

	public Border getResaltarFK_IdDetalleActivoFijoGastoDepreciacionCentroCosto() {
		return this.resaltarFK_IdDetalleActivoFijoGastoDepreciacionCentroCosto;
	}

	public void setResaltarFK_IdDetalleActivoFijoGastoDepreciacionCentroCosto(Border borderResaltar) {
		this.resaltarFK_IdDetalleActivoFijoGastoDepreciacionCentroCosto= borderResaltar;
	}

	public void setResaltarFK_IdDetalleActivoFijoGastoDepreciacionCentroCosto(ParametroGeneralUsuario parametroGeneralUsuario/*GastoDepreciacionCentroCostoBeanSwingJInternalFrame gastodepreciacioncentrocostoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdDetalleActivoFijoGastoDepreciacionCentroCosto= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaGastoDepreciacionCentroCosto=null;

	public Border getResaltarFK_IdEmpresaGastoDepreciacionCentroCosto() {
		return this.resaltarFK_IdEmpresaGastoDepreciacionCentroCosto;
	}

	public void setResaltarFK_IdEmpresaGastoDepreciacionCentroCosto(Border borderResaltar) {
		this.resaltarFK_IdEmpresaGastoDepreciacionCentroCosto= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaGastoDepreciacionCentroCosto(ParametroGeneralUsuario parametroGeneralUsuario/*GastoDepreciacionCentroCostoBeanSwingJInternalFrame gastodepreciacioncentrocostoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaGastoDepreciacionCentroCosto= borderResaltar;
	}

	public Border resaltarFK_IdSucursalGastoDepreciacionCentroCosto=null;

	public Border getResaltarFK_IdSucursalGastoDepreciacionCentroCosto() {
		return this.resaltarFK_IdSucursalGastoDepreciacionCentroCosto;
	}

	public void setResaltarFK_IdSucursalGastoDepreciacionCentroCosto(Border borderResaltar) {
		this.resaltarFK_IdSucursalGastoDepreciacionCentroCosto= borderResaltar;
	}

	public void setResaltarFK_IdSucursalGastoDepreciacionCentroCosto(ParametroGeneralUsuario parametroGeneralUsuario/*GastoDepreciacionCentroCostoBeanSwingJInternalFrame gastodepreciacioncentrocostoBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalGastoDepreciacionCentroCosto= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}