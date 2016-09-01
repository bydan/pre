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


import com.bydan.erp.tesoreria.util.DetallePagoChequeConstantesFunciones;
import com.bydan.erp.tesoreria.util.DetallePagoChequeParameterReturnGeneral;
//import com.bydan.erp.tesoreria.util.DetallePagoChequeParameterGeneral;

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
final public class DetallePagoChequeConstantesFunciones extends DetallePagoChequeConstantesFuncionesAdditional {		
	
	
	
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
	public static final String SNOMBREOPCION="DetallePagoCheque";
	public static final String SPATHOPCION="Tesoreria";	
	public static final String SPATHMODULO="tesoreria/";		
	public static final String SPERSISTENCECONTEXTNAME="";
	public static final String SPERSISTENCENAME="DetallePagoCheque"+DetallePagoChequeConstantesFunciones.SPERSISTENCECONTEXTNAME+Constantes.SPERSISTENCECONTEXTNAME;
	public static final String SEJBNAME="DetallePagoChequeHomeRemote";
	public static final String SEJBNAME_ADDITIONAL="DetallePagoChequeHomeRemoteAdditional";
	
	
	//RMI
	public static final String SLOCALEJBNAME_RMI=DetallePagoChequeConstantesFunciones.SCHEMA+"_"+DetallePagoChequeConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBLOCAL;//"erp/DetallePagoChequeHomeRemote/local"
	public static final String SREMOTEEJBNAME_RMI=DetallePagoChequeConstantesFunciones.SCHEMA+"_"+DetallePagoChequeConstantesFunciones.SEJBNAME+"_"+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL_RMI=DetallePagoChequeConstantesFunciones.SCHEMA+"_"+DetallePagoChequeConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBLOCAL;//"erp/DetallePagoChequeHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL_RMI=DetallePagoChequeConstantesFunciones.SCHEMA+"_"+DetallePagoChequeConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+"_"+Constantes.SEJBREMOTE;//remote		
	//RMI
	
	//JBOSS5.1
	public static final String SLOCALEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetallePagoChequeConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DetallePagoChequeHomeRemote/local"
	public static final String SREMOTEEJBNAME=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetallePagoChequeConstantesFunciones.SEJBNAME+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote	
	
	public static final String SLOCALEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetallePagoChequeConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBLOCAL;//"erp/DetallePagoChequeHomeRemote/local"
	public static final String SREMOTEEJBNAMEADDITIONAL=Constantes.SEJBPACKAGE+Constantes.SEJBSEPARATOR+DetallePagoChequeConstantesFunciones.SEJBNAME+Constantes.SEJBADDITIONAL+Constantes.SEJBSEPARATOR+Constantes.SEJBREMOTE;//remote		
	//JBOSS5.1
	
	
	public static final String SSESSIONNAME=DetallePagoChequeConstantesFunciones.OBJECTNAME + Constantes.SSESSIONBEAN;	
	public static final String SSESSIONNAME_FACE=Constantes.SFACE_INI+DetallePagoChequeConstantesFunciones.SSESSIONNAME + Constantes.SFACE_FIN;	
	public static final String SREQUESTNAME=DetallePagoChequeConstantesFunciones.OBJECTNAME + Constantes.SREQUESTBEAN;			
	public static final String SREQUESTNAME_FACE=Constantes.SFACE_INI+DetallePagoChequeConstantesFunciones.SREQUESTNAME + Constantes.SFACE_FIN;	
	public static final String SCLASSNAMETITULOREPORTES="Detalle Pago Cheques";
	public static final String SRELATIVEPATH="../../../";
	public static final String SCLASSPLURAL="s";
	public static final String SCLASSWEBTITULO="Detalle Pago Cheque";
	public static final String SCLASSWEBTITULO_LOWER="Detalle Pago Cheque";
	public static Integer INUMEROPAGINACION=10;
	public static Integer ITAMANIOFILATABLA=Constantes.ISWING_ALTO_FILA;
	public static Boolean ES_DEBUG=false;
	public static Boolean CON_DESCRIPCION_DETALLADO=false;
	
	public static final String CLASSNAME="DetallePagoCheque";
	public static final String OBJECTNAME="detallepagocheque";
	
	//PARA FORMAR QUERYS
	public static final String SCHEMA=Constantes.SCHEMA_TESORERIA;	
	public static final String TABLENAME="detalle_pago_cheque";
	public static final String SQL_SECUENCIAL=SCHEMA+"."+TABLENAME+"_id_seq";
	
	public static String QUERYSELECT="select detallepagocheque from "+DetallePagoChequeConstantesFunciones.SPERSISTENCENAME+" detallepagocheque";
	public static String QUERYSELECTNATIVE="select "+DetallePagoChequeConstantesFunciones.SCHEMA+"."+DetallePagoChequeConstantesFunciones.TABLENAME+".id,"+DetallePagoChequeConstantesFunciones.SCHEMA+"."+DetallePagoChequeConstantesFunciones.TABLENAME+".version_row,"+DetallePagoChequeConstantesFunciones.SCHEMA+"."+DetallePagoChequeConstantesFunciones.TABLENAME+".id_empresa,"+DetallePagoChequeConstantesFunciones.SCHEMA+"."+DetallePagoChequeConstantesFunciones.TABLENAME+".id_sucursal,"+DetallePagoChequeConstantesFunciones.SCHEMA+"."+DetallePagoChequeConstantesFunciones.TABLENAME+".id_asiento_contable,"+DetallePagoChequeConstantesFunciones.SCHEMA+"."+DetallePagoChequeConstantesFunciones.TABLENAME+".id_ejercicio,"+DetallePagoChequeConstantesFunciones.SCHEMA+"."+DetallePagoChequeConstantesFunciones.TABLENAME+".id_periodo,"+DetallePagoChequeConstantesFunciones.SCHEMA+"."+DetallePagoChequeConstantesFunciones.TABLENAME+".valor,"+DetallePagoChequeConstantesFunciones.SCHEMA+"."+DetallePagoChequeConstantesFunciones.TABLENAME+".id_anio,"+DetallePagoChequeConstantesFunciones.SCHEMA+"."+DetallePagoChequeConstantesFunciones.TABLENAME+".id_mes from "+DetallePagoChequeConstantesFunciones.SCHEMA+"."+DetallePagoChequeConstantesFunciones.TABLENAME;//+" as "+DetallePagoChequeConstantesFunciones.TABLENAME;
	
	//AUDITORIA
	public static Boolean ISCONAUDITORIA=false;	
	public static Boolean ISCONAUDITORIADETALLE=true;	
	
	//GUARDAR SOLO MAESTRO DETALLE FUNCIONALIDAD
	public static Boolean ISGUARDARREL=false;
	
	
	protected DetallePagoChequeConstantesFuncionesAdditional detallepagochequeConstantesFuncionesAdditional=null;
	
	public DetallePagoChequeConstantesFuncionesAdditional getDetallePagoChequeConstantesFuncionesAdditional() {
		return this.detallepagochequeConstantesFuncionesAdditional;
	}
	
	public void setDetallePagoChequeConstantesFuncionesAdditional(DetallePagoChequeConstantesFuncionesAdditional detallepagochequeConstantesFuncionesAdditional) {
		try {
			this.detallepagochequeConstantesFuncionesAdditional=detallepagochequeConstantesFuncionesAdditional;
		} catch(Exception e) {
			;
		}
	}
	
	
	
	public static final String ID=ConstantesSql.ID;
	public static final String VERSIONROW=ConstantesSql.VERSIONROW;
    public static final String IDEMPRESA= "id_empresa";
    public static final String IDSUCURSAL= "id_sucursal";
    public static final String IDASIENTOCONTABLE= "id_asiento_contable";
    public static final String IDEJERCICIO= "id_ejercicio";
    public static final String IDPERIODO= "id_periodo";
    public static final String VALOR= "valor";
    public static final String IDANIO= "id_anio";
    public static final String IDMES= "id_mes";
	//TITULO CAMPO
    	public static final String LABEL_ID= "Id";
		public static final String LABEL_ID_LOWER= "id";
    	public static final String LABEL_VERSIONROW= "Versionrow";
		public static final String LABEL_VERSIONROW_LOWER= "version Row";
    	public static final String LABEL_IDEMPRESA= "Empresa";
		public static final String LABEL_IDEMPRESA_LOWER= "Empresa";
    	public static final String LABEL_IDSUCURSAL= "Sucursal";
		public static final String LABEL_IDSUCURSAL_LOWER= "Sucursal";
    	public static final String LABEL_IDASIENTOCONTABLE= "Asiento Contable";
		public static final String LABEL_IDASIENTOCONTABLE_LOWER= "Asiento Contable";
    	public static final String LABEL_IDEJERCICIO= "Ejercicio";
		public static final String LABEL_IDEJERCICIO_LOWER= "Ejercicio";
    	public static final String LABEL_IDPERIODO= "Periodo";
		public static final String LABEL_IDPERIODO_LOWER= "Periodo";
    	public static final String LABEL_VALOR= "Valor";
		public static final String LABEL_VALOR_LOWER= "Valor";
    	public static final String LABEL_IDANIO= "Anio";
		public static final String LABEL_IDANIO_LOWER= "Anio";
    	public static final String LABEL_IDMES= "Mes";
		public static final String LABEL_IDMES_LOWER= "Mes";
	
		
		
		
		
		
		
		
		
		
		
	
	public static String getDetallePagoChequeLabelDesdeNombre(String sNombreColumna) {
		String sLabelColumna="";
		
		if(sNombreColumna.equals(DetallePagoChequeConstantesFunciones.IDEMPRESA)) {sLabelColumna=DetallePagoChequeConstantesFunciones.LABEL_IDEMPRESA;}
		if(sNombreColumna.equals(DetallePagoChequeConstantesFunciones.IDSUCURSAL)) {sLabelColumna=DetallePagoChequeConstantesFunciones.LABEL_IDSUCURSAL;}
		if(sNombreColumna.equals(DetallePagoChequeConstantesFunciones.IDASIENTOCONTABLE)) {sLabelColumna=DetallePagoChequeConstantesFunciones.LABEL_IDASIENTOCONTABLE;}
		if(sNombreColumna.equals(DetallePagoChequeConstantesFunciones.IDEJERCICIO)) {sLabelColumna=DetallePagoChequeConstantesFunciones.LABEL_IDEJERCICIO;}
		if(sNombreColumna.equals(DetallePagoChequeConstantesFunciones.IDPERIODO)) {sLabelColumna=DetallePagoChequeConstantesFunciones.LABEL_IDPERIODO;}
		if(sNombreColumna.equals(DetallePagoChequeConstantesFunciones.VALOR)) {sLabelColumna=DetallePagoChequeConstantesFunciones.LABEL_VALOR;}
		if(sNombreColumna.equals(DetallePagoChequeConstantesFunciones.IDANIO)) {sLabelColumna=DetallePagoChequeConstantesFunciones.LABEL_IDANIO;}
		if(sNombreColumna.equals(DetallePagoChequeConstantesFunciones.IDMES)) {sLabelColumna=DetallePagoChequeConstantesFunciones.LABEL_IDMES;}
		
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
	
	
	
			
			
			
			
			
			
			
			
			
			
	
	public static String getDetallePagoChequeDescripcion(DetallePagoCheque detallepagocheque) {
		String sDescripcion=Constantes.SCAMPONONE;
			
		if(detallepagocheque !=null/* && detallepagocheque.getId()!=0*/) {
			if(detallepagocheque.getId()!=null) {
				sDescripcion=detallepagocheque.getId().toString();
			}//detallepagochequedetallepagocheque.getId().toString();
		}
			
		return sDescripcion;
	}
	
	public static String getDetallePagoChequeDescripcionDetallado(DetallePagoCheque detallepagocheque) {
		String sDescripcion="";
			
		sDescripcion+=DetallePagoChequeConstantesFunciones.ID+"=";
		sDescripcion+=detallepagocheque.getId().toString()+",";
		sDescripcion+=DetallePagoChequeConstantesFunciones.VERSIONROW+"=";
		sDescripcion+=detallepagocheque.getVersionRow().toString()+",";
		sDescripcion+=DetallePagoChequeConstantesFunciones.IDEMPRESA+"=";
		sDescripcion+=detallepagocheque.getid_empresa().toString()+",";
		sDescripcion+=DetallePagoChequeConstantesFunciones.IDSUCURSAL+"=";
		sDescripcion+=detallepagocheque.getid_sucursal().toString()+",";
		sDescripcion+=DetallePagoChequeConstantesFunciones.IDASIENTOCONTABLE+"=";
		sDescripcion+=detallepagocheque.getid_asiento_contable().toString()+",";
		sDescripcion+=DetallePagoChequeConstantesFunciones.IDEJERCICIO+"=";
		sDescripcion+=detallepagocheque.getid_ejercicio().toString()+",";
		sDescripcion+=DetallePagoChequeConstantesFunciones.IDPERIODO+"=";
		sDescripcion+=detallepagocheque.getid_periodo().toString()+",";
		sDescripcion+=DetallePagoChequeConstantesFunciones.VALOR+"=";
		sDescripcion+=detallepagocheque.getvalor().toString()+",";
		sDescripcion+=DetallePagoChequeConstantesFunciones.IDANIO+"=";
		sDescripcion+=detallepagocheque.getid_anio().toString()+",";
		sDescripcion+=DetallePagoChequeConstantesFunciones.IDMES+"=";
		sDescripcion+=detallepagocheque.getid_mes().toString()+",";
			
		return sDescripcion;
	}
	
	public static void setDetallePagoChequeDescripcion(DetallePagoCheque detallepagocheque,String sValor) throws Exception {			
		if(detallepagocheque !=null) {
			//detallepagochequedetallepagocheque.getId().toString();
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

	public static String getAsientoContableDescripcion(AsientoContable asientocontable) {
		String sDescripcion=Constantes.SCAMPONONE;

		if(asientocontable!=null/*&&asientocontable.getId()>0*/) {
			sDescripcion=AsientoContableConstantesFunciones.getAsientoContableDescripcion(asientocontable);
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
		} else if(sNombreIndice.equals("FK_IdAsientoContable")) {
			sNombreIndice="Tipo=  Por Asiento Contable";
		} else if(sNombreIndice.equals("FK_IdEjercicio")) {
			sNombreIndice="Tipo=  Por Ejercicio";
		} else if(sNombreIndice.equals("FK_IdEmpresa")) {
			sNombreIndice="Tipo=  Por Empresa";
		} else if(sNombreIndice.equals("FK_IdMes")) {
			sNombreIndice="Tipo=  Por Mes";
		} else if(sNombreIndice.equals("FK_IdPeriodo")) {
			sNombreIndice="Tipo=  Por Periodo";
		} else if(sNombreIndice.equals("FK_IdSucursal")) {
			sNombreIndice="Tipo=  Por Sucursal";
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

	public static String getDetalleIndiceFK_IdAsientoContable(Long id_asiento_contable) {
		String sDetalleIndice=" Parametros->";
		if(id_asiento_contable!=null) {sDetalleIndice+=" Codigo Unico De Asiento Contable="+id_asiento_contable.toString();} 

		return sDetalleIndice;
	}

	public static String getDetalleIndiceFK_IdEjercicio(Long id_ejercicio) {
		String sDetalleIndice=" Parametros->";
		if(id_ejercicio!=null) {sDetalleIndice+=" Codigo Unico De Ejercicio="+id_ejercicio.toString();} 

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
	
	
	
	
	
	
	public static void quitarEspaciosDetallePagoCheque(DetallePagoCheque detallepagocheque,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
	}
	
	public static void quitarEspaciosDetallePagoCheques(List<DetallePagoCheque> detallepagocheques,ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		
		for(DetallePagoCheque detallepagocheque: detallepagocheques) {
		
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDetallePagoCheque(DetallePagoCheque detallepagocheque,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		if(conAsignarBase && detallepagocheque.getConCambioAuxiliar()) {
			detallepagocheque.setIsDeleted(detallepagocheque.getIsDeletedAuxiliar());	
			detallepagocheque.setIsNew(detallepagocheque.getIsNewAuxiliar());	
			detallepagocheque.setIsChanged(detallepagocheque.getIsChangedAuxiliar());
			
			//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
			detallepagocheque.setConCambioAuxiliar(false);
		}
		
		if(conInicializarAuxiliar) {
			detallepagocheque.setIsDeletedAuxiliar(false);	
			detallepagocheque.setIsNewAuxiliar(false);	
			detallepagocheque.setIsChangedAuxiliar(false);
			
			detallepagocheque.setConCambioAuxiliar(false);
		}
	}
	
	public static void InicializarGeneralEntityAuxiliaresDetallePagoCheques(List<DetallePagoCheque> detallepagocheques,Boolean conAsignarBase,Boolean conInicializarAuxiliar) throws Exception  {
		
		for(DetallePagoCheque detallepagocheque : detallepagocheques) {
			if(conAsignarBase && detallepagocheque.getConCambioAuxiliar()) {
				detallepagocheque.setIsDeleted(detallepagocheque.getIsDeletedAuxiliar());	
				detallepagocheque.setIsNew(detallepagocheque.getIsNewAuxiliar());	
				detallepagocheque.setIsChanged(detallepagocheque.getIsChangedAuxiliar());
				
				//YA RESTAURO, NO DEBERIA HACERLO NUEVAMENTE AL MENOS NO HASTA GUARDAR OTRA VEZ
				detallepagocheque.setConCambioAuxiliar(false);
			}
			
			if(conInicializarAuxiliar) {
				detallepagocheque.setIsDeletedAuxiliar(false);	
				detallepagocheque.setIsNewAuxiliar(false);	
				detallepagocheque.setIsChangedAuxiliar(false);
				
				detallepagocheque.setConCambioAuxiliar(false);
			}
		}
	}	
	
	public static void InicializarValoresDetallePagoCheque(DetallePagoCheque detallepagocheque,Boolean conEnteros) throws Exception  {
		detallepagocheque.setvalor(0.0);
		
		if(conEnteros) {
			Short ish_value=0;
			
		}
	}		
	
	public static void InicializarValoresDetallePagoCheques(List<DetallePagoCheque> detallepagocheques,Boolean conEnteros) throws Exception  {
		
		for(DetallePagoCheque detallepagocheque: detallepagocheques) {
			detallepagocheque.setvalor(0.0);
		
			if(conEnteros) {
				Short ish_value=0;
				
			}
		}				
	}
	
	public static void TotalizarValoresFilaDetallePagoCheque(List<DetallePagoCheque> detallepagocheques,DetallePagoCheque detallepagochequeAux) throws Exception  {
		DetallePagoChequeConstantesFunciones.InicializarValoresDetallePagoCheque(detallepagochequeAux,true);
		
		for(DetallePagoCheque detallepagocheque: detallepagocheques) {
			if(detallepagocheque.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			detallepagochequeAux.setvalor(detallepagochequeAux.getvalor()+detallepagocheque.getvalor());			
		}
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesDetallePagoCheque(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		arrColumnasGlobales=DetallePagoChequeConstantesFunciones.getArrayColumnasGlobalesDetallePagoCheque(arrDatoGeneral,new ArrayList<String>());
		
		return arrColumnasGlobales;
	}		
	
	public static ArrayList<String> getArrayColumnasGlobalesDetallePagoCheque(ArrayList<DatoGeneral> arrDatoGeneral,ArrayList<String> arrColumnasGlobalesNo) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		Boolean noExiste=false;
		
		

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetallePagoChequeConstantesFunciones.IDEMPRESA)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetallePagoChequeConstantesFunciones.IDEMPRESA);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetallePagoChequeConstantesFunciones.IDSUCURSAL)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetallePagoChequeConstantesFunciones.IDSUCURSAL);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetallePagoChequeConstantesFunciones.IDEJERCICIO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetallePagoChequeConstantesFunciones.IDEJERCICIO);
		}

		noExiste=false;
		for(String sColumnaGlobalNo:arrColumnasGlobalesNo) {
			if(sColumnaGlobalNo.equals(DetallePagoChequeConstantesFunciones.IDPERIODO)) {
				noExiste=true;
			}
		}

		if(!noExiste) {
			arrColumnasGlobales.add(DetallePagoChequeConstantesFunciones.IDPERIODO);
		}
		
		return arrColumnasGlobales;
	}
	
	public static ArrayList<String> getArrayColumnasGlobalesNoDetallePagoCheque(ArrayList<DatoGeneral> arrDatoGeneral) throws Exception  {
		ArrayList<String> arrColumnasGlobales=new ArrayList<String>();
		
		
		
		return arrColumnasGlobales;
	}
	
	public static Boolean ExisteEnLista(List<DetallePagoCheque> detallepagocheques,DetallePagoCheque detallepagocheque,Boolean conIdNulo) throws Exception  {
		Boolean existe=false;
		
		for(DetallePagoCheque detallepagochequeAux: detallepagocheques) {
			if(detallepagochequeAux!=null && detallepagocheque!=null) {
				if((detallepagochequeAux.getId()==null && detallepagocheque.getId()==null) && conIdNulo) {
					existe=true;
					break;
					
				} else if(detallepagochequeAux.getId()!=null && detallepagocheque.getId()!=null){
					if(detallepagochequeAux.getId().equals(detallepagocheque.getId())) {
						existe=true;
						break;
					}
				}
			}
		}
		
		return existe;
	}
		
	public static ArrayList<DatoGeneral> getTotalesListaDetallePagoCheque(List<DetallePagoCheque> detallepagocheques) throws Exception  {
		ArrayList<DatoGeneral> arrTotalesDatoGeneral=new ArrayList<DatoGeneral>();
		DatoGeneral datoGeneral=new DatoGeneral();
		
		Double valorTotal=0.0;
	
		for(DetallePagoCheque detallepagocheque: detallepagocheques) {			
			if(detallepagocheque.getsType().equals(Constantes2.S_TOTALES)) {
				continue;
			}
			
			valorTotal+=detallepagocheque.getvalor();
		}
		
		
		datoGeneral=new DatoGeneral();
		datoGeneral.setsCodigo(DetallePagoChequeConstantesFunciones.VALOR);
		datoGeneral.setsDescripcion(DetallePagoChequeConstantesFunciones.LABEL_VALOR);
		datoGeneral.setdValorDouble(valorTotal);
		arrTotalesDatoGeneral.add(datoGeneral);
		
		return arrTotalesDatoGeneral;
	}
	
	public static ArrayList<OrderBy> getOrderByListaDetallePagoCheque() throws Exception  {
		ArrayList<OrderBy> arrOrderBy=new ArrayList<OrderBy>();
		OrderBy orderBy=new OrderBy();
		
		

		orderBy=new OrderBy(false,DetallePagoChequeConstantesFunciones.LABEL_ID, DetallePagoChequeConstantesFunciones.ID,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePagoChequeConstantesFunciones.LABEL_VERSIONROW, DetallePagoChequeConstantesFunciones.VERSIONROW,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePagoChequeConstantesFunciones.LABEL_IDEMPRESA, DetallePagoChequeConstantesFunciones.IDEMPRESA,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePagoChequeConstantesFunciones.LABEL_IDSUCURSAL, DetallePagoChequeConstantesFunciones.IDSUCURSAL,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePagoChequeConstantesFunciones.LABEL_IDASIENTOCONTABLE, DetallePagoChequeConstantesFunciones.IDASIENTOCONTABLE,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePagoChequeConstantesFunciones.LABEL_IDEJERCICIO, DetallePagoChequeConstantesFunciones.IDEJERCICIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePagoChequeConstantesFunciones.LABEL_IDPERIODO, DetallePagoChequeConstantesFunciones.IDPERIODO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePagoChequeConstantesFunciones.LABEL_VALOR, DetallePagoChequeConstantesFunciones.VALOR,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePagoChequeConstantesFunciones.LABEL_IDANIO, DetallePagoChequeConstantesFunciones.IDANIO,false,"");
		arrOrderBy.add(orderBy);

		orderBy=new OrderBy(false,DetallePagoChequeConstantesFunciones.LABEL_IDMES, DetallePagoChequeConstantesFunciones.IDMES,false,"");
		arrOrderBy.add(orderBy);
		
		return arrOrderBy;
	}
	
	public static List<String> getTodosTiposColumnasDetallePagoCheque() throws Exception  {
		List<String> arrTiposColumnas=new ArrayList<String>();
		String sTipoColumna=new String();
		
		

		sTipoColumna=new String();
		sTipoColumna=DetallePagoChequeConstantesFunciones.ID;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePagoChequeConstantesFunciones.VERSIONROW;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePagoChequeConstantesFunciones.IDEMPRESA;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePagoChequeConstantesFunciones.IDSUCURSAL;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePagoChequeConstantesFunciones.IDASIENTOCONTABLE;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePagoChequeConstantesFunciones.IDEJERCICIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePagoChequeConstantesFunciones.IDPERIODO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePagoChequeConstantesFunciones.VALOR;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePagoChequeConstantesFunciones.IDANIO;
		arrTiposColumnas.add(sTipoColumna);

		sTipoColumna=new String();
		sTipoColumna=DetallePagoChequeConstantesFunciones.IDMES;
		arrTiposColumnas.add(sTipoColumna);
		
		return arrTiposColumnas;
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetallePagoCheque() throws Exception  {
		return DetallePagoChequeConstantesFunciones.getTiposSeleccionarDetallePagoCheque(false,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetallePagoCheque(Boolean conFk) throws Exception  {
		return DetallePagoChequeConstantesFunciones.getTiposSeleccionarDetallePagoCheque(conFk,true,true,true,true);
	}
	
	public static ArrayList<Reporte> getTiposSeleccionarDetallePagoCheque(Boolean conFk,Boolean conStringColumn,Boolean conValorColumn,Boolean conFechaColumn,Boolean conBitColumn) throws Exception  {
		ArrayList<Reporte> arrTiposSeleccionarTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		
		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePagoChequeConstantesFunciones.LABEL_IDEMPRESA);
			reporte.setsDescripcion(DetallePagoChequeConstantesFunciones.LABEL_IDEMPRESA);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePagoChequeConstantesFunciones.LABEL_IDSUCURSAL);
			reporte.setsDescripcion(DetallePagoChequeConstantesFunciones.LABEL_IDSUCURSAL);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePagoChequeConstantesFunciones.LABEL_IDASIENTOCONTABLE);
			reporte.setsDescripcion(DetallePagoChequeConstantesFunciones.LABEL_IDASIENTOCONTABLE);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePagoChequeConstantesFunciones.LABEL_IDEJERCICIO);
			reporte.setsDescripcion(DetallePagoChequeConstantesFunciones.LABEL_IDEJERCICIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePagoChequeConstantesFunciones.LABEL_IDPERIODO);
			reporte.setsDescripcion(DetallePagoChequeConstantesFunciones.LABEL_IDPERIODO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conValorColumn) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePagoChequeConstantesFunciones.LABEL_VALOR);
			reporte.setsDescripcion(DetallePagoChequeConstantesFunciones.LABEL_VALOR);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePagoChequeConstantesFunciones.LABEL_IDANIO);
			reporte.setsDescripcion(DetallePagoChequeConstantesFunciones.LABEL_IDANIO);

			arrTiposSeleccionarTodos.add(reporte);
		}

		if(conFk) {
			reporte=new Reporte();
			reporte.setsCodigo(DetallePagoChequeConstantesFunciones.LABEL_IDMES);
			reporte.setsDescripcion(DetallePagoChequeConstantesFunciones.LABEL_IDMES);

			arrTiposSeleccionarTodos.add(reporte);
		}

		
		return arrTiposSeleccionarTodos;
	}
	
	public static ArrayList<Reporte> getTiposRelacionesDetallePagoCheque(Boolean conEspecial) throws Exception  {
		ArrayList<Reporte> arrTiposRelacionesTodos=new ArrayList<Reporte>();
		Reporte reporte=new Reporte();
		
		//ESTO ESTA EN CONTROLLER
		
		
		return arrTiposRelacionesTodos;
	}
	
	public static void refrescarForeignKeysDescripcionesDetallePagoCheque(DetallePagoCheque detallepagochequeAux) throws Exception {
		
			detallepagochequeAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(detallepagochequeAux.getEmpresa()));
			detallepagochequeAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(detallepagochequeAux.getSucursal()));
			detallepagochequeAux.setasientocontable_descripcion(AsientoContableConstantesFunciones.getAsientoContableDescripcion(detallepagochequeAux.getAsientoContable()));
			detallepagochequeAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(detallepagochequeAux.getEjercicio()));
			detallepagochequeAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(detallepagochequeAux.getPeriodo()));
			detallepagochequeAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(detallepagochequeAux.getAnio()));
			detallepagochequeAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(detallepagochequeAux.getMes()));		
	}
	
	public static void refrescarForeignKeysDescripcionesDetallePagoCheque(List<DetallePagoCheque> detallepagochequesTemp) throws Exception {
		for(DetallePagoCheque detallepagochequeAux:detallepagochequesTemp) {
			
			detallepagochequeAux.setempresa_descripcion(EmpresaConstantesFunciones.getEmpresaDescripcion(detallepagochequeAux.getEmpresa()));
			detallepagochequeAux.setsucursal_descripcion(SucursalConstantesFunciones.getSucursalDescripcion(detallepagochequeAux.getSucursal()));
			detallepagochequeAux.setasientocontable_descripcion(AsientoContableConstantesFunciones.getAsientoContableDescripcion(detallepagochequeAux.getAsientoContable()));
			detallepagochequeAux.setejercicio_descripcion(EjercicioConstantesFunciones.getEjercicioDescripcion(detallepagochequeAux.getEjercicio()));
			detallepagochequeAux.setperiodo_descripcion(PeriodoConstantesFunciones.getPeriodoDescripcion(detallepagochequeAux.getPeriodo()));
			detallepagochequeAux.setanio_descripcion(AnioConstantesFunciones.getAnioDescripcion(detallepagochequeAux.getAnio()));
			detallepagochequeAux.setmes_descripcion(MesConstantesFunciones.getMesDescripcion(detallepagochequeAux.getMes()));
		}
	}
	
	public static ArrayList<Classe> getClassesForeignKeysOfDetallePagoCheque(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			ArrayList<Classe> classes=new ArrayList<Classe>();	
			
			if(deepLoadType.equals(DeepLoadType.NONE)) {
				
				classes.add(new Classe(Empresa.class));
				classes.add(new Classe(Sucursal.class));
				classes.add(new Classe(AsientoContable.class));
				classes.add(new Classe(Ejercicio.class));
				classes.add(new Classe(Periodo.class));
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
					if(clas.clas.equals(AsientoContable.class)) {
						classes.add(new Classe(AsientoContable.class));
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
	
	public static ArrayList<Classe> getClassesForeignKeysFromStringsOfDetallePagoCheque(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
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

					if(AsientoContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(AsientoContable.class)); continue;
					}

					if(Ejercicio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ejercicio.class)); continue;
					}

					if(Periodo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Periodo.class)); continue;
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

					if(AsientoContable.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(AsientoContable.class)); continue;
					}

					if(Ejercicio.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Ejercicio.class)); continue;
					}

					if(Periodo.class.getSimpleName().equals(sClasse)) {
						classes.add(new Classe(Periodo.class)); continue;
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
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetallePagoCheque(ArrayList<Classe> classesP,DeepLoadType deepLoadType)throws Exception {
		try {
			return DetallePagoChequeConstantesFunciones.getClassesRelationshipsOfDetallePagoCheque(classesP,deepLoadType,true);
			
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}
	
	public static ArrayList<Classe> getClassesRelationshipsOfDetallePagoCheque(ArrayList<Classe> classesP,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDetallePagoCheque(ArrayList<String> arrClasses,DeepLoadType deepLoadType)throws Exception {
		try {
			return DetallePagoChequeConstantesFunciones.getClassesRelationshipsFromStringsOfDetallePagoCheque(arrClasses,deepLoadType,true);
		} catch(Exception e) {
			//Funciones.manageException(logger,e);
			throw e;
		}
	}	
	
	public static ArrayList<Classe> getClassesRelationshipsFromStringsOfDetallePagoCheque(ArrayList<String> arrClasses,DeepLoadType deepLoadType,Boolean conMuchosAMuchos)throws Exception {
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
	public static void actualizarLista(DetallePagoCheque detallepagocheque,List<DetallePagoCheque> detallepagocheques,Boolean permiteQuitar) throws Exception {
		try	{
			Boolean existe=false;
			DetallePagoCheque detallepagochequeEncontrado=null;
			
			for(DetallePagoCheque detallepagochequeLocal:detallepagocheques) {
				if(detallepagochequeLocal.getId().equals(detallepagocheque.getId())) {
					detallepagochequeEncontrado=detallepagochequeLocal;
					
					detallepagochequeLocal.setIsChanged(detallepagocheque.getIsChanged());
					detallepagochequeLocal.setIsNew(detallepagocheque.getIsNew());
					detallepagochequeLocal.setIsDeleted(detallepagocheque.getIsDeleted());
					
					detallepagochequeLocal.setGeneralEntityOriginal(detallepagocheque.getGeneralEntityOriginal());
					
					detallepagochequeLocal.setId(detallepagocheque.getId());	
					detallepagochequeLocal.setVersionRow(detallepagocheque.getVersionRow());	
					detallepagochequeLocal.setid_empresa(detallepagocheque.getid_empresa());	
					detallepagochequeLocal.setid_sucursal(detallepagocheque.getid_sucursal());	
					detallepagochequeLocal.setid_asiento_contable(detallepagocheque.getid_asiento_contable());	
					detallepagochequeLocal.setid_ejercicio(detallepagocheque.getid_ejercicio());	
					detallepagochequeLocal.setid_periodo(detallepagocheque.getid_periodo());	
					detallepagochequeLocal.setvalor(detallepagocheque.getvalor());	
					detallepagochequeLocal.setid_anio(detallepagocheque.getid_anio());	
					detallepagochequeLocal.setid_mes(detallepagocheque.getid_mes());	
					
					
					
					existe=true;
					break;
				}
			}
			
			if(!detallepagocheque.getIsDeleted()) {
				if(!existe) {
					detallepagocheques.add(detallepagocheque);
				}
			} else {
				if(detallepagochequeEncontrado!=null && permiteQuitar)  {
					detallepagocheques.remove(detallepagochequeEncontrado);
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}
	
	public static void actualizarSelectedLista(DetallePagoCheque detallepagocheque,List<DetallePagoCheque> detallepagocheques) throws Exception {
		try	{			
			for(DetallePagoCheque detallepagochequeLocal:detallepagocheques) {
				if(detallepagochequeLocal.getId().equals(detallepagocheque.getId())) {
					detallepagochequeLocal.setIsSelected(detallepagocheque.getIsSelected());					
					break;
				}
			}
		} catch(Exception e) {
			throw e;
		}
	}	
	
	public static void setEstadosInicialesDetallePagoCheque(List<DetallePagoCheque> detallepagochequesAux) throws Exception {
		//this.detallepagochequesAux=detallepagochequesAux;
		
		for(DetallePagoCheque detallepagochequeAux:detallepagochequesAux) {
			if(detallepagochequeAux.getIsChanged()) {
				detallepagochequeAux.setIsChanged(false);
			}		
			
			if(detallepagochequeAux.getIsNew()) {
				detallepagochequeAux.setIsNew(false);
			}	
			
			if(detallepagochequeAux.getIsDeleted()) {
				detallepagochequeAux.setIsDeleted(false);
			}
		}
	}
	
	public static void setEstadosInicialesDetallePagoCheque(DetallePagoCheque detallepagochequeAux) throws Exception {
		//this.detallepagochequeAux=detallepagochequeAux;
		
			if(detallepagochequeAux.getIsChanged()) {
				detallepagochequeAux.setIsChanged(false);
			}		
			
			if(detallepagochequeAux.getIsNew()) {
				detallepagochequeAux.setIsNew(false);
			}	
			
			if(detallepagochequeAux.getIsDeleted()) {
				detallepagochequeAux.setIsDeleted(false);
			}		
	}
	
	public static void seleccionarAsignar(DetallePagoCheque detallepagochequeAsignar,DetallePagoCheque detallepagocheque) throws Exception {
		detallepagochequeAsignar.setId(detallepagocheque.getId());	
		detallepagochequeAsignar.setVersionRow(detallepagocheque.getVersionRow());	
		detallepagochequeAsignar.setid_empresa(detallepagocheque.getid_empresa());
		detallepagochequeAsignar.setempresa_descripcion(detallepagocheque.getempresa_descripcion());	
		detallepagochequeAsignar.setid_sucursal(detallepagocheque.getid_sucursal());
		detallepagochequeAsignar.setsucursal_descripcion(detallepagocheque.getsucursal_descripcion());	
		detallepagochequeAsignar.setid_asiento_contable(detallepagocheque.getid_asiento_contable());
		detallepagochequeAsignar.setasientocontable_descripcion(detallepagocheque.getasientocontable_descripcion());	
		detallepagochequeAsignar.setid_ejercicio(detallepagocheque.getid_ejercicio());
		detallepagochequeAsignar.setejercicio_descripcion(detallepagocheque.getejercicio_descripcion());	
		detallepagochequeAsignar.setid_periodo(detallepagocheque.getid_periodo());
		detallepagochequeAsignar.setperiodo_descripcion(detallepagocheque.getperiodo_descripcion());	
		detallepagochequeAsignar.setvalor(detallepagocheque.getvalor());	
		detallepagochequeAsignar.setid_anio(detallepagocheque.getid_anio());
		detallepagochequeAsignar.setanio_descripcion(detallepagocheque.getanio_descripcion());	
		detallepagochequeAsignar.setid_mes(detallepagocheque.getid_mes());
		detallepagochequeAsignar.setmes_descripcion(detallepagocheque.getmes_descripcion());	
	}
	
	public static void inicializarDetallePagoCheque(DetallePagoCheque detallepagocheque) throws Exception {
		try {
				detallepagocheque.setId(0L);	
					
				detallepagocheque.setid_empresa(-1L);	
				detallepagocheque.setid_sucursal(-1L);	
				detallepagocheque.setid_asiento_contable(-1L);	
				detallepagocheque.setid_ejercicio(-1L);	
				detallepagocheque.setid_periodo(-1L);	
				detallepagocheque.setvalor(0.0);	
				detallepagocheque.setid_anio(null);	
				detallepagocheque.setid_mes(null);	
			} catch(Exception e) {
			throw e;
		}
	}
	
	public static void generarExcelReporteHeaderDetallePagoCheque(String sTipo,Row row,Workbook workbook) {
		Cell cell=null;
		int iCell=0;
		
		CellStyle cellStyle = Funciones2.getStyleTitulo(workbook,"PRINCIPAL");
		
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePagoChequeConstantesFunciones.LABEL_IDEMPRESA);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePagoChequeConstantesFunciones.LABEL_IDSUCURSAL);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePagoChequeConstantesFunciones.LABEL_IDASIENTOCONTABLE);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePagoChequeConstantesFunciones.LABEL_IDEJERCICIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePagoChequeConstantesFunciones.LABEL_IDPERIODO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePagoChequeConstantesFunciones.LABEL_VALOR);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePagoChequeConstantesFunciones.LABEL_IDANIO);
		cell.setCellStyle(cellStyle);

		cell = row.createCell(iCell++);
		cell.setCellValue(DetallePagoChequeConstantesFunciones.LABEL_IDMES);
		cell.setCellStyle(cellStyle);
	}
	
	public static void generarExcelReporteDataDetallePagoCheque(String sTipo,Row row,Workbook workbook,DetallePagoCheque detallepagocheque,CellStyle cellStyle) throws Exception {
		Cell cell=null;
		int iCell=0;
					
		if(sTipo.equals("RELACIONADO")) {
			iCell++;
		}
		
		

			cell = row.createCell(iCell++);
			cell.setCellValue(detallepagocheque.getempresa_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallepagocheque.getsucursal_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallepagocheque.getasientocontable_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallepagocheque.getejercicio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallepagocheque.getperiodo_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallepagocheque.getvalor());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallepagocheque.getanio_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}

			cell = row.createCell(iCell++);
			cell.setCellValue(detallepagocheque.getmes_descripcion());
			if(cellStyle!=null) {
				cell.setCellStyle(cellStyle);
			}
	}
	//FUNCIONES CONTROLLER
	
	
	public String sFinalQueryDetallePagoCheque=Constantes.SFINALQUERY;
	
	public String getsFinalQueryDetallePagoCheque() {
		return this.sFinalQueryDetallePagoCheque;
	}
	
	public void setsFinalQueryDetallePagoCheque(String sFinalQueryDetallePagoCheque) {
		this.sFinalQueryDetallePagoCheque= sFinalQueryDetallePagoCheque;
	}
	
	public Border resaltarSeleccionarDetallePagoCheque=null;
	
	public Border setResaltarSeleccionarDetallePagoCheque(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePagoChequeBeanSwingJInternalFrame detallepagochequeBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		
		//detallepagochequeBeanSwingJInternalFrame.jTtoolBarDetallePagoCheque.setBorder(borderResaltar);
		
		this.resaltarSeleccionarDetallePagoCheque= borderResaltar;
		
		return borderResaltar;
	}

	public Border getResaltarSeleccionarDetallePagoCheque() {
		return this.resaltarSeleccionarDetallePagoCheque;
	}
	
	public void setResaltarSeleccionarDetallePagoCheque(Border borderResaltarSeleccionarDetallePagoCheque) {
		this.resaltarSeleccionarDetallePagoCheque= borderResaltarSeleccionarDetallePagoCheque;
	}
	
	//RESALTAR,VISIBILIDAD,HABILITAR COLUMNA
	
	
	public Border resaltaridDetallePagoCheque=null;
	public Boolean mostraridDetallePagoCheque=true;
	public Boolean activaridDetallePagoCheque=true;

	public Border resaltarid_empresaDetallePagoCheque=null;
	public Boolean mostrarid_empresaDetallePagoCheque=true;
	public Boolean activarid_empresaDetallePagoCheque=true;
	public Boolean cargarid_empresaDetallePagoCheque=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_empresaDetallePagoCheque=false;//ConEventDepend=true

	public Border resaltarid_sucursalDetallePagoCheque=null;
	public Boolean mostrarid_sucursalDetallePagoCheque=true;
	public Boolean activarid_sucursalDetallePagoCheque=true;
	public Boolean cargarid_sucursalDetallePagoCheque=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_sucursalDetallePagoCheque=false;//ConEventDepend=true

	public Border resaltarid_asiento_contableDetallePagoCheque=null;
	public Boolean mostrarid_asiento_contableDetallePagoCheque=true;
	public Boolean activarid_asiento_contableDetallePagoCheque=true;
	public Boolean cargarid_asiento_contableDetallePagoCheque=false;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_asiento_contableDetallePagoCheque=false;//ConEventDepend=true

	public Border resaltarid_ejercicioDetallePagoCheque=null;
	public Boolean mostrarid_ejercicioDetallePagoCheque=true;
	public Boolean activarid_ejercicioDetallePagoCheque=true;
	public Boolean cargarid_ejercicioDetallePagoCheque=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_ejercicioDetallePagoCheque=false;//ConEventDepend=true

	public Border resaltarid_periodoDetallePagoCheque=null;
	public Boolean mostrarid_periodoDetallePagoCheque=true;
	public Boolean activarid_periodoDetallePagoCheque=true;
	public Boolean cargarid_periodoDetallePagoCheque=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_periodoDetallePagoCheque=false;//ConEventDepend=true

	public Border resaltarvalorDetallePagoCheque=null;
	public Boolean mostrarvalorDetallePagoCheque=true;
	public Boolean activarvalorDetallePagoCheque=true;

	public Border resaltarid_anioDetallePagoCheque=null;
	public Boolean mostrarid_anioDetallePagoCheque=true;
	public Boolean activarid_anioDetallePagoCheque=false;
	public Boolean cargarid_anioDetallePagoCheque=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_anioDetallePagoCheque=false;//ConEventDepend=true

	public Border resaltarid_mesDetallePagoCheque=null;
	public Boolean mostrarid_mesDetallePagoCheque=true;
	public Boolean activarid_mesDetallePagoCheque=false;
	public Boolean cargarid_mesDetallePagoCheque=true;//ConNoLoadForeignKeyColumnOTable=false
	public Boolean event_dependid_mesDetallePagoCheque=false;//ConEventDepend=true

	
	

	public Border setResaltaridDetallePagoCheque(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePagoChequeBeanSwingJInternalFrame detallepagochequeBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallepagochequeBeanSwingJInternalFrame.jTtoolBarDetallePagoCheque.setBorder(borderResaltar);
		
		this.resaltaridDetallePagoCheque= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltaridDetallePagoCheque() {
		return this.resaltaridDetallePagoCheque;
	}

	public void setResaltaridDetallePagoCheque(Border borderResaltar) {
		this.resaltaridDetallePagoCheque= borderResaltar;
	}

	public Boolean getMostraridDetallePagoCheque() {
		return this.mostraridDetallePagoCheque;
	}

	public void setMostraridDetallePagoCheque(Boolean mostraridDetallePagoCheque) {
		this.mostraridDetallePagoCheque= mostraridDetallePagoCheque;
	}

	public Boolean getActivaridDetallePagoCheque() {
		return this.activaridDetallePagoCheque;
	}

	public void setActivaridDetallePagoCheque(Boolean activaridDetallePagoCheque) {
		this.activaridDetallePagoCheque= activaridDetallePagoCheque;
	}

	public Border setResaltarid_empresaDetallePagoCheque(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePagoChequeBeanSwingJInternalFrame detallepagochequeBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallepagochequeBeanSwingJInternalFrame.jTtoolBarDetallePagoCheque.setBorder(borderResaltar);
		
		this.resaltarid_empresaDetallePagoCheque= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_empresaDetallePagoCheque() {
		return this.resaltarid_empresaDetallePagoCheque;
	}

	public void setResaltarid_empresaDetallePagoCheque(Border borderResaltar) {
		this.resaltarid_empresaDetallePagoCheque= borderResaltar;
	}

	public Boolean getMostrarid_empresaDetallePagoCheque() {
		return this.mostrarid_empresaDetallePagoCheque;
	}

	public void setMostrarid_empresaDetallePagoCheque(Boolean mostrarid_empresaDetallePagoCheque) {
		this.mostrarid_empresaDetallePagoCheque= mostrarid_empresaDetallePagoCheque;
	}

	public Boolean getActivarid_empresaDetallePagoCheque() {
		return this.activarid_empresaDetallePagoCheque;
	}

	public void setActivarid_empresaDetallePagoCheque(Boolean activarid_empresaDetallePagoCheque) {
		this.activarid_empresaDetallePagoCheque= activarid_empresaDetallePagoCheque;
	}

	public Boolean getCargarid_empresaDetallePagoCheque() {
		return this.cargarid_empresaDetallePagoCheque;
	}

	public void setCargarid_empresaDetallePagoCheque(Boolean cargarid_empresaDetallePagoCheque) {
		this.cargarid_empresaDetallePagoCheque= cargarid_empresaDetallePagoCheque;
	}

	public Border setResaltarid_sucursalDetallePagoCheque(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePagoChequeBeanSwingJInternalFrame detallepagochequeBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallepagochequeBeanSwingJInternalFrame.jTtoolBarDetallePagoCheque.setBorder(borderResaltar);
		
		this.resaltarid_sucursalDetallePagoCheque= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_sucursalDetallePagoCheque() {
		return this.resaltarid_sucursalDetallePagoCheque;
	}

	public void setResaltarid_sucursalDetallePagoCheque(Border borderResaltar) {
		this.resaltarid_sucursalDetallePagoCheque= borderResaltar;
	}

	public Boolean getMostrarid_sucursalDetallePagoCheque() {
		return this.mostrarid_sucursalDetallePagoCheque;
	}

	public void setMostrarid_sucursalDetallePagoCheque(Boolean mostrarid_sucursalDetallePagoCheque) {
		this.mostrarid_sucursalDetallePagoCheque= mostrarid_sucursalDetallePagoCheque;
	}

	public Boolean getActivarid_sucursalDetallePagoCheque() {
		return this.activarid_sucursalDetallePagoCheque;
	}

	public void setActivarid_sucursalDetallePagoCheque(Boolean activarid_sucursalDetallePagoCheque) {
		this.activarid_sucursalDetallePagoCheque= activarid_sucursalDetallePagoCheque;
	}

	public Boolean getCargarid_sucursalDetallePagoCheque() {
		return this.cargarid_sucursalDetallePagoCheque;
	}

	public void setCargarid_sucursalDetallePagoCheque(Boolean cargarid_sucursalDetallePagoCheque) {
		this.cargarid_sucursalDetallePagoCheque= cargarid_sucursalDetallePagoCheque;
	}

	public Border setResaltarid_asiento_contableDetallePagoCheque(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePagoChequeBeanSwingJInternalFrame detallepagochequeBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallepagochequeBeanSwingJInternalFrame.jTtoolBarDetallePagoCheque.setBorder(borderResaltar);
		
		this.resaltarid_asiento_contableDetallePagoCheque= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_asiento_contableDetallePagoCheque() {
		return this.resaltarid_asiento_contableDetallePagoCheque;
	}

	public void setResaltarid_asiento_contableDetallePagoCheque(Border borderResaltar) {
		this.resaltarid_asiento_contableDetallePagoCheque= borderResaltar;
	}

	public Boolean getMostrarid_asiento_contableDetallePagoCheque() {
		return this.mostrarid_asiento_contableDetallePagoCheque;
	}

	public void setMostrarid_asiento_contableDetallePagoCheque(Boolean mostrarid_asiento_contableDetallePagoCheque) {
		this.mostrarid_asiento_contableDetallePagoCheque= mostrarid_asiento_contableDetallePagoCheque;
	}

	public Boolean getActivarid_asiento_contableDetallePagoCheque() {
		return this.activarid_asiento_contableDetallePagoCheque;
	}

	public void setActivarid_asiento_contableDetallePagoCheque(Boolean activarid_asiento_contableDetallePagoCheque) {
		this.activarid_asiento_contableDetallePagoCheque= activarid_asiento_contableDetallePagoCheque;
	}

	public Boolean getCargarid_asiento_contableDetallePagoCheque() {
		return this.cargarid_asiento_contableDetallePagoCheque;
	}

	public void setCargarid_asiento_contableDetallePagoCheque(Boolean cargarid_asiento_contableDetallePagoCheque) {
		this.cargarid_asiento_contableDetallePagoCheque= cargarid_asiento_contableDetallePagoCheque;
	}

	public Border setResaltarid_ejercicioDetallePagoCheque(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePagoChequeBeanSwingJInternalFrame detallepagochequeBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallepagochequeBeanSwingJInternalFrame.jTtoolBarDetallePagoCheque.setBorder(borderResaltar);
		
		this.resaltarid_ejercicioDetallePagoCheque= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_ejercicioDetallePagoCheque() {
		return this.resaltarid_ejercicioDetallePagoCheque;
	}

	public void setResaltarid_ejercicioDetallePagoCheque(Border borderResaltar) {
		this.resaltarid_ejercicioDetallePagoCheque= borderResaltar;
	}

	public Boolean getMostrarid_ejercicioDetallePagoCheque() {
		return this.mostrarid_ejercicioDetallePagoCheque;
	}

	public void setMostrarid_ejercicioDetallePagoCheque(Boolean mostrarid_ejercicioDetallePagoCheque) {
		this.mostrarid_ejercicioDetallePagoCheque= mostrarid_ejercicioDetallePagoCheque;
	}

	public Boolean getActivarid_ejercicioDetallePagoCheque() {
		return this.activarid_ejercicioDetallePagoCheque;
	}

	public void setActivarid_ejercicioDetallePagoCheque(Boolean activarid_ejercicioDetallePagoCheque) {
		this.activarid_ejercicioDetallePagoCheque= activarid_ejercicioDetallePagoCheque;
	}

	public Boolean getCargarid_ejercicioDetallePagoCheque() {
		return this.cargarid_ejercicioDetallePagoCheque;
	}

	public void setCargarid_ejercicioDetallePagoCheque(Boolean cargarid_ejercicioDetallePagoCheque) {
		this.cargarid_ejercicioDetallePagoCheque= cargarid_ejercicioDetallePagoCheque;
	}

	public Border setResaltarid_periodoDetallePagoCheque(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePagoChequeBeanSwingJInternalFrame detallepagochequeBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallepagochequeBeanSwingJInternalFrame.jTtoolBarDetallePagoCheque.setBorder(borderResaltar);
		
		this.resaltarid_periodoDetallePagoCheque= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_periodoDetallePagoCheque() {
		return this.resaltarid_periodoDetallePagoCheque;
	}

	public void setResaltarid_periodoDetallePagoCheque(Border borderResaltar) {
		this.resaltarid_periodoDetallePagoCheque= borderResaltar;
	}

	public Boolean getMostrarid_periodoDetallePagoCheque() {
		return this.mostrarid_periodoDetallePagoCheque;
	}

	public void setMostrarid_periodoDetallePagoCheque(Boolean mostrarid_periodoDetallePagoCheque) {
		this.mostrarid_periodoDetallePagoCheque= mostrarid_periodoDetallePagoCheque;
	}

	public Boolean getActivarid_periodoDetallePagoCheque() {
		return this.activarid_periodoDetallePagoCheque;
	}

	public void setActivarid_periodoDetallePagoCheque(Boolean activarid_periodoDetallePagoCheque) {
		this.activarid_periodoDetallePagoCheque= activarid_periodoDetallePagoCheque;
	}

	public Boolean getCargarid_periodoDetallePagoCheque() {
		return this.cargarid_periodoDetallePagoCheque;
	}

	public void setCargarid_periodoDetallePagoCheque(Boolean cargarid_periodoDetallePagoCheque) {
		this.cargarid_periodoDetallePagoCheque= cargarid_periodoDetallePagoCheque;
	}

	public Border setResaltarvalorDetallePagoCheque(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePagoChequeBeanSwingJInternalFrame detallepagochequeBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallepagochequeBeanSwingJInternalFrame.jTtoolBarDetallePagoCheque.setBorder(borderResaltar);
		
		this.resaltarvalorDetallePagoCheque= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarvalorDetallePagoCheque() {
		return this.resaltarvalorDetallePagoCheque;
	}

	public void setResaltarvalorDetallePagoCheque(Border borderResaltar) {
		this.resaltarvalorDetallePagoCheque= borderResaltar;
	}

	public Boolean getMostrarvalorDetallePagoCheque() {
		return this.mostrarvalorDetallePagoCheque;
	}

	public void setMostrarvalorDetallePagoCheque(Boolean mostrarvalorDetallePagoCheque) {
		this.mostrarvalorDetallePagoCheque= mostrarvalorDetallePagoCheque;
	}

	public Boolean getActivarvalorDetallePagoCheque() {
		return this.activarvalorDetallePagoCheque;
	}

	public void setActivarvalorDetallePagoCheque(Boolean activarvalorDetallePagoCheque) {
		this.activarvalorDetallePagoCheque= activarvalorDetallePagoCheque;
	}

	public Border setResaltarid_anioDetallePagoCheque(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePagoChequeBeanSwingJInternalFrame detallepagochequeBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallepagochequeBeanSwingJInternalFrame.jTtoolBarDetallePagoCheque.setBorder(borderResaltar);
		
		this.resaltarid_anioDetallePagoCheque= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_anioDetallePagoCheque() {
		return this.resaltarid_anioDetallePagoCheque;
	}

	public void setResaltarid_anioDetallePagoCheque(Border borderResaltar) {
		this.resaltarid_anioDetallePagoCheque= borderResaltar;
	}

	public Boolean getMostrarid_anioDetallePagoCheque() {
		return this.mostrarid_anioDetallePagoCheque;
	}

	public void setMostrarid_anioDetallePagoCheque(Boolean mostrarid_anioDetallePagoCheque) {
		this.mostrarid_anioDetallePagoCheque= mostrarid_anioDetallePagoCheque;
	}

	public Boolean getActivarid_anioDetallePagoCheque() {
		return this.activarid_anioDetallePagoCheque;
	}

	public void setActivarid_anioDetallePagoCheque(Boolean activarid_anioDetallePagoCheque) {
		this.activarid_anioDetallePagoCheque= activarid_anioDetallePagoCheque;
	}

	public Boolean getCargarid_anioDetallePagoCheque() {
		return this.cargarid_anioDetallePagoCheque;
	}

	public void setCargarid_anioDetallePagoCheque(Boolean cargarid_anioDetallePagoCheque) {
		this.cargarid_anioDetallePagoCheque= cargarid_anioDetallePagoCheque;
	}

	public Border setResaltarid_mesDetallePagoCheque(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePagoChequeBeanSwingJInternalFrame detallepagochequeBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		
		//detallepagochequeBeanSwingJInternalFrame.jTtoolBarDetallePagoCheque.setBorder(borderResaltar);
		
		this.resaltarid_mesDetallePagoCheque= borderResaltar;

		return borderResaltar;
	}

	public Border getresaltarid_mesDetallePagoCheque() {
		return this.resaltarid_mesDetallePagoCheque;
	}

	public void setResaltarid_mesDetallePagoCheque(Border borderResaltar) {
		this.resaltarid_mesDetallePagoCheque= borderResaltar;
	}

	public Boolean getMostrarid_mesDetallePagoCheque() {
		return this.mostrarid_mesDetallePagoCheque;
	}

	public void setMostrarid_mesDetallePagoCheque(Boolean mostrarid_mesDetallePagoCheque) {
		this.mostrarid_mesDetallePagoCheque= mostrarid_mesDetallePagoCheque;
	}

	public Boolean getActivarid_mesDetallePagoCheque() {
		return this.activarid_mesDetallePagoCheque;
	}

	public void setActivarid_mesDetallePagoCheque(Boolean activarid_mesDetallePagoCheque) {
		this.activarid_mesDetallePagoCheque= activarid_mesDetallePagoCheque;
	}

	public Boolean getCargarid_mesDetallePagoCheque() {
		return this.cargarid_mesDetallePagoCheque;
	}

	public void setCargarid_mesDetallePagoCheque(Boolean cargarid_mesDetallePagoCheque) {
		this.cargarid_mesDetallePagoCheque= cargarid_mesDetallePagoCheque;
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
		
		
		this.setMostraridDetallePagoCheque(esInicial);
		this.setMostrarid_empresaDetallePagoCheque(esInicial);
		this.setMostrarid_sucursalDetallePagoCheque(esInicial);
		this.setMostrarid_asiento_contableDetallePagoCheque(esInicial);
		this.setMostrarid_ejercicioDetallePagoCheque(esInicial);
		this.setMostrarid_periodoDetallePagoCheque(esInicial);
		this.setMostrarvalorDetallePagoCheque(esInicial);
		this.setMostrarid_anioDetallePagoCheque(esInicial);
		this.setMostrarid_mesDetallePagoCheque(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetallePagoChequeConstantesFunciones.ID)) {
				this.setMostraridDetallePagoCheque(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePagoChequeConstantesFunciones.IDEMPRESA)) {
				this.setMostrarid_empresaDetallePagoCheque(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePagoChequeConstantesFunciones.IDSUCURSAL)) {
				this.setMostrarid_sucursalDetallePagoCheque(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePagoChequeConstantesFunciones.IDASIENTOCONTABLE)) {
				this.setMostrarid_asiento_contableDetallePagoCheque(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePagoChequeConstantesFunciones.IDEJERCICIO)) {
				this.setMostrarid_ejercicioDetallePagoCheque(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePagoChequeConstantesFunciones.IDPERIODO)) {
				this.setMostrarid_periodoDetallePagoCheque(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePagoChequeConstantesFunciones.VALOR)) {
				this.setMostrarvalorDetallePagoCheque(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePagoChequeConstantesFunciones.IDANIO)) {
				this.setMostrarid_anioDetallePagoCheque(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePagoChequeConstantesFunciones.IDMES)) {
				this.setMostrarid_mesDetallePagoCheque(esAsigna);
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
		
		
		this.setActivaridDetallePagoCheque(esInicial);
		this.setActivarid_empresaDetallePagoCheque(esInicial);
		this.setActivarid_sucursalDetallePagoCheque(esInicial);
		this.setActivarid_asiento_contableDetallePagoCheque(esInicial);
		this.setActivarid_ejercicioDetallePagoCheque(esInicial);
		this.setActivarid_periodoDetallePagoCheque(esInicial);
		this.setActivarvalorDetallePagoCheque(esInicial);
		this.setActivarid_anioDetallePagoCheque(esInicial);
		this.setActivarid_mesDetallePagoCheque(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetallePagoChequeConstantesFunciones.ID)) {
				this.setActivaridDetallePagoCheque(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePagoChequeConstantesFunciones.IDEMPRESA)) {
				this.setActivarid_empresaDetallePagoCheque(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePagoChequeConstantesFunciones.IDSUCURSAL)) {
				this.setActivarid_sucursalDetallePagoCheque(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePagoChequeConstantesFunciones.IDASIENTOCONTABLE)) {
				this.setActivarid_asiento_contableDetallePagoCheque(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePagoChequeConstantesFunciones.IDEJERCICIO)) {
				this.setActivarid_ejercicioDetallePagoCheque(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePagoChequeConstantesFunciones.IDPERIODO)) {
				this.setActivarid_periodoDetallePagoCheque(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePagoChequeConstantesFunciones.VALOR)) {
				this.setActivarvalorDetallePagoCheque(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePagoChequeConstantesFunciones.IDANIO)) {
				this.setActivarid_anioDetallePagoCheque(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePagoChequeConstantesFunciones.IDMES)) {
				this.setActivarid_mesDetallePagoCheque(esAsigna);
				continue;
			}
		}
	}
	
	public void setResaltarCampos(DeepLoadType deepLoadType,ArrayList<Classe> campos,ParametroGeneralUsuario parametroGeneralUsuario/*,DetallePagoChequeBeanSwingJInternalFrame detallepagochequeBeanSwingJInternalFrame*/)throws Exception {	
		Border esInicial=null;
		Border esAsigna=null;
			
		if(deepLoadType.equals(DeepLoadType.INCLUDE) || deepLoadType.equals(DeepLoadType.NONE)) {
			esInicial=null;
			esAsigna=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
		} else if(deepLoadType.equals(DeepLoadType.EXCLUDE)) {
			esInicial=Funciones2.getBorderResaltar(parametroGeneralUsuario,"COLUMNA");
			esAsigna=null;
		}
		
		
		this.setResaltaridDetallePagoCheque(esInicial);
		this.setResaltarid_empresaDetallePagoCheque(esInicial);
		this.setResaltarid_sucursalDetallePagoCheque(esInicial);
		this.setResaltarid_asiento_contableDetallePagoCheque(esInicial);
		this.setResaltarid_ejercicioDetallePagoCheque(esInicial);
		this.setResaltarid_periodoDetallePagoCheque(esInicial);
		this.setResaltarvalorDetallePagoCheque(esInicial);
		this.setResaltarid_anioDetallePagoCheque(esInicial);
		this.setResaltarid_mesDetallePagoCheque(esInicial);

		for(Classe campo:campos) {

			if(campo.clase.equals(DetallePagoChequeConstantesFunciones.ID)) {
				this.setResaltaridDetallePagoCheque(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePagoChequeConstantesFunciones.IDEMPRESA)) {
				this.setResaltarid_empresaDetallePagoCheque(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePagoChequeConstantesFunciones.IDSUCURSAL)) {
				this.setResaltarid_sucursalDetallePagoCheque(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePagoChequeConstantesFunciones.IDASIENTOCONTABLE)) {
				this.setResaltarid_asiento_contableDetallePagoCheque(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePagoChequeConstantesFunciones.IDEJERCICIO)) {
				this.setResaltarid_ejercicioDetallePagoCheque(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePagoChequeConstantesFunciones.IDPERIODO)) {
				this.setResaltarid_periodoDetallePagoCheque(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePagoChequeConstantesFunciones.VALOR)) {
				this.setResaltarvalorDetallePagoCheque(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePagoChequeConstantesFunciones.IDANIO)) {
				this.setResaltarid_anioDetallePagoCheque(esAsigna);
				continue;
			}

			if(campo.clase.equals(DetallePagoChequeConstantesFunciones.IDMES)) {
				this.setResaltarid_mesDetallePagoCheque(esAsigna);
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
	
	public void setResaltarRelaciones(DeepLoadType deepLoadType,ArrayList<Classe> clases,ParametroGeneralUsuario parametroGeneralUsuario/*,DetallePagoChequeBeanSwingJInternalFrame detallepagochequeBeanSwingJInternalFrame*/)throws Exception {	
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
	
	


	public Boolean mostrarFK_IdAsientoContableDetallePagoCheque=true;

	public Boolean getMostrarFK_IdAsientoContableDetallePagoCheque() {
		return this.mostrarFK_IdAsientoContableDetallePagoCheque;
	}

	public void setMostrarFK_IdAsientoContableDetallePagoCheque(Boolean visibilidadResaltar) {
		this.mostrarFK_IdAsientoContableDetallePagoCheque= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEjercicioDetallePagoCheque=true;

	public Boolean getMostrarFK_IdEjercicioDetallePagoCheque() {
		return this.mostrarFK_IdEjercicioDetallePagoCheque;
	}

	public void setMostrarFK_IdEjercicioDetallePagoCheque(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEjercicioDetallePagoCheque= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdEmpresaDetallePagoCheque=true;

	public Boolean getMostrarFK_IdEmpresaDetallePagoCheque() {
		return this.mostrarFK_IdEmpresaDetallePagoCheque;
	}

	public void setMostrarFK_IdEmpresaDetallePagoCheque(Boolean visibilidadResaltar) {
		this.mostrarFK_IdEmpresaDetallePagoCheque= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdPeriodoDetallePagoCheque=true;

	public Boolean getMostrarFK_IdPeriodoDetallePagoCheque() {
		return this.mostrarFK_IdPeriodoDetallePagoCheque;
	}

	public void setMostrarFK_IdPeriodoDetallePagoCheque(Boolean visibilidadResaltar) {
		this.mostrarFK_IdPeriodoDetallePagoCheque= visibilidadResaltar;
	}

	public Boolean mostrarFK_IdSucursalDetallePagoCheque=true;

	public Boolean getMostrarFK_IdSucursalDetallePagoCheque() {
		return this.mostrarFK_IdSucursalDetallePagoCheque;
	}

	public void setMostrarFK_IdSucursalDetallePagoCheque(Boolean visibilidadResaltar) {
		this.mostrarFK_IdSucursalDetallePagoCheque= visibilidadResaltar;
	}	
	


	public Boolean activarFK_IdAsientoContableDetallePagoCheque=true;

	public Boolean getActivarFK_IdAsientoContableDetallePagoCheque() {
		return this.activarFK_IdAsientoContableDetallePagoCheque;
	}

	public void setActivarFK_IdAsientoContableDetallePagoCheque(Boolean habilitarResaltar) {
		this.activarFK_IdAsientoContableDetallePagoCheque= habilitarResaltar;
	}

	public Boolean activarFK_IdEjercicioDetallePagoCheque=true;

	public Boolean getActivarFK_IdEjercicioDetallePagoCheque() {
		return this.activarFK_IdEjercicioDetallePagoCheque;
	}

	public void setActivarFK_IdEjercicioDetallePagoCheque(Boolean habilitarResaltar) {
		this.activarFK_IdEjercicioDetallePagoCheque= habilitarResaltar;
	}

	public Boolean activarFK_IdEmpresaDetallePagoCheque=true;

	public Boolean getActivarFK_IdEmpresaDetallePagoCheque() {
		return this.activarFK_IdEmpresaDetallePagoCheque;
	}

	public void setActivarFK_IdEmpresaDetallePagoCheque(Boolean habilitarResaltar) {
		this.activarFK_IdEmpresaDetallePagoCheque= habilitarResaltar;
	}

	public Boolean activarFK_IdPeriodoDetallePagoCheque=true;

	public Boolean getActivarFK_IdPeriodoDetallePagoCheque() {
		return this.activarFK_IdPeriodoDetallePagoCheque;
	}

	public void setActivarFK_IdPeriodoDetallePagoCheque(Boolean habilitarResaltar) {
		this.activarFK_IdPeriodoDetallePagoCheque= habilitarResaltar;
	}

	public Boolean activarFK_IdSucursalDetallePagoCheque=true;

	public Boolean getActivarFK_IdSucursalDetallePagoCheque() {
		return this.activarFK_IdSucursalDetallePagoCheque;
	}

	public void setActivarFK_IdSucursalDetallePagoCheque(Boolean habilitarResaltar) {
		this.activarFK_IdSucursalDetallePagoCheque= habilitarResaltar;
	}	
	


	public Border resaltarFK_IdAsientoContableDetallePagoCheque=null;

	public Border getResaltarFK_IdAsientoContableDetallePagoCheque() {
		return this.resaltarFK_IdAsientoContableDetallePagoCheque;
	}

	public void setResaltarFK_IdAsientoContableDetallePagoCheque(Border borderResaltar) {
		this.resaltarFK_IdAsientoContableDetallePagoCheque= borderResaltar;
	}

	public void setResaltarFK_IdAsientoContableDetallePagoCheque(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePagoChequeBeanSwingJInternalFrame detallepagochequeBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdAsientoContableDetallePagoCheque= borderResaltar;
	}

	public Border resaltarFK_IdEjercicioDetallePagoCheque=null;

	public Border getResaltarFK_IdEjercicioDetallePagoCheque() {
		return this.resaltarFK_IdEjercicioDetallePagoCheque;
	}

	public void setResaltarFK_IdEjercicioDetallePagoCheque(Border borderResaltar) {
		this.resaltarFK_IdEjercicioDetallePagoCheque= borderResaltar;
	}

	public void setResaltarFK_IdEjercicioDetallePagoCheque(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePagoChequeBeanSwingJInternalFrame detallepagochequeBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEjercicioDetallePagoCheque= borderResaltar;
	}

	public Border resaltarFK_IdEmpresaDetallePagoCheque=null;

	public Border getResaltarFK_IdEmpresaDetallePagoCheque() {
		return this.resaltarFK_IdEmpresaDetallePagoCheque;
	}

	public void setResaltarFK_IdEmpresaDetallePagoCheque(Border borderResaltar) {
		this.resaltarFK_IdEmpresaDetallePagoCheque= borderResaltar;
	}

	public void setResaltarFK_IdEmpresaDetallePagoCheque(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePagoChequeBeanSwingJInternalFrame detallepagochequeBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdEmpresaDetallePagoCheque= borderResaltar;
	}

	public Border resaltarFK_IdPeriodoDetallePagoCheque=null;

	public Border getResaltarFK_IdPeriodoDetallePagoCheque() {
		return this.resaltarFK_IdPeriodoDetallePagoCheque;
	}

	public void setResaltarFK_IdPeriodoDetallePagoCheque(Border borderResaltar) {
		this.resaltarFK_IdPeriodoDetallePagoCheque= borderResaltar;
	}

	public void setResaltarFK_IdPeriodoDetallePagoCheque(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePagoChequeBeanSwingJInternalFrame detallepagochequeBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdPeriodoDetallePagoCheque= borderResaltar;
	}

	public Border resaltarFK_IdSucursalDetallePagoCheque=null;

	public Border getResaltarFK_IdSucursalDetallePagoCheque() {
		return this.resaltarFK_IdSucursalDetallePagoCheque;
	}

	public void setResaltarFK_IdSucursalDetallePagoCheque(Border borderResaltar) {
		this.resaltarFK_IdSucursalDetallePagoCheque= borderResaltar;
	}

	public void setResaltarFK_IdSucursalDetallePagoCheque(ParametroGeneralUsuario parametroGeneralUsuario/*DetallePagoChequeBeanSwingJInternalFrame detallepagochequeBeanSwingJInternalFrame*/) {
		Border borderResaltar=Funciones2.getBorderResaltar(parametroGeneralUsuario,"TAB");
		this.resaltarFK_IdSucursalDetallePagoCheque= borderResaltar;
	}		
	
	//CONTROL_FUNCION2
}